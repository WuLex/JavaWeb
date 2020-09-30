<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s"  uri="/struts-tags"   %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ognl.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 
  </head>
  
  <body>
    获取作用域的属性:<br>
    request:${requestScope.str2}==<s:property value="#request.str2" />
    session:${sessionScope.str2}==<s:property value="#session.str2" />
    application:${applicationScope.str2}==<s:property value="#application.str2" />
  <hr>
  获取请求的参数:<br>
  task:${param.task}==<s:property value="#parameters.task" />
  
  </body>
</html>
