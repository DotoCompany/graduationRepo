<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>

<head>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/main.css">

<!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- jQuery -->
<script src="<%=request.getContextPath()%>/common/js/jquery-1.12.3.js"></script>

<script
	src="https://maps.googleapis.com/maps/api/js?v=3.11&sensor=false"
	type="text/javascript"></script>

<title>RE:CALL</title>
</head>

<body>
	<div id="left_sideBar">
		<ul>
			<li><a href="">
					<div id="sideBar_logo">
						<span></span>
					</div>
			</a></li>
			<li><a href="">
					<div id="sideBar_profile">
						<span>Profile</span>
					</div>
			</a></li>
			<li><a href="">
					<div id="sideBar_friends">
						<span>Friends</span>
					</div>
			</a></li>
			<li><a href="">
					<div id="sideBar_photo">
						<span>Photo</span>
					</div>
			</a></li>
			<li><a href="">
					<div id="sideBar_notification">
						<span>Notification</span>
					</div>
			</a></li>
			<li><a href="">
					<div id="sideBar_markers">
						<span>Markers</span>
					</div>
			</a></li>
		</ul>
	</div>
	<!-- side bar end -->

	<input type="hidden" id="contextPath"
		value="<%=request.getContextPath()%>">

	<div id="center">
		<div id="map"></div>
		<script>
			window.onload = function() {

				$.ajax({
					type : 'post',
					// make sure you respect the same origin policy with this url:
					// http://en.wikipedia.org/wiki/Same_origin_policy
					url : $('#contextPath').val() + '/marker.do',
					data : {
						uId : '1'
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

					$.each(markerList, function(key) {

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
									+ '<div class="iw_title">' + m_time
									+ '</div>' + '<div class="iw_content">'
									+ addr + '<br />' + '</div></div>';

							// including content to the infowindow
							infoWindow.setContent(iwContent);

							// opening the infowindow in the current map and at the current marker location
							infoWindow.open(map, marker);
						});
					})(marker);
				}
			}
		</script>
	</div>
</body>

</html>