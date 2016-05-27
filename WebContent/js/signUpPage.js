/**
 * Creator : kwongyo
 */
window.onload = function() {
	if ('${isRegister eq "false"}'=='false') {
		alert("회원가입에 실패했습니다.");
	}
	if ('${isRegister eq "false"}'=='true') {
		alert("회원가입 성공했습니다.");
	}
	/*이메일이 회원가입 되어 있는지 안되어 있는지 check~*/
	$("#muEmailIdForm").focusout(function() {
		
		alert("signUpPage.js파일속-ajax코드_이미 가입된 이메일인지 확인하셈");
	});
	/*비밀번호 입력 시 서로 입력된 비밀번호 2칸이 일치하는지 검사하는 함수 2개*/
	$("#muPasswordForm").focusout(checkPassword);
	$("#muPasswordConfirmForm").focusout(checkPassword);
	
	/* 일반 사용자 회원가입 버튼을 클릭했을 경우.*/
	$("#signUpBtn1").click(checkRegisterNecessaryCondition);
	/*비밀번호 확인란에 비밀번호 입력할 시 비밀번호가 맞는지 아닌지를 체크해주는 함수.*/
	function checkPassword() {
		if($("#muPasswordForm").val()==$("#muPasswordConfirmForm").val()){ // 비밀번호 입력과 비밀번호 확인란에 작성한 비밀번호가 같을 경우.
			$("#muResultFormSpan").text("비밀번호가 일치합니다.");
			$("#passwordCheckHiddenTag").val("true");
		}
		else /*비밀번호 입력과 비밀번호 확인란에 작성한 비밀번호가 같지 않을 경우.*/ { 
			$("#muResultFormSpan").text("비밀번호가 일치하지 않습니다.");
			$("#passwordCheckHiddenTag").val("false");
		}
	}
	/*submit하기 전에 data들이 잘 들어 왔는지 check */
	function checkRegisterNecessaryCondition(){
		
		if($("#muNicknameForm").val()=="") {
			alert("이름를 입력해 주세요.");
			$("#muNicknameForm").tooltip({content:"이름을 입력해 주세요!"});
			return;
		}
		else if($("#muEmailIdForm").val()=="") {
			alert("이메일을 입력해 주세요.");
			$("#muEmailIdForm").focus();
			return;
		}
		else if($("#muPasswordForm").val()=="") {
			alert("비밀번호를 입력해 주세요.");
			$("#muPasswordForm").focus();
			return;
		}
		else if ( $("#passwordCheckHiddenTag").val()=="false"){
			alert("비밀번호를 확인해 주세요.");
			$("#muResultFormSpan").focus();
			return;
		}
		
		$("#signUpForm").submit();
		
	}
}
