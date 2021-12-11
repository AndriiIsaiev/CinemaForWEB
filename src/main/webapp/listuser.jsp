<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body style="max-width: 1200px">

<%@ include file="mainheader.jsp"%>

<div>
	<br>
	<c:choose>
		<c:when test="${currentUser != null && currentUser.role == 1}">
			Total ${user.size()} users
			<a href="formInsertUser"
				style=" color: black;
					text-decoration: none;
					background: rgb(240,240,240);
					padding: 3px;
					margin: 5px;
					border-width: 1px;
					border-style: outset;
					border-color: black;
					border-radius: 2px"
			>Add new user</a>
			<br><br>
			<table border="1" cellpadding="5">
				<tr>
					<th>Id</th><th>E-mail</th><th>Password</th><th>Create time</th><th>Admin?</th>
					<th>Name</th><th>Surname</th><th>Phone</th><th>Mailing</th><th>Action</th>
				</tr>
				<c:forEach var="user" items="${user}">
					<tr>
						<td>${user.id}</td><td>${user.email}</td><td>${user.password}</td><td>${user.createTime}</td>
						<td align="center"> <c:if test="${user.role==1}">yes</c:if> </td>
						<td>${user.name}</td><td>${user.surname}</td><td>${user.phone}</td>
						<td align="center"> <c:if test="${user.mailing==1}">yes</c:if> </td>
						<td> <a href="formEditUser?id=${user.id}">edit</a> <a href="deleteUser?id=${user.id}">delete</a> </td>
					</tr>
				</c:forEach>
			</table>
			<br>
			Total ${user.size()} users
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
