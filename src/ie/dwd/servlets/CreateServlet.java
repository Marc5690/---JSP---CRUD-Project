package ie.dwd.servlets;

import ie.dwd.beans.MovieBean;
import ie.dwd.beans.UserBean;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class CreateServlet
 */
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html";
	private ArrayList<MovieBean> movieList;


	/**Process the HTTP Get request*/
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType(CONTENT_TYPE);
	    PrintWriter out = response.getWriter();

		HttpSession mySession = request.getSession(true);
		movieList = (ArrayList<MovieBean>)mySession.getAttribute("mlist");
		
		  
	    String option = request.getParameter("btn1");
	    if (option==null);
	    
	    else if(option.equals("Create") && (option != null))
	        {
	    	   try
	            {
	            int MOVIEID = Integer.parseInt(request.getParameter("txtID"));
	            String TITLE = request.getParameter("txtTitle");
	            int RATING = Integer.parseInt(request.getParameter("txtRating"));
	            String CERTIFICATION = request.getParameter("txtCertification");
	           
	            MovieBean b = new MovieBean(MOVIEID, TITLE,CERTIFICATION,RATING);
	
	            movieList.add(b); 
	           
	            

				try {
				     FileOutputStream fout = new FileOutputStream("movie.txt");
				      ObjectOutputStream oos = new ObjectOutputStream(fout);
				      oos.writeObject(movieList);
				      oos.close();
				      }
				   catch (Exception e) { e.printStackTrace(); }
				
				 mySession.setAttribute("mlist",movieList);// userList);
	            
	          RequestDispatcher dispatcher = request.getRequestDispatcher("/RetrievePage.jsp");
	          dispatcher.forward(request,response);
	          }

	          catch(Exception e)
	            {
	            mySession.setAttribute("error", e);  
	            response.sendRedirect("errorpage.jsp");
	        	  
	            }
	        }

	    out.println("<html>");
	    out.println("<head><title>CreateServlet</title></head>");
	    out.println("<body bgcolor='#FF0033' color='#FFFFFF'>");
	    out.println("<p><font color='#FFFFFF' face='Arial' size='4'>Please the DVD Details Below.</font></p><br>");
	    out.println("<form method=get action='/Project/CreateServlet'>");
	    out.println("<p align=left>");
	    out.println("<font color='#FFFFFF' face='Arial' size='3'>ID:      </font><input type=text name=txtID><br>");
	    out.println("<br>");
	    out.println("<font color='#FFFFFF' face=Arial> Rating: <select name=txtRating><option value=1>1</option><option value=2>2</option><option value=3>3</option><option value=4>4</option><option value=5>5</option><option value=6>6</option><option value=7>7</option><option value=8>8</option><option value=9>9</option><option value=10>10</option></select>");
	    out.println("<br>");
	    out.println("</br>");
	    out.println("<font color='#FFFFFF' face='Arial' size='3'>Title:     </font><input type=text name=txtTitle><br>");
	    out.println("<br>");
	    out.println("<font color='#FFFFFF' face=Arial> Certification: <select name=txtCertification><option value=PG>PG</option><option value=12>12</option><option value=15>15</option><option value=18>18</option>");
	    out.println("</br>");
	    out.println("<br>");
	    out.println("<input type=submit value=Create name=btn1>");
	    out.println("<input type=reset value=Clear name=btn1>");
	    out.println("</p></form>");
		out.println("<form method='get' action='/Project/menu.jsp'>");
		out.println("<p align='center'><input type='submit' value='Home' name='btn'></p>");
		out.println("</form>");
	    out.println("</body></html>");
	  }
	 // }
	  /**Process the HTTP Post request*/
	  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      doGet(request,response);
	  }
	  /**Clean up resources*/
	  public void destroy() {
	  }
	  
	}