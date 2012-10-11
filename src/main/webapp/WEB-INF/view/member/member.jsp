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
							<td><spring:message code="member.pointDocument" /></td>
							<td>${member.pointDocument}</td>
						</tr>
						<tr>
							<td><spring:message code="member.pointComment" /></td>
							<td>${member.pointComment}</td>
						</tr>
						<tr>
							<td><spring:message code="member.pointBeCommented" /></td>
							<td>${member.pointBeCommented}</td>
						</tr>
						<tr>
							<td><spring:message code="member.pointLike" /></td>
							<td>${member.pointLike}</td>
						</tr>
						<tr>
							<td><spring:message code="member.pointBeLiked" /></td>
							<td>${member.pointBeLiked}</td>
						</tr>
						<tr>
							<td><spring:message code="member.pointDislike" /></td>
							<td>${member.pointDislike}</td>
						</tr>
						<tr>
							<td><spring:message code="member.pointBeDisliked" /></td>
							<td>${member.pointBeDisliked}</td>
						</tr>
						<tr>
							<td><spring:message code="member.pointShare" /></td>
							<td>${member.pointShare}</td>
						</tr>
						<tr>
							<td><spring:message code="member.pointBeShared" /></td>
							<td>${member.pointBeShared}</td>
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