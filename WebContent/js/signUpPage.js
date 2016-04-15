/**
 * Creator : kwongyo
 */
window.onload = function() {
	/*이메일이 회원가입 되어 있는지 안되어 있는지 check~*/
	$("#muEmailIdForm").blur(function() {
		alert("signUpPage.js파일속-ajax코드_이미 가입된 이메일인지 확인하셈")
	});
	/*비밀번호 확인란에 비밀번호 입력할 시 비밀번호가 맞는지 아닌지를 체크해줌.*/
	$("#muPasswordConfirmForm").keyup(function() {
		/*각각의 String을 받아온다*/
		var muPasswordForm = $("#muPasswordForm").val();
		var muPasswordConfirmForm = $("#muPasswordConfirmForm").val();
		//alert(muPasswordForm+"/"+muPasswordConfirmForm)
		if(muPasswordForm==muPasswordConfirmForm) {
			alert("asdfffffffff");
			$("#muResultFormSpan").val("비밀번호가 일치합니다.");
		} else {
			alert("asdf");
			$("#muResultFormSpan").val("비밀번호가 일치하지 않습니다.");
		}
		/*비밀번호 입력과 비밀번호 확인란에 작성한 비밀번호가 같지 않을 경우.*/
		
		
	});
	/* 일반 사용자 회원가입 버튼을 클릭했을 경우.*/
	$("#signUpBtn1").click(function() {
		
	});
}
