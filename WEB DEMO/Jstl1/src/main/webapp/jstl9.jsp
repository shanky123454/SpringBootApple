<%@page import="java.util.ArrayList"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Output</title>
</head>
<body>
<c:set var="msg" value="good morning" scope="request" ></c:set>
<c:if test="${! empty param.username}">
<c:out value="${msg}"></c:out><br>
<c:out  value="${param.username}"></c:out>
</c:if>
</body>
</html>