<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>

<!doctype html>

<html lang='nl'>

<head>
<v:head title="Alle brouwers" />
</head>

<body>

	<v:menu />

	<h1>
		<spring:message code="AlleBrouwers" />
	</h1>

	<table>
		<thead>
			<tr>
				<c:forEach var="titel"
					items="id,naam,adres.straat,adres.huisNr,adres.postcode,adres.gemeente,omzet,temperatuur">
					<th><c:set var="titelAsc" value="${titel},asc" /> 
						<spring:url	value="" var="url">
							<spring:param name="sort" value="${titel}${(param.sort != titelAsc)? ',asc' : ',desc'}" />
						</spring:url> 
						<a href="${url}"><spring:message code="${titel}" /> </a></th>
				</c:forEach>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="brouwer" items="${page.content}">
				<tr>
					<td class='recht'>${brouwer.id}</td>
					<td>${brouwer.naam}</td>
					<td>${brouwer.adres.straat}</td>
					<td>${brouwer.adres.huisNr}</td>
					<td>${brouwer.adres.postcode}</td>
					<td>${brouwer.adres.gemeente}</td>
					<td class='recht'>
						${(not empty brouwer.omzet)? brouwer.omzet : '<spring:message code="nb" />'}
					</td>
					<td>
						<fmt:message key='temperatuurEenheid' var='temperatuurEenheid'/>
						<spring:url value='/temperatuur/huidigetemperatuur/{gemeente}' var="temperatuururl">
							<spring:param name='gemeente' value='${brouwer.adres.gemeente}' />
						</spring:url>
						<a href="${temperatuururl}" title="<spring:message code="temperatuur" />">&rarr;</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pageNumbers">
		<span><spring:message code="paginas" /> </span>
		<c:forEach var='pageNr' begin="1" end="${page.totalPages}">
			<c:choose>
				<c:when test="${pageNr-1 == page.number}">
					<span class="geselecteerd">${pageNr}</span>
				</c:when>
				<c:otherwise>
					<spring:url value="" var="anderepaginaurl">
						<spring:param name="page" value="${pageNr-1}" />
						<spring:param name="sort" value="${param.sort}" />
					</spring:url>
					<a href="${anderepaginaurl}">${pageNr}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</div>

</body>

</html>