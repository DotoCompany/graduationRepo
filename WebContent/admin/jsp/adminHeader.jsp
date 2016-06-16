<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- imported sources -->

	<!-- MetisMenu CSS -->
    <link href="<%=request.getContextPath()%>/admin/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=request.getContextPath()%>/admin/metisMenu/dist/metisMenu.min.js"></script>


<!-- custom sources -->
	
	<!-- custom CSS -->
	<link href="<%=request.getContextPath()%>/admin/css/adminHeader.css" rel="stylesheet">
	
	<!-- custom JS -->
	<script src="<%=request.getContextPath()%>/admin/js/adminHeader.js"></script>
	
	<!-- Custom Fonts -->
    <link href="<%=request.getContextPath()%>/admin/fonts/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">


<div id="wrapper">
<!-- navbar 시작 -->
<!-- <nav class="navbar navbar-default" data-spy="affix" data-offset-top="47"> -->
<nav class="navbar navbar-default navbar-static-top" data-spy="affix" data-offset-top="100" role="navigation" style="margin-bottom: 0">
  <!-- <div class="container-fluid"> -->
    
    <div class="navbar-header">
    	<!-- mobile로 접속할 시에 버튼으로 바뀌는 메뉴 리스트 -->
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        	<span class="sr-only">Admin Toggle</span>
        	<span class="icon-bar"></span>
          	<span class="icon-bar"></span>
          	<span class="icon-bar"></span>                        
      	</button>
      	<a class="navbar-brand" href="<%=request.getContextPath()%>/admin/adminMain.jsp">
      		<img src="<%=request.getContextPath()%>/image/RE-CALL_gray.png" style="height: 20px;">
      	</a>
    </div>
    <!-- end of header -->
    
    <ul class="nav navbar-top-links navbar-right">
    			<li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    	<!-- fa ?? font-awesome 폰트를 import 할 경우 사용할 수 있는 icon -->
                        <i class="fa fa-info-circle fa-lg fa-fw" ></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li>
                        	<a href="<%=request.getContextPath()%>/admin"><i class="fa fa-sitemap fa-fw"></i> 사이트 맵</a>
                        </li>
                    </ul>
                    <!-- end of dropdown-user -->
                </li>
                <!-- end of dropdown -->
                
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    	<!-- fa ?? font-awesome 폰트를 import 할 경우 사용할 수 있는 icon -->
                        <i class="fa fa-user fa-lg fa-fw" ></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li>
                        	<a href="<%=request.getContextPath()%>/admin?logout=OK"><i class="fa fa-sign-out fa-fw"></i> 로그아웃</a>
                        </li>
                    </ul>
                    <!-- end of dropdown-user -->
                </li>
                <!-- end of dropdown -->
      </ul>
      <!-- end of navbar-top-links -->
            
            <div class="navbar-default sidebar" role="navigation" style="float:left;">
            	<div class="sidebar-nav navbar-collapse">
            		<ul class="nav" id="side-menu">
            			<li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                        </li>
                        
                        <li>
                            <a href="#"><i class="fa fa-users fa-fw"></i> 회원관리<!-- <span class="fa arrow"></span> --></a>
                            <ul class="nav nav-second-level"> 
                            <!-- nav-second-level ? ul li 아래에 또 다른 ul il 가 달려 있을때,  -->
                                <li>
                                	<button type="button" class="btn btn-link marketTotBtn" <%-- href="<%=request.getContextPath()%>/adminMain?service=member" --%> style="color: #333333;">회원 전체보기</button>
                                    <%-- <a href="<%=request.getContextPath()%>/adminMain?service=member" style="color: black;">회원 전체보기</a> --%>
                                </li>
                            </ul>
                            <!-- end of nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bold fa-fw"></i> 블로그관리<!-- <span class="fa arrow"></span> --></a>
                            <ul class="nav nav-second-level">
                                <li>
                                	<button type="button" class="btn btn-link marketTotBtn" <%-- href="<%=request.getContextPath()%>/adminMain?service=blog" --%> style="color: #333333;" disabled>블로그 전체보기</button>
                                    <%-- <a href="<%=request.getContextPath()%>/adminMain?service=blog" style="color: black;">블로그 전체보기</a> --%>
                                </li>
                            </ul>
                            <!-- end of nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bell fa-fw"></i> 신고관리<!-- <span class="fa arrow"></span> --></a>
                            <ul class="nav nav-second-level">
                                <li>
                                	<button type="button" class="btn btn-link marketTotBtn" <%-- href="<%=request.getContextPath()%>/adminMain?service=report" --%> style="color: #333333;" disabled>신고 전체보기</button>
                                    <%-- <a href="<%=request.getContextPath()%>/adminMain?service=report" style="color: black;">신고 전체보기</a> --%>
                                </li>
                            </ul>
                            <!-- end of nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 통계<!-- <span class="fa arrow"></span> --></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <%-- <a href="<%=request.getContextPath()%>/adminStats?service=marketTotStats" style="font-size: 1.2em;" disabled>마켓 전체 통계</a> --%>
                                    <form action="<%=request.getContextPath()%>/adminStats" id="marketTotFm" method="post">
                                    	<button type="button" class="btn btn-link marketTotBtn" href="<%=request.getContextPath()%>/adminStats" style="color: #333333;">회원 전체 통계</button>
                                    </form> 
                                </li>
                                <li>
                                	<button type="button" class="btn btn-link" disabled>블로그 전체 통계</button> 
                                    <%-- <a href="<%=request.getContextPath()%>/adminStats?service=marketVisitorTotStats">마켓 방문자별 통계</a> --%>
                                </li>
                                <li>
                                	<button type="button" class="btn btn-link" disabled>게시글 전체 통계</button> 
                                    <%-- <a href="<%=request.getContextPath()%>/adminStats?service=marketCategoryStats">마켓 종류별 통계</a> --%>
                                </li>
                            </ul>
                            <!-- end of nav-second-level -->
                        </li>
                       
            		</ul>
            	</div>
            </div>
            
</nav>    

</div>
