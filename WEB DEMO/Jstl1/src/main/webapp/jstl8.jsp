<%@page import="java.util.ArrayList"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Output</title>
</head>
<body>
  <c:set var="x" value="2" scope="application" > </c:set>
  <c:if test="${x eq 2}" var="y" scope="session">
  <c:out value="${x}"></c:out>
  </c:if>
  <c:out value="${y}"></c:out>
</body>
</html>