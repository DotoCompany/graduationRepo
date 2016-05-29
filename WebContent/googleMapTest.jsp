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
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

#map {
	height: 80%;
}
</style>


<title>RE:CALL</title>
</head>

<body>

	<input type="hidden" id="contextPath"
		value="<%=request.getContextPath()%>">


	<div id="map"></div>



	<script src="<%=request.getContextPath()%>/js/main.js" type="text/javascript" charset="utf-8"></script>
	 <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCv59_KYHHzRqtky9EwzOJ7WY-Pb5XMGlc"
  type="text/javascript"></script>
</body>

</html>