package ie.ds.wit;

import javax.servlet.http.Cookie;

public class ServletUtilities 
{
 public static final String DOCTYPE =
	    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
	    "Transitional//EN\">";

 public static String headWithTitle(String title) {
	    return(DOCTYPE + "\n" +
	           "<HTML>\n" +
	           "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n");
	  }
	  
 public static String getCookieValue(Cookie[] cookies, String cookieName, String defaultVal) 
	{
	if (cookies != null) 
	{
			for(int i=0; i<cookies.length; i++) 
			{
					Cookie cookie = cookies[i];
					if (cookieName.equals(cookie.getName()))
						return(cookie.getValue());
			}
	}
	return(defaultVal);
	}

 public static Cookie getCookie(Cookie[] cookies, String cookieName) 
	{
		if (cookies != null) 
			{
			for(int i=0; i<cookies.length; i++) 
				{
				Cookie cookie = cookies[i];
				  if (cookieName.equals(cookie.getName()))
					  return(cookie);
				}
			}
		return(null);
	}

}
