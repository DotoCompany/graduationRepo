<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>'Fleax 관리자모드'</title>
	
	<!-- imported sources -->
   	
   	<!-- jQuery -->
	<script src="<%=request.getContextPath()%>/admin/js/jquery-1.11.3.js"></script>
    <!-- Bootstrap Core CSS -->	
    <link href="<%=request.getContextPath()%>/admin/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()%>/admin/js/bootstrap.min.js"></script>
    <!-- masonry -->
	<script src="<%=request.getContextPath()%>/admin/js/masonry.pkgd.min.js"></script>
	
	
	<!-- custom sources -->
	
	<!-- custom CSS -->
	<%-- <link href="<%=request.getContextPath()%>/admin/css/adminStats.css" rel="stylesheet"> --%>
	
	<!-- custom JS -->
	<script src="<%=request.getContextPath()%>/admin/js/adminStats.js"></script>
	
</head>
<body>

	<jsp:include page="../jsp/adminHeader.jsp"></jsp:include>
	
	<!-- 내용 영역 -->
	<%-- 내용 영역은 id="content-area" 으로 통일해야 함. 
	이유는  "/admin/css/adminHeader.css"  31Line 확인 --%>
	<div id="content-area">
	
		<%-- style="padding-top: 50px;" 에 주의!!! --%>
		<div class="container-fluid" style="padding-top: 50px;">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					
					<!-- Ajax 가 적용돼야 하는 영역 -->
					
					<div id="marketTotStats"></div>
					<div id="marketVisitorTotStats"></div>
					<div id="marketCategoryStats"></div>
  					
				</div>
			</div>
		</div>
		
	</div>

</body>
</html>