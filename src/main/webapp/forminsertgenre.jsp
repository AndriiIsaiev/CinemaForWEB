<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="currentPage" value="forminsertgenre.jsp" scope="session"/>

<html>
<body style="max-width: 1200px">

<%@ include file="mainheader.jsp"%>


<div style="width: 210px">
	<br>
	<c:choose>
		<c:when test="${currentUser != null && currentUser.role == 1}">
			<form action="insertGenre" method="post">
				<fieldset>
					<legend>Add new genre</legend>
					<span style="color: red"> <fmt:message key="${textError}" /> </span><br>
					Name *<br>
					<input name="name" value="${insertGenre.name}" ><br>
					* - обязательные поля <br>
					<input type="submit" value="Add">
				</fieldset>
			</form>
			<form> <button formaction="listGenre" formmethod="get">Back</button> </form>
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
