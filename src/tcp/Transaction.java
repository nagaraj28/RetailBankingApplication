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

import com.mysql.cj.jdbc.result.ResultSetMetaData;
public class Transaction extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {

int accid = Integer.parseInt(req.getParameter("accid"));

try{  
	Class.forName("com.mysql.jdbc.Driver");  
	java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Rbank","root","12345678");  
	//here sonoo is database name, root is username and password  
	java.sql.Statement stmt=con.createStatement();  
	ResultSet rs = stmt.executeQuery("select * from Transaction where accid="+accid);
	
PrintWriter out = res.getWriter();
/*ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
int columnsNumber = rsmd.getColumnCount();*/
out.println("<html>");
out.println("<head><title>TransactionDetails</title></head>");
out.println("<body>");
out.println("<h1>TransactionDetails</h1>");
out.println("<table><tr><th>Firstname</th><th>Lastname</th><th>Age</th</tr>");
while (rs.next()) {
/*	for(int i = 1 ; i <= columnsNumber; i++){

	      out.println(<tr>rs.getString(i) + " "); //Print one element of a row

	}*/
	out.println("<tr><td>"+rs.getInt(1)+"</td>"+"<td>"+rs.getInt(2)+"</td>"+"<td>"+rs.getInt(3)+"</td>"+"<td>"+rs.getInt(4)+"</td></tr>");
	    }
out.println("</table>\r\n" + 
		"</body></html>");
}
catch(Exception e){ 
	System.out.println(e);
	}  
}

}

