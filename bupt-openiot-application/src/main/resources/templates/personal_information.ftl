<!DOCTYPE html>
<html>
  <head>
    <title>个人中心</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <link rel="stylesheet" type="text/css" href="${request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${request.contextPath}/static/bootstrap/css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="${request.contextPath}/static/css/login.css">
   
  </head>
  
  <body style='background-color: rgba(156, 154, 154, 0.09);'>
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
        <a class="navbar-brand" href="${request.contextPath}/api/noauth/homepage"><span>CHENSI </span><span> 物管理</span></a>
    </div>
    <div class="collapse navbar-collapse " id="example-navbar-collapse" >
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    chensi <b class="caret"></b>
                </a>
                
                <ul class="dropdown-menu">
                    <li><a href="${request.contextPath}/api/noauth/user/personui">个人中心</a></li>
                    <li><a href="${request.contextPath}/">退出登录</a></li>
                </ul>
            </li>
        </ul>
    </div>
    </div>
</nav>
<div style='min-height:800px;'>
	<div class='container'>
	<div class='row'>
	<div class='col-md-4 basic'>
	<span class="glyphicon glyphicon-home" style='font-size: 20px;
    font-weight: 600;'> chensi</span>
    <hr>
	<div class='b_body row'>
	<div class='col-md-12 pad'><span class="glyphicon glyphicon-user"> 性别 : </span> 女</div>
	<div class='col-md-12 pad'><span class="glyphicon glyphicon-earphone"> 电话 : </span> 1333333333</div>
	
	<br>
	
	</div>
	</div>
		<div class='col-md-7 basic_1'>
		<form class='able'>
 			<fieldset>
  			<legend class='open1 btn-success'>已开通服务:</legend>
  			<div style='color:black'>物接入IoT Hub</div>
  			</fieldset>
  			
  		</form>
  		
  		<form class='able'>
 			<fieldset>
  			<legend class='open1 btn-primary'>未开通服务:</legend>
  			
  			</fieldset>
  			
  		</form>
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
  </body>
</html>
