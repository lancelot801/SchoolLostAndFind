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

		<title>个人信息管理中心</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="bootstrap-3.3.5/dist/css/bootstrap.css" />
		<script type="text/javascript"
			src="bootstrap-3.3.5/js/tests/vendor/jquery.min.js">
</script>
		<script src="bootstrap-3.3.5/dist/js/bootstrap.min.js">
</script>
		<script type="text/javascript" src="js/myinfo.js">
</script>
		<style>
.myHidden {
	display: none;
}
</style>
	</head>

	<body>
		<div class="container-fluid" style="overflow: hidden;">
			<div class="row">
				<div class="col-md-pull-12">
					<ol class="breadcrumb">
						<li>
							当前的位置
						</li>
						<li>
							<a href="User/MyInfo.jsp">个人信息管理</a>
						</li>
					</ol>
				</div>
			</div>
			<div class="row">
				<div class="col-md-pull-12">
					<div class="row featurette">
						<div class="panel panel-primary">
							<div class="panel-heading">
								&nbsp;&nbsp;
								<span class="glyphicon glyphicon-user">&nbsp;个人信息管理</span>
							</div>
							<div class="panel-body">
								<ul class="nav nav-tabs" role="tablist" id="feature-tab">
									<li class="active">
										<a href="#tab-myinfo" role="tab" data-toggle="tab"> <span
											class="glyphicon glyphicon-user"></span>个人基本信息</a>
									</li>
									<li>
										<a href="#tab-updatePassword" role="tab" data-toggle="tab">
											<span class="glyphicon glyphicon-pencil"></span>修改密码</a>
									</li>
								</ul>
								<div class="tab-content">
									<div class="tab-pane active" id="tab-myinfo">
										<form action="updateUserInfo.action" method="post">
											<table class="table table-bordered table-hover table-striped"
												style="font-size: 13px;">
												<tr>
													<td>
														<input type="hidden" name="userInfoId" id="userDetailId"/>
														<label>
															学号
														</label>
													</td>
													<td>
														<input type="text" class="form-control"  readonly="readonly"
															value="${sessionScope.userId}" id="accountId"
															  name="userId.userId">
													</td>
												</tr>
												<tr>
													<td>
														<label>
															姓名
														</label>
													</td>
													<td>
														<input type="text" class="form-control" value=""
														  	id="userName" name="userName">
													</td>
												</tr>
												<tr>
													<td>
														<label>
															性别
														</label>
													</td>
													<td>
														<input type="text" class="form-control" value=""
															id="userGener" name="gender">
													</td>
												</tr>
												<tr>
													<td>
														<label>
															电话
														</label>
													</td>
													<td>
														<input type="text" class="form-control" value=""
															id="userPhone"  name="phoneNumber">
													</td>
												</tr>
												<tr>
													<td>
														<label>
															邮箱
														</label>
													</td>
													<td>
														<input type="text" class="form-control" value=""
															id="userEmail" name="email">
													</td>
												</tr>
												<tr>
													<td>
														<label>
															地址
														</label>
													</td>
													<td>
														<input type="text" class="form-control" value=""
															id="userDetail" name="DetailAddress">
													</td>
												</tr>
												<tr>
													<td colspan="2" style="text-align: center;">
														<button class="btn btn-info" type="submit" style="width: 100px">
															修改
														</button>
													</td>

												</tr>
											</table>

										</form>
									</div>

									<div class="tab-pane" id="tab-updatePassword">
										<form action="uppswd.action" method="post">
											<table class="table table-bordered table-hover table-striped"
												style="font-size: 13px;">
												<tr>
													<td>
														<label>
															学号
														</label>
													</td>
													<td>
														<input type="text" class="form-control"
															value="${sessionScope.userId}" readonly="readonly"
															disabled="disabled" id="accountId" name="account.userId">
													</td>
												</tr>
												<tr>
													<td>
														<label>
															新密码
														</label>
													</td>
													<td>
														<input type="password" class="form-control" value=""
															name="account.password">
													</td>
												</tr>
												<tr>
													<td>
														<label>
															确认密码
														</label>
													</td>
													<td>
														<input type="password" class="form-control" value=""
															name="password">
													</td>
												</tr>

												<tr>
													<td colspan="2" class="text-center">
														<button type="submit" class="btn btn-info">
															提交
														</button>
													</td>

												</tr>

											</table>
										</form>
									</div>

								</div>

							</div>
						</div>
					</div>

				</div>

			</div>
		</div>



		<!-- 模态框（Modal） -->
		<div class="modal  fade" id="mycheckfinding">
			<div class="modal-dialog">
				<div class="modal-content" style="">
					<div class="modal-header">
						<button class="close" data-dismiss="modal" type="button">
							&times;
						</button>
						<h4 class="modal-title">
							<label class="label label-success">
								<span class="glyphicon glyphicon-user">审核捡拾提交</span>
							</label>
						</h4>
					</div>
					<div class="modal-body">
						<br />
						<br />
						<table class="table table-bordered table-hover table-striped"
							style="font-size: 13px;">


							<tr>
								<td>
									<label>
										捡拾者姓名
									</label>
								</td>
								<td>
									<input type="text" value="">
								</td>
							</tr>
							<tr>
								<td>
									<label>
										物品名称
									</label>
								</td>
								<td>
									<input type="text" value="">
								</td>
							</tr>
							<tr>
								<td>
									<label>
										描述
									</label>
								</td>
								<td>
									<input type="text" value="">
								</td>
							</tr>

						</table>
					</div>
					<br />
					<br />
					<div class="modal-footer">
						<lable style="float right">
						审核意见
						</lable>
						<input type="text" style="height: 30px">
						<br />
						<button>
							提交
						</button>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
