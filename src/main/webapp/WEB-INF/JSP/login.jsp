<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='security'	uri='http://www.springframework.org/security/tags'%>


<!doctype html>

<html lang='nl'>

<head>
<v:head title="login" />
</head>

<body>


	<v:menu/>

	<h1><spring:message code="inloggen"/></h1>

	
	<form method='post'>
		<label>Gebruikersnaam:<input name='username' autofocus required></label> 
		<label>Paswoord:<input name='password' type='password' required></label>
		<security:csrfInput />
		<input type='submit' value='Aanmelden'>
	</form>

	<c:if test='${param.error != null}'>
		<div class='fout'><spring:message code="foutieveGebruikersnaamOfPaswoord"/></div>
	</c:if>
	


</body>

</html>