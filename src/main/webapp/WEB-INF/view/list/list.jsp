<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>

<div class="container">
	<div class="row">
		<div class="span12">
			<input type="text" id="title" path="title" class="span12" placeholder="title" />
			<textarea path="content" id="content" class="span12" placeholder="contents"></textarea>
			<button type="submit" class="btn btn-info" onclick="saveDocument()" id="save">Save</button>
			<br /><br />
		</div>
	</div>
	<div class="accordion" id="accordion2">
		<div id="firstDocumentPosition"></div>
		<c:forEach var="document" items="${documents}">
			<%@include file="document.jsp"%>
		</c:forEach>
	</div>
	
	<hr>
	
	<footer>
		<p>&copy; Company 2012</p>
	</footer>
	
	<script type="text/javascript">
		function saveDocument() {
			$.ajax({
				type : "POST",
				url : "/document",
				dataType: "text",
				data: {"title": $("#title").val(), "content": $("#content").val()},
				success : function(content) {
					$("#title").val('');
					$("#content").val('');
					$("div#firstDocumentPosition").after(content);
				}
			});
		}
				
		function saveComment(documentId) {
			$.ajax({
				type : "POST",
				url : "/comment",
				dataType: "text",
				data: {"documentId": documentId, "content": $("#newComment" + documentId).val()},
				success : function(content) {
					$("#newComment" + documentId).val('');
					$("blockquote#lastCommentPosition" + documentId).before(content);
				}
			});
		}
		
		function deleteDocument(documentId) {
			$.ajax({
				type : "POST",
				url : "/document",
				dataType: "text",
				data: {"documentId": documentId, _method: "DELETE"},
				success : function() {
					$("div#document" + documentId).remove();
				}
			});
		}
		$('textarea').autoresize();
	</script>
</div>