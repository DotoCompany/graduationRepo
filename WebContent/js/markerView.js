$(document).ready(function(){
	
	
	$("#deleteBtn").click(function(){
		
		/*$("#form").submit();*/
		window.location.href='edit.do?service=DELETE&llId=' + $('#llId').val();
		
	});
	
	$("#modifyBtn").click(function(){
		$("#form").submit();
	});
	
	var lat = $("#lat").val();
	var lng = $("#lng").val();
	
	(function() {
		displayMarkers(lat, lng);
	}());
	
	function displayMarkers(lat, lng) {
		
		var latlng = new google.maps.LatLng(lat, lng);
		// map options
		var options = {
			zoom : 15,
			center : latlng, // centered 
			zoomControlOptions: {
				style: google.maps.ZoomControlStyle.BIG //zoom control size
			},
				scaleControl: true, // enable scale control
			mapTypeId: google.maps.MapTypeId.ROADMAP,
			mapTypeControl : false
		};

		// init map
		var map = new google.maps.Map(document.getElementById('map'), options);
		
		createMarker(map, latlng);
		
	}
	
	function createMarker(map, latlng) {
		var marker = new google.maps.Marker({
			map : map,
			position : latlng,
			title : latlng.toString()
		});
	}
});