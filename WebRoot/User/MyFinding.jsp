<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyFinding.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="bootstrap-3.3.5/dist/css/bootstrap.css" />
	<script type="text/javascript"
	src="bootstrap-3.3.5/js/tests/vendor/jquery.min.js"></script>
	<script src="bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
     <script type="text/javascript" src="js/myfind.js"></script>
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
							<a href="User/MyInfo.jsp">我的捡拾</a>
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
								<span class="glyphicon glyphicon-bookmark">&nbsp;我的捡拾列表</span>
							</div>
							<div class="panel-body" style="height: 690px;">
								
							<table class="table table-bordered table-hover table-striped" style="font-size:13px;">
								<input  class="myHidden" type="text" value="${sessionScope.userId}" id="theuserId">
								<thead>
									<tr>
										<th class="text-primary">名称</th>
										<th class="text-primary">捡拾地点</th>
										<th class="text-primary">捡拾时间</th>
										<th class="text-primary">描述</th>
										<th class="text-primary">操作</th>
									</tr>
								</thead>
								<tbody id="loadindData">
									
								</tbody>
							</table>
									</div>
								</div>
						
							</div>
						</div>
					</div>

				</div>

		<!-- 模态框（Modal） -->
	<div class="modal  fade" id="query">
		<div class="modal-dialog">
			<div class="modal-content" style="background-color：#ffffff;">
				<div class="modal-header">
					<button class="close" data-dismiss="modal" type="button">&times;</button>
					<h4 class="modal-title">
						<label class="label label-primary"><span
							class="glyphicon glyphicon-bookmark">&nbsp;&nbsp;我的捡拾</span></label>
					</h4>
				</div>
				<div class="modal-body">
					<br /> 
					<br />
						<table class="table table-bordered table-hover table-striped" style="font-size: 13px;">
							<tr>
							   <td><label >物品名称</label></td>
							   <td><input type="text" class="form-control"  value=""></td>
					         </tr>
                             <tr>
							   <td><label >捡拾地点</label></td>
							   <td><input type="text" class="form-control"  value=""></td>
					         </tr>
					         <tr>
							   <td><label >捡拾时间</label></td>
							   <td><input type="text" class="form-control" value=""></td>
					         </tr>
					         <tr>
							   <td><label >描述</label></td>
							   <td><input type="text" class="form-control" value=""></td>
					         </tr>
						</table>
					</div>
				
				<div class="modal-footer">
				    
				</div>
			</div>
		</div>
	</div>
  </body>
</html>
