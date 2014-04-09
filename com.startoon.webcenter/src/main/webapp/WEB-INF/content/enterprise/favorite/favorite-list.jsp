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

<link rel="stylesheet" type="text/css" href="${ctx}/css/member.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />

<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>

<script type="text/javascript"> 
$(document).ready(function(){
	$(":hidden[name=shortDesc]").each(function() {
		var desc = $(this).val();
		var desc1 = $(desc).text();
		$(this).parent().prepend(desc1);
	});

});
</script>

</head>
<body>
<s:include value="/WEB-INF/content/inc/header.jsp"/>
<s:include value="/WEB-INF/content/inc/member-left.jsp"/>

<%-- 列表管理 --%>
<div class="memright">
<div class="title4"> <div class="hotline">客服热线：020-39106666</div>
	 <div class="titlemu2">
	 
	 <h2 class="q3"><a href="#">我的收藏</a></h2> 
	
	 </div>
	 </div>
	 
	<div class="memcon">
	 <ul class="favlist">
	 <s:iterator value="pager.items">
	 <li><div class="l"><img src="${ctx}/FileView?id=<s:property value='supply.productImgUrl'/>" width="78" height="78"/></div>
	 <div class="r">
	 <p class="b hei"><s:property value="supply.name"/></p>
	 <p><input type="hidden" name="shortDesc" value="<s:property value='supply.shortDesc'/>"/>
	 <a href="${ctx}/supply/supply-manage!detail.action?supplyId=<s:property value='supply.id'/>"><span class="red">详细信息&gt;&gt;</span></a></p>     
	 </div>
	 </li>
	 </s:iterator>
	 </ul>
	 <div class="cls"></div>
	 <div class="pages"><e:pagination/></div>
	 
	</div>
	 
</div>
<%-- 列表管理 --%>

<div class="cls"></div>
<div style="clear:both;"></div>

<s:include value="/WEB-INF/content/inc/footer.jsp"/>
</body>
</html>