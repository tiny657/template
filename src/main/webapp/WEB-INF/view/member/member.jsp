<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>

<div class="container">
	<img class="thumbnail" src="http://graph.facebook.com/${member.userId}/picture?type=large" />
	<h3 style="color:#0082CC">${member.name}</h3>
	<h4 style="color:#AAA">${member.email}</h4>

	<hr>

	<footer>
		<p>&copy; Company 2012</p>
	</footer>
</div>