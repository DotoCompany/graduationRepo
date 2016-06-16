
$(document).ready(function(){
	
	$('#loginBtn').click(function(){
		
		adminLoginCheck();
		
	});
	
});

function adminLoginCheck() {
	
	if ($("#adminId").val()=="" || $("#adminPwd").val()=="") {
		alert("아이디 혹은 비밀번호를 입력하세요.");
		return;
	}
	
	/* 로그인 (아이디, 비번) 유효성 check !! */
	
	
	$('#loginFm').submit();
	
}