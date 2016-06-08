<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>

<head>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/main.css">

<!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- jQuery -->
<script src="<%=request.getContextPath()%>/common/js/jquery-1.12.3.js"></script>



<title>RE:CALL</title>
</head>

<body>
<div id="all">

	<jsp:include page="sideBar.jsp" flush="false"/>
	
	<div class="main">
	
		<div id="markerMap">
			<jsp:include page="markerMap.jsp" flush="false"/>
		</div>
		
		<div>
		
		</div>
	
	</div>
	
	

</div>
</body>

</html>