<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="currentPage" value="listseance.jsp" scope="session"/>

<html>
<body style="max-width: 1200px">

<%@ include file="mainheader.jsp"%>

<div style="max-width: 1200px">

	<br>
	<div style="text-align: center">
		<span style=" color: black; padding: 3px; margin: 5px"><fmt:message key="seance.Totalseances" /> ${seancePage.getAllSeance()}</span>

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
				><fmt:message key="seance.Addnewseance"/></a>
			</c:if>
		</c:if>

		<span style=" color: black; padding: 3px; margin: 5px"><fmt:message key="seance.Page" /> №</span>
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
			<input type="submit" value="<fmt:message key="seance.Seancesonpage" />"/>
		</form>
	</div>
	<br>

	<div style="text-align: center">
		<span style=" color: black; padding: 3px; margin: 5px"><fmt:message key="seance.Sortby"/></span>
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
			><fmt:message key="seance.Datetime" /></a>
		</c:if>
		<c:if test="${seancePage.getPageSort() == 'dateTime'}">
			<b><fmt:message key="seance.Datetime" /></b>
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
			><fmt:message key="seance.Filmtitle" /></a>
		</c:if>
		<c:if test="${seancePage.getPageSort() == 'filmId, dateTime'}">
			<b><fmt:message key="seance.Filmtitle" /></b>
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
			><fmt:message key="seance.Freeseat" /></a>
		</c:if>
		<c:if test="${seancePage.getPageSort() == 'freeSeat'}">
			<b><fmt:message key="seance.Freeseat" /></b>
		</c:if>
		<br><br>

		<form action="listSeance" style='display:inline; padding-left: 20px'>
			<input type="submit" value="<fmt:message key="seance.Filterby" />"/>

			<select name="newGenreIdFilter" style="padding: 2px 0px">
				<c:forEach var="fgenre" items="${seancePage.getListGenre()}">
					<option value="${fgenre.getId()}"
						<c:if test="${seancePage.getGenreIdFilter() == fgenre.getId()}">
							selected
						</c:if>
					>${fgenre.getName()}</option>
			</c:forEach>
			</select>
			<select name="newFilmIdFilter" style="padding: 2px 0px">
				<c:forEach var="ffilm" items="${seancePage.getListFilm()}">
					<option value="${ffilm.getId()}"
							<c:if test="${seancePage.getFilmIdFilter() == ffilm.getId()}">
								selected
							</c:if>
					>${ffilm.getTitle()}</option>
				</c:forEach>
			</select>

		</form>
	</div>

	<br>
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
					<fmt:message key="seance.Freeseat" /> ${xseance.getFreeSeat()}
				<br>
					<fmt:message key="seance.Ticketcost" /> ${xseance.getCost()}
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
					><fmt:message key="seance.Buytickets" /></a>

				</c:if>
				<c:if test="${currentUser != null && currentUser.role == 1}">
					<a href="formEditSeance?id=${xseance.getSeanceId()}"
					   style=" color: black;
						text-decoration: none;
						background: darkseagreen ;
						padding: 3px;
						margin: 5px;
						border-width: 1px;
						border-style: outset;
						border-color: green;
						border-radius: 2px"
					><fmt:message key="inall.Edit" /></a>
					<a href="deleteSeance?id=${xseance.getSeanceId()}"
					   style=" color: black;
						text-decoration: none;
						background: indianred ;
						padding: 3px;
						margin: 5px;
						border-width: 1px;
						border-style: outset;
						border-color: firebrick;
						border-radius: 2px"
					><fmt:message key="inall.Delete" /></a>
				</c:if>
			</div>
		</div>
		<br>
	</c:forEach>
	<br>
	<fmt:message key="seance.Totalseances" /> ${seancePage.getAllSeance()}

</div>

</body>
</html>
