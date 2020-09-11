import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		pw.println("<h2>"+"Welcome" + "</h2>");
		try
		{
			Thread.sleep(3000);
		}
		catch (Exception e)
		{
			pw.println(e);
			
		}
	}
}