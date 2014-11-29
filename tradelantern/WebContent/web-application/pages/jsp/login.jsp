<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body style="background-image: url('<%=request.getContextPath() %>/web-application/images/background_index.jpg'); background-repeat: no-repeat; background-size: 100% ">
<div class="header"  style="background-color: black; height: 30px;">ADVANCE ELECTRONICS</div>

<div class="curveedge" align="center">
<br><br>

<s:form action="login" id="myform" >
	<table align="center" width="100%" height="90%">
		
		<tr>
			<td  align="right"> <b style="color: black;">USER NAME : </b></td><td><input style="width: 90%; color: black;" type="text" name="userName" id="userName"></td>
		</tr>
		<tr>
			<td   align="right"> <b style="color: black;">PASSWORD : </b></td><td><input style="width: 90%; color: black;" type="password" name="passWord" id="passWord"></td>
		</tr>
		<tr>
			<td align="center" colspan="2"> <button style="width: 200px;" class="btn" type="submit"><b>LOGIN</b></button></td>
		</tr>
		
	</table>
	
</s:form>
</div>

</body>
</html>