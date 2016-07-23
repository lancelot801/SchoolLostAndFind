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

	// 加载所有数据
	function loadData() {
		var $container = $("#loadingResult");
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
					result += "<tr><td>" + data[i].CategoryName + "</td>"
							+ "<td>" + data[i].ItemsName + "</td>" + "<td>"
							+ data[i].PickLocation + "</td>" + "<td>"
							+ convert(data[i].PickTime.toString()) + "</td>" + "<td>"
							+ data[i].ItemDescribtion + "</td>"
							+ "<td><a href='ItemsDetail.jsp?type=1&id="
							+ data[i].PickingId + "'>查看详情</a></td></tr>";
				}
				$container.append(result);
			},
			error : function(err) {
				alert(err.responseText);
			}
		});
	}

	// 将时间戳转化为标准时间
	function convert(Time) {
		var timeString = "";
		timeString = Time.replace("/Date(", "").replace(")/", "").trim();
		var quit = timeString.substring(7, 10);
		timeString = timeString.replace(quit, "");
		return new Date(parseInt(timeString) * 1000).toLocaleString();
	}
	
	//按照类别加载数据
	function loadByCategory(category){
		var $container = $("#loadingResult");		 
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
					result += "<tr><td>" + data[i].CategoryName + "</td>"
					+ "<td>" + data[i].ItemsName + "</td>" + "<td>"
					+ data[i].PickLocation + "</td>" + "<td>"
					+ convert(data[i].PickTime.toString()) + "</td>" + "<td>"
					+ data[i].ItemDescribtion + "</td>"
							+ "<td><a href='ItemsDetail.jsp?type=1&id="
					+ data[i].PickingId + "'>查看详情</a></td></tr>";
				}
				$container.append(result);
			},
			error : function(error) {
				alert(err.responseText);
			}
		});
	}
	
	//按照类别
	$("#itemsCategory").change(function(){
		var category = $(this).val(); 
		loadByCategory(category);
	});

});