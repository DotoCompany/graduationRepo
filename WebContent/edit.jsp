<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit LifeLog</title>
</head>
<style>
* {
	margin: 0 auto;
}
#locationInfo {
	text-align: center;
}
#image {
	max-width: 500px;
	max-height: 375px;
	display: block;
}
#texarea{
	width:50%;
	height:300px;
	margin-left:25%;
	margin-right:25%;
	margin-top:2%;
}
#btn {
	
	margin-left:46.5%;
	margin-top: 2%;
}
.btn {
 text-align:center;
 position: relative;
}
#file {
	display: none;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#image").click(function(){
		$("#file").trigger("click");
		
	});
	$("#file").change(function(){
		var reader = new FileReader();
		reader.onload = function (e) {
			$("#image").attr("src",e.target.result);
		};
		reader.readAsDataURL(this.files[0]);
	});
	$("#saveBtn").click(function(){
		if($("#file").val()=="" || $("#file").val()=="logo.png") {
			alert("이미지를 등록해 주세요!");
			return;
		}
		$("#form").submit();
	});
});

</script>
<body>
	<div id="locationInfo">
		<span id="lat"> Lat : 127.012643523</span> <span id="lon"> Lon : 36.8123649</span>
	</div>
	<form method="post" action="edit.do" id="form" enctype="multipart/form-data">
		<img id="image" src="image/logo.png" >
		<input type="file" id="file" name="file" />
		<textarea id="texarea" cols="100" rows="20" ></textarea>
		<div id="btn">
			<input type="button" id="saveBtn" class="btn" value="저장"/>
			<input type="button" id="cancelBtn" class="btn" value="취소"/>
		</div>
	</form>
</body>
</html>