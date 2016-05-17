
window.onload = function() {
	
	function getContextPath() {
		var hostIndex = location.href.indexOf( location.host ) + location.host.length;
		return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
	};
	
	$("#loginBtn").click(validate);
	
	function validate() {
		
		if($("#loginId").val()=="") {
			alert("아이디를 입력해 주세요.");
			$("#loginId").focus();
			return;
		}
		else if ( $("#loginPwd").val()==""){
			alert("비밀번호를 입력해 주세요.");
			$("#loginPwd").focus();
			return;
		}
		
		var frm = $('#loginForm');
		$.ajax({
		    type: 'post',
		    // make sure you respect the same origin policy with this url:
		    // http://en.wikipedia.org/wiki/Same_origin_policy
		    url: getContextPath() + '/login.do',
		    data: 
		        frm.serialize(),
		    dataType : 'json',
		    error : function() {
		    	alert("Error Occured !");
		    },
		    success: function(data){
		    	
		        alert('data' + data.name);
		        //window.location.href='/test.jsp';
		    	login(data);
		    }
		});
		
		//$("#loginForm").submit();
	}
	
	function login(data) {
		$("#loginForm").submit();
	}
}