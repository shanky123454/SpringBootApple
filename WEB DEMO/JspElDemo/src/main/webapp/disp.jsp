<%@ page language="java" %>

<h1>Page Scope object is :: ${p} </h1> <%-- o/p==>null --%>
<h1>request Scope object is :: ${r} </h1>
<h1>session Scope object is :: ${s} </h1>
<h1>application Scope object is :: ${a} </h1>


<h1>request Scope object is :: ${requestScope.r} </h1>
<h1>page Scope object is :: ${pageScope.p} </h1>
<h1>session Scope object is :: ${sessionScope.s} </h1>
<h1>application Scope object is :: ${applicationScope.a} </h1>


<h1><%= pageContext.getAttribute("p",1)%></h1>
<h1><%= pageContext.getAttribute("s",3)%></h1>
<h1><%= pageContext.getAttribute("a",4)%></h1>
<h1><%= pageContext.getAttribute("r",2) %></h1>
<h1><%= pageContext.findAttribute("f")%></h1>
<h1><%= pageContext.findAttribute("m")%></h1>


<h1><%= application.getAttribute("a")%></h1>
<h1><%= request.getAttribute("r")%></h1>
<h1><%= session.getAttribute("s")%></h1>
<h1><%= request.getAttribute("f")%></h1>
<h1><%= session.getAttribute("m")%></h1> 


<h1><%= this.getServletName()%></h1>
<h1><%= this.getServletInfo()%></h1>
<h1><%= this.getServletConfig()%></h1>
<h1><%= this.getServletContext()%></h1>
<h1><%= this.getInitParameterNames()%></h1>
<h1><%= ((HttpServlet)page).getServletContext()%></h1>
<h1><%= ((HttpServlet)page).getServletConfig()%></h1>





<%-- reading from xml file through EL  syntax --%>
<h1>username is :: ${initParam.user} </h1>
<h1>password is :: ${initParam.pwd} </h1>
<h1>url is :: ${initParam.url} </h1>


<h1> the request object is :: ${request}</h1> <%-- o/p==>null --%>
<h1> the session object is :: ${session}</h1> <%-- o/p==>null --%>


<%--  Between JSP and EL the only common implicit object available is 
"pageContext" In EL session,request implicit objects are not directly available. --%>
 
<h1> the request object is :: ${pageContext.request.method}</h1> 
<h1> the session object is :: ${pageContext.session.id}</h1>