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