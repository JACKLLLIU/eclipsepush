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
<script src="../assets/node_modules/jquery/jquery.min.js"></script>
<script src="../assets/node_modules/bootstrap/js/popper.min.js"></script>
<script src="../assets/node_modules/bootstrap/js/bootstrap.min.js"></script>
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
						<li class="nav-item">
							<h3>
								欢迎<font color="red">${user.username }${admin.adminname}</font>来到系统
							</h3> 
							<input id="admin_id" style="display: none;" type="text"
							disabled="disabled" value="${admin.id}" /> 
							<input id="user_id" style="display: none;" type="text" disabled="disabled"
							value="${user.id}" />
						</li>
					</ul>
					<ul class="navbar-nav" style="float: right;">
						<li class="nav-item dropdown" style=""><a
							class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">更多设置<i
								class="fa fa-cog" aria-hidden="true"></i></a>
							<div class="dropdown-menu " style="min-width: 125px;">
								<a class="dropdown-item" href="#">退出登录</a> <a
									class="dropdown-item" href="changepsw.jsp">修改密码</a>
							</div></li>
					</ul>

				</div>
			</nav>
		</header>
		<aside class="left-sidebar">
			<div class="scroll-sidebar">
				<nav class="sidebar-nav">
					<ul id="sidebarnav">
						<li><a class="waves-effect waves-dark" href="modperson.jsp"
							aria-expanded="false"><i class="fa fa-address-card-o"></i><span
								class="hide-menu">个人信息</span></a></li>
						<li><a class="waves-effect waves-dark" href="usersShow.jsp"
							aria-expanded="false"><i class="fa fa-users"></i><span
								class="hide-menu">用户信息</span></a></li>
						<li><a class="waves-effect waves-dark" href="parkinfo.jsp"
							aria-expanded="false"><i class="fa fa-car"></i><span
								class="hide-menu">车库信息</span></a></li>
						<li><a class="waves-effect waves-dark"
							href="../QSubServlet?id=${user.id}" aria-expanded="false"><i
								class="fa fa-smile-o"></i><span class="hide-menu">我的预约</span></a></li>
						<li class=""><a class="waves-effect waves-dark"
							href="${pageContext.request.contextPath}/QoccupyServlet?id=${user.id}"
							aria-expanded="false"><i class="fa fa-street-view"></i><span
								class="hide-menu">占有车位</span></a></li>
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
							<li class="breadcrumb-item"><a href="javascript:void(0)">Home</a>
							</li>
							<li class="breadcrumb-item active">主页面</li>
						</ol>
					</div>
				</div>
				<div class="row">
					<!-- Start Notification -->
					<div class="col-md-12">
						<div class="card card-body mailbox">
							<h5 class="card-title">修改密码</h5>
							<form class="form-horizontal" style="margin: 0 auto;">
								<div class="form-group col-md-8">
									<label class="control-label"><h3
											class="text-themecolor">原密码</h3></label> <input class="form-control"
										type="text" placeholder="请输入原密码" id="psd1">
								</div>
								<div class="form-group col-md-8">
									<lable class="control-label">
									<h3 class="text-themecolor">新密码</h3>
									</lable>
									<input class="form-control" type="password"
										placeholder="请输新入密码" id="psd2">
								</div>
								<div class="form-group col-md-8">
									<lable class="control-label">
									<h3 class="text-themecolor">再次输入新密码</h3>
									</lable>
									<input class="form-control" type="password"
										placeholder="请再次输入密码" id="psd3">
								</div>
								<div class="form-group col-md-8">
									<input type="button" value="提交" class="btn btn-success"
										onclick="commit()">
								</div>
							</form>
						</div>
					</div>
				</div>
				<footer class="footer">
					© 2018 Adminwrap by wrappixe - More Templates <a
						href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>
					- Collect from <a href="http://www.cssmoban.com/" title="网页模板"
						target="_blank">网页模板</a>
				</footer>

			</div>
		</div>
	</div>
	<script type="text/javascript">
		function commit(){
			var userId = $("#user_id").val();
			var psd1 = $("#psd1").val();
			var psd2 = $("#psd2").val();
			var psd3 = $("#psd3").val();
			if(psd2!=psd2){
				alert("2次输入的密码不一致！！");
				return;
			}
			$.ajax({
				url : "../ResetPsdServlet",
				data : {
					id:userId,
					psd1:psd1,
					psd2:psd2
				},
				type : "POST",
				dataType : "JSON ",
				success : function(result) {
					if(result.code == 100){
						window.location.href = result.extend.url;
					}
				}
			});
		}
	</script>
</body>

</html>