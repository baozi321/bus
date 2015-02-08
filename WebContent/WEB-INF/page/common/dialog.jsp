<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="ext/bootstrap/3.3.0/css/bootstrap.min.css">
<!--[if lt IE 9]>
  <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body style="background: #EEF2FB">
<!-- 对话框 start-->
<div class="modal-dialog modal-sm" style="margin-top: 10%">
	<div class="modal-content">
		<div class="modal-header">
			<h4 class="modal-title"><strong>提示</strong></h4>
		</div>
		<div class="modal-body">
			<p>${message }</p>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-primary" onclick="javascript:history.back()">返回</button>
			<button type="button" class="btn btn-primary" onclick="javascript:location.assign('${url}')">确定</button>
		</div>
	</div>
</div>
<!-- 对话框  end-->
<script src="ext/jquery/1.11.2/jquery.min.js"></script> 
<script src="ext/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>
</html>