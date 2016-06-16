<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	
	
	
</head>
<body>

	<!-- 상단메뉴 include -->
	<jsp:include page="jsp/adminHeader.jsp"></jsp:include>

<div id="content-area">

	<div class="container" style="padding-top: 50px;">

	<table class="table table-hover">
		<thead>
			<tr>
				<th class="col-md-1"></th>
				<th class="col-md-3">아이디</th>
				<th class="col-md-2">이름</th>
				<th class="col-md-4">가입날짜</th>
				<th class="col-md-2"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="userList" items="${requestScope.userList }" varStatus="status">
				
				<tr>
					<td>${status.count}</td>
					<td id="emailId">
						${ userList.emailId }
					</td>
					<td id="name">
						${ userList.name }
					</td>
					<td id="reg_date">
						${ userList.reg_date }
					</td>
					<td>
						<button type="button" class="btn btn-danger btn-md userDeleteBtn" value="${ userList.uId }"
							onclick="deleteUser( $(this).val() )")>삭제
							
						</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	</div>
</div>


	<script>
	
		
		function deleteUser(uId) {
			
			//alert(uId);
			window.location.href="userMgmt.do?service=DELETE&deleteId="+uId;
			
		}
		 
		
	
	</script>

</body>
</html>