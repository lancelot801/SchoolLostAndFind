$(document).ready(function(){
	
	$.getJSON("findAllLosingItemsByUsrId.action?userId="+$("#theuserId").val(), function(json) {
		var tr;
		$("#datalist").empty();
		$.each(json,function(index, stock) {
			tr+="<tr>";
			tr+="<td>" + stock.ItemsName + "</td>";
			tr+="<td>" + convert(stock.LosingTime.toString()) + "</td>";
			tr+="<td>" + stock.ItemDescribtion + "</td>";
			tr+="</tr>";
			});
		$("#datalist").append(tr);
	});
	
	function convert(Time) {        
        var timeString = "";
        timeString = Time.replace("/Date(", "").replace(")/", "").trim();
        var quit = timeString.substring(7, 10);
        timeString = timeString.replace(quit, "");
        return new Date(parseInt(timeString) * 1000).toLocaleString();
    }
});

