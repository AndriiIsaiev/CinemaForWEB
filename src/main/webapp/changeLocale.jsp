<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${currentLocale == null}">
    <c:set var="currentLocale" value="en" scope="session"/>
</c:if>

<c:choose>
    <c:when test="${currentLocale == 'ru'}">
        <fmt:setLocale value="en" scope="session"/>
        <c:set var="currentLocale" value="en" scope="session"/>
    </c:when>
    <c:when test="${currentLocale == 'en'}">
        <fmt:setLocale value="ru" scope="session"/>
        <c:set var="currentLocale" value="ru" scope="session"/>
    </c:when>
</c:choose>

<jsp:forward page="${currentPage}"/>