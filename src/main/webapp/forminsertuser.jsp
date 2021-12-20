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
							<legend><fmt:message key="user.Addnewuser" /></legend>
							<span style="color: red"> <fmt:message key="${textError}" /> </span><br>
							<tr><td><fmt:message key="user.E-mail" /> *</td>  <td><input name="email" value="${insertUser.email}" type="email" ></td></tr>
							<tr><td><fmt:message key="user.Password" /> *</td><td><input name="password" value="${insertUser.password}" type="password"></td></tr>
							<tr><td><fmt:message key="user.Password" /> *</td><td><input name="password1" value="${password1}" type="password"></td></tr>
							<tr><td><fmt:message key="user.Roleadmin" /></td><td><input name="role" value="${1}" type="checkbox" <c:if test="${insertUser.role==1}">checked</c:if> ></td></tr>
							<tr><td><fmt:message key="user.Name" /></td>       <td><input name="name" value="${insertUser.name}" ></td></tr>
							<tr><td><fmt:message key="user.Surname" /></td>    <td><input name="surname" value="${insertUser.surname}" ></td></tr>
							<tr><td><fmt:message key="user.Phone" /></td>      <td><input name="phone" value="${insertUser.phone}" pattern="+38([0-9]{3})[0-9]{3}-[0-9]{2}-[0-9]{2}"></td></tr>
							<tr><td><fmt:message key="user.Mailing" /></td>    <td><input name="mailing" value="${1}" type="checkbox" <c:if test="${insertUser.mailing==1}">checked</c:if> ></td></tr>
						</table>
						* - <fmt:message key="inall.requiredfields" /> <br>
						<input type="submit" value="<fmt:message key="inall.Add" />">
					</fieldset>
				</form>
				<form> <button formaction="listUser" formmethod="get"><fmt:message key="inall.Back" /></button> </form>
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
