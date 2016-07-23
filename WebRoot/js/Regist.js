$(function() {
 
	// 重置
	$("#resetUser").click(function(e) {
		e.preventDefault(); 
		$('#regist').data('bootstrapValidator').resetForm(true);
	});

	// 验证表单
	$("#regist").bootstrapValidator({	 
		message : "请输入有效的字段",
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},	 		 
		fields : {
			"userId.userId" : {
				message : "一卡通不合法",
				validators : {
					notEmpty : {
						message : '一卡通号不能为空'
					},
					stringLength : {
						max : 11,
						message : '一卡通只能是11位'
					}
				}
			},
			"userId.password" : {
				validators : {
					notEmpty : {
						message : '密码不能为空'
					},
					identical : {
						field : 'surePassword',
						message : '密码和确认密码不一致'
					},
					different : {
						field : 'userId.userId',
						message : '密码不能和用户的账号一致'
					}
				}
			},
			"surePassword" : {
				validators : {
					notEmpty : {
						message : '确认密码不能为空'
					},
					identical : {
						field : 'userId.password',
						message : '密码和确认密码不一致'
					}
				}
			},
			"userName" : {
				validators : {
					notEmpty : {
						message : "用户的名称不能为空",
					}
				}
			},
			"gender":{
				validators:{
					notEmpty:{
						message:"性别不能为空"
					}
				}
			},
			"email":{
				validators:{
					notEmpty:{
						message:"邮箱不能为空"
					},
					emailAddress:{
						message:"邮箱地址有误"
					}
				}
			},
			"phoneNumber":{
				validators:{
					notEmpty:{
						message:"手机号码不能为空"
					},
					regexp:{
						regexp:/^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/,
						message:"手机号码输入有误"
					}
				}
			},
			"detailAddress":{
				validators:{
					notEmpty:{
						message:"地址填写不能为空"
					}
				}
			}
		}
	});
});