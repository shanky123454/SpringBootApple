<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Output</title>
</head>
<body bgcolor="yellow">
<center>
	<table border="1" align="center">
	<tr><th>ENO</th>
	<td>${emp.eno}</td>
	</tr>
	<tr><th>ENAME</th>
	<td>${emp.ename}</td>
	</tr>
	<tr><th>EDESG</th>
	<td>${emp.desg}</td>
	</tr>
	<tr><th>ESALARY</th>
	<td>${emp.salary}</td>
	</tr>
	</table>
</center>
</body>
</html>