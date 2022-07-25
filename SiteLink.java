/**
package DD;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

           //this is the basic Servlet that opens the website
public class SiteLink extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("index/html");
		PrintWriter out = resp.getWriter();
		
		//following will print out individual session information if needed
		
		HttpSession session = req.getSession(true);
		
		Date created = new Date(session.getCreationTime());
        Date accessed = new Date(session.getLastAccessedTime());
        out.println("ID " + session.getId());
        out.println("Created: " + created);
        out.println("Last Accessed: " + accessed);
	}

}
 */
