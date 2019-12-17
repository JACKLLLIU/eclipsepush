<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" sizes="16x16"
	href="../assets/images/favicon.png">
<link href="../assets/node_modules/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link type="text/css"
	href="../assets/node_modules/bootstrap/css/bootstrap-table.min.css"
	rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/colors/default.css" id="theme" rel="stylesheet">
<script src="../assets/node_modules/jquery/jquery.min.js"></script>
<script src="../assets/node_modules/bootstrap/js/popper.min.js"></script>
<script src="../assets/node_modules/bootstrap/js/bootstrap.min.js"></script>
<script src="../assets/node_modules/bootstrap/js/bootstrap-table.min.js"></script>
<script src="../assets/node_modules/bootstrap/js/bootstrap-table-zh-CN.min.js"></script>
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
						<li class="nav-item"><h3>
								欢迎用户<font color="red">${user.username }${admin.adminname}</font>来到系统
							</h3></li>
					</ul>
					<ul class="navbar-nav" style="float: right;">
						<li class="nav-item dropdown" style=""><a
							class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">更多设置<i
								class="fa fa-cog" aria-hidden="true"></i></a>
							<div class="dropdown-menu " style="min-width: 125px;">
								<a class="dropdown-item" href="#">退出登录</a> <a
									class="dropdown-item" href="#">修改密码</a> 
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
						<li class="active"><a class="waves-effect waves-dark"
							href="usersShow.jsp" aria-expanded="false"><i
								class="fa fa-users"></i><span class="hide-menu">用户信息</span></a></li>
						<li><a class="waves-effect waves-dark" href="parkinfo.jsp"
							aria-expanded="false"><i class="fa fa-car"></i><span
								class="hide-menu">车库信息</span></a></li>
						<li><a class="waves-effect waves-dark"
							href="../QSubServlet?id=${user.id}" aria-expanded="false"><i
								class="fa fa-smile-o"></i><span class="hide-menu">车库操作</span></a></li>
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
							<h5 class="card-title">Notification</h5>
							<div id="toolbar">
								
							</div>
							<table id="ArbetTable"></table>
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
		<script type="text/javascript">
			$(function() {
				//1.初始化Table
				var oTable = new TableInit();
				oTable.Init();
			});
			var TableInit = function() {
				var oTableInit = new Object();
				//初始化Table
				oTableInit.Init = function() {
					$('#ArbetTable').bootstrapTable({
						url : '../QAllUserServlet', //请求后台的URL（*）
						method : 'post', //请求方式（*）
						striped : true, //是否显示行间隔色
						cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
						pagination : true, //是否显示分页（*）
						sortable : true, //是否启用排序
						toolbar : '#toolbar',
						dataType : "json",
						sortOrder : "asc", //排序方式
						queryParamsType : "undefined",
						queryParams : oTableInit.queryParams,//传递参数（*）
						sidePagination : "client", //分页方式：client客户端分页，server服务端分页（*）
						pageNumber : 1, //初始化加载第一页，默认第一页
						pageSize : 5, //每页的记录行数（*）
						pageList : [ 5, 10, 15, 20 ], //可供选择的每页的行数（*）
						showRefresh : true, //显示刷新按钮
						search : true, //是否启用查询
						contentType : "application/x-www-form-urlencoded",
						showColumns : true, //是否显示所有的列
						//showExport : true,
						//clickToSelect : true, //是否启用点击选中行
						columns : [ {
							field : 'id',
							title : 'ID'
						}, {
							field : 'username',
							title : '用户名'
						}, {
							field : 'name',
							title : '使用名'
						}, {
							field : 'licenseplate',
							title : '车照'
						}, {
							field : 'age',
							title : '年龄'
						}, {
							field : 'sex',
							title : '性别'
						}, {
							field : 'telephone',
							title : '电话'
						}, {
							field : 'operate',
							title : '操作',
							width : '300',
							formatter : operateFormatter
						//自定义方法，添加操作按钮
						} ],
						onLoadSuccess : function() { //加载成功时执行
							console.info("加载成功");
						},
						onLoadError : function() { //加载失败时执行
							console.info("加载数据失败");
						}
					});

				};

				//得到查询的参数
				oTableInit.queryParams = function(params) {
					var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					//limit : params.limit, //页面大小
					//offset : params.offset
					/* 						pageNumber : params.pageNumber,
					 pageSize : params.pageSize, */
					};
					return temp;
				};
				return oTableInit;
			};

			function operateFormatter(value, row, index) {//赋予的参数
				////value： 该列的字段值；//row： 这一行的数据对象；//index： 行号，第几行，从0开始计算
				return [
						
						'<button  style="margin-right:10px;" class="btn btn-danger btn-sm" onclick="del(\''
								+ row.id
								+ '\')"><i class="fa fa-trash-o"></i> 删除</button>',
						'<button style="margin-right:10px;" class="btn btn-primary btn-sm" onclick="reset(\''
								+ row.id + '\')">重置密码</button>' ].join('');
			}
			
			
			
			function del(id) {
				var msg = confirm("您确定删除吗？");
				if (msg == true) {
					$.ajax({
						url : "../delUserServlet",
						data : {
							id : id
						},
						type : "POST",
						success : function(result) {
							alert(result);
							$('#ArbetTable').bootstrapTable('refresh');
						}
					});
				}
			}
		</script>
</body>

</html>