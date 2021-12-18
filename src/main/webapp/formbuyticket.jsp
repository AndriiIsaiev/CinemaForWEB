<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="currentPage" value="formbuyticket.jsp" scope="session"/>

<html>
<body style="max-width: 1200px">

<%@ include file="mainheader.jsp"%>

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
