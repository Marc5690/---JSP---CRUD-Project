package ie.dwd.servlets;

import ie.dwd.beans.MovieBean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TopTen
 */
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }
   
    
              
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 response.setContentType(CONTENT_TYPE);
		    PrintWriter out = response.getWriter();
			out.println("<html>");
		    out.println("<head><title>RetrieveServlet</title></head>");
		    out.println("<body bgcolor='#225588'>");
		 		    	
				HttpSession mySession = request.getSession(true);
				
				 mySession.setAttribute("Username", null);
	        	   mySession.setAttribute("Password", null);
	        	   RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
	   			dispatcher.forward(request,response); 
   
		  
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
