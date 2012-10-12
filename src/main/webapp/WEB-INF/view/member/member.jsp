<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>

<div class="container">
	<div class="row-fluid">
		<div class="thumbnail span5">
			<form:form method="post" action="/memberUpdate" modelAttribute="member">
				<div style="text-align: center;">
					<img src="http://graph.facebook.com/${member.providerUserId}/picture?type=large" />
				</div>
				
				<br />
				
				<table class="table table-bordered table-striped">
					<thead>
						<tr><th colspan=2 style="text-align: center; "><spring:message code="member.information" /></th></tr>
					</thead>
					<tbody>
						<tr>
							<td><spring:message code="member.name" /></td>
							<td><form:input type="text" path="name" value="${member.name}" /></td>
						<tr>
							<td><spring:message code="member.email" /></td>
							<td>${member.email}</td>
						<tr>
							<td><spring:message code="member.gender" /></td>
							<td>
								<c:choose>
									<c:when test="${member.gender}">
										<spring:message code="member.male" />
									</c:when>
									<c:otherwise>
										<spring:message code="member.female" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td><spring:message code="member.locale" /></td>
							<td>${member.locale}</td>
						</tr>
					</tbody>
				</table>
				
				<table class="table table-bordered table-striped">
					<thead>
						<tr><th colspan=2" style="text-align: center; "><spring:message code="member.titlePoint" /></th></tr>
					</thead>
					<tbody>
						<tr>
							<td><spring:message code="member.point" /></td>
							<td>${member.point}</td>
						</tr>
						<tr>
							<td><spring:message code="member.doc" /></td>
							<td>${member.doc}</td>
						</tr>
						<tr>
							<td><spring:message code="member.comment" /></td>
							<td>${member.comment}</td>
						</tr>
						<tr>
							<td><spring:message code="member.commentOnMyDoc" /></td>
							<td>${member.commentOnMyDoc}</td>
						</tr>
						<tr>
							<td><spring:message code="member.like" /></td>
							<td>${member.like}</td>
						</tr>
						<tr>
							<td><spring:message code="member.likeOnMyDoc" /></td>
							<td>${member.likeOnMyDoc}</td>
						</tr>
						<tr>
							<td><spring:message code="member.dislike" /></td>
							<td>${member.dislike}</td>
						</tr>
						<tr>
							<td><spring:message code="member.dislikeOnMyDoc" /></td>
							<td>${member.dislikeOnMyDoc}</td>
						</tr>
						<tr>
							<td><spring:message code="member.sharing" /></td>
							<td>${member.sharing}</td>
						</tr>
						<tr>
							<td><spring:message code="member.sharingOfMyDoc" /></td>
							<td>${member.sharingOfMyDoc}</td>
						</tr>
					</tbody>
				</table>
				<p style="text-align: center; ">
					<button type="submit" class="btn btn-info" style="text-align: center;">Save</button>
				</p>
			</form:form>
		</div>
	</div>
</div>