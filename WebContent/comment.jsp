<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<script>
window.onload=function(){
	commentGet();
	
	function commentGet(){
		$.ajax({
			url:"commentget.do",
			data: { lifeLogCode : '1'} ,
			type:"post",
			success: function(data) {
				$("#commentDiv").html(data);
			}
		});	
	}
	$("#commentBtn").click(function(){
		$.ajax({
			url:"commentAdd.do",
			data: { commentText : $("#commentText").val() , llId : $("#llId").val()},
			type:"post",
			success: function(data) {
				commentGet();
				
			}
		});
	});
}
</script>
<div id="commentDiv"></div>
<input type="text" name="commentText" id="commentText" />
<input type="button" value="확인" id="commentBtn"/>

</body>
</html>