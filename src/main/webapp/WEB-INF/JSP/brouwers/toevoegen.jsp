<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags' %>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>


<!doctype html>

<html lang='nl'>

<head><v:head title="Brouwer toevoegen"/></head>
	
<body>

<v:menu/>
	
	<h1><spring:message code="BrouwerToevoegen"/></h1>

	<c:url value="/brouwers/toevoegen" var="url"/>
	
	<form:form action="${url}" commandName="brouwer" method='post'>
		<jsp:include page="brouwerformfield.jsp"/>
		<input type="submit" value='<spring:message code="Toevoegen"/>'>
	</form:form>	

</body>
</html>