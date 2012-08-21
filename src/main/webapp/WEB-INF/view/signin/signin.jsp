<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container">
	<form action="<c:url value="/signin/facebook" />" method=POST>
		<button type="submit">Sign in with Facebook</button>
		<input type="hidden" name="scope" value="email,publish_stream,offline_access" />
	</form>
</div>
