<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

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

<!-- imported sources -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/admin/js/Chart.min.js"></script>
  
    
</head>
<body>

	<!-- 상단메뉴 include -->
	<jsp:include page="jsp/adminHeader.jsp"></jsp:include>


<div id="content-area">

	<div class="container" style="padding-top: 50px;">

		<input type ="hidden" value ="${requestScope.qua1}" id ="qua1"/>
    	<input type ="hidden" value ="${requestScope.qua2}" id ="qua2"/>
    	<input type ="hidden" value ="${requestScope.qua3}" id ="qua3"/>
    	<input type ="hidden" value ="${requestScope.qua4}" id ="qua4"/>
    
    	<div class="row">
    		<div class="col-sm-12 col-md-12">
    			<h3>- 분기별 사용자 가입 현황</h3>
    			<br>
    		</div>
    	</div>
    	
    	<div class="row">
    		<div class="col-sm-12 col-md-12">
    			<canvas id="canvas"> </canvas>
    		</div>
    	</div>
    	 
    
    
    <script>
    
      		
      		var data1 = $('#qua1').val();
      		var data2 = $('#qua2').val();
      		var data3 = $('#qua3').val();
      		var data4 = $('#qua4').val();
      		 
      	
      		
    		var BarChart = {
    			    /* labels: ["Ruby", "jQuery", "Java", "ASP.Net", "PHP", "Others"],
    			    datasets: [{
    			        fillColor: "rgba(151,249,190,0.5)",
    			        strokeColor: "rgba(255,255,255,1)",
    			        data: [13, 20, 30, 40, 50]
    			    }, {
    			        fillColor: "rgba(252,147,65,0.5)",
    			        strokeColor: "rgba(255,255,255,1)",
    			        data: [28, 68, 40, 19, 96]
    			    }] */
    			    labels: ["1/4", "2/4", "3/4", "4/4"],
    		        datasets: [
    		            {
    		                label: "Market Count",
    		                fillColor: "rgba(220,220,220,0.5)",
    		                strokeColor: "rgba(220,220,220,0.8)",
    		                highlightFill: "rgba(220,220,220,0.75)",
    		                highlightStroke: "rgba(220,220,220,1)",
    		                data: [data1, data2, data3, data4]
    		            }
    		        ]
    			}
       
       $(function(){
    	   
    	   /* var myLineChart = new Chart(document.getElementById("canvas").getContext("2d")).Line(LineChart, {scaleFontSize : 13, scaleFontColor : "#ffa45e"}); */
    	   var myBarChart = new Chart(document.getElementById("canvas").getContext("2d")).Bar(BarChart, {scaleFontSize : 13, scaleFontColor : "#ffa45e"});
    	   
       });
       
   </script>
   
   </div>
</div>   
</body>
</html>    
    
   
    
    
    
    