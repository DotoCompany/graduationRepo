$(document).ready(function(){
	$("#image").click(function(){
		$("#file").trigger("click");
	});
	$("#file").change(function(){
		var reader = new FileReader();
		reader.onload = function (e) {
			$("#image").attr("src",e.target.result);
		};
		reader.readAsDataURL(this.files[0]);
	});
	$("#saveBtn").click(function(){
		if($("#file").val()=="" || $("#file").val()=="logo_white.png") {
			alert("이미지를 등록해 주세요!");
			return;
		}
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