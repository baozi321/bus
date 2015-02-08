<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/HTMLHeader.jsp" %>
<link rel="stylesheet" href="ext/umeditor1_2_2-utf8-jsp/themes/default/css/umeditor.css">
<script src="ext/umeditor1_2_2-utf8-jsp/third-party/jquery.min.js"></script>
<script src="ext/umeditor1_2_2-utf8-jsp/umeditor.config.js"></script>
<script src="ext/umeditor1_2_2-utf8-jsp/umeditor.min.js"></script>
<script src="ext/umeditor1_2_2-utf8-jsp/lang/zh-cn/zh-cn.js"></script>
</head>
<body style="background: #EEF2FB">
<div class="container">
	<form class="form-horizontal" action="control/news/mamage_add" method="post">
	  <div class="form-group">
	    <label for="news_title" class="col-sm-2 control-label">新闻标题</label>
	    <div class="col-sm-8">
	      <input type="text" class="form-control" id="news_title" name="news.news_title" placeholder="请输入新闻标题">
	    </div>
	    <div class="col-sm2">
	      <span class="help-block">* 在50个字符以内</span>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="news_author" class="col-sm-2 control-label">新闻作者</label>
	    <div class="col-sm-8">
	      <input type="text" class="form-control" id="news_author" name="news.news_author" placeholder="请输入新闻作者">
	    </div>
	    <div class="col-sm2">
	      <span class="help-block">* 在10个字符以内</span>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="news_author" class="col-sm-2 control-label">新闻内容</label>
	    <div class="col-sm-8">
	      <!--style给定宽度可以影响编辑器的最终宽度-->
		  <script type="text/plain" id="myEditor" style="width:100%;height: 300px;"></script>
		  <script type="text/javascript">
		  	//实例化编辑器
		    var um = UM.getEditor('myEditor');
		    function verification() {
				// 新闻标题
				var news_title = document.getElementById("news_title");
				if(news_title.value == ""){
					alert("新闻标题不允许为空");
		        	return false;
				}
		    	// 新闻作者
		    	var news_author = document.getElementById("news_author");
		    	if (news_author.value == "") {
					alert("新闻作者不允许为空");
					return false;
				}
		    	// 新闻内容
		    	var news_content = document.getElementById("news_content");
		    	// 设置内容
		    	news_content.value=UM.getEditor('myEditor').getContent();
		    	if (news_content.value == "") {
					alert("新闻内容不允许为空");
					return false;
				}
		    }
		  </script>
	      <textarea rows="15" class="form-control hidden" id="news_content" name="news.news_content" placeholder="请输入相关新闻"></textarea>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-2">
	      <div class="checkbox">
	        <label>
	          <input type="checkbox" id="visible" checked="checked" value="true" name="news.news_visible"> 立即发布
	        </label>
	      </div>
	    </div>
	    <div class="col-sm-8">
        	<span class="help-block">默认为勾选，如果不勾选，发布之后不会显示，需手动显示</span>
        </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-primary" onclick="return verification()">发布新闻</button>
	    </div>
	  </div>
	</form>
</div>
</body>
</html>