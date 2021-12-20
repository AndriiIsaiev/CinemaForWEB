<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="mylib" tagdir="/WEB-INF/tags" %>

<c:set var="currentPage" value="formbuyticket.jsp" scope="session"/>

<html>
<body style="max-width: 1200px">

<%@ include file="mainheader.jsp"%>

<div style="max-width: 1200px">
	<div style="max-width: 1200px; display: flex; justify-content: center">
		<form action="bascket" method="get">
			<fieldset>
				<legend><fmt:message key="seance.Buytickets" /></legend>
				<span style="color: red"> <fmt:message key="${buyError}" /> </span><br>
				<fmt:message key="seance.Seance" /> ${seanceDateTime}<br>
				<fmt:message key="seance.Film" /> ${film.getTitle()}<br>
				<fmt:message key="seance.Length" /> ${film.getLength()}<br>
				<fmt:message key="seance.Ticketcost" /> ${buySeance.getBaseCost()}grn<br>
				<div style="display: flex">
					<img src="${film.getPhotoURL()}" alt="Постер" /><br><br>
					<div style="padding-left: 20px">
						<fmt:message key="seance.Freeseat" /> ${freeSeat}
						<table cellspacing="10" width: 900px style="font-size: 18px">
							<c:forEach begin="0" end="${maxLine}" var="xline">
								<tr>
									<span style="font-size: 24px">
										<td width: 9%><fmt:message key="seance.Row" /></td><td width: 7%>${xline + 1}</td>
									</span>
									<c:forEach begin="0" end="${maxPosition}" var="xposition">
										<c:if test="${hall[xline][xposition] == 0}">
											<td>
												<a href="reserveSeat?id=${hallId[xline][xposition]}"
													title="<fmt:message key="seance.Available" />"
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
													title="<fmt:message key="seance.Occupied" />"
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
													title="<fmt:message key="seance.Selected" />"
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
													title="<fmt:message key="seance.Reserved" />"
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
				<fmt:message key="seance.Reservedseats" /> ${reservedSeat.size()}:
				<c:forEach var="rSeat" items="${reservedSeat}">
					${rSeat.getLine()}-${rSeat.getPosition()}
				</c:forEach>
				<br>
				<fmt:message key="seance.Totalcost" /> ${reservedSeat.size() * buySeance.getBaseCost()}grn
				<br>
				<input type="submit" value="<fmt:message key="seance.Puyfortickets" />">
			</fieldset>
		</form>
	</div>
	<div style="max-width: 1200px; display: flex; justify-content: center">
		<form> <button formaction="listSeance" formmethod="get"><fmt:message key="inall.Back" /></button> </form>
	</div>
</div>


</body>
</html>
