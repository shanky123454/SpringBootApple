<%@ page language="java" %>
 <h1>
      <b> from second.jsp page</b></br>
      <%= new java.util.Date() %>
 </h1>
 
 <h1 style='color:red;text-align:centre;'>
 STUDENT_ID = <%= request.getParameter("student_id") %>
 </br>
 STUDENT_NAME = <%= request.getParameter("student_name") %>
 
 </h1>
