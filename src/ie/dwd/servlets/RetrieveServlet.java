package ie.dwd.servlets;

import ie.dwd.beans.MovieBean;
import ie.dwd.beans.UserBean;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RetrieveServlet
 */

public class RetrieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String CONTENT_TYPE = "text/html";
	private ArrayList<MovieBean> movieList;


		  /**Initialize global variables*/
		  public void init() throws ServletException {
		  }
		  /**Process the HTTP Get request*/
		  @SuppressWarnings("unchecked")
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType(CONTENT_TYPE);
		    PrintWriter out = response.getWriter();
			out.println("<html>");
		    out.println("<head><title>RetrieveServlet</title></head>");
		    out.println("<body bgcolor='#225588'>");
		    
		    try {
			    FileInputStream fin = new FileInputStream("movie.txt");
			    ObjectInputStream ois = new ObjectInputStream(fin); 
			    movieList = (ArrayList<MovieBean>)ois.readObject();
			    ois.close();
			   }
			   catch (Exception e) { e.printStackTrace(); }
		    
		   
		    try{
		    	
				HttpSession mySession = request.getSession(true);
				movieList = (ArrayList<MovieBean>) mySession.getAttribute("mlist");
if (movieList != null){
	


		    out.println("<table align='center' border=2 width=77%>");
		    out.println("<tr>");
		    out.println("<td width=20% align=center><font color='#FFFFFF' face=Arial><b>Movie ID</b></font></td>");
		    out.println("<td width=33% align=center><font color='#FFFFFF' face=Arial><b>Movie Title</b></font></td>");
		    out.println("<td width=54% align=center><font color='#FFFFFF' face=Arial><b>Movie Certification</b></font></td>");
		    out.println("<td width=54% align=center><font color='#FFFFFF' face=Arial><b>Movie Rating</b></font></td>");
		    out.println("<td width=40% align=center><font color='#FFFFFF'face=Arial><b>Select</b></font></td>");
		    out.println("<td width=40% align=center><font color='#FFFFFF' face=Arial><b>Select</b></font></td>");
		    out.println("</tr>");

		    

		  for(MovieBean ub : movieList)
		      {
		      out.println("<tr><td width=20%>");
		      out.println("<p align=center><font color='#FFFFFF' face=Arial> " + ub.getMovieid() + "</font></td>");
		      out.println("<td width=33%><font color='#FFFFFF' face=Arial>" + ub.getTitle() + "</font></td>");
		      out.println("<td width=54%><font color='#FFFFFF' face=Arial>" + ub.getCertification() + "</font></td>");
		      out.println("<td width=54%><font color='#FFFFFF' face=Arial>" + ub.getRating() + "</font></td>");
		      out.println("<td width=40%><font color='#FFFFFF' face=Arial><a href=/Project/UpdateServlet?option=" + ub.getMovieid() + "><b>UPDATE</b></font></a></td>");
		      out.println("<td width=40%><font color='#FFFFFF' face=Arial><a href=/Project/DeleteServlet?option=" + ub.getMovieid() + "><b>DELETE</b></font></a></td>");
		      out.println("</tr>");
		      }

		    out.println("</table>");
		    }
		    
		    else
		    {
		    	 out.println("NO MOVIES HAVE BEEN ADDED TO THE LIST YET.....");
		    }
			   
				out.println("<form method='get' action='/Project/index.html'>");
				out.println("<p align='center'><input type='submit' value='Return Home' name='btn'></p>");
				out.println("</form>");
				
				
				out.println("</body></html>");
		    }
		    	
			

		    catch(Exception sqle)
		    {
		    System.out.println(sqle);
		    }
		  }
		  /**Process the HTTP Post request*/
		  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      doGet(request,response);
		  }
		
}
