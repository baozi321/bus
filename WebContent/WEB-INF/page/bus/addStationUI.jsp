<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/page/common/HTMLHeader.jsp" %>
</head>
<body>
<div class="container">
	<form class="form-horizontal" action="control/bus/stationManage_add" method="post">
	  <div class="form-group">
	    <label for="stationName" class="col-sm-2 control-label">车站名称</label>
	    <div class="col-sm-8">
	      <input type="text" name="name" class="form-control" id="stationName" placeholder="请输入车站名称"/>
	    </div>
	    <div class="col-sm2">
	      <span class="help-block">* 在20个字符以内</span>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-primary" onclick="return verification()">添加车站</button>
	    </div>
	  </div>
	</form>
</div>
</body>
</html>
