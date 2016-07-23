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
<link rel="stylesheet"
	href="bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet"
	href="bootstrapvalidator/css/bootstrapValidator.min.css" />
<script type="text/javascript"
	src="bootstrap-3.3.5/js/tests/vendor/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script src="bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="bootstrap-datetimepicker-master/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript"
	src="bootstrapvalidator/js/bootstrapValidator.min.js"></script>
<script src="js/main.js"></script>
<style>
ul.publishingUl li {
	line-height: 40px;
	border-bottom: dotted 1px lightgray;
}

ul.publishingUl li:hover {
	background-color: #EEE;
}

span.spanTime {
	float: right;
}

.publishingName {
	color: darkred;
}

.mylabStyle{
	font-size:13px;
}
*{
	font-size:"微软雅黑";
}
</style>
</head>

<body>
	<div class="container" style="width:100%;height:100%;font-size:13px;">
		<div style="float:left;width:60%;height:100%;">
			<div class="panel panel-default">
				<div class="panel-body" style="height:690px;">
					<ul class="nav nav-tabs" role="tablist" id="feature-tab">
						<li class="active"><a href="#tab-latestfinding" role="tab"
							data-toggle="tab"><span class="glyphicon glyphicon-picture"></span>最新招领信息</a></li>
						<li><a href="#tab-latestlosing" role="tab" data-toggle="tab"><span
								class="glyphicon glyphicon-search"></span>最新寻物信息</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="tab-latestfinding">
							<ul
								style="list-style: none; float:left;padding-left:0px;width:100%;"
								class="publishingUl" id="pickingResultUL">
							 <!-- 内容 -->
							</ul>
						</div>
						<div class="tab-pane" id="tab-latestlosing">
							<ul
								style="list-style: none; float:left;padding-left:0px;width:100%;"
								class="publishingUl" id="findingResultUL">
								<!-- 内容 -->								 
							</ul>
						</div>
					</div>
					<div>
						<a style="color：green;display: block; float:right;cursor:pointer;"
							id="moreInfo">更多<span class="glyphicon glyphicon-forward"></span></a>
					</div>
					<div>
						<button class="btn btn-success" id="seeGetLocation">
							<span class="glyphicon glyphicon-hand-right"></span>&nbsp;&nbsp;失物招领地点
						</button>
					</div>
					<div>
						<div class="container" style="margin-top:10px;">
							<div class="pull-left">
								<a href="Location.html" class="thumbnail"> <img
									src="img/chennan.jpg" style="width:150px;height:100px;"
									title="城南校区" alt="通用的占位符缩略图">
								</a>
							</div>
							<div class="pull-left" style="margin-left:40px;">
								<a href="Location.html" class="thumbnail"> <img
									src="img/zhongxing.jpg" style="width:150px;height:100px;"
									title="中心校区" alt="通用的占位符缩略图">
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div style="width:40%;float:left;height:100%;">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<span class="glyphicon glyphicon-heart"></span>&nbsp;徐州工程学院失物招领平台
						</div>
						<div class="panel-body">Hi!失物招领网是由后勤集团基于我校数字
							化校园构建的网上失物招领平台，系统开发由信 息网络中心指导下的学生组织阿尔法工作室负责，
							日常运维由后勤集团和我校学生会权益保障部负责 。本着为广大师生服务的原则，旨在建立全校失物招
							领系统，实现校园内"失物有处寻，拾物有处交"。欢迎大家使用~</div>
						<div class="panel-footer">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button class="btn btn-primary" id="btnPicking">
								<span class="glyphicon glyphicon-bullhorn"></span>&nbsp;捡拾物品
							</button>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<button class="btn btn-primary" id="btnFinding">
								<span class="glyphicon glyphicon-zoom-in"></span>&nbsp;丢失物品
							</button>
						</div>
					</div>
					<div class="panel panel-info">
						<div class="panel-heading">
							<span class="glyphicon glyphicon-send"></span>&nbsp;网站公告
						</div>
						<div class="panel-body">
							<table class="table table-bordered table-hover"
								style="font-size:13px;">
								<thead>
									<tr>
										<th>内容</th>
										<th>时间</th>
									</tr>
								</thead>
								<tbody id="newsPart">
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- J捡拾物品模态框（Modal） -->
	<div class="modal  fade" id="myPickingModal">
		<div class="modal-dialog">
			<form id="myPicking"
				action="${pageContext.request.contextPath}/addPicking.action"
				method="post">
				<div class="modal-content">
					<div class="modal-header">
						<button class="close" data-dismiss="modal" type="button">&times;</button>
						<h4 class="modal-title">
							<span class="glyphicon glyphicon-leaf"></span>&nbsp;捡拾物品上传
						</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="form-group">
									<label for="ItemsName" class="col-sm-2 control-label mylabStyle">物品名称</label>
									<div class="col-sm-10">
										<input type="text" id="ItemsName" name="items.itemsName"
											class="form-control" placeholder="请输入物品的名称" />
									</div>
								</div>
								<br /> <br />
								<div class="form-group">
									<label for="dtp_input1" class="col-sm-2 control-label mylabStyle">捡拾时间</label>
									<div class="input-group date form_datetime col-sm-10"
										data-date="2016-01-01T05:25:07Z"
										data-date-format="yyyy-MM-dd HH:mm:ss"
										style="margin-left:105px;width:280px;"
										data-link-field="dtp_input1">
										<input class="form-control" name="pickTime" size="16"
											type="text" value="" placeholder="请选择捡拾的时间" readonly>
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-remove"></span></span> <span
											class="input-group-addon"><span
											class="glyphicon glyphicon-th"></span></span>
									</div>
									<input type="hidden" id="dtp_input1" value="" />
								</div>
								<br/>
								<div class="form-group">
									<label for="picker" class="col-sm-2 control-label mylabStyle">捡拾地点</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="picker"
											name="PickLocation" placeholder="请输入捡拾的地点" />
									</div>
								</div>
								<br /> <br />
								<div class="form-group">
									<label for="CategoryId" class="col-sm-2 control-label mylabStyle">物品种类</label>
									<div class="col-sm-10">
										<select class="form-control categoryList" id="CategoryId"
											name="items.itemsCategory.categoryId">
											<option value="">--请选择物品的种类--</option>
										</select>
									</div>
								</div>
								<br /> <br />
								<div class="form-group">
									<label for="ItemDescribtion" class="col-sm-2 control-label mylabStyle">物品描述</label>
									<div class="col-sm-10">
										<textarea class="form-control" id="ItemDescribtion"
											name="items.itemsDescribtion" placeholder="请输入物品的描述"></textarea>
									</div>
								</div>
								<br /> <br /> <br /> <br />
								<div class="form-group">
									<label for="picker" class="col-sm-2 control-label mylabStyle">捡拾者</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="picker"
											name="picker" placeholder="请输入您的名字" />
									</div>
								</div>
								<br /> <br />
								<div class="form-group">
									<label for="pickPhone" class="col-sm-2 control-label mylabStyle">联系方式</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="pickPhone"
											name="pickPhone" placeholder="输入您的联系方式" />
									</div>
								</div>
								<br /> <br />
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" id="btnClose" class="btn btn-default"
							data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary">提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<!-- 丢失物品模态框 -->
	<div class="modal  fade" id="myFindingModal">
		<div class="modal-dialog">
			<form id="myFinding" action="addFindingItems.action" method="post">
				<div class="modal-content">
					<div class="modal-header">
						<button class="close" data-dismiss="modal" type="button">&times;</button>
						<h4 class="modal-title">
							<span class="glyphicon glyphicon-search"></span>丢失物品
						</h4>
					</div>
					<div class="modal-body">
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="form-group">
									<label for="ItemsName" class="col-sm-2 control-label mylabStyle">物品名称</label>
									<div class="col-sm-10">
										<input type="text" id="ItemsName" name="items.itemsName"
											class="form-control" placeholder="请输入物品的名称" />
									</div>
								</div>
								<br /> <br />
								<div class="form-group">
									<label for="dtp_input2" class="col-sm-2 control-label mylabStyle">丢失时间</label>
									<div class="input-group date form_datetime col-md-5"
										data-date="2016-01-01T05:25:07Z"
										data-date-format="yyyy-MM-dd HH:mm:ss"
										style="margin-left:105px;width:280px;"
										data-link-field="dtp_input2">
										<input class="form-control" name="losingTime" size="16" type="text" value=""
											placeholder="请选择丢失的时间" readonly> <span
											class="input-group-addon"><span
											class="glyphicon glyphicon-remove"></span></span> <span
											class="input-group-addon"><span
											class="glyphicon glyphicon-th"></span></span>
									</div>
									<input type="hidden" id="dtp_input2" value="" /> <br />
								</div>
								<br/>
								<div class="form-group">
									<label for="CategoryId" class="col-sm-2 control-label mylabStyle">物品种类</label>
									<div class="col-sm-10">
										<select class="form-control categoryList" id="CategoryId"
											name="items.itemsCategory.categoryId">
											<option value="">--请选择物品的种类--</option>
										</select>
									</div>
								</div>
								<br /> <br />
								<div class="form-group">
									<label for="ItemDescribtion" class="col-sm-2 control-label mylabStyle">物品描述</label>
									<div class="col-sm-10">
										<textarea class="form-control" id="ItemDescribtion"
											name="items.itemsDescribtion" placeholder="请输入物品的描述"></textarea>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<!--<button type="button" data-dismiss="modal" class="btn btn-default">关闭</button>-->
						<button type="button" id="btnClose" class="btn btn-default"
							data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary">提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
