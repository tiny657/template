<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>

<div class="container">
	<img class="thumbnail" src="http://graph.facebook.com/${member.providerUserId}/picture?type=large" />
	<h3 style="color:#0082CC">${member.name}</h3>
	<h4 style="color:#AAA">${member.email}</h4>
	<h4 style="color:#AAA">
		<c:choose>
			<c:when test="${member.gender}">
				<spring:message code="member.male" />	
			</c:when>
			<c:otherwise>
				<spring:message code="member.female" />	
			</c:otherwise>
		</c:choose>
	</h4>
	<h4 style="color:#AAA">${member.locale}</h4>

	<hr>

	<footer>
		<p>&copy; Company 2012</p>
	</footer>
</div>