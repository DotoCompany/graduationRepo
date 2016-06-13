<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList,DTO.FriendDTO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style>
#friendImage{
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
			<img src="${friends.image }" id="friendImage" />
		</td>
		<tr>
			<td id="friendName">${friends.friendName }</td>
		</tr>
		<tr>
			<td id="friendEmail">${friends.friendEmail }</td>
		</tr>
		<tr>
			<td>
				<input type="button" value="메시지 " id="messageBtn" class="btn btn-success btn-lg" onclick="javascript:messageBtn('${friends.friendCode }')"/>
				<input type="button" value="친구삭제" class="btn btn-cancel btn-lg" id="friendDeleteBtn"/>
			</td>
		</tr>
	</tr>
</c:forEach>
