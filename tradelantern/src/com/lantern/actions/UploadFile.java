package com.lantern.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.lantern.beans.ItemMaster;
import com.lantern.impls.FindImpl;
import com.lantern.impls.SaveImpl;
import com.lantern.utils.Status.ITEM;
import com.opensymphony.xwork2.ActionSupport;

public class UploadFile extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private File myFile;
	private String myFileContentType;
	private String myFileFileName;
	private String destPath;
	
	private String message;

	private ArrayList<String> addedItem;
	private ArrayList<String> updatedItem;
	private ArrayList<String> failedItem;
	
	private int addedItemCount;
	private int updatedItemCount;
	private int failedItemCount;
	
	public String uploadFile(){

		/* Copy file to a safe location */
		File destFile;

		int itemIdIndex = 0, itemCodeIndex = 0, itemNameIndex = 0, itemDescriptionIndex = 0, itemUomIndex = 0, itemStockIndex = 0, itemPurchaseIndex = 0 , itemSellIndex = 0;
		addedItem = new ArrayList<String>();
		updatedItem = new ArrayList<String>();
		failedItem = new ArrayList<String>();

		try{

			HttpServletRequest request = ServletActionContext.getRequest();
			destPath = request.getSession().getServletContext().getRealPath(".") +"/uploadedFile/";
			destFile  = new File(destPath, myFileFileName);
			FileUtils.copyFile(myFile, destFile);
			System.out.println(destFile.getAbsolutePath());

			ItemMaster item = null;

			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(myFile));

			// Get first sheet from the workbook
			XSSFSheet sheet = wb.getSheetAt(0);

			Row row;
			Cell cell;

			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();

			if(rowIterator.hasNext()){

				row = rowIterator.next();

				Iterator<Cell> cellIterator = row.cellIterator();
				int index = 0;
				while (cellIterator.hasNext()) 
				{
					cell = cellIterator.next();

					Object value = getCellValue(cell);
					if("ITEM ID".equalsIgnoreCase(value.toString())){
						itemIdIndex = index;
					}else if("ITEM CODE".equalsIgnoreCase(value.toString())){
						itemCodeIndex = index;
					}else if("NAME OF COMPONENT".equalsIgnoreCase(value.toString())){
						itemNameIndex = index;
					}else if("DESCRIPTION".equalsIgnoreCase(value.toString())){
						itemDescriptionIndex = index;
					}else if("UOM".equalsIgnoreCase(value.toString())){
						itemUomIndex = index;
					}else if("STOCK QUANTITY".equalsIgnoreCase(value.toString())){
						itemStockIndex = index;
					}else if("PURCHASE PRICE".equalsIgnoreCase(value.toString())){
						itemPurchaseIndex = index;
					}else if("SELL PRICE".equalsIgnoreCase(value.toString())){
						itemSellIndex = index;
					}
					
					index++;

				}
			}

			SaveImpl impl = new SaveImpl();
			FindImpl findImpl = new FindImpl();
			String itemName = null;
			Integer itemId = null;
			String uuid = null;
			while (rowIterator.hasNext()) 
			{
				row = rowIterator.next();
				itemName = "ROW ID : "+row.getRowNum();
				try {
					
					if(getCellValue(row.getCell(itemDescriptionIndex)) != null)
						itemName = getCellValue(row.getCell(itemNameIndex)).toString() +" : "+ getCellValue(row.getCell(itemDescriptionIndex)).toString();
					else
						itemName = getCellValue(row.getCell(itemNameIndex)).toString();
					
						
					try {
						itemId =  Integer.parseInt((String) getCellValue(row.getCell(itemIdIndex)));
					} catch (Exception e) {
						itemId = null;
					}
					
					uuid = UUID.randomUUID().toString();
					if(itemId == null || itemId == 0){
						
						String itemCode = getCellValue(row.getCell(itemCodeIndex)).toString();
						if(itemCode == null || "".equalsIgnoreCase(itemCode)){
							itemCode = uuid.substring( uuid.length() - 4 );
						}
						
						
						String itemStockValue = getCellValue(row.getCell(itemStockIndex)).toString();
						if(itemStockValue == null || "".equalsIgnoreCase(itemStockValue)){
							itemStockValue = "0";
						}
						
						String itemPurchaseValue = getCellValue(row.getCell(itemPurchaseIndex)).toString();
						if(itemPurchaseValue == null || "".equalsIgnoreCase(itemPurchaseValue)){
							itemPurchaseValue = "0";
						}
						
						String itemSellValue = getCellValue(row.getCell(itemSellIndex)).toString();
						if(itemSellValue == null || "".equalsIgnoreCase(itemSellValue)){
							itemSellValue = "0";
						}
						
						Object[] params = {
								itemId , 
								itemName.substring(0, 1) + new Date().getTime() + itemCode.charAt(0) ,
								itemCode,
								getCellValue(row.getCell(itemNameIndex)).toString() +" : "+ getCellValue(row.getCell(itemDescriptionIndex)).toString(),
								getCellValue(row.getCell(itemUomIndex)).toString(),
								new BigDecimal(itemStockValue),
								new BigDecimal(itemPurchaseValue),
								new BigDecimal(itemSellValue),
								2
						};
						
						
						
						String spName = "CALL INS_ITEM_DETAILS( ?,?,?,?,?,?,?,?,? )";
						String result = impl.executeSP(spName , params);

						if(SaveImpl.SUCCESS.equalsIgnoreCase(result)){
							System.out.println(itemName+" : Successfully added to system");
							addedItem.add(itemName);
						}else{
							System.out.println(itemName+" : Failed to add item to system");
							failedItem.add(itemName);
						}
						
						item = null;

					} else {
						//UPDATE ITEM
						
						
						
						String itemCode = getCellValue(row.getCell(itemCodeIndex)).toString();
						if("".equalsIgnoreCase(itemCode)){
							itemCode = null;
						}
						
						Object[] params = {
								itemId , 
								itemName.substring(0, 1) + new Date().getTime() + item.getItemCode().charAt(0) ,
								itemCode,
								getCellValue(row.getCell(itemNameIndex)).toString() +" : "+ getCellValue(row.getCell(itemDescriptionIndex)).toString(),
								getCellValue(row.getCell(itemUomIndex)).toString(),
								new BigDecimal(getCellValue(row.getCell(itemStockIndex)).toString()),
								new BigDecimal(getCellValue(row.getCell(itemPurchaseIndex)).toString()),
								new BigDecimal(getCellValue(row.getCell(itemSellIndex)).toString()),
								2
						};
						
						
						
						String spName = "CALL INS_ITEM_DETAILS( ?,?,?,?,?,?,?,?,? )";
						String result = impl.executeSP(spName , params);

						if(SaveImpl.SUCCESS.equalsIgnoreCase(result)){
							System.out.println(itemName+" : Successfully added to system");
							updatedItem.add(itemName);
						}else{
							System.out.println(itemName+" : Failed to add item to system");
							failedItem.add(itemName);
						}
						
						item = null;
					}
					
				} catch (Exception e) {
					failedItem.add(itemName +" : "+e.getMessage());
				}
				


			}
			
			addedItemCount = addedItem.size();
			updatedItemCount = updatedItem.size();
			failedItemCount = failedItem.size();
			
			System.out.println("Total number of item added : "+addedItemCount);
			System.out.println("Total number of item updated : "+updatedItemCount);
			System.out.println("Total number of item failed to add/update : "+failedItemCount);
			
			System.out.println("**************************************NEW ITEMS*******************************************************");
			
			for (String fItem : addedItem) {
				System.out.println(fItem);
			}
			
			System.out.println("*****************************************END*************************************************************");
			
            System.out.println("**************************************UPDATED ITEMS*******************************************************");
			
			for (String fItem : updatedItem) {
				System.out.println(fItem);
			}
			
			System.out.println("*****************************************END*************************************************************");
			
			System.out.println("**************************************FAILED ITEMS*******************************************************");
			
			for (String fItem : failedItem) {
				System.out.println(fItem);
			}
			
			System.out.println("*****************************************END*************************************************************");
			

		}catch(IOException e){
			e.printStackTrace();
		}
		
		message = "Successfully Uploaded Items !!!";
		
		return "fileUploaded";
	}


	private Object getCellValue(Cell cell){
		
		if(cell == null){
			return null;
		}
		
		
		switch (cell.getCellType()) 
		{

		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue();

		case Cell.CELL_TYPE_NUMERIC:
			return cell.getNumericCellValue();

		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();

		case Cell.CELL_TYPE_BLANK:
			return "";

		}
		return null;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public String getDestPath() {
		return destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public ArrayList<String> getAddedItem() {
		return addedItem;
	}


	public void setAddedItem(ArrayList<String> addedItem) {
		this.addedItem = addedItem;
	}


	public ArrayList<String> getUpdatedItem() {
		return updatedItem;
	}


	public void setUpdatedItem(ArrayList<String> updatedItem) {
		this.updatedItem = updatedItem;
	}


	public ArrayList<String> getFailedItem() {
		return failedItem;
	}


	public void setFailedItem(ArrayList<String> failedItem) {
		this.failedItem = failedItem;
	}


	public int getAddedItemCount() {
		return addedItemCount;
	}


	public void setAddedItemCount(int addedItemCount) {
		this.addedItemCount = addedItemCount;
	}


	public int getUpdatedItemCount() {
		return updatedItemCount;
	}


	public void setUpdatedItemCount(int updatedItemCount) {
		this.updatedItemCount = updatedItemCount;
	}


	public int getFailedItemCount() {
		return failedItemCount;
	}


	public void setFailedItemCount(int failedItemCount) {
		this.failedItemCount = failedItemCount;
	}


}
