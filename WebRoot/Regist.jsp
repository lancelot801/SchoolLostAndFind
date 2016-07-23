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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="bootstrap-3.3.5/dist/css/bootstrap.css" />
<link rel="stylesheet"
	href="bootstrapvalidator/css/bootstrapValidator.min.css" />
<script type="text/javascript"
	src="bootstrap-3.3.5/js/tests/vendor/jquery.min.js"></script>
<script type="text/javascript"
	src="bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="bootstrapvalidator/js/bootstrapValidator.min.js"></script>
<script src="js/Regist.js"></script>
</head>

<body>
	<div class="container-fluid" style="overflow:hidden;">
		<div class="row">
			<div class="col-md-pull-12">
				<ol class="breadcrumb">
					<li>当前的位置</li>
					<li><a href="main.jsp">首页</a></li>
					<li><a href="Regist.jsp">注册账户</a></li>
				</ol>
			</div>
		</div>
		<div class="row">
			<div class="row featurette">
				<form id="regist" action="${pageContext.request.contextPath}/regist"
					method="post" enctype="multipart/form-data">
					<div class="panel panel-primary">
						<div class="panel-heading">
							&nbsp;&nbsp;<span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;注册用户
						</div>
						<div class="panel-body">
							<div class="panel panel-default">
								<div class="panel-body">
									<table class="table table-hover table-bordered"
										style="font-size:13px;">
										<tr>
											<td>一卡通号</td>
											<td>
												<div class="form-group">
													<input type="text" class="form-control" id="userId"
														name="userId.userId" placeholder="请输入一卡通号码" />
												</div>
											</td>
										</tr>
										<tr>
											<td>密码</td>
											<td>
												<div class="form-group">
													<input type="password" class="form-control" id="password"
														name="userId.password" placeholder="请输入密码" />
												</div>
											</td>
										</tr>
										<tr>
											<td>确认密码</td>
											<td>
												<div class="form-group">
													<input type="password" class="form-control"
														id="surePassword" name="surePassword"
														placeholder="请再次输入密码" />
												</div>
											</td>
										</tr>
										<tr>
											<td>用户</td>
											<td>
												<div class="form-group">
													<input type="text" class="form-control" id="userName"
														name="userName" placeholder="请输入用户名" />
												</div>
											</td>
										</tr>
										<tr>
											<td>性别</td>
											<td>
												<div class="form-group">
													<input type="radio" name="gender" value="男"
														checked="checked" />男 &nbsp; <input type="radio"
														name="gender" value="女" />女
												</div>
											</td>
										</tr>
										<tr>
											<td>电子邮箱</td>
											<td>
												<div class="form-group">
													<input type="text" class="form-control" id="email"
														name="email" placeholder="请输入电子邮箱" />
												</div>
											</td>
										</tr>
										<tr>
											<td>手机号</td>
											<td>
												<div class="form-group">
													<input type="text" class="form-control" id="phoneNumber"
														name="phoneNumber" placeholder="请输入手机号" />
												</div>
											</td>
										</tr>
										<tr>
											<td>详细地址</td>
											<td>
												<div class="form-group">
													<textarea class="form-control" placeholder="请输入用户的详细地址"
														name="detailAddress"></textarea>
												</div>
											</td>
										</tr>
									</table>
								</div>
							</div>
							<div style="text-align: center;" class="form-group">
								<button type="submit" class="btn btn-success" id="registUser"
									name="registUser">
									<span class="glyphicon glyphicon-check"></span>注册用户
								</button>
								&nbsp;&nbsp;
								<button class="btn btn-danger" id="resetUser">
									<span class="glyphicon glyphicon-repeat"></span>重新注册
								</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
