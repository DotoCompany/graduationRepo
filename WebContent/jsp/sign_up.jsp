<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- jquery -->
<script src="<%=request.getContextPath()%>/common/js/jquery-1.12.3.js"></script>
<!-- 회원가입 script -->
<script src="<%=request.getContextPath()%>/js/signUpPage.js"
	type="text/javascript" charset="utf-8"></script>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/sign.css"/>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


	<title>RE:CALL Sign-up</title>
</head>
<body>
	<div class="container">

		<br/>
		<br/>
		<div id="all">
		<br/>
			<br/>
			<div id="registerPageLogo" ></div>
			
			<!-- end of row -->

			<div id="signUpContentDiv">
				<form action="<%=request.getContextPath()%>/register.do"
					method="post" id="signUpForm">
					<div id='content' class="tab-content">

						<div class="tab-pane fade in active" id="attendantSignUp">

							<input type="hidden" name="checkUser" value="mu"
								id="checkUserType"> <input type="hidden"
								name="registerCode" value="register" />
							<div class="row">
								<div class="col-md-4"></div>
								<div class="col-md-4">

									
									<br>
									<br>

									<div id="muExistNicknameResult"></div>
									<input type="text" class="form-control" placeholder="이름 입력"
										size="20" name="name" id="muNicknameForm">
									<div id="muExistResult"></div>
									<input type="email" class="form-control" placeholder="이메일 입력"
										size="20" name="email" id="muEmailIdForm"> <br>
									<br> <input type="password" class="form-control"
										placeholder="비밀번호 입력" size="20" name="password"
										id="muPasswordForm">
									<!-- ajax 비동기 처리  -->
									<input type="password" class="form-control"
										placeholder="비밀번호 확인" size="20" name="passwordComfirm"
										id="muPasswordConfirmForm">
									<div id="muResultForm">
										<span id="muResultFormSpan"></span>
									</div>
									<input type="hidden" id="passwordCheckHiddenTag" value="false">


									<br>
									
									<br> <br> 
									
									<button type="button" id="signUpBtn1" class="btn btn-success">회원가입</button>
								</div>
								<div class="col-md-4"></div>
							</div>
							<!-- end of .row -->

						</div>
						<!-- end of #attendantSignUp -->



					</div>
					<!-- end of .tab-content -->
				</form>
				<!--  </div>-->
				<!-- end of row -->
			</div>
			<!-- end of signUpContent -->

			<br>
			<hr id="sighUpPageUnderLine"/>
			<div id="signUpBottomDiv">

				<p>
					RE:CALL 회원 이신가요?<br> <a href="<%=request.getContextPath()%>/login.jsp">지금 로그인하세요</a>
					<br/>
				</p>
			</div>
			<!-- end of signUpBottomDiv -->

		</div>
		<!-- end of #all -->
	</div>
	<!-- end of .container -->
</body>
</html>