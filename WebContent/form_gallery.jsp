<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Insert title here</title>
<script>

</script>
<c:forEach var="lifeLogViewDTO" items="${requestScope.arrayList }">
	<img src="${lifeLogViewDTO.url }" onclick="javascript:detailsee(${lifeLogViewDTO.llId})">
	<p>${lifeLogViewDTO.llId }</p>
</c:forEach>

	