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

		<title>My JSP 'Direction.jsp' starting page</title>

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
		<style>
* {
	font-size: "微软雅黑";
}
</style>
	</head>

	<body>
		<div class="container-fluid" style="overflow-x: hidden;">
			<div class="row">
				<div class="col-md-pull-12">
					<ol class="breadcrumb">
						<li>
							当前的位置
						</li>
						<li>
							<a href="main.jsp">首页</a>
						</li>
						<li>
							<a href="Direction.jsp">使用指南</a>
						</li>
					</ol>
				</div>
			</div>
			<div class="row">
				<div class="row featurette">
					<div class="panel panel-primary">
						<div class="panel-heading">
							&nbsp;&nbsp;
							<span class="glyphicon glyphicon-bookmark"></span>&nbsp;本站使用指南
						</div>
						<div class="panel-body">
							<ul style="padding: 30px;">
								<li>
									一、如果您在校园内拾得他人遗失的物品，可登录失物招领平台，自行发布失物招领信息，寻找失主，也可以送交到失物招领点，填写《失物领取（交公）记录》，做好登记，工作人员会保管相关物品并将信息在失物招领平台发布。
								</li>
								<li>
									二、如果您有遗失物品在查找无果后，可自行登录失物招领信息平台查看有无您正寻找的物品招领信息，并按信息提示寻找失物。如果没有，可以自行发布寻物信息。
								</li>
								<li>
									三、遗失物品领取时，凭学生证、身份证、校园卡等有效证件。代他人领取的，还须出示失主的委托书、失主身份证件。领取失物时，需填写《失物领取（交公）记录》。
								</li>
								<li>
									四、后勤集团将定期统计网上信息发布数量及切实帮助师生找到失物的情况，并据此对拾金不昧的师生进行表彰。
								</li>
								<li>
									五、失物招领信息平台面向全校师生进行开放，根据数字化校园平台的师大通行证进行实行实名注册、登陆，让公益以最广、最快的形式进行传播。
									拾金不昧是中华民族的传统美德，希望广大师生充分利用这个平台，发扬拾金不昧的优秀品质，自助助人。也希望通过我们的努力，能够切实加强师生管理自身财产安全的意识，营造良好的学习与生活环境，构建和谐、温馨校园。
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
