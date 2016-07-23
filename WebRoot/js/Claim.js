$(function() {
 
	loadCategory();
	loadData();
	
	// 加载类别
	function loadCategory() {
		var $container = $("#itemsCategory");		 
		var result = "";
		$.ajax({
			url : "getAllItemsCategory.action",
			type : "post",
			async : false,
			dataType : "json",
			success : function(data) {
				var len = data.length;
				for (var i = 0; i < len; i++) {
					result += "<option value='" + data[i].CategoryId + "'>"
							+ data[i].CategoryName + "</option>";
				}
				$container.append(result);
			},
			error : function(error) {
				alert(err.responseText);
			}
		});
	}
	
	//加载所有数据
	function loadData(){
		var $container = $("#findingResults");		 
		var result = "";
		$.ajax({
			url : "findAllPickingItems.action",
			type : "post",
			async : false,
			dataType : "json",
			success : function(data) {
				$container.empty();
  			    var len = data.length;  			   
				for (var i = 0; i < len; i++) {
					result += "<tr>" +
					"<td>" + data[i].CategoryName + "</td>"+
					"<td>" + data[i].ItemsName + "</td>" + 
					"<td>" + convert(data[i].PickTime.toString()) + "</td>" + 
					"<td><button class='btn btn-primary claimPickBtn'><span class='glyphicon glyphicon-thumbs-up'></span>认领</button></td>" +
					"<td class='myHidden'>" + data[i].Picker + "</td>" + 
					"<td class='myHidden'>" + data[i].PickPhone + "</td>" + 
					"<td class='myHidden'>" + data[i].PickLocation + "</td>" +
					"<td class='myHidden'>" + data[i].ItemsId + "</td></tr>";
				}
				$container.append(result);
				$(".claimPickBtn").bind("click",function(){
					 $("#claim").modal();
					 var $f = $(this).parent().parent().find("td");					 
					 $("#picker").val($f.eq(4).html());					 
					 $("#pickerphone").val($f.eq(5).html());
					 $("#plocation").val($f.eq(6).html());
					 $("#itemsId").val($f.eq(7).html());
				});
			},
			error : function(error) {
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
	
	//按照类别加载数据
	function loadByCategory(category){
		var $container = $("#findingResults");		 
		var result = "";
		$.ajax({
			url : "findAllPickingByCategory.action?myCategory="+category,
			type : "post",
			async : false,
			dataType : "json",
			success : function(data) {
				$container.empty();
  			    var len = data.length;  			   
				for (var i = 0; i < len; i++) {
					result += "<tr>" +
					"<td>" + data[i].CategoryName + "</td>"+
				    "<td>" + data[i].ItemsName + "</td>" + 
					"<td>"+convert(data[i].PickTime.toString()) + "</td>" + 
					"<td><button class='btn btn-primary claimPickBtn'><span class='glyphicon glyphicon-thumbs-up'></span>认领</button></td>" +
					"<td class='myHidden'>" + data[i].Picker + "</td>" + 
					"<td class='myHidden'>" + data[i].PickPhone + "</td>" + 
					"<td class='myHidden'>" + data[i].PickLocation + "</td>" +
					"<td class='myHidden'>" + data[i].ItemsId + "</td></tr>";
				}
				$container.append(result);
				$(".claimPickBtn").bind("click",function(){
					 $("#claim").modal();
					 var $f = $(this).parent().parent().find("td");					 
					 $("#picker").val($f.eq(4).html());					 
					 $("#pickerphone").val($f.eq(5).html());
					 $("#plocation").val($f.eq(6).html());
					 $("#itemsId").val($f.eq(7).html());
				});
			
			},
			error : function(error) {
				alert(err.responseText);
			}
		});
	}
	
	//筛选不同的类别
	$("#itemsCategory").change(function(){
		var category = $(this).val();
		loadByCategory(category);
	});
	
	
	//查询学生信息
	$("#searchStuInfo").click(function(){
		var accountId = $("#accountId").val();
		$.ajax({
			url : "findUserDetail.action?accountId="+accountId,
			type : "post",
			async : false,
			dataType : "json",
			success : function(data) {
				//赋值
				$("#finderName").val(data.UserName);
				$("#finderPhone").val(data.PhoneNumber);
				$("#finderAddress").val(data.DetailAddress);
			},
			error : function(error) {
				alert(err.responseText);
			}
		});
		
	});

});