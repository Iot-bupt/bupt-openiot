$(function () {
	$("#device_input").keyup(function () {
		$("#device_table tbody tr").hide()
                .filter(":contains('"+($(this).val())+"')").show();//filter和contains共同来实现了这个功能。
            }).keyup();

	//加载表格数据
	$.ajax({
            type: "get",     //post
            url: "../../api/noauth/allDevices",     //url 后台会告诉你
            success:function (data) {   //如果成功获取
            	
                     
                  
                    for(var i = 0;i < data.length; i++){
                    	$('#device_table').append(
                    		'<tr>'+
                    		'<td>'+ data[i].name +'</td>'+
                    		'<td>'+ data[i].type +'</td>'+
                    		'<td>'+ data[i].additionalInfo +'</td>'+
                    		'<td>'+ data[i].createdTime +'</td>'+
                    		'<td>'+'<a>'+'编辑'+'</td>'+
                    		'<td>'+ '<aclass="btn btn-danger">'+'删除'+'</a>'+'<a class="btn btn-success">'+'控制'+'</a>'+'' +'</td>'+
                    		'</tr>'
                    		)
                    }

               
            },
            error: function(data){
            	
            }
        })
})



/*
$("#device_search").click(function(event) {
	 
	$("#device_input").val()

});



$(document).ready(function() {
	id = null?'"id":"",':'"id":"'+ 获取输入框的值 +'"';
           //可以有多个参数以逗号分开，如下
            var param = '{"seq":"",'+ id + '}';   //此seq为序列号，你的不一定有序列号
            console.log(param);     //此为console的一个数据显示，与功能无关
            //param=BASE64.encoder(param);
            var req = {"cmd":0x05,"param":param};  //提交参数，cmd后台会告诉
            $.ajax({
            type: "post",     //post
            url: "/user",     //url 后台会告诉你
            data: req,
            success:function (data,status) {   //如果成功获取
            	if(status == 'success'){
                    console.log(data);    //显示获取成功后返回的数据
                    var repair_contactlist = jQuery.parseJSON(data);  //数据转为json串
                    console.log(repair_contactlist);
                    for(var i = 0;i < repair_contactlist.data.length; i++){
                    	$('#device_table').append(
                    		'<tr>'+
                    		'<td>'+ repair_contactlist.data[i].equipno +'</td>'+
                    		'<td>'+ repair_contactlist.data[i].name +'</td>'+
                    		'<td>'+ repair_contactlist.data[i].name +'</td>'+
                    		'<td>'+ repair_contactlist.data[i].name +'</td>'+
                    		'<td>'+'<a>'+'编辑'+'</td>'+
                    		'<td>'+ '<aclass="btn btn-danger">'+'删除'+'</a>'+'<a class="btn btn-success">'+'控制'+'</a>'+'' +'</td>'+
                    		'</tr>'
                    		)
                    }

        }else{
                    alert('failed to request data');//请求失败的alert
                }
            },
            error: function(data,status){
            	if(status == 'error'){
                    alert('failed to request data');  //状态错误的alert
                }
            }
        })
        })

$("#add").onclick(function(){
	$("#content").html(123)
})

i = 1;
document.getElementById("add").onclick=function(){
	document.getElementById("content").innerHTML+='<input name="text" id="text_'+i+'" type="text" class="add" /><input type="button" id="btn_'+i+'"class="btn btn-danger pull-right" value="删除"  onclick="del('+i+')"/>';
	i = i + 1;
}
function del(o){
	document.getElementById("content").removeChild(document.getElementById("text_"+o));
	document.getElementById("content").removeChild(document.getElementById("btn_"+o));
}

$(document).ready(function() {
	$("#create").click(function (e) {
		e.preventDefault();
		var name = $("#name").val();
		var description = $("#description").val();
		var devicegroup = $("#devicegroup").val();
		$.ajax({
			url: "${request.contextPath}/api/noauth/device/create",
			type: "POST",
			contentType: "application/json;charset=utf-8",
			data: JSON.stringify({'name': name, 'description': description, 'devicegroup': devicegroup}),
			dataType: "text",
			success: function (result) {
				console.log('success');
				<#--刷新-->
				window.location.href = "${request.contextPath}/api/noauth/homepage";
			},
			error: function (msg) {
				alert(msg.message);
			}
		});
		return false;
	});
});

$(document).ready(function() {
	$("#dg").mousedown(function (e) {
		e.preventDefault();
		$.ajax({
			url: "${request.contextPath}/api/noauth/devicegroup/data",
			type: "GET",
			contentType: "application/json;charset=utf-8",
			dataType: "json",
			success: function (result) {
				console.log(result);
				$("#devicegroup").html("");
				for (var i=0; i<result.size; i++) {
					$("#devicegroup").append( "<option value=result.list[i].id>" + result.list[i].path + "</option>" );
				}
			},
			error: function (msg) {
				alert(msg.message);
			}
		});
		return false;
	});
});*/