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
	src="bootstrap-3.3.5/js/tests/vendor/jquery.min.js"></script>
<script src="bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container-fluid" style="overflow-x: hidden;">
		<div class="row">
			<div class="col-md-pull-12">
				<ol class="breadcrumb">
					<li>当前的位置</li>
					<li><a href="main.jsp">首页</a></li>
					<li><a href="Location.jsp">校园招领点</a></li>
				</ol>
			</div>
		</div>
		<div class="row">
			<table class="table table-hover table-bordered" style="font-size:13px;">
				<thead>
					<tr>
						<th class="text-primary">校区</th>
						<th class="text-primary">招领点</th>
						<th class="text-primary">联系电话</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td rowspan="4" style="width:250px;height:220px;">
							<div style="width:100%;height:100%;position:relative;">
								<a href="#" class="thumbnail"> <img src="img/chennan.jpg"
									style="width:260px;height:200px;" alt="通用的占位符缩略图">
								</a>
								<div
									style="position:absolute;width:100%;height:30px;background-color:orange;color:white;font-size:20px;top:160px;left:5px;opacity: 0.7;text-align: center;">城南校区</div>
							</div>
						</td>
						<td>江苏省徐州市云龙区丽水路2号 大学生活动中心</td>
						<td>05168432910432</td>
					</tr>
					<tr>

						<td>江苏省徐州市云龙区丽水路2号 大学生活动中心</td>
						<td>05168432910432</td>
					</tr>
					<tr>

						<td>江苏省徐州市云龙区丽水路2号</td>
						<td>05168432910432</td>
					</tr>
					<tr>

						<td>江苏省徐州市云龙区丽水路2号</td>
						<td>05168432910432</td>
					</tr>
					<tr>
						<td colspan="3"></td>
					</tr>
					<tr>
						<td rowspan="4" style="width:250px;height:220px;">
							<div style="width:100%;height:100%;position:relative;">
								<a href="#" class="thumbnail"> <img src="img/zhongxing.jpg"
									style="width:260px;height:200px;" alt="通用的占位符缩略图">
								</a>
								<div
									style="position:absolute;width:100%;height:30px;background-color:red;color:white;font-size:20px;top:160px;left:5px;opacity: 0.7;text-align: center;">中心校区</div>
							</div>
						</td>
						<td>江苏省徐州市云龙区丽水路2号</td>
						<td>05168432910432</td>
					</tr>
					<tr>

						<td>江苏省徐州市云龙区丽水路2号</td>
						<td>05168432910432</td>
					</tr>
					<tr>

						<td>江苏省徐州市云龙区丽水路2号</td>
						<td>05168432910432</td>
					</tr>
					<tr>

						<td>江苏省徐州市云龙区丽水路2号</td>
						<td>05168432910432</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
