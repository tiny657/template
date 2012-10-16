<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>

<div class="container">
	<%-- alert --%>
	<div id="alertPosition">
		<div id="alert"></div>
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
						$("#alert").replaceWith("<div id=\"alertPosition\"><div id=\"alert\" class=\"alert alert-info\">Fail to like.</div></div>");
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
						$("#alert").replaceWith("<div id=\"alertPosition\"><div id=\"alert\"></div></div>");
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
						$("#alert").replaceWith("<div id=\"alertPosition\"><div id=\"alert\" class=\"alert alert-info\">Fail to dislike.</div></div>");
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
						$("#alertPosition").replaceWith("<div id=\"alertPosition\"><div id=\"alert\"></div></div>");
					}
				}
			});
		}
		
		$("textarea").autoresize();
	</script>
</div>