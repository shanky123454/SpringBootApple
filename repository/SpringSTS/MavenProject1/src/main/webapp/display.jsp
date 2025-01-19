<%@page import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@page import="org.apache.taglibs.standard.tag.common.xml.ForEachTag"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="in.com.dao.Student" 
     isELIgnored="false" import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <% Object obj = request.getAttribute("student"); %> 
 <% List<Student> std = (List<Student>)obj; %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HELLO STUDENTS!</title>
</head>
<body bgcolor='yellow'>
<center>
<h1>STUDENT RECORDS</h1>

<% if(std==null){
%>
	<h1 style='color: red; text-align: center'>NO RECORD TO DISPLAY</h1><%
}
else {
	%>
<table border="1">
	<tr>
		<th>SID</th>
		<th>SNAME</th>
		<th>SAGE</th>
	</tr>	
	
	<% for(Student stud : std)
		{%>		
		<tr>
			<td><%= stud.sid%></td>
			<td><%= stud.sname%></td>
			<td><%= stud.sage %></td>
		    </tr>
		<%} %>		
</table>
<%}
%>	
</center>
</body>
</html>


