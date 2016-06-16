window.onload = function() {

	$("#loginBtn").click(validate);

	function validate() {
		if ($("#loginId").val() == "") {
			alert("아이디를 입력해 주세요.");
			$("#loginId").focus();
			return;
		} else if ($("#loginPwd").val() == "") {
			alert("비밀번호를 입력해 주세요.");
			$("#loginPwd").focus();
			return;
		}
		else {
			$.ajax({
				type : "post",
				url : "login.do",
				data : $("#loginForm").serialize(),
				success : function(data) {
					if (data == -1) {
						alert("아이디나 비밀번호를 잘못 입력하셨습니다.");
					} else if (data == 1) {
						 window.location.replace("login.jsp")
					}
				}
			});
		}
	}
}