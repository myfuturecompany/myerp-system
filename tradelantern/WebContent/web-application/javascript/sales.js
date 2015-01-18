var sellList = null;
var odatatable = null;

function showNewSellDiv(){
	$('#sellSummaryListDiv').hide(500);
	$('#newSellDiv').show(500);
	
	populateItemStockTable();
}

function showSellList(){
	$('#newSellDiv').hide(500);
	$('#sellSummaryListDiv').show(500);
	
}

function findInvoiceNumber(){
	SalesServices.findInvoiceNumber(function(p){
		$('#invoiceNumber').html(p);
	});
		
}

function saveSell(saveAction){
	var sell = new Array();
	
	$('#sellTrasactionTable > tbody > tr').each(function(index , obj){
		
		var sellDetail = new Array();
		
		$(obj).find('td').each(function(i , td){
			sellDetail.push(td.innerHTML);	
		});
		
		sell.push( sellDetail );
		
		
	});
	
	var sellSummary = new Array();

	sellSummary.push( $('#totalParticulars').val() );
	sellSummary.push( $('#totalPrice').val() );
	sellSummary.push( $('#totalDiscount').val() );
	sellSummary.push( $('#totalNetPrice').val() );
	
	SalesServices.saveSell(sell, sellSummary , $('#invoiceNumber').html() , function(p){

		$('#totalParticulars').val( 0 );
		$('#totalPrice').val( 0.00 );
		$('#totalNetPrice').val( 0.00 );
		$('#totalDiscount').val( 0.00 );
		
		cleanFields();
		sellList = null;
		populateSellTrasactionTable();
		populateItemStockTable();
		findInvoiceNumber();
		
		if(saveAction == 'SAVEANDPRINT'){
			//open popup
			window.open("/tradelantern/web-application/pages/jsp/popups/printsellbill.jsp","SellBillPrint",'height=450,width=600,scrollbars=yes');
			
		}else if (saveAction == 'SAVEANDNEW'){
			//make sure every thing is cleaned
			
		}else if (saveAction == 'SAVE'){
			//go to list page
			showSellList();
			
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
	}else if( $('#sellPrice').val() ==null || $('#sellPrice').val() == '' ){
		alert("Price Cannot be blank");
		$('#sellPrice').focus();	
		return;
	}
	
	if( sellList == null){
		sellList = new Array();
	}
	
	
	var sellTransaction = {
			
			"itemCode":$('#itemCode').val(),
			"itemName":$('#itemName').val(),
			"quantity":$('#quantity').val(),
			"uom":$('#uom').val(),
			"sellPrice":$('#sellPrice').val(),
			"defaultPrice":$('#sellPrice').val(),
			"netPrice": Number($('#quantity').val()) * Number($('#sellPrice').val())
		
	}
	
	sellList.push( sellTransaction );
	populateSellTrasactionTable() ;
	
	$('#totalParticulars').val( sellList.length );
	$('#totalPrice').val( Number($('#totalPrice').val()) + Number(sellTransaction.netPrice) );
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
function populateSellTrasactionTable() {
	
	$('#sellTrasactionDiv').html('');
	$('<table style="width: 100%" id="sellTrasactionTable"></table>').appendTo('#sellTrasactionDiv')
	
	
	odatatable = $('#sellTrasactionTable').dataTable( {
    	"data": sellList,
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
            {"title":"UNIT PRICE", "data": "sellPrice" },
            {"title":"NET PRICE", "data": "netPrice" }
        ]
    } );
}

function populateItemStockTable(){
	
	
	
	SalesServices.findItemList(function(p){
			
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
	$('#sellPrice').val( '' );
	$('#defaultPrice').val( '' );
}