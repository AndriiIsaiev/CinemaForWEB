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

	<br>
	<div style="text-align: center">
		<span style=" color: black; padding: 3px; margin: 5px">Total ${seancePage.getAllSeance()} seances</span>

		<c:if test="${currentUser != null}">
			<c:if test="${currentUser.role == 1}">
				<a href="formInsertSeance?id=-1"
				   style=" color: black;
					text-decoration: none;
					background: rgb(240,240,240);
					padding: 3px;
					margin: 5px;
					border-width: 1px;
					border-style: outset;
					border-color: black;
					border-radius: 2px"
				>Add new seance</a>
			</c:if>
		</c:if>

		<span style=" color: black; padding: 3px; margin: 5px">Page №</span>
		<c:if test="${seancePage.getPageNumber() > 1}">
			<a href="listSeance?newPage=1"
			   style=" color: black;
				text-decoration: none;
				background: rgb(240,240,240);
				padding: 1px 3px;
				margin: 2px;
				border-width: 1px;
				border-style: outset;
				border-color: black;
				border-radius: 2px"
			>1</a>
		</c:if>
		<c:if test="${seancePage.getPageNumber() == 1}">
			<span style=" color: black; padding: 1px 3px; margin: 2px">1</span>
		</c:if>

		<c:if test="${seancePage.getPageNumber() > 3}">
			<span style=" color: black; padding: 1px 3px; margin: 2px">...</span>
		</c:if>

		<c:if test="${seancePage.getPageNumber() == 2}">
			<span style=" color: black; padding: 1px 3px; margin: 2px">2</span>
		</c:if>

		<c:if test="${seancePage.getPageNumber() > 2}">
			<a href="listSeance?newPage=${seancePage.getPageNumber() - 1}"
			   style=" color: black;
				text-decoration: none;
				background: rgb(240,240,240);
				padding: 1px 3px;
				margin: 2px;
				border-width: 1px;
				border-style: outset;
				border-color: black;
				border-radius: 2px"
			>${seancePage.getPageNumber() - 1}</a>
			<span style=" color: black; padding: 1px 3px; margin: 2px">${seancePage.getPageNumber()}</span>
		</c:if>

		<c:if test="${seancePage.getPageNumber() < seancePage.getPageMax() - 1}">
			<a href="listSeance?newPage=${seancePage.getPageNumber() + 1}"
			   style=" color: black;
				text-decoration: none;
				background: rgb(240,240,240);
				padding: 1px 3px;
				margin: 2px;
				border-width: 1px;
				border-style: outset;
				border-color: black;
				border-radius: 2px"
			>${seancePage.getPageNumber() + 1}</a>
		</c:if>

		<c:if test="${seancePage.getPageNumber() < seancePage.getPageMax() - 2}">
			<span style=" color: black; padding: 1px 3px; margin: 2px">...</span>
		</c:if>

		<c:if test="${seancePage.getPageNumber() < seancePage.getPageMax()}">
			<a href="listSeance?newPage=${seancePage.getPageMax()}"
			   style=" color: black;
				text-decoration: none;
				background: rgb(240,240,240);
				padding: 1px 3px;
				margin: 2px;
				border-width: 1px;
				border-style: outset;
				border-color: black;
				border-radius: 2px"
			>${seancePage.getPageMax()}</a>
		</c:if>

		<form action="listSeance" style='display:inline; padding-left: 20px'>
			<select name="newPageSize" style="padding: 2px 0px">
				<option value="5"
					<c:if test="${seancePage.getPageSize() == 5}">
						selected
					</c:if>
				>5</option>
				<option value="10"
					<c:if test="${seancePage.getPageSize() == 10}">
						selected
					</c:if>
				>10</option>
				<option value="25"
					<c:if test="${seancePage.getPageSize() == 25}">
						selected
					</c:if>
				>25</option>
				<option value="100"
					<c:if test="${seancePage.getPageSize() == 100}">
						selected
					</c:if>
				>100</option>
			</select>
			<input type="submit" value="Seance on page"/>
		</form>
	</div>
	<br><br>

	<div style="text-align: center">
		<span style=" color: black; padding: 3px; margin: 5px">Sort by</span>
		<c:if test="${seancePage.getPageSort() != 'dateTime'}">
			<a href="listSeance?seanceSort=dateTime"
			style=" color: black;
							text-decoration: none;
							background: rgb(240,240,240);
						padding: 1px 3px;
						margin: 2px;
							border-width: 1px;
							border-style: outset;
							border-color: black;
							border-radius: 2px"
			>Date time</a>
		</c:if>
		<c:if test="${seancePage.getPageSort() == 'dateTime'}">
			<b>Date time</b>
		</c:if>

		<c:if test="${seancePage.getPageSort() != 'filmId, dateTime'}">
			<a href="listSeance?seanceSort=filmId, dateTime"
			   style=" color: black;
						text-decoration: none;
						background: rgb(240,240,240);
						padding: 1px 3px;
						margin: 2px;
						border-width: 1px;
						border-style: outset;
						border-color: black;
						border-radius: 2px"
			>Film</a>
		</c:if>
		<c:if test="${seancePage.getPageSort() == 'filmId, dateTime'}">
			<b>Film</b>
		</c:if>

		<c:if test="${seancePage.getPageSort() != 'freeSeat'}">
			<a href="listSeance?seanceSort=freeSeat"
			   style=" color: black;
						text-decoration: none;
						background: rgb(240,240,240);
						padding: 1px 3px;
						margin: 2px;
						border-width: 1px;
						border-style: outset;
						border-color: black;
						border-radius: 2px"
			>Free seat</a>
		</c:if>
		<c:if test="${seancePage.getPageSort() == 'freeSeat'}">
			<b>Free seat</b>
		</c:if>

		<form action="listSeance" style='display:inline; padding-left: 20px'>
			<input type="submit" value="Filter by"/>

			<select name="newGenreIdFilter" style="padding: 2px 0px">
				<c:forEach var="fgenre" items="${seancePage.getListGenre()}">
					<option value="${fgenre.getId()}"
						<c:if test="${seancePage.getGenreIdFilter() == fgenre.getId()}">
							selected
						</c:if>
					><img src="./img/comedy.jpg" style="width: 30px;"> ${fgenre.getName()}</option>
			</c:forEach>
			</select>

		</form>
	</div>

	<br><br>
	<c:forEach var="xseance" items="${seanceList}">
		<div style="display: flex; justify-content: center; font-size: 16px">
			<div>
				<img src="${xseance.getFilmPhoto()}" alt="Постер" />
			</div>
			<div style="width: 500px; padding: 10px 50px 10px 30px; padding-left: 30px; background: lightgoldenrodyellow ">
				${xseance.getSeanceDateTime()}
				<br><br>
				<b style="font-size: 24px"> ${xseance.getFilmTitle()}</b>
				<br><br>
				<c:forEach var="xgenre" items="${xseance.getGenre()}">
					-${xgenre.getName()} <br>
				</c:forEach>
				<br>
				Free seats ${xseance.getFreeSeat()}
				<br>
				Ticket price ${xseance.getCost()}
				<c:if test="${(currentUser != null) && (xseance.getAfterNow())}">
					<a href="formBuyTicket?id=${xseance.getSeanceId()}"
						style=" color: black;
						text-decoration: none;
						background: rgb(240,240,240);
						padding: 3px;
						margin: 5px;
						border-width: 1px;
						border-style: outset;
						border-color: black;
						border-radius: 2px"
					>Buy ticket</a>
				</c:if>
			</div>
		</div>
		<br>
	</c:forEach>
	<br>
	Total ${seancePage.getAllSeance()} films

</div>

</body>
</html>