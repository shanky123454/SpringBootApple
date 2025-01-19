<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Output</title>
</head>
<body>
	<h1><c:out value="${param.username}"></c:out></h1><br>
	
	<c:catch var="e">
	<% 
	Integer userAge = Integer.parseInt(request.getParameter("userAge"));
	out.println(userAge);
	%>
	<c:out value="${param.userAge}"></c:out><br>
	</c:catch>
	
	<c:if test="${! empty e }">
	<c:out value="${e}"></c:out><br>
	</c:if>
	
	<c:out value="${param.userid}"></c:out>
</body>
</html>
</body>
</html>