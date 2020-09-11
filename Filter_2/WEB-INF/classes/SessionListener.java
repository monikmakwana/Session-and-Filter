import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SessionListener implements HttpSessionAttributeListener
{

	public void attributeAdded(HttpSessionBindingEvent event) 
	{
		HttpSession cartSession = event.getSession();
		String  attributename=event.getName();
		Object  attributevalue=event.getValue();
		System.out.println("\n Product added to Cart: " + attributename + "\n Cost : " + attributevalue);
		
		
	}
	
	public void attributeRemoved(HttpSessionBindingEvent event)
	{
		HttpSession cartSession = event.getSession();
		String  attributename=event.getName();
		Object  attributevalue=event.getValue();
		System.out.println("\n Product removed from Cart: " + attributename + "\n Cost : " + attributevalue );
		
	}
 

	public void attributeReplaced(HttpSessionBindingEvent event) {}
}