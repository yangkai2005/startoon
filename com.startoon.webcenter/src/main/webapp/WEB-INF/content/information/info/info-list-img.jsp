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
	<s:if test="%{typeIdEq2}">
	$('li#l2').addClass('hover');
	$('h2#h2').show();
	</s:if>
	
	//创意资讯
	<s:if test="infoType.id==7">
	$('li#l7').addClass('hover');
	$('h2#h7').show();
	</s:if>
	//模拟世界-技术
	<s:if test="infoType.id==35">
	$('li#l10').addClass('hover');
	$('h2#h10').show();
	</s:if>
	//模拟世界-市场
	<s:if test="infoType.id==36">
	$('li#l10').addClass('hover');
	$('h2#h10').show();
	</s:if>

	//产业合作-代理
	<s:if test="infoType.id==31">
	$('li#l9').addClass('hover');
	$('h2#h9').show();
	</s:if>
	//产业合作-合作
	<s:if test="infoType.id==32">
	$('li#l9').addClass('hover');
	$('h2#h9').show();
	</s:if>
	//产业合作-加盟
	<s:if test="infoType.id==33">
	$('li#l9').addClass('hover');
	$('h2#h9').show();
	</s:if>
	//产业合作-商机
	<s:if test="infoType.id==34">
	$('li#l9').addClass('hover');
	$('h2#h9').show();
	</s:if>
	//人才服务-教育培训
	<s:if test="infoType.id==46">
	$('li#l11').addClass('hover');
	$('h2#h11').show();
	</s:if>
	//星力观察家
	<s:if test="infoType.id==6">
	$('li#l6').addClass('hover');
	</s:if>
	//星力观察家
	<s:if test="infoType.id==4">
	$('li#l4').addClass('hover');
	$('h2#h4').show();
	</s:if>
	<s:if test="infoType.id==19">
	//行情调查-编辑推荐
	$('li#l3').addClass('hover');
	$('h2#h3').show();
	</s:if>
	
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
<!--main star-->
<div class="main">

<div class="left blueBorder">
		<div class="titleCartoon"><s:property value="infoType.name"/></div>
		<ul class="imgNewsList">
			<s:iterator value="pager.items">
				<li>
					<a href="${ctx}/information/info/info!show.action?requestId=${id}" target="_blank"><img src="<s:property value='mainImg.smallImg'/>" width="100" height="75"/></a>
					<div class="txtImgNews">
						<p class="titleTxtImg"><span class="fr"><s:date name="infoTime" format="yyyy-MM-dd"/></span><a href="${ctx}/information/info/info!show.action?requestId=${id}" target="_blank"><s:property value="title"/></a></p>
						<p class="t2m"><s:property value="contentTxt125"/><a href="${ctx}/information/info/info!show.action?requestId=${id}" target="_blank">&gt;&gt;&gt;详细</a></p>
					</div>
				</li>
			</s:iterator>
		</ul>
		
		<div class="cls"></div>
		<div class="pages"><e:pagination></e:pagination></div>
	</div>

	
	<div class="right">
	<s:include value="/WEB-INF/content/information/inc/right-ad1.jsp"/>
	<s:action name="info-hot" namespace="/information/inc" executeResult="true"/>
	<s:include value="/WEB-INF/content/information/inc/right-ad2.jsp"/>
	<s:include value="/WEB-INF/content/information/inc/right-ad3.jsp"/>
	</div>
</div>
<%-- main end --%>

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