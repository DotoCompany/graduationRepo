<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList,DTO.FriendDTO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style>
.userImage{
	width:120px;
	height:100px;
}
#friendName{
font-size: 20px;

}
#from_friend_table {
	float:left;
}
</style>
<script>
window.onload= function(){
	
};
</script>
	<table id="from_friend_table">
<c:forEach var="friends" items="${requestScope.friends }">
	<tr>
		<td rowspan="4" colspan="3">
			<c:if test="${friends.image == 0 }">
				<img src="image/default_profile_image.png" class="userImage"/>
			</c:if>
			<c:if test="${friends.image !=0 }">
				<img src="${friends.image }" id="friendImage" class="userImage"/>
			</c:if>
			
			
			
		</td>
		<tr>
			<td id="friendName">${friends.name }</td>
		</tr>
		<tr>
			<td id="friendEmail">${friends.emailId }</td>
		</tr>
		<tr>
			<td>
				<input type="button" value="친구추가 " id="requestFriendBtn" class="btn btn-success btn-lg" onclick="javascript:requestFriend('${friends.uId }')"/>
				
			</td>
		</tr>
	</tr>
</c:forEach>
