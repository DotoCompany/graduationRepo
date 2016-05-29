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
		var map = new google.maps.Map(document.getElementById('map'), options);
		
		var path = new Array();
		
		$.each(markerList, function(key) {

			var marker = markerList[key].marker;

			var m_id = marker.m_id;
			var latlng = new google.maps.LatLng(marker.lat, marker.lng);
			var addr = marker.address;
			var m_time = marker.m_time;

			createMarker(map, m_id, latlng, addr, m_time);
			path.push(latlng);

		});
		
		createPath(map, path);
		
	}
	
	function createPath(map, path) {
		
		var flightPath = new google.maps.Polyline({
		    path: path,
		    geodesic: true,
		    strokeColor: '#FF0000',
		    strokeOpacity: 1.0,
		    strokeWeight: 2
		  });

		  flightPath.setMap(map);
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
						+ '<div class="iw_content">' + addr + '<br />'
						+ '</div></div>';

				// including content to the infowindow
				infoWindow.setContent(iwContent);

				// opening the infowindow in the current map and at the current marker location
				infoWindow.open(map, marker);
			});
		})(marker);
	}

}