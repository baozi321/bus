<%@ page language="java" pageEncoding="UTF-8"%>
<style>
<!--
* {
	margin: 0px;
	padding: 0px;
}
.searchBorder {
	margin:auto;
	border:1px solid #FF60A0;
	height: 40px;
	width: 800px;
}
.searchType {
	float: left;
	height:40px;
	width:100px;
	outline:none;
	cursor:pointer;
	text-align:center;
	line-height:40px;
	color:#FF60A0;
	border-right: 1px solid #FF60A0;
}
.search {
	float: left;
	width: 538px;
	height: 30px;
	font-size:25px;
	padding: 5px;
	outline: none;	
	border: none; 
}
.searchBT {
	float: right;
	width: 150px;
	height: 40px;
}
-->
</style>
<script type="text/javascript">
	function switchover(object) {
		var busType = document.getElementById("busType");
		if(busType.value=="gj"){
			busType.value="hc";
			object.innerHTML="公交换乘";
		} else {
			busType.value="gj";
			object.innerHTML="车站路线";
		}
	}
</script>
<form action="q" target="_self">
<div class="searchBorder">
<input type="hidden" value="gj" name="type" id="busType"/>
<div title="点击切换" class="searchType" onclick="switchover(this)">车站路线</div>
<input type="text" value="${q }" name="q" id="input" class="search"><input type="image" src="images/public/index/search.jpg" class="searchBT">
</div>
</form>
