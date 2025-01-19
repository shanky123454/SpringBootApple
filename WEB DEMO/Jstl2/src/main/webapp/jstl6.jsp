<%@ page isELIgnored="false"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSTL FORMAT LIBRARY</title>
</head>
<body>

	<fmt:setLocale value="fr_FR"/>
	
	
	
	<fmt:formatNumber var="fnumber" value="234567" type="currency"/>
	<h1>${fnumber}</h1>
	    
	
	
	 <jsp:useBean id="date" class="java.util.Date"></jsp:useBean>
	 <fmt:formatDate value="${date}" var="fdate"/>
	 <c:out value="${fdate}"></c:out>
	 
	 
	<fmt:setBundle basename="in.main.commons.App"/>
	<fmt:message key="welcome.msg" var="msg1"/>
	<fmt:message key="goodbye.msg" var="msg2"/>
    <h1 style='color:red; text-align: center;'>Message is :: ${msg1 },${msg2 }</h1>

    
</body>
</html>