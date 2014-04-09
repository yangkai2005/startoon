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

<style type="text/css">
.t1 {
font-size: 14px;
font-weight: bold;
color: #3333FF;
}

.pcontent3 A:link {
    COLOR: #003399; TEXT-DECORATION: none
}
.pcontent3 A:visited {
    COLOR: #003399; TEXT-DECORATION: none;
}
.pcontent3 A:hover {
    COLOR: #ff0000; TEXT-DECORATION: none
}
.pcontent3 A:active {
    COLOR: #ff0000; TEXT-DECORATION: none
}
.btn01 {
BACKGROUND-IMAGE: url(../images/button.gif);
BORDER-BOTTOM: 0px solid;
BORDER-LEFT: 0px solid;
LINE-HEIGHT: 145%;
WIDTH: 65px;
HEIGHT: 21px;
COLOR: #666;
BORDER-TOP: 0px solid;
CURSOR: hand;
BORDER-RIGHT: 0px solid;
background-image: url(http://jic.b2b.makepolo.com/caigou/images/bnt_01.gif);
border-bottom: 0px solid;
border-left: 0px solid;
line-height: 145%;
width: 65px;
height: 21px;
color: #666;
border-top: 0px solid;
border-right: 0px solid;
}

</style>

<script type="text/javascript"> 
$(document).ready(function(){
	$('#type').val(2);
	$('a#searchProduct').parent().removeClass('searin');
	$('a#searchPost').parent().addClass('searin');

	$(":hidden[name=shortDesc]").each(function() {
		var desc = $(this).val();
		var desc1 = $(desc).text();
		$(this).parent().html(desc1);
	});
	
	$('a[rel=favorite]').click(function() {
		var sid = $(this).attr('id');
		$.post('${pageContext.request.contextPath}/enterprise/favorite/favorite!add.action', {fid: sid, type: 1}, function(data) {if(data=='success') alert('已经成功添加到收藏夹');});
	});
});
</script>

</head>
<body>
<s:include value="/WEB-INF/content/inc/header.jsp"/>

<%-- 顶部的分类筛选 --%>
<s:if test="headerCategories.size()>0">
<div class="sxuan" >
<div class="l">按分类筛选：</div>
<div class="r">
<s:property value="currentCategory.name"/>
<ul>
<s:iterator value="headerCategories">
	<li><a href="${ctx}/postedpro/posted-pro1-list.action?categoryIdStr=<s:property value='id'/>"><s:property value='name'/></a></li>
</s:iterator>
</ul>

</div>
</div>
</s:if>
<%-- 顶部的分类筛选 --%>

<s:include value="/WEB-INF/content/inc/posted-pro-left.jsp"/>

<div class="qyright">
<div class="qyrightcon">
  	<div class="title7">
	<h2><strong></strong></h2>
	<h1>求购信息</h1>
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
<div class=pcontent3><a class="t1" href="${ctx}/postedpro/posted-pro!detail.action?requestId=<s:property value="id"/>"><s:property value="proName" /></a>[<s:date name="createTime" format="yyyy-MM-dd"/>]<br />
<div><input type="hidden" name="shortDesc" value="<s:property value='shortDesc'/>"/></div><a href="${ctx}/postedpro/posted-pro!detail.action?requestId=<s:property value="id"/>"><span class="red">[详细信息]</span></a>
<br />
<p>
	<input type="button" value="点此报价" class="btn01" onclick="window.open('${ctx}/publishprice/publish-price!input.action?pid=<s:property value='id'/>&receiverId=<s:property value='creator.id'/>','_blank')" />
	<s:if test="#session.enterprise_user_id!=null">
	<a id="<s:property value='id'/>" href="javascript:void(0)" rel="favorite"><img src="${ctx}/images/favorite.jpg" /></a>
	</s:if>
</p>

  </div>

   <div class="pcontent4"></div> 
  
</div>

</s:iterator>
<e:pagination></e:pagination>
</div>
</div>
</div>

<s:include value="/WEB-INF/content/inc/footer.jsp"/>
</body>
</html>