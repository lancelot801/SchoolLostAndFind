$(function() {

	//加载页面
	load();
	
	/**
	 * 提取URL中的参数
	 */
	function getUrlArgs() {
		//定义一个数组，用于存放取出来的字符串参数。
		var argsArr = new Object();
		//获取URL中的查询字符串参数
		var query = window.location.search;
		query = query.substring(1);
		//这里的pairs是一个字符串数组
		var pairs = query.split("&");
		for (var i = 0; i < pairs.length; i++) {
			var sign = pairs[i].indexOf("=");
			//如果没有找到=号，那么就跳过，跳到下一个字符串（下一个循环）。
			if (sign == -1) {
				continue;
			}
			var aKey = pairs[i].substring(0, sign);
			var aValue = pairs[i].substring(sign + 1);
			argsArr[aKey] = aValue;
		}
		return argsArr;
	}

	//加载页面的内容
	function load() {
		var obj = new Object();
		obj = getUrlArgs();
		var type = obj["type"].toString().trim();
		var $items;		 
		if (type == "1") {			
			$items = $("<li><a href='Publishing.jsp'>招领信息</a></li><li><a>招领信息详情</a></li>");			 
			$("#pickingTable").show();
			$("#findingTable").hide();
			loadPickingInfo();
		} else {
			$items = $("<li><a href='Finding.jsp'>寻物信息</a></li><li><a>寻物信息详情</a></li>");			
			$("#pickingTable").hide();
			$("#findingTable").show();
			loadFindInfo();
		}
		$("#leading").append($items);
	}
	
	//加载搜寻的信息
	function loadFindInfo(){
		var obj = getUrlArgs();
		var id = obj["id"].toString().trim();	 
		$.ajax({
			url:"findFindgDetail.action?theLosingId="+id,			 
			type:"post",
			async:false,
			contentType:"JSON",
			success:function(data){
				var obj = JSON.parse(data);		
				$("#itemsName").html(obj.ItemsName);
				$("#describtion").val(obj.ItemDescribtion);
				$("#category").html(obj.CategoryName);
				$("#finder").html(obj.Finder);
				$("#losingTime").html(convert(obj.LosingTime.toString()));
				$("#finderPhoneNumber").html(obj.PhoneNumber);
				$("#finderEmail").html(obj.Email);
			},
			error:function(err){
				alert(err.responseText);
			}
		});
	}
	
	//加载捡拾信息
	function loadPickingInfo(){
		var obj = getUrlArgs();
		var id = obj["id"].toString().trim();	 
		$.ajax({
			url:"findPickingDetail.action?thePickingId="+id,			 
			type:"post",
			async:false,
			contentType:"JSON",
			success:function(data){					 			 
				var obj = JSON.parse(data);				 
				//加载捡拾信息
				$("#itemsName").html(obj.ItemsName);
				$("#describtion").val(obj.ItemDescribtion);
				$("#category").html(obj.CategoryName);
				$("#picker").html(obj.Picker);
				$("#pickTime").html(convert(obj.PickTime.toString()));
				$("#pickingLocation").html(obj.PickLocation);
				$("#phoneNumber").html(obj.PickPhone);
			},
			error:function(err){
				alert(err.responseText);
			}
		});
	}
	
	//将时间戳转化为标准时间     
	function convert(Time) {        
        var timeString = "";
        timeString = Time.replace("/Date(", "").replace(")/", "").trim();
        var quit = timeString.substring(7, 10);
        timeString = timeString.replace(quit, "");
        return new Date(parseInt(timeString) * 1000).toLocaleString();
    }

});