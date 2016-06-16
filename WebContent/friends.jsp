<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 친구목록 리스트임. -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=request.getContextPath()%>/common/js/jquery-1.12.3.js"></script>
<title>친구 목록</title>
</head>
<script src="<%=request.getContextPath()%>/common/js/bootstrap.min.js"></script>
<link href="<%=request.getContextPath()%>/common/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/friends.css" rel="stylesheet">

<script>
/*메세지 버튼 클릭 시.*/
function messageBtn(friendCode,friendImage){
	$.ajax({
		type : "post",
		url : "message.do",
		/*아래에 friendImage를 보고 왜 이걸 여기서 보내줬지 하고 있을거다..
		지금은 새벽 3시고 내일은 발표고 졸려서 그랬다.
		미안하다
		*/
		data : { "friendCode" : friendCode, 
		"friendImage" :friendImage	
		}
		,
		error : function() {
			alert("메시지 불러오기 실패");
		},
		success : function(data) {
			$("#messageArea").html(data);
		}
	});
}
window.onload = function() {
	
		$.ajax({
			type : 'post',
			url : "friendList.do",
			error : function() {
				alert("친구목록 불러오기 실패");
			},
			success : function(data) {
				$("#friendDiv").html(data);
			}
		});	
		$("#messageSendBtn").click(function(){
			
			 $.ajax({
				type:'post',
				url: "messageSend.do",
				data :{ msg : $("#messageBox").val() ,friendCode : $("#friendCode").val()  } ,
				success : function(data) {
					if(data!=0){
						$("#messageBtn").trigger("click");
					}
				}
			}); 
		});
}

</script>

<jsp:include page="sideBar.jsp" flush="false"/>
<body>
	<div id="all">
	<div id="friendDiv">
	</div>
	<div id="messageDiv">
		<div id="messageArea"></div>
		<div id="message_bottom">
			<input type="text" name="message" placeholder="내용을 입력하세요..." id="messageBox"/>
			<input type="button" id="messageSendBtn" class="btn btn-success btn-lg" value="전송"/>
		</div>
	</div>
	</div>
</body>
</html>