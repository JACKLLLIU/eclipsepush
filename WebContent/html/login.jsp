<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>登录注册</title>
<link href="../assets/node_modules/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<script src="../assets/node_modules/jquery/jquery.min.js"></script>
<script src="../assets/node_modules/bootstrap/js/popper.min.js"></script>
<script src="../assets/node_modules/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<center>
					<h2>
						<font style="color: #03A9F4;">欢迎来到本系统，请选择登录or注册</font>
					</h2>
				</center>
			</div>
		</div>
		<div class="row justify-content-center">
			<center>
				<a data-toggle="modal" data-target="#login" href="">
					<button type="button" class="btn btn-primary btn-lg">登录</button>
				</a> <a data-toggle="modal" data-target="#register" href="">
					<button type="button" class="btn btn-warning btn-lg">注册</button>
				</a>
			</center>

		</div>

		<div id="login" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body">
						<button class="close" data-dismiss="modal">
							<span>&times;</span>
						</button>
					</div>
					<div class="modal-title">
						<h1 class="text-center">登录</h1>
					</div>
					<div class="modal-body">
						<form class="form-group" action="">
							<div class="form-group">
								<label for="">用户名</label> <input id="username"
									class="form-control" type="text" placeholder="">
							</div>
							<div class="form-group">
								<label for="">密码</label> <input id="password"
									class="form-control" type="password" placeholder="">
							</div>
							<div class="form-group" style="width: 200px">
								<!-- 样式1 -->
								<label for="">选择登录类型</label>
								<select id="selector" class="form-control input-sm">
									<option value="0">管理员</option>
									<option value="1">用户</option>
								</select>
							</div>
							<div class="text-right">
								<button class="btn btn-primary" type="button" onclick="login()">登录</button>
								<button class="btn btn-danger" data-dismiss="modal">取消</button>
							</div>
							<a href="" data-toggle="modal" data-dismiss="modal"
								data-target="#register">还没有账号？点我注册</a>
						</form>
					</div>
				</div>
			</div>
		</div>

		<!-- 注册窗口 -->
		<div id="register" class="modal fade" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body">
						<button class="close" data-dismiss="modal">
							<span>&times;</span>
						</button>
					</div>
					<div class="modal-title">
						<h1 class="text-center">注册</h1>
					</div>
					<div class="modal-body">
						<form class="form-group" action="">
							<div class="form-group">
								<label for="">用户名</label> <input id="newusername"
									class="form-control" type="text" placeholder="6-15位字母或数字">
							</div>
							<div class="form-group">
								<label for="">密码</label> <input id="newpassword1"
									class="form-control" type="password" placeholder="至少6位字母或数字">
							</div>
							<div class="form-group">
								<label for="">再次输入密码</label> <input id="newpassword2"
									class="form-control" type="password" placeholder="至少6位字母或数字">
							</div>
							<div class="text-right">
								<button class="btn btn-primary" type="button"
									onclick="register()">提交</button>
								<button class="btn btn-danger" data-dismiss="modal">取消</button>
							</div>
							<a href="" data-toggle="modal" data-dismiss="modal"
								data-target="#login">已有账号？点我登录</a>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	<script type="text/javascript">
			/*登录功能  */
			function login(){
				var username = $("#username").val();
				var password = $("#password").val();
				var selector = $("#selector").val();
				if(username==""||password==""){
					alert("你有输入没有正确输入！！请重新进行登录！！");
					return
				}
				$.ajax({
					type:"get",
					url:"../LoginServlet",
					async:false,
					dataType: "json",
					data:{
						username:username,
						password:password,
						selector:selector
					},
					success:function(result){
						alert(result.extend.url);
						window.location.href = result.extend.url;
						return;
					},
					error:function(result){
						alert("登录失败");
					}
					
				});
			}
			/*注册功能  */
			function register(){
				var username = $("#newusername").val();
				var password = $("#newpassword1").val();
				var repassword = $("#newpassword2").val();
				if(username==""||password==""||repassword==""){
					alert("你有输入没有正确输入！！请重新进行登录！！");
					return;
				}
				if(password!=repassword){
					$("#newpassword2").val("");
					$("#newpassword1").val("");
					alert("密码两次输入不一致！！请重新输入！！");
					
					return;
				}
				$.ajax({
					type:"get",
					url:"../registerServlet",
					async:false,
					dataType: "json",
					data:{
						username:username,
						password:password,
						repassword:repassword
					},
					success:function(result){
						if(result.code==100){
							alert("注册成功请登录！！");
						}
						if(result.code==200){
							alert("注册失败，请联系管理员！！");
						}
						$("#newusername").val("");
						$("#newpassword1").val("");
						$("#newpassword2").val("");
						return;
					},
					error:function(result){
						alert("登录失败");
					}
					
				});
			}
		</script>

</body>

</html>