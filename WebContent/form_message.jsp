<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Insert title here</title>
</head>
<body>
<style>
#msgFriendMessage {
	width:80px;
	height:80px;
}
.toMessage {



}
#messageTable {
	
}
</style>
	<table>
		<c:forEach var="message" items="${requestScope.arrayList }" >
			<c:if test="${message.fromName eq sessionScope.userName}">
				<tr>
					<td rowspan="3" >
							<img src="${requestScope.friendImage }" id="friendImage" />
					</td>
					<tr>
						<td>
							<h3>${message.toName }</h3>
						</td>
					</tr>
					<tr>
						<td>
							${message.body }
						</td>
					</tr>
				</tr>
			</c:if>
			<c:if test="${message.fromName != sessionScope.userName }">
			<tr>
				<td class="toMessage">${message.body }</td>
			</tr>
			</c:if>
		</c:forEach>
	</table>
	<input type="hidden" id="friendCode" value="${requestScope.friendCode }"/>
</body>
</html>