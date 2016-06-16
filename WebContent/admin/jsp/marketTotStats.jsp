<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

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
	<input type ="hidden" value ="${requestScope.quater1}" id ="quater1"/>
    <input type ="hidden" value ="${requestScope.quater2}" id ="quater2"/>
    <input type ="hidden" value ="${requestScope.quater3}" id ="quater3"/>
    <input type ="hidden" value ="${requestScope.quater4}" id ="quater4"/>
    
    <canvas id="canvas"> </canvas>
    
    <script>
    
   			var jan = "1/4";
      		var feb = "2/4";
      		
      		/* var data1 = $('#quater1').val();
      		var data2 = $('#quater2').val();
      		var data3 = $('#quater3').val();
      		var data4 = $('#quater4').val();
      		 */
      		var data1 = 100;
      		var data2 = 200;
      		var data3 = 50;
      		var data4 = 75;
      		
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
   
</body>
</html>    
    
   
    
    
    
    