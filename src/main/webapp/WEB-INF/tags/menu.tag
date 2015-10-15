<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<nav>
	<ol class="inlineLijst">
		<li><a href="<c:url value='/'/>">Hoofdpagina</a></li>
		<li><a href="<c:url value='/brouwers'/>">Alle brouwers</a></li>
		<li><a href="<c:url value='/brouwers/beginnaam'/>">Brouwers op naam</a></li>
		<li><a href="<c:url value='/brouwers/toevoegen'/>">Brouwer toevoegen</a></li>
	</ol>

</nav>