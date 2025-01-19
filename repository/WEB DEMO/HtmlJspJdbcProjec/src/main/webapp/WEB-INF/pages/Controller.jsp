<%@ page language="java" import="java.sql.*"%>
<%!
    Connection con = null;
    PreparedStatement pstmt1= null;
    PreparedStatement pstmt2= null;
    ResultSet res= null;
   
    
    public void jspInit()
    {
    	//ToDo
        ServletConfig config = getServletConfig();
        String url = config.getInitParameter("url");
        String user = config.getInitParameter("user");
        String password = config.getInitParameter("password");
      //
    	try{
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	con=DriverManager.getConnection(url,user,password);
    	
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    
    %>
<%
 
  String action = request.getParameter("s1");
 
   if(action.equalsIgnoreCase("reg"))
   {
	   String name= request.getParameter("name");
	   String age= request.getParameter("age");
	   String id= request.getParameter("id");
	   String address= request.getParameter("address");
   if(con!=null)
       {
	   String query = "insert into student(id,name,age,address) values(?,?,?,?)";
 	   pstmt1=con.prepareStatement(query);
	   pstmt1.setInt(1, Integer.parseInt(id));
	   pstmt1.setString(2, name);
	   pstmt1.setInt(3, Integer.parseInt(age));
	   pstmt1.setString(4, address);
	   
	    int res = pstmt1.executeUpdate();
	   
	   if(res==1)
	        {
		   out.println("<h2>DATA SUCCESSFULLY INSERTED");
	        }
	   else   {
		   out.println("<h2>DATA NOT SUCCESSFULLY INSERTED");
	          }  
       }
   }
   else if(action.equalsIgnoreCase("link")){ %>
   
       <table bgcolor='pink' align='center' border='1'>
	<tr>
		<th>SID</th>
		<th>SNAME</th>
		<th>SADDR</th>
		<th>SAGE</th>
	</tr>
	<% 
		String sql= "select * from student";
	    pstmt2= con.prepareStatement(sql);
	     res=pstmt2.executeQuery();
	    if(res!=null)
	    {
	    	while(res.next())
	    	{ %>
	    	
	    	<tr>
	    		<td><%=res.getInt(1)%></td>
	    		<td><%=res.getString(2)%></td>
	    		<td><%=res.getString(4)%></td>
	    		<td><%=res.getInt(3)%></td>
	    	</tr>
	    	
	    <%	} %>
	    </table>
	  <%  }
   }
   %>
   
   <h1 style='text-align:center;'><a href='./index.html'>|HOMEPAGE|</a></h1>

<%!
public void jspDestroy()
{
	System.out.println("got destroyed");
}

%>



