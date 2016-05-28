
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
		
		var markerList = json.markers;
		
		$.each(markerList, function(key){
			
			var marker = markerList[key].marker;
			
			var addr = marker.address;
			var lat = marker.lat;
			var lng = marker.lng;
			var m_time = marker.m_time;
			
			alert(addr + ' / ' + lat + ' / ' + lng + ' / ' + m_time + ' / ');
			
		});
		
	}
			
}