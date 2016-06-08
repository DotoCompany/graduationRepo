window.onload = function() {
	
	var contextPath = $('#contextPath').val();
	
	$.ajax({
		type : 'post',
		// make sure you respect the same origin policy with this url:
		// http://en.wikipedia.org/wiki/Same_origin_policy
		url : contextPath + '/marker.do',
		data : {
			uId : $('#uId').val()
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
			zoomControlOptions: {
				style: google.maps.ZoomControlStyle.BIG //zoom control size
			},
				scaleControl: true, // enable scale control
			mapTypeId: google.maps.MapTypeId.ROADMAP,
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
			title : latlng.toString()
		});
		
		var date = new Date(Date.parse(m_time)).toUTCString();
		var btnHref = contextPath + '/markerEdit.jsp?m_id=' + m_id + '&lat=' + latlng.lat().toFixed(6) + '&lng=' + latlng.lng().toFixed(6);
		
		infoWindow = new google.maps.InfoWindow();

		(function(marker) {
			// add click event
			google.maps.event.addListener(marker, 'click',

			function() {
				var contentString = '<div id="content">'+
			      '<div id="siteNotice">'+
			      '</div>'+
			      '<h1 id="firstHeading" class="firstHeading">' +  date + '</h1>'+
			      '<div id="bodyContent">'+
			      '<p><b>(' + latlng.lat().toFixed(6) + ', ' + latlng.lng().toFixed(6) + ')</b></p>' +
			      '<input type=button class="normal_bt" value="편집" onclick="window.location.href=\'' +
			      
			      btnHref + '\'"/>' +
			      
			      '</div>'+
			      '</div>';

				// including content to the infowindow
				infoWindow.setContent(contentString);

				// opening the infowindow in the current map and at the current marker location
				infoWindow.open(map, marker);
			});
		})(marker);
	}

}