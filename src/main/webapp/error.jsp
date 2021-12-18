<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="currentPage" value="error.jsp" scope="session"/>

<html>
<body>

<h3>Error!!</h3>

<%-- <%=exception.getCause().getMessage()%>--%>
<hr>


${requestScope['javax.servlet.error.status_code']}

<hr>

${requestScope['javax.servlet.error.message']}
</body>
</html>
