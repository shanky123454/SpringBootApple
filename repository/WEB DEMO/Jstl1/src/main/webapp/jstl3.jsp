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
 <c:out value="${3+4}"></c:out><br> <%-- op==> 7 --%>
 <c:out value="${null + 4}"></c:out><br> <%-- op==> 4 --%>
  <c:out value="${shanky + 5 }"></c:out><br> <%-- op==> 5, bcz shanky is no where 
 declared so it is treated as null --%>
  <c:out value="${empty null }"></c:out><br> <%-- op==> true --%>
  <c:out value="${! null }"></c:out><br> <%-- op==> true --%>
 <c:out value="${''+6}"></c:out><br> <%-- op==> 6, '' is treated as empty string value is 0 --%>
 <c:out value="${' '+4 }"></c:out><br> <%-- op==> exception, ' ' is treated as blank string--%>
  <c:out value="${'shanky'+ 5 }"></c:out> <%-- op==> exception
  EL does not support operator overloading, so there is no String 
 concatenation operator.'+' always acts as addition operator. --%>
 </c:catch>
 <c:if test="${! empty e }">
 <c:out value="${e}"></c:out>
 </c:if>
 <h1> after the exception</h1>
</body>
</html>