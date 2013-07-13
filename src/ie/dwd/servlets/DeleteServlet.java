package ie.dwd.servlets;

import ie.dwd.beans.MovieBean;
import ie.dwd.beans.UserBean;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html";
	private ArrayList<MovieBean> movieList;
	
	
	  /**Process the HTTP Get request*/
	  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType(CONTENT_TYPE);

		HttpSession mySession = request.getSession(true);
		movieList = (ArrayList<MovieBean>) mySession.getAttribute("mlist");
		
	    try
	    {
	    String option = request.getParameter("option");

	    if (option==null)
	    ;
	     else
	          {
	            int ID = Integer.parseInt(request.getParameter("option"));
	      
	            
	            Iterator<MovieBean> iter = movieList.iterator();
	            while (iter.hasNext()) {
	                if (iter.next().getMovieid() == ID) iter.remove();
	            }	
	            	}
	    
	    try {
		     FileOutputStream fout = new FileOutputStream("movie.txt");
		      ObjectOutputStream oos = new ObjectOutputStream(fout);
		      oos.writeObject(movieList);
		      oos.close();
		      }
		   catch (Exception e) { e.printStackTrace(); }

	            mySession.setAttribute("mlist", movieList);

	          RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");//("/RetrievePage.jsp");
	            dispatcher.forward(request,response);
	           }
	          catch(Exception e)
	            {
	        	  	mySession.setAttribute("error", e);  
		            response.sendRedirect("/Project/errorpage.jsp");
	            }

	  }
	  /**Process the HTTP Post request*/
	  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      doGet(request,response);
	  }
	}