import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Add_Or_Remove extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
	{
	
		ServletContext context = getServletContext();
		HttpSession cartSession = request.getSession();
		Product p;
		
		if(request.getParameter("addP1") != null)
		{
		
			p = (Product)context.getAttribute("p1");
			cartSession.setAttribute("p1",p);
		}
		
		else if(request.getParameter("addP2") != null)
		{
		
			p = (Product)context.getAttribute("p2");
			
			cartSession.setAttribute("p2",p);
		
		}
		
		else if(request.getParameter("addP3") != null){
		
			p = (Product)context.getAttribute("p3");
			
			cartSession.setAttribute("p3",p);
		
		}
		
		else if(request.getParameter("addP4") != null){
		
			p = (Product)context.getAttribute("p4");
			
			cartSession.setAttribute("p4",p);
		
		}
		
		else if(request.getParameter("addP5") != null){
		
			p = (Product)context.getAttribute("p5");
			
			cartSession.setAttribute("p5",p);
		
		}
		
		else if(request.getParameter("removeP1") != null){
		
			context.removeAttribute("p1");
			
			cartSession.removeAttribute("p1");
			
		}
		
		else if(request.getParameter("removeP2") != null){
		
			context.removeAttribute("p2");
			
			cartSession.removeAttribute("p2");
			
		}
		
		else if(request.getParameter("removeP3") != null){
		
			context.removeAttribute("p3");
			
			cartSession.removeAttribute("p3");
			
		}
		
		else if(request.getParameter("removeP4") != null){
		
			context.removeAttribute("p4");
			
			cartSession.removeAttribute("p4");
			
		}
		
		else if(request.getParameter("removeP5") != null){
		
			context.removeAttribute("p5");
			
			cartSession.removeAttribute("p5");
			
		}
		
		response.sendRedirect("ItemList");
	
	}

}
