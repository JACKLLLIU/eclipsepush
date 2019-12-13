<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="utf-8">
<title>AdminWrap - Easy to Customize Bootstrap 4 Admin Template</title>
<link rel="icon" type="image/png" sizes="16x16"
	href="../assets/images/favicon.png">
<link href="../assets/node_modules/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/colors/default.css" id="theme" rel="stylesheet">
<link
	href="../assets/node_modules/bootstrap/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<script src="../assets/node_modules/jquery/jquery.min.js"></script>
<script src="../assets/node_modules/bootstrap/js/popper.min.js"></script>
<script src="../assets/node_modules/bootstrap/js/bootstrap.min.js"></script>
<script src="../assets/node_modules/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
<script src="../assets/node_modules/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="js/perfect-scrollbar.jquery.min.js"></script>
<script src="js/waves.js"></script>
<script src="js/sidebarmenu.js"></script>
<script src="js/custom.min.js"></script>
<style type="text/css">
.page-titles {
	background: #f6f9fa;
	margin-bottom: 10px;
	padding: 0px;
}
</style>
</head>

<body class="fix-header card-no-border fix-sidebar">

	<!-- 遮罩层 -->
	<div class="preloader">
		<div class="loader">
			<div class="loader__figure"></div>
			<p class="loader__label">请稍等。。。</p>
		</div>
	</div>

	<div id="main-wrapper">
		<!-- 头 -->
		<header class="topbar">
			<nav class="navbar top-navbar navbar-expand-md navbar-light">
				<!-- 图标 -->
				<div style="border-bottom: 1px solid rgba(120, 130, 140, 0.13);"
					class="navbar-header">
					<a class="navbar-brand" href="fristshow.html"> <b> <img
							style="height: 40px; width: 45px;" src="../assets/images/car.jpg"
							alt="homepage" class="dark-logo" /> <img
							style="height: 20px; width: 100px;"
							src="../assets/images/logo-light-icon.png" alt="homepage"
							class="light-logo" />
					</b> <span> <img style="height: 50px; width: 180px;"
							src="../assets/images/partcar.png" alt="homepage"
							class="dark-logo" /> <img
							src="../assets/images/logo-light-text.png" class="light-logo"
							alt="homepage" />
					</span>
					</a>
				</div>
				<!--  -->
				<div style="height: 74px;" class="navbar-collapse">
					<ul class="navbar-nav mr-auto">

					</ul>
					<ul class="navbar-nav" style="float: right;">
						<li class="nav-item dropdown" style=""><a
							class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">更多设置<i
								class="fa fa-cog" aria-hidden="true"></i></a>
							<div class="dropdown-menu " style="min-width: 125px;">
								<a class="dropdown-item" href="#">退出登录</a> <a
									class="dropdown-item" href="#">修改密码</a> <a
									class="dropdown-item" href="modperson.html">个人信息</a>
							</div></li>
					</ul>

				</div>
			</nav>
		</header>
		<aside class="left-sidebar">
			<div class="scroll-sidebar">
				<nav class="sidebar-nav">
					<ul id="sidebarnav">
						<li><a class="waves-effect waves-dark" href="fristshow.html"
							aria-expanded="false"><i class="fa fa-tachometer"></i><span
								class="hide-menu">主页面</span></a></li>
						<li><a class="waves-effect waves-dark" href="usersShow.html"
							aria-expanded="false"><i class="fa fa-users"></i><span
								class="hide-menu">用户信息</span></a></li>
						<li><a class="waves-effect waves-dark" href="parkinfo.html"
							aria-expanded="false"><i class="fa fa-car"></i><span
								class="hide-menu">车库信息</span></a></li>
						<li><a class="waves-effect waves-dark" href="#"
							aria-expanded="false"><i class="fa fa-smile-o"></i><span
								class="hide-menu">车库操作</span></a></li>
						<li><a class="waves-effect waves-dark" href="#"
							aria-expanded="false"><i class="fa fa-file-text"
								aria-hidden="true"></i><span class="hide-menu">出入记录</span></a></li>
						<li><a class="waves-effect waves-dark" href="#"
							aria-expanded="false"><i class="fa fa-bookmark-o"></i><span
								class="hide-menu">Blank</span></a></li>
						<li><a class="waves-effect waves-dark" href="#"
							aria-expanded="false"><i class="fa fa-question-circle"></i><span
								class="hide-menu">关于我们</span></a></li>
					</ul>
				</nav>
			</div>
		</aside>
		<div class="page-wrapper">
			<div class="container-fluid">
				<div class="row page-titles">
					<div class="col-md-5 align-self-center">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active">完善个人信息</li>
						</ol>
					</div>
				</div>
				<div class="row">
					<!-- Column -->
					<div class="col-lg-4 col-xlg-3 col-md-5">
						<div class="card">
							<div class="card-body">
								<center class="m-t-30">
									<img src="../assets/images/users/5.jpg" class="img-circle"
										width="150" />
									<h4 class="card-title m-t-10">
										<c:if test="${empty user}">
											管理员登录ID：
											<font color="red" id="id">${admin.id}</font>
										</c:if>
										<c:if test="${empty admin}">
											用户登录ID：
											<font color="red" id="id">${user.id}</font>
										</c:if>
									</h4>
									<h6 class="card-subtitle">${user.username }
										${admin.adminname }</h6>
									<div class="row text-center justify-content-md-center">
										<div class="col-4">
											<a href="javascript:void(0)" class="link"><i
												class="icon-people"></i> <font class="font-medium">254</font>
											</a>
										</div>
										<div class="col-4">
											<a href="javascript:void(0)" class="link"><i
												class="icon-picture"></i> <font class="font-medium">54</font>
											</a>
										</div>
									</div>
								</center>
							</div>
						</div>
					</div>
					<!-- Column -->
					<!-- Column -->
					<div class="col-lg-8 col-xlg-9 col-md-7">
						<div class="card">
							<div class="card-body">
								<form class="form-horizontal form-material">
									<div class="form-group">
										<label class="col-md-12"><h3 class="text-themecolor">使用名：</h3></label>
										<div class="col-md-12">
											<input id="name" type="text" placeholder="输入你的名字"
												class="form-control form-control-line">
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-12">车牌号码：</label>
										<div class="col-md-12">
											<input id="licenseplate" type="text" placeholder="输入你的车牌号"
												class="form-control form-control-line">
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-12">性别</label>
										<div class="col-sm-6">
											<select id="selector" class="form-control form-control-line">
												<option value="0">男</option>
												<option value="1">女</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-12">年龄</label>
										<div class='input-group date col-md-7' id='startTime'>
											<input id="age" type='text'
												class="form-control form-control-line" readonly="readonly" />
											<span class="input-group-addon"><i
												class="fa fa-calendar" aria-hidden="true"></i> </span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-12">Phone No</label>
										<div class="col-md-12">
											<input id="phonenumber" type="text"
												placeholder="123 456 7890"
												class="form-control form-control-line">
										</div>
									</div>

									<div class="form-group">
										<div class="col-sm-12">
											<button class="btn btn-success" onclick="commit()">提交</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
					<!-- Column -->
				</div>
				<footer class="footer">
					© 2018 Adminwrap by wrappixe - More Templates <a
						href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>
					- Collect from <a href="http://www.cssmoban.com/" title="网页模板"
						target="_blank">网页模板</a>
				</footer>
			</div>
		</div>
		<script type="text/javascript">
			var id = $("#id").html();
			$(function(){
				$.ajax({
					type:"get",
					url:"../UserQyServlet",
					async:false,
					dataType: "json",
					data:{
						id:id
					},
					success:function(result){
						if(result.code==200){
							alert("查询信息失败，请联系管理员！！");
						}
						if(result.code==100){
							$("#name").val(result.extend.user.name);
							$("#licenseplate").val(result.extend.user.licenseplate);
							$("#age").val(result.extend.user.age);
							$("#phonenumber").val(result.extend.user.telephone);
							if(result.extend.user.sex=='男'){
								$("#selector").val('0');
							}else{
								$("#selector").val('1');
							}
							
						}
						
					},
					error:function(result){
						alert("查询信息失败，请联系管理员！！");
					}
					
				});
			});
				$('#startTime').datetimepicker({
					format: 'yyyy-mm-dd',
					weekStart: 1,
					initialDate:new Date(),
					language: 'zh-CN',
					minView: 2,
					autoclose: true,
					todayHighlight: 1,
					todayBtn: true,
					forceParse: true,
					keyboardNavigation: true,
					clearBtn: true,
					pickerPosition: 'bottom-left',
				}).on("changeDate", function(ev) {
					if(ev.date) {
						$('#endTime').datetimepicker('setStartDate', new Date(ev.date.valueOf()))

					} else {
						$('#endTime').datetimepicker('setStartDate', );
					}
				});
				function commit(){
					var name = $("#name").val();
					var licenseplate  = $("#licenseplate").val();
					var selector =$("#selector").val();
					var age = $("#age").val();
					var phone = $("#phonenumber").val();
					$.ajax({
					type:"get",
					url:"../Userservlet",
					async:false,
					dataType: "json",
					data:{
						id:id,
						name:name,
						licenseplate:licenseplate,
						selector:selector,
						age:age,
						phone:phone
					},
					success:function(result){
						if(result.code==200){
							alert("完善失败，请联系管理员！！");
						}
						if(result.code==100){
							alert("完善信息成功！！！");
						}
						
					},
					error:function(result){
						alert("完善失败，请联系管理员！！");
					}
					
				});
				}
			</script>
</body>

</html>