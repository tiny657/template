<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>

<div class="container">
	<%-- alert --%>
	<div id="alertPosition"></div>
	<div id="posting" class="alert alert-info" style="display:none">
		Posting...<img src="/img/wait24trans.gif" />
	</div>
	
	<div>
		<table class="table table-striped">
			<tbody>
				<%-- waiting icon --%>
				<tr id="waitingDocument" style="display: none;"><td>
					<img src="/img/wait24trans.gif" id="waitingDocument" />
				</td></tr>
		
				<%-- document one --%>
				<%@include file="document.jsp"%>
			</tbody>
		</table>
	</div>
	
	<script type="text/javascript">
		function post(documentId) {
			$.ajax({
				type : "POST",
				url : "/post",
				dataType: "text",
				data: {"content": $("#content" + documentId).text()},
				beforeSend: function() {
					$("#posting").css("display", "");
					$("#postAlert").remove();
				},
				success : function(content) {
					$("#posting").css("display", "none");
					$("#alertPosition").after(content);
				}
			});
		}
		
		function saveComment(documentId) {
			$.ajax({
				type : "POST",
				url : "/comment",
				dataType: "text",
				data: {"documentId": documentId, "content": $("#newComment" + documentId).val()},
				beforeSend: function() {
					$("#waitingComment" + documentId).css("display", "inline");
				},
				success : function(content) {
					$("#waitingComment" + documentId).css("display", "none");
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
					$("#document" + documentId).remove();
				}
			});
		}
		
		function deleteComment(commentId) {
			$.ajax({
				type : "POST",
				url : "/comment",
				dataType: "text",
				data: {"commentId": commentId, _method: "DELETE"},
				success : function() {
					$("#comment" + commentId).remove();
				}
			});
		}
		$("textarea").autoresize();
	</script>
</div>