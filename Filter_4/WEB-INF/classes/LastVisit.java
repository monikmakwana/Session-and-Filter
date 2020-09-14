import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class LastVisit extends HttpServlet
{
          public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
          {
                   res.setContentType("text/html");
                   PrintWriter out = res.getWriter();
                   Date date = new Date();
                  
                   String time = String.valueOf(date.getTime());
                  
                   Cookie myCookie = new Cookie("mca214",time);
                   myCookie.setMaxAge(60*60*24*365);
                   res.addCookie(myCookie);
                  
                  
                   Cookie cookie_arr[] = req.getCookies();
             

				   out.println( 
				   "<HTML>" + 
				   "<HEAD><TITLE>Hello</TITLE></HEAD>" +
				   "<BODY>" );
				   
                   boolean found = false;
				   if(cookie_arr != null)
                   {
                             for(int i=0; i<cookie_arr.length; i++)
                             {
                                      if(cookie_arr[i].getName().equals("mca214"))
                                      {
                                                long time1 = Long.parseLong(cookie_arr[i].getValue());
                                                long time2 = date.getTime();
                                                long time_diff = time2 - time1;
												out.println("<h3><br> Welcome Again</h3>");
                                                out.println("<h4>Last time you visited page : " + new Date(time1) + "<br>Current Date is : " + new Date(time2) + " </h4> " );
                                                out.println("<h4>You have visited after " + (time_diff/1000) + " Seconds</h4>");
												found=true;
                                      }
                             }
                   }
				   if(found == false)
				   {
					   out.println("<h3><br> Welcome</h3>");
					   out.println("<h3> You visited website for the first time</h3>");
								   
				   }
					out.println("</BODY></HTML>");
          }
}