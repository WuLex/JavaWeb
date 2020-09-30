<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="wu.domain.Person"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>使用Jstl+el完成集合迭代</title>

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
	<%
		List list = new ArrayList();
		list.add(new Person("wu"));
		list.add(new Person("li"));
		list.add(new Person("wang"));
		request.setAttribute("list", list);
	%>

    <c:forEach var="person" items="${list}">
        ${person.name}</br>
    </c:forEach>
    
    <c:if test="${user!=null}">
            欢迎你:${user.username}
    </c:if>
     <c:if test="${user==null}">
     
     
     
     </c:if>
</body>
</html>
