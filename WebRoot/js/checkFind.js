$(function(){
     //加载数据
	pickva();
	//查询所有待审核的捡拾信息
	function pickva(){
		var $container = $("#loadingData1");//货物到容器
		var result = "";
		$.ajax({
			url:"findVaFind.action",
			type:"post",
			dataType:"json",
			success:function(data){
				var len = data.length;			 				 
				for(var i = 0;i<len;i++){
					result += "<tr>" +
					"<td>"+data[i].PickingId+"</td>" +
					"<td>"+convert(data[i].PickTime.toString())+"</td>" +
					"<td>"+data[i].ItemsName+"</td>" +
					"<td><button class='btn btn-primary checkPickBtn'><span class='glyphicon glyphicon-check'></span>审核</button></td>" +
					"<td class='myHidden'>"+data[i].Picker+"</td>" +
					"<td class='myHidden'>"+data[i].PickPhone+"</td>" +
					"<td class='myHidden'>"+data[i].PickLocation+"</td>" +
					"<td class='myHidden'>"+data[i].ItemsId+"</td></tr>";
				}	
				$container.append(result);
				//绑定审核事件
				$(".checkPickBtn").bind("click",function(){
					 $("#mycheckfinding").modal();
					 var $f = $(this).parent().parent().find("td");					 
					 $("#picker").val($f.eq(4).html());					 
					 $("#pickphone").val($f.eq(5).html());
					 $("#picklocation").val($f.eq(6).html());
					  $("#itemsId").val($f.eq(7).html());
				});
			},
			error:function(err){
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
});