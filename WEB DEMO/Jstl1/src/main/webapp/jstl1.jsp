<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Output</title>
</head>
<body>
<c:set var="name" value="sachin" scope="request" ></c:set>
<c:set var="age" value="45" scope="session"></c:set>
<c:set var="id" value="17" scope="application"> </c:set>

<c:set var="x" value="1" scope="application"> </c:set>
<c:set var="y" value="2" scope="application"> </c:set>
<c:set var="z" value="${x+y}" scope="application"> </c:set>


<c:remove var="name" scope="request"/>
<c:remove var="z" scope="application"/>

<h1><c:out value="${name}"></c:out></h1>
<h1><c:out value="${age}"></c:out></h1>
<h1><c:out value="${id}"></c:out></h1>
<h1><c:out value="${z}"></c:out></h1>
<h1><c:out value="${param.username}" default="paddu"></c:out></h1>
<h1><c:out value="${param.age}" default="24"></c:out></h1>
<h1><c:out value="${param.id}" default="095"></c:out></h1>


<h1 style='color:red; text-align: center;'>
		The sum is :: <c:out value="${z}" default="1000"/>
	</h1>
	
</body>
</html>