<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>

<!doctype html>

<html lang='nl'>

<head>
<v:head title="Brouwers op naam" />
</head>

<body>

	<v:menu />

	<h1><spring:message code="BrouwersOpNaam"/></h1>
	
	<c:url value='/brouwers/opnaam' var='url'/>
	
	<form:form action='${url}' commandName='deelVanNaam' method='get'>
		<div><form:label path="deelVanNaam"><spring:message code="DeelVanDeNaam"/></form:label></div>
		<div><form:input path="deelVanNaam" required='required' autofocus='autofocus' type='text'/></div>
		<div><input type='submit' value='<spring:message code="zoeken"/>'></div>
		<div class="fout"><form:errors class="fout" path="deelVanNaam"/></div>
	</form:form>
	
	<v:lijstBrouwers brouwers='${brouwers}'/>
	
	</body>
	
</html>