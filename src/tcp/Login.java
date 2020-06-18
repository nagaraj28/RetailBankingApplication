package tcp;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.mysql.jdbc.Statement;

public class Login extends HttpServlet{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
	int uid=Integer.parseInt(req.getParameter("uname"));
String pw =req.getParameter("psw");

	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Rbank","root","12345678");  
		//here sonoo is database name, root is username and password  
		java.sql.Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select password from employee where eid="+uid+"");  
		while(rs.next())  {
String pass=rs.getString("password");
if(pass.equals(pw)) {
	
	res.setContentType("text/html");  
	PrintWriter pw1=res.getWriter();  
	res.sendRedirect("mainhome.html");
	HttpSession session=req.getSession();  
  session.setAttribute("name",uid);
	//pw1.print("Welcome, "+uid);  
    
	//pw1.close();
	}
}
	//con.close();  
		}
	
	
	catch(Exception e){
		System.out.println(e);
	
		} 

}
}
