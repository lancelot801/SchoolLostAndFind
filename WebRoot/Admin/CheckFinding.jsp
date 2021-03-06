<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>审核捡拾提交</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="bootstrap-3.3.5/dist/css/bootstrap.css" />
	<script type="text/javascript"
	src="bootstrap-3.3.5/js/tests/vendor/jquery.min.js"></script>
	<script src="bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
   <script type="text/javascript" src="js/checkFind.js"></script>
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
					<li>当前的位置</li>					
					<li><a href="CheckFinding.jsp">审核捡拾提交</a></li>
				</ol>
			</div>
		</div>
		<div class="row">
			<div class="col-md-pull-12">
				<div class="row featurette">
					<div class="panel panel-primary">
						<div class="panel-heading">
							&nbsp;&nbsp;<span class="glyphicon glyphicon-bookmark">&nbsp;捡拾提交列表</span>
						</div>
						<br/>
						<br/>
						<div class="panel-body">
						<!--
                                	 主要内容
                                -->
							<table class="table table-bordered table-hover table-striped" style="font-size:13px;">
								<thead>
									<tr>
										<th class="text-primary">捡拾编号</th>
										<th class="text-primary">捡拾时间</th>
										<th class="text-primary">捡拾物品名称</th>
										<th class="text-primary">操作</th>
									</tr>
								</thead>
								<tbody id="loadingData1">
									 <!-- 加载内容 -->									
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
	
	<!-- 模态框（Modal） -->
	<div class="modal  fade" id="mycheckfinding">
		<div class="modal-dialog">
			<div class="modal-content" style="background-color：#ffffff;">
			<form action="passValidatePick.action" method="post">
				<div class="modal-header">
					<button class="close" data-dismiss="modal" type="button">&times;</button>
					<h4 class="modal-title">
						<label class="label label-primary"><span
							class="glyphicon glyphicon-check">&nbsp;&nbsp;审核捡拾提交</span></label>
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
											物品的编号
										</label>
									</td>
									<td>
										<input type="text" id="itemsId" name="items.itemsId"/>
									</td>
								</tr>
							<tr>
							   <td><label >捡拾者姓名</label></td>
							   <td><input id="picker" type="text" value=""></td>
					         </tr>
                             <tr>
							   <td><label >捡拾者电话</label></td>
							   <td><input  id="pickphone" type="text" value=""></td>
					         </tr>
					         <tr>
							   <td><label >捡拾地点</label></td>
							   <td><input  id="picklocation" type="text" value=""></td>
					         </tr>
						
						</table>
					</div>
				<br /> <br />
				<div class="modal-footer">
				
					<button type="submit" class="btn btn-info">
					通过审核</button>
			
				    
				</div>
				</form>
			</div>
		</div>
	</div>
  </body>
</html>
