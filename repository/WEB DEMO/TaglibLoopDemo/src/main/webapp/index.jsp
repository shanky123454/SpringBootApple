<%@ page language="java" %>
<%@ taglib prefix="myTags" uri="/WEB-INF/loop.tld" %>
<h1>Hello this is index.jsp page</h1>
<myTags:Hello count='5'>
 <h1>This is the body of custom Tag</h1>
</myTags:Hello>

<%-- <myTags:Hello> error bcz attribute is missing if we make true in hello.tld in attribute 
 <h1>This is the body of custom body</h1>
</myTags:Hello>--%>

<h1>This is after the custom tags</h1>