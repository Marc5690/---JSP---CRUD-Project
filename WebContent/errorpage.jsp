
<%@ page isErrorPage="true" language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'errorpage.jsp' starting page</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  </head>
  
  <body style="color: #FFFFFF; background-color: #3366BB">
<h1 align="center">CUSTOMISED ERROR PAGE</h1>
<br>

<%
	HttpSession mySession = request.getSession(true);
		Exception e = (Exception) mySession.getAttribute("error");

 %>
 <B>convert.jsp</B> reported the following error:
<I><%= e %></I>. 
This problem occurred in the following place:
<PRE>
<% e.printStackTrace(new java.io.PrintWriter(out)); %>
</PRE>
  </body>
</html>
