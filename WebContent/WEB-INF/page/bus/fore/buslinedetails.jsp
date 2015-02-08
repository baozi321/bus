<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/HTMLHeader.jsp" %>
<title>永川${busLine.name }路公交</title>
<style type="text/css">
.busStationStyle {
	line-height: 30px;
}
.busStationStyle a {
	color: #666666;
}
.busStationStyle a:HOVER {
	color: #FFA513;
	text-decoration: none;
}
</style>
</head>
<body>
<!-- start header-->
<%@ include file="/WEB-INF/page/common/fore/header.jsp" %>
<div class="container body">
<!-- 公交路线详细信息 -->
<div class="buslineStyle">
	<h2 class="page-header"><span class="label label-default">永川${busLine.name }路公交</span></h2>
	<p style="color: #FFA513;">
	<span class="glyphicon glyphicon-time"></span> 运营时间：${busLine.startTime }-${busLine.endTime }<br/>
	<span class="glyphicon glyphicon-hand-right"></span> 票价：${busLine.price}元 | 公交卡：${busLine.card}元<br/>
	<span class="glyphicon glyphicon-bell"></span> ${busLine.description}<br/>
	<span class="glyphicon glyphicon-refresh"></span> 更新时间 ：${line_Station.busLine.lastUpdate }
	</p>
	<p class="busStationStyle">
		<c:forEach items="${busLine.line_Stations}" var="line_Station">
			<a href="stationDetails?stationId=${line_Station.station.id}">${line_Station.station.name}</a>-
		</c:forEach>全程共${fn:length(line_Station.busLine.line_Stations)}站 
	</p>
</div>
<!-- 公交路线列表 -->
<div>
	<c:forEach items="${qr.resultList }" var="entity">
		<a href="buslinedetails?busline=${entity.id}"><button class="btn btn-info" style="margin: 10px;">${entity.name }路</button></a>
	</c:forEach>
</div>
</div>		
<!-- start foorter -->
<%@ include file="/WEB-INF/page/common/fore/footer.jsp" %>
</body>
</html>