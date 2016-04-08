<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/sign.css" type="text/css">
<title>회원가입</title>
</head>

<script type="text/javascript">
	function AllCheck() {
// 		var all_check = document.getElementById("all_check").checked;
// 		var email = document.getElementById("email").checked;
// 		var sms = document.getElementById("SMS").checked;
		
// 		if (all_check == true) {
// 			email = true;
// 			sms = true;
// 		} else {
// 			email = false;
// 			sms = false;
// 		}
		if(document.getElementById("all_check").checked==true) {
			document.getElementById("email").checked = true;
			document.getElementById("SMS").checked = true;;
		} else {
			document.getElementById("email").checked = false;
			document.getElementById("SMS").checked = false;
		}
	}
</script>


<body>
	<div class="main_wrapper">
		<div class="coupang_img">
			<a href="http://www.coupang.com"> <img
				src="//mimgs.coupangcdn.com/image/static/my/logo-copuang-140925.png"
				width="113" height="25">
			</a>
		</div>
		<fieldset class=main_fieldset>
			<h1 class="main_title">회원가입</h1>
			<div class="login">
				<div class="login_id_title">
					<b>아이디(이메일)</b>
				</div>
				<div class="login_id_input">
					<span><input type="text" class="login_id_input_email"
						maxlength="20" id="password"> @ <input type="text"
						class="login_id_input_domain" maxlength="15"> <select
						class="login_id_input_select" id="password_check">
							<option value="0">직접입력</option>
							<option value="naver.com">naver.com</option>
							<option value="hanmail.net">hanmail.net</option>
							<option value="nate.com">nate.com</option>
							<option value="gmail.com">gmail.com</option>
							<option value="hotmail.com">hotmail.com</option>
							<option value="lycos.co.kr">lycos.co.kr</option>
							<option value="empal.com">empal.com</option>
							<option value="dreamwiz.com">dreamwiz.com</option>
							<option value="korea.com">korea.com</option>
					</select></span>
				</div>
				<div class="login_pw">
					<div>
						<span class="login_pw_title"><b>비밀번호</b></span> <span
							class="login_pw_title"><b>비밀번호 확인</b></span>
					</div>
					<div>
						<input id="password" type="password" class="login_pw_input" maxlength="15"
							value=""> <input id="password_check" type="password" class="login_pw_input"
							maxlength="15" value="">
					</div>
					<div id="login_pw_err"><p></p></div>
				</div>
			</div>
			<div>
				<p>
					비밀번호는 6~15자 이내로 영문 (대문자,소문자), 숫자, 특수 문자 3가지 조합중 2가지 이상을 조합<br>
					하셔서 작성하시면 됩니다.<br> 단, 3가지 모두를 조합하실 경우 더욱 강력한 패스워드 구현이 가능합니다.
				</p>
			</div>
			<div>
				<fieldset class="member_and_option_impormation">
					<legend align="left">
						<b>회원정보</b>
					</legend>
					<div class="member_element">
						<span> <b class="member_subtitle">이름</b> <input></input>
						</span>
					</div>
					<div class="member_element">
						<span> <b class="member_subtitle">생년월일</b> <select
							id="member_select_option_year">
							<option value="0" selected>년도</option>
								<% for(int i=2016; i>=1900; i--) {%>
								<option value=""><%= i %>년</option>
								<% } %>
						</select><select id="member_select_option_month">
								<option value="0" selected>월</option>
								<% for(int i=1; i<=12; i++) { %>
								<option value="<%=i%>"><%= i %>월</option>
								<% } %>
						</select><select id="member_select_option_day">
								<option value="0" selected>일</option>
								<% for(int i=1; i<=31; i++) {%>
								<option value="<%=i%>"><%=i%>일</option>
								<% } %>
						</select>
						</span>
					</div>
					<span class="member_description">만 14세 미만은 가입하실 수 없습니다.</span>
					<div class="member_element">
						<span><b class="member_subtitle">휴대폰 번호</b> <input></input>
						</span>
					</div>
					<div class="member_description">
						아이디 또는 비밀번호를 찾기 위해 꼭 필요한 정보이므로 <b>정확하게</b> 입력해주세요.
					</div>
				</fieldset>
			</div>
			<div>
				<fieldset class="member_and_option_impormation">
					<legend align="left">
						<b>부가정보</b>
					</legend>
					<div class="option_impormation_element">
						<span><b class="option_impormation_subtitle">성별</b> <input
							type="radio" name="gender">남자 <input type="radio"
							name="gender">여자 </span>
					</div>
					<div class="option_impormation_element">
						<span><b class="option_impormation_subtitle">마케팅 수신동의</b> <input
							type="checkbox" id="email">이메일 <input type="checkbox" id="SMS">SMS </span>
					</div>
					<div>
						<span><b class="option_impormation_subtitle">(<input
								type="checkbox" id="all_check" onclick ="AllCheck()">전체동의)
						</b> </span> <span id="option_impormation_description_1">쿠팡에서 제공하는 오늘의
							쿠팡 정보 등을 받으실 수 있습니다. 단, 상품 구매<br> 정보는 수신동의 여부 관계없이 발송됩니다.<br>
						</span> <b id="option_impormation_description_2">제공 동의를 하지 않으셔도 서비스
							이용에는 문제가 없습니다.</b>
					</div>
				</fieldset>
			</div>
			<div id="complete_button_wrapper" align="center">
				<button id="complete_button" type="submit">가입완료</button>
			</div>
		</fieldset>
	</div>
</body>
</html>