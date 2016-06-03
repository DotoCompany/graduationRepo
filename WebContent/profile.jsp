<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=request.getContextPath()%>/common/js/jquery-1.12.3.js"></script>
<title>profile</title>
</head>
<jsp:include page="sideBar.jsp" flush="false"/>
<style>
body {
margin-left: 80px;
}
</style>
<body>
<%! HttpSession session; %>	
<%session = request.getSession(); %>

<script>
$(document).ready(function(){
	/*수정 버튼이 눌렸을 때*/
	$("#modifySave").click(modifySave);
	/*취소 버튼이 눌렸을 때*/
	$("#cancel").click(cancel);
	
	function modifySave(){
		
		
	}
	function toSaveBtn(){
		
	}
	function cancel(){
		alert("cancel");
	}
});
</script>
<style>
#modifyName {
	display:none;
}
</style>
<table>
	<tr>
		<td>
		name 
		</td>
		<td id="userName">
			<%=session.getAttribute("userName") %>
		</td>
		<td id="modifyName">
			<input type="text" name="modifyName" id="modifyName"/>
		</td>
	</tr>
	<tr>
		<td>
		email 
		</td>
		<td id="userEmail">
		<%=session.getAttribute("userEmail") %>
		</td>
	</tr>
	<tr>
		<td>
			<input type="button" value="수정" name="modify" id="modifySave"/>
		</td>
		<td>
			<input type="button" value="취소" name="cancel" id="cancel"/>
		</td>
	</tr>

</table>
	
	
</body>
</html>