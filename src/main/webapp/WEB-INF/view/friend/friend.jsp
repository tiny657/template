<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>

<div class="container">
	<div>
		<table class="table table-striped">
			<tbody>
				<%-- friend list --%>
				<c:forEach var="friend" items="${friends}">
					<tr>
						<td>
							<img class="img-polaroid" src="http://graph.facebook.com/${friend.id}/picture" />
							${friend.name}
							<br /><br />
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>