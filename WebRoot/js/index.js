$(function() {
  	 	
	//加载页面
	isLogined();
	
	
	//获取session的值
	function getSession(key){
		var value = "";
		$.ajax({
			url:"getSession.action",			 	
			type:"post",
			data:"key="+key,
			success:function(data){					
				value = data;			 
			},
			error:function(err){
				alert(err.responseText);
			},
			async:false
		});
		return value;
	}
	
	//清空session
	function clearSession(key){
		var flag = 0;
		$.ajax({
			url:"clearSession.action",			 	
			type:"post",
			data:"key="+key,
			success:function(data){					 
				if(data.trim() == "success"){
					flag = 1;
				}		 
			},
			error:function(err){
				alert(err.responseText);
			},
			async:false
		});
		return flag;
	}
	
	
	$("ul.webdirection li").click(function() {
		var index = $(this).index();
		switch (index) {
			case 0: //首页
				$("#content").attr("src", "main.jsp");
				break;
			case 1: //招领信息
				$("#content").attr("src", "Publishing.jsp");
				break;
			case 2: //寻物信息
				$("#content").attr("src", "Finding.jsp");
				break;
			case 3: //校园招领点
				$("#content").attr("src", "Location.jsp");
				break;
			case 4: //使用指南
				$("#content").attr("src", "Direction.jsp");
				break;
			default:
				break;
		}
	});

	//登录
	$("#userlogin").click(function() {
		$("#mylogin").modal().draggable({
			handle: ".modal-header",
			cursor: 'move',
			refreshPositions: false
		});
	});
	
	//注册用户
	$("#registAccount").click(function(){
		$("#content").attr("src", "Regist.jsp");
	});
	 
	//加载页面的时候是否要让用户登录
	function isLogined(){
		var $loginBtn = $("#userlogin");
		var userName = getSession("userName");
		if(userName.trim() == "暂时没有登录"){
			$("#userIdlogin").html("立即登录");
		}else{
			$("#userIdlogin").html("当前用户为："+userName);
			$loginBtn.attr("disabled",true);
			$("#userloginout").show();
			$("#userMain").show();
		}
	}
	
	//注销用户登录
	$("#userloginout").click(function(){
		if(confirm("你确定要注销账户登录吗？")){
			var f = clearSession("userId");
			var t = clearSession("userName");
			if(f+t == 2){
				alert("注销成功！");
				window.location.href="index.jsp";
			}else{
				alert("服务器繁忙，注销失败！");
			}
		}		
	});
	
	//进入个人中心
	$("#userMain").click(function(){
		window.location.href="User/User.jsp";
	});
	
	//验证登录表单
    $("#loinForm").bootstrapValidator({	 
		message : "请输入有效的字段",
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			"userId":{
				validators : {
					notEmpty : {
						message : "用户的账号不能为空！",
					}
				}
			},
			"password":{
				validators:{
					notEmpty:{
						message:"用户的密码不能为空！",
					}
				}
			}
		}
	});

});