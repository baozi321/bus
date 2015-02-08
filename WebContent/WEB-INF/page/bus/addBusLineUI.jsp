<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/page/common/HTMLHeader.jsp" %>
</head>
<body>
<div class="container">
	<form class="form-horizontal" action="control/station/manage_add" method="post">
	  <div class="form-group">
	    <label for="busLine_name" class="col-sm-2 control-label">公交路线</label>
	    <div class="col-sm-8">
	      <input type="text" class="form-control" id="busLine_name" name="busLine.name" placeholder="请输入公交路线">
	    </div>
	    <div class="col-sm2">
	      <span class="help-block">* 在10个字符以内</span>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="busLine_startTime" class="col-sm-2 control-label">发车时间</label>
	    <div class="col-sm-8">
	      <input type="text" class="form-control" id="busLine_startTime" name="busLine.startTime" placeholder="请输入发车时间">
	    </div>
	    <div class="col-sm2">
	      <span class="help-block">* 例如 6:00</span>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="busLine_endTime" class="col-sm-2 control-label">收车时间</label>
	    <div class="col-sm-8">
	      <input type="text" class="form-control" id="busLine_endTime" name="busLine.endTime" placeholder="请输入收车时间">
	    </div>
	    <div class="col-sm2">
	      <span class="help-block">* 例如 18:00</span>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="busLine_price" class="col-sm-2 control-label">现金价格</label>
	    <div class="col-sm-8">
	      <input type="text" class="form-control" id="busLine_price" name="busLine.price" placeholder="请输入现金价格">
	    </div>
	    <div class="col-sm2">
	      <span class="help-block">* 例如 1</span>
	    </div>
	  </div><div class="form-group">
	    <label for="busLine_card" class="col-sm-2 control-label">刷卡价格</label>
	    <div class="col-sm-8">
	      <input type="text" class="form-control" id="busLine_card" name="busLine.card" placeholder="请输入刷卡价格">
	    </div>
	    <div class="col-sm2">
	      <span class="help-block">* 例如 0.9</span>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="busLine_description" class="col-sm-2 control-label">相关说明</label>
	    <div class="col-sm-8">
	      <textarea rows="10" class="form-control" id="busLine_description" name="busLine.description" placeholder="请输入相关说明"></textarea>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-primary">添加公交路线</button>
	    </div>
	  </div>
	</form>
</div>
</body>
</html>
