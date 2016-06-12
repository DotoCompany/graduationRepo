<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Imported sources -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	
    <script src="<%=request.getContextPath()%>/common/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <%-- <link href="<%=request.getContextPath()%>/common/css/bootstrap.min.css" rel="stylesheet"> --%>

	<link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  	<link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">

<style>
body {
	padding: 0;
	background-color: #f6f6f6;
	font: 400 15px Lato, sans-serif;
    line-height: 1.8;
    color: #818181;
}

#all {

	width: 70%;
	margin: 0 auto;
	padding-left: 80px;
}

.bg-grey {
	background-color: #f6f6f6;
}


.thumbnail {
	margin: 15px 0;
	padding: 0 0 0 0;
	border: none;
	border-radius: 0;
}

.thumbnail img {
	width: 100%;
	height: 230px;
	
}


@media screen and (max-width: 1024px) {

    .thumbnail img {
	width: 100%;
	height: 450px;
	
}


@media screen and (max-width: 768px) {

    .thumbnail img {
	width: 100%;
	height: 350px;
	
}


}
  @media screen and (max-width: 480px) {
   .thumbnail img {
	width: 100%;
	height: 150px;
	
}
  }

</style>

<title>RE:Call - Photo</title>

</head>
<body>


<div id="sideBarDiv">
		<jsp:include page="sideBar.jsp" flush="false"/>
	</div> <!-- End of sideBarDiv -->

<div id="all">

<div id="portfolio" class="container-fluid text-center bg-grey">
  <h2>Recall</h2><br>
  <!-- <h4>What we have created</h4> -->
  <div class="row text-center slideanim">
    <div class="col-sm-4">
      <div class="thumbnail">
        <img src="<%=request.getContextPath()%>/image/paris.jpg" alt="Paris" width="400" height="300">
        <!-- <p><strong>Paris</strong></p>
        <p>Yes, we built Paris</p> -->
      </div>
    </div>
    <div class="col-sm-4">
      <div class="thumbnail">
        <img src="<%=request.getContextPath()%>/image/newyork.jpg" alt="New York" width="400" height="300">
        <!-- <p><strong>New York</strong></p>
        <p>We built New York</p> -->
      </div>
    </div>
    <div class="col-sm-4">
      <div class="thumbnail">
        <img src="<%=request.getContextPath()%>/image/sanfran.jpg" alt="San Francisco" width="400" height="300">
        <!-- <p><strong>San Francisco</strong></p>
        <p>Yes, San Fran is ours</p> -->
      </div>
    </div>
    <div class="col-sm-4">
      <div class="thumbnail">
        <img src="<%=request.getContextPath()%>/image/logo_black.png" alt="San Francisco" width="400" height="300">
      </div>
    </div>
    <div class="col-sm-4">
      <div class="thumbnail">
        <img src="<%=request.getContextPath()%>/image/android_w.png" alt="San Francisco" width="400" height="300">
      </div>
    </div>
    <div class="col-sm-4">
      <div class="thumbnail">
        <img src="<%=request.getContextPath()%>/image/iphone_w.png" alt="San Francisco" width="400" height="300">
      </div>
    </div>
    
  </div><br>
  </div>


</div>

</body>
</html>