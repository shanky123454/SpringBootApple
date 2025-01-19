<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="blue">

<div id="getEmployees">
<h1>OAUTH DEMO</h1>

<form:form action="http://localhost:8084/oauth/authorize" method="post">
<table>
<tr>
	 <th>Response_Type</th>
    <td> <input type="text" name="response_type" value="code" /> </td>
 </tr>
 <tr>
 	<th>Client_Id</th>
    <td> <input type="text" name="client_id" value="redbus" /> </td>
     </tr>
     
    <tr>
     <th>Redirect_Uri</th>
    <td> <input type="text" name="redirect_uri" value="http://localhost:8090/showEmployees"/>
    </td>
    </tr>
    
    <tr>
     <th>Scope</th>
    <td> <input type="text" name="scope" value="read" /> </td>
     </tr>
     <tr>
    <td> <input type="SUBMIT" value="result" /></td>
     </tr>
  </table>
</form:form>
</div>
</body>
</html>