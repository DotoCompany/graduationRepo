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
  	

<!-- Customized sources -->
	<link href="<%=request.getContextPath()%>/css/intro.css" rel="stylesheet">

<%
	if(request.getSession().getAttribute("userCode")!=null)
		response.sendRedirect("main.jsp");
%>


<title>RE:Call</title>
</head>



<body>


	<div id="all">

		<div >

			<div id="videoDiv" class="container-fluid">

				<div class="videoContent">
					<img class="videoContent_heading"
						src="<%=request.getContextPath()%>/image/logo_white.png"
						alt="Recall Logo" height="120" width="120">


					<h1 class="videoContent_teaser">RE:Call, the Special service
						for you.</h1>
				</div><!-- End of videoContent -->

				<video id="bg-video" class="video" width="100%" autoplay loop>
					<source src="<%=request.getContextPath()%>/video/feet_bg.mp4"
						type="video/mp4">
				</video>
			</div><!-- End of videoDiv -->

			<div id="homeDiv" class="container-fluid" >
				
				<div class="row">
					<div class="col-sm-5">
						<h1 class="homeDiv_h1" style="margin-bottom: -10px;">Look back</h1>
						<h1 class="homeDiv_h1">upon your life</h1>
						
						<h4 class="homeDiv_h4">Arrange your beautiful day with Recall, the Lifelog! </h4>
						<a id="home-btn" class="red-btn" href="<%=request.getContextPath()%>/login.jsp">H O M E</a>
					</div>
					<div class="col-sm-7">
					</div>
				</div>
			</div>


			<div id="appDiv" class="container-fluid" >
				<h1 class="addDiv-h1">Recall App for Android & iPhone</h1>
				<br><br><br><br>
				
				<img 
						src="<%=request.getContextPath()%>/image/android_w.png"
						alt="Android App" width="250" style="float:left; margin-left:240px;">
						
				<img 
						src="<%=request.getContextPath()%>/image/iphone_w.png"
						alt="iPhone App" width="250" style="float:right; margin-right:240px;">
				
				<!-- <a class="red-btn" href="#">J O I N</a> -->
			</div>

			<div id="contactDiv">
				<h2 class="text-center">CONTACT</h2>
				<br>
				<div class="row">
					<div class="col-sm-5">
						<p>Contact us and we'll get back to you within 24 hours.</p>
						<br>
						<p>
							<span class="glyphicon glyphicon-map-marker"></span> Dankook Univ, Republic Of Korea
						</p>
						<p>
							<span class="glyphicon glyphicon-phone"></span> +82 10-9998-2666
						</p>
						<p>
							<span class="glyphicon glyphicon-envelope"></span>
							 doto_recall@gmail.com
						</p>
						
					</div>
					<div class="col-sm-7 slideanim">
						<div class="row">
							<div class="col-sm-6 form-group">
								<input class="form-control" id="name" name="name"
									placeholder="Name" type="text" required>
							</div>
							<div class="col-sm-6 form-group">
								<input class="form-control" id="email" name="email"
									placeholder="Email" type="email" required>
							</div>
						</div>
						<textarea class="form-control" id="comments" name="comments"
							placeholder="Comment" rows="5"></textarea>
						<br>
						<div class="row">
							<div class="col-sm-12 form-group">
								<button class="btn btn-default pull-right" type="submit">Send</button>
							</div>
						</div>
					</div>
				</div>
			</div><!-- End of ContactDiv -->

			<div id="mapDiv"></div>

		</div><!-- End of container-fluid -->


		<footer class="container-fluid">
			<div id="footer">
				<a href="<%=request.getContextPath()%>/login.jsp">Home</a> <span>
					| </span> <a href="#">Blog</a> <span>
					| </span> <a href="<%=request.getContextPath()%>/policy.jsp">Policy</a> <span>
					| </span> <a href="#">FAQ</a>
			</div>
		</footer><!-- End of footer -->


		<!-- Custom sources -->
		<script src="<%=request.getContextPath()%>/js/intro.js"
			type="text/javascript" charset="utf-8"></script>
		<script
			src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCv59_KYHHzRqtky9EwzOJ7WY-Pb5XMGlc"
			type="text/javascript"></script>


	</div><!-- End of all -->
</body>
</html>