<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
.commentImage{
	width:80px;
	height:60px;
}
</style>

<table>
	<c:forEach var="comment" items="${requestScope.arrayList }">
		<tr>
			<td rowspan="3" >
				<c:if test="${comment.image == '0' }">
					<img src="image/default_profile_image.png" class="commentImage"/>
				</c:if>
				<c:if test="${comment.image !='0' }">
					<img src="${friends.image }" class="commentImage" />
				</c:if>
			</td>
			<tr>
				<td>
					${comment.name }
				</td>
			</tr>
			<tr>
				<td>
					${comment.text }
				</td>
			</tr>
		</tr>
	</c:forEach>
</table>
<input type="hidden" id="llId" value="${requestScope.lifeLogCode }"/>
</body>
</html>