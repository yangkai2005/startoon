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
<link href="${ctx}/information/css/news-scroll.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>

<script type="text/javascript">
$(function() {
	$('li#l8').addClass('hover');
	$('h2#h8').show();
	
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
	<div class="left">
		<div class="blueBorder">
			<div class="titleCartoon"><s:property value="info.infoType.name"/></div>
			<div class="newsDetail">
				<p class="titleNewsDetail"><s:property value="info.title"/></p>
				<p class="subNews"><span>来源：<s:property value="info.source"/></span><span>录入：<s:property value="info.creator.account"/></span><span><s:date name="infoTime" format="yyyy-MM-dd"/></span></p>
				<p class="relNews">
					<span class="fr">
					下一篇：<a href="${ctx}/information/info/info!show.action?requestId=${nextInfo.id}"><s:property value="nextInfo.title"/></a>
					</span>
					上一篇：<a href="${ctx}/information/info/info!show.action?requestId=${nextInfo.id}"><s:property value="preInfo.title"/></a>
				</p>
				<div class="cls"></div>
				<div class="dumascroll">
				  <p align="left"><s:property value="info.content" escape="HTML"/></p>
				</div>
			</div>
		</div>
		
		<div class="messageZone">
			<div class="titleMessage">
				<span class="fr">已有<span class="red"><s:property value="info.comments" /></span>条评论<!-- ，共<span class="red">1139</span>人参与，点击查看<a href="#">全部留言</a> --></span>
				<span class="tabMessage"><a href="javascript:choose('tabMess','conMess',0,2);" id="tabMess0" class="lsve">评论区</a><a href="javascript:choose('tabMess','conMess',1,2);" id="tabMess1" >我要留言</a></span></div>
			<div class="cls"></div>
			<div class="conMessage">
				<div class="hover" id="conMess0" >
					<ul class="messageList">
						<s:iterator value="infoComments">
							<li>
								<p class="titleUser"><span class="fr">评论日期：<s:date name="createTime" format="yyyy-MM-dd HH:mm:dd"/></span>访客：<s:property value="creatorName"/></p>
								<div class="txtMessage"><s:property value="content"/></div>
							</li>
						</s:iterator>
					</ul>
				</div>
				<div class="hidden" id="conMess1" style="display: none; ">
					<form id="commentForm" name="commentForm" action="${ctx}/information/comments/comments!insert.action" method="post">
					<input type="hidden" name="info.id"  value="${info.id }"/>
					<table width="100%" border="0" class="tableMessage">
					  <tbody><tr>
						<td>昵称：<input type="text" name="comments.creatorName" class="txtUser"/><!--<span class="ml20">验证码：<input type="text" class="txtUser"></span><span class="ml20"><a href="#"><img src="../images/pic_checkcode.jpg" align="absmiddle"></a></span> --></td>
					  </tr>
					  <tr>
						<td><textarea class="areaMessage" name="comments.content"></textarea><p class="red">最多1000字 *</p></td>
					  </tr>
					  <tr>
						<td class="tr"><input type="submit" class="btnSubmitMess" value="" /></td>
					  </tr>
					</tbody>
					</table>
					</form>
				</div>
			</div>
		</div>
		
	</div>
	
	<div class="right">

	<s:include value="/WEB-INF/content/information/inc/right-ad1.jsp"/>
	
	<div class="title3"><div class="nt2">热点资讯</div></div>
	<div class="zxnews">
	<ul class="zxnewslist">
		<s:iterator value="hotInfos">
			<li><a href="${ctx}/information/info/info!show.action?requestId=${id}"><s:property value="shortTitle" /></a></li>
		</s:iterator>
	</ul>
	</div>	
	
	<s:include value="/WEB-INF/content/information/inc/right-ad2.jsp"/>
	
	<div class="title3"><div class="nt2">阅读推荐</div></div>
	<div class="zxnews">
	<ul class="zxnewslist">
		<s:iterator value="recommendInfos">
			<li><a href="${ctx}/information/info/info!show.action?requestId=${id}"><s:property value="shortTitle" /></a></li>
		</s:iterator>	
	</ul>
	</div>	
	
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