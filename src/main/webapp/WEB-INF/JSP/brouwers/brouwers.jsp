<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>

<!doctype html>

<html lang='nl'>

<head>
<v:head title="Alle brouwers" />
</head>

<body>

	<v:menu />

	<h1>Alle Brouwers</h1>

	<table>
		<thead>
			<tr>
				<th>Nummer</th>
				<th>Naam</th>
				<th>Straat</th>
				<th>HuisNr</th>
				<th>Postcode</th>
				<th>Gemeente</th>
				<th>Omzet</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="brouwer" items="${brouwers}">
				<tr>
					<td class='recht'>${brouwer.brouwerNr}</td>
					<td>${brouwer.naam}</td>
					<td>${brouwer.adres.straat}</td>
					<td>${brouwer.adres.huisNr}</td>
					<td>${brouwer.adres.postcode}</td>
					<td>${brouwer.adres.gemeente}</td>
					<td class='recht'><c:if test="${not empty brouwer.omzet}">${brouwer.omzet}</c:if>
						<c:if test="${empty brouwer.omzet}">nb</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>

</html>