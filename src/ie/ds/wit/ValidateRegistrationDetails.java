package ie.ds.wit;

import ie.dwd.beans.MovieBean;
import ie.dwd.beans.UserBean;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidateLoginDetails
 */
public class ValidateRegistrationDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
    	response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession mySession = request.getSession(true);
		ArrayList<UserBean> userList = (ArrayList<UserBean>) mySession.getAttribute("ulist");
		String[] Params = request.getParameterValues("password");
		
			
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
		
		else {				
	
			if(userList == null) 
				
				 try {
					    FileInputStream fin = new FileInputStream("data.txt");
					    ObjectInputStream ois = new ObjectInputStream(fin);
					    userList = (ArrayList<UserBean>)ois.readObject();
					    ois.close();
					   }
					   catch (Exception e) { e.printStackTrace(); }  
				
				
				int num = Integer.parseInt(request.getParameter("ID"));
				String alice = request.getParameter("username");
				long bob = Long.parseLong(request.getParameter("password"));	   
				userList.add(new UserBean(num, alice, bob));
								
				try {
				     FileOutputStream fout = new FileOutputStream("data.txt");
				      ObjectOutputStream oos = new ObjectOutputStream(fout);
				      oos.writeObject(userList);
				      oos.close();
				      }
				   catch (Exception e) { e.printStackTrace(); }
				
				mySession.setAttribute("ulist",userList);
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
	            dispatcher.forward(request,response);
	            
	       		}
				
		}
					

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
