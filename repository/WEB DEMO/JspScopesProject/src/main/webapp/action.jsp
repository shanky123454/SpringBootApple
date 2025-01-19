<%@ page language="java" %>
<jsp:useBean id="dto" class="in.com.dto.Employee" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>

<jsp:useBean id="service" class="in.com.service.SalarygeneratorImplclass" scope="application"></jsp:useBean>

<%
  service.salarygenerator(dto);
%>

<html>
<head>
<title>OUTPUT</title>
</head>
<body bgcolor='green'>

<h1 style='color:red;text-align:center;'>DETAILS ABOUT EMPLOYEES</h1>
<table border='1' align="center">

<tr><th>NAME</th><td><jsp:getProperty property="name" name="dto"/></td></tr>
<tr><th>ID</th><td><jsp:getProperty property="id" name="dto"/></td></tr>
<tr><th>AGE</th><td><jsp:getProperty property="age" name="dto"/></td></tr>
<tr><th>ADDRESS</th><td><jsp:getProperty property="address" name="dto"/></td></tr>
<tr><th>BSALARY</th><td><jsp:getProperty property="bsalary" name="dto"/></td></tr>
<tr><th>GSALARY</th><td><jsp:getProperty property="gsalary" name="dto"/></td></tr>
<tr><th>NSALARY</th><td><jsp:getProperty property="nsalary" name="dto"/></td></tr>

</table>
</body>
</html>