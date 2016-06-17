window.onload = function() {
	
	function requestFriend(uId) {   // 검색기능중 하나
		$.ajax({
			type:"post",
			
			data : {toUserCode : uId},
			url: "reqFriend.do",
			success : function(data) {
				alert(data);	
			}
		});
	}
	$("#searchBtn").click(function(){  // 검색기능중 하나
		$.ajax({
			type:"post",
			data: { searchBox : $("#searchBox").val() },
			url: "search.do",
			success :function(data) {
				$("#userList").html(data);
			}
		});
	});
	
	
	$("#logout_btn").click(function() {
		window.location.replace("logout.do");
	});
	
	//왼쪽버튼 클릭시
	$("#update_btn").click(function() {
		if ($("#update_btn").val() == "수정하기") {
			$("#input_name").attr("readonly", false);
			$("#input_name").css("background-color", "#ffffff");
			$("#update_btn").attr("value", "완료");
			$("#goodbye_btn").attr("value", "취소");
			$("#update_pwd_div").css('display', "block");
		} else if ($("#update_btn").val() == "완료") {
			$("#input_name").attr("readonly", true);
			$("#input_name").css("background-color", "#f1f1f1");
			$("#update_btn").attr("value", "수정하기");
			$("#goodbye_btn").attr("value", "탈퇴하기");
			$("#update_pwd_div").css("display", "none");
			$.ajax({
				type : "post",
				url : "modify.do",
				data : $("#profile_all_div").serialize(),
				success : function(data) {
					if (data == 1) {
						$("#input_name_").val($("#input_name").val());
						alert("정보가 수정되었습니다 .");
					} else if (data == -1) {
						$("#input_name").val($("#input_name_").val());
						alert("비밀번호가 일치하지 않습니다.");
					} else if(data==0){
						$("#input_name").val($("#input_name_").val());
						alert("변경할 비밀번호가 일치하지 않습니다.");
					} else {
						$("#input_name").val($("#input_name_").val());
						alert("예외 오류가 발생했습니다.");
					}
				},
				error : function(data) {
					$("#input_name").val($("#input_name_").val());
					alert("예외 오류가 발생했습니다2.");
				}
			})
			// alert("DB에 수정한 값 넘겨주는거 구현할 것");
		} else if ($("#update_btn").val() == "탈퇴") {
			$("#input_name").attr("readonly", true);
			$("#update_btn").attr("value", "수정하기");
			$("#goodbye_btn").attr("value", "탈퇴하기");
			$("#update_pwd_div").css("display", "none");
			$("#goodbye_div").css("display", "none");
			$.ajax({
				type : "post",
				url : "leave.do",
				data : $("#profile_all_div").serialize(),
				success : function(data) {
					if (data == 1) {
						alert("회원 탈퇴되었습니다..");
						window.location.replace("login.jsp");
					} else if (data == 0) {
						alert("비밀번호가 일치하지 않습니다.");
					} else {
						alert("예외 오류가 발생했습니다");
					}
				},
				error : function(data) {
					alert("예외 오류가 발생했습니다2.");
				}
			})
			//alert("DB에서도 탈퇴처리 구현할 것");
		}
		clear();
	});
	
	//오른쪽버튼 클릭시
	$("#goodbye_btn").click(function() {
		if ($("#goodbye_btn").val() == "탈퇴하기") {
			$("#update_btn").attr("value", "탈퇴");
			$("#goodbye_btn").attr("value", "취소");
			$("#goodbye_div").css("display", "block");
		} else if ($("#goodbye_btn").val() == "취소") {
			$("#input_name").attr("readonly", true);
			$("#input_name").css("background-color", "#f1f1f1");
			$("#update_btn").attr("value", "수정하기");
			$("#goodbye_btn").attr("value", "탈퇴하기");
			$("#update_pwd_div").css("display", "none");
			$("#goodbye_div").css("display", "none");
			$("#input_name").val($("#input_name_").val());
		}
		clear();
	});
	
	//취소 클릭시 값 초기화 메서드
	function clear() {
		$("#password_check").val("");
		$("#password_new").val("");
		$("#password_new_confirm").val("");
		$("#password_check2").val("");
	}
	
	function profileSubmit() {
		$("#profile_all_div").submit();
	} 
}