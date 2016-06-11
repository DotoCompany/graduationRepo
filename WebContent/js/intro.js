window.onload = function() {
	
	(function() {
		displayMap();
	}());
	
	function displayMap() {

		
		var latlng = new google.maps.LatLng(36.837378, 127.169906);
		// map options
		var options = {
			zoom : 15,
			center : latlng, // centered 
			zoomControlOptions: {
				style: google.maps.ZoomControlStyle.BIG //zoom control size
			},
				scaleControl: false, // enable scale control
			mapTypeId: google.maps.MapTypeId.ROADMAP,
			mapTypeControl : false,
			scrollwheel: false,
		    scaleControl: false,
		};

		// init map
		var map = new google.maps.Map(document.getElementById('mapDiv'), options);
		
		var marker = new google.maps.Marker({
			map : map,
			position : latlng,
			title : latlng.toString()
		});
		
	}
	
	
}