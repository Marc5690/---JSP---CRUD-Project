package ie.ds.wit;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ie.ds.wit.ServletUtilities;
import ie.dwd.beans.MovieBean;
import ie.dwd.beans.UserBean;

/**
 * Servlet implementation class ValidateLoginDetails
 */
public class ValidateLoginDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String[] Params = request.getParameterValues("password");
		
		Cookie c = new Cookie("name", "value");
		c.setMaxAge(999999999);
		
		HttpSession session = request.getSession(true);
		
		ArrayList<UserBean> userList = (ArrayList<UserBean>) session.getAttribute("ulist");
		ArrayList<MovieBean> movieList = (ArrayList<MovieBean>) session.getAttribute("mlist");
		 
		 
		 String redirect = "";
		 
			
			if(request.getParameter("password").equals("") && request.getParameter("username").equals("")) {
				out.println("You must input a username and password.");
			}
			
			else if(request.getParameter("username").equals(""))
			{
				out.println("You must input a username.");
			}
			
			else if(request.getParameter("password").equals(""))
			{
				out.println("You must input a password.");
			}
			
			
					
			else if(!Params[0].equals(Params[1]))
			{
				out.println("Passwords is not equal.");
			}
					
		else{	
			if(userList == null) 
			{
				
				
				
			 try {
				    FileInputStream fin = new FileInputStream("data.txt");
				    ObjectInputStream ois = new ObjectInputStream(fin); 
				    userList = (ArrayList<UserBean>)ois.readObject();
				    ois.close();
				   }
				   catch (Exception e) { e.printStackTrace(); }
			}
			
			
			{

				try {
				    FileInputStream fin = new FileInputStream("movie.txt");
				    ObjectInputStream ois = new ObjectInputStream(fin); 
				    movieList = (ArrayList<MovieBean>)ois.readObject();
				    ois.close();
				   }
				   catch (Exception e) { e.printStackTrace(); }
			}
			
		
			String alice = request.getParameter("username");
			long bob = Long.parseLong(request.getParameter("password"));
			
			try{
			Iterator<UserBean> iter = userList.iterator();
	        while (iter.hasNext()) {
	        	UserBean a = iter.next();
	           	 if ((a.getUsername()).equals(alice) && (a.getPassword())==bob){  
	        	   
	        	   session.setAttribute("Username", alice);
	        	   session.setAttribute("Password", bob);
	        	   redirect = "menu.jsp";
	        
	        	   }
	        
	         }
	       }
			 catch(Exception e)
	            {
	           session.setAttribute("error", e);  
	           redirect = "/errorpage.jsp";
	            }
	        }
			
			session.setAttribute("ulist", userList);
			session.setAttribute("mlist", movieList);
	
			if (redirect == ""){
				
				redirect = "index.html";
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(redirect);
			dispatcher.forward(request,response);  
		}	
		/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
