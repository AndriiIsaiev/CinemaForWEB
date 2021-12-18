<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="currentPage" value="listgenre.jsp" scope="session"/>

<html>
<body style="max-width: 1200px">

<%@ include file="mainheader.jsp"%>

<div>
	<br>
	<c:choose>
		<c:when test="${currentUser != null && currentUser.role == 1}">
			Total ${genre.size()} genres
			<a href="formInsertGenre?id=-1"
			   style=" color: black;
					text-decoration: none;
					background: rgb(240,240,240);
					padding: 3px;
					margin: 5px;
					border-width: 1px;
					border-style: outset;
					border-color: black;
					border-radius: 2px"
			>Add new genre</a>
			<br><br>
			<c:forEach var="genre" items="${genre}">
				${genre.id} ==&gt; ${genre.name}
				<a href="formEditGenre?id=${genre.id}">edit</a>
				<a href="deleteGenre?id=${genre.id}">delete</a>
				<br>
			</c:forEach>
			<br>
			Total ${genre.size()} genres
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
