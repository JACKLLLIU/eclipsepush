<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="assets/node_modules/jquery/jquery.min.js"></script>

</head>
<body>
	<%-- java代码注释了 --%>
	<%-- <%!public String name = "123";

	public String show() {
		return "hello";
	}%>
	<%
		out.print(name);
	%>
	<%=show()%> --%>

	<p>
		<font id="Tips" size="15px" color="red"></font>
	</p>
	用户名
	<input type="text" id="username" /> 密码
	<input type="password" id="password" />

	<button id="btn" onclick="btn()">点击</button>

	<script type="text/javascript">
		function btn() {
			var username = $("#username").val();
			var password = $("#password").val();
			var url = "Ajaxtest";
			var data = "username="+username+"&password="+password;
			var fun = function(result) {
				if (result.code == 200) {
					alert("正确");
					window.location.href = result.url;
				} else if (result.code == 999) {
					alert("失败");
					$("#Tips").html("登录失败！！请检查账号密码");
				}
			};
			$.get(url, {username:username,password:password}, fun, "json");
		}
	</script>
</body>
</html>