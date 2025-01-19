<%@page import="java.util.ArrayList"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Output</title>
</head>
<body>
<c:forTokens var="name" delims="$" items="sachin$rahul$dhoni">
<c:out value="${name}"></c:out>
<h1>${name}</h1>
</c:forTokens>
<%
ArrayList<String> al = new ArrayList<String>();
al.add(0, "shashank");
al.add(1, "shanky");
al.add(2, "ritu");
request.setAttribute("al", al);
%>
<c:forEach var="list" items="${al}">
<h1>${list}</h1>
<c:out value="${list}"></c:out>
</c:forEach>
</body>
</html>