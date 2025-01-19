<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="in.com.Dto.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% Student student = (Student)request.getAttribute("foola"); %>
<% if(student!=null)
{
%>
<html>
<head>
<title>Insert title here</title>
</head>
<body bgcolor='yellow'>
<center>
<form method='post' action='./controller/updateRecord'>
<input type='hidden' name='sid' value=<%=student.getSid()%> />
<table>
<tr><th>ID</th><td><%= student.getSid()%></td></tr>
<tr><th>NAME</th><td><input type='text' name='sname' value=<%= student.getSname()%> /></td></tr>
<tr><th>AGE</th><td><input type='text' name='sage'  value=<%= student.getSage()%> /></td></tr>
<tr><td></td><td><input type='submit'  value='update'/></td></tr>
</table>
</form>
</center>
</body>
</html>

<% 
}
%>