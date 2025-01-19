<%@page import="java.util.ArrayList"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Output</title>
</head>
<body>
<c:choose>
<c:when test="${param.p >0 }">
<c:out value="${param.p} no is positive"></c:out>
</c:when>
<c:when test="${param.p <0 }">
<c:out value="${param.p} no is negative"></c:out>
</c:when>
<c:otherwise>
<c:out value="${param.p} no is zero"></c:out>
</c:otherwise>
</c:choose>
</body>
</html>