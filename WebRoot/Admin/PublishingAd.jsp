<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>发布公告</title>
    
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
    <div class="container-fluid" style="overflow: hidden;">
		<div class="row">
			<div class="col-md-pull-12">
				<ol class="breadcrumb">
					<li>当前的位置</li>					
					<li><a href="Admin/PublishingAd.jsp">发布公告</a></li>
				</ol>
			</div>
		</div>
		<div class="row">
			<div class="col-md-pull-12">
				<div class="row featurette">
					<div class="panel panel-primary">
						<div class="panel-heading">
							&nbsp;&nbsp;<span class="glyphicon glyphicon-bookmark">&nbsp;发布公告</span>
						</div>
						<form action="addWAd.action" method="post">
						<div class="panel-body">
							<table class="table table-bordered table-hover table-striped" style="font-size:13px;">
								<tr>
								<td><label >标题</label></td>
								<td><input  type="text" value="" name="Title"></td>
								</tr>
								<tr>
								<td><label >内容</label></td>
								<td><input  type="text" value="" name="Content" ></td>
								</tr>
								<tr>
								<tr>
								<td><label >发布者</label></td>
								<td><input  type="text" value="admin" name="account.userId"></td>
								</tr>
								<td colspan="2"><button type="submit" class="btn btn-primary">发布</button></td>
								</tr>
							</table>
						</div>
						 </form>
					</div>
				</div>
			</div>
		</div>
	</div>
  </body>
</html>
