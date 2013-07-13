package ie.dwd.servlets;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ControllerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	String redirect = "";
    	
       	if(request.getParameter("btn").equals("Add a DVD" ))
            {
       		redirect = "/CreateServlet";
            }
            else
            	
              if(request.getParameter("btn").equals("View all DVD's" ))
              {
            	 redirect = ("/RetrievePage.jsp");
                 }
              else
            	  if(request.getParameter("btn").equals("Top Ten" ))
            	  {
            		  redirect = "/ten";
            	  }
            	  else
            		  if(request.getParameter("btn").equals("Logout" ))
            		  {
            			  redirect = "/logout";
            		  }
       	
    	      RequestDispatcher dispatcher = request.getRequestDispatcher(redirect);
              dispatcher.forward(request,response);
         }
    
      private void gotoPage(String string, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**Process the HTTP Post request*/
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
      {
      doGet(request,response);
      }


}
