<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- java代码注释了 --%>
	<%!public String name = "123";

	public String show() {
		return "hello";
	}%>
	<%
		out.print(name);
	%>
	<%=show()%>
</body>
</html>