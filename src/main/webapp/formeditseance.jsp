<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="currentPage" value="formeditseance.jsp" scope="session"/>

<html>
<body style="max-width: 1200px">

<%@ include file="mainheader.jsp"%>

<div style="width: 1200px; display: flex; justify-content: center">
	<br>
	<c:choose>
		<c:when test="${currentUser != null && currentUser.role == 1}">
			<div style="width: 600px">
				<form action="updateSeance" method="post">
					<fieldset>
						<table>
							<legend>Edit seance</legend>
							<span style="color: red"> ${textError} </span> <br>
							Id           <input name="id" value="${editSeance.id}" readonly><br>
							<tr><td>Film *</td>  <td>	<select name="filmId" style="padding: 2px 0px">
								<c:forEach var="xfilm" items="${listFilm}">
									<option value="${xfilm.getId()}"
											<c:if test="${editSeance.getFilmId() == xfilm.getId()}">
												selected
											</c:if>
									>${xfilm.getTitle()}</option>
								</c:forEach>
							</select>

							</td></tr>
							<tr><td>Дата *</td><td><input name="seanceDate" value="${editSeance.dateTime}" type="date"></td></tr>
							<tr><td>Время *</td><td><input name="seanceTime" value="${"00:00:00"}" type="time"></td></tr>
							<tr><td>Цена *</td> <td><input name="seanceCost" value="${editSeance.baseCost}" type="number"></td></tr>
						</table>
						* - обязательные поля <br>
						<input type="submit" value="Update">
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
