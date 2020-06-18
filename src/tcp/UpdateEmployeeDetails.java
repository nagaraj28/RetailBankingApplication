package tcp;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class UpdateEmployeeDetails extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		int ssid=Integer.parseInt(req.getParameter("ssid"));
		
		int eid=Integer.parseInt(req.getParameter("eid"));
		
	String empname =req.getParameter("cn");
	
	String age =req.getParameter("age");
	
	String address=req.getParameter("add");
			try{  
		String sql ="update employee set name='"+empname+"',age='"+age+"',address='"+address+"' where ssid='"+ssid+"'";
			Class.forName("com.mysql.jdbc.Driver");  
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Rbank","root","12345678");  
			//here sonoo is database name, root is username and password  
			java.sql.Statement stmt=con.createStatement();  
		stmt.executeUpdate(sql);
			PrintWriter out = res.getWriter();
			out.println("<h1>Employee Update Success</h1>");
			
		/*	while(rs.next())  {
	String pass=rs.getString("password");
	System.out.println("hello"+pass);
	if(pass.equals(pw)) {
		HttpSession session=req.getSession();  
	    session.setAttribute("name",uid);
		res.setContentType("text/html");  
		PrintWriter pw1=res.getWriter();  
		res.sendRedirect("homepage.html");  
		pw1.print("Welcome, "+uid);  
	    
		  
		//pw1.close();
		}
	}*/
		//con.close();  
			
			}
		
		
		catch(Exception e){
			PrintWriter out = res.getWriter();
			out.println("<h1>employee not created</h1>");
			System.out.println(e);
		
			} 

	}

}

