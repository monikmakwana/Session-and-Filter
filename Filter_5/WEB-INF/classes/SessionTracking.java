import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SessionTracking extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		int count=1;
		
		String userID = session.getId();
		
		out.println("<html>");
		
		if(session.isNew())
		{
		
			out.println("<br><h1> Welcome To My Website </h1>"); 
			count = 1;
			session.setAttribute("userCount", count);
		
		}
		else
		{
		
			count = (Integer)session.getAttribute("userCount");
			count = count + 1;
			session.setAttribute("userCount", count);
			out.println("<br><h1> Welcome Back To My Website </h1>"); 
			
		}
		
		out.println("<body>");
		out.println("<br><br> Session ID : " + userID);
		out.println("<br><br> Your Visit Count : " + count);
		out.println("</body>");
		out.println("</html>");
		
	}
	
}
