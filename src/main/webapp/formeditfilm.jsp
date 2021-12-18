<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="currentPage" value="formeditfilm.jsp" scope="session"/>

<html>
<body style="max-width: 1200px">

<%@ include file="mainheader.jsp"%>

<div style="width: 1200px; display: flex; justify-content: center">
	<br>
	<c:choose>
		<c:when test="${currentUser != null && currentUser.role == 1}">
			<div style="width: 400px">
				<form action="updateFilm" method="post">
					<fieldset>
						<legend>Edit film</legend>
						<table>
							<span style="color: red"> ${textError} </span><br>
							<tr><td>Id</td><td>           <input name="id" value="${editFilm.id}" readonly>></td></tr>
							<tr><td>Film title *</td><td>   <input name="title" value="${editFilm.title}" >></td></tr>
							<tr><td>Year of issue *</td><td><input name="year" value="${editFilm.year}" pattern="^19{1}[0-9]{2}|^20{1}[0-9]{2}">></td></tr>
							<tr><td>Studio</td><td>       <input name="studio" value="${editFilm.studio}" >></td></tr>
							<tr><td>Lenght *</td><td>       <input name="length" value="${editFilm.length}" type="time">></td></tr>
							<tr><td>Age categoory</td><td><input name="ageCategory" value="${editFilm.ageCategory}" >></td></tr>
							<tr><td>Description</td><td><textarea name="description" cols="60" rows="5"> ${editFilm.description} </textarea>></td></tr>
							<tr><td>Photoname</td><td>    <input name="photoURL" type="file" value="${editFilm.photoURL}" ><img src="${editFilm.photoURL}" alt="Постер" />></td></tr>
						</table>
						* - обязательные поля <br>
						<input type="submit" value="Update">
					</fieldset>
				</form>
				<form> <button formaction="listFilm" formmethod="get">Back</button> </form>
			</div>
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
