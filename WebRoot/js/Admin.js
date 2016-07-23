$(function(){

	//加载数据
	findva();
	
	//查询所有待审核的丢失信息
	function findva(){
		var $container = $("#loadingData");//货物到容器
		var result = "";
		$.ajax({
			url:"findVaLosing.action",
			type:"post",
			dataType:"json",
			success:function(data){
				var len = data.length;			 				 
				for(var i = 0;i<len;i++){
					result += "<tr>" +
					"<td>"+data[i].LosingId+"</td>" +
					"<td>"+convert(data[i].LosingTime.toString())+"</td>" +
					"<td>"+data[i].ItemsName+"</td>" +
					"<td><button class='btn btn-primary checkingBtn'><span class='glyphicon glyphicon-check'></span>审核</button></td>" +
					"<td class='myHidden'>"+data[i].Finder+"</td>" +
					"<td class='myHidden'>"+data[i].ItemDescribtion+"</td>" +
					"<td class='myHidden'>"+data[i].ItemsId+"</td></tr>";
				}	
				$container.append(result);
				//绑定审核事件
				$(".checkingBtn").bind("click",function(){
					 $("#mycheckpublishing").modal();
					 var $f = $(this).parent().parent().find("td");					 
					 $("#finder").val($f.eq(4).html());					 
					 $("#describtion").val($f.eq(5).html());
					 $("#itemsId").val($f.eq(6).html());
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