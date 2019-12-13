<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String name = request.getParameter("username");
session.setAttribute("name", "张三");
application.setAttribute("age", "18");
response.sendRedirect("inner.jsp");

%>
<%=name%>
<form action="TestServlet">
	用户名<input type="text" name="username" value="123">
	密码<input type="password" name="password">
</form>
</body>
</html>