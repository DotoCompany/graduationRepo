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
	<div id="left_sideBar">
		<ul>
			<li><a href="">
					<div id="sideBar_logo">
						<span></span>
					</div>
			</a></li>
			<li><a href="">
					<div id="sideBar_profile">
						<span>Profile</span>
					</div>
			</a></li>
			<li><a href="">
					<div id="sideBar_friends">
						<span>Friends</span>
					</div>
			</a></li>
			<li><a href="">
					<div id="sideBar_photo">
						<span>Photo</span>
					</div>
			</a></li>
			<li><a href="">
					<div id="sideBar_notification">
						<span>Notification</span>
					</div>
			</a></li>
			<li><a href="">
					<div id="sideBar_markers">
						<span>Markers</span>
					</div>
			</a></li>
		</ul>
	</div>
	<!-- side bar end -->
	
	<div id="markerMap">
	
		<%@include file="markerMap.jsp" %>
	
	</div>


</body>

</html>