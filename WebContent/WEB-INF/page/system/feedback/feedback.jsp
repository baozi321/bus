<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/HTMLHeader.jsp"%>
<title>意见反馈-永川公交网</title>
</head>
<body>
<!-- header -->
<c:set var="feedback" scope="request" value="active" />
<%@ include file="/WEB-INF/page/common/fore/header.jsp"%>
<!-- body -->
<br/>
<div class="container body">
	<form class="form-horizontal" action="feedbackAction"
		method="post">
		<div class="form-group">
			<label for="feedback_name" class="col-sm-2 control-label">您的姓名</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="feedback_name" name="feedback.feedback_name" placeholder="请输入您的姓名">
			</div>
			<div class="col-sm2">
				<span class="help-block">* 在10个字符以内</span>
			</div>
		</div>
		<div class="form-group">
			<label for="feedback_email" class="col-sm-2 control-label">电子邮件</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="feedback_email" name="feedback.feedback_email" placeholder="请输入电子邮件">
			</div>
			<div class="col-sm2">
				<span class="help-block">* 在20个字符以内</span>
			</div>
		</div>
		<div class="form-group">
			<label for="feedback_tel" class="col-sm-2 control-label">您的电话</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="feedback_tel" name="feedback.feedback_tel" placeholder="请输入您的电话">
			</div>
			<div class="col-sm2">
				<span class="help-block">* 输入您的联系电话</span>
			</div>
		</div>
		<div class="form-group">
			<label for=feedback_content class="col-sm-2 control-label">反馈内容</label>
			<div class="col-sm-8">
				<textarea rows="10" class="form-control" id="feedback_content"
					name="feedback.feedback_content" placeholder="请输入反馈内容"></textarea>
			</div>
		</div>
		<div class="form-group">
			<label for="validateCode" class="col-sm-2 control-label">验证码</label>
			<div class="col-sm-2">
				<img alt="" src="ValidateCode.jpg" style="width:100%;height: 34px;">
			</div>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="validateCode" name="validateCode" placeholder="请输入验证码">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary"
					onclick="return verification()">立即反馈</button>
			</div>
		</div>
	</form>
</div>
<!-- footer -->
<%@ include file="/WEB-INF/page/common/fore/footer.jsp"%>
</body>
</html>