<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/HTMLHeader.jsp" %>
<script type="text/javascript">
function finish(){
	var objForm = document.forms[0];
	var form = opener.document.forms[0];
	if (form){
		form.stationId.value = objForm.stationId.value;
		form.stationName.value = objForm.stationName.value;
	}
	window.close();
}
function choice(id,name){
	var objForm = document.forms[0];
	objForm.stationId.value = id;
	objForm.stationName.value = name;
}

</script>
</head>
<body>
<form action="control/station/list?type=select" method="post">
<input type="hidden" name="page" value="1"/>
<input type="hidden" name="stationId">
<input type="hidden" name="stationName">
<table class="table table-hover">
<thead>
	<tr><td colspan="2"><%@ include file="/WEB-INF/page/common/fenye.jsp" %></td></tr>
</thead>
<tbody>
	<tr><th>选择 车站名</th></tr>
	<c:forEach items="${paging.records}" var="entry">
	<tr>
	<td>
	<input type="radio" id="radio${entry.id }" name="id" onclick="choice('${entry.id }','${entry.name}')">
	<label for="radio${entry.id }">${entry.name}</label>
	</td>
	</tr>
	</c:forEach>
</tbody>
<tfoot>
	<tr><td colspan="2">
	<input type="button" value="确定" onclick="finish()">
	</td></tr>
</tfoot>
</table>
</form>
</body>
</html>