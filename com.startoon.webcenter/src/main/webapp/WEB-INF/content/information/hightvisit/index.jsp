<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="keywords" content="星力网，游戏机供应，游戏机采购，动漫游戏资讯，动漫游戏展会，卖游戏机"/>
<meta http-equiv="description" content="星力网是广州星力动漫游戏产业园打造的动漫游戏行业最专业的游戏机供应、游戏机采购平台，提供最新、最全的游艺产品、游戏产品、电玩产品、游戏机配件、电脑板、框体机、模拟机等供应信息、采购信息，星力网资讯频道为行业提供最专业的动漫游戏行业资讯、行业新闻。"/>
<title>星力网_中国动漫游艺门户_动漫游戏产品网络交易平台_动漫游戏行业资讯</title>
<link rel="stylesheet" type="text/css" href="${ctx}/information/css/style.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/information/css/common.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/slider.css" />

<script type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="${ctx}/js/slider.js"></script>

<script type="text/javascript"> 
$(document).ready(function(){
	$('li#l4').addClass('hover');
	$('h2#h4').show();
	
	$('a[rel=ad]').click(function() {
		var id = $(this).attr('id');
		$.post('${ctx}/information/advertisement/click.action', {'id':id});
	});	
});
</script>
</head>

<body>
<div id="wrap">
<s:include value="/WEB-INF/content/information/inc/header.jsp"/>

<%-- main begin --%>

<div class="main">
	<div class="intleft">	
	<div class="intone">
		<div class="cyoneleft1">
		
		<div class="content_right">
		
		  <div class="ad" >
		    <ul class="slider" >
		      <s:iterator value="currentObserveMainInfo.infoImgs">
		      <li><a href="${ctx}/information/info/info!show.action?requestId=<s:property value='currentObserveMainInfo.id'/>" target="_blank"><img src="<s:property value='normalImg'/>" width="300" height="234"/></a></li>
		      </s:iterator>
		    </ul>
		    <ul class="num" >
		      <s:iterator status="st" value="currentObserveMainInfo.infoImgs">
		      <li><s:property value="#st.count"/></li>
		      </s:iterator>
		    </ul>
		  </div>
		
		</div>

		
		</div>
		
		
		<div class="intoneabout">
		<p style="margin-bottom:3px;"><span class="f16 b f96"><s:property value="currentObserveMainInfo.title"/></span></p>
		<p><s:property value="currentObserveMainInfo.contentTxt175"/><a href="${ctx}/information/info/info!show.action?requestId=<s:property value='currentObserveMainInfo.id'/>" target="_blank">[详细]</a></p>
		</div>
		
		</div>
		
		<div class="inttwo">
			<h1><div class="int1">最新访谈</div></h1>
			<h2>
			<ul class="intlist1">
			<s:iterator value="currentObserveSubInfos">
			<li><div class="l"><img src="<s:property value='mainImg.smallImg'/>" width="128" height="96"/></div>
			<div class="r">
			<p><span class="f14 b"><s:property value="title" /></span><span style=" color:#717171">（<s:date name="infoTime" format="yyyy-MM-dd"/>）</span></p>
			<p> <s:property value="contentTxt90"/> <a href="${ctx}/information/info/info!show.action?requestId=<s:property value='id'/>" target="_blank"><span class="f96">[详细]</span></a></p>
			</div>
			</li>
			</s:iterator>
			</ul>
			
			</h2>
			<h3></h3>
		
		</div>
	
	</div>
	
	<div class="intright">
		<div class="intrgone">
		<div class="inttitle"><div class="int1">热点推荐</div></div>
		<div class="intrcon">
		<ul class="intlist2">
		<s:iterator value="hotInfos">
			<li><a href="${ctx}/information/info/info!show.action?requestId=<s:property value='id'/>" target="_blank"><s:property value="shortTitle" /></a></li>
		</s:iterator>
		</ul>
		</div>
		<div class="intrfoot"></div>
		
		</div>
		
		<div class="banint1">
		<e:adquery id="ad1" adId="195"/>
		<a id="195" rel="ad" target="_blank" href="<e:adlink name="ad1"/>"><img src="<e:adimg name="ad1"/>" width="288" height="130" /></a>
		</div>
		
		<div class="intrgone">
		<div class="inttitle"><div class="more11"><a href="${ctx}/information/info/info-list-img.action?infoTypeId=4" target="_blank">更多&gt;&gt;</a></div><div class="int1">往期访谈回顾</div></div>
		<div class="intrcon" style="height:auto">
		<ul class="intlist2">
		<s:iterator value="historyInfos">
			<li><a href="${ctx}/information/info/info!show.action?requestId=<s:property value='id'/>" target="_blank"><s:property value="shortTitle" /></a></li>
		</s:iterator>
		</ul>
		</div>
		<div class="intrfoot"></div>
		
		</div>
		<div class="banint1" style="margin-bottom:0">
		<e:adquery id="ad2" adId="196"/>
		<a id="196" rel="ad" target="_blank" href="<e:adlink name="ad2"/>"><img src="<e:adimg name="ad2"/>" width="288" height="130" /></a>		
		</div>
	</div>
</div>

<%-- main end --%>

<%-- 合作伙伴 begin  --%>
<s:action name="copartnership" namespace="/information/inc" executeResult="true">
	<s:param name="infoTypeId"><s:property value="infoType.id"/> </s:param>
</s:action>
<%-- 合作伙伴 end --%>

<div class="cls"></div>

<%-- links begin --%>
<s:include value="/WEB-INF/content/information/inc/links.jsp"/>
<%-- links end --%>

<div class="cls"></div>

<!--foot begin-->
<s:include value="/WEB-INF/content/information/inc/footer.jsp"/>
<!--foot end-->

</div>
</body>
</html>
