<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>
<%-- documentId를 string으로 설정함. comment에서 Map key로 integer 사용 안 됨. --%>
<c:set var="documentId">${document.documentId}</c:set>

<%-- document --%>
<tr id="document${documentId}">
	<td>
		<%-- content --%>
		<div id="content${documentId}">
			${document.content}
		</div>
		
		<br /><br />
		
		<%-- comment list --%>
		<c:forEach var="comment" items="${comments[documentId]}">
			<%@include file="comment.jsp"%>
		</c:forEach>

		<%-- new comment after sending comment --%>
		<blockquote id="lastCommentPosition${documentId}" style="display:none;"></blockquote>
		
		<%-- waiting icon --%>
		<blockquote><p><img src="/img/wait24trans.gif" id="waitingComment${documentId}" style="display:none;" /></p></blockquote>
		
		<%-- comment form --%>
		<textarea id="newComment${documentId}" class="span12" placeholder="comment"></textarea>
		<br />
		<button type="submit" class="btn btn-info" id="saveComment${documentId}" onclick="saveComment(${documentId})" style="display:none;">Save</button>
		<br /><br />
		<script>
			$("#newComment${documentId}").click(function() {
				$("#saveComment${documentId}").css('display', 'inline');
			});
		</script>
	</td>
	<td>
		<c:if test="${member.providerUserId eq document.providerUserId}">
			<a href="#deleteModal${documentId}" data-toggle="modal"><i class="icon-remove"></i></a>
			<%-- Modal (Delete) --%>
			<div id="deleteModal${documentId}" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3 id="myModalLabel">DELETE</h3>
				</div>
				<div class="modal-body">
					<p>Do you want to delete?</p>
				</div>
				<div class="modal-footer">
					<button class="btn" data-dismiss="modal" aria-hidden="true">No</button>
					<button type="submit" class="btn btn-primary" data-dismiss="modal" aria=hidden="true" onclick="deleteDocument(${documentId})">Yes</button>
				</div>
			</div>
		</c:if>
		
		<a href="#postModal${documentId}" data-toggle="modal"><i class="icon-share"></i></a>
		<%-- Modal (Post) --%>
		<div id="postModal${documentId}" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h3 id="myModalLabel">POST</h3>
			</div>
			<div class="modal-body">
				<p>Do you want to post?</p>
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">No</button>
				<button type="submit" class="btn btn-primary" data-dismiss="modal" aria=hidden="true" onclick="post(${documentId})">Yes</button>
			</div>
		</div>
	</td>
</tr>