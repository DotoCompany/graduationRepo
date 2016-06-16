<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="javax.servlet.http.HttpSession" %>
<html>
<head>
<%
	if(request.getSession().getAttribute("userCode")!=null)
		response.sendRedirect("main.jsp");
%>

<!-- Imported sources -->

<script src="<%=request.getContextPath()%>/common/js/jquery-1.12.3.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no">
<script src="<%=request.getContextPath() %>/js/login.js" ></script>
<!-- Custom sources -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/login.css">

<title>RE:CALL</title>

</head>
<body>
	<div id="background">
		<img src="<%=request.getContextPath()%>/image/background.jpg" class="stretch"/>
		<form action="login.do" id="loginForm" method="post" class="main_div">
			<div id="logo_div">
				<img id="logo" src="<%=request.getContextPath()%>/image/logo.png" />
			</div>

			<div id="comment_div">
				<p class="comment">
					Special service for you<br>RE:CALL
				</p>
			</div>

			<div id="facebook_div">
				<input class="facebook_bt" type="submit" value="Join with Facebook" />
			</div>

			<div id="login_div">
				<input class="login_input" name="loginId" id="loginId" type="email"
					placeholder="E-mail" /><br> <input class="login_input"
					name="loginPwd" id="loginPwd" type="password"
					placeholder="Password" />
			</div>

			<div id="forgot_div">
				<a href="" class="a_tag">Forgot password</a>
			</div>

			<div id="login_bt_div">
				<input type="button" id="loginBtn" class="normal_bt" value="Login" />
			</div>

			<div id="bottom_div">
				<p class="bottom_comment">
					No account yet?<br> <a
						href="<%=request.getContextPath()%>/register.jsp" class="a_tag">Register now</a>
				</p>
			</div>
		</form>
	</div>
</body>
</html>