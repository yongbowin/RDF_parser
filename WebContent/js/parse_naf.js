$(function(){
	$("#content_id").click(function(){
		//alert("点击事件");
		var textarea_txt = $("#textarea_id").val();
		//alert("textarea_txt:" + textarea_txt);
		//在replace中代替所有的%要用正则表达式
		var textarea_txt1 = textarea_txt.replace(/%/g, " ");
		
		$.ajax({
            url:"submit_txt",
            type:"post",
            data:"contentTxt=" + textarea_txt1,
            dataType:"json",
            success:function(json){
            	//alert("成功！");
                //alert(typeof(json));
                //alert(json[0].subject_str);
                //var labelValue = json.level_name;

                //$(".breadcrumb-1 .active").html("labelValue");
            	
            	//alert(json);
            	
            	//alert(typeof(json));
            	//alert("大小为：" + json.length);
            	var html = "";
            	for(var i=0; i<json.length; i++){
            		if(json[i].subject_str && json[i].predicate_str && json[i].object_str){
            			if(json[i].time_str){
		            		html += "<tr>" +
		            				"<td>" + json[i].subject_str + "</td>" +
		            				"<td>" + json[i].predicate_str + "</td>" +
		            				"<td>" + json[i].object_str + "</td>" +
		            				"<td>" + json[i].time_str + "</td>" +
		            				"</tr>";
            			} else {
            				html += "<tr>" +
		            				"<td>" + json[i].subject_str + "</td>" +
		            				"<td>" + json[i].predicate_str + "</td>" +
		            				"<td>" + json[i].object_str + "</td>" +
		            				"<td>" + " " + "</td>" +
		            				"</tr>";
            			}
            		}
            	}
            	//alert(html);
            	$(".table-responsive table tbody").html(html);
            	//$(".add-tuple").append(html);
				//动态刷新样式
				//$(".add-tuple").trigger("create");
            }
        });
		
	});
	
	//点击logo进行页面重定向
	$(".navbar-header").click(function(){
		//location.href="http://192.168.100.250:8098/home/";
		location.href="http://www.chaorder.cn";
	});
})