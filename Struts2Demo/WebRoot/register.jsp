<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 
  </head>
  
  <body>
    <s:form name"form1" id="form1" action="register!register" >
     username:<s:textfield name="username" maxlength="16" cssStyle="" cssClass=""></s:textfield> <br>
     password:<s:password name="password"></s:password><br>
     usersex:<s:radio list="#{0:'女',1:'男'}" value="1"></s:radio><br>
     married:<s:checkbox name="married"></s:checkbox><br>
     likes:<s:checkboxlist name="likes" list="{'game','READ','movies'}"></s:checkboxlist><br>
     city:<s:select list="#{'fz':'福州','xm':'厦门','qz':'泉州'}"></s:select>
     info:<s:textarea name="info" rows="5"  cols="40"></s:textarea>
     <s:submit value="注册"></s:submit>
     <s:reset value="重置"></s:reset>
    </s:form>
  </body>
</html>
