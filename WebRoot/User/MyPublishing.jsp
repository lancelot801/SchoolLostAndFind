<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的丢失</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="bootstrap-3.3.5/dist/css/bootstrap.css" />
	<script type="text/javascript"
	src="bootstrap-3.3.5/js/tests/vendor/jquery.min.js"></script>
	<script src="bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
   <script type="text/javascript" src="js/mypub.js"></script>
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
							<a href="User/MyPublishing.jsp">我的丢失</a>
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
								<span class="glyphicon glyphicon-bookmark">&nbsp;我的丢失列表</span>
							</div>
							<div class="panel-body" style="height: 690px;">
								
								<table class="table table-bordered table-hover table-striped" style="font-size:13px;">
								<thead>
								<input  class="myHidden" type="text" value="${sessionScope.userId}" id="theuserId">
									<tr>
										<th class="text-primary">名称</th>
										<th class="text-primary">丢失时间</th>
										<th class="text-primary">描述</th>
									</tr>
								</thead>
								<!-- 加载数据 -->
								<tbody id="datalist">
									
									
								</tbody>
							</table>
									</div>
								</div>
						
							</div>
						</div>
					</div>

				</div>
  </body>
</html>
