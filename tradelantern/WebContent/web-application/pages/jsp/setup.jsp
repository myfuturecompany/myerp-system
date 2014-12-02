<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div role="tabpanel">

  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
	<li role="presentation" class="active"><a href="#role" aria-controls="role" role="tab" data-toggle="tab">Role</a></li>
    <li role="presentation"><a href="#location" aria-controls="location" role="tab" data-toggle="tab">Location</a></li>
    <li role="presentation"><a href="#item" aria-controls="item" role="tab" data-toggle="tab">Item</a></li>
    <li role="presentation"><a href="#customer" aria-controls="messages" role="customer" data-toggle="tab">Customer</a></li>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="role">ROLES</div>
    
    
    <!-- LOCATION -->
    <div role="tabpanel" class="tab-pane" id="location">
		<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">
		<span class="glyphicon glyphicon-user"></span>NEW LOCATION
	</button>

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					
					<h4 class="modal-title" id="myModalLabel">LOCATION</h4>
				</div>
				
				<div class="modal-body">

					<table border="0" style="height: 450px;">
						
						<tr>
							<td>SYSTEM ID</td>
							<td>
								<div class="col-lg-12">
									<div class="input-group">
										<input id="systemId" name="systemId" type="text" class="form-control" style="width: 400px;">
										<span class="input-group-addon glyphicon glyphicon-ok"> </span>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td>LOCATION NAME</td>
							<td>
								<div class="col-lg-12">
									<div class="input-group">
										<input id="locationName" name="locationName" type="text" class="form-control" style="width: 400px;">
										<span class="input-group-addon glyphicon glyphicon glyphicon-remove"> </span>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td>ADDRESS</td>
							<td>
								<div class="col-lg-12">
									<div class="input-group">
										<textarea id="address" name="address" class="form-control" style="width: 400px; height: 100px;"></textarea>
										<span class="input-group-addon glyphicon glyphicon-ok"> </span>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td>CITY</td>
							<td>
								<div class="col-lg-12">
									<div class="input-group">
									
										<input id="city" name="city" type="text" class="form-control" style="width: 400px;">
										 <span class="input-group-addon glyphicon glyphicon-ok"> </span>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td>STATE</td>
							<td>
								<div class="col-lg-12">
									<div class="input-group">
										<input id="state" name="state" type="text" class="form-control" style="width: 400px;">
										<span class="input-group-addon glyphicon glyphicon-ok"> </span>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td>COUNTRY</td>
							<td>
								<div class="col-lg-12">
									<div class="input-group">
										<input id="country" name="country" type="text" class="form-control" style="width: 400px;">
										<span class="input-group-addon glyphicon glyphicon-ok"> </span>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td>ZIP</td>
							<td>
								<div class="col-lg-12">
									<div class="input-group">
										<input id="zip" name="zip" type="text" class="form-control" style="width: 400px;">
										<span class="input-group-addon glyphicon glyphicon-ok"> </span>
									</div>
								</div>
							</td>
						</tr>
						
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					<button type="button" class="btn btn-primary" onclick="saveUser()">Save LOCATION</button>
				</div>
			</div>
		</div>
	</div>


	</div>
    
    
    
    
    
    <div role="tabpanel" class="tab-pane" id="item">

	 <!-- ITEM -->
    <div role="tabpanel" class="tab-pane" id="location">
		<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#itemModal">
		<span class="glyphicon glyphicon-user"></span>NEW ITEM
	</button>

	<!-- Modal -->
	<div class="modal fade" id="itemModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					
					<h4 class="modal-title" id="myModalLabel">ITEM</h4>
				</div>
				
				<div class="modal-body">

					<table border="0" style="height: 350px;">
						
						<tr>
							<td>ITEM CODE</td>
							<td>
								<div class="col-lg-12">
									<div class="input-group">
										<input id="itemCode" name="itemCode" type="text" class="form-control" style="width: 400px;">
										<span class="input-group-addon glyphicon glyphicon-ok"> </span>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td>ITEM NAME</td>
							<td>
								<div class="col-lg-12">
									<div class="input-group">
										<input id="itemName" name="itemName" type="text" class="form-control" style="width: 400px;">
										<span class="input-group-addon glyphicon glyphicon glyphicon-remove"> </span>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td>UOM</td>
							<td>
								<div class="col-lg-12">
									<div class="input-group">
										<select id="uom" name="uom" class="form-control" style="width: 400px;">
											<option>PIECES</option>
											<option>KILOGRAMS</option>
											<option>PACKETS</option>
										</select>
										<span class="input-group-addon glyphicon glyphicon-ok"> </span>
									</div>
								</div>
							</td>
						</tr>
						
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					<button type="button" class="btn btn-primary" onclick="saveUser()">Save LOCATION</button>
				</div>
			</div>
		</div>
	</div>
	


	</div>
	
	</div>
	
    <div role="tabpanel" class="tab-pane" id="customer">




<!-- LOCATION -->
    <div role="tabpanel" class="tab-pane" id="">
		<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#customerModal">
			<span class="glyphicon glyphicon-user"></span>NEW CUSTOMER
		</button>

		<!-- Modal -->
		<div class="modal fade" id="customerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						
						<h4 class="modal-title" id="myModalLabel">CUSTOMER</h4>
					</div>
					
					<div class="modal-body">
	
						<table border="0" style="height: 450px;">
							
							<tr>
								<td>NAME</td>
								<td>
									<div class="col-lg-12">
										<div class="input-group">
											<input id="customerName" name="customerName" type="text" class="form-control" style="width: 400px;">
											<span class="input-group-addon glyphicon glyphicon-ok"> </span>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td>CONTACT NUMBER</td>
								<td>
									<div class="col-lg-12">
										<div class="input-group">
											<input id="contactNumber" name="contactNumber" type="text" class="form-control" style="width: 400px;">
											<span class="input-group-addon glyphicon glyphicon glyphicon-remove"> </span>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td>EMAIL</td>
								<td>
									<div class="col-lg-12">
										<div class="input-group">
											<input id="email" name="email" type="text" class="form-control" style="width: 400px;">
											<span class="input-group-addon glyphicon glyphicon-ok"> </span>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td>ADDRESS</td>
								<td>
									<div class="col-lg-12">
										<div class="input-group">
										
											<textarea id="address" name="address" class="form-control" style="width: 400px; height: 80px;"></textarea>
											<span class="input-group-addon glyphicon glyphicon-ok"> </span>
										</div>
									</div>
								</td>
							</tr>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
						<button type="button" class="btn btn-primary" onclick="saveUser()">Save LOCATION</button>
					</div>
				</div>
			</div>
		</div>






		</div>
	</div>

</div>


</body>
</html>