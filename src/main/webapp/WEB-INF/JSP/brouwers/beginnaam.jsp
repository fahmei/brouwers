<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>

<!doctype html>

<html lang='nl'>

<head>
<v:head title="Brouwers alfabetisch" />
</head>

<body>

	<v:menu />

	<h1><spring:message code="BrouwersAlfabetisch"/></h1>

	<ol class="inlineLijst">
		<c:forEach var="letter" items="${letters}">
			<li><a
				href=" 	<spring:url value="/brouwers/beginnaam/{gekozenLetter}">
							<spring:param name='gekozenLetter' value='${letter}'/>
						</spring:url>">
					${letter} </a></li>
		</c:forEach>
	</ol>

	<v:lijstBrouwers brouwers='${brouwers}'/>
</body>

</html>