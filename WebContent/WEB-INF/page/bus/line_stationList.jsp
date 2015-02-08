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
	
}
//添加站点
function add(me) {
	var add = document.getElementById("add");
	if(me.value=="添加") {
		me.setAttribute("value","取消");
		add.setAttribute("style", "display: normal");
	} else {
		me.setAttribute("value","添加");
		add.setAttribute("style", "display: none");
	}
}
/* 打开一个指定的窗口 */
function winOpen (strURL,strName,width,height)
{
    theWindow = window.open (strURL,strName,"width="+width+" height="+height+" scrollbars=yes left="+(1024-width)/2+" top="+(768-height)/2);	
    if (theWindow.opener == null) theWindow.opener = window;
    if (window.focus) theWindow.focus();
}
</script>
</head>
<body>
<div class="container">
<form action="control/line_station/manage_add" method="post">
<input type="hidden" name="busLineId" value="${busLine.id }"/>
<input type="hidden" name="stationId">
<table class="table table-hover">
<thead>
	<tr><th colspan="4"><span class="h3">公交路线${busLine.name}</span></th></tr>
</thead>
<tbody>
	<tr><th>选择</th><th>第几站</th><th>车站名</th></tr>
	<c:forEach items="${line_Stations}" var="line_Station">
	<tr>
	<td><input type="checkbox" name="ids" value=""></td>
	<td>第${line_Station.num}站</td>
	<td>${line_Station.station.name}</td>
	<td><a>编辑</a></td>
	</tr>
	</c:forEach>
	<tr id="add" style="display: none"><td></td><td>第<input type="text" style="width:20px" name="num">站</td><td><input type="text" name="stationName" disabled="disabled"><input class="btn btn-primary btn-sm" type="button" onclick="winOpen('control/station/list?type=select','车站列表',100,400)" value="选择"></td></tr>
</tbody>
<tfoot>
	<tr><td colspan="4">
	<input type="checkbox" class="hidden" name="all" id="all" onclick="allselect(this, this.form.ids)"><label for="all" class="btn btn-primary btn-sm">全选</label>
	<input class="btn btn-primary btn-sm" type="submit" value="保存" onclick="deleteFiles(this.form)">
	<input class="btn btn-primary btn-sm" type="button" value="添加" onclick="add(this)">
	</td></tr>
</tfoot>
</table>
</form>
</div>
</body>
</html>