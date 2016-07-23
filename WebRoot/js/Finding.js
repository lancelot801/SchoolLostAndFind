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
			url : "findAllLosingItems.action",
			type : "post",
			async : false,
			dataType : "json",
			success : function(data) {
				$container.empty();
  			    var len = data.length;  			   
				for (var i = 0; i < len; i++) {
					result +="<tr><td>"+data[i].CategoryName+"</td>"+
					"<td style='color:darkred;'>"+data[i].ItemsName+"</td>"+									 
					"<td style='color:blue;'>"+convert(data[i].LosingTime.toString())+"</td>"+
					"<td style='color:green;'>"+data[i].ItemDescribtion+"</td>"+
					"<td><a href='ItemsDetail.jsp?type=2&id="+data[i].LosingId+"' >查看详情</a></td></tr>";
				}
				$container.append(result);
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
			url : "findAllLosingItemsByCategory.action?thelosingCategory="+category,
			type : "post",
			async : false,
			dataType : "json",
			success : function(data) {
				$container.empty();
  			    var len = data.length;  			   
				for (var i = 0; i < len; i++) {
					result +="<tr><td>"+data[i].CategoryName+"</td>"+
										"<td style='color:darkred;'>"+data[i].ItemsName+"</td>"+									 
										"<td style='color:blue;'>"+convert(data[i].LosingTime.toString())+"</td>"+
										"<td style='color:green;'>"+data[i].ItemDescribtion+"</td>"+
										"<td><a href='ItemsDetail.jsp?type=2&id="+data[i].LosingId+"' >查看详情</a></td></tr>";
				}
				$container.append(result);
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

});