<%@ page language="java" %>
<%
out.println("<h2> Page scope  object is "+ pageContext.getAttribute("p")+" </h2>");
out.println("<h2>request scope object is "+ request.getAttribute("r")+" </h2>");
out.println("<h2> session scope object is "+ session.getAttribute("s")+" </h2>");
out.println("<h2> application scope object is "+ application.getAttribute("a")+" </h2>");
out.println("</br>");
out.println("<h2> request scope object is "+ pageContext.findAttribute("r")+" </h2>");
out.println("<h2> session scope  object is "+ pageContext.getAttribute("s",3)+" </h2>");

//  pageContext.getAttribute(k)==> It will search only in page scope,
//  if found returns value otherwise returns null.

// pageContext.getAttribute(k,scope) => It will search in the specified scope
// if found return value otherwise it returns null.
		
//  pageContext.findAttribute(k) => It will search in 
//  pagescope,requestscope,sessionscope,applicationscope if found in any scope 
// particular value will be returned othewise it would return null value.


%>
