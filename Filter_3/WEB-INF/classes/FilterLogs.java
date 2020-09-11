import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FilterLogs implements Filter 
{
	protected FilterConfig config;
	public void init(FilterConfig config) throws ServletException 
	{
		this.config = config;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException 
	{
		long startTime = System.currentTimeMillis();
	
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		chain.doFilter(request, response);
	
		long endTime = System.currentTimeMillis();
		long diff = endTime - startTime;
		
		Date req = new Date(startTime);
		Date res = new Date(endTime);
	
		out.println("<br> Request Time : " + req.getHours() + ":" + req.getMinutes() + ":" + req.getSeconds());
		out.println("<br> Response Time : " + res.getHours() + ":" + res.getMinutes() + ":" + res.getSeconds());
		out.println("<br> Time take to process the request is : " + diff/1000.0);		
		
		out.println("<br>IP Address :" + request.getRemoteAddr());
		if (request instanceof HttpServletRequest) 
		{
			out.println("<br>URL :" + ((HttpServletRequest) request).getRequestURL());
			out.println("<br>URI :" + ((HttpServletRequest) request).getRequestURI());
		}
		
	}
	
	public void destroy() 
	{
	}

}


