<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset=UTF-8">


<!-- customized sources -->
<script src="<%=request.getContextPath()%>/js/loginPage.js" type="text/javascript" charset="utf-8"></script>



<!-- imported sources -->

<!-- jQuery -->
<script src="<%=request.getContextPath()%>/common/js/jquery-1.12.3.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="<%=request.getContextPath()%>/common/js/bootstrap.min.js"></script>
<!-- Bootstrap Core CSS -->
<link href="<%=request.getContextPath()%>/common/css/bootstrap.min.css" rel="stylesheet">
<!-- Login about CSS -->
<link href="<%=request.getContextPath()%>/css/login.css" rel="stylesheet">

	<title>RE:CALL Sign-in</title>
</head>
<body>
	<div class="container">
		<div id="all">
		<br/>
		<br/>
			<!-- 여기부터 화면에 그려지는 영역. -->
			<div class="jumbotron" id="loginMain">
			<p class="login_description">당신의 특별한 서비스</p>
			<p class="login_description">RE:CALL</p>
			
				<div id="loginPageLogo" ></div>
				<div class="row">
					
					<div class="row"></div>
					<div class="loginContentDiv">
						<div class="row">
							<div class="col-md-4"></div>
							<div class="col-md-4">
								<div id="loginInFrame">
									<form action="<%=request.getContextPath()%>/test.jsp" method="post" id="loginForm">
										<div id="content" class="tab-content">
											<input type="hidden" name="checkUser" value="mu"
												id="checkUserType">
											<div class="tab-pane fade in active" id="attendantLogin">

												
												<br>
												<br> <input type="email" class="form-control"
													name="loginId" placeholder="이메일  아이디 입력" size="20"
													id="loginId"> <input type="password"
													class="form-control" name="loginPwd" placeholder="비밀번호 입력"
													size="20" id="loginPwd">
											</div>

										</div>
										<br>
										<br>
										<div id="loginResultDiv"></div>
										<button id="facebookLoginBtn" type="button" class="btn btn-primary btn-block">페이스북으로 RE:CALL하기</button>
										<br/>
										<br/>
										<button type="button" id="loginBtn" class="btn btn-success">로 그 인</button>
									</form>

								</div>

							</div>
							<div class="col-md-4"></div>
						</div>
					</div>

					<br>

					<div id="loginBottomDiv">
						<p>
							아이디가 없으신가요?
							<br/> 
							<a href="<%=request.getContextPath()%>/jsp/sign_up.jsp">지금 가입하세요</a>
						</p>
					</div>
				</div>
			</div>
			
</body>

</html>