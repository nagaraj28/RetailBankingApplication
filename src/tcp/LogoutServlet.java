package tcp;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
public class LogoutServlet extends HttpServlet {  
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                                throws ServletException, IOException {  
			try {
			response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  
            HttpSession session=request.getSession();  
            request.getRequestDispatcher("index.html").include(request, response);  
            session.invalidate();  
            out.println("<h2>You are successfully logged out!</h2>");
            out.close();  

			}
			catch(Exception e){ 
				System.out.println(e);
				}                
    }  
}  