<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="bean.Users" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	pageContext.setAttribute("web_path", request.getContextPath());//当前项目路径
	Users u1 = new Users("张三","123213");
	Users u2 = new Users("李四","123213");
	Users u3 = new Users("王五","123213");
	List list = new ArrayList();
	list.add(u1);
	list.add(u2);
	list.add(u3);
	request.setAttribute("info", list);
	
%>
</head>
<body>
	<h1 style="color="green">hello${name }</h1>
	<table border="1">
	<c:forEach items="${info}" var="var" varStatus="status">
		<tr>
			<td>${var.username }</td>
			<td>${var.password }</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>