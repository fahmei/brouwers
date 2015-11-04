<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='security' uri='http://www.springframework.org/security/tags'%>

<nav>
	<!-- Login/logout -->
		<div class="login">
			<security:authorize access='isAnonymous()'>
				<a href="<c:url value='/login'/>"><spring:message code='aanmelden'/></a>
			</security:authorize>
			
			<security:authorize access='isAuthenticated()'>
				<form method='post' action='<c:url value="/logout"/>' id='logoutform'>
					<input type='submit' value='<spring:message code='afmelden'/>' id='logoutbutton'>
					<security:csrfInput/>
				</form>
			</security:authorize>
		</div>

	<ol class="inlineLijst">
		
		<!-- Menu's -->
		<security:authorize access='isAuthenticated()'>
			<li><a href="<c:url value='/'/>"><spring:message code="Hoofdpagina"/></a></li>
			
			<li><a href="<c:url value='/brouwers'/>"><spring:message code="AlleBrouwers"/></a></li>
			
			<li><a href="<c:url value='/brouwers/beginnaam'/>"><spring:message code="BrouwersAlfabetisch"/></a></li>
			
			<li><a href="<c:url value='/brouwers/opnaam'/>"><spring:message code="BrouwersOpNaam"/></a></li>
			
			<security:authorize access='hasAuthority("administrator")'>
				<li><a href="<c:url value='/brouwers/toevoegen'/>"><spring:message code="BrouwerToevoegen"/></a></li>
			</security:authorize>
		</security:authorize>
		
		
		
		<!-- Languages -->
		
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