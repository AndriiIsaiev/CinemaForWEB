<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body style="max-width: 1200px">

<%@ include file="mainheader.jsp"%>

<div style="width: 1200px; display: flex; justify-content: center">
	<br>
	<c:choose>
		<c:when test="${currentUser != null && currentUser.role == 1}">
			<div style="width: 300px">
				<form action="updateUser" method="post">
					<fieldset>
						<table>
							<legend>Edit user</legend>
							<span style="color: red"> ${textError} </span> <br>
							<tr><td>Id (readonly)</td><td><input name="id" value="${editUser.id}" readonly></td></tr>
							<tr><td>E-mail *</td>     <td><input name="email" value="${editUser.email}" type="email" ></td></tr>
							<tr><td>Password *</td>   <td><input name="password" value="${editUser.password}" type="password"></td></tr>
							<tr><td>Password *</td>   <td><input name="password1" value="${password1}" type="password"></td></tr>
							<tr><td>Create time</td>  <td><input name="createTime" value="${editUser.createTime}" readonly></td></tr>
							<tr><td>Role admin?</td>  <td><input name="role" value="${1}" type="checkbox" <c:if test="${editUser.role==1}">checked</c:if> ></td></tr>
							<tr><td>Name</td>         <td><input name="name" value="${editUser.name}" ></td></tr>
							<tr><td>Surname</td>      <td><input name="surname" value="${editUser.surname}" ></td></tr>
							<tr><td>Phone</td>        <td><input name="phone" value="${editUser.phone}" pattern="+38([0-9]{3})[0-9]{3}-[0-9]{2}-[0-9]{2}"></td></tr>
							<tr><td>Mailing</td>      <td><input name="mailing" value="${1}" type="checkbox" <c:if test="${editUser.mailing==1}">checked</c:if> ></td></tr>
						</table>
						* - обязательные поля <br>
						<input type="submit" value="Update">
					</fieldset>
				</form>
				<form> <button formaction="listUser" formmethod="get">Back</button> </form>
			</div>
		</c:when>
		<c:otherwise>
			<br><br>
			<p style="font-size: 24px; text-align: center"> Access denied</p>
		</c:otherwise>
	</c:choose>
</div>

</body>
</html>
