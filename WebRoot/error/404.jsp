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

		<title>My JSP '404.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript" src="bootstrap-3.3.5/js/tests/vendor/jquery.min.js">
         </script>
		<script src="bootstrap-3.3.5/dist/js/bootstrap.min.js">
        </script>
		<script type="text/javascript" src="js/jquery-ui.min.js"></script>

</head>
  
  <body>
     <div class="panel panel-primary">
     	<div class="panel panel-body">
     		<h1>错误：404，您找的页面不存在！</h1>
     	</div>
     </div>
  </body>
</html>
