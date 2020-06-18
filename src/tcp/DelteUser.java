package tcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DelteUser extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		int accid=Integer.parseInt(req.getParameter("accid"));
		try{  
		String sql1 ="delete from user where accid="+accid;
		String sql2="delete from accountdetails where accid="+accid;
			Class.forName("com.mysql.jdbc.Driver");  
			
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Rbank","root","12345678");  
			
			java.sql.Statement stmt=con.createStatement();  
		
			stmt.executeUpdate(sql1);
		
			stmt.executeUpdate(sql2);
			
			PrintWriter out = res.getWriter();
			
			out.println("<h1>Deletion Successful</h1>");
		}
		
		catch(Exception e){
			PrintWriter out = res.getWriter();
			out.println("<h1>employee not created</h1>");
			System.out.println(e);
		
			} 

	}

}
