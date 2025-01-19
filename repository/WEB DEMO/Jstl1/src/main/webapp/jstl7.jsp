<%@page import="java.util.ArrayList"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Output</title>
</head>
<body>
   <%
   	int[] arr = {};
    String[] arr1= {};
    ArrayList<Integer> al =  new ArrayList<Integer>();
    ArrayList<String> al1 = new ArrayList<String>();
   %>
	${empty sachin }<br/>
	${empty 'sachin'}<br/>
	${empty null }<br/>
	${empty arr }<br/>
	${empty al }<br>
	${ empty al1 }
	<hr/>
	${10 + null }<br/>
	${empty null }<br/>
	${!null}
</body>
</html>