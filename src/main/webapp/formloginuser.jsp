<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body style="max-width: 1200px">

<%@ include file="mainheader.jsp"%>

<center>
<div style="width: 250px">
	<form action="loginUser" method="post">
		<fieldset>
			<legend>User login</legend>
			<span style="color: red"> ${textError} </span><br>
			Enter E-mail<br>
			<input name="login" value=""><br>
			Enter password<br>
			<input name="password" value="" type="password"><br>
			<input type="submit" value="Login">
		</fieldset>
	</form>
</div>
</center>


</body>
</html>