<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="bootstrap-3.3.5/dist/css/bootstrap.min.css" />
<link rel="stylesheet" href="bootstrapvalidator/css/bootstrapValidator.min.css"/>
<script type="text/javascript"
	src="bootstrap-3.3.5/js/tests/vendor/jquery.min.js"></script>
<script src="bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src="bootstrapvalidator/js/bootstrapValidator.min.js"></script>
<script src="js/index.js"></script>
<style>
.footingul li {
	float: left;
	padding: 10px;
}
</style>
</head>

<body>
	<div class="container" style="overflow:hidden;">
		<div class="row" style="height:150px;">
			<div class="col-md-1"></div>
			<div class="col-md-10"
				style="height:150px;background-image:url(img/heading.jpg);background-size:100% 100%;background-repeat: no-repeat;">
				<h3>
					<label class="label label-success"><span
						class="glyphicon glyphicon-heart"></span>&nbsp;徐州工程学院校园失物招领&nbsp;<span
						class="glyphicon glyphicon-heart"></span></label>
				</h3>
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="well well-sm">
					<ul class="nav nav-pills webdirection">
						<li role="presentation" class="active"><a href="#"><span
								class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;首页</a></li>
						<li role="presentation"><a href="#"><span
								class="glyphicon glyphicon-picture"></span>&nbsp;招领信息</a></li>
						<li role="presentation"><a href="#"><span
								class="glyphicon glyphicon-search"></span>&nbsp;寻物信息</a></li>
						<li role="presentation"><a href="#"><span
								class="glyphicon glyphicon-star-empty"></span>&nbsp;校园招领点</a></li>
						<li role="presentation"><a href="#"><span
								class="glyphicon glyphicon-hand-right"></span>&nbsp;使用指南</a></li>
						<li role="presentation" style="float:right;">
						
							<button class="btn btn-success" id="userlogin">
								<span class="glyphicon glyphicon-user"></span>&nbsp;<span id="userIdlogin">立即登录</span>								 
							</button>
							<button class="btn btn-primary" id="userMain" style="display:none;">个人中心</button>
							<button class="btn btn-default" id="userloginout" style="display:none;">注销</button>
						</li>
					</ul>
				</div>
				<div class="panel panel-default">
					<div class="panel-body" style="height:850px;">
						<iframe src="main.jsp" width="100%" height="100%" border="none"
							frameborder="0" id="content"></iframe>
					</div>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="container">
							<div class="col-md-2"></div>
							<div class="col-md-8">
								<ul class="footingul" style="list-style: none;">
									<li><a href="http://www.xzit.edu.cn/" target="_blank"><span
											class="glyphicon glyphicon-th-large"></span>&nbsp;学校官网</a></li>
									<li><a href="http://gh.xzit.edu.cn/" target="_blank"><span
											class="glyphicon glyphicon-wrench"></span>&nbsp;工会</a></li>
									<li><a href="http://tw.xzit.edu.cn/" target="_blank"><span
											class="glyphicon glyphicon-book"></span>&nbsp;团委</a></li>
									<li><a href="http://etc.xzit.edu.cn/" target="_blank"><span
											class="glyphicon glyphicon-info-sign"></span>&nbsp;信息化中心</a></li>
									<li><a href="http://hqfwzx.xzit.edu.cn/" target="_blank"><span
											class="glyphicon glyphicon-tree-deciduous"></span>&nbsp;后勤服务中心</a></li>
								</ul>
							</div>
							<div class="col-md-2"></div>
						</div>
						<hr />
						<div class="well well-sm">
							<p style="text-align: center;font-size:15px;">13计卓版权所有
								@copyright 2015</p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>

	<!-- 模态框（Modal） -->
	<div class="modal  fade" id="mylogin">
		<div class="modal-dialog">
			<div class="modal-content" style="background-color：#ffffff;">
				<div class="modal-header">
					<button class="close" data-dismiss="modal" type="button">&times;</button>
					<h4 class="modal-title">
						<label class="label label-success"><span
							class="glyphicon glyphicon-user">用户登录</span></label>
					</h4>
				</div>
				<div class="modal-body">
					<br /> <br />
					<form role="form" id="loinForm" class="form-horizontal" action="${pageContext.request.contextPath}/login" method="post">
						<div class="form-group">
							<label for="exampleInputEmail3" class="col-sm-2 control-label"><span
								class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;账户</label>
							<div class="col-sm-10">
								<input type="text" name="userId" class="form-control" id="exampleInputEmail3"
									placeholder="请输入您的账户号码">
							</div>
						</div>

						<div class="form-group">
							<label for="exampleInputPassWord3" class="col-sm-2 control-label"><span
								class="glyphicon glyphicon-lock"></span>&nbsp;&nbsp;密码</label>
							<div class="col-sm-10">
								<input type="password" class="form-control"
									id="exampleInputPassWord3" name="password" placeholder="请输入您的密码">
							</div>
						</div>

						<div style="text-align: center;">
							<button class="btn btn-primary" style="width:350px;" type="submit">
								<span class=" glyphicon glyphicon-ok-sign"></span>&nbsp;登录
							</button>
						</div>
					</form>
				</div>
				<br /> <br />
				<div class  ="modal-footer">
					<div class="container">
						<div class="pull-left">
							<a href="#" title="还没激活账号？赶紧用学号注册吧！" id="registAccount"
								data-dismiss="modal">注册账号</a> <span style="margin-left:150px;"><i>徐州工程学院失物招领平台</i></span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
