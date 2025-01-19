<%@ page language="java" %>
<jsp:useBean id="student"  scope="session" class="in.com.jspdemo.Student"></jsp:useBean>

<h2>ID::<jsp:getProperty property="id" name="student"/></h2>
<h2> NAME ::<jsp:getProperty property="name" name="student"/></h2>
<h2>AGE ::<jsp:getProperty property="age" name="student"/></h2>
<h2> ADDRESS::<jsp:getProperty property="address" name="student"/></h2>



