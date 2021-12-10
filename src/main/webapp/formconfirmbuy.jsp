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

	<c:if test="${sizeAllTicket == 0}">
	<br><br><br>
		Bascket is free
	</c:if>

	<c:if test="${sizeAllTicket > 0}">
		<div>
			<br>
			Confirm buy ${sizeAllTicket} ticket
			<br><br>
			<table border="1" cellpadding="5">
				<tr>
					<th>Date time</th><th>Film Title</th><th>Seat</th><th>Cost</th>
				</tr>
				<c:forEach begin="0" end="${sizeAllTicket - 1}" var="xticket">
					<tr>
						<td>${buyTicket.get(xticket).getDateTime()}</td>
						<td>${buyTicket.get(xticket).getFilmName()}</td>
						<td>Seat ${line[xticket]}-${position[xticket]}</td>
						<td>${buyTicket.get(xticket).getCost()}</td>
					</tr>
				</c:forEach>
			</table>
			<br>
			Total cost ${totalTotalCost} grn
		</div>
	</c:if>

</body>
</html>
