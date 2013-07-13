<%@ page errorPage="errorpage.jsp" language="java" import="java.util.*,ie.dwd.beans.*" pageEncoding="UTF-8"%>

<html>

<head>
<meta http-equiv="Content-Language" content="en-ie">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta name="GENERATOR" content="Microsoft FrontPage 4.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<title>CRUD JSP/Servlet Example</title>
</head>

<%
	HttpSession mySession = request.getSession(true);
	ArrayList<MovieBean> movieList = (ArrayList<MovieBean>) mySession.getAttribute("mlist");
 %>
 

<body bgcolor="#FF0033">

<p align="center"><font color="#FFFFFF" face="Arial" size="4">Welcome to the DVD library!</font></p>
<p align="center"><font color="#FFFFFF" face="Arial" size="4">What would you like
to do?</font></p>
<form method="get" action="/Project/ControllerServlet">
  <p align="center">
  <input type="submit" value="Add a DVD" name="btn">
  <input type="submit" value="View all DVD's" name="btn">
  <input type="submit" value="Top Ten" name="btn">
  <input type="submit" value="Logout" name="btn"> 
    </p>
</form>

<font color='#FFFFFF' face=Arial>Welcome 
<b><%=session.getAttribute("Username")%></b>!
		 
			<%
			ArrayList<UserBean> userList = (ArrayList<UserBean>) mySession.getAttribute("ulist");
			session.setAttribute("ulist",userList);
     		 %>
	    
</body>

</html>
