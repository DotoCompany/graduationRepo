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
			
			<form role="form" method="post" action="edit.do?service=MODIFY" id="form" enctype="multipart/form-data">
				
				<input type="hidden" id="llId" name="llId" 
					value="${ param.llId }">
				<input type="hidden" id="lat" name="lat" 
					value="${ param.lat }">
				<input type="hidden" id="lng" name="lng" 
					value="${ param.lng }">
				<input type="hidden" id="url" name="url" 
					value="${ param.url }">
				<input type="hidden" id="body" name="body" 
					value="${ param.body }">
				<input type="hidden" id="isPublic" name="isPublic"
					value="${ param.isPublic }">
				
				
			<div class="centered text-center">
				<img id="image" src="${ param.url }">
				<input type="file" id="file" name="file" />
    		</div>
    		<br><hr><br>
				
			
			<div class="row" style="height:350px;">

				<div class="col-sm-6 col-lg-6 col-md-6">
				
					<div class="row">
						<div class="col-sm-9 col-lg-9 col-md-9 col-sm-offset-3 col-lg-offset-3 col-md-offset-3" >
							
							<div class="panel panel-default">
					    		<div class="panel-heading">Your marker located : <br>( Lat : <c:out value="${ lat }" /> / Lng : <c:out value="${ lng }" /> )</div>
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
							<textarea id="modifyBody" name="modifyBody" class="form-control" rows="22" placeholder="내용을 입력하세요..." > ${ body }</textarea>
						</div>
					</div>
					<br><br>
					<div class="row">
						<div id="map" class="col-sm-9 col-lg-9 col-md-9 text-right">
						
							<div id="btn">
									<button type="button" class="btn btn-danger btn-lg" id= "cancelBtn" value="취소">취소</button>
									<button type="button" class="btn btn-success btn-lg" id= "modifyBtn" value="수정">수정</button>
    								
							</div>
							
							
						</div>
					</div>
					
					
				</div>
				
			</div> <!-- End of row -->
		
			
			</form> <!-- End of form -->
			
		</div> <!-- End of Container -->	
	</div> <!-- End of centerDiv -->
	
	<!-- Custom sources -->
	<script src="<%=request.getContextPath()%>/js/markerModify.js"
		type="text/javascript" charset="utf-8"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCv59_KYHHzRqtky9EwzOJ7WY-Pb5XMGlc"
		type="text/javascript"></script>
		
</div> <!-- End of all -->
</body>
</html>