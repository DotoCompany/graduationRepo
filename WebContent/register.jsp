<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/login.css">
<script src="<%=request.getContextPath()%>/common/js/jquery-1.12.3.js"></script>
<script src="<%=request.getContextPath()%>/js/register.js"
	type="text/javascript" charset="utf-8"></script>
<title>RE:CALL Register</title>
</head>

<body>
<div id="background">
		<img src="<%=request.getContextPath()%>/image/background.jpg" class="stretch"/>
	<form class="main_div" id="signUpForm" method="post" action="<%=request.getContextPath()%>/register.do">
		<div id="logo_div">
			<img id="logo" src="<%=request.getContextPath()%>/image/logo.png" />
		</div>

		<div id="comment_div">
			<p class="comment">
				Found something nice?<br>Join now!
			</p>
		</div>

		<div id="name_div">
			<input id="muNicknameForm" name="name" class="login_input" type="text" placeholder="Name"/><br>
		</div>

		<div id="idpw_div">
			<input class="login_input" name="email" id="muEmailIdForm" type="email" placeholder="E-Mail" /><br>
			<input class="login_input" name="password" id="muPasswordForm" type="password" placeholder="Password" />
			<input class="login_input" name="password" id="muPasswordConfirmForm" type="password" placeholder="Password confirm" />
		</div>

		<div id="muResultForm">
			<span class="bottom_comment" id="muResultFormSpan"></span>
		</div>
		<input type="hidden" id="passwordCheckHiddenTag" value="false">

		<div id="login_bt_div">
			<input type="submit" id="signUpBtn1" class="normal_bt" value="Sign up" />
		</div>

		<div id="bottom_div">
			<p class="bottom_comment">
				Do you have an ID?  <a href="<%=request.getContextPath()%>/login.jsp" class="a_tag">Sign in</a><br><br>
				You accept out terms and privacy policy by registering<br>an
				account. <a href="<%=request.getContextPath()%>/policy.jsp" class="a_tag" target="_blank">View</a>
			</p>
		</div>
	</form>
	</div>
</body>

</html>