<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="mylib" tagdir="/WEB-INF/tags" %>

<c:set var="currentPage" value="listgenre.jsp" scope="session"/>

<html>
<body style="max-width: 1200px">

<%@ include file="mainheader.jsp"%>

<div>
	<br>
	<c:choose>
		<c:when test="${currentUser != null && currentUser.role == 1}">
			<fmt:message key="genre.Totalgenres" /> ${genre.size()}
			<mylib:mybutton button_action="genre.Addnewgenre" button_href="formInsertGenre?id=-1" button_color="rgb(240,240,240)"/>
			<br><br>
			<table border="1" cellpadding="5">
				<tr>
					<th>Id</th><th>Name</th><th>Action</th>
				</tr>

			<c:forEach var="genre" items="${genre}">
				<tr>
					<td>${genre.id}</td><td>${genre.name}</td>
					<td>
						<mylib:mybutton button_action="inall.Edit" button_href="formEditGenre?id=${genre.id}" button_color="darkseagreen"/>
						<mylib:mybutton button_action="inall.Delete" button_href="deleteGenre?id=${genre.id}" button_color="indianred"/>
					</td>
				</tr>
			</c:forEach>
			<br>
			<fmt:message key="genre.Totalgenres" /> ${genre.size()}
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
