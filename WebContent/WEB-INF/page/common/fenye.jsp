<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript">
<!--
//到指定的分页页面
function topage(page){
	var form = document.forms[0];
	form.page.value=page;
	form.submit();
}
//-->
</script>
<style>
<!--
.label-primary:HOVER{
	background: #3071A9;
	cursor: pointer;
}
-->
</style>
<span class="label label-primary">${paging.totalRecord}条记录 | 共${paging.totalPage}页 </span>&nbsp;
<c:forEach begin="${paging.pageIndex.startIndex}" end="${paging.pageIndex.endIndex}" var="wp">
	<c:if test="${paging.currentPage==wp}">
		<span class="label label-success">第${wp}页</span>&nbsp;
	</c:if>
	<c:if test="${paging.currentPage!=wp}">
		<span onclick="javascript:topage('${wp}')" class="label label-primary">第${wp}页</span>&nbsp;
	</c:if>
</c:forEach>
