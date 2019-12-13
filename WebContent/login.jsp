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
	<form action="" id="" method="get">
		<div>
			<p>
				用户名<input id="username" type="text" name="username" />
			</p>
			<p>
				密码&nbsp;&nbsp;<input id="password" type="password" name="password" />
			</p>
		</div>
		<div>
			<button id="btn" onclick="btn()">点击登录</button>
		</div>
	</form>

</body>
</html>