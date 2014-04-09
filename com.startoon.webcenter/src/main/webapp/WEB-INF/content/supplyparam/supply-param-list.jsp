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

<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/index.css" />
<script src="${ctx}/resources/js/jquery.js" type="text/javascript"></script>
<link href="${ctx}/resources/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>

<script type="text/javascript"> 
$(document).ready(function(){

});
</script>

</head>
<body>
<s:include value="/WEB-INF/content/inc/header.jsp"/>
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

<s:iterator value="pager.items">
<div id="compareColor2844644" class="plistk">
<div class=pcheck><input name="" type="checkbox" value="" /></div>
<div class="pcimg2"><img src="${ctx}/FileView?id=<s:property value='supply.productImgUrl'/>" width="125" /></div>


<div class=pcontent3><a href="${ctx}/supply/supply-manage!detail.action?supplyId=<s:property value="supply.id"/>"><s:property value="supply.name" /></a><br />
 <s:property value="supply.subDescription" escape="HTML" />
  <a href="${ctx}/supply/supply-manage!detail.action?supplyId=<s:property value="supply.id"/>"><span class="red">详细信息&gt;&gt;</span></a><br />
  <span class="red"> <s:property value="supply.creator.name"/> </span>&nbsp; &nbsp; &nbsp; <s:property value="supply.creator.manageTypeZh"/>&nbsp; &nbsp; &nbsp;<a href="${ctx}/enterprises/ent-produce.action?enterpriseId=<s:property value="supply.creator.id" />"><span class="red">公司所有产品</span></a>
  <br />
	<p><a href="#"><img src="${ctx}/images/xunjia.jpg" /></a> <a href="#"><img src="${ctx}/images/ckcontact.jpg" /></a></p>
  </div>

   <div class="pcontent4">
   <s:iterator value="supply.supplyParams">
   <div><s:property value="pkey"/>:<s:property value="pvalue"/></div>
   </s:iterator>
   </div> 
  
</div>

</s:iterator>
<e:pagination></e:pagination>
</div>
</div>
</div>

<s:include value="/WEB-INF/content/inc/footer.jsp"/>
</body>
</html>