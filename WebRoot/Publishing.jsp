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
<script type="text/javascript" src="js/Publishing.js"></script>
</head>

<body>
	<div class="container-fluid" style="overflow: hidden;">
		<div class="row">
			<div class="col-md-pull-12">
				<ol class="breadcrumb">
					<li>当前的位置</li>
					<li><a href="main.jsp">首页</a></li>
					<li><a href="Publishing.jsp">招领信息</a></li>
				</ol>
			</div>
		</div>
		<div class="row">
			<div class="col-md-pull-12">
				<div class="row featurette">
					<div class="panel panel-primary">
						<div class="panel-heading">
							&nbsp;&nbsp;<span class="glyphicon glyphicon-picture">&nbsp;招领信息</span>
						</div>
						<div class="panel-body">
							<!--选择栏-->
							<div class="row featurette">
								<div class="well well-sm">
									<div class="container">
										<div class="row">
											<div class="col-md-12">
												<div class="pull-left">
													<select class="form-control"
														style="width:260px;margin-left:200px;" id="itemsCategory">
														<option value="">--选择物件类型--</option>
													</select>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!--
                                	 主要内容
                                -->
							<table class="table table-bordered table-hover table-striped" style="font-size:13px;">
								<thead>
									<tr>
										<th class="text-primary">类型</th>
										<th class="text-primary">名称</th>
										<th class="text-primary">地点</th>
										<th class="text-primary">发布时间</th>
										<th class="text-primary">描述</th>
										<th class="text-primary">详情</th>
									</tr>
								</thead>
								<tbody id="loadingResult">
									 <!-- 加载的内容 -->
								</tbody>
							</table>
						</div>
						<div class="panel-footer">
							<div class="container">
								<div class="pull-right">
									<ul class="pagination">
										<li><a href="#">&laquo;</a></li>
										<li><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
										<li><a href="#">5</a></li>
										<li><a href="#">&raquo;</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
