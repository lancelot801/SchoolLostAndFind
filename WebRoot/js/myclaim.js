$(document).ready(function(){
	
	$.getJSON("findAllByUsrId.action?userId="+$("#theuserId").val(), function(json) {
		var tr;
		$("#loaddata").empty();
		$.each(json,function(index, stock) {
			tr+="<tr>";
			tr+="<td>" + stock.ItemsName + "</td>";
			tr+="<td>" + convert(stock.GetTime.toString()) + "</td>";
			tr+="<td>" + stock.ItemDescribtion + "</td>";
			//tr+="<td><button class='btn btn-primary'>查看详情</button></td>";
			tr+="</tr>";
			});
		$("#loaddata").append(tr);
	});
	//加载时间戳
	function convert(Time) {        
        var timeString = "";
        timeString = Time.replace("/Date(", "").replace(")/", "").trim();
        var quit = timeString.substring(7, 10);
        timeString = timeString.replace(quit, "");
        return new Date(parseInt(timeString) * 1000).toLocaleString();
    }
});

