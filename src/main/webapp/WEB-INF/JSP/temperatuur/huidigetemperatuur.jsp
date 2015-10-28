<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>

<!doctype html>
<html lang='nl'>

	<head><v:head title="temperatuur" /></head>
	<body>
		
		<c:choose>
			<c:when test="${empty fout}">
				<h1>In ${param.gemeente} is het &deg;C <fmt:formatNumber value="${temperatuur}"/></h1>
			</c:when>
			<c:otherwise>
				<h1 class='fout'>${fout}</h1>
			</c:otherwise>
		</c:choose>
	
	</body>
	
</html>