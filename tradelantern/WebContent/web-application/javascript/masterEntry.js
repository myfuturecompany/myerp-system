function saveLocation(){
	
	var location = {
			
			"systemId" : $('#systemId').val(),
			"locationName" : $('#locationName').val(),
			"address" : $('#address').val(),
			"city" : $('#city').val(),
			"state" : $('#state').val(),
			"country" : $('#country').val(),
			"zip" : $('#zip').val()
			
	}
	
	MasterServices.saveNewLocation(location, function(p){
		populateLocationMaster();
		$('#myModal').modal('hide');
	});
	
}

function saveItem(){
	
	var item = {
			
			"itemCode" : $('#itemCode').val(),
			"itemName" : $('#itemName').val(),
			"uom" : $('#uom').val()
			
	}
	
	MasterServices.saveNewItem(item, function(p){
		populateItemMaster();
		$('#itemModal').modal('hide');
	});
	
}




function populateLocationMaster(){
	
	MasterServices.findAllLocation(function(p){
		
		$('#locationMasterDiv').html('<table id="locationMasterTable" class="display master"></table>');
		
		    $('#locationMasterTable').dataTable( {
		        "data": JSON.parse(p),
		        "columns": [
		            { "title": "ID" },
		            { "title": "SYSTEM ID" },
		            { "title": "NAME" },
		            { "title": "ADDRESS"},
		            { "title": "CITY" },
		            { "title": "STATE" },
		            { "title": "COUNTRY" },
		            { "title": "ZIP" },
		            { "title": "STATUS" }
		        ]
		        
		       
		    } );   
		
	});
	
	
}

function populateRoleMaster(){
	
	MasterServices.findAllRoles(function(p){
		
	    $('#roleMasterTable').dataTable( {
	        "data": JSON.parse(p),
	        "columns": [
	            { "title": "ID" },
	            { "title": "MENU" },
	            { "title": "STATUS" }
	           
	        ]
	    } );   
	
	});
	
	
}


function populateCustomerMaster(){
	
	MasterServices.findAllCustomers(function(p){
		
		    $('#customerMasterTable').dataTable( {
		        "data": JSON.parse(p),
		        "columns": [
		            { "title": "ID" },
		            { "title": "NAME" },
		            { "title": "CONTACT NUMBER" },
		            { "title": "EMAIL"},
		            { "title": "ADDRESS" },
		            { "title": "STATUS" }
		           
		        ]
		    } );   
		
	});
	
	
}


function populateItemMaster(){
	
	MasterServices.findAllItems(function(p){
		$('#itemMasterDiv').html('<table id="itemMasterTable" class="display master"></table>');
		
		    $('#itemMasterTable').dataTable( {
		        "data": JSON.parse(p),
		        "columns": [
		            { "title": "ID" },
		            { "title": "BARCODE" },
		            { "title": "ITEM CODE" },
		            { "title": "NAME"},
		            { "title": "UOM" },
		            { "title": "STATUS" }
		           
		        ]
		    } );   
		
	});
	
	
}