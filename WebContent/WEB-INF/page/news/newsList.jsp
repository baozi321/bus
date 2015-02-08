<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/HTMLHeader.jsp" %>
<script type="text/javascript">
function allselect(allobj,items){
    var state = allobj.checked;
    if(items.length){
    	for(var i=0;i<items.length;i++){
    		if(!items[i].disabled) items[i].checked=state;
    	}
    }else{
    	if(!items.disabled) items.checked=state;
    }
}
function deleteFiles(objform){
	objform.action="control/uploadfile/manage_del";
	objform.method.value="delete";
	objform.submit();
}
</script>
</head>
<body>
<div class="container">
<form action="control/news/list" method="post">
<input type="hidden" name="page" value="1"/>
<table class="table table-hover">
<thead>
	<tr><th colspan="7"><%@ include file="/WEB-INF/page/common/fenye.jsp" %></th></tr>
</thead>
<tbody>
	<tr><th>选择</th><th>ID</th><th>标题</th><th>作者</th><th>发布时间</th><th>状态</th><th>编辑</th></tr>
	<c:forEach items="${paging.records}" var="entry">
		<tr><td><input type="checkbox" name="ids" value="${entry.news_id}"></td><td>${entry.news_id}</td>
		<td>${entry.news_title}</td><td>${entry.news_author}</td><td>${entry.news_time}</td>
		<td><c:if test="${entry.news_visible}">显示</c:if><c:if test="${!entry.news_visible}">隐藏</c:if></td>
		<td><a href="#">编辑</a></td></tr>
	</c:forEach>
</tbody>
<tfoot>
	<tr><td colspan="7">
	<input type="checkbox" class="hidden" name="all" id="all" onclick="allselect(this, this.form.ids)"><label for="all" class="btn btn-primary btn-sm">全选</label>
	<input type="button" class="btn btn-primary btn-sm" value="删除" onclick="deleteFiles(this.form)">
	</td></tr>
</tfoot>
</table>
</form>
</div>
</body>
</html>