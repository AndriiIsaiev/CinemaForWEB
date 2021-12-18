<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<c:set var="currentPage" value="adminpage.jsp" scope="session"/>

<html>
<body style="max-width: 1200px">

<sql:query var="rs" dataSource="jdbc/cinema">
    SELECT genre.*, COUNT(ticket.id) AS ticketid, SUM(ticket.cost) AS ticketcost FROM genre INNER JOIN film_genre ON genre.id=film_genre.genreId INNER JOIN film ON film_genre.filmId=film.id INNER JOIN seance ON film.id=seance.filmId INNER JOIN ticket ON seance.id=ticket.seanceId GROUP BY genre.id ORDER BY -SUM(ticket.cost)
</sql:query>

<table border="1">
<tr><td>Id</td><td>Name</td><td>Sum</td><td>Tickets</td></tr>
<c:forEach var="row" items="${rs.rows}">
    <tr><td>${row.id}</td><td>${row.name}</td><td>${row.ticketcost}</td><td>${row.ticketid}</td></tr>
</c:forEach>
</table>

<br><br>

<sql:query var="rs" dataSource="jdbc/cinema">
    SELECT user.*, COUNT(ticket.id) AS ticketid, SUM(ticket.cost) AS ticketcost FROM user INNER JOIN ticket ON user.id=ticket.userId GROUP BY user.id ORDER BY -SUM(ticket.cost)
</sql:query>

<table border="1">
    <tr><td>Id</td><td>Name Surname</td><td>Sum</td><td>Tickets</td></tr>
<c:forEach var="row" items="${rs.rows}">
    <tr><td>${row.id}</td><td>${row.name} ${row.surname}</td><td>${row.ticketcost}</td><td>${row.ticketid}</td></tr>
</c:forEach>
</table>

</body>
</html>
