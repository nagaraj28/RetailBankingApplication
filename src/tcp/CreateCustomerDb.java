package tcp;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class CreateCustomerDb extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		System.out.println("fgv");
		int ssid=Integer.parseInt(req.getParameter("ssid"));
		int cusid=Integer.parseInt(req.getParameter("cusid"));
	String custname =req.getParameter("cn");
	String age =req.getParameter("age");
	String state=req.getParameter("state");
	String city=req.getParameter("city");
	String address=req.getParameter("add");
	String pass=req.getParameter("pass");
		try{  
			System.out.println("fgv");
		String sql ="insert into employee values('"+ssid+"','"+cusid+"','"+custname+"','"+age+"','"+address+"','"+city+"','"+state+"','"+pass+"')";
			Class.forName("com.mysql.jdbc.Driver");  
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Rbank","root","12345678");  
			//here sonoo is database name, root is username and password  
			java.sql.Statement stmt=con.createStatement();  
		stmt.executeUpdate(sql);
		System.out.println("fgv");
			PrintWriter out = res.getWriter();
			out.println("<h1>employee created Successfully</h1>");
			
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
