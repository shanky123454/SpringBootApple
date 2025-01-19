<%@page import="java.util.ArrayList"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Output</title>
</head>
<body>
<table border="1" bgcolor="red" >
<tr>
  <th>KEY</th>
  <th>VALUE</th>
</tr>
<c:forEach var="p" items="${param}">
<tr>
<td> <c:out value="${p.key}"></c:out></td>
<td> <c:out value="${p.value}"></c:out></td>
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