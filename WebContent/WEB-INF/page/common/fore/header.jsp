<%@ page language="java" pageEncoding="UTF-8"%>
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="" style="color:white;font-weight: bold;"><span class="glyphicon glyphicon-flash"></span> 永川公交</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="<c:out value='${index }'/>"><a href=""><span class="glyphicon glyphicon-home"></span> 首页</a></li>
				<li class="<c:out value='${busLine }'/>"><a href="busLine"><span class="glyphicon glyphicon-align-left"></span> 路线</a></li>
				<li class="<c:out value='${station }'/>"><a href="station"><span class="glyphicon glyphicon-flag"></span> 车站</a></li>
				<li class="<c:out value='${news }'/>"><a href="news_list"><span class="glyphicon glyphicon-globe"></span> 新闻</a></li>
				<li class="<c:out value='${feedback }'/>"><a href="feedback"><span class="glyphicon glyphicon-envelope"></span> 反馈</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">更多
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#"><span class="glyphicon glyphicon-user"></span> 关于我们</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-phone"></span> 联系我们</a></li>
						<li class="divider"></li>
						<li><a href="#"><span class="glyphicon glyphicon-heart"></span> 新浪微博</a></li>
					</ul></li>
			</ul>
			<!-- 查询 -->
			<form class="navbar-form navbar-right" action="q">
				<div class="input-group">
					<input type="text" value="${q }" name="q" class="form-control" placeholder="路线/站点/起始 终点">
					<div class="input-group-btn">
					<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span> 查询</button>
					</div><!-- /btn-group -->
				</div><!-- /input-group -->
    
			</form>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</div>