<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/HTMLHeader.jsp" %>
<title>永川公交网</title>
<style>
<!--
.busContent {
	width: 188px;
	text-align: left;
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
<c:set var="station" scope="request" value="active"/>
<%@ include file="/WEB-INF/page/common/fore/header.jsp" %>
<!-- body -->
<div class="container body">
	<!-- 热门公交站(按热度排序) -->
	<div class="row">
		<h3 class="page-header">热门公交站(按热度排序)</h3>
		<c:forEach items="${hotStations }" var="entity">
		 	<div class="busContent">
		 	<a href="stationDetails?stationId=${entity[0]}"><span class="glyphicon glyphicon-flag"></span> ${entity[1] }</a>
		 	</div>
	 	 </c:forEach>
	</div>
</div>
<!-- foorter -->
<%@ include file="/WEB-INF/page/common/fore/footer.jsp" %>
</body>
</html>