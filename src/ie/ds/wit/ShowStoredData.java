package ie.ds.wit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;


		

public class ShowStoredData extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
for(int i=0; i<3; i++) {
Cookie cookie = new Cookie("Session-Cookie-" + i, "Cookie-Value-S" + i);
response.addCookie(cookie);
cookie = new Cookie("Persistent-Cookie-" + i, "Cookie-Value-P" + i);
cookie.setMaxAge(3600);
response.addCookie(cookie);
}
response.setContentType("text/html");
PrintWriter out = response.getWriter();

String title = "Active Cookies";
out.println( ServletUtilities.headWithTitle(title) +
		"<BODY BGCOLOR=\"#FDF5E6\">\n" +
		"<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
		"<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
		"<TR BGCOLOR=\"#FFAD00\">\n" +
		" <TH>Cookie Name\n" + " <TH>Cookie Value");

Cookie[] cookies = request.getCookies();
if (cookies != null) {
Cookie cookie;
for(int i=0; i<cookies.length; i++) {
cookie = cookies[i];
out.println("<TR>\n" +
"<TD>" + cookie.getName() + "\n" +"<TD>" + cookie.getValue());
}
}
out.println("</TABLE></BODY></HTML>");


HttpSession session = request.getSession(true);
out.println("<TR>\n" +
"<TD>" + session.getAttribute("Username") + "\n" +"<TD>" + session.getAttribute("Password"));
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}


