<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset=UTF-8">
		
	<!-- imported sources -->
   	
   	<!-- jQuery -->
	<script src="<%=request.getContextPath()%>/common/js/jquery-1.11.3.js"></script>
    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath()%>/common/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()%>/common/js/bootstrap.min.js" ></script>
		
	<style>
	
		.all {
			margin: 0 auto;
			width: 80%;
		}
		
	</style>	
	
	<style>
	   #all{
	      width:80%;
	      margin:0 auto;
	   }
	   /*
	   .container{
	      margin:0 auto;
	   }*/
	   
	   .loginContentDiv{
	      border-bottom: 2px solid #ddd;
	       padding-bottom: 5em;
	   }
	   
	   #signUpBtn {
	       min-width: 80px;
	       max-width: 80px;
	   }
	   
	   #loginInFrame{
	      text-align: center;
	   }
	   
	   #loginDes{
	      float:right;
	   }
	   
	   #facebookLoginBtn{
	      width: 100%;
	   }
	   
	   .tab-content {
	       padding-top: 5em;
	   }
	   
	   #loginBottomDiv{
	      text-align: center;
	   }
	   
	   #imageDiv{
        /*    float : left; */
	   }
	   #contentDiv{
/* 	   float : right; */
	   }
	   
	   
	   .loginMainScope{
/* 	    text-align : center; */
	   }
	   
	   #loginMainImg{
	   width:100%;
	   height:280px;
	   }
	   
	   
	</style>
		
		
	<title>Login</title>
</head>

<!-- <body>

	<div class="all">
		<div class="container-fluid">
			

			
			<div id="loginContent">
				<form id="loginForm" role="form">
				<div class="row form-group">
			
					<div class="col-md-6">
						<input type="text">
					</div>
					<div class="col-md-6">
						<input type="password">
					</div>
					
				</div>
				</form>
			</div>
			
		</div>
	</div>

</body> -->


<body>
	<div class="container">
		<div id="all">

		   <div  class = "jumbotron" id = "loginMain">
		       	<div class="row">
		       		<div class="col-md-12 loginMainScope">
		       		    <div class="col-md-4">
		       				<img src = "<%=request.getContextPath()%>/images/mainPage/image/mainLogo.png" id ="loginMainImg">
		       			</div>
		       			
		       			    <div class="col-md-8">
		       			    <br><br><br>
		       				<div class="row">
		       					<div class="col-md-12 loginMainScope">
		       						<h1>Fleax!</h1>
		       					</div>
		       					</div>
		       					
		       					<div class="row">
		       					<div class="col-md-12 loginMainScope">
		       						<p>로그인하세요</p> 
		       					</div>
		       				</div>
		       				</div>
		       	  </div>
		       			
		       			
		       			
		       				       	
		       	</div>

		     <!--   	<div class="row"> -->
		       	
		  <!--      		<div class="col-md-12">
		       				<div class="row">
		       					<div class="col-md-12 loginMainScope">
		       						<h1>Fleax!</h1>
		       					</div>
		       					</div>
		       					
		       					<div class="row">
		       					<div class="col-md-12 loginMainScope">
		       						<p>로그인하세요</p> 
		       					</div>
		       				</div>
		       	  </div> -->

		   <!--  </div> -->
		</div>
		   
		   <ul class="nav nav-tabs">
		      <li class="active"><a data-toggle="tab" href="#attendantLogin" id ="selectedMU">로그인 하기</a></li>
		    <!--   <li><a data-toggle="tab" href="#hostLogin" id = "selectedMM">플리마켓 주최</a></li> -->
		   </ul>
		   
		   
		   <div class="row">
		  <!--  <div class="col-md-12">
		   <div id="loginDes">
		      <button type="button" class="btn btn-link btn-xs" data-toggle="modal" data-target="#hostInfoModal">플리마켓 주최란 ?</button><br>
		      <button type="button" class="btn btn-link btn-xs" data-toggle="modal" data-target="#attendantInfoModal">일반사용자란 ?</button>
		   </div>
		   </div> -->
		   
		   <!-- start of Modal -->
		      <!-- <div class="modal fade" id="hostInfoModal" role="dialog">
		            <div class="modal-dialog">
		
		               Modal content
		               <div class="modal-content">
		                  <div class="modal-header">
		                     <button type="button" class="close" data-dismiss="modal">&times;</button>
		                     <h4 class="modal-title">플리마켓 주최</h4>
		                  </div>
		                  <div class="modal-body">
		                     <p>플리마켓 주최는 주최다.</p>
		                  </div>
		                  <div class="modal-footer">
		                     <button type="button" class="btn btn-default"
		                        data-dismiss="modal">Close</button>
		                  </div>
		               </div>
		
		            </div>	
		      </div>
		      <div class="modal fade" id="attendantInfoModal" role="dialog">
		            <div class="modal-dialog">
		
		               Modal content
		               <div class="modal-content">
		                  <div class="modal-header">
		                     <button type="button" class="close" 	data-dismiss="modal">&times;</button>
		                     <h4 class="modal-title">일반사용자</h4>
		                  </div>
		                  <div class="modal-body">
		                     <p>일반사용자는 일반사용자 이다.</p>
		                  </div>
		                  <div class="modal-footer">
		                     <button type="button" class="btn btn-default"
		                        data-dismiss="modal">Close</button>
		                  </div>
		               </div>
		
		            </div>
		      </div> end of Modal
		   </div> end of row -->
		   <div class="loginContentDiv">
		   <div class="row">
		      <div class="col-md-4"></div>
		      <div class="col-md-4">
		         <div id="loginInFrame">
		         
       				 <form action="<%=request.getContextPath()%>/login" method="post"  id="loginform">
			            <div id="content" class="tab-content">
							<input type = "hidden" name = "checkUser" value = "mu" id ="checkUserType">
			                <div class="tab-pane fade in active" id="attendantLogin">
			                
			                  <button id="facebookLoginBtn" type="button" class="btn btn-primary btn-block">페이스북으로 Login 하기</button>
			                  <br><br> 
			                  <input type="email" class="form-control"  name="attendantId" placeholder="이메일  아이디 입력" size="20" id ="attendentIdForm">
			                  <input type="password" class="form-control" name="attendantPassword" placeholder="비밀번호 입력" size="20" id = attendantPwdForm>
			                </div>
							<!-- 
			                <div class="tab-pane fade" id="hostLogin">
			                 
			                   <input type="email" class="form-control" name="hostid" placeholder="이메일 아이디 입력" size="20" id = "hostIdForm">  
			                  <input type="password" class="form-control" name="hostpassword" placeholder="비밀번호 입력" size="20" id = "hostPwdForm">
			                </div>
			                
			                 -->
					        </div>
					        <br><br>
					        <div id="loginResultDiv"></div>
					        <button type="button" id="loginBtn" class="btn btn-success" >로 그 인</button>
			       </form>	   
			         
		         </div>
		         	  
		      </div>
		      <div class="col-md-4"></div>
		   </div>
		   </div>
		   
		   <br>
		   
		   <div id="loginBottomDiv">
		      <p>아이디가 없으신가요?<br>
		      <a href="<%=request.getContextPath()%>/jsp/signUpPage.jsp">지금 가입하세요</a></p>
		   </div>
		
		</div> <!--End of #all -->
	</div> <!--End of .container -->
</body>

</html>