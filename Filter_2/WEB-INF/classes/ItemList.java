import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ItemList extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
	{
	
		PrintWriter out = response.getWriter();
		Product p1 = new Product("Shirt","Formal",1500);
		Product p2 = new Product("Jeans","Slim-Fit",2500);
		Product p3 = new Product("Shoes","Sport Shoes",3000);
		Product p4 = new Product("Hand-Sanitizer","Alcohol based Hand Sanitizer 500ml",250);
		Product p5 = new Product("Mask","Face-Mask Cotton Washable",100);
		
		ServletContext context = getServletContext();
		
		context.setAttribute("p1",p1);
		context.setAttribute("p2",p2);
		context.setAttribute("p3",p3);
		context.setAttribute("p4",p4);
		context.setAttribute("p5",p5);
		
		response.sendRedirect("DisplayItem");
	
	}
	
}
