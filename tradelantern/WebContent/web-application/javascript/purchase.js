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
	
}

function findInvoiceNumber(){
	PurchaseServices.findInvoiceNumber(function(p){
		$('#invoiceNumber').html(p);
	});
		
}

function savePurchase(){
	var purchase = new Array();
	
	$('#purchaseTrasactionTable > tbody > tr').each(function(index , obj){
		
		var purchaseDetail = new Array();
		
		$(obj).find('td').each(function(i , td){
			purchaseDetail.push(td.innerHTML);	
		});
		
		purchase.push( purchaseDetail );
		
		
	});
	
	alert( purchase );
	
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