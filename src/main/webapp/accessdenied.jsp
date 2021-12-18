<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="currentPage" value="accessdenied.jsp" scope="session"/>

<html>
<body style="max-width: 1200px">

<%@ include file="mainheader.jsp"%>

<div>
	<br><br>
	<img src="./img/accessdenied.png" width="600" alt="Access denied" style="margin-left: 300px">
	<p style="font-size: 24px; text-align: center"> Access denied</p>
</div>

</body>
</html>
