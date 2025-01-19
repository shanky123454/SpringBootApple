<%@ page language="java" %>
<%

pageContext.setAttribute("p", "page");// using pageContext it behaves as local to page so it was not forwarded to disp.jsp page
request.setAttribute("r", "request");
session.setAttribute("s", "session");
application.setAttribute("a", "application");
request.setAttribute("f", "fuffa");
pageContext.forward("./disp.jsp");
pageContext.setAttribute("m", "mamu"); // op==> null  
session.setAttribute("m", "mamu");

%>
