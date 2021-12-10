<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body style="max-width: 1200px">

<header style="max-width: 1200px">
    <div style="display: flex; justify-content: center">
        <div style="width: 171px; height: 151px; background-image: url(./img/frame.jpg); background-size: 171px;
                    display: flex; justify-content: center; align-items: center">
            <div style="width: 140px; height: 105px; background-image: url(./img/cinema.jpg); background-size: 140px;
                        box-shadow: 0 0 10px 10px #f0dbc2 inset"> </div>
        </div>

        <div align="center" style="width: 171px; height: 151px; background-image: url(./img/frame.jpg); background-size: 171px;
                    display: flex; justify-content: center; align-items: center;
                    text-decoration: none; color: white; font-size: 24px; font-weight: bold;
                    text-shadow: 5px 0 5px #640c0c, 0 5px 5px #640c0c, -5px 0 5px #640c0c, 0 -5px 5px #640c0c,
                                 5px 5px 5px #640c0c, -5px 5px 5px #640c0c, -5px -5px 5px #640c0c, 5px -5px 5px #640c0c">
            <a href="/cin" style="text-decoration: none; color: white">Main<br>Page</a>
        </div>

        <div align="center" style="width: 171px; height: 151px; background-image: url(./img/frame.jpg); background-size: 171px;
                    display: flex; justify-content: center; align-items: center;
                    text-decoration: none; color: white; font-size: 24px; font-weight: bold;
                    text-shadow: 5px 0 5px #640c0c, 0 5px 5px #640c0c, -5px 0 5px #640c0c, 0 -5px 5px #640c0c,
                                 5px 5px 5px #640c0c, -5px 5px 5px #640c0c, -5px -5px 5px #640c0c, 5px -5px 5px #640c0c">
            <a href="/cin/listSeance" style="text-decoration: none; color: white">Seance<br>Schedule</a>
        </div>

        <div align="center" style="width: 171px; height: 151px; background-image: url(./img/frame.jpg); background-size: 171px;
                    display: flex; justify-content: center; align-items: center;
                    color: white; font-size: 24px; font-weight: bold;
                    text-shadow: 5px 0 5px #640c0c, 0 5px 5px #640c0c, -5px 0 5px #640c0c, 0 -5px 5px #640c0c,
                                 5px 5px 5px #640c0c, -5px 5px 5px #640c0c, -5px -5px 5px #640c0c, 5px -5px 5px #640c0c">
            <c:if test="${currentUser == null}">
                Unknown<br>user
            </c:if>
            <c:if test="${currentUser != null}">
                <c:if test="${currentUser.role == 0}">
                    Current<br>user:
                </c:if>
                <c:if test="${currentUser.role == 1}">
                    Current<br>admin:
                </c:if>
            </c:if>
        </div>

        <div align="center" style="width: 171px; height: 151px; background-image: url(./img/frame.jpg); background-size: 171px;
                    display: flex; justify-content: center; align-items: center;
                    color: white; font-size: 24px; font-weight: bold;
                    text-shadow: 5px 0 5px #640c0c, 0 5px 5px #640c0c, -5px 0 5px #640c0c, 0 -5px 5px #640c0c,
                                 5px 5px 5px #640c0c, -5px 5px 5px #640c0c, -5px -5px 5px #640c0c, 5px -5px 5px #640c0c">
            <c:if test="${currentUser == null}">
                <a href="/cin/formLoginUser" style="text-decoration: none; color: white">Login</a>
            </c:if>
            <c:if test="${currentUser != null}">
                ${currentUser.name}<br>${currentUser.surname}
            </c:if>
        </div>

        <div align="center" style="width: 171px; height: 151px; background-image: url(./img/frame.jpg); background-size: 171px;
                    display: flex; justify-content: center; align-items: center;
                    text-decoration: none; color: white; font-size: 24px; font-weight: bold;
                    text-shadow: 5px 0 5px #640c0c, 0 5px 5px #640c0c, -5px 0 5px #640c0c, 0 -5px 5px #640c0c,
                                 5px 5px 5px #640c0c, -5px 5px 5px #640c0c, -5px -5px 5px #640c0c, 5px -5px 5px #640c0c">
            <c:if test="${currentUser == null}">
                <a href="/cin/formRegisterUser" style="text-decoration: none; color: white">Register</a>
            </c:if>
            <c:if test="${currentUser != null}">
                <a href="/cin/logoutUser" style="text-decoration: none; color: white">Logout</a>
            </c:if>
        </div>

        <div style="width: 171px; height: 151px; background-image: url(./img/frame.jpg); background-size: 171px;
                    display: flex; justify-content: center; align-items: center">
            <a href="/cin/bascket"><img src="./img/basket.png" style="width: 130px; box-shadow: 0px 0px 15px 10px #ffffff"></a>
        </div>
    </div>
</header>

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
                <a href="/cin/listGenre"><img src="./img/ticket.jpg" style="width: 200px; height: 200px">Просмотр билетов</a> <br>
            </div>
        </div>
    </c:if>

</body>
</html>
