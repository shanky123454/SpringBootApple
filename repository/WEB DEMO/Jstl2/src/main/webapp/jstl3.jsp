<%@page import="java.util.ArrayList"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Output</title>
</head>
<body>
<c:url value="jstl4.jsp" var="url" scope="session">
<c:param name="corejava" value="hyder"></c:param>
<c:param name="jee" value="nitin"></c:param>
</c:url>
<h1>the modified url is :: ${url}</h1>
<a href="${url}">|click to go to new page|</a>
${url}
</body>
</html>