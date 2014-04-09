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

<link rel="stylesheet" type="text/css" href="${ctx}/css/index.css" />

<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>

<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<script type="text/javascript" src="${ctx}/js/cn_main.js"></script>
<script type="text/javascript" src="${ctx}/js/sh_scripts1.js"></script>

<!-- clueTip -->
<link rel="stylesheet" type="text/css" href="${ctx}/resources/cluetip-1.0.6/jquery.cluetip.css" />
<script src="${ctx}/resources/cluetip-1.0.6/lib/jquery.bgiframe.min.js" type="text/javascript"></script>
<script src="${ctx}/resources/cluetip-1.0.6/lib/jquery.hoverIntent.js" type="text/javascript"></script>
<script src="${ctx}/resources/cluetip-1.0.6/jquery.cluetip.js" type="text/javascript"></script>
<!-- clueTip -->

<style type="text/css">

</style>

<script type="text/javascript"> 
$(document).ready(function(){
	$(":hidden[name=shortDesc]").each(function() {
		var desc = $(this).val();
		var desc1 = $(desc).text();
		$(this).parent().html(desc1);
	});

	$('a.aline').cluetip({showTitle: false, dropShadow: false});

	$('a[rel=favorite]').click(function() {
		var sid = $(this).attr('id');
		$.post('${pageContext.request.contextPath}/enterprise/favorite/favorite!add.action', {fid: sid, type: 0}, function(data) {if(data=='success') alert('已经成功添加到收藏夹');});
	});

	$(':checkbox').click(function() {
		var ck = $(this).attr('checked');
		var Y = $(this).offset().top; 
		var X = $(this).offset().left;
		if(ck) {
			$('#tishiDiv').show();
			$("#tishiDiv").css({position: "absolute", left: X + 5 + "px", top: Y - 71 + "px"}); 
		}
		else
			$('#tishiDiv').hide();
	});

	$('#compare').click(function() {
		var cks = $(':checkbox:checked');
		if(cks && cks.length==2) {
			$('#compareForm').submit();
		} else {
			alert('只能选择两款产品进行对比，请重新选择！');
			return false;
		}			
			
	});

	$('#clean').click(function() {
		$(':checkbox').attr('checked', false);
	});

	$('#close').click(function() {
		$('#tishiDiv').hide();
	});

});
</script>

</head>
<body>
<div id="popmenu" class="menuskin" onmouseover="clearhidemenu();" onmouseout="dynamichide(event)"></div>
<div id="tishiDiv" class="Layer1" ondblclick="checkBox.hiddenFlaotDiv()">
<div class="layerContent1">
<ul>
	<span class="b">您可以：</span>
</ul>
<ul>
	<li><button id="compare" class="btn01">对比产品</button></li>
	<li><input class="btn01" value="清空选择" type="button" id="clean"/></li>
	<li><input class="btn01" value="  关 闭   " type="button" id="close"/></li>
</ul>
</div>
</div>
<s:include value="/WEB-INF/content/inc/header.jsp"/>

<%-- 顶部的分类筛选 --%>
<div class="sxuan">
<div class="l">按分类筛选：</div>
<div class="r">
<s:property value="currentCategory.name"/>
<ul>
<s:iterator value="headerCategories">
	<li><a href="${ctx}/supply/supply-list.action?categoryId=<s:property value='id'/>"><s:property value='name'/></a></li>
</s:iterator>
</ul>

</div>
</div>
<%-- 顶部的分类筛选 --%>

<s:include value="/WEB-INF/content/inc/product-list-left.jsp"/>

<div class="qyright">
<div class="qyrightcon">
  	<div class="title7">
	<h2><strong>产品参数</strong></h2>
	<h1>产品信息</h1>
	</div>
	
<div class="qyshow">

<s:if test="! (pager.countOfTotalItem>0)">
<br/>
<br/>
<br/>
<div align="center">抱歉，暂无相关信息！</div>
</s:if>
<s:form namespace="/supply" action="supply-contrast" id="compareForm" name="compareForm" target="_blank">
<s:iterator value="pager.items">
<div id="compareColor<s:property value='id'/>" class="plistk">
<div class=pcheck><input id="compareBox<s:property value='id'/>" name="supplyId" type="checkbox" value="<s:property value="id"/>"/></div>
<div class="pcimg2"><a target="_blank" href="${ctx}/supply/supply-manage!detail.action?supplyId=<s:property value="id"/>"><img src="${ctx}/FileView?id=<s:property value='productImgUrl'/>" width="125" /></a></div>

<div class=pcontent3><a target="_blank" href="${ctx}/supply/supply-manage!detail.action?supplyId=<s:property value="id"/>"><s:property value="name" /></a><br />
<div><input type="hidden" name="shortDesc" value="<s:property value='shortDesc'/>"/></div><a target="_blank" href="${ctx}/supply/supply-manage!detail.action?supplyId=<s:property value="id"/>"><span class="red">[详细信息]</span></a><br />
  <span class="red"> <s:property value="creator.name"/> </span>&nbsp;<s:if test="creator.auth"><font style="color: #3300CC;font-weight: bold;">【已认证】</font></s:if>&nbsp; <s:property value="creator.manageTypeZh"/>&nbsp; &nbsp; &nbsp;<a href="${ctx}/enterprises/ent-produce.action?enterpriseId=<s:property value="creator.id" />"><span class="red">公司所有产品</span></a>
  <br />
	<p>
		<a href="${ctx}/askprice/ask-price!input.action?enterpriseId=<s:property value='creator.id'/>" target="_blank"><img src="${ctx}/images/xunjia.jpg" /></a>
		<a href="${ctx}/enterprises/ent-contact.action?enterpriseId=<s:property value='creator.id'/>" target="_blank"><img src="${ctx}/images/ckcontact.jpg" /></a>
		<s:if test="#session.enterprise_user_id!=null">
		<a id="<s:property value='id'/>" href="javascript:void(0)" rel="favorite"><img src="${ctx}/images/favorite.jpg" /></a>
		</s:if>
	</p>
  </div>

   <div class="pcontent4" id="param100037525931">
   <a class="aline" href="${ctx}/supply/supply!properties.action?requestId=<s:property value="id"/>" rel="${ctx}/supply/supply!properties.action?requestId=<s:property value="id"/>">
   <s:if test="supplyParams.size()>5">
   <s:iterator value="supplyParams" begin="0" end="4">
   <div><b><s:property value="pkey"/></b>:<s:property value="pvalue"/></div>
   </s:iterator>
   <div>......</div>
   </s:if>
   <s:else>
   <s:iterator value="supplyParams">
   <div><b><s:property value="pkey"/></b>:<s:property value="pvalue"/></div>
   </s:iterator>
   </s:else>
   </a>
   </div>
  
</div>

</s:iterator>
</s:form>
<div align="center"><e:pagination></e:pagination></div>
</div>
</div>
</div>

<s:include value="/WEB-INF/content/inc/footer.jsp"/>
</body>
</html>