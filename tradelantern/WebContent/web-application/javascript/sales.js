var purchaseList = null;
var odatatable = null;

function showNewPurchaseDiv(){
	$('#purchaseSummaryListDiv').hide(500);
	$('#newPurchaseDiv').show(500);
	
	populatePurchaseTrasactionTable();
}

function showPurchaseList(){
	$('#newPurchaseDiv').hide(500);
	$('#purchaseSummaryListDiv').show(500);
	
}




function addItemToGrid(){
	
	if( $('#itemCode').val() ==null || $('#itemCode').val() == '' ){
		alert("Item Code Cannot be blank");
		return;
	}else if( $('#itemName').val() ==null || $('#itemName').val() == '' ){
		alert("Item Name Cannot be blank");
		return;
	}else if( $('#quantity').val() ==null || $('#quantity').val() == '' ){
		alert("Quantity Cannot be blank");
		return;
	}else if( $('#uom').val() ==null || $('#uom').val() == '' ){
		alert("UOM Cannot be blank");
		return;
	}else if( $('#purchasePrice').val() ==null || $('#purchasePrice').val() == '' ){
		alert("Price Cannot be blank");
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
}


function updatePriceForDiscount(){
	
	
	
	
	
	
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

