<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>

<div class="container">
	<div>
		<table class="table table-striped">
			<tbody>
				<c:choose>
					<c:when test="${empty items}">
						<tr>
							<td>
								<spring:message code="market.noItem" />
							</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="item" items="${items}">
							<tr>
								<td>
									${item.name}
								</td>
								<td>
									${item.price}
								</td>
								<td>
									${item.desc}
								</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</div>