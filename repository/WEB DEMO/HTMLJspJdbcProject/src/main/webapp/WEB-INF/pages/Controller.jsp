<%@ page language="java" import="java.util.* , java.lang.*, java.sql.*"%>
<%@ page isELIgnored='false'%>
<%!
    ServletConfig config = getServletConfig();
    String url = config.getInitParameter("url");
    String user = config.getInitParameter("user");
    String password = config.getInitParameter("password");
    Connection con = null;
    PreparedStatement pstmt1= null;
    PreparedStatement pstmt2= null;
    int res=0;
    ResultSet rest =null;
    
    public void jspInit()
    {
    	try{
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	con=DriverManager.getConnection(url, user, password);
    	
    	System.out.println("connection got established");
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
%>

<%
  String name= request.getParameter("name");
  String age= request.getParameter("age");
  String id= request.getParameter("id");
  String address= request.getParameter("address");
  String action = request.getParameter("s1");
 
   if(action.equalsIgnoreCase("reg"))
   {
   if(con!=null)
       {
	   String query = "insert into student(id,name,age,address) values(?,?,?,?)";
	   pstmt1=con.prepareStatement(query);
	   pstmt1.setInt(1, Integer.parseInt(id));
	   pstmt1.setString(2, name);
	   pstmt1.setInt(3, Integer.parseInt(age));
	   pstmt1.setString(4, address);
	   
	   res = pstmt1.executeUpdate();
	   
	   if(res==1)
	        {
		   out.println("<h2>DATA SUCCESSFULLY INSERTED");
	        }
	   else   {
		   out.println("<h2>DATA NOT SUCCESSFULLY INSERTED");
	          }  
       }
   }
%>

<%!
public void jspDestroy()
{
	System.out.println("got destroyed");
}

%>



