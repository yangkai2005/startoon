<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="keywords" content="星力网，游戏机供应，游戏机采购，动漫游戏资讯，动漫游戏展会，卖游戏机"/>
<meta http-equiv="description" content="星力网是力凯信息科技打造的动漫游戏行业最专业的游戏机供应、游戏机采购平台，提供最新、最全的游艺产品、游戏产品、电玩产品、游戏机配件、电脑板、框体机、模拟机等供应信息、采购信息，星力网资讯频道为行业提供最专业的动漫游戏行业资讯、行业新闻。"/>
<title>星力网_中国动漫游艺门户_动漫游戏产品网络交易平台_动漫游戏行业资讯</title>

<script type="text/javascript" src="js/nav.js"></script>
<link rel="stylesheet" type="text/css" href="css/index.css" />
<script type="text/javascript" src="js/dialog.js"></script>
<script language="javascript1.1" type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>


<style type="text/css">
#floatBoxBg{display:none;width:100%;height:100%;background:#000;position:absolute;top:0;left:0;}
.floatBox{width:739px;position:absolute;top:50px;left:40%;}
.floatBox .title{height:23px;padding:7px 10px 0;background:#77A3CA;color:#fff;}
.floatBox .title h4{float:left;padding:0;margin:0;font-size:14px;line-height:16px;}
.floatBox .title span{float:right;cursor:pointer;}
.floatBox .title span img{padding-top:0px;padding-left:0px;}
.floatBox .content{padding:20px 15px;background:#fff;}

#box{padding:20px;margin:0 50px;background:#999;font-size:14px;}
#box h1{font-size:40px;line-height:50px;height:90px;}
#box #testFloatBox{position:static;margin:20px 0;}
#box table{margin:20px 0;}
#box h3{font-size:16px;padding:20px 0 10px;}
code{font-size:12px;color:#333;margin:10px;display:block;}
#box ol{margin:0;padding:0;list-style-position:inside;list-style-type:decimal;}
#box ol li{margin:0 0 20px 0;line-height:18px;}
#box ol li span{color:#00f;text-decoration:underline;cursor:pointer;}
#box ol li strong{display:block;}
body .iframe .content{padding:0;}
#box .title span{font-size:12px;}
#box p{line-height:18px;}

</style>

<script type="text/javascript">
$(document).ready(function() {
	$("h2[lang=category]").each(function() {
		var id = $(this).attr("rel");
		$(this).load("${ctx}/category.action?categoryId=" + id + "&r=" + (new Date()).getTime());
	}); 
});
</script>

</head>

<body>

<%-- header --%>
<s:include value="/inc/header.jsp"></s:include>
<%-- header --%>

	    
<div class="cls"></div>

<!--main star-->
<div class="main">
  <div class="title">
  <div class="titlemu"><img src="images/titlemu.jpg" style="display:block" /></div>
  
  <div class="hotline"><img src="images/hotline.jpg" /></div>
  </div>
  
 <div class="cls"></div>
 
 <div class="indexcon">
 	<div class="xinxi" style="display: none;"><img src="images/rmb.jpg" /> 今日采购商登录：<span class="red b">94616家</span> | 今日供应商登录：<span class="red b">203732家企业</span> |最新询盘发布：<span class="red b">10972条信息</span> |最新产品发布：<span class="red b">73630条信息</span>
 	
	
	</div>
	
	<div class="qiyeku">
	<div class="l"><span class="red f14">企业库</span>&nbsp; <strong>按产品字母分类</strong>： 
	<a href="#">A</a> 
	<a href="#">B</a>  
	<a href="#">C</a>  
	<a href="#">D</a>  
	<a href="#">E</a>  
	<a href="#">F</a>  
	<a href="#">G</a>  
	<a href="#">H</a>  
	<a href="#">I</a>  
	<a href="#">J</a>  
	<a href="#">K</a>  
	<a href="#">L</a>  
	<a href="#">M</a>  
	<a href="#">N</a>  
	<a href="#">O</a>  
	<a href="#">P</a>  
	<a href="#">Q</a>  
	<a href="#">R</a>  
	<a href="#">S</a>  
	<a href="#">T</a>  
	<a href="#">U</a>  
	<a href="#">V</a>  
	<a href="#">W</a>  
	<a href="#">X</a>  
	<a href="#">Y</a> </div>
	<div class="r"><a href="${ctx}/enterprise/supply/supply!input.action"><img src="images/fabu1.jpg" /></a> &nbsp;
	<a href="${ctx}/enterprise/postedpro/posted-pro!input.action"><img src="images/fabu2.jpg" /></a></div>
	
	</div>
	
	<div class="cls"></div>
	
	
	<s:iterator value="categories">
		<div class="tablist">
		<div class="t1"><span class="sp1"> <s:property value="name"/> </span></div>
		<h2 id="category_<s:property value="id"/>" rel="<s:property value="id"/>" lang="category"></h2>
	</div>
<div class="cls"></div>
	</s:iterator>
	
	<div class="cls"></div>
	<div class="indexnews" style="display: none;">
	  <div class="newslist">
	  <h1><img src="images/inew1.jpg" /> <a href="#">最新求购信息</a></h1>
	  <h2>
	  <ul class="list1">
	  <li><div class="time">01/11/1</div><a href="#" class="qg">[求购]</a> <a href="#">东莞废品回收：求购钛锡回收 锡渣</a></li>
	  <li><div class="time">01/11/1</div><a href="#" class="qg">[求购]</a> <a href="#">东莞废品回收：求购钛锡回收 锡渣</a></li>
	  <li><div class="time">01/11/1</div><a href="#" class="qg">[求购]</a> <a href="#">东莞废品回收：求购钛锡回收 锡渣</a></li>
	  <li><div class="time">01/11/1</div><a href="#" class="qg">[求购]</a> <a href="#">东莞废品回收：求购钛锡回收 锡渣</a></li>
	  <li><div class="time">01/11/1</div><a href="#" class="qg">[求购]</a> <a href="#">东莞废品回收：求购钛锡回收 锡渣</a></li>
	  </ul>
	  
	  </h2>

	  </div>
	  
	  <div class="newslist">
	  <h1><img src="images/inew2.jpg" /> <a href="#">最有活力企业排行榜</a></h1>
	  <h2>
	  <ul class="list2">
	  <li style="background:url(images/num1.jpg) 0 4px no-repeat;"><a href="#">济南星辉体育器材有限公司</a></li>
	   <li style="background:url(images/num2.jpg) 0 4px no-repeat;"><a href="#">济南星辉体育器材有限公司</a></li>
	 <li style="background:url(images/num3.jpg) 0 4px no-repeat;"><a href="#">济南星辉体育器材有限公司</a></li>
	  <li style="background:url(images/num4.jpg) 0 4px no-repeat;"><a href="#">济南星辉体育器材有限公司</a></li>
	   <li style="background:url(images/num5.jpg) 0 4px no-repeat;"><a href="#">济南星辉体育器材有限公司</a></li>
	  </ul>
	  
	  </h2>

	  </div>
	  
	  <div class="newslist">
	  <h1><img src="images/inew3.jpg" /> <a href="#">30分钟前获得采购询盘的企业</a></h1>
	  <h2>
	  <ul class="list1">
	  <li>【<a href="#" class="red">333条</a>】 <a href="#">东莞废品回收：求购钛锡回收 锡渣</a></li>
	<li>【<a href="#" class="red">333条</a>】 <a href="#">东莞废品回收：求购钛锡回收 锡渣</a></li>
	<li>【<a href="#" class="red">333条</a>】 <a href="#">东莞废品回收：求购钛锡回收 锡渣</a></li>
	<li>【<a href="#" class="red">333条</a>】 <a href="#">东莞废品回收：求购钛锡回收 锡渣</a></li>
	<li>【<a href="#" class="red">333条</a>】 <a href="#">东莞废品回收：求购钛锡回收 锡渣</a></li>
		  </ul>
	  
	  </h2>

	  </div>

	
	
	
	</div>
	<div class="cls"></div>
	<div class="ban"><img src="images/ban1.jpg" /></div>

 </div>

<%-- footer --%>
<s:include value="/inc/footer.jsp"/>
<%-- footer --%>	


</body>
</html>