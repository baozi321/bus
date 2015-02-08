<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/HTMLHeader.jsp" %>
<style type="text/css">
	ul{
		float:right;
		list-style-type: none;
		margin-top:10px;
		font-weight: bold;
	}
	li{
		margin-right:15px;
		width: 46px;
		height: 22px;
		background:#428BCA;
		border-radius:10px;
		text-align: center;
		cursor:pointer;
		float:left;
		color:white;
	}
	li:HOVER{
		background:#3071A9;
	}
</style>
</head>
<body>
<div style="width:100%;height: 64px;background-image: url('images/background/top-right.gif');">
	<img src="images/background/logo.jpg" width="262" height="64">
	<ul>
		<li onclick="javascript:window.open('/bus/index')">首页</li>
		<li onclick="javascript:window.parent.right.location.replace('control/right')">主页</li>
		<li onclick="javascript:window.parent.right.location.reload()">刷新</li>
		<li onclick="javascript:window.history.back()">后退</li>
		<li onclick="javascript:window.history.forward()">前进</li>
	</ul>
</div>
<script src="ext/jquery/1.11.2/jquery.min.js"></script> 
<script src="ext/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>
</html>