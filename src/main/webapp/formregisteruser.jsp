<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body style="max-width: 1200px">

<%@ include file="mainheader.jsp"%>

<div style="width: 350px">
	<form action="registerUser" method="post">
		<fieldset>
			<table>
				<legend>Add new user</legend>
				<span style="color: red"> ${textError} </span> <br>
				<tr><td>E-mail *</td>  <td><input name="email" value="${registerUser.email}" type="email" ></td></tr>
				<tr><td>Password *</td><td><input name="password" value="${registerUser.password}" type="password"></td></tr>
				<tr><td>Password *</td><td><input name="password1" value="${password1}" type="password"></td></tr>
				<tr><td>Name</td>       <td><input name="name" value="${registerUser.name}" ></td></tr>
				<tr><td>Surname</td>    <td><input name="surname" value="${registerUser.surname}" ></td></tr>
				<tr><td>Phone</td>      <td><input name="phone" value="${registerUser.phone}" pattern="+38([0-9]{3})[0-9]{3}-[0-9]{2}-[0-9]{2}"></td></tr>
				<tr><td>Mailing</td>    <td><input name="mailing" value="${1}" type="checkbox" <c:if test="${registerUser.mailing==1}">checked</c:if> ></td></tr>
				<tr><td>* - обязательные поля </td></tr>
				<tr><td><input type="submit" value="Register"></td></tr>
			</table>
		</fieldset>
	</form>

</div>

</body>
</html>
