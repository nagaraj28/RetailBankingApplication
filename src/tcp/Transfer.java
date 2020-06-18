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
public class Transfer extends HttpServlet{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {

int sendid = Integer.parseInt(req.getParameter("sendid"));
int receiveid = Integer.parseInt(req.getParameter("receiveid"));

int tamount = Integer.parseInt(req.getParameter("tamount"));

try{  
	Class.forName("com.mysql.jdbc.Driver");  
	java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Rbank","root","12345678");  
	//here sonoo is database name, root is username and password  
	java.sql.Statement stmt=con.createStatement();  
	ResultSet rs1 = stmt.executeQuery("select amount from accountdetails where accid="+sendid);
	
	int year = YearMonth.now().getYear();
	int month = YearMonth.now().getMonthValue();
	String date1 = " "+year+" "+month+"01";
	int date=Integer.parseInt(date1); 
	String op1="debited";
	String op2="credited";

	int bal1=0,bal2=0;
PrintWriter out = res.getWriter();
	while(rs1.next()) {
		 bal1=rs1.getInt("amount");
	}
	 rs1 = stmt.executeQuery("select amount from accountdetails where accid="+receiveid);
	 while(rs1.next()) {
		 bal2=rs1.getInt("amount");
	}
	if(bal1<tamount) {
		out.println("<h1>Insufficient funds</h1>");
	}
	else {
		int updatebal1=bal1-tamount;
		int updatebal2=bal2+tamount;

String sql1="update accountdetails set amount='"+updatebal1+"' where accid='"+sendid+"'";
String sql3="insert into Transaction values('"+sendid+"','"+updatebal1+"','"+date+"','"+op1+"')";
String sql2="update accountdetails set amount='"+updatebal2+"' where accid='"+receiveid+"'";
String sql4="insert into Transaction values('"+receiveid+"','"+updatebal2+"','"+date+"','"+op2+"')";
stmt.executeUpdate(sql1);
stmt.executeUpdate(sql2);
stmt.executeUpdate(sql3);
stmt.executeUpdate(sql4);
out.println("amount updated");
	}
}
catch(Exception e){ 
	System.out.println(e);
	}  
}

}

