<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit LifeLog</title>
</head>


<!-- Imported sources -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	
    <script src="<%=request.getContextPath()%>/common/js/bootstrap.min.js"></script>
    <link href="<%=request.getContextPath()%>/common/css/bootstrap.min.css" rel="stylesheet">


<!-- Custom sources -->
	<%-- <script src="<%=request.getContextPath()%>/js/markerEdit.js"></script> --%>
	<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/markerEdit.css">




<body>
<div id="all">

	<input type="hidden" id="mId"
		value="${ param.m_id }">
	<input type="hidden" id="lat"
		value="${ param.lat }">
	<input type="hidden" id="lng"
		value="${ param.lng }">
	

	<div id="sideBarDiv">
		<jsp:include page="sideBar.jsp" flush="false"/>
	</div> <!-- End of sideBarDiv -->

	
	<div id="centerDiv">
		
		<div class="container-fluid">
			
			<form role="form" method="post" action="edit.do" id="form" enctype="multipart/form-data">
				
			<div class="centered text-center">
        		<img id="image" class="icon icons8-Image-File" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADQAAAA0CAYAAADFeBvrAAADgElEQVRoQ+2aTVLbMBTH/4qZdNn0BIUTkAxm3XCClhOUbGqzanICyAkCK+JuoCcoPQF0HTMJJyA5QemyM8XqyE4IsfXp2ErSqVeZiT7eT3/p6elJBLrf8GIbfyqfATRBUNetJi5HxwBu4dAuGsfsdyEf0WplEPRA0NYqa17oESTqYO/4yrxqtoYaaBAMi1FEZS5tw/XPVaVU/8uBwv4ZQNg0s/TRK7h+a5nOxEBszTxVHlKNTwC04USj3PN+eFnD0+8rgLznG74clBgoq84ETrWORutxmRGM6w6/1PFEhxKHkVspMVB27RzC9a6Xhpk1EAZU3lY+pSQKpTp0qm8KUUcbiBU0h9IHcj21RzSRT6nQrDEzqA0AMlNqQ4D0oTYIKIY6h+tLI5YNAwJAopYsTNo8IOARTtQQbeyrBGIb9GsTx/ii7Fe43hGv7uqABhdNkAqLsN+aQ9ExXH9nvYB0KRg4KqcgeLdQRbAvrk4hXaA49uMEyqUCJR32ADo9yZIRnKiTOyLnwaYji9KAEhgWOddSdki9kYlAcVlrQGH/WnK2+Q7X/2Bs/EoVCoOfHHWmJom9kTGkPYUC2X4ygettGxu/WoX+tSmXOIURZ9f/BSeqSz3dXXACRBOtFJa1Kfe8TxCWIZq6bTqCQ9sKmDYoetPZpT7eWwXKs0jC/gNAputLw3msNdDdxRFo5XJhHBTHAnv7UD51OHsXvYXrHwibW1uF+AnMhMOJdoTrzjpQkhHtAaQGh3TR+MQ8X/YbBCxyPuH+R9DBnnfG/c860GJikh/HJdDDuTNImU4xwr7XWD0Qb9SZcVvVg4XkpEydGYVo2llTSJanjqGiw3hdhMFHAOo7ING0swYU9m8A0szj7Lh1KH5g38u2ZwUoyQvcFAbzPO04eXQrQEWrMx+ZbChUOlBZ6sRQnAxp6UDlqQPw1pEFIMnRe8lVRdHFvne60ErpQEvabFz9P1B6yDRHxHik81bQtGczMqdsEAoHKvrS2ESpYlLB/RFAdl/0qz73mxhpUjYMWLLy27wKvYfrcx9QGTy8oGM4rxqFXu3rQHGPHOKrScOnMXQMija26H2hiXgeWPycjeyCgGWTFpOVkpPtmj1e0pFMfnGsfkwRZtaSTq8llRGvnVmHaqDYZdp+ZsYbD/WVPqulB8RKxq6TsDcCzZT3K0mNOOq+nz7jPNNds38B1k0RU9+x6voAAAAASUVORK5CYII=" width="80" height="80">
				<input type="file" id="file" name="file" />
    		</div>
    		<br><hr><br>
				
			
			<div class="row" style="height:350px;">

				<div class="col-sm-6 col-lg-6 col-md-6">
				
					<div class="row">
						<div class="col-sm-9 col-lg-9 col-md-9 col-sm-offset-3 col-lg-offset-3 col-md-offset-3" >
							
							<div class="panel panel-default">
					    		<div class="panel-heading">Your marker located : ( Lat : <c:out value="${ param.lat }" /> / Lng : <c:out value="${ param.lng }" /> )</div>
					    		<div class="panel-body" id = "mapScope">
				  	        		<div id="map" style="height:230px;"></div> 
				  	        	</div>
							</div>
							
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-9 col-lg-9 col-md-9 col-sm-offset-3 col-lg-offset-3 col-md-offset-3">
							<div class="panel panel-default">
					    		<div class="panel-heading">Authority</div>
					    		<div class="panel-body" id = "authorityScope">
				  	        		<label class="radio-inline"><input type="radio" name="optradio" value ="public" checked class="public">공개</label>
									<label class="radio-inline"><input type="radio" name="optradio" value ="private"class="private">비공개</label>
					   			</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="col-sm-6 col-lg-6 col-md-6">
					<div class="row">
						<div id="map" class="col-sm-9 col-lg-9 col-md-9">
							<textarea class="form-control" rows="22" placeholder="내용을 입력하세요..."></textarea>
						</div>
					</div>
					<br><br>
					<div class="row">
						<div id="map" class="col-sm-9 col-lg-9 col-md-9 text-right">
							<div id="btn">
								<button type="button" class="btn btn-success btn-lg" id= "saveBtn" value="저장">저장</button>
								<button type="button" class="btn btn-default btn-lg" id= "cancelBtn" value="취소">취소</button>
							</div>
						</div>
					</div>
					
					
				</div>
				
			</div> <!-- End of row -->
		
			
			</form> <!-- End of form -->
			
		</div> <!-- End of Container -->	
	</div> <!-- End of centerDiv -->
	
	<!-- Custom sources -->
	<script src="<%=request.getContextPath()%>/js/markerEdit.js"
		type="text/javascript" charset="utf-8"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCv59_KYHHzRqtky9EwzOJ7WY-Pb5XMGlc"
		type="text/javascript"></script>
		
</div> <!-- End of all -->
</body>
</html>