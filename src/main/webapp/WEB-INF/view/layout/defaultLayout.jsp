<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="Content-Script-Type" content="text/javascript">
<meta http-equiv="Content-Style-Type" content="text/css">
<title id="browserTitleArea"><tiles:insertAttribute name="title" ignore="true" defaultValue="메뉴 :: 브랜드명 서비스" /></title>

<tiles:insertAttribute name="header" />
</head>

<body>
	<tiles:insertAttribute name="top" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
	<tiles:useAttribute id="lazyloadngScripts" name="lazyloadngScripts" classname="java.util.List" />
	<c:forEach var="script" items="${lazyloadingScripts}">
		<script type="text/javascript" src="<c:url value='${script}'/>"></script>
	</c:forEach>
</body>
</html>