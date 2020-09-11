import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;

public class Welcome extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
      
		String user = (String)session.getAttribute("user1");
		String name = (String)session.getAttribute("Name");
		String add = (String)session.getAttribute("Add");
		String mob = (String)session.getAttribute("Mob");
		String email = (String)session.getAttribute("Email");
		Date date=new Date(session.getLastAccessedTime());
		//session.invalidate(); //Destroying a Session
		
		
		out.println(
		"<html>" +
		"<body>" +
		"<h3>" + "Login Successful" + "</h3>" +
		"<h3>" + "Welcome " + user + "</h3>" +
		
		"<table>" +
			"<tr>" +
				"<td>" + "Full Name : " + "</td>" +
				"<td>"+ name +"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>" + "Address : " +"</td>"+
				"<td>"+ add +"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>"+ "Mobile : "+"</td>"+
				"<td>"+ mob +"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>" + "Email : "+"</td>"+
				"<td>"+ email +"</td>"+
			"</tr>"+
		"</table>"+
		
		
		"</body>" +
		"</html>"
		);
		
		out.println("<h3>"+"Current Date: " +date.getDate()+"-"+(date.getMonth()+1)+"-"+(date.getYear()+1900)+"</h3>");
		out.println("<h3>"+"Current Time: " +date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()+"</h3>");
		
	}
}