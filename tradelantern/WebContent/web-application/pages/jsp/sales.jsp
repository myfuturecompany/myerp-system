<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style type="text/css">
.dataTables_scrollHeadInner {
	width: 100% !important ;
}

.dataTable {
	width: 100% !important ;
}

</style>

</head>
<body onload="populateItemStockTable();populateSellTrasactionTable()"> 
<jsp:include page="header.jsp"></jsp:include>

<script src="<%=request.getContextPath() %>/web-application/javascript/sales.js"	type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/dwr/interface/SalesServices.js"	type="text/javascript"></script>

<!-- <div style="text-align: center;" class="alert alert-primary">PURCHASE BILL</div> -->

<div id="sellSummaryListDiv" style="display: none;">
	<br>
	<button type="button" class="btn btn-primary btn-sm" style="float: right; width: 10%;" onclick="showNewSellDiv()">
		NEW SALE
	</button>    
   	<br><br>

    <div id="sellSummaryDiv"></div>

</div>

<div id="newSellDiv"  align="center">
<br>

<span id="invoiceNumber" style="float: left;"></span>

<br>

<table border="1" style="width: 100%; height: 400px;"> 
	<tr> 
		<td align="center" valign="top">
		
		
		
			<div id="sellTrasactionDiv">
				
			</div>
			<br>
			
			<table style="width: 100%">
				<tr>
					<th style="text-align: center;">TOTAL PARTICULAR</th>
					<th style="text-align: center;">TOTAL PRICE</th>
					<th style="text-align: center;">DISCOUNT</th>
					<th style="text-align: center;">NET PRICE</th>
				</tr>
				<tr>
					<td>
						<div class="input-group" style="width: 100%;">
							<input readonly="readonly" id="totalParticulars" value=0 type="text" class="form-control" style="height: 40px; font-size: 20px;  text-align: right;"/>
							<span class="input-group-addon">Nos</span>
						</div>
					</td>
					<td>
						<div class="input-group" style="width: 100%;">
							<input readonly="readonly" id="totalPrice" value=0.00 type="text" class="form-control" style="height: 40px; font-size: 20px;  text-align: right;"/>
							<span class="input-group-addon">INR</span>
						</div>
					</td>
					<td>
						<div class="input-group" style="width: 100%;">
							<input id="totalDiscount" value=0.00 onkeyup="updatePriceForDiscount()" type="text" class="form-control" style="height: 40px; font-size: 20px;  text-align: right;"/>
							<span class="input-group-addon">INR</span>
						</div>
					</td>
					<td>
						<div class="input-group" style="width: 100%;">
							<input readonly="readonly" id="totalNetPrice" value=0.00 type="text" class="form-control" style="height: 40px; font-size: 20px;  text-align: right;"/>
							<span class="input-group-addon">INR</span>
						</div>
					</td>
				</tr>
			</table>
			
			
			
			<br><br>
			
			<button type="button" class="btn btn-danger btn-sm" style=" width: 24%;" onclick="showSellList()">
				CANCEL
			</button>  
			<button type="button" class="btn btn-primary btn-sm" style=" width: 24%;" onclick="saveSell('SAVEANDPRINT')">
				SAVE & PRINT
			</button>
			<button type="button" class="btn btn-primary btn-sm" style=" width: 24%;" onclick="saveSell('SAVEANDNEW')">
				SAVE & CREATE NEW
			</button>  
			<button type="button" class="btn btn-primary btn-sm" style=" width: 24%;" onclick="saveSell('SAVE')">
				SAVE
			</button> 
		</td>
			
		<td width="25%" valign="top">
			<div id='stockDiv'>
				<table id="stockTable" border="1" style="width: 100%;">
				</table>
			</div>
		</td>		
			
			
		<td width="25%" valign="top" align="center">
			
			<input type="text" disabled="disabled" value="ITEM CODE" style="width: 45%; height: 20px; font-size: 12px; text-align: center; font-weight: bold;"/>
			<input type="text" disabled="disabled" value="ITEM" style="width: 45%; height: 20px; font-size: 12px; text-align: center; font-weight: bold;"/>
			<br>
			<input type="text" id="itemCode"  readonly="readonly" placeholder="ITEM CODE" style="width: 45%; height: 60px; font-size: 25px;"/>
			<input type="text" id="itemName"  readonly="readonly" placeholder="ITEM" style="width: 45%; height: 60px; font-size: 25px;"/>
			<br><br>
			<input type="text" disabled="disabled" value="QUANTITY" style="width: 45%; height: 20px; font-size: 12px; text-align: center; font-weight: bold;"/>
			<input type="text" disabled="disabled" value="UOM" style="width: 45%; height: 20px; font-size: 12px; text-align: center; font-weight: bold;"/>
			<br>
			<input type="text" id="quantity"  placeholder="QUANTITY" tabindex="2" style="width: 45%; height: 60px; font-size: 25px;"/>
			<input type="text" id="uom"  readonly="readonly" placeholder="UOM" style="width: 45%; height: 60px; font-size: 25px;"/>
			<br><br>
			<input type="text" disabled="disabled" value="PRICE" style="width: 45%; height: 20px; font-size: 12px; text-align: center; font-weight: bold;"/>
			<input type="text" disabled="disabled" value="DEFAULT PRICE" style="width: 45%; height: 20px; font-size: 12px; text-align: center; font-weight: bold;"/>
			<br>
			<input type="text" id="sellPrice"  placeholder="PRICE" tabindex="3" style="width: 45%; height: 60px; font-size: 25px;"/>
			<input type="text" id="defaultPrice"  readonly="readonly" placeholder="D PRICE" style="width: 45%; height: 60px; font-size: 25px;"/>
			<br><br>
			<button class="btn btn-success" tabindex="4" style="width: 45%; height: 60px; font-size: 25px;" onclick="addItemToGrid()">ADD ITEM</button>
			<button class="btn btn-danger" style="width: 45%; height: 60px; font-size: 25px;">CLEAR ALL</button>
			
		</td>
		
	</tr> 
</table>
	
	
	
	
	
</div>



<!-- <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#sellTransactionModal" >Show Details</button>
 -->
<div class="modal fade" id="sellTransactionModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					
					<h4 class="modal-title" id="sellTransactionModalLabel">INVOICE NO</h4>
				</div>
				
				<div class="modal-body" id="sellTransactionModalList">

					
					
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>
				</div>
			</div>
	</div>
</div>

</body>
</html>