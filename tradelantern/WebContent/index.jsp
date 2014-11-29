<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lantern</title>
</head>
<body>
<div class="header"  style="background-color: black; height: 30px;">ADVANCE ELECTRONICS</div>
<s:form action="start" id="myform" >
	Your user-agent is: <%=request.getHeader("user-agent")%><br/>
	Your IP address is: <%=request.getRemoteAddr()%><br/>
	Protocol: <%=request.getProtocol()%><br/>
	Session Id: <%=request.getSession().getId()%><br/>
	Session Creation Time: <%= new Date( request.getSession().getCreationTime() )%><br/>
	Session Last Access: <%= new Date( request.getSession().getLastAccessedTime() )%><br/><br/>

	<script type="text/javascript">
	setTimeout(
	  function() 
	  {
	   		document.getElementById('myform').submit();
	  }, 5000);
	</script>

</s:form>

</body>
</html>