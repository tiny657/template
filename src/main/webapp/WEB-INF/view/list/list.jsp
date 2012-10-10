<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>

<div class="container">
	<%-- alert --%>
	<div id="alertPosition"></div>
	<div id="posting" class="alert alert-info" style="display:none">
		Posting...<img src="/img/wait24trans.gif" />
	</div>
	
	<%-- new document form --%>
	<div class="row">
		<div class="span12">
			<textarea path="content" id="content" class="span12" placeholder="contents"></textarea>
			<button type="submit" id="save" class="btn btn-info" onclick="saveDocument()">Save</button>
			<br />
			<br />
		</div>
	</div>

	<div>
		<table class="table table-striped">
			<tbody>
				<%-- waiting icon --%>
				<tr id="waitingDocument" style="display: none;"><td>
					<img src="img/wait24trans.gif" id="waitingDocument" />
				</td></tr>
		
				<%-- document list --%>
				<c:forEach var="document" items="${documents}">
					<%@include file="document.jsp"%>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<script type="text/javascript">
		function saveDocument() {
			$.ajax({
				type : "POST",
				url : "/document",
				dataType: "text",
				data: {"content": $("#content").val()},
				beforeSend: function() {
					$("#waitingDocument").css("display", "");
				},
				success : function(content) {
					$("#waitingDocument").css("display", "none");
					$("#content").val('');
					$("#waitingDocument").after(content);
					$("textarea").autoresize();
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
		
		function post(documentId) {
			$.ajax({
				type : "POST",
				url : "/post",
				dataType: "text",
				data: {"documentId" : documentId, "content": $("#content" + documentId).text()},
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
				
		function like(documentId) {
			var countToLike = parseInt($("#countToLike${documentId}").text());
			$("#countToLike${documentId}").text(countToLike + 1);
			$.ajax({
				type : "GET",
				url : "/like",
				dataType: "text",
				data: {"documentId": documentId},
				success : function() {
				}
			});
		}
		
		function dislike(documentId) {
			var countToDislike = parseInt($("#countToDislike${documentId}").text());
			$("#countToDislike${documentId}").text(countToDislike + 1);
			$.ajax({
				type : "GET",
				url : "/dislike",
				dataType: "text",
				data: {"documentId": documentId},
				success : function() {
				}
			});
		}
		
		function comment(documentId) {
			$.ajax({
				type : "GET",
				url : "/dislike",
				dataType: "text",
				data: {"documentId": documentId},
				success : function(content) {
				}
			});
		}
		
		$("textarea").autoresize();
	</script>
</div>