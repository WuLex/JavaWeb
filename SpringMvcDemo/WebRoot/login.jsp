<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<a href="user/ajax.do">测试ajax</a>
<form action="user/login.do" method="post">
	<table>
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="userName"/></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="登录"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>