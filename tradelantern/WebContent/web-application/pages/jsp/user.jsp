<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>


	<table id="userDetails">
	</table>

	<button type="button" class="btn btn-primary btn-sm"
		data-toggle="modal" data-target="#myModal">
		<span class="glyphicon glyphicon-user"></span>NEW USER
	</button>

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					
					<h4 class="modal-title" id="myModalLabel">USER INFO</h4>
				</div>
				
				<div class="modal-body">

					<table border="0" style="height: 450px;">
						<tr>
							<td>USER NAME</td>
							<td>
								<div class="col-lg-12">
									<div class="input-group">
										<input id="userName" name="userName" type="text" class="form-control" style="width: 400px;">
										<span class="input-group-addon glyphicon glyphicon glyphicon-remove"> </span>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td>NAME</td>
							<td>
								<div class="col-lg-12">
									<div class="input-group">
										<input id="name" name="name" type="text" class="form-control" style="width: 400px;">
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
						<tr>
							<td>CONTACT NO</td>
							<td>
								<div class="col-lg-12">
									<div class="input-group">
										<input id="contactNo" name="contactNo" type="text" class="form-control" style="width: 400px;">
										<span class="input-group-addon glyphicon glyphicon-ok"> </span>
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
							<td>ROLE</td>
							<td>
								<div class="col-lg-12">
									<div class="input-group">
										<select id="role" name="role" class="form-control" style="width: 400px;"></select>
										<span class="input-group-addon glyphicon glyphicon-ok"> </span>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td>LOCATION</td>
							<td>
								<div class="col-lg-12">
									<div class="input-group">
										<select id="locationCd" name="locationCd" class="form-control" style="width: 400px;"></select>
										<span class="input-group-addon glyphicon glyphicon-ok"> </span>
									</div>
								</div>
							</td>
						</tr>
					</table>






				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					<button type="button" class="btn btn-primary">Save User</button>
				</div>
			</div>
		</div>
	</div>


</body>
</html>