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

	<h1>Brouwers op naam</h1>
	
	<c:url value='/brouwers/opnaam' var='url'/>
	
	<form:form action='${url}' commandName='deelVanNaam' method='get'>
		<form:label path="deelVanNaam">Begin van de naam</form:label>
		<form:input path="deelVanNaam" required='required' autofocus='autofocus' type='text'/>
		<input type='submit' value='zoeken'>
	</form:form>
	
	<v:lijstBrouwers brouwers='${brouwers}'/>
	
	</body>
	
</html>