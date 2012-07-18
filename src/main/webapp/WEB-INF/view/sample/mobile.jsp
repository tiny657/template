<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<h3>Device Information</h3>
<p>Your mobile device is</p>
<ul>
	<li>${currentDevice.userAgent}</li>
</ul>
<p>is capable of:</p>
<ul>mobile browser : ${currentDevice.capabilities.mobile_browser}
</ul>
<ul>
	<s:eval expression="new java.util.TreeMap(currentDevice.capabilities)" var="sortedCapabilities" />
	<c:forEach var="capability" items="${sortedCapabilities}">
		<li>${capability}</li>
	</c:forEach>
</ul>