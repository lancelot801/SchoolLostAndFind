$(function() {

	// 加载类别
	loadCategory();
	// 加载初始信息
	loadPickingInfo();
	loadfindingInfo();
	loadWebNews();

	// 查看领取地点
	$("#seeGetLocation").click(function() {
		window.location.href = "Location.jsp";
	});

	// 标记
	var flag = 0;

	// 定位到要加载那种列表
	$("#feature-tab li").click(function() {
		flag = $(this).index();
	});

	// 更多消息
	$("#moreInfo").click(function() {
		if (flag == 0) {
			window.location.href = "Publishing.jsp";
		} else {
			window.location.href = "Finding.jsp";
		}
	});

	// 捡拾物品
	$("#btnPicking").click(function() {
		$("#myPickingModal").modal().draggable({
			handle : ".modal-header",
			cursor : 'move',
			refreshPositions : false
		});
	});

	// 寻找物品
	$("#btnFinding").click(function() {
		$("#myFindingModal").modal().draggable({
			handle : ".modal-header",
			cursor : 'move',
			refreshPositions : false
		});
	});

	// 时间
	$('.form_datetime').datetimepicker({
		language : 'zh-CN',
		format : "yyyy-mm-dd hh:mm:ss", // 选择日期后，文本框显示的日期格式
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		forceParse : 0,
		showMeridian : 1
	});

	// 加载类别
	function loadCategory() {
		var $container = $("select.categoryList");
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

	// 验证输入框
	$("#myPicking").bootstrapValidator({
		message : "请输入有效的字段",
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			"items.itemsName" : {
				validators : {
					notEmpty : {
						message : '物品的名字不能为空'
					}
				}
			},
			"items.itemsDescribtion" : {
				validators : {
					notEmpty : {
						message : '请添加物品的描述'
					}
				}
			}
		}
	});

	// 验证搜寻物品的信息
	$("#myFinding").bootstrapValidator({
		message : "请输入有效的字段",
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			"items.itemsName" : {
				validators : {
					notEmpty : {
						message : '物品的名称不能为空'
					}
				}
			},
			"items.itemsDescribtion" : {
				validators : {
					notEmpty : {
						message : '物品的描述不能为空'
					}
				}
			}
		}
	});

	// 加载发布的信息
	function loadPickingInfo() {
		var $container = $("#pickingResultUL");
		var result = "";
		$.ajax({
					async : false,
					url : "pickingTop.action",
					type : "post",
					contentType : "JSON",
					success : function(data) {
						var ob = JSON.parse(data);
						var len = ob.length;
						for (var i = 0; i < len; i++) {
							result += "<li><span class='glyphicon glyphicon-volume-up'></span><a "
									+ "href='ItemsDetail.jsp?type=1&id="
									+ ob[i].PickingId
									+ "'>&nbsp;<label class='publishingName'>"
									+ ob[i].ItemsName
									+ "</label>&nbsp;被捡到了，快来领取！"
									+ "</a><span class='spanTime'>"
									+ convert(ob[i].PickTime.toString())
									+ "</span></li>";
						}
						$container.append(result);
					},
					error : function(err) {
						alert(err.responseText);
					}
				});
	}

	// 加载寻找的信息
	function loadfindingInfo() {
		var $container = $("#findingResultUL");
		var result = "";
		$.ajax({
					async : false,
					url : "findingTop.action",
					type : "post",
					success : function(data) {
						var ob = JSON.parse(data);
						var len = ob.length;
						for (var i = 0; i < len; i++) {
							result += "<li><span class='glyphicon glyphicon-volume-up'></span><a "
									+ "href='ItemsDetail.jsp?type=2&id="
									+ ob[i].LosingId
									+ "'>&nbsp;<label class='publishingName'>"
									+ ob[i].ItemsName
									+ "</label>&nbsp;丢了，大家有看到的吗？"
									+ "</a><span class='spanTime'>"
									+ convert(ob[i].LosingTime.toString())
									+ "</span></li>";
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

	// 加载网站公告
	function loadWebNews() {
		var $contianer = $("#newsPart");
		var result = "";
		$.ajax({
			async : false,
			url : "findNews.action",
			type : "post",
			success : function(data) {	
				var obj = JSON.parse(data);
				var len = obj.length;						 
				for (var i = 0; i < len; i++) {								 
						result += "<tr><td>"+obj[i].Content+"<td>"+convert(obj[i].PublishingTime.toString())+"</td></tr>";
				}
				$contianer.append(result);
			},
			error : function(err) {
				alert(err.responseText);
			}
		});
	}

});