<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/profile.css">

<title>RE:CALL</title>

</head>
<%!HttpSession session;%>
<%
	session = request.getSession();
%>


<script src="<%=request.getContextPath()%>/common/js/jquery-1.12.3.js"></script>
<script src="<%=request.getContextPath()%>/js/profile.js"></script>


<body>
<div id="sideBarDiv">
      <jsp:include page="sideBar.jsp" flush="false"/>
   </div> <!-- End of sideBarDiv -->
	<form id="profile_all_div" method="post" action="<%=request.getContextPath()%>/modify.do">
		<div id="profile_">
			<div id="profile_picture_div">
				<img id="profile_image" src="image/logo_black.png" />
			</div>
			<div id="profile_information_div">
				<table>
					<tr>
						<td><label>E-mail</label></td>
						<td><input style="background-color: #f1f1f1;" type="email"
							class="input" name="input_email" id="input_email" readonly
							value="<%=(String) session.getAttribute("userEmail")%>" /></td>
					</tr>
					<tr>
						<td><label>Name</label></td>
						<td><input name="input_name" id="input_name" style="background-color: #f1f1f1;"
							type="text" class="input" readonly
							value="<%=(String) session.getAttribute("userName")%>" /></td>
					</tr>
				</table>
				<div id="update_pwd_div" style="display: none;">
					<table>
						<tr>
							<td><label>현재 비밀번호</label></td>
							<td><input type="password" class="input" id="password_check" name="password_check"/></td>
						</tr>
						<tr>
							<td><label>새 비밀번호</label></td>
							<td><input type="password" class="input" id="password_new" name="password_new"/></td>
						</tr>
						<tr>
							<td><label style="font-size: 14px;">새 비밀번호확인</label></td>
							<td><input type="password" class="input" id="password_new_confirm" name="password_new_confirm"/></td>
						</tr>
					</table>
				</div>
				<div id="goodbye_div" style="display: none;">
					<table>
						<tr>
							<td><label>현재 비밀번호</label></td>
							<td><input type="password" class="input" name="password_check2" id="password_check2"/></td>
						</tr>
					</table>
				</div>

				<div id="profile_button_div">
					<table>
						<tr>
							<td><input id="update_btn" type="button" class="normal_bt"
								value="수정하기" /></td>
							<td><input id="goodbye_btn" type="button" class="normal_bt"
								value="탈퇴하기" /></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
			<input id="input_name_" name="input_name_" type="hidden" value="<%=(String) session.getAttribute("userName")%>"/>
	</form>
</body>
</html>