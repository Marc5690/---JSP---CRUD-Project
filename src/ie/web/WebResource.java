package ie.web;

import ie.dwd.beans.MovieBean;
import ie.dwd.beans.UserBean;


//import java.awt.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONString;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * Servlet implementation class Web
 */

//http://localhost:8080/Project/rest/WebResource/comment

@Path("/WebResource")
public class WebResource {
	ArrayList<MovieBean> movieList;
	@GET
	@Produces("application/json")
	@Path("/comment")
    public String hello(){ 
		try{
		FileInputStream fin = new FileInputStream("movie.txt");
	    ObjectInputStream ois = new ObjectInputStream(fin); 
	    movieList = (ArrayList<MovieBean>)ois.readObject();
	    ois.close();
		}
		catch (Exception e) { e.printStackTrace(); }
		
		 JSONObject responseDetailsJson = new JSONObject();
		    JSONArray jsonArray = new JSONArray();

		    for (int i = 0; i < movieList.size(); i++)
		    {
		      JSONObject formDetailsJson = new JSONObject();
		      formDetailsJson.put("movieid", movieList.get(i).getMovieid());
		      formDetailsJson.put("title", movieList.get(i).getTitle());
		      formDetailsJson.put("certification", movieList.get(i).getCertification());
		      formDetailsJson.put("rating", movieList.get(i).getRating());
		      jsonArray.add(formDetailsJson);
		    }
		    
		   		    
		    String x = JSONValue.toJSONString(jsonArray);
		    System.out.println(x);
		    return x;
		  } 
		
		  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		doGet(request,response);
        }
	}
