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

<div style="max-width: 1200px">
	<div style="max-width: 1200px; display: flex; justify-content: center">
		<form action="bascket" method="get">
			<fieldset>
				<legend>Buy tickets</legend>
				<span style="color: red"> ${buyError} </span><br>
				Seance ${seanceDateTime}<br>
				Film ${film.getTitle()}<br>
				Length ${film.getLength()}<br>
				Cost ticket ${buySeance.getBaseCost()}grn<br>
				<div style="display: flex">
					<img src="${film.getPhotoURL()}" alt="Постер" /><br><br>
					<div style="padding-left: 20px">
						Free seats ${freeSeat}
						<table cellspacing="10" width: 900px style="font-size: 18px">
							<c:forEach begin="0" end="${maxLine}" var="xline">
								<tr>
									<span style="font-size: 24px">
										<td width: 9%>Ряд</td><td width: 7%>${xline + 1}</td>
									</span>
									<c:forEach begin="0" end="${maxPosition}" var="xposition">
										<c:if test="${hall[xline][xposition] == 0}">
											<td>
												<a href="reserveSeat?id=${hallId[xline][xposition]}"
													title="Free"
													style=" color: white;
													text-decoration: none;
													background: green;
													padding: 5px;
													margin: 5px;
													border-radius: 5px"
												>
												${xposition + 1}
												</a>
											</td>
										</c:if>
										<c:if test="${hall[xline][xposition] == 1}">
											<td>
												<a href="" onclick="return false"
													title="Bought"
													style=" color: white;
													text-decoration: none;
													background: darkgrey;
													padding: 5px;
													margin: 5px;
													border-radius: 5px"
												>
												${xposition + 1}
												</a>
											</td>
										</c:if>
										<c:if test="${hall[xline][xposition] == 2}">
											<td>
												<a href="reserveSeat?id=${hallId[xline][xposition]}"
													title="Reserved"
													style=" color: white;
													text-decoration: none;
													background: firebrick;
													padding: 5px;
													margin: 5px;
													border-radius: 5px"
												>
												${xposition + 1}
												</a>
											</td>
										</c:if>
										<c:if test="${hall[xline][xposition] == 3}">
											<td>
												<a href="" onclick="return false"
													title="Busy"
													style=" color: white;
													text-decoration: none;
													background: mediumorchid;
													padding: 5px;
													margin: 5px;
													border-radius: 5px"
												>
												${xposition + 1}
												</a>
											</td>
										</c:if>
									</c:forEach>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				Reserved ${reservedSeat.size()} seats:
				<c:forEach var="rSeat" items="${reservedSeat}">
					${rSeat.getLine()}-${rSeat.getPosition()}
				</c:forEach>
				<br>
				Total cost: ${reservedSeat.size() * buySeance.getBaseCost()}grn
				<br>
				<input type="submit" value="Buy">
			</fieldset>
		</form>
	</div>
	<div style="max-width: 1200px; display: flex; justify-content: center">
		<form> <button formaction="listSeance" formmethod="get">Back</button> </form>
	</div>
</div>


</body>
</html>
