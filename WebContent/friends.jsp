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
function messageBtn(friendCode){
	$.ajax({
		type : "post",
		url : "message.do",
		data : { "friendCode" : friendCode }
		,
		error : function() {
			alert("메시지 불러오기 실패");
		},
		success : function(data) {
			$("#messageDiv").html(data);
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
}
</script>

<jsp:include page="sideBar.jsp" flush="false"/>
<body>
	<div id="all">
	<div id="friendDiv">
	</div>
	<div id="messageDiv">
		<textarea rows="40" readonly id="messageArea"></textarea>
		<div id="message_bottom">
			<input type="text" name="message" placeholder="내용을 입력하세요..." id="messageBox"/>
			<input type="button" id="messageSendBtn" class="btn btn-success btn-lg" value="전송"/>
		</div>
	</div>
	</div>
</body>
</html>