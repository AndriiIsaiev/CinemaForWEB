<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ attribute name="button_action" required="true"%>
<%@ attribute name="button_href" required="true"%>
<%@ attribute name="button_color" required="true"%>

	<a href="${button_href}"
		style=" color: black;
		text-decoration: none;
		background: ${button_color};
		padding: 3px;
		margin: 5px;
		border-width: 1px;
		border-style: outset;
		border-color: black;
		border-radius: 2px"
	><fmt:message key="${button_action}"/></a>
