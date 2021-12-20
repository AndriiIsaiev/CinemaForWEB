<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://com.abi.cinema.tag" prefix="xxlib" %>

<c:set var="currentPage" value="formconfirmbuy.jsp" scope="session"/>

<html>
<body style="max-width: 1200px">

<%@ include file="mainheader.jsp"%>

<div style="text-align: center">

	<c:if test="${sizeAllTicket == 0}">
	<br><br><br>
		<fmt:message key="seance.Bascketisempty" />
	</c:if>

	<c:if test="${sizeAllTicket > 0}">
		<div>
			<br>
			<fmt:message key="seance.Confirmbuytickets" /> ${sizeAllTicket}
			<jsp:useBean id="date" class="java.util.Date"/>
			<fmt:message key="seance.Currenttime" />
			<fmt:formatDate var="time" value="${date}" pattern="HH:mm:ss"/>
			${time}
			<br><br>
			<center>
			<table border="1" cellpadding="5">
				<tr>
					<th><fmt:message key="seance.Datetimeseance" /></th><th><fmt:message key="seance.Filmtitle" /></th>
					<th><fmt:message key="seance.Seat" /></th><th><fmt:message key="seance.Cost" /></th>
					<th><fmt:message key="seance.Endofreservation" /></th>
				</tr>
				<c:forEach begin="0" end="${sizeAllTicket - 1}" var="xticket">
					<tr>
						<td>${buyTicket.get(xticket).getDateTime()}</td>
						<td>${buyTicket.get(xticket).getFilmName()}</td>
						<td>Seat ${line[xticket]}-${position[xticket]}</td>
						<td>${buyTicket.get(xticket).getCost()}</td>
						<td><xxlib:buytimeend buyTime="${buyTicket.get(xticket).getBuyTime()}" /> </td>
					</tr>
				</c:forEach>
			</table>
			</center>
			<br>
			<fmt:message key="seance.Totalcost" /> ${totalTotalCost} <fmt:message key="seance.grn" />
		</div>
		<br>
		<a href="payTicket"
		   style=" color: black;
					text-decoration: none;
					background: rgb(240,240,240);
					padding: 3px;
					margin: 5px;
					border-width: 1px;
					border-style: outset;
					border-color: black;
					border-radius: 2px"
		><fmt:message key="seance.Puyfortickets" /></a>
	</c:if>

</div>
</body>
</html>
