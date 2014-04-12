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

<script type="text/javascript"> 
$(document).ready(function(){
	
	//资讯中心
	$('li#l2').addClass('hover');
	$('h2#h2').show();
	
	$('a[rel=ad]').click(function() {
		var id = $(this).attr('id');
		$.post('${ctx}/information/advertisement/click.action', {'id':id});
	});
});
</script>
</head>

<body>
<div id="wrap">
<s:include value="/information/inc/header.jsp"/>

<%-- main begin --%>
<!--main star-->
<div class="main">

	<div class="newsBoxBottom">
	<div class="newsBox">
		<div class="titleNews"><span>搜索结果</span></div>
		<div class="newsBoxCont">
			<ul class="policyList">
				<s:iterator value="pager.items">
				<li><span class="fr"> <s:date name="infoTime" format="yyyy-MM-dd"/> </span><a href="${ctx}/information/info/info!show.action?requestId=${id}"><s:property value="title"/></a></li>
				</s:iterator>
			</ul>
			<div class="cls"></div>
			<div class="pages"><e:pagination/></div>
		</div>
	</div>
	</div>
	
	<div class="right">
	<s:include value="/information/inc/right-ad1.jsp"/>
	<s:action name="info-hot" namespace="/information/inc" executeResult="true"/>
	<s:include value="/information/inc/right-ad2.jsp"/>
	<s:include value="/information/inc/right-ad3.jsp"/>
	</div>
</div>
<%-- main end --%>

<div class="cls"></div>

<%-- links begin --%>
<s:include value="/information/inc/links.jsp"/>
<%-- links end --%>

<div class="cls"></div>

<!--foot begin-->
<s:include value="/information/inc/footer.jsp"/>
<!--foot end-->

</div>
</body>
</html>