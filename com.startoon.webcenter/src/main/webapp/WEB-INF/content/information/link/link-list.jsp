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

<script type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="${ctx}/information/js/nav.js"></script>
<script type="text/javascript" src="${ctx}/information/js/products_scroll.js"></script>
<script type="text/javascript" src="${ctx}/information/js/swfobject.js"></script>

<link rel="stylesheet" type="text/css" href="${ctx}/css/slider/common1.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/slider/index1.css" />
<script type="text/javascript" src="${ctx}/js/slider.js"></script>

<script type="text/javascript">
$(function() {
	
});
</script>

</head>

<body>


<div id="wrap">
<!-- head start -->
<s:include value="/WEB-INF/content/information/inc/top-login.jsp"/>
<!-- head end -->
	    
<div class="cls"></div>

<s:include value="/WEB-INF/content/information/inc/menu.jsp"/>

<s:include value="/WEB-INF/content/information/inc/search.jsp"/>

<!-- main start -->
<div class="main">

<div class="linkstitle"><span><img src="${ctx}/information/images/linkt1.jpg" width="74" height="27" /></span></div>

<ul class="linkslist3" >
<s:iterator value="pager.items">
<li><a href="<s:property value='url'/>" target="_blank"><img src="<s:property value="normalLogo"/>" width="146" height="56" alt="<s:property value='name'/>" /></a><a href="<s:property value='url'/>" target="_blank"><s:property value='name'/></a></li>
</s:iterator>
</ul>

<div class="linkspage" style="height:40px;">
<div class="clear"></div>
<e:pagination></e:pagination>
</div>
</div>

<!-- main end -->

<div class="cls"></div>
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
