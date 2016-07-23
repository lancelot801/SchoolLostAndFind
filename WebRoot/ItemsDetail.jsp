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
		<link rel="stylesheet" href="bootstrap-3.3.5/dist/css/bootstrap.css" />
		<script type="text/javascript"
			src="bootstrap-3.3.5/js/tests/vendor/jquery.min.js">
</script>
		<script src="bootstrap-3.3.5/dist/js/bootstrap.min.js">
</script>
		<script type="text/javascript" src="js/itemsDetail.js">
</script>
		<style>
table tr td:first-child {
	width: 120px;
}

* {
	font-size: "微软雅黑";
}
</style>
	</head>

	<body>
		<div class="container-fluid" style="overflow: hidden;">
			<div class="row">
				<div class="col-md-pull-12">
					<ol class="breadcrumb" id="leading">
						<li>
							当前的位置
						</li>
						<li>
							<a href="main.jsp">首页</a>
						</li>
					</ol>
				</div>
			</div>
			<div class="row">
				<div class="col-md-pull-12">
					<div class="row featurette">
						<div class="panel panel-primary">
							<div class="panel panel-heading">
								&nbsp;&nbsp;
								<span class="glyphicon glyphicon-tag"></span>&nbsp;&nbsp;物品的详细信息
							</div>
							<div class="panel panel-body">
								<table class="table table-hover table-bordered"
									style="font-size: 13px;">
									<tr>
										<td>
											物品的名称
										</td>
										<td>
											<h4>
												<label class="label label-info" id="itemsName"></label>
											</h4>
										</td>
									</tr>
									<tr>
										<td>
											物品的类别
										</td>
										<td>
											<h4>
												<label class="label label-danger" id="category">
													类别
												</label>
											</h4>
										</td>
									</tr>
									<tr>
										<td>
											物品的描述
										</td>
										<td>
											<textarea readonly="readonly" id="describtion"
												class="form-control"></textarea>
										</td>
									</tr>
								</table>
								<hr />
								<!--捡拾信息-->
								<table class="table table-hover table-bordered"
									id="pickingTable" style="font-size: 13px;">
									<tr>
										<td>
											捡拾人
										</td>
										<td>
											<label id="picker">
												小杨
											</label>
										</td>
									</tr>
									<tr>
										<td>
											捡拾时间
										</td>
										<td>
											<label id="pickTime"></label>
										</td>
									</tr>
									<tr>
										<td>
											捡拾地点
										</td>
										<td>
											<label id="pickingLocation"></label>
										</td>
									</tr>
									<tr>
										<td>
											捡拾人联系方式
										</td>
										<td>
											<label id="phoneNumber"></label>
										</td>
									</tr>
								</table>
								<!--丢失信息-->
								<table class="table table-hover table-bordered"
									id="findingTable" style="display: none; font-size: 13px;">
									<tr>
										<td>
											寻物人
										</td>
										<td>
											<label id="finder">
												小杨
											</label>
										</td>
									</tr>
									<tr>
										<td>
											丢失时间
										</td>
										<td>
											<label id="losingTime">
												2016-01-03
											</label>
										</td>
									</tr>
									<tr>
										<td>
											丢失人联系方式
										</td>
										<td>
											<label id="finderPhoneNumber">
												121323232
											</label>
										</td>
									</tr>
									<tr>
										<td>
											邮箱
										</td>
										<td>
											<label id="finderEmail"></label>
										</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
