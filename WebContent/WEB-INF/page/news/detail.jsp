<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/HTMLHeader.jsp" %>
<title>${news.news_title }-新闻中心-永川公交网</title>
</head>
<body>
<div class="container body">
<!-- header-->
<%@ include file="/WEB-INF/page/common/fore/header.jsp" %>
<!-- body -->
<h1 class="h1 page-header">${news.news_title } </h1>
<h5 class="h5">发布人：${news.news_author } 发布时间：${news.news_time }</h5>
${news.news_content }
</div>
<!-- start foorter -->
<%@ include file="/WEB-INF/page/common/fore/footer.jsp" %>
</body>
</html>