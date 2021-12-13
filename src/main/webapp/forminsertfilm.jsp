<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body style="max-width: 1200px">

<%@ include file="mainheader.jsp"%>

<div>
	<br>
	<c:choose>
		<c:when test="${currentUser != null && currentUser.role == 1}">
			<div style="width: 300px">
				<form action="insertFilm" method="post">
					<fieldset>
						<table>
							<legend>Add new film</legend>
							<span style="color: red"> ${textError} </span><br>
							<tr><td>Film title *</td>   <td><input name="title" value="${insertFilm.title}" ></td></tr>
							<tr><td>Year of issue *</td><td><input name="year" value="${insertFilm.year}" pattern="^19{1}[0-9]{2}|^20{1}[0-9]{2}"></td></tr>
							<tr><td>Studio</td>         <td><input name="studio" value="${insertFilm.studio}" ></td></tr>
							<tr><td>Lenght *</td>       <td><input name="length" value="${insertFilm.length}" type="time"></td></tr>
							<tr><td>Age categoory</td>  <td><input name="ageCategory" value="${insertFilm.ageCategory}" ></td></tr>
							<tr><td>Description</td>    <td><input name="description" value="${insertFilm.description}" size="60" ></td></tr>
							<tr><td>Photo name</td>     <td><input name="photoURL" value="./img/${insertFilm.photoURL}" type="file" ></td></tr>
						</table>
						* - обязательные поля <br>
						<input type="submit" value="Add">
					</fieldset>
				</form>
				<form> <button formaction="listFilm" formmethod="get">Back</button> </form>
			</div>
			</c:when>
		<c:otherwise>
			<br><br>
			<p style="font-size: 24px; text-align: center"> Access denied</p>
		</c:otherwise>
	</c:choose>
</div>
</div>

</body>
</html>
