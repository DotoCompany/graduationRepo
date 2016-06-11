<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<script>


</script>


<style>


body {
	margin: 0;
	padding: 0;
  
	font-family: "Oxygen", sans-serif;
}
.header-unit {
  height: 500px;
  border-right:none;
  border-left: none;
  position: relative;
}
#video-container {
	position: absolute;
	top:0%;
	left:0%;
	height:100%;
	width:100%;
	overflow: hidden;
}
video {
	position:absolute;
	z-index:0;
}
video.fillWidth {
	width: 100%;
}




#container .content {
	position: absolute;
	top: 0;
	left: 0;
	z-index:2;
}

</style>

<title>Insert title here</title>
</head>
<body>


  <div class="header-unit">
<div id="video-container">
<video autoplay loop class="fillWidth">
<source src="<%=request.getContextPath()%>/video/feet_bg.mp4" type="video/mp4"/>
</video>

<div class="content">
		<img class="videoContent_heading" src="<%=request.getContextPath()%>/image/logo_white.png"
				alt="Recall Logo" height="120" width="120">
				
				
	<h1 class="videoContent_teaser">RE:Call, the Special service for you.</h1>
	</div>
</div><!-- end video-container -->
</div><!-- end .header-unit -->






<%-- <div id=”Container”>
<div id=”Video”>


		<video autoplay loop >
            <source id="mp4" src="<%=request.getContextPath()%>/video/feet_bg.mp4" type="video/mp4"/>
            
        </video>
<div id=”Message”>
<h1>Your text to display</h1>
</div>
</div>
</div>

<div style="background-color:blue;">
AAAAAAAAAAAAA
</div> --%>

<%-- <div id="all">
	<div class='vidContain'>
    <div class='vid'>
        <video autoplay loop style="width:100%; height:100%">
            <source id="mp4" src="<%=request.getContextPath()%>/video/feet_bg.mp4" type="video/mp4"/>
            
        </video>
        <!-- <div class='content'>
            I'm content!! :D 
        </div> -->
    </div>
	</div>
</div> --%>
	
	

</body>
</html>