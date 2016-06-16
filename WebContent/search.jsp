<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-zType" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="<%=request.getContextPath()%>/common/js/jquery-1.12.3.js"></script>
<script type="text/javascript">
function requestFriend(uId) {
	$.ajax({
		type:"post",
		
		data : {toUserCode : uId},
		url: "reqFriend.do",
		success : function(data) {
			alert(data);	
		}
	});
}
window.onload= function(){
	$("#searchBtn").click(function(){
		$.ajax({
			type:"post",
			data: { searchBox : $("#searchBox").val() },
			url: "search.do",
			success :function(data) {
				$("#userList").html(data);
			}
		});
	});
};
</script>
<input type="text" name="searchBox" id="searchBox"/>
<input type="button" name="searchBtn" id="searchBtn" value="검색"/>
<div id="userList"></div>
</body>
</html>