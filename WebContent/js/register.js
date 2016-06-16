/**
 * Creator : kwongyo
 */
window.onload = function() {
	/*이메일이 회원가입 되어 있는지 안되어 있는지 check~*/
	$("#muEmailIdForm").focusout(function() {
		$.ajax({
			type : "post",
			url : "checkID.do",
			data : $("#signUpForm").serialize(),
			success : function(data) {
				if(data==1) {
					alert("이미 있는 이메일입니다.");
					$("#isCheck").val("false");
				} else if(data==0) {
					alert("가입 가능한 이메일입니다.");
					$("#isCheck").val("true");
				} else if(data==-1) {
					alert("이메일을 입력해주세요.");
					$("#isCheck").val("false");
				}
			},
		})
	});
	
	/*비밀번호 입력 시 서로 입력된 비밀번호 2칸이 일치하는지 검사하는 함수 2개*/
	$("#muPasswordForm").keyup(checkPassword);
	$("#muPasswordConfirmForm").keyup(checkPassword);
	
	/* 일반 사용자 회원가입 버튼을 클릭했을 경우.*/
	$("#signUpBtn1").click(checkRegisterNecessaryCondition);
	
	
	/*비밀번호 확인란에 비밀번호 입력할 시 비밀번호가 맞는지 아닌지를 체크해주는 함수.*/
	function checkPassword() {
		if($("#muPasswordForm").val()=="")
			return;
		else if($("#muPasswordConfirmForm").val()=="")
			return;
		
		if($("#muPasswordForm").val()==$("#muPasswordConfirmForm").val()){ // 비밀번호 입력과 비밀번호 확인란에 작성한 비밀번호가 같을 경우.
			$("#passwordCheckHiddenTag").val("true");
			$("#muResultFormSpan").text("비밀번호가 일치합니다.");
			return;
		}
		else /*비밀번호 입력과 비밀번호 확인란에 작성한 비밀번호가 같지 않을 경우.*/ {
			$("#passwordCheckHiddenTag").val("false");
			$("#muResultFormSpan").text("비밀번호가 일치하지 않습니다.");
			return;
		}
	}
	
	
	/*submit하기 전에 data들이 잘 들어 왔는지 check */
	function checkRegisterNecessaryCondition(){
		
		if($("#muNicknameForm").val()=="") {
			alert("이름를 입력해 주세요.");
			$("#muNicknameForm").tooltip({content:"이름을 입력해 주세요!"});
			return;
		}
		else if($("#muEmailIdForm").val()=="" || ($("#muEmailIdForm").val()).indexOf('@')==-1) {
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
		} else if ($("#isCheck").val() == "true") {
			$("#signUpForm").submit();
			$.ajax({
				type : "post",
				url : "register.do",
				data : $("#signUpForm").serialize(),
				success : function(data) {
					if (data == 1) {
						window.location.replace("main.jsp")
					} else {
						alert("예상치 못한 에러가 발생했습니다 : " + data);
					}
				}
			});
		} else {
			alert("이메일을 확인해주세요.");
			$("#loginId").focus();
		}
	}
}
