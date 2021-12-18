<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="currentPage" value="forminsertseance.jsp" scope="session"/>

<html>
<body style="max-width: 1200px">

<%@ include file="mainheader.jsp"%>

<div style="width: 1200px; display: flex; justify-content: center">
<br>
	<c:choose>
		<c:when test="${currentUser != null && currentUser.role == 1}">
			<div style="width: 600px">
				<form action="insertSeance" method="post">
					<fieldset>
						<table>
							<legend>Add new seance</legend>
							<span style="color: red"> ${textError} </span> <br>
							<tr><td>Film *</td>  <td>	<select name="filmId" style="padding: 2px 0px">
															<c:forEach var="xfilm" items="${listFilm}">
																<option value="${xfilm.getId()}"
																		<c:if test="${insertSeance.getFilmId() == xfilm.getId()}">
																			selected
																		</c:if>
																>${xfilm.getTitle()}</option>
															</c:forEach>
														</select>

													</td></tr>
							<tr><td>Дата *</td><td><input name="seanceDate" value="${insertSeance.dateTime}" type="date"></td></tr>
							<tr><td>Время *</td><td><input name="seanceTime" value="${Time.valueOf("09:30:00")}" type="time"></td></tr>
							<tr><td>Цена *</td> <td><input name="seanceCost" value="${99}" type="number"></td></tr>
						</table>
						* - обязательные поля <br>
						<input type="submit" value="Add">
					</fieldset>
				</form>
				<form> <button formaction="listSeance" formmethod="get">Back</button> </form>
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
