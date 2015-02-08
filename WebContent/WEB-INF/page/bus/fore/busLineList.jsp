<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/HTMLHeader.jsp" %>
<title>永川公交网</title>
<style>
<!--
.busContent {
	width: 188px;
	text-align: center;
	float:left;
	line-height: 35px;
	font-size: 20px;
}
.busContent a{
	color: #666666;
	text-decoration: none;
}
.busContent a:HOVER {
	color: #FFA513;
}
-->
</style>
</head>
<body>
<!-- header -->
<c:set var="busLine" scope="request" value="active"/>
<%@ include file="/WEB-INF/page/common/fore/header.jsp" %>
<!-- body -->
<div class="container body">
	<!-- 公交路线 -->
	<div class="row">
		<h3 class="page-header" style="text-align: center;">公交路线(共${qr.totalRecord }条路线)</h3>
		<c:forEach items="${qr.resultList }" var="entity">
		 	<div class="busContent">
		 	<a href="buslinedetails?busline=${entity.id}"><span class="glyphicon glyphicon-align-left"></span> ${entity.name }路</a>
	 	 	</div>
	 	 </c:forEach>
	</div>
</div>
<!-- foorter -->
<%@ include file="/WEB-INF/page/common/fore/footer.jsp" %>
</body>
</html>