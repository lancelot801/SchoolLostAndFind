<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>徐州工程学院校园失物招领后台管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="bootstrap-3.3.5/dist/css/bootstrap.min.css" />
    <script type="text/javascript"
	        src="bootstrap-3.3.5/js/tests/vendor/jquery.min.js"></script>
	<script src="bootstrap-3.3.5/dist/js/bootstrap.min.js">
    </script>
	<script type="text/javascript" src="js/jquery-ui.min.js">
    </script>
		<style>
          .footingul li {
	       float: left;
	       padding: 10px;
           }
		</style>
		<script>
		$(function(){
			$("#returnIndex").click(function(){
				window.location.href="index.jsp";
			});
		});
	</script>
	</head>
  
  <body>
    <div class="container" style="overflow:hidden;">
		<div class="row" style="height:150px;">
			<div class="col-md-1"></div>
			<div class="col-md-10"
				style="height:150px;background-image:url(img/heading.jpg);background-size:100% 100%;background-repeat: no-repeat;">
				<h3>
					<label class="label label-success">&nbsp;徐州工程学院校园失物招领后台管理&nbsp;</label>
				</h3>
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="well well-sm">
					<ul class="nav nav-pills webdirection" >
					    <li role="presentation" class="active"><a href="" id="returnIndex" style="display:block;" target="content"><span class="glyphicon glyphicon-home"></span>&nbsp;首页</a></li>
						<li role="presentation"><a href="Admin/CheckPublishing.jsp" target="content"><span class="glyphicon glyphicon-check"></span>&nbsp;审核失物申请</a></li>
						<li role="presentation"><a href="Admin/CheckFinding.jsp" target="content"><span class="glyphicon glyphicon-check"></span>&nbsp;审核捡拾提交</a></li>
						<li role="presentation"><a href="Admin/Claim.jsp" target="content"><span class="glyphicon glyphicon-thumbs-up"></span>&nbsp;失物者认领</a></li>
						<li role="presentation"><a href="Admin/PublishingAd.jsp" target="content"><span class="glyphicon glyphicon-thumbs-up"></span>&nbsp;发布公告</a></li>
						<li role="presentation"><a href="Location.jsp" target="content"><span class="glyphicon glyphicon-hand-right"></span>&nbsp;校园招领点</a></li>						
					</ul>
				</div>
				<div class="panel panel-default">
					<div class="panel-body" style="height:750px;">
						<iframe src="Admin/CheckPublishing.jsp" width="100%" height="100%" border="none"
							frameborder="0" name="content" id="content2"></iframe>
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
  </body>
</html>
