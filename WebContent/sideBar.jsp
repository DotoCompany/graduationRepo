<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/sideBar.css">

<div id="left_sideBar" class="left">
		<ul>
			<li><a href="<%=request.getContextPath()%>/main.jsp">
					<div id="sideBar_logo">
						<span>RE:Call</span>
					</div>
			</a></li>
			<li><a href="">
					<div id="sideBar_profile">
						<span>Profile</span>
					</div>
			</a></li>
			
			<li><a href="<%=request.getContextPath()%>/photo.jsp">
					<div id="sideBar_photo">
						<span>Photo</span>
					</div>
			</a></li>
			<li><a href="">
					<div id="sideBar_markers">
						<span>Markers</span>
					</div>
			</a></li>
			<li><a href="">
					<div id="sideBar_notification">
						<span>Notification</span>
					</div>
			</a></li>
			
			<li><a href="">
					<div id="sideBar_friends">
						<span>Friends</span>
					</div>
			</a></li>
		</ul>
	</div>
	<!-- side bar end -->
