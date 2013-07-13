package ie.dwd.servlets;

import ie.dwd.beans.MovieBean;
import ie.dwd.beans.UserBean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateServlet
 */

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html";
	private ArrayList<MovieBean> movieList;
	MovieBean x = new MovieBean();

	/**Process the HTTP Get request*/
	  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType(CONTENT_TYPE);
	    PrintWriter out = response.getWriter();


		HttpSession mySession = request.getSession(true);
		movieList = (ArrayList<MovieBean>) mySession.getAttribute("mlist");
		String TITLE1 = null;
		
	    try
	    {
	    String option = request.getParameter("option");

	    if (option==null)
	    ;
	    else
	        if(option != null && option.equals("Cancel"))
	            {
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/RetrieveServlet.jsp");
	            dispatcher.forward(request,response);
	            }
	    else if(option != null && option.equals("Update"))
	          {
	            int ID = Integer.parseInt(request.getParameter("txtID"));
	            String TITLE = request.getParameter("txtTitle");
	            String CERT = request.getParameter("txtCertification");
	            int RATING = Integer.parseInt(request.getParameter("txtRating"));
	    
	            for(MovieBean ub : movieList){
	            	if (ub.getMovieid()==ID){
	            		ub.setTitle(TITLE);
	            		TITLE1=TITLE;
	            		ub.setCertification(CERT);
	            		ub.setRating(RATING);
	            	}
	            }
	            
	            mySession.setAttribute("mlist", movieList);
			
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/RetrievePage.jsp");
	            dispatcher.forward(request,response);
	          }
	          else
	          {
	            int ID = Integer.parseInt(request.getParameter("option"));
	           
	            int CERT1 = 0;
	            int RATING1 = 0;
	            String title = new String();
	            
	            for(MovieBean ub : movieList){
	   			 if(ub.getMovieid() == ID)
	   			 {
	   				 MovieBean x = ub;
	   				 title = (x.getTitle());
	   			 }
	   		 }

	  
	            out.println("<html>");
	            out.println("<head><title>UpdateServlet</title></head>");
	            out.println("<body bgcolor='#FF0033'>");
	            out.println("<p><font color='#FFFFFF' face='Arial' size='4'>Please Change Your Details Below for Movie(ID) : <b>" + ID + "</b>.</font></p><br>");
	            out.println("<form method=get action='/Project/UpdateServlet'>");
	            out.println("<p align=left>");

	         
	            out.println("<font color='#FFFFFF' face='Arial' size='3'>Rating: <select name=txtRating><option value=1>1</option><option value=2>2</option><option value=3>3</option><option value=4>4</option><option value=5>5</option><option value=6>6</option><option value=7>7</option><option value=8>8</option><option value=9>9</option><option value=10>10</option></select>");
	            out.println("</br>");
	            out.println("<br>");
	            out.println("<font color='#FFFFFF' face='Arial' size='3'>Title:     </font><input type=text name=txtTitle value=" + title +">");
	            out.println("</br>");
	            out.println("<br>");
	            out.println("<font color='#FFFFFF' face='Arial' size='3'>Certification: <select name=txtCertification><option value=PG>PG</option><option value=12>12</option><option value=15>15</option><option value=18>18</option>");
	    	    out.println("<br>");
	    	    out.println("</br>");
	            out.println("<input type=submit value=Update name=option>");
	            out.println("<input type=submit value=Cancel name=option>");
	            out.println("<input type=hidden value='"+ ID +"' name=txtID>");
	            out.println("</p></form>");
	   
				out.println("<form method='get' action='/Project/menu.jsp'>");
				out.println("<p align='center'><input type='submit' value='ReturnHome' name='btn'></p>");
				out.println("</form>");

	            out.println("</body></html>");
	          }

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
