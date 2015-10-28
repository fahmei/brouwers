<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>


<form:label path="naam"><spring:message code="naam"/> <form:errors path='naam'/></form:label>
<form:input path='naam' autofocus='autofocus'/>

<form:label path="adres.straat"><spring:message code="adres.straat"/> <form:errors path='adres.straat'/></form:label>
<form:input path='adres.straat'/>

<form:label path="adres.huisNr"><spring:message code="adres.huisNr"/> <form:errors path='adres.huisNr'/></form:label>
<form:input path='adres.huisNr'/>

<form:label path="adres.postcode"><spring:message code="adres.postcode"/> <form:errors path='adres.postcode'/></form:label>
<form:input path='adres.postcode'/>

<form:label path="adres.gemeente"><spring:message code="adres.gemeente"/> <form:errors path='adres.gemeente'/></form:label>
<form:input path='adres.gemeente'/>

<form:label path="omzet"><spring:message code="omzet"/> <form:errors path='omzet'/></form:label>
<form:input path='omzet'/>

