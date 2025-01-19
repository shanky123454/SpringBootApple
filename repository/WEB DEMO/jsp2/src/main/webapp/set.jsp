<%@ page language="java" %>
<jsp:useBean id="student"  scope="session" class="in.com.jspdemo.Student"></jsp:useBean>
<%-- <jsp:setProperty property="id" name="student" value="1"/>
<jsp:setProperty property="name" name="student" value="Shashank"/>
<jsp:setProperty property="age" name="student" value="25"/>
<jsp:setProperty property="address" name="student" value="BLR"/> 

<%= student %> </br>

param is used to get input from request object when user fill during registering from first.html
<jsp:setProperty property="id" name="student" param="sid"/>
<jsp:setProperty property="name" name="student" param="sname"/>
<jsp:setProperty property="age" name="student" param="sage"/>
<jsp:setProperty property="address" name="student" param="saddress"/>

<%= student %> </br> --%>



<%-- If java bean(student) property and request object parameter names are same then --%>
 <jsp:setProperty property="*" name="student"/>

<%= student %>








