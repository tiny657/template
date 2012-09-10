<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>

<div class="container">
	<img src="/profileImage" />
	<ul>
		<li>${member.nickName}</li>
		<li>${member.email}</li>
	</ul>

	<hr>

	<footer>
		<p>&copy; Company 2012</p>
	</footer>
</div>