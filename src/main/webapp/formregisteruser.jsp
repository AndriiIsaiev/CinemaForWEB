<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="currentPage" value="formregisteruser.jsp" scope="session"/>

<html>
<body style="max-width: 1200px">

<%@ include file="mainheader.jsp"%>

<div style="width: 1200px; display: flex; justify-content: center">
	<div style="width: 350px">
		<form action="registerUser" method="post">
			<fieldset>
				<table>
					<legend><fmt:message key="user.Addnewuser" /></legend>
					<span style="color: red"> <fmt:message key="${textError}" /> </span><br>
					<tr><td><fmt:message key="user.E-mail" /> *</td>  <td><input name="email" value="${registerUser.email}" type="email" ></td></tr>
					<tr><td><fmt:message key="user.Password" /> *</td><td><input name="password" value="${registerUser.password}" type="password"></td></tr>
					<tr><td><fmt:message key="user.Password" /> *</td><td><input name="password1" value="${password1}" type="password"></td></tr>
					<tr><td><fmt:message key="user.Name" /></td>       <td><input name="name" value="${registerUser.name}" ></td></tr>
					<tr><td><fmt:message key="user.Surname" /></td>    <td><input name="surname" value="${registerUser.surname}" ></td></tr>
					<tr><td><fmt:message key="user.Phone" /></td>      <td><input name="phone" value="${registerUser.phone}" pattern="+38([0-9]{3})[0-9]{3}-[0-9]{2}-[0-9]{2}"></td></tr>
					<tr><td><fmt:message key="user.Mailing" /></td>    <td><input name="mailing" value="${1}" type="checkbox" <c:if test="${registerUser.mailing==1}">checked</c:if> ></td></tr>
				</table>
				* - <fmt:message key="inall.requiredfields" /><br>
				<tr><td><input type="submit" value="<fmt:message key="user.Register" />"></td></tr>
			</fieldset>
		</form>

	</div>
</div>

</body>
</html>
