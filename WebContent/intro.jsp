<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<%
	if(request.getSession().getAttribute("userCode")!=null)
		response.sendRedirect("main.jsp");
%>


<style>
body {
	width: 100%;
	margin: 0;
	padding: 0;
	font-family: "Oxygen", sans-serif;
}

#videoDiv {
	
}

#bg-video {
	position: relative;
	z-index: -1;
	right: 0;
	bottom: 0;
	min-width: 100%;
	min-height: 100%;
	width: auto;
	transform: translateY(-38vh);
}

.videoContent {
	position: relative;
	top: 30%;
	z-index: 2;
	margin: 0 auto;
	max-width: 720px;
	text-align: center;
}

.videoContent_heading {
	margin-bottom: 24px;
	color: rgb(39, 39, 39);
	font-size: 44px;
}

.videoContent_teaser {
	margin-bottom: 24px;
	width: 100%;
	font-size: 36px;
	letter-spacing: 3px;
	color: #fff;
	font-family: Oswald, sans-serif;
	text-align: center;
}

.content__cta {
	display: inline-block;
	margin: 0;
	padding: 12px 48px;
	color: rgb(255, 60, 100);
	font-size: 22px;
	text-decoration: none;
	border: solid 4px rgb(255, 60, 100);
}

#contactDiv{
	width: 100%;
	background-color: #ccc;
	
	padding: 20px 50px;
}

#mapDiv{
	width: 100%;
	height: 450px;
}


footer {
	margin: 20px 0;
	background-color: white;
	color: #57524C;
}

#footer {
	text-align: center;
}

#footer a{
	color: #57524C;
	font-weight: bold;
}

#footer span{
	margin: 0 10px;
	font-size: 120%;
}

</style>

<title>RE:Call</title>
</head>

<!-- Imported sources -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	
    <script src="<%=request.getContextPath()%>/common/js/bootstrap.min.js"></script>
    <link href="<%=request.getContextPath()%>/common/css/bootstrap.min.css" rel="stylesheet">

<body>


	<div id="all">

		<div class="container-fluid" style="padding: 0;">

			<div id="videoDiv"
				style="width: 100%; height: 550px; overflow: hidden;">

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

			<div>
				<h1>a</h1>
				<h1>a</h1>
				<h1>a</h1>
				<h1>a</h1>
				<h1>a</h1>
				<h1>a</h1>
				<h1>a</h1>
				<h1>a</h1>
				<h1>a</h1>
				<h1>a</h1>
				<h1>a</h1>
			</div>

			<div id="secondDiv"></div>

			<div id="contactDiv">
				<h2 class="text-center">CONTACT</h2>
				<br>
				<div class="row">
					<div class="col-sm-5">
						<p>Contact us and we'll get back to you within 24 hours.</p>
						<p>
							<span class="glyphicon glyphicon-map-marker"></span> Chicago, US
						</p>
						<p>
							<span class="glyphicon glyphicon-phone"></span> +00 1515151515
						</p>
						<p>
							<span class="glyphicon glyphicon-envelope"></span>
							myemail@something.com
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
					| </span> <a href="<%=request.getContextPath()%>/policy.jsp">Policy</a> <span>
					| </span> <a href="<%=request.getContextPath()%>/login.jsp">Home</a>
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