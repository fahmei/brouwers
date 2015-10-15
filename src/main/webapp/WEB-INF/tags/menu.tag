<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<nav>
	<ol class="inlineLijst">
		<li><a href="<c:url value='/'/>">Hoofdpagina</a></li>
		<li><a href="<c:url value='/brouwers'/>">Alle brouwers</a></li>
		<li><a href="<c:url value='/brouwers/beginnaam'/>">Brouwers op naam</a></li>
		<li><a href="<c:url value='/brouwers/toevoegen'/>">Brouwer toevoegen</a></li>
		
		<c:if test='${pageContext.response.locale.language != "nl"}'>
			<c:url value='' var='nederlandsURL'>
				<c:param name='locale' value='nl_be' />
			</c:url>
			<li><a href='${nederlandsURL}'>Nederlands</a></li>
		</c:if>
		<c:if test='${pageContext.response.locale.language != "en"}'>
			<c:url value='' var='engelsURL'>
				<c:param name='locale' value='en_us' />
			</c:url>
			<li><a href='${engelsURL}'>Engels</a></li>
		</c:if>
		
	</ol>

</nav>