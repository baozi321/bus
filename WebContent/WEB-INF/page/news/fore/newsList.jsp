<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/HTMLHeader.jsp" %>
<title>新闻中心-永川公交网</title>
<style>
.newsDetail{
	cursor: pointer;
}
.newsDetail:HOVER {
	color: #F3609E;
}
</style>
</head>
<body>
<div class="container body">
<!-- header-->
<c:set var="news" scope="request" value="active"/>
<%@ include file="/WEB-INF/page/common/fore/header.jsp" %>
<!-- content -->
<h1 class="h1 page-header">新闻中心</h1>
<table class="table table-hover">
<thead>
	<tr><th>标题</th><th>发布人</th><th>发布时间</th></tr>
</thead>
<tbody>
	<c:forEach items="${paging.records }" var="entity">
	<tr class="newsDetail" onclick="location.href='news_detail?id=${entity.news_id}'">
		<td class="col-xs-6">${entity.news_title }</td>
		<td class="col-xs-3"><span class="glyphicon glyphicon-user"></span> ${entity.news_author }</td>
		<td class="col-xs-3"><span class="glyphicon glyphicon-time"></span> ${entity.news_time }</td>
	</tr>
	</c:forEach>
</tbody>
<tfoot></tfoot>
</table>
<!-- 分页导航 -->
 <ul class="pagination">
    <c:if test="${paging.pageIndex.startIndex!=page }">
    	<li><a href="news_list?page=${page-1}"><span>&laquo;</span><span class="sr-only">Previous</span></a></li>
    </c:if>
    <c:forEach begin="${paging.pageIndex.startIndex }" end="${paging.pageIndex.endIndex }" var="index">
	    <c:if test="${page==index }">
	    <li class="active"><a href="news_list?page=${index }">${index }</a></li>
	    </c:if>
	    <c:if test="${page!=index }">
	    <li><a href="news_list?page=${index }">${index }</a></li>
	    </c:if>
    </c:forEach>
    <c:if test="${paging.pageIndex.endIndex!=page }">
    	<li><a href="news_list?page=${page+1}"><span>&raquo;</span><span class="sr-only">Next</span></a></li>
    </c:if>
  </ul>
</div>
<!-- start foorter -->
<%@ include file="/WEB-INF/page/common/fore/footer.jsp" %>
</body>
</html>