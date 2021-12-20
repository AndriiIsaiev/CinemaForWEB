<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="mylib" tagdir="/WEB-INF/tags" %>

<c:set var="currentPage" value="listuser.jsp" scope="session"/>

<html>
<body style="max-width: 1200px">

<%@ include file="mainheader.jsp"%>

<div>
	<br>
	<c:choose>
		<c:when test="${currentUser != null && currentUser.role == 1}">
			<fmt:message key="user.Totalusers" /> ${user.size()}
			<mylib:mybutton button_action="user.Addnewuser" button_href="formInsertUser" button_color="rgb(240,240,240)"/>
			<br><br>
			<table border="1" cellpadding="5">
				<tr>
					<th><fmt:message key="inall.Id" /></th><th><fmt:message key="user.E-mail" /></th>
					<th><fmt:message key="user.Password" /></th><th><fmt:message key="user.Createtime" /></th>
					<th><fmt:message key="user.Roleadmin" /></th><th><fmt:message key="user.Name" /></th>
					<th><fmt:message key="user.Surname" /></th><th><fmt:message key="user.Phone" /></th>
					<th><fmt:message key="user.Mailing" /></th><th><fmt:message key="inall.Action" /></th>
				</tr>
				<c:forEach var="user" items="${user}">
					<tr>
						<td>${user.id}</td><td>${user.email}</td><td>${user.password}</td><td>${user.createTime}</td>
						<td align="center"> <c:if test="${user.role==1}"><fmt:message key="user.yes" /></c:if> </td>
						<td>${user.name}</td><td>${user.surname}</td><td>${user.phone}</td>
						<td align="center"> <c:if test="${user.mailing==1}"><fmt:message key="user.yes" /></c:if> </td>
						<td>
							<mylib:mybutton button_action="inall.Edit" button_href="formEditUser?id=${user.id}" button_color="darkseagreen"/>
							<mylib:mybutton button_action="inall.Delete" button_href="deleteUser?id=${user.id}" button_color="indianred"/>
						</td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<fmt:message key="user.Totalusers" /> ${user.size()}
		</c:when>
		<c:otherwise>
			<br><br>
			<img src="./img/accessdenied.png" width="600" alt="Access denied" style="margin-left: 300px">
			<p style="font-size: 24px; text-align: center"> Access denied</p>
		</c:otherwise>
	</c:choose>

</div>

</body>
</html>
