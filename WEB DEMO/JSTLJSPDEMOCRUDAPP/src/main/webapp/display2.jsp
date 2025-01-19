<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="in.com.Dto.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <% Student st = (Student)request.getAttribute("student"); %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HELLO STUDENTS!</title>
</head>
<body bgcolor='yellow'>
<center>
<c:choose>
<c:when test="${str ne null || ! empty str}">
<table border='1'>
<tr>
<th>status</th>
</tr>
<tr>
<td>${str}</td>
</tr>
</table>
</c:when>
<c:otherwise>
<h1 style="color:red;text-align: center;"> STUDENT OBJECT IS NOT DELETED</h1>
</c:otherwise>
</c:choose>
</center>
</body>
</html>