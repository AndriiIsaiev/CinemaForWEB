<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body style="max-width: 1200px">

<%@ include file="mainheader.jsp"%>

<div>
	<br>
	<c:choose>
		<c:when test="${currentUser != null && currentUser.role == 1}">
			Edit film
			<form action="updateFilm" method="post">
				Id           <input name="id" value="${editFilm.id}" readonly><br>
				Film title   <input name="title" value="${editFilm.title}" ><br>
				Year of issue<input name="year" value="${editFilm.year}" pattern="^19{1}[0-9]{2}|^20{1}[0-9]{2}"><br>
				Studio       <input name="studio" value="${editFilm.studio}" ><br>
				Lenght       <input name="length" value="${editFilm.length}" type="time"><br>
				Age categoory<input name="ageCategory" value="${editFilm.ageCategory}" ><br>
				<textarea name="description" cols="60" rows="5"> ${editFilm.description} </textarea>
				<%--		Description  <input name="description" value="${editFilm.description}" size="60"><br>--%>
				Photoname    <input name="photoURL" type="file" value="${editFilm.photoURL}" ><img src="${editFilm.photoURL}" alt="Постер" /><br>
				<input type="submit" value="Update">
			</form>
			<form> <button formaction="listFilm" formmethod="get">Back</button> </form>
		</c:when>
		<c:otherwise>
			<br><br>
			<p style="font-size: 24px; text-align: center"> Access denied</p>
		</c:otherwise>
	</c:choose>
</div>

</body>
</html>
