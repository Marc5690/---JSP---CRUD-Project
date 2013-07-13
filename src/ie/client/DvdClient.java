package ie.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import ie.dwd.beans.MovieBean;
import ie.dwd.beans.UserBean;

import java.awt.List;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.annotate.JsonView;
import org.codehaus.jettison.json.JSONString;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DvdClient {
	//http://localhost:8080/Project/rest/WebResource/comment
	   public static void main(String[] args) throws ParseException {
			ClientConfig config = new DefaultClientConfig();
			Client client = Client.create(config);
			WebResource service = client.resource("http://localhost:8080/Project");
     		String s = service.path("rest").path("WebResource").path("comment").accept(MediaType.APPLICATION_JSON).get(String.class);
			
			JSONParser parser=new JSONParser();
			Object obj=parser.parse(s);
			JSONArray array=(JSONArray)obj;
		    ArrayList<MovieBean> x = (ArrayList<MovieBean>) JSONValue.parse(s);
	
			JSONObject obj2=(JSONObject)array.get(1);
			ArrayList<MovieBean> movieList = new ArrayList<MovieBean>();
			
			System.out.println(array);
			System.out.println("------------------------------------"); 
			System.out.println(obj2.get("title"));
			System.out.println("------------------------------------");
			System.out.println(x);
			System.out.println("------------------------------------");
			System.out.println((x.get(0)));
			
			
	   }
	   
}
		