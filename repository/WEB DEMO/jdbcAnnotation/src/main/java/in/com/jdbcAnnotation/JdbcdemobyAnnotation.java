package in.com.jdbcAnnotation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/test" }, 
initParams = { 
		@WebInitParam(name = "url", value = "jdbc:mysql:///employee"),
		@WebInitParam(name = "user", value = "root"),
		@WebInitParam(name = "password", value = "Shanky@123") 
	}, 
loadOnStartup = 10)
public class JdbcdemobyAnnotation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded successfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void init()throws ServletException
	{
                     
		String url = getInitParameter("url");
		String user =  getInitParameter("user");
		String password = getInitParameter("password");
		
		 try {
				con =DriverManager.getConnection(url,user,password);
				if(con!=null)
				    System.out.println("connection got established");
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out =response.getWriter();
		 response.setContentType("text");
		 try {			
			if(con!=null)
			{
				String query ="select * from employees";
				pstmt=con.prepareStatement(query );
			}
			if(pstmt!=null)
			{
				res=pstmt.executeQuery();
			}
			if(res!=null)
			{
			        out.println("<html><head><title>OUTPUT</title>");
					out.println("<h1 style='color:red;text-align:centre;'> EMPLOYEE DATABASE</h1>");
					out.println("<body>");
					out.println("<centre>");
					out.println("<table border='1'>");
					out.println("<tr> <th>ID</th> <th>NAME</th> <th>AGE</th> </tr>");
					while(res.next())
					{
						out.println("<tr> <td>"+ res.getInt(1)+" <td>"+ res.getString(2)+" <td>"+ res.getInt(3)+" </tr>");
					}
					out.println("</table>");
					out.println("</centre>");
					out.println("</body>");
					out.println("</html>");
			}
			
		} catch (SQLException e) {
		e.printStackTrace();
		}
		out.close(); 
//		try {
////			res.close();
////			pstmt.close();
////			//con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
	}


}
