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

		<title>失物者认领</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
        <link rel="stylesheet" href="bootstrap-3.3.5/dist/css/bootstrap.css" />
		<script type="text/javascript"
		src="bootstrap-3.3.5/js/tests/vendor/jquery.min.js"></script>
		<script src="bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/Claim.js"></script>
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
							<a href="Admin/Claim.jsp">失物者认领</a>
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
								<span class="glyphicon glyphicon-bookmark">&nbsp;失物认领列表</span>
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
										<th class="text-primary">捡拾时间</th>
										<th class="text-primary">操作</th>
									</tr>
								</thead>
								<tbody id="findingResults">
									 <!-- 加载内容 -->									
								</tbody>
							</table>
								
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
		
<!-- 模态框（Modal） -->
	<div class="modal  fade" id="claim">
		<div class="modal-dialog">
			<div class="modal-content" style="background-color：#ffffff;">
			<form action="CClaim.action" method="post">
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
						<div class="tab-pane" id="tab-updatePassword">
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
											<td><label>捡拾者</label></td>
											<td><input class="form-control" id="picker" type="text" value=""></td>
										</tr>
										
										<tr>
											<td><label>捡拾者联系方式</label></td>
											<td><input class="form-control" id="pickerphone" type="text" value=""></td>
										</tr>
										<tr>
											<td><label>捡拾地点</label></td>
											<td><input class="form-control" id="plocation" type="text" value=""></td>
										</tr>
										<tr>
										<td colspan="2" style="height:50px"></td>
										</tr>
										
							            <tr>
							              <td colspan="2" style="vertical-align:middle; text-align:center;font-size:18px">认领者</td>
							            </tr>
							            <tr></tr>
										
										<tr>
											<td><label>学号</label></td>
											<td><input id="accountId" class="form-control" type="text" value="" name="account.userId"><button type="button" class="btn btn-primary" id="searchStuInfo">查询</button></td>
										</tr>
										<tr>
											<td><label>姓名</label></td>
											<td><input class="form-control" type="text" value="" id="finderName"></td>
										</tr>
										<tr>
											<td><label>联系方式</label></td>
											<td><input class="form-control" type="text" value="" id="finderPhone"></td>
										</tr>	
										<tr>
											<td><label>详细地址</label></td>
											<td><input class="form-control" type="text" value="" id="finderAddress"></td>
										</tr>										 										
									</table>
								</div>
					</div>
				<br /> <br />
				<div class="modal-footer">
				
					<button type="submit" class="btn btn-info">
					认领</button>
			
				    
				</div>
				</form>
			</div>
		</div>
	</div>
	</body>
</html>
