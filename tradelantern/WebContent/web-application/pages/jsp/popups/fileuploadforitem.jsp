<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form action="uploadFile" enctype="multipart/form-data">
		<input type="file" id="myFile" name="myFile" class="btn btn-primary btn-sm">
		<input type="submit" class="btn btn-primary btn-sm" value="UPLOAD FILE">
</s:form>
</body>
</html>