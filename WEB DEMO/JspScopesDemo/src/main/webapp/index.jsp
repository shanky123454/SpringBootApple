<%@ page language="java" %>
<%

pageContext.setAttribute("p","page");// it behaves as local to page so it was not forwarded to disp.jsp page
request.setAttribute("r","request");
session.setAttribute("s","session");
application.setAttribute("a","application");

pageContext.forward("./disp.jsp");
%>
