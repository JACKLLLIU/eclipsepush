<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
	<font color="red">${message}</font>
	<form action="TestFilter" id="" method="get">
		<div>
			<p>
				用户名<input type="text" name="username" />
			</p>
			<p>
				密码&nbsp;&nbsp;<input type="password" name="password" />
			</p>
		</div>
		<div>
			<input type="submit" value="点击登录"/>
		</div>
	</form>

</body>
</html>