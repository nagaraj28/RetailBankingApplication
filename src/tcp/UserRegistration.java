package tcp;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class UserRegistration extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		System.out.println("fgv");
		int accid=Integer.parseInt(req.getParameter("accid"));
		int cusid=Integer.parseInt(req.getParameter("cusid"));
	String uname =req.getParameter("uname");
	String age =req.getParameter("age");
	String mobile =req.getParameter("mobile");
	String state=req.getParameter("state");
	String city=req.getParameter("city");
	String address=req.getParameter("address");
		try{  
			int bal=0;
		String sql ="insert into user values('"+cusid+"','"+accid+"','"+uname+"','"+age+"','"+mobile+"','"+state+"','"+city+"','"+address+"')";
		String sql1 ="insert  into Transaction values('"+accid+"','"+bal+"')";
			Class.forName("com.mysql.jdbc.Driver");  
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Rbank","root","12345678");  
			//here sonoo is database name, root is username and password  
			java.sql.Statement stmt=con.createStatement();  
		stmt.executeUpdate(sql);
		stmt.executeUpdate(sql1);

			PrintWriter out = res.getWriter();
			out.println("<h1>User created Successfully</h1>");
		}
		
		catch(Exception e){
			PrintWriter out = res.getWriter();
			out.println("<h1>employee not created</h1>");
			System.out.println(e);
		
			} 

	}

}
