<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HURRAY!!!</title>
</head>
<body bgcolor="yellow">
<center>
<form:form  method="post" modelAttribute="emp" action="result">
<table border="1">
<tr>
<th>ENO</th>
<td>

<form:input path="eno" type="text"/>
</td>
</tr>
<tr>
<th>ENAME</th>
<td>
<form:input path="ename" type="text"/>
</td>
</tr>
<tr>
<th>EDESG</th>
<td>
<form:input path="desg" type="text"/>
</td>
</tr>
<tr>
<th>ESALARY</th>
<td>
<form:input path="salary" type="text"/>
</td>
</tr>
<tr><td colspan="2">
<form:input type="submit" value="reg" path=""/>
</td></tr>
</table>
</form:form>
</center>
</body>
</html>