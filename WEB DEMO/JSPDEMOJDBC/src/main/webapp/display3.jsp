<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String string = (String)request.getAttribute("update");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HELLO STUDENTS!</title>
</head>
<body bgcolor='yellow'>
<center>
<table border='1'>
<tr><th>STATUS</th><td><%= string %></td></tr>
</table>
</center>
</body>
</html>