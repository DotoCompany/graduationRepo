<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>here</title>
</head>
<body>
	
	<input type ="hidden" value ="${requestScope.qua1}" id ="qua1"/>
    <input type ="hidden" value ="${requestScope.qua2}" id ="qua2"/>
    <input type ="hidden" value ="${requestScope.qua3}" id ="qua3"/>
    <input type ="hidden" value ="${requestScope.qua4}" id ="qua4"/>
    
    <canvas id="canvas" height="450" width="600"> </canvas>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/admin/js/Chart.min.js"></script>
	
	<script>
      		
      		var data1 = $('#qua1').val();
      		var data2 = $('#qua2').val();
      		var data3 = $('#qua3').val();
      		var data4 = $('#qua4').val();
      		
    		var BarChart = {
    			    
    			    labels: ["1/4 분기", "2/4 분기", "3/4 분기", "4/4 분기"],
    		        datasets: [
    		            {
    		                label: "Market Count",
    		                fillColor: "rgba(120,220,220,0.5)",
    		                strokeColor: "rgba(220,220,220,0.8)",
    		                highlightFill: "rgba(220,220,220,0.75)",
    		                highlightStroke: "rgba(220,220,220,1)",
    		                data: [data1, data2, data3, data4]
    		            }
    		        ]
    			}
       
       $(function(){
    	   
    	   /* var myLineChart = new Chart(document.getElementById("canvas").getContext("2d")).Line(LineChart, {scaleFontSize : 13, scaleFontColor : "#ffa45e"}); */
    	   var myBarChart = new Chart($("#canvas")[0].getContext("2d")).Bar(BarChart, {scaleGridLineWidth : 1, scaleFontSize : 15, scaleFontColor : "#ffa45e"});
    	   
       });
       
   </script>
</body>
</html>