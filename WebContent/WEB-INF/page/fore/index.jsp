<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/HTMLHeader.jsp"%>
<title>关于我们-永川公交网</title>
</head>
<body>
<!-- header -->
<c:set var="about" scope="request" value="active" />
<%@ include file="/WEB-INF/page/common/fore/header.jsp"%>
<!-- body -->
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<li data-target="#carousel-example-generic" data-slide-to="0" ></li>
		<li data-target="#carousel-example-generic" data-slide-to="1" class="active"></li>
		<li data-target="#carousel-example-generic" data-slide-to="2"></li>
	</ol>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".indexbg").css("width",document.body.clientWidth);
			$(".indexbg").css("height",document.body.clientHeight);
		});
	</script>
	<!-- Wrapper for slides -->
	<div class="carousel-inner">
		<div class="item">
			<img class="indexbg" src="images/background.png" title="← 键盘 →">
			<div class="carousel-caption">
				<h1>永川公交网</h1>
				<h2>上线啦</h2>
   				<p>永川公交系统由CY提供，旨在为所有永川朋友的日常生活提供方便，我们会尽力保证所有公交线路信息的准确性，但由于能力所限，我们不能保证所提供的数据是准确的，所有信息仅供参考，不具备任何法律效力。请您在乘坐公交车时向乘务员问询确认。</p>
			</div>
		</div>
		<div class="item active">
			<img class="indexbg" src="images/background.png" title="← 键盘 →">
			<div class="carousel-caption">
				<a href=""><img src="images/app.png" title="立即下载"></a>
				<h1>安卓客户端，上线啦！</h1>
   				<p>永川公交系统由CY提供，旨在为所有永川朋友的日常生活提供方便，我们会尽力保证所有公交线路信息的准确性，但由于能力所限，我们不能保证所提供的数据是准确的，所有信息仅供参考，不具备任何法律效力。请您在乘坐公交车时向乘务员问询确认。</p>
			</div>
		</div>
		<div class="item">
			<img class="indexbg" src="images/background.png" title="← 键盘 →">
			<div class="carousel-caption">
				<a href=""><img src="images/app.png" title="立即下载"></a>
				<h1>IOS客户端，上线啦！</h1>
   				<p>永川公交系统由CY提供，旨在为所有永川朋友的日常生活提供方便，我们会尽力保证所有公交线路信息的准确性，但由于能力所限，我们不能保证所提供的数据是准确的，所有信息仅供参考，不具备任何法律效力。请您在乘坐公交车时向乘务员问询确认。</p>
			</div>
		</div>
	</div>

	<!-- Controls -->
	<a class="left carousel-control" href="#carousel-example-generic" data-slide="prev"> 
		<span class="glyphicon glyphicon-chevron-left"></span>
		<span class="sr-only">Previous</span>
	</a> 
	<a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
		<span class="glyphicon glyphicon-chevron-right"></span> 
		<span class="sr-only">Next</span>
	</a>
</div>
</body>
</html>