<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="currentPage" value="listfilm.jsp" scope="session"/>

<html>
<body style="max-width: 1200px">

<%@ include file="mainheader.jsp"%>

<div>
	<br>
	Total ${listFilePageItem.size()} films
	<br><br>
	<c:if test="${currentUser != null && currentUser.role == 1}">
		<a href="formInsertFilm?id=-1"
		   style=" color: black;
				text-decoration: none;
				background: rgb(240,240,240);
				padding: 3px;
				margin: 5px;
				border-width: 1px;
				border-style: outset;
				border-color: black;
				border-radius: 2px"
		>Add new film</a>
	</c:if>
	<br><br>
	<c:forEach var="xfilm" items="${listFilePageItem}">
		<div style="background: lightgoldenrodyellow">
			<div style="text-align: center; font-size: 24px"> <b>${xfilm.film.title}</b></div>
			<div style="display: flex; justify-content: center; font-size: 16px">
				<div>
					<img src="${xfilm.film.photoURL}" alt="Постер" />
				</div>
				<div style="padding-left: 10px; background: lightgoldenrodyellow">
					 ${xfilm.film.year} ${xfilm.film.studio} ${xfilm.film.length} ${xfilm.film.ageCategory}
					 <br>
					<c:forEach var="xgenre" items="${xfilm.listGenre}">
						<c:if test="${! xgenre.equals(xfilm.listGenre.get(0))}">
							<span style="margin-right: 5px">,</span>
						</c:if>
						${xgenre.name}
					</c:forEach>
					<br>
					${xfilm.film.description}
				</div>
			</div>
			<c:if test="${currentUser != null && currentUser.role == 1}">
				<div style="text-align: center">
					<a href="formEditFilm?id=${xfilm.film.id}"
							style=" color: black;
							text-decoration: none;
							background: darkseagreen ;
							padding: 3px;
							margin: 5px;
							border-width: 1px;
							border-style: outset;
							border-color: green;
							border-radius: 2px"
					>edit</a>
					<a href="deleteFilm?id=${xfilm.film.id}"
							style=" color: black;
							text-decoration: none;
							background: indianred ;
							padding: 3px;
							margin: 5px;
							border-width: 1px;
							border-style: outset;
							border-color: firebrick;
							border-radius: 2px"
					>delete</a>
				</div>
			</c:if>
			<br>
		</div>
		<br>
	</c:forEach>
	<br>
	Total ${listFilePageItem.size()} films
</div>
</div>

</body>
</html>
