<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset=UTF-8">

<!-- customized sources -->
<script src="<%=request.getContextPath()%>/js/main.js"
	type="text/javascript" charset="utf-8"></script>

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
	height: 100%;
}

.normal_bt {
	font-family: nanum-barun-gothic-regular !important;
	background-color: #969696;
	color: #FEFDFD;
	width: 100%;
	padding: 15px 40px 17px;
    border-radius: 7px;
    border: none;
    line-height: 17px;
/*     font-weight: bold; */
    font-size: 15px;
}

</style>


<title>RE:CALL</title>
</head>

<body>

	<input type="hidden" id="contextPath"
		value="<%=request.getContextPath()%>">
	<input type="hidden" id="uId"
		value="<%=session.getAttribute("userCode")%>">

	<div id="map"></div>



	<script src="<%=request.getContextPath()%>/js/main.js"
		type="text/javascript" charset="utf-8"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCv59_KYHHzRqtky9EwzOJ7WY-Pb5XMGlc"
		type="text/javascript"></script>
</body>

</html>