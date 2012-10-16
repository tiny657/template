<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>

<div id="container" class="container">
	<%-- alert --%>
	<div id="alertPosition">
		<div id="alert"></div>
	</div>
	
	<%-- new document form --%>
	<div class="row">
		<div class="span12">
			<textarea path="rawContent" id="newDocument" class="span12" placeholder="contents"></textarea>
			<button type="submit" class="btn btn-info" onclick="saveDocument()">Save</button>
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
				data: {"rawContent": $("#newDocument").val()},
				beforeSend: function() {
					$("#waitingDocument").css("display", "");
				},
				success : function(content) {
					$("#waitingDocument").css("display", "none");
					$("#newDocument").val('');
					$("#waitingDocument").after(content);
					$("textarea").autoresize();
				}
			});
		}
		
		function enableCloseEditContent(documentId) {
			$(document).bind("click", function(event) {
				var id = event.target.id;
				if(id != "rawContent" + documentId && id != "updateRawContent" + documentId && id != "deleteRawContent" + documentId) {
					$("#divContent" + documentId).css("display", "");
					$("#editContent" + documentId).css("display", "none");
					$(document).unbind("click");
				}
			});
		}
		
		function clickDocument(documentId) {
			$("#divContent" + documentId).css("display", "none");
			$("#editContent" + documentId).css("display", "");
			$("#rawContent" + documentId).focus();
			<%-- 열리자 마자 바로 닫히는 것 방지 --%>
			var timer = setInterval(function() {
				enableCloseEditContent(documentId);
				clearInterval(timer);
				}, 100);
		}
		
		
		function updateDocument(documentId) {
			$.ajax({
				type : "POST",
				url : "/document",
				dataType: "text",
				data: {"documentId" : documentId, "rawContent": $("#rawContent" + documentId).val(), _method: "PUT"},
				beforeSend: function() {
				 	$("#updateRawContent" + documentId).html("Updating...");
				},
				success : function(content) {
				 	$("#updateRawContent" + documentId).html("Update");
				  	$("#editContent" + documentId).css("display", "none");
					$("#divContent" + documentId).css("display", "");
					$("#content" + documentId).html(content);
					<%-- focus out으로 나가지 않은 경우이기 때문에 unbind 해 주어야 함. --%>
					$(document).unbind("click");
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
					<%-- focus out으로 나가지 않은 경우이기 때문에 unbind 해 주어야 함. --%>
					$(document).unbind("click");
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
						$("#alert").removeClass("alert alert-error").html("");
					}
					else {
						$("#alert").addClass("alert alert-error").html("<button type=\"button\" class=\"close\" data-dismiss=\"alert\">x</button>Fail to dislike.");
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
						$("#alert").removeClass("alert alert-error").html("");
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
						$("#alert").removeClass("alert alert-error").html("");
					}
					else {
						$("#alert").addClass("alert alert-error").html("<button type=\"button\" class=\"close\" data-dismiss=\"alert\">x</button>Fail to dislike.");
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
						$("#alert").removeClass("alert alert-error").html("");
					}
				}
			});
		}
		
		$("textarea").autoresize();
	</script>
</div>