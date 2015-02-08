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
	objform.action="control/busLine/manage_del";
	objform.method.value="delete";
	objform.submit();
}
</script>
</head>
<body>
<div class="container">
<form action="control/busLine/list" method="post">
<input type="hidden" name="page" value="1"/>
<table class="table table-hover">
<thead>
	<tr><th colspan="10"><%@ include file="/WEB-INF/page/common/fenye.jsp" %></th></tr>
</thead>
<tbody>
	<tr><th>选择</th><th>ID</th><th>公交路线</th><th>发车时间</th><th>收车时间</th><th>现金价格</th><th>刷卡价格</th><th>最后更新</th><th>相关说明</th><th>车站管理</th></tr>
	<c:forEach items="${paging.records}" var="entry">
	<tr>
	<td><input type="checkbox" name="ids" value="${entry.id}"></td>
	<td>${entry.id}</td>
	<td>${entry.name}</td>
	<td>${entry.startTime}</td>
	<td>${entry.endTime}</td>
	<td>${entry.price}</td>
	<td>${entry.card}</td>
	<td>${entry.lastUpdate }</td>
	<td>${entry.description }</td>
	<td><a href="control/line_station/list?busLineId=${entry.id}">管理</a></td>
	</tr>
	</c:forEach>
</tbody>
<tfoot>
	<tr><td colspan="10">
	<input type="checkbox" class="hidden" name="all" id="all" onclick="allselect(this, this.form.ids)"><label for="all" class="btn btn-primary btn-sm">全选</label>
	<input type="button" class="btn btn-primary btn-sm" value="删除" onclick="deleteFiles(this.form)">
	</td></tr>
</tfoot>
</table>
</form>
</div>
</body>
</html>