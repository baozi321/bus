<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/common/HTMLHeader.jsp" %>
<style>
body,td,.p1,.p2,.i{font-family:arial}
body{margin:6px 0 0 0;background-color:#EEF2FB;color:#000;position:relative}
input{padding-top:0;padding-bottom:0;-moz-box-sizing:border-box;-webkit-box-sizing:border-box;box-sizing:border-box;}
table{border:0}
TD{FONT-SIZE:9pt;LINE-HEIGHT:18px;}
em{font-style:normal;color:#cc0000}
a em{text-decoration:underline;}
#cal{width:434px;border:1px solid #c3d9ff;font-size:12px;margin:8px 0 0 15px;}
#cal #top{height:29px;line-height:29px;background:#e7eef8;color:#003784;padding-left:70px;}
#cal #top select{font-size:12px;}
#cal #top input{padding:0;}
#cal ul#wk{margin:0;padding:0;height:25px;}
#cal ul#wk li{float:left;width:60px;text-align:center;line-height:25px;list-style:none;}
#cal ul#wk li b{font-weight:normal;color:#c60b02;}
#cal #cm{clear:left;border-top:1px solid #ddd;border-bottom:1px dotted #ddd;position:relative;}
#cal #cm .cell{position:absolute;width:42px;height:36px;text-align:center;margin:0 0 0 9px;}
#cal #cm .cell .so{font:bold 16px arial;}
#cal #bm{text-align:right;height:24px;line-height:24px;padding:0 13px 0 0;}
#cal #bm a{color:7977ce;}
#cal #fd{display:none;position:absolute;border:1px solid #dddddf;background:#feffcd;padding:10px;line-height:21px;width:150px;}
#cal #fd b{font-weight:normal;color:#c60a00;}
</style>
</head>
<body>
<div class="container">
<iframe name="weather_inc" src="http://i.tianqi.com/index.php?c=code&id=1" width="330" height="35" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
<div style="width:435px;margin: auto;text-align: center;font: 50px bold red;color:green;">
永川公交系统
</div>
<table style="display:block;margin:50px auto;width:435px;"><tr><td>
<div id="cal"><div id="top">公元&nbsp;<select></select>&nbsp;年&nbsp;<select></select>&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;农历<span></span>年&nbsp;[&nbsp;<span></span>年&nbsp;]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="回到今天" title="点击后跳转回今天" style="padding:0px"></div><ul id="wk"><li>一</li><li>二</li><li>三</li><li>四</li><li>五</li><li><b>六</b></li><li><b>日</b></li></ul><div id="cm"></div><div id="bm"><a target="_blank" onMouseDown="return c({'fm':'alop','title':this.innerHTML,'url':this.href,'p1':al_c(this),'p2':1})" href="javascript:void(0)">历史上的今天</a></div></div>
<script src="ext/wannianli/bdcalendar.js"></script>
</td></tr></table>
</div>
</body>
</html>