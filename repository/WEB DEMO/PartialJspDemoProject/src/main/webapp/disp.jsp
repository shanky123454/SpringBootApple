<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="in.com.Dto.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% Student st = (Student)request.getAttribute("hoola"); %>
<%= st.getSage() %>
<%= st.getSid() %>
<%= st.getSname() %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HELLO STUDENTS!</title>
</head>
<body>
<table border='1'>
<tr><th>SID</th><td><%= st.getSid() %></td>
<tr><th>SNAME</th><td><%= st.getSname() %></td>
<tr><th>SAGE</th><td><%= st.getSage() %></td>
</table>
</body>
</html>