package in.com.jdbcAnnotation;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( urlPatterns={"/JdbcInsert"},
                   initParams= { 
                			@WebInitParam(name = "url", value = "jdbc:mysql:///employee"),
                			@WebInitParam(name = "user", value = "root"),
                			@WebInitParam(name = "password", value = "Shanky@123") 
                		}, 
                	loadOnStartup = 10)
		
public class JdbcInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con =null;
	PreparedStatement pstmt = null;
	int res=0;
	boolean flag=false;

	
	static{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("driver class successfully loaded");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}			
	}
	
	public void init() throws ServletException
	{
		String url = getInitParameter("url");
		String user = getInitParameter("user");
		String password = getInitParameter("password");
		
		try {
			con=DriverManager.getConnection(url,user,password);
			if(con!=null)
			{
				System.out.println("connection got established");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//doPost(request, response);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
//		out.println("<h2>before request in main servlet</h2>");
		String id= request.getParameter("userid");
		String name= request.getParameter("username");
		String age= request.getParameter("userage");
	
		request.setAttribute("userid", id);
		request.setAttribute("username", name);
		request.setAttribute("userage", age);
		
//		ServletContext context  = getServletContext();
//		RequestDispatcher req =context.getRequestDispatcher("/Demo");
//		req.include(request, response);
//		req.forward(request, response);
		RequestDispatcher req = request.getRequestDispatcher("/Demo");
////		//req.include(request, response);
		req.forward(request, response);
//		out.println("<h2>After request in main servlet</h2>");
//		
		
		if(con!=null)
		{
			
			String query ="insert into employees(id,name,age) values (?,?,?)";
			try {
				pstmt=con.prepareStatement(query );
				pstmt.setInt(1, Integer.parseInt(id));
				pstmt.setString(2, name);
				pstmt.setInt(3, Integer.parseInt(age));
			
				
				if(pstmt!=null)
				{
					res=pstmt.executeUpdate();
				}
				
				if(res==1)
				{
					out.println("<h1> record successfully inserted</h1></br>");
				}
				else {
					out.println("<h1>record not inserted</h1></br>");
					out.println("< a href='./Reg.html'/>|REG|</a>");
				     }
				
				out.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
