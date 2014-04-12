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
<link rel="stylesheet" type="text/css" href="${ctx}/css/storefronts.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />

</head>

<body>

<s:include value="/WEB-INF/content/inc/nav.jsp"></s:include>

<div id="wrap">
	<div class="ban">   		  
		<s:include value="/WEB-INF/content/enterprises/banner.jsp"></s:include>
	</div>

<div class="cls"></div>

<div class="curr">您当前的位置：<a href="${ctx}/index.action">首 页</a> &gt; <a href="${ctx}/enterprises/ent-index.action?enterpriseId=<s:property value="enterprise.id"/>"><s:property value="enterprise.name"/></a> &gt;产业合作</div>
<!--main star-->
<div class="main">

<!-- //left star-->
<s:include value="/WEB-INF/content/inc/ent-left.jsp"></s:include>
<!-- //left over-->

<%-- main begin --%>
<div class="right">
 <div class="title3">
 <div class="titlemu"><h1>产业合作</h1></div>
 </div>
 
 <div class="mconter3">
  <ul class="newslist">
  <s:iterator value="pager.items">
  <li><div class="time"><s:date name="createTime" format="yyyy-MM-dd"/></div><a href="${ctx}/enterprises/crop/crop.action?requestId=<s:property value='id'/>"><s:property value="title"/></a></li>
  </s:iterator>
  </ul>
 
 <div class="cls"></div>
 
 <div class="pages3"><e:pagination></e:pagination> </div>

 </div>
</div>
<%-- main begin --%>

</div>
<div class="cls"></div>

<%-- footer begin --%>
<s:include value="/WEB-INF/content/inc/copyright.jsp"></s:include>
<%-- footer begin --%>
</body>
</html>