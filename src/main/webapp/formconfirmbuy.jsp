<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body style="max-width: 1200px">

<%@ include file="mainheader.jsp"%>

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
		>Pay for tickets</a>
	</c:if>

</body>
</html>
