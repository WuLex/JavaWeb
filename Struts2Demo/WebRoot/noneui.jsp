<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'noneui.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 
  </head>
  
  <body>
    <table width="100%" border="1">
    <tr>
      <td>类别编号</td>
      <td>类别名称</td>
      <td>父类编号</td>
    </tr>
    <s:iterator value="allTypes" var="type">
      <s:debug></s:debug>
      <td><s:property value="#type.typeid" /></td>
      <td><s:property value="#type.typename" /></td>
      <td><s:property value="#type.fatherid" /></td>
    </s:iterator>
    </table>
    <hr>
          集合投影
    <s:iterator value="allTypes.{typename}" var="typename">
       <s:property value="#typename"/>
    </s:iterator>
    <hr>
          集合的选择
    <s:iterator value="allTypes.{? #this.fatherid ==0}" var="big">
         <div><s:property value="#big.typename"/></div>
         <div>
             <s:iterator value="allTypes.{? #this.fatherid ==#big.typeid}" var="small">
                <s:property value="#small.typename"/>
             </s:iterator>
         </div>
    </s:iterator>  
  </body>
</html>
