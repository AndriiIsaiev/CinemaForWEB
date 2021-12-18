<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="currentPage" value="formloginuser.jsp" scope="session"/>

<html>
<body style="max-width: 1200px">

<%@ include file="mainheader.jsp"%>

<center>
<div style="width: 250px">
	<form action="loginUser" method="post">
		<fieldset>
			<legend><fmt:message key="login.Userlogin"/></legend>
			<span style="color: red"> ${textError} </span><br>
			<fmt:message key="login.EnterE-mail"/><br>
			<input name="login" value=""><br>
			<fmt:message key="login.Enterpassword"/><br>
			<input name="password" value="" type="password"><br>
			<input type="submit" value="<fmt:message key="login.Login"/>">
		</fieldset>
	</form>
</div>
</center>


</body>
</html>