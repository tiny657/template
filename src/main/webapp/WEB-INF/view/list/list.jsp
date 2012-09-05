<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>

<div class="container">
	<div class="row">
		<div class="span12">
			<form:form method="post" action="/" modelAttribute="newDocument">
				<form:input type="text" path="title" class="span12" placeholder="Title" />
				<form:textarea path="content" rows="3" class="span12"></form:textarea>
				<button type="submit" class="btn">Save</button>
			</form:form>
		</div>
	</div>
	<div class="accordion" id="accordion2">
		<c:forEach var="document" items="${documents}">
			<div class="accordion-group">
				<div class="accordion-heading">
					<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapse${document.documentId}">${document.title}</a>
				</div>

				<div id="collapse${document.documentId}" class="accordion-body collapse">
					<div class="accordion-inner">${document.content}</div>
				</div>
			</div>
		</c:forEach>
	</div>

	<hr>

	<footer>
		<p>&copy; Company 2012</p>
	</footer>
</div>