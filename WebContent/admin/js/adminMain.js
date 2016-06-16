$(function(){
	
	 $('.marketTotBtn').click(function(){
	
	    	$.ajax({
				url: $('#marketTotFm').attr('action'),
				type : 'POST',
				data: { service: "marketTotStats" },
				success: function(data) {
					$('#resultPrnArea').html(data);
	            }
			})
	 });
})

