<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Output</title>
</head>
<body>
 
 <c:catch var="e">
 <jsp:scriptlet>
 //Integer i = Integer.parseInt("10");
 Integer i1 = Integer.parseInt("ten"); // error
 //out.println(i);
 out.println(i1);
 </jsp:scriptlet>
 </c:catch>
<c:if test="${! empty e}">
<h1><c:out value="${e}"></c:out></h1>
</c:if>
<h1>the code after the exception raised</h1>
</body>
</html>