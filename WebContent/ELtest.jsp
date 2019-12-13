<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.*"%>
<%@ page import="bean.Users"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List list = new ArrayList();
		list.add(new Users("张三", "123213"));
		list.add(new Users("李四", "123213"));
		list.add(new Users("王五", "123213"));
		pageContext.setAttribute("name", "iron man");
		request.setAttribute("users", list);
		request.setAttribute("request", "2");
		session.setAttribute("session", "3");
		application.setAttribute("application", "4");
	%>
	
	<h1>${name }</h1>
	<h1>${pageContext.request.contextPath }</h1>
	<h1>${request}</h1>
	<h1>${session}</h1>
	<h1>${application}</h1>
	<hr/>
	<h2>${fn:length(name) }</h2>
	<h2>${fn:contains(name, man) }</h2>
	<h2>${fn:indexOf(name,m) }</h2>
	<hr/>
	<h2>${users[0].username }</h2>
	<h2>${users[1].username }</h2>


</body>
</html>