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
		<link rel="icon" type="image/png" sizes="16x16" href="../assets/images/favicon.png">
		<link href="../assets/node_modules/bootstrap/css/bootstrap.min.css" rel="stylesheet">
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
					<div style="border-bottom: 1px solid rgba(120, 130, 140, 0.13);" class="navbar-header">
						<a class="navbar-brand" href="fristshow.html">
							<b>
                            <img style="height: 40px;width: 45px;" src="../assets/images/car.jpg" alt="homepage" class="dark-logo" />
                            <img style="height: 20px;width: 100px;"src="../assets/images/logo-light-icon.png" alt="homepage" class="light-logo" />
                        </b>
							<span>
                         <img style="height: 50px;width: 180px;"src="../assets/images/partcar.png" alt="homepage" class="dark-logo" />
                         <img src="../assets/images/logo-light-text.png" class="light-logo" alt="homepage" />
                        </span>
						</a>
					</div>
					<!--  -->
					<div style="height: 74px;" class="navbar-collapse">
						<ul class="navbar-nav mr-auto">
							<li class="nav-item"><h3>欢迎用户<font color="red">${user.username }</font>来到系统</h3></li>
						</ul>
						<ul class="navbar-nav" style="float: right;">
							<li class="nav-item dropdown" style="">
								<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">更多设置<i class="fa fa-cog" aria-hidden="true"></i></a>
								<div class="dropdown-menu " style="min-width: 125px;">
									<a class="dropdown-item" href="#">退出登录</a>
									<a class="dropdown-item" href="#">修改密码</a>
									<a class="dropdown-item" href="modperson.jsp">个人信息</a>
								</div>
							</li>
						</ul>

					</div>
				</nav>
			</header>
			<aside class="left-sidebar">
				<div class="scroll-sidebar">
					<nav class="sidebar-nav">
						<ul id="sidebarnav">
							<li>
								<a class="waves-effect waves-dark" href="fristshow.jsp" aria-expanded="false"><i class="fa fa-tachometer"></i><span class="hide-menu">主页面</span></a>
							</li>
							<li class="active">
								<a class="waves-effect waves-dark" href="usersShow.jsp" aria-expanded="false"><i class="fa fa-users"></i><span class="hide-menu">用户信息</span></a>
							</li>
							<li>
								<a class="waves-effect waves-dark" href="parkinfo.jsp" aria-expanded="false"><i class="fa fa-car"></i><span class="hide-menu">车库信息</span></a>
							</li>
							<li>
								<a class="waves-effect waves-dark" href="subscribe.jsp" aria-expanded="false"><i class="fa fa-smile-o"></i><span class="hide-menu">车库操作</span></a>
							</li>
							<li>
								<a class="waves-effect waves-dark" href="#" aria-expanded="false"><i class="fa fa-file-text" aria-hidden="true"></i><span class="hide-menu">出入记录</span></a>
							</li>
							<li>
								<a class="waves-effect waves-dark" href="#" aria-expanded="false"><i class="fa fa-bookmark-o"></i><span class="hide-menu">Blank</span></a>
							</li>
							<li>
								<a class="waves-effect waves-dark" href="#" aria-expanded="false"><i class="fa fa-question-circle"></i><span class="hide-menu">关于我们</span></a>
							</li>
						</ul>
					</nav>
				</div>
			</aside>
			<div class="page-wrapper">
				<div class="container-fluid">
					<div class="row page-titles">
						<div class="col-md-5 align-self-center">
							<ol class="breadcrumb">
								<li class="breadcrumb-item">
									<a href="javascript:void(0)">Home</a>
								</li>
								<li class="breadcrumb-item active">主页面</li>
							</ol>
						</div>
					</div>
					<div class="row">
						<!-- Start Notification -->
						<div class="col-md-12">
							<div class="card card-body mailbox">
								<h5 class="card-title">Notification</h5>
								<div class="message-center ps ps--theme_default ps--active-y" data-ps-id="a045fe3c-cb6e-028e-3a70-8d6ff0d7f6bd">
									<!-- Message -->
									<a href="#">
										<div class="btn btn-danger btn-circle"><i class="fa fa-link"></i></div>
										<div class="mail-contnet">
											<h5>Luanch Admin</h5> <span class="mail-desc">Just see the my new admin!</span> <span class="time">9:30 AM</span> </div>
									</a>
									<!-- Message -->
									<a href="#">
										<div class="btn btn-success btn-circle"><i class="fa fa-calendar-check-o"></i></div>
										<div class="mail-contnet">
											<h5>Event today</h5> <span class="mail-desc">Just a reminder that you have event</span> <span class="time">9:10 AM</span> </div>
									</a>
									<!-- Message -->
									<a href="#">
										<div class="btn btn-info btn-circle"><i class="fa fa-cog"></i></div>
										<div class="mail-contnet">
											<h5>Settings</h5> <span class="mail-desc">You can customize this template as you want</span> <span class="time">9:08 AM</span> </div>
									</a>
									<!-- Message -->
									<a href="#">
										<div class="btn btn-primary btn-circle"><i class="fa fa-user"></i></div>
										<div class="mail-contnet">
											<h5>Pavan kumar</h5> <span class="mail-desc">Just see the my admin!</span> <span class="time">9:02 AM</span> </div>
									</a>
								</div>
							</div>
						</div>
					</div>
					<footer class="footer"> © 2018 Adminwrap by wrappixe - More Templates
						<a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from
						<a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
					</footer>
				</div>
			</div>

	</body>

</html>