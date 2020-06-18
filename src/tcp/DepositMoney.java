package tcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.time.YearMonth;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DepositMoney extends HttpServlet{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {

int accid = Integer.parseInt(req.getParameter("cusid"));
int depamt = Integer.parseInt(req.getParameter("depo"));

try{  
	Class.forName("com.mysql.jdbc.Driver");  
	java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Rbank","root","12345678");  
	//here sonoo is database name, root is username and password  
	java.sql.Statement stmt=con.createStatement();  
	ResultSet rs1 = stmt.executeQuery("select amount from accountdetails where accid="+accid);
int bal=0;
	while(rs1.next())
 bal=rs1.getInt("amount");
bal=bal + depamt;
int year = YearMonth.now().getYear();
int month = YearMonth.now().getMonthValue();
String date1 = " "+year+" "+month+"01";
int date=Integer.parseInt(date1); 
String op="credited";
String sql="update accountdetails set amount='"+bal+"' where accid='"+accid+"'";
String sql1="insert into Transaction values('"+accid+"','"+bal+"','"+date+"','"+op+"')";
stmt.executeUpdate(sql1);
stmt.executeUpdate(sql);
PrintWriter out = res.getWriter();
out.println("success");
}
catch(Exception e){ System.out.println(e);}  
}

}
