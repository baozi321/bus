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
	objform.action="control/station/manage_del";
	objform.method.value="delete";
	objform.submit();
}
</script>
</head>
<body>
<div class="container">
<form action="control/station/list" method="post">
<input type="hidden" name="page" value="1"/>
<table class="table table-hover">
<thead>
	<tr><th colspan="3"><%@ include file="/WEB-INF/page/common/fenye.jsp" %></th></tr>
</thead>
<tbody>
	<tr><th>选择</th><th>ID</th><th>车站名</th></tr>
	<c:forEach items="${paging.records}" var="entry">
	<tr>
	<td><input type="checkbox" name="ids" value="${entry.id}"></td>
	<td>${entry.id}</td>
	<td>${entry.name}</td>
	</tr>
	</c:forEach>
</tbody>
<tfoot>
	<tr><td colspan="3">
	<input type="checkbox" class="hidden" name="all" id="all" onclick="allselect(this, this.form.ids)"><label for="all" class="btn btn-primary btn-sm">全选</label>
	<input type="button" class="btn btn-primary btn-sm" value="删除" onclick="deleteFiles(this.form)">
	</td></tr>
</tfoot>
</table>
</form>
</div>
</body>
</html>