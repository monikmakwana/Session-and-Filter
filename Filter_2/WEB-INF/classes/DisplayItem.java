import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class DisplayItem extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
	{
	
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		
		Product p1 = (Product)context.getAttribute("p1");
		Product p2 = (Product)context.getAttribute("p2");
		Product p3 = (Product)context.getAttribute("p3");
		Product p4 = (Product)context.getAttribute("p4");
		Product p5 = (Product)context.getAttribute("p5");
		
		response.setContentType("text/html");
		out.println("<h1><p style=\"color:red\">ShoppingCart.com</h1></p><br><br>");
		out.println("<form action='Add_Or_Remove'>");
		out.println("<table border=1 width='700'>");
		
		
		
		out.println("<tr> <th> Product </th> <th> Description </th> <th> Cost </th> <th> Add To Cart </th> <th> Remove From Cart </th> </tr>");
		
		out.println("<tr align='center'> <td>" + p1.name() + "</td> <td>" + p1.description() + "</td> <td>" + p1.cost() + "</td> <td><input type='submit' name='addP1' value='Add To Cart'></td> <td><input type='submit' name='removeP1' value='Remove From Cart'></td> </tr>");
		
		out.println("<tr align='center'> <td>" + p2.name() + "</td> <td>" + p2.description() + "</td> <td>" + p2.cost() + "</td> <td><input type='submit' name='addP2' value='Add To Cart'></td> <td><input type='submit' name='removeP2' value='Remove From Cart'></td> </tr>");
		
		out.println("<tr align='center'> <td>" + p3.name() + "</td> <td>" + p3.description() + "</td> <td>" + p3.cost() + "</td> <td><input type='submit' name='addP3' value='Add To Cart'></td> <td><input type='submit' name='removeP3' value='Remove From Cart'></td> </tr>");
		
		out.println("<tr align='center'> <td>" + p4.name() + "</td> <td>" + p4.description() + "</td> <td>" + p4.cost() + "</td> <td><input type='submit' name='addP4' value='Add To Cart'></td> <td><input type='submit' name='removeP4' value='Remove From Cart'></td> </tr>");
		
		out.println("<tr align='center'> <td>" + p5.name() + "</td> <td>" + p5.description() + "</td> <td>" + p5.cost() + "</td> <td><input type='submit' name='addP5' value='Add To Cart'></td> <td><input type='submit' name='removeP5' value='Remove From Cart'></td> </tr>");
		
		out.println("</table>");
		out.println("</form>");
		
		out.println("<br><br><br><br>");
		
		HttpSession cartSession = request.getSession();
		
		Enumeration productEnum = cartSession.getAttributeNames();
		
		if(productEnum != null)
		{
			out.println("<h1>Your Cart</h1>");
			
			out.println("<table border=1 width='300'>");
			out.println("<tr> <th> Items </th> <th> Price </th> </tr>");
		
			float sum = 0;
		
			while(productEnum.hasMoreElements())
			{
		
				String productName = (String)productEnum.nextElement();
			
				Product p = (Product)context.getAttribute(productName);
				
				out.println("<tr align='center'> <td>" + p.name() + "</td> <td>" + p.cost() + "</td> </tr>");
				
				sum = sum + p.cost();
				
			}			
			out.println("<tr> <th> Total Bill </th> <th>" + sum + "</th> </tr>");
		
		}
			
	}
}
