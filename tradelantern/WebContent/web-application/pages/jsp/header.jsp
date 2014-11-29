<%@taglib uri="/struts-tags" prefix="s"%>

<title>Lantern</title>

<link href="<%=request.getContextPath() %>/web-application/style/bootstrap.css"	rel="stylesheet">
<link href="<%=request.getContextPath() %>/web-application/style/mycss.css"	rel="stylesheet">

<script	src="<%=request.getContextPath() %>/web-application/javascript/jquery-1.9.1.js"	type="text/javascript"></script>
<script	src="<%=request.getContextPath() %>/web-application/javascript/bootstrap.js"	type="text/javascript"></script>
<script	src="<%=request.getContextPath() %>/web-application/javascript/jquery.dataTables.min.js"	type="text/javascript"></script>

<script src="<%=request.getContextPath() %>/dwr/engine.js"	type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/dwr/util.js"	type="text/javascript"></script>

<div  align="right" style="background-color: black; height: 30px;">
	<div class="menu">
		<s:form action="user"><div onclick="navigate(this)"> USERS </div> </s:form>
		<s:form action="purchase"><div onclick="navigate(this)">PURCHASE</div></s:form>
		<s:form action="transfer"><div onclick="navigate(this)">TRANSFER</div></s:form>
		<s:form action="sales"><div onclick="navigate(this)">SALES</div></s:form>
		<s:form action="stock"><div onclick="navigate(this)">STOCK</div></s:form>
		<s:form action="report"><div onclick="navigate(this)">REPORT</div></s:form>
	</div>
	<div class="header">ADVANCE ELECTRONICS</div>
</div>

<script type="text/javascript">
	
	function navigate(f){
		$(f).parent().submit();
	}


</script>


<!-- 
<div style="position: fixed; left: 0px; top: 0px;">
<button type="button" onclick="toggleMenu()" class="btn" style="width: 100px; height:30px "> MENU </button>
</div> -->

<%-- <div style="position: fixed; left: 0px; top: 30px;" id="menu">
	<jsp:include page="menu.jsp"></jsp:include>
</div>

<script type="text/javascript">
function toggleMenu(){
	
	$('#menu').show(500);
	
}

</script> --%>