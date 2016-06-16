<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	
    <script src="<%=request.getContextPath()%>/common/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    

	<link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  	<link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">

<style>
body {
margin-left:80px;
}
img {
	width:300px;
	height:240px;
	margin:30px;
}
#photoDiv{
	
	margin-left:10%;
	
}
#photoArea {
	
}
#titlebar {
	text-align: center;
}
</style>

<title>RE:Call - Photo</title>

</head>
<script type="text/javascript">
window.onload=function(){
	$.ajax({
		type:"post",
		url:"lifelogget.do",
		success: function(data){
			$("#photoArea").html(data);
		}
	});
}
</script>
<body>
<jsp:include page="sideBar.jsp" flush="false"/>
<h1 id="titlebar">RECALL-Photo</h1>
<div id="photoDiv">
	<div id="photoArea">
	</div>
</div>


</body>
</html>