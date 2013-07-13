   <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "ie.dwd.beans.*, java.io.IOException, java.util.ArrayList, 
    javax.servlet.ServletException, javax.servlet.annotation.WebServlet, javax.servlet.http.HttpServlet, 
    javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.http.HttpSession
    "%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Displaying all users</title>
</head>

<body bgcolor="#FF0033">
	<%final ArrayList<MovieBean> movieList;%>

		
		  <head><title>RetrieveServlet</title></head>
		  
    
		    <%try{%>
		    	
				<%HttpSession mySession = request.getSession(true);//scriplets x 2%>
				<%movieList = (ArrayList<MovieBean>) mySession.getAttribute("mlist");%>

				<% if(movieList != null)%>
				<%{%>

		    <table align='center' border=2 width=77 >
		    <tr>
		    <td width=20% align=center><font color='#FFFFFF' face=Arial><b>Movie ID</b></font></td>
		    <td width=33% align=center><font color='#FFFFFF' face=Arial><b>Movie Title</b></font></td>
		    <td width=54% align=center><font color='#FFFFFF' face=Arial><b>Movie Certification</b></font></td>
		    <td width=54% align=center><font color='#FFFFFF' face=Arial><b>Movie Rating</b></font></td>
		    <td width=40% align=center><font color='#FFFFFF'face=Arial><b>Select</b></font></td>
		    <td width=40% align=center><font color='#FFFFFF' face=Arial><b>Select</b></font></td>
		    </tr>



		 <% for(MovieBean ub : movieList){ %>   
		      <tr><td width=20%>
		      <p align=center><font color='#FFFFFF' face=Arial><%=ub.getMovieid()%></font></td>
		      <td width=33%><font color='#FFFFFF' face=Arial><%=ub.getTitle()%></font></td>
		      <td width=54%><font color='#FFFFFF' face=Arial><%=ub.getCertification()%></font></td>
		       <td width=54%><font color='#FFFFFF' face=Arial><%=ub.getRating()%></font></td>
		      <td width=40%><font color='#FFFFFF' face=Arial><a href=/Project/UpdateServlet?option=<%=ub.getMovieid()%>><b>UPDATE</b></font></a></td>
		      <td width=40%><font color='#FFFFFF' face=Arial><a href=/Project/DeleteServlet?option=<%=ub.getMovieid()%>><b>DELETE</b></font></a></td>
		      </tr>
		    <%} %>   

		  
		  </table>
		 <%}  %>  
		    
		    <%} 
		    
		    catch(Exception sqle)
		    {
		    System.out.println(sqle);
		    }
		    	
		    	%>
		    
		   
			
				<form method='get' action='/Project/menu.jsp'>
				<p align='center'><input type='submit' value='Home' name='btn'></p>
				</form>
				
				</body></html>
		    
		    	
			

		
		 

