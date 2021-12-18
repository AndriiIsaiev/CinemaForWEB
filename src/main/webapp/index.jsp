<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="currentPage" value="index.jsp" scope="session"/>

<html>
<body style="max-width: 1200px">

<%@ include file="mainheader.jsp"%>

    <c:if test="${currentUser != null && currentUser.role == 0}">
        <div style="margin-top: 30px; ax-width: 1200px; display: flex; justify-content: space-around">
            <div style="width: 200px">
                <a href="/cin/listSeance"><img src="./img/seance.jpg" style="width: 200px; height: 200px">Сеансы</a> <br>
            </div>
            <div style="width: 200px">
                <a href="/cin/listFilm"><img src="./img/film2.jpg" style="width: 200px; height: 200px">Фильмы</a> <br>
            </div>
        </div>
    </c:if>

    <c:if test="${currentUser != null && currentUser.role == 1}">
        <div style="margin-top: 30px; ax-width: 1200px; display: flex; justify-content: space-around; flex-wrap: wrap">
            <div style="width: 200px">
                <a href="/cin/listSeance"><img src="./img/seance.jpg" style="width: 200px; height: 200px">Редактирование сеансов</a> <br>
            </div>
            <div style="width: 200px">
                <a href="/cin/listFilm"><img src="./img/film2.jpg" style="width: 200px; height: 200px">Реактирование фильмов</a> <br>
            </div>
            <div style="width: 200px">
                <a href="/cin/listUser"><img src="./img/user.jpg" style="width: 200px; height: 200px">Редактирование пользователей</a> <br>
            </div>
            <div style="width: 200px">
                <a href="/cin/listGenre"><img src="./img/genre.jpg" style="width: 200px; height: 200px">Редактирование жанров</a> <br>
            </div>
            <div style="width: 200px">
                <a href="/cin/adminpage.jsp"><img src="./img/ticket.jpg" style="width: 200px; height: 200px">Просмотр билетов</a> <br>
            </div>
        </div>
    </c:if>

</html>
