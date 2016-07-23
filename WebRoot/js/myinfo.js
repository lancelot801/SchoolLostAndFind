$(function(){
	
		var accountId = $("#accountId").val();
		$.ajax({
			url : "findUserDetail.action?accountId="+accountId,
			type : "post",
			async : false,
			dataType : "json",
			success : function(data) {
				//赋值
				$("#userName").val(data.UserName);
				$("#userPhone").val(data.PhoneNumber);
				$("#userDetail").val(data.DetailAddress);
				$("#userGener").val(data.Gender);
				$("#userEmail").val(data.Email);				
				$("#userDetailId").val(data.UserInfoId);
			},
			error : function(error) {
				alert(err.responseText);
			}
		});
		
})