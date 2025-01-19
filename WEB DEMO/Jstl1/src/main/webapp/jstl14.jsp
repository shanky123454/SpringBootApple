<%@page import="java.util.ArrayList"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Output</title>
</head>
<body>
<c:url value="http://www.google.com" var="googleurl" scope="session">
<h1><c:out value="${googleurl}"></c:out></h1>
</c:url>
<%-- <c:redirect url="${googleurl}"/> --%> 
 <h1> <a href="${googleurl}" >|click to go|</a></h1> 
</body>
</html>