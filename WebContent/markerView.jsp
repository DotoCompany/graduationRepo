<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View LifeLog</title>
</head>


<!-- Imported sources -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	
    <script src="<%=request.getContextPath()%>/common/js/bootstrap.min.js"></script>
    <link href="<%=request.getContextPath()%>/common/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom sources -->
	<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/markerView.css">


<body>
<div id="all">

	
	

	<div id="sideBarDiv">
		<jsp:include page="sideBar.jsp" flush="false"/>
	</div> <!-- End of sideBarDiv -->

	
	<div id="centerDiv">
		
		<div class="container-fluid">
			
			<form role="form" method="post" action="<%=request.getContextPath()%>/edit.do?service=ToMODIFY" id="form" enctype="multipart/form-data">
				
				<input type="hidden" id="llId" name="llId" 
					value="${ lifeLogViewDTO.llId }">
				<input type="hidden" id="lat" name="lat" 
					value="${ lifeLogViewDTO.lat }">
				<input type="hidden" id="lng" name="lng" 
					value="${ lifeLogViewDTO.lng }">
				<input type="hidden" id="url" name="url" 
					value="${ lifeLogViewDTO.url }">
				<input type="hidden" id="body" name="body" 
					value="${ lifeLogViewDTO.body }">
				<input type="hidden" id="isPublic" name="isPublic"
					value="${ lifeLogViewDTO.isPublic }">
				
				
			<div class="centered text-center">
				<img id="image" src="${lifeLogViewDTO.url }">
    		</div>
    		<br><hr><br>
				
			
			<div class="row" style="height:350px;">

				<div class="col-sm-6 col-lg-6 col-md-6">
				
					<div class="row">
						<div class="col-sm-9 col-lg-9 col-md-9 col-sm-offset-3 col-lg-offset-3 col-md-offset-3" >
							
							<div class="panel panel-default">
					    		<div class="panel-heading">Your marker located : <br>( Lat : <c:out value="${ lifeLogViewDTO.lat }" /> / Lng : <c:out value="${ lifeLogViewDTO.lng }" /> )</div>
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
				  	        		<label class="radio-inline"><input type="radio" name="optradio" value ="public" checked class="public" disabled>공개</label>
									<label class="radio-inline"><input type="radio" name="optradio" value ="private"class="private" disabled>비공개</label>
					   			</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="col-sm-6 col-lg-6 col-md-6">
					<div class="row">
						<div id="map" class="col-sm-9 col-lg-9 col-md-9">
							<textarea name="body" class="form-control" rows="22" placeholder="내용을 입력하세요..." disabled>${lifeLogViewDTO.body }</textarea>
						</div>
					</div>
					<br><br>
					<div class="row">
						<div id="map" class="col-sm-9 col-lg-9 col-md-9 text-right">
						
							<div id="btn">
							
								<c:set var="userId" value="${lifeLogViewDTO.uId}" />
								<c:set var="sessionId" value="${userCode}" />
					
								<c:if test="${userId == sessionId}">
    								<button type="button" class="btn btn-danger btn-lg" id= "deleteBtn" value="삭제">삭제</button>
    								<button type="button" class="btn btn-success btn-lg" id= "modifyBtn" value="수정">수정</button>
								</c:if>
								
							</div>
							
							
						</div>
					</div>
					
					
				</div>
				
			</div> <!-- End of row -->
		
			
			</form> <!-- End of form -->
			
		</div> <!-- End of Container -->	
	</div> <!-- End of centerDiv -->
	
	<!-- Custom sources -->
	<script src="<%=request.getContextPath()%>/js/markerView.js"
		type="text/javascript" charset="utf-8"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCv59_KYHHzRqtky9EwzOJ7WY-Pb5XMGlc"
		type="text/javascript"></script>
		
</div> <!-- End of all -->
</body>
</html>