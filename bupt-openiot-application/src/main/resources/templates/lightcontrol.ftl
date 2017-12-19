<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
  <head>
    <title>设备详情</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <link rel="stylesheet" type="text/css" href="${request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${request.contextPath}/static/bootstrap/css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="${request.contextPath}/static/css/login.css">

  </head>
  
  <body>
       <nav class="navbar navbar-inverse bar" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse"
                data-target="#example-navbar-collapse">
            <span class="sr-only">切换导航</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="${request.contextPath}/api/noauth/homepage"><span>CHENSI </span><span> 毕设2017</span></a>
    </div>
    <div class="collapse navbar-collapse " id="example-navbar-collapse" >
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    chensi <b class="caret"></b>
                </a>
                
                <ul class="dropdown-menu">
					<li><a href="${request.contextPath}/api/noauth/user/personui">个人中心</a></li>
					<li><a href="${request.contextPath}/api/noauth/homepage">物管理</a></li>
					<li><a href="${request.contextPath}/api/noauth/deviceaccess">物接入</a></li>
					<li><a href="${request.contextPath}/">退出登录</a></li>
                </ul>
            </li>
        </ul>
    </div>
    </div>
</nav>
<div class="container container_body" style='margin-top: -19px;width:100%'>
<div class="row">
<div class="col-md-2 nav_left">
<ul class="nav nav-stacked nav-pills">
<li style='font-size: 18px;

    margin-left: -5px;'><a href="${request.contextPath}/api/noauth/homepage"><span class="glyphicon glyphicon-home"></span> <span> 物管理</span></a></li>
			<hr style='margin-top: 0px; border-top: 1px solid black;'>
  				<li class="active"><a href="#"><span class="glyphicon glyphicon-inbox"></span>设备控制</a></li>
			</ul>
</div>
<div class="col-md-10 col-md-offset-2 ">
	<div class="panel panel-default" style='margin-top: 40px;'> 
    	<div class="panel-heading">
        	<span class='d_name'> 设备名:${device.name}</span>
            <span class='d_state btn-success'> 状态:${device.status}</span>
   		</div>
    	<div class="panel-body">
    	<form class='able'>
 			<fieldset>
  			<legend>基础信息:</legend>
  		       <div class="row information" >
  		       <div class="col-md-2 " style="font-weight: 800;text-align: right;">
  		       设备名 ：
  		       </div>
  		       <div class="col-md-8 col-md-offset-2">
               ${device.name}
               </div>
               <div class="col-md-2 " style="font-weight: 800;text-align: right;">
               状态 ：
               </div>
               <div class="col-md-8 col-md-offset-2">
               ${device.status}
                </div>
                <div class="col-md-2 " style="font-weight: 800;text-align: right;">
                描述 ：
                </div>
                <div class="col-md-8 col-md-offset-2">
                ${device.description}
                 </div>
  		       </div>
 			</fieldset>
		</form>
    	<form class='able'>
 			<fieldset>
  			    <legend>设备控制:</legend>
                <label >台灯开关</label> </br>
                <div class="container">
                    <div class="row">
                        <div class="col-md-4 col-md-offset-2">
                            <img src="${request.contextPath}/static/img/1.png" onclick="changeImg()" id="control">
                        </div>
                    </div>
                </div>
 			</fieldset>
		</form>
    	
    	
    	</div>
    </div>
</div>
</div>
</div>
<footer class="footer">
<div class='container'>
<div class='row'>
	<div class= 'col-md-3'>联系我们</div>
	<div class= 'col-md-3'>教程指导</div>
	<div class= 'col-md-3'>Powered by CHENSI</div>
	
</div>

</div>
</footer>
<script src="${request.contextPath}/static/js/jquery.min.js"></script>
<script src="${request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
       <script type="text/javascript">
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
           function changeImg(){
               var img = $("#control").attr("src");
               var status = 'off';
               if(img == "/static/img/1.png"){
                   status = 'on';
               } else {
                   status = 'off';
               }
               $.ajax({
                   url: "${request.contextPath}/api/noauth/device/light?status=" + status,
                   type: "POST",
                   contentType: "application/json;charset=utf-8",
                   dataType: "text",
                   success: function (result) {
                       console.log('success');
                   <#--刷新-->
                       console.log(result);
                       if (result == 'on') {
                           $("#control").attr("src","${request.contextPath}/static/img/2.png");
                       } else {
                           $("#control").attr("src","${request.contextPath}/static/img/1.png");
                       }
                   },
                   error: function (msg) {
                       alert(msg.message);
                   }
               });

           }
       </script>
  </body>
</html>
