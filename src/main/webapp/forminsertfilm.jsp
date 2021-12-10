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

<div>
	<br>
	<c:choose>
		<c:when test="${currentUser != null && currentUser.role == 1}">
			Add new film
			<table>
				<form action="insertFilm" method="post">
					<tr><td>Film title</td>   <td><input name="title" value="${insertFilm.title}" ></td></tr>
					<tr><td>Year of issue</td><td><input name="year" value="${insertFilm.year}" pattern="^19{1}[0-9]{2}|^20{1}[0-9]{2}"></td></tr>
					<tr><td>Studio</td>       <td><input name="studio" value="${insertFilm.studio}" ></td></tr>
					<tr><td>Lenght</td>       <td><input name="length" value="${insertFilm.length}" type="time"></td></tr>
					<tr><td>Age categoory</td><td><input name="ageCategory" value="${insertFilm.ageCategory}" ></td></tr>
					<tr><td>Description</td>  <td><input name="description" value="${insertFilm.description}" size="60" ></td></tr>
					<tr><td>Photo name</td>   <td><input name="photoURL" value="./img/${insertFilm.photoURL}" type="file" ></td></tr>
					<tr><td><input type="submit" value="Add"></td></tr>
				</form>
			</table>
			<form> <button formaction="listFilm" formmethod="get">Back</button> </form>
		</c:when>
		<c:otherwise>
			<br><br>
			<p style="font-size: 24px; text-align: center"> Access denied</p>
		</c:otherwise>
	</c:choose>
</div>
</div>

</body>
</html>
