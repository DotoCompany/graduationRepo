<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Insert title here</title>
<script>

</script>
<c:forEach var="lifeLogViewDTO" items="${requestScope.arrayList }">
	<img src="${lifeLogViewDTO.url }" onclick="javascript:detailsee('${lifeLogViewDTO.llId}')" style="width:200px;height:150px;">
</c:forEach>


<script>

	function detailsee(id) {
		/* alert(id); */
		window.location.href="edit.do?service=GET&llId="+id;
		/* $.post( "edit.do", { service: "GET", llId : id} ); */
	}

</script>