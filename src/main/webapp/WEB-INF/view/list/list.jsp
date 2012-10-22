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
			<textarea path="rawContent" id="newDocument" class="span12" rows="1" placeholder="contents"></textarea>
			<button type="submit" id="saveRawContent" class="btn btn-info" onclick="saveDocument()">Save</button>
			<br /><br />
		</div>
	</div>

	<div>
		<table class="table table-striped">
			<tbody>
				<%-- waiting icon --%>
				<tr id="waitingDocument" style="display: none;"><td>
					<img src="img/wait24trans.gif" />
				</td></tr>
		
				<%-- document list --%>
				<%@include file="documents.jsp" %>
			</tbody>
		</table>
	</div>
</div>