<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset=UTF-8">

<!-- customized sources -->
<%-- <script src="<%=request.getContextPath()%>/js/main.js"
	type="text/javascript" charset="utf-8"></script> --%>

<!-- imported sources -->
<!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- jQuery -->
<script src="<%=request.getContextPath()%>/common/js/jquery-1.12.3.js"></script>


<style>

</style>


<title>RE:CALL</title>
</head>

<body>

	<div id='all'>
	
		<div id='mapDiv'>
			<jsp:include page="<%=request.getContextPath()%>/googleMapTest.jsp" flush="false">
			</jsp:include>
		</div>
		
		
	
	</div>
	
	
	<script src="<%=request.getContextPath()%>/js/main.js"
		type="text/javascript" charset="utf-8"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCv59_KYHHzRqtky9EwzOJ7WY-Pb5XMGlc"
		type="text/javascript"></script>
</body>

</html>