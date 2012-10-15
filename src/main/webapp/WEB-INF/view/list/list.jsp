<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>

<div class="container">
	<%-- alert --%>
	<div id="alertPosition">
		<div id="alert"></div>
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
			var comment = parseInt($("#comment" + documentId).text());
			$("#comment" + documentId).text(comment + 1);
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
		
		function deleteComment(documentId, commentId) {
			var comment = parseInt($("#comment" + documentId).text());
			$("#comment" + documentId).text(comment - 1);
			$.ajax({
				type : "POST",
				url : "/comment",
				dataType: "text",
				data: {"documentId": documentId, "commentId": commentId, _method: "DELETE"},
				beforeSend: function() {
				},
				success : function() {
					$("#commentBox" + commentId).remove();
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
				},
				success : function(content) {
					$("#alert").replaceWith(content);
				}
			});
		}
				
		function like(documentId) {
			$.ajax({
				type : "GET",
				url : "/like",
				dataType: "text",
				data: {"documentId": documentId},
				success : function(isSuccess) {
					if (isSuccess === "true") {
						var like = parseInt($("#like" + documentId).text());
						$("#like" + documentId).text(like + 1);
						$("#cancelLike" + documentId).css("display", "");
						$("#alert").replaceWith("<div id=\"alert\"></div>");
					}
					else {
						$("#alert").replaceWith("<div id=\"alert\" class=\"alert alert-info\">Fail to like.</div>");
					}
				}
			});
		}
		
		function cancelLike(documentId) {
			$.ajax({
				type : "GET",
				url : "/cancelLike",
				dataType: "text",
				data: {"documentId": documentId},
				success : function(isSuccess) {
					if (isSuccess === "true") {
						var like = parseInt($("#like" + documentId).text());
						$("#like" + documentId).text(like - 1);
						$("#cancelLike" + documentId).css("display", "none");
						$("#alert").replaceWith("<div id=\"alert\"></div>");
					}
				}
			});
		}
		
		function dislike(documentId) {
			$.ajax({
				type : "GET",
				url : "/dislike",
				dataType: "text",
				data: {"documentId": documentId},
				success : function(isSuccess) {
					if (isSuccess === "true") {
						var dislike = parseInt($("#dislike" + documentId).text());
						$("#dislike" + documentId).text(dislike + 1);
						$("#cancelDislike" + documentId).css("display", "");
						$("#alert").replaceWith("<div id=\"alert\"></div>");
					}
					else {
						$("#alert").replaceWith("<div id=\"alert\" class=\"alert alert-info\">Fail to dislike.</div>");
					}
				}
			});
		}
		
		function cancelDislike(documentId) {
			$.ajax({
				type : "GET",
				url : "/cancelDislike",
				dataType: "text",
				data: {"documentId": documentId},
				success : function(isSuccess) {
					if (isSuccess === "true") {
						var dislike = parseInt($("#dislike" + documentId).text());
						$("#dislike" + documentId).text(dislike - 1);
						$("#cancelDislike" + documentId).css("display", "none");
						$("#alert").replaceWith("<div id=\"alert\"></div>");
					}
				}
			});
		}
		
		$("textarea").autoresize();
	</script>
</div>