<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
     DMI访问方式一:<br>
     <a href="dmiadd">add</a>
     <a href="dmiupdate">update</a>
     <a href="dmidel">del</a>
     <a href="dmiquery">query</a> 
      <hr>
     DMI访问方式二:<br>
     <a href="dmitest!add">add</a>
     <a href="dmitest!update">update</a>
     <a href="dmitest!del">del</a>
     <a href="dmitest!query">query</a> 
      <hr>
      DMI访问方式三:<br>
     <a href="dmido_DMIAction_add">add</a>
     <a href="dmido_DMIAction_update">update</a>
     <a href="dmido_DMIAction_del">del</a>
     <a href="dmido_DMIAction_query">query</a> 
  </body>
</html>
