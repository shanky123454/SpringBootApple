<%@page import="java.util.ArrayList"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Output</title>
</head>
<body>
<table border="1" >
<c:forEach var="x" begin="0" end="10" step="1">
<tr>
    <td> <c:out value="${2*x}"></c:out> </td>
</tr>
</c:forEach>
</table>
<%
ArrayList<String> al = new ArrayList<String>();
al.add(0, "shashank");
al.add(1, "shanky");
al.add(2, "ritu");
request.setAttribute("al", al);
%>
<c:forEach var="list" items="${al}">
<h1> value=${list}</h1>
</c:forEach>
</body>
</html>