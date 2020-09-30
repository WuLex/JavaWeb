<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'list.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	<a href="${pageContext.request.contextPath}/student/preSave.do">添加学生</a>
	<table>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>操作</th>
		</tr>
		<c:forEach var="student" items="${studentList }">
			<tr>
				<td>${student.id }</td>
				<td>${student.name }</td>
				<td>${student.age }</td>
				<td><a
					href="${pageContext.request.contextPath}/student/preSave.do?id=${student.id}">修改</a>
					&nbsp;&nbsp; 
					<a
					href="${pageContext.request.contextPath}/student/delete.do?id=${student.id}">删除</a>

				</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>
