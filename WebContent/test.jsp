<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style>

/* import url('http://fonts.googleapis.com/css?family=Oswald');

body {
  margin: 0;
  padding: 0;
  background-attachment: fixed;
  background-size: cover;
} */

/* @media all and ( min-width: 560px ) {
    .div_style { 
        width:100%;
    }
} */

/* #video-background {
  position: fixed;
  right: 0; 
  bottom: 0;
  min-width: 100%; 
  min-height: 100%;
  width: auto; 
  height: auto;
  z-index: -100;
}

article {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  margin: 0;
}

h1 {
  position: absolute;
  top: 60%;
  width: 100%;
  font-size: 36px;
  letter-spacing: 3px;
  color: #fff;
  font-family: Oswald, sans-serif;
  text-align: center;
} */

</style>

<title>Insert title here</title>
</head>
<body>

 <video width="320" height="240" controls>
 	 <source src="<%=request.getContextPath()%>/video/feet_background.mp4" type="video/mp4">
  </video>

<div id="all">


<!-- <h1>Video Background Snippet</h1> -->


  <%-- <div class="embed-responsive embed-responsive-16by9 div_style">
    <iframe class="embed-responsive-item" src="<%=request.getContextPath()%>/video/feet_background.mp4" style="height:800px; width:100%;" allowfullscreen="true" webkitallowfullscreen="true" mozallowfullscreen="true"></iframe>

  
  </div> --%>
  
 
</div>


<%-- <div class="container">
	
	<h1>Video Background Snippet</h1>
	
  <div class="row">
    <div class="col-xs-12 col-md-12 col-lg-12">
      <div class="embed-responsive embed-responsive-16by9">
        <video id="video-background" src="<%=request.getContextPath()%>/video/feet.mp4" autoplay controls></video>
        <iframe class="embed-responsive-item" src="<%=request.getContextPath()%>/video/feet.mp4" allowfullscreen="true"></iframe>
        
      </div>
    </div>
  </div>
</div>

	
	<video autoplay="" loop="" class="fillWidth fadeIn animated"  id="video-background">
    <source src="<%=request.getContextPath()%>/video/feet.mp4" type="video/mp4">Your browser does not support the video tag. I suggest you upgrade your browser.
</video>

</div> --%>
<!-- 
<article>
  <h1>Video Background Snippet</h1>
</article> -->


</body>
</html>