<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>RECALL 관리자로그인</title>
	<!--  푸쉬 주석  -->
	
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
	<link href="<%=request.getContextPath()%>/admin/css/login.css" rel="stylesheet">
	
	<!-- custom JS -->
	<script src="<%=request.getContextPath()%>/admin/js/login.js"></script>
	
	<!-- Custom Fonts -->
    <link href="<%=request.getContextPath()%>/admin/fonts/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>
<body>

<div id=all>

	<div class="container-fluid">

		<div class="row">
            <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 col-lg-offset-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
						<h4>RECALL 관리자 모드</h4>
					</div>
                    <div class="panel-body">
                        <form action="<%=request.getContextPath()%>/adminLogin.do" id="loginFm" method="post">
                            <fieldset>
                                <div class="form-group">
                                	<input type="text" class="form-control" id="adminId" name="adminId" placeholder="Enter id" autofocus>
                                </div>
                                <div class="form-group">
                                	<input type="password" class="form-control" id="adminPwd" name="adminPwd" placeholder="Enter password">
                                </div>
                                
                                <button type="button" id="loginBtn" class="btn btn-lg btn-success btn-block">로그인</button>
                            </fieldset>
                        </form>
                    </div>
                    <div class="panel-footer" style="text-align:right;">
                    	<label style="color:#CECECE; font-size:10px;">Copyright ⓒ Recall All Rights Reserved.</label>
  					</div>
                </div>
            </div>
        </div>
	
	</div>

</div>

</body>
</html>