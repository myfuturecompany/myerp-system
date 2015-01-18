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
			<s:property value="message"/>
			
			<br><br><br>
			
			<table>
				<tr><td>Total number of item added :</td><td> <s:property value="addedItemCount"/></td></tr>
				<tr><td>Total number of item updated :</td><td>  <s:property value="updatedItemCount"/> </td></tr>
				<tr><td>Total number of item failed to add/update :</td><td>  <s:property value="failedItemCount"/> </td></tr>
			</table>
			
			<br>
				Note : Please refresh the parent page to get updated item list.
			<br>
			
			
			<table width="80%" border="1">
				<tr><td>NEW ITEMS</td><td>UPDATED ITEMS</td><td>FAILED ITEMS</td></tr>
				<tr>
					<td valign="top">
						<s:iterator id="itr" value="addedItem">
						  <s:property value="itr"/><br>
						</s:iterator>
					</td>
					<td valign="top">
						<s:iterator id="itr" value="updatedItem">
						 <s:property value="itr"/><br>
						</s:iterator>
					</td>
					<td valign="top">
						<s:iterator id="itr" value="failedItem">
						  <s:property value="itr"/><br>
						</s:iterator>
					</td>
				</tr>
			
			</table>
			
			
		
</body>
</html>