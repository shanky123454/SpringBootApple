<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="in.com.Dto.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <% Student student = (Student)request.getAttribute("foola"); %>
<% if(student!=null)
{
%> --%>
<html>
<head>
<title>Insert title here</title>
</head>
<body bgcolor='yellow'>
<center>
<form method='post' action='./controller/updateRecord'>
<input type='hidden' name='sid' value="${student.sid}" />
<c:choose>
<c:when test="${student ne null  || ! empty student}">
<table>
<tr><th>ID</th><td>${student.sid}</td></tr>
<tr><th>NAME</th><td><input type='text' name='sname' value="${student.sname}"/></td></tr>
<tr><th>AGE</th><td><input type='text' name='sage'  value="${student.sage}"/></td></tr>
<tr><td></td><td><input type='submit'  value='update'/></td></tr>
</table>
</c:when>
<c:otherwise>
<h1 style="color: red; text-align: center;">Student object is null</h1>
</c:otherwise>
</c:choose>
</form>
</center>
</body>
</html>
