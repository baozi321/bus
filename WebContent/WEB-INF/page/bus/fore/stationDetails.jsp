<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/HTMLHeader.jsp" %>
<title>永川${station.name }公交站</title>
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
<!-- header-->
<%@ include file="/WEB-INF/page/common/fore/header.jsp" %>
<!-- body -->
<div class="body container">
   	<h2 class="page-header"><span class="label label-default">${station.name }-公交站 </span>&nbsp;<span class="badge">${fn:length(station.line_Stations) }</span></h2>
	<c:forEach items="${station.line_Stations}" var="line_Station">
		<div class="panel panel-default" style="padding: 10px;background: #EEF2FB;">
			<!-- 公交路线标题 -->
			<div class="h3" style="margin: 5px;">${line_Station.busLine.name}路公交车</div>
			<p style="color: #FFA513;">
			<span class="glyphicon glyphicon-time"></span> 运营时间：${line_Station.busLine.startTime }-${line_Station.busLine.endTime }<br/>
			<span class="glyphicon glyphicon-hand-right"></span> 票价：${line_Station.busLine.price}元 | 公交卡：${line_Station.busLine.card}元<br/>
			<span class="glyphicon glyphicon-bell"></span> ${line_Station.busLine.description}
			</p>
			<p class="busStationStyle">
				<c:forEach items="${line_Station.busLine.line_Stations}" var="line_Station_">
					<c:if test="${station.name==line_Station_.station.name }">
		 			<font style="font-weight: bold;">${line_Station_.station.name}</font> -  
					</c:if>
					<c:if test="${station.name!=line_Station_.station.name }">
		 			<a href="stationDetails?stationId=${line_Station_.station.id}">${line_Station_.station.name}</a> -  
					</c:if>
				</c:forEach>全程共${fn:length(line_Station.busLine.line_Stations)}站 
			</p>
			<a href="buslinedetails?busline=${line_Station.busLine.id }"><button class="btn btn-primary">详细信息</button></a>
			<span class="pull-right"><span class="glyphicon glyphicon-refresh"></span> 更新时间 ：${line_Station.busLine.lastUpdate }</span>
		</div>
	 </c:forEach>
</div>
<!-- start foorter -->
<%@ include file="/WEB-INF/page/common/fore/footer.jsp" %>
</body>
</html>