<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body style="max-width: 1200px">

<header style="background: rgb(220,220,220); display: flex; justify-content: space-between">
    <div>
        <img src="./img/kino.jpg" width='100'; height='100' />
    </div>
    <div style="font-size: 24px; padding-top: 35px; margin-bottom: 30px; width: 1000px; display: flex; justify-content: space-around">
        <a href="/cin">Main page</a>
        <a href="/cin/listSeance">Seance Schedule</a>
        <c:if test="${currentUser == null}">
            Not registered user
            <a href="/cin/formLoginUser">Login</a>
            <a href="/cin/formRegisterUser">Register</a>
        </c:if>
        <c:if test="${currentUser != null}">
            <c:if test="${currentUser.role == 0}">
                Current user:
            </c:if>
            <c:if test="${currentUser.role == 1}">
                Current admin:
            </c:if>

            ${currentUser.name}${currentUser.surname}
            <a href="/cin/logoutUser">Logout</a>
        </c:if>
    </div>
    <br><br>
</header>

</body>
</html>
