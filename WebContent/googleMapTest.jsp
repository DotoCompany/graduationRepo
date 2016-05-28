<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset=UTF-8">

<!-- customized sources -->
<%-- <script src="<%=request.getContextPath()%>/js/main.js"
	type="text/javascript" charset="utf-8"></script> --%>

<!-- imported sources -->
<!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- jQuery -->
<script src="<%=request.getContextPath()%>/common/js/jquery-1.12.3.js"></script>

<script src="https://maps.googleapis.com/maps/api/js?v=3.11&sensor=false" type="text/javascript"></script>

<style>
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

#map {
	height: 80%;
}
</style>


<title>RE:CALL</title>
</head>

<body>

	<input type="hidden" id="contextPath"
		value="<%=request.getContextPath()%>">


	<div id="map"></div>

	<script>
	
		window.onload = function() {
			
			$.ajax({
				type : 'post',
				// make sure you respect the same origin policy with this url:
				// http://en.wikipedia.org/wiki/Same_origin_policy
				url : $('#contextPath').val() + '/marker.do',
				data : {
					uId : '2'
				},
				dataType : 'json',
				error : function() {
					alert("Error Occured !");
				},
				success : marker_json
			});
			
			
			function marker_json(json) {

				markerList = json.markers;
				displayMarkers(markerList);

			}

			function displayMarkers(markerList) {
				// map options
				var options = {
					zoom : 5,
					center : new google.maps.LatLng(39.909736, -98.522109), // centered US
					mapTypeId : google.maps.MapTypeId.TERRAIN,
					mapTypeControl : false
				};

				// init map
				var map = new google.maps.Map(document
						.getElementById('map'), options);

				$.each(markerList,
						function(key) {

							var marker = markerList[key].marker;

							var m_id = marker.m_id;
							var latlng = new google.maps.LatLng(marker.lat,
									marker.lng);
							var addr = marker.address;
							var m_time = marker.m_time;

							createMarker(map, m_id, latlng, addr, m_time);
				
						});
			}
			
			
			function createMarker(map, m_id, latlng, addr, m_time) {
				var marker = new google.maps.Marker({
					map : map,
					position : latlng,
					title : m_time
				});
				
				infoWindow = new google.maps.InfoWindow();

				(function(marker) {
					// add click event
					google.maps.event.addListener(marker, 'click',

					function() {
						var iwContent = '<div id="iw_container">'
								+ '<div class="iw_title">' + m_time + '</div>'
								+ '<div class="iw_content">' + addr
								+ '<br />'
								+ '</div></div>';

						// including content to the infowindow
						infoWindow.setContent(iwContent);

						// opening the infowindow in the current map and at the current marker location
						infoWindow.open(map, marker);
					});
				})(marker);
			}

		}
	</script>


</body>

</html>