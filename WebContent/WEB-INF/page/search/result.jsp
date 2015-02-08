<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/HTMLHeader.jsp" %>
<title>搜索-永川公交网</title>
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
<div class="body container">
<!-- 提示 -->
<c:if test="${!empty(message)}">
	<div class="alert alert-danger" style="text-align: center;">${message }</div>
</c:if>
<br/>
<!-- 公交路线 -->
<c:forEach items="${buslines}" var="busLine">
	<div class="panel panel-default" style="padding: 10px;background: #EEF2FB;">
		<!-- 公交路线标题 -->
		<div class="h3" style="margin: 5px;">${busLine.name}路公交车</div>
		<p style="color: #FFA513;">
		<span class="glyphicon glyphicon-time"></span> 运营时间：${busLine.startTime }-${busLine.endTime }<br/>
		<span class="glyphicon glyphicon-hand-right"></span> 票价：${busLine.price}元 | 公交卡：${busLine.card}元<br/>
		<span class="glyphicon glyphicon-bell"></span> ${busLine.description}
		</p>
		<p class="busStationStyle">
			<c:forEach items="${busLine.line_Stations}" var="line_Station">
				<a href="stationDetails?stationId=${line_Station.station.id}">${line_Station.station.name}</a>-
			</c:forEach>全程共${fn:length(busLine.line_Stations)}站 
		</p>
		<a href="buslinedetails?busline=${line_Station.busLine.id }"><button class="btn btn-primary">详细信息</button></a>
		<span class="pull-right"><span class="glyphicon glyphicon-refresh"></span> 更新时间 ：${line_Station.busLine.lastUpdate }</span>
	</div>
 </c:forEach>
<!-- 公交站 -->
<c:forEach items="${stations}" var="station">
	<div class="panel panel-default" style="padding: 10px;background: #EEF2FB;">
		<span class="h2">${station.name }公交站</span>
		<p class="busStationStyle"> 该公交站共有以下几路公交车<br/>
			<c:forEach items="${station.line_Stations }" var="entity">
				<a href="buslinedetails?busline=${entity.busLine.id}">${entity.busLine.name }路 </a> |
			</c:forEach> Powered by CY.
		</p>
		<a href="stationDetails?stationId=${station.id}"><button class="btn btn-primary">详细信息</button></a>
	</div>
</c:forEach>
	 
<!-- 换乘 -->
<!-- 直达 -->
<c:if test="${mark==1 }">
	<c:forEach items="${result }" var="busLine">
		<div class="panel panel-default" style="padding: 10px;background: #EEF2FB;">
			<!-- 公交路线标题 -->
			<div class="h3" style="margin: 5px;">${busLine.name}路公交车</div>
			<p style="color: #FFA513;">
			<span class="glyphicon glyphicon-time"></span> 运营时间：${busLine.startTime }-${busLine.endTime }<br/>
			<span class="glyphicon glyphicon-hand-right"></span> 票价：${busLine.price}元 | 公交卡：${busLine.card}元<br/>
			<span class="glyphicon glyphicon-bell"></span> ${busLine.description}
			</p>
			<p class="busStationStyle">
				<c:forEach items="${busLine.line_Stations}" var="line_Station">
					<a href="stationDetails?stationId=${line_Station.station.id}">${line_Station.station.name}</a>-
				</c:forEach>全程共${fn:length(busLine.line_Stations)}站 
			</p>
			<a href="buslinedetails?busline=${line_Station.busLine.id }"><button class="btn btn-primary">详细信息</button></a>
			<span class="pull-right"><span class="glyphicon glyphicon-refresh"></span> 更新时间 ：${line_Station.busLine.lastUpdate }</span>
		</div>
	</c:forEach>
</c:if>	
<!-- 换乘 -->
<c:if test="${mark==2 }">
	<c:forEach items="${result }" var="transfer">
		<div class="panel panel-default" style="padding: 10px;background: #EEF2FB;">
			<span class="h2">
				<span class="label label-default">先乘坐<a href="buslinedetails?busline=${transfer.firstBusLine.id}">${transfer.firstBusLine.name }路</a>公交车，然后在乘坐<a href="buslinedetails?busline=${transfer.secondBusLine.id}">${transfer.secondBusLine.name }路</a></span>
			</span><br/><br/>
			<p class="busStationStyle"> 可以在以下车站下车进行换乘：<br/>
				<c:forEach items="${transfer.transferStations }" var="station">
					<a href="stationDetails?stationId=${station.id }">${station.name }</a>|
				</c:forEach> Powered by CY.
			</p>
		</div>
	</c:forEach>
</c:if>	
</div>
<%@ include file="/WEB-INF/page/common/fore/footer.jsp" %>
</body>
</html>