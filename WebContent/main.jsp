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
			
			

			(function() {
				// map options
				var options = {
					zoom : 5,
					center : new google.maps.LatLng(39.909736, -98.522109), // centered US
					mapTypeId : google.maps.MapTypeId.TERRAIN,
					mapTypeControl : false
				};

				// init map
				var map = new google.maps.Map(document
						.getElementById('map_canvas'), options);

				// NY and CA sample Lat / Lng
				var southWest = new google.maps.LatLng(40.744656, -74.005966);
				var northEast = new google.maps.LatLng(34.052234, -118.243685);
				var lngSpan = northEast.lng() - southWest.lng();
				var latSpan = northEast.lat() - southWest.lat();

				// set multiple marker
				for (var i = 0; i < 250; i++) {
					// init markers
					var marker = new google.maps.Marker({
						position : new google.maps.LatLng(southWest.lat()
								+ latSpan * Math.random(), southWest.lng()
								+ lngSpan * Math.random()),
						map : map,
						title : 'Click Me ' + i
					});

					// process multiple info windows
					(function(marker, i) {
						// add click event
						google.maps.event.addListener(marker, 'click',
								function() {
									infowindow = new google.maps.InfoWindow({
										content : 'Hello, World!!'
									});
									infowindow.open(map, marker);
								});
					})(marker, i);
				}
			})();

			var lat;
			var lng;
			var markerList;

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

				/* $.each(markerList, function(key){
					
					var marker = markerList[key].marker;
					
					addr = marker.address;
					lat = marker.lat;
					var lng = marker.lng;
					var m_time = marker.m_time;
					
					alert(addr + ' / ' + lat + ' / ' + lng + ' / ' + m_time + ' / ');
					
				}); */

				displayMarkers(markerList);

			}

			function displayMarkers(markerList) {

				// this variable sets the map bounds and zoom level according to markers position
				var bounds = new google.maps.LatLngBounds();

				$.each(markerList,
						function(key) {

							var marker = markerList[key].marker;

							var m_id = marker.m_id;
							var latlng = new google.maps.LatLng(marker.lat,
									marker.lng);
							var addr = marker.address;
							var m_time = marker.m_time;

							createMarker(m_id, latlng, addr, m_time);

							bounds.extend(latlng);
						});
				map.fitBounds(bounds);
			}

			function createMarker(m_id, latlng, addr, m_time) {
				var marker = new google.maps.Marker({
					map : map,
					position : latlng,
					title : m_time
				});
				/* 
				 // This event expects a click on a marker
				 // When this event is fired the infowindow content is created
				 // and the infowindow is opened
				 google.maps.event.addListener(marker, 'click',
				 function() {

				 // Variable to define the HTML content to be inserted in the infowindow
				 var iwContent = '<div id="iw_container">'
				 + '<div class="iw_title">' + name
				 + '</div>' + '<div class="iw_content">'
				 + address1 + '<br />' + address2 + '<br />'
				 + postalCode + '</div></div>';

				 // including content to the infowindow
				 infoWindow.setContent(iwContent);

				 // opening the infowindow in the current map and at the current marker location
				 infoWindow.open(map, marker);
				 }); */
			}

			function initialize() {
				var mapOptions = {
					center : new google.maps.LatLng(40.601203, -8.668173),
					zoom : 9,
					mapTypeId : 'roadmap',
				};

				map = new google.maps.Map(document.getElementById('map'),
						mapOptions);

			}
			google.maps.event.addDomListener(window, 'load', initialize);

		}
	</script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCv59_KYHHzRqtky9EwzOJ7WY-Pb5XMGlc"
		async defer>
		
	</script>
	
	<script src="https://maps.googleapis.com/maps/api/js?sensor=false" type="text/javascript"></script>
	<script src="/assets/gmap3.js?body=1" type="text/javascript"></script>

</body>

</html>