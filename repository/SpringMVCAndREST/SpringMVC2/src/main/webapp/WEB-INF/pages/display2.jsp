<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Output</title>
</head>
<body>
<center>
<h1 style="color: red; text-align: center;">INFO ABOUT SIMPLE OBJECTS</h1>
<h1> name are :<c:forEach var="names" items="${names}" >
<c:out value="${names}"></c:out>
</c:forEach></h1>

<h1 style="color:blue;text-align: center;">
<h1> courses offered are: <c:forEach var="courses" items="${courselist}">
<c:out value="${courses}"></c:out>
</c:forEach></h1>

<h1 style="color: blue;text-align: center;">
<h1> mobiles no are : <c:forEach var="mob" items="${mobileNo}">
<c:out value="${mob}"></c:out>
</c:forEach></h1>

<h1 style="color: blue;text-align: center;">
<h1> ID'S no are : <c:forEach var="items" items="${ids}">
<c:out value="${items}"></c:out>
</c:forEach></h1>
</center>
</body>
</html>