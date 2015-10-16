<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@attribute name='brouwers' required='true' type='java.util.List'%>



<c:if test="${not empty brouwers}">
		<ol class="namenLijst">
			<c:forEach var="brouwer" items="${brouwers}">
				<li>${brouwer.naam}</li>
			</c:forEach>
		</ol>
</c:if>
