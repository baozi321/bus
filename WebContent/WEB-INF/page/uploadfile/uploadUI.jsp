<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/HTMLHeader.jsp" %>
</head>
<body>
<form class="form-inline" action="control/uploadfile/manage_upload" enctype="multipart/form-data" method="post">
<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">文件上传</div>
		<div class="modal-body">
			<input type="file" id="uploadFile" name="uploadFile" />
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-primary" onclick="javascript:history.back()">返回</button>
			<input type="submit" class="btn btn-primary" value="上传">
		</div>
	</div>
</div>
</form>
</body>
</html>