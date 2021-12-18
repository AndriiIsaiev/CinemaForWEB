<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="currentPage" value="forminsertuser.jsp" scope="session"/>

<html>
<body style="max-width: 1200px">

<%@ include file="mainheader.jsp"%>

<div style="width: 1200px; display: flex; justify-content: center">
<br>
	<c:choose>
		<c:when test="${currentUser != null && currentUser.role == 1}">
			<div style="width: 300px">
				<form action="insertUser" method="post">
					<fieldset>
						<table>
							<legend>Add new user</legend>
							<span style="color: red"> ${textError} </span> <br>
							<tr><td>E-mail *</td>  <td><input name="email" value="${insertUser.email}" type="email" ></td></tr>
							<tr><td>Password *</td><td><input name="password" value="${insertUser.password}" type="password"></td></tr>
							<tr><td>Password *</td><td><input name="password1" value="${password1}" type="password"></td></tr>
							<tr><td>Role admin?</td><td><input name="role" value="${1}" type="checkbox" <c:if test="${insertUser.role==1}">checked</c:if> ></td></tr>
							<tr><td>Name</td>       <td><input name="name" value="${insertUser.name}" ></td></tr>
							<tr><td>Surname</td>    <td><input name="surname" value="${insertUser.surname}" ></td></tr>
							<tr><td>Phone</td>      <td><input name="phone" value="${insertUser.phone}" pattern="+38([0-9]{3})[0-9]{3}-[0-9]{2}-[0-9]{2}"></td></tr>
							<tr><td>Mailing</td>    <td><input name="mailing" value="${1}" type="checkbox" <c:if test="${insertUser.mailing==1}">checked</c:if> ></td></tr>
						</table>
						* - обязательные поля <br>
						<input type="submit" value="Add">
					</fieldset>
				</form>
				<form> <button formaction="listUser" formmethod="get">Back</button> </form>
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
