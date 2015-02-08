<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/HTMLHeader.jsp"%>
<title>后台登陆-永川公交网</title>
</head>
<body style="background:#555555">
<!-- body -->
<div class="container body">
<img class="center-block" src="images/logo_login.png">
<div class="col-md-6 col-md-offset-3" style="color:white;border-top:1px dashed white;padding: 15px;">
	<form class="form-horizontal" action="login" method="post">
		<div class="form-group">
			<label for="users.username" class="col-sm-3 control-label"><span class="glyphicon glyphicon-user"></span> 用户名</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" name="users.username" value="${users.username }" id="users.username" placeholder="用户名">
			</div>
		</div>
		<div class="form-group">
			<label for="users.password" class="col-sm-3 control-label"><span class="glyphicon glyphicon-lock"></span> 密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
			<div class="col-sm-9">
				<input type="password" class="form-control" value="${users.password }" name="users.password" id="users.password" placeholder="密&nbsp;&nbsp;&nbsp;&nbsp;码">
			</div>
		</div>
		<div class="form-group">
			<label for="validateCode" class="col-sm-3 control-label"><span class="glyphicon glyphicon-search"></span> 验证码</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" name="validateCode" id="validateCode" placeholder="验证码">
			</div>
			<div class="col-sm-5">
				<img src="ValidateCode.jpg">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-3">
				<div class="checkbox">
					<label> <input type="checkbox"> 记住用户名</label>
				</div>
			</div>
			<div class="col-sm-6">
				<span class="help-block" style="color:red;font-size: 18px;">${message }</span>
				
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-10">
				<button type="submit" class="btn btn-primary">立即登陆</button>
			</div>
		</div>
	</form>
</div>
</div>
<!-- start foorter -->
<%@ include file="/WEB-INF/page/common/fore/footer.jsp" %>
</body>
</html>