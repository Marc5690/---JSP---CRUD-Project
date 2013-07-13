package ie.dwd.servlets;

import ie.dwd.beans.MovieBean;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * Servlet implementation class TopTen
 */
public class TopTen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html";
	public ArrayList<MovieBean> movieList = new ArrayList<MovieBean>();
    
	
	
    public TopTen() { 
    super(); 
    ClientConfig config = new DefaultClientConfig();
	Client client = Client.create(config);
	WebResource service = client.resource("http://localhost:8080/Project");
	String s = service.path("rest").path("WebResource").path("comment").accept(MediaType.APPLICATION_JSON).get(String.class);
	JSONParser parser=new JSONParser();
	
	
	
	try{
			Object obj=parser.parse(s);
			JSONArray array=(JSONArray)obj;
		
			 for(Object ub : array)
		      { JSONObject obj2=(JSONObject)ub;
				
		         int id = ((Long) obj2.get("movieid")).intValue();
				 int rating = ((Long) obj2.get("rating")).intValue();
				 String certification = (obj2.get("certification")).toString();
				 String title = (obj2.get("title")).toString();
				 				
				 MovieBean tg = new MovieBean(id, title,certification,rating);
				 movieList.add(tg);
				 
			   }
			
		}
		catch(Exception e) { e.printStackTrace(); }
   
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
		    out.println("<body bgcolor='#FF0033'>");
		 
	//	    HttpSession mySession = request.getSession(true);
				
			if(movieList != null)
				{

					
		    out.println("<table align='center' border=2 width=77%>");
		    out.println("<tr>");
		    out.println("<td width=20% align=center><font color='#FFFFFF' face=Arial><b>Movie ID</b></font></td>");
		    out.println("<td width=33% align=center><font color='#FFFFFF' face=Arial><b>Movie Title</b></font></td>");
		    out.println("<td width=54% align=center><font color='#FFFFFF' face=Arial><b>Movie Certification</b></font></td>");
		    out.println("<td width=54% align=center><font color='#FFFFFF' face=Arial><b>Movie Rating</b></font></td>");
		    out.println("</tr>");


		    Collections.sort(movieList);
		    Collections.reverse(movieList);
			    
		    for(MovieBean ub : movieList)
		      {
			  
		      out.println("<tr><td width=20%>"); 
		      out.println("<p align=center><font color='#FFFFFF' face=Arial> " + ub.getMovieid() + "</font></td>");//ub.getUserid() + "</font></td>");
		      out.println("<td width=33%><font color='#FFFFFF' face=Arial>" + ub.getTitle() + "</font></td>");//ub.getUsername() + "</font></td>");
		      out.println("<td width=54%><font color='#FFFFFF' face=Arial>" + ub.getCertification() + "</font></td>");//getPassword() + "</font></td>");
		      out.println("<td width=54%><font color='#FFFFFF' face=Arial>" + ub.getRating() + "</font></td>");//getPassword() + "</font></td>");
		      out.println("</tr>");
		      }

		    out.println("</table>");
		    }
		    
		    else
		    {
		    	 out.println("There are no movies.....");
		    }
			   
				out.println("<form method='get' action='/Project/menu.jsp'>");
				out.println("<p align='center'><input type='submit' value='Return Home' name='btn'></p>");
				out.println("</form>");
				
				
				out.println("</body></html>");
		    }
		    	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
