var purchaseList = null;
var odatatable = null;

function showNewPurchaseDiv(){
	$('#purchaseSummaryListDiv').hide(500);
	$('#newPurchaseDiv').show(500);
	
	populateItemStockTable();
}

function showPurchaseList(){
	$('#newPurchaseDiv').hide(500);
	$('#purchaseSummaryListDiv').show(500);
	purchaseSummaryList();
	
}

function findInvoiceNumber(){
	PurchaseServices.findInvoiceNumber(function(p){
		$('#invoiceNumber').html(p);
	});
		
}

function purchaseSummaryList(){
	
	$('#purchaseSummaryDiv').html('');
	$('<table id="purchaseSummaryTable" class="display master"></table>').appendTo('#purchaseSummaryDiv')
	
	PurchaseServices.findPurchaseSummaryList(function(p){
		var purchaseSummary = JSON.parse(p);
		odatatable = $('#purchaseSummaryTable').dataTable( {
	    	"data": purchaseSummary,
	    	"language": {
	            "emptyTable":"No Items Added"
	        },
	        "columns": [
	            {"title":"DATE", "data": "invoiceDate" },
	            {"title":"INVOICE NUMBER", "data": "invoiceNumber" },
	            {"title":"TOTAL PARTICULAR", "data": "totalParticular" },
	            {"title":"TOTAL NET PRICE", "data": "netPrice" },
	            {"title":"TOTAL DISCOUNT", "data": "discount" },
	            {"title":"TOTAL SALE", "data": "totalSale" },
	            {"title":"ACTION", "data": "actionBtn" }
	        ]
	    } );
	});
}

function viewDetails(invoiceNumber){
	
	PurchaseServices.findPurchaseTransactionListByInvoice(invoiceNumber , function(p){
		
		$('#purchaseTransactionModalList').html('');
		$('<table id="purchaseTransactionModalTable" class="display master"></table>').appendTo('#purchaseTransactionModalList')
		
		
			var purchaseTrans = JSON.parse(p);
			odatatable = $('#purchaseTransactionModalTable').dataTable( {
		    	"data": purchaseTrans,
		    	"language": {
		            "emptyTable":"No Items Added"
		        },
		        "columns": [
		            {"title":"ITEM", "data": "itemName" },
		            {"title":"QUANTITY", "data": "quantity" },
		            {"title":"UOM", "data": "uom" },
		            {"title":"UNIT PRICE", "data": "unitPrice" },
		            {"title":"NET PRICE", "data": "netPrice" }
		        ]
		        
		        
		        
		        
		    } );
		
		
		$('#purchaseTransactionModalLabel').html(invoiceNumber);
		
		$('#purchaseTransactionModal').modal('show');
		
	});
	
	
	
}






function savePurchase(saveAction){
	var purchase = new Array();
	
	$('#purchaseTrasactionTable > tbody > tr').each(function(index , obj){
		
		var purchaseDetail = new Array();
		
		$(obj).find('td').each(function(i , td){
			purchaseDetail.push(td.innerHTML);	
		});
		
		purchase.push( purchaseDetail );
		
		
	});
	
	var purchaseSummary = new Array();

	purchaseSummary.push( $('#totalParticulars').val() );
	purchaseSummary.push( $('#totalPrice').val() );
	purchaseSummary.push( $('#totalDiscount').val() );
	purchaseSummary.push( $('#totalNetPrice').val() );
	
	PurchaseServices.savePurchase(purchase, purchaseSummary , $('#invoiceNumber').html() , function(p){

		$('#totalParticulars').val( 0 );
		$('#totalPrice').val( 0.00 );
		$('#totalNetPrice').val( 0.00 );
		$('#totalDiscount').val( 0.00 );
		
		cleanFields();
		purchaseList = null;
		populatePurchaseTrasactionTable();
		populateItemStockTable();
		findInvoiceNumber();
		
		if(saveAction == 'SAVEANDPRINT'){
			//open popup
			window.open("/tradelantern/web-application/pages/jsp/popups/printpurchasebill.jsp","PurchaseBillPrint",'height=450,width=600,scrollbars=yes');
			
		}else if (saveAction == 'SAVEANDNEW'){
			//make sure every thing is cleaned
			
		}else if (saveAction == 'SAVE'){
			//go to list page
			showPurchaseList();
			
		}
		
		
	});
	
	
	
}

function addItemToGrid(){
	
	if( $('#itemCode').val() ==null || $('#itemCode').val() == '' ){
		alert("Item Code Cannot be blank");
		$('#itemCode').focus();	
		return;
	}else if( $('#itemName').val() ==null || $('#itemName').val() == '' ){
		alert("Item Name Cannot be blank");
		$('#itemName').focus();	
		return;
	}else if( $('#quantity').val() ==null || $('#quantity').val() == '' ){
		alert("Quantity Cannot be blank");
		$('#quantity').focus();	
		return;
	}else if( $('#uom').val() ==null || $('#uom').val() == '' ){
		alert("UOM Cannot be blank");
		$('#uom').focus();	
		return;
	}else if( $('#purchasePrice').val() ==null || $('#purchasePrice').val() == '' ){
		alert("Price Cannot be blank");
		$('#purchasePrice').focus();	
		return;
	}
	
	if( purchaseList == null){
		purchaseList = new Array();
	}
	
	
	var purchaseTransaction = {
			
			"itemCode":$('#itemCode').val(),
			"itemName":$('#itemName').val(),
			"quantity":$('#quantity').val(),
			"uom":$('#uom').val(),
			"purchasePrice":$('#purchasePrice').val(),
			"defaultPrice":$('#purchasePrice').val(),
			"netPrice": Number($('#quantity').val()) * Number($('#purchasePrice').val())
		
	}
	
	purchaseList.push( purchaseTransaction );
	populatePurchaseTrasactionTable() ;
	
	$('#totalParticulars').val( purchaseList.length );
	$('#totalPrice').val( Number($('#totalPrice').val()) + Number(purchaseTransaction.netPrice) );
	$('#totalNetPrice').val( Number($('#totalPrice').val()) - Number($('#totalDiscount').val()) );
	
	cleanFields();	
}


function updatePriceForDiscount(){
	$('#totalNetPrice').val( Number($('#totalPrice').val()) - Number($('#totalDiscount').val()) );
}


/*"scrollY":        "200px",
"scrollCollapse": true,
"paging":         false
"order": [[ 1, 'asc' ]]
*/
function populatePurchaseTrasactionTable() {
	
	$('#purchaseTrasactionDiv').html('');
	$('<table style="width: 100%" id="purchaseTrasactionTable"></table>').appendTo('#purchaseTrasactionDiv')
	
	
	odatatable = $('#purchaseTrasactionTable').dataTable( {
    	"data": purchaseList,
    	"scrollY": "300px",
    	
    	"paging": false,
    	"searching": false,
    	"info": false,
    	"language": {
            "emptyTable":"No Items Added"
        },
        "columns": [
            {"title":"ITEM CODE", "data": "itemCode" },
            {"title":"PARTICULAR", "data": "itemName" },
            {"title":"QUANTITY", "data": "quantity" },
            {"title":"UOM", "data": "uom" },
            {"title":"UNIT PRICE", "data": "purchasePrice" },
            {"title":"NET PRICE", "data": "netPrice" }
        ]
    } );
}

function populateItemStockTable(){
	
	
	
	PurchaseServices.findItemList(function(p){
			
			$('#stockDiv').html('<table id="stockTable" class="display master"></table>');
			
			    $('#stockTable').dataTable( {
			        "data": JSON.parse(p),
			        "scrollY": "450px",
			        "paging": false,
			        "info": false,
			        "language": {
			            "emptyTable":"No Items Added"
			        },
			        "columns": [
			            { "title": "CODE" },
			            { "title": "ITEM" },
			            { "title": "AVAILABLE" },
			            { "title": "UOM"},
			            { "title": "DEFAULT PRICE" }
			        ]
			        
			       
			    } );   
			    
			    $('#stockTable > tbody > tr').click( function () {
					  $('#itemCode').val( $(this).find('td')[0].innerHTML  );
					  $('#itemName').val( $(this).find('td')[1].innerHTML  );
					  $('#uom').val( $(this).find('td')[3].innerHTML  );
					  $('#quantity').focus();				  
				} );
			
	});
	
	
	findInvoiceNumber();
}



function cleanFields(){
	$('#itemCode').val( '' );
	$('#itemName').val( ''  );
	$('#uom').val( ''  );
	$('#quantity').val( '' );
	$('#purchasePrice').val( '' );
	$('#defaultPrice').val( '' );
}