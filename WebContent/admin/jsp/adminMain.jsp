<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
	<title>'RECALL 관리자모드'</title>
	
<!-- imported sources -->
   	
   	<!-- jQuery -->
	<script src="<%=request.getContextPath()%>/common/js/jquery-1.12.3.js"></script>
    <!-- Bootstrap Core CSS -->	
    <link href="<%=request.getContextPath()%>/common/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()%>/common/js/bootstrap.min.js"></script>
    <!-- masonry -->
	<script src="<%=request.getContextPath()%>/admin/js/masonry.pkgd.min.js"></script>
	
	
<!-- custom sources -->
	
	<!-- custom CSS -->
	<link href="<%=request.getContextPath()%>/admin/css/adminMain.css" rel="stylesheet">
	
	
	<!-- custom JS -->
	<script src="<%=request.getContextPath()%>/admin/js/adminMain.js"></script>
	
</head>
<body>

	<!-- 상단메뉴 include -->
	<jsp:include page="../jsp/adminHeader.jsp"></jsp:include>
	

<!-- 내용 영역 -->
<%-- 내용 영역은 id="content-area" 으로 통일해야 함. 
이유는  "/admin/css/adminHeader.css"  31Line 확인 --%>
<div id="content-area">
	
	<!-- adminMain 시작 -->
	<%-- style="padding-top: 50px;" 에 주의!!! --%>
	
	<div class="container-fluid" style="padding-top: 50px;">
		
		
		
		<%-- <div id="resultPrnArea"> 
		
			<!-- desktop : col-4 offset-2 / mobile : col-12 -->
			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-2">
				<div class="panel panel-default">
				
					<div class="panel-heading">
						<a href="<%=request.getContextPath()%>/adminMain?service=member" class="btn btn-link btn-lg">회원관리</a>
					</div>
					<div class="panel-body">
						<!-- href 속성에, 회원 관리 서비스 연결 -->
						<a href="#" class="btn btn-link btn-lg">회원 전체보기</a>
					</div>
				</div>
			</div>
		
			<!-- desktop : col-4 / mobile : col-12 -->
			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
				<div class="panel panel-default">
				
					<div class="panel-heading">
						<a href="<%=request.getContextPath()%>/adminMain?service=blog" class="btn btn-link btn-lg">블로그관리</a>
					</div>
					<div class="panel-body">
						<!-- href 속성에, 블로그 관리 서비스 연결 -->
						<a href="#" class="btn btn-link btn-lg">블로그 전체보기</a> 
					</div>
				</div>
			</div>
	
			<!-- desktop : col-4 offset-2 / mobile : col-12 -->
			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-2">
				<div class="panel panel-default">
		
					<div class="panel-heading">
						<a href="<%=request.getContextPath()%>/adminMain?service=report" class="btn btn-link btn-lg">신고관리</a>
					</div>
					<div class="panel-body">
						<!-- href 속성에, 신고 관리 서비스 연결 -->
						<a href="#" class="btn btn-link btn-lg">신고내역 전체보기</a>
					</div>
				</div>
			</div>

			<!-- desktop : col-4 / mobile : col-12 -->
			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
				<div class="panel panel-default">
				
					<div class="panel-heading">
						<button type="button" class="btn btn-link marketTotBtn" style="font-size:20px;">통 계</button>
						<a href="<%=request.getContextPath()%>/adminMain?service=stats" class="btn btn-link btn-lg">통 계</a>
					</div>
					<div class="panel-body">
						<div class="panel panel-default">
							<div class="panel-heading">
								마켓 분석
							</div>
							<div class="panel-body">
								<a href="<%=request.getContextPath()%>/adminStats?service=marketTotStats" class="btn btn-link btn-lg marketTotBtn">마켓 전체 통계</a>
								
								<button type="button" class="btn btn-link marketTotBtn">마켓 전체 통계</button>
								<a href="<%=request.getContextPath()%>/adminStats?service=marketVisitorTotStats" class="btn btn-link btn-lg" disabled>마켓 방문자 통계</a>
								<a href="<%=request.getContextPath()%>/adminStats?service=marketCategoryStats" class="btn btn-link btn-lg" disabled>마켓 종류별 통계</a>
								<button type="button" class="btn btn-link" disabled>마켓 방문자별 통계</button> 
								<button type="button" class="btn btn-link" disabled>마켓 종류별 통계</button> 
							</div>
						</div>
						
					</div>
				</div>
			</div>
			
		</div>
		<!-- end of marketTotStats -->
		 --%>
		
	</div>
	<!-- <div class="container-fluid"> 
		
	</div> -->
	<!-- end of adminMain -->
	
	
<!-- 	<h1>aa</h1><h1>aa</h1><h1>aa</h1><h1>aa</h1>
	<h1>aa</h1><h1>aa</h1><h1>aa</h1>
	<h1>aa</h1><h1>aa</h1><h1>aa</h1>
	<h1>aa</h1><h1>aa</h1><h1>aa</h1><h1>aa</h1> -->

</div>
<!-- page -->

</body>
</html>