<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>

<%-- document list --%>
<c:forEach var="document" items="${documents}">
	<%@include file="document.jsp"%>
</c:forEach>

<c:choose>
	<c:when test="${empty documents}">
		<span id="newest" style="display: none;">0</span>
	</c:when>
	<c:otherwise>
		<span id="newest" style="display: none;">${documents[0].documentId}</span>
	</c:otherwise>
</c:choose>

<%-- waiting icon --%>
<c:if test="${more}">
	<tr id="moreDocument"><td>
		<img src="img/wait24trans.gif" />
		<span id="oldest" style="display: none;">${documentId}</span>
	</td></tr>
</c:if>