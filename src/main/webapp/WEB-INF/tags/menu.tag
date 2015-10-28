<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>

<nav>
	<ol class="inlineLijst">
		<li><a href="<c:url value='/'/>"><spring:message code="Hoofdpagina"/></a></li>
		
		<li><a href="<c:url value='/brouwers'/>"><spring:message code="AlleBrouwers"/></a></li>
		
		<li><a href="<c:url value='/brouwers/beginnaam'/>"><spring:message code="BrouwersAlfabetisch"/></a></li>
		
		<li><a href="<c:url value='/brouwers/opnaam'/>"><spring:message code="BrouwersOpNaam"/></a></li>
		
		<li><a href="<c:url value='/brouwers/toevoegen'/>"><spring:message code="BrouwerToevoegen"/></a></li>
		
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