<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/HTMLHeader.jsp" %>
<link rel="stylesheet" href="ext/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="ext/zTree_v3/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="ext/zTree_v3/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript">
	<!--
	var setting = {
			data: {
				simpleData: {
					enable: true
				}
			}
		};
	var zNodes =[
		{ id:1, pId:0, name:"网站管理",open:true},
		{ id:11, pId:1, name:"基本设置"},
		{ id:12, pId:1, name:"增加链接"},
		{ id:13, pId:1, name:"管理链接"},
		{ id:2, pId:0, name:"文件管理",open:true},
		{ id:21, pId:2, name:"上传文件", url:"control/uploadfile/uploadUI",target:"right"},
		{ id:22, pId:2, name:"文件管理", url:"control/uploadfile/list",target:"right"},
		{ id:3, pId:0, name:"站点管理",open:true},
		{ id:31, pId:3, name:"添加公交站", url:"control/station/addUI",target:"right"},
		{ id:32, pId:3, name:"管理公交站", url:"control/station/list",target:"right"},
		{ id:4, pId:0, name:"路线管理",open:true},
		{ id:41, pId:4, name:"添加公交路线", url:"control/busLine/addUI",target:"right"},
		{ id:42, pId:4, name:"管理公交路线", url:"control/busLine/list",target:"right"},
		{ id:5, pId:0, name:"新闻管理",open:true},
		{ id:51, pId:5, name:"添加新闻", url:"control/news/addUI",target:"right"},
		{ id:52, pId:5, name:"管理新闻", url:"control/news/list",target:"right"},
		{ id:6, pId:0, name:"参数管理",open:true},
		{ id:61, pId:6, name:"管理设置", url:""},
		{ id:62, pId:6, name:"登陆记录"},
	];
	
	$(document).ready(function(){
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	});
	//-->
</script>
<style>
<!--
html,body{
	height: 100%;
}
-->
</style>
</head>
<div class="container" style="border-right:2px dashed #999999;height: 99%;">
<ul id="treeDemo" class="ztree"></ul>
</div>
</body>
</html>