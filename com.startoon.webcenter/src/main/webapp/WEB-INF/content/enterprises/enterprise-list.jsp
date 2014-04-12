<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<script type="text/javascript" src="${ctx}/js/dialog.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	$('a#searchProduct').parent().removeClass('searin');
	$('a#searchEnterprise').parent().addClass('searin');
	$('#searchForm').attr('action', '${ctx}/enterprises/enterprise-list.action');

	$("span[lang=info]").each(function() {
		var desc1 = $(this).text();
		$(this).parents('p').prepend(desc1);
	});

	$('a[rel=favorite]').click(function() {
		var fid = $(this).attr('id');
		$.post('${pageContext.request.contextPath}/enterprise/favorite/favorite!add.action', {fid: fid, type: 2}, function(data) {if(data=='success') alert('已经成功添加到收藏夹');});
	});
});
</script>
</head>

<body>
<s:include value="/WEB-INF/content/inc/header.jsp"></s:include>

<%-- main begin --%>
<div class="main">
<div class="title4">
<h1>共找到关于 “<s:property value="currentCategory.name"/>” 企业信息 <s:property value="pager.countOfTotalItem"/> 条</h1>
</div>
<div class="qycurr">
<h1>您当前的位置：<a href="${ctx}/index.action">首 页</a>&gt;
				 <a href="${ctx}/enterprises/enterprise-list.action">企业大全</a>
				 <s:if test="currentCategory!=null">&gt;</s:if>
				 <a href="${ctx}/enterprises/enterprise-list.action?categoryIds=<s:property value="currentCategory.id"/>&t=1"><s:property value="currentCategory.name"/></a> </h1>
</div>

<div class="sxuan">
<div class="l">按分类筛选：</div>
<div class="r">
<s:property value="currentCategory.name"/>
<%-- &nbsp;<a href="#" class="fenlei">选择其它分类</a>--%>
<ul>
<s:iterator value="categories">
	<li><a href="${ctx}/enterprises/enterprise-list.action?categoryIds=<s:property value='id'/>"><s:property value='name'/></a></li>
</s:iterator>
</ul>

</div>
</div>

<s:include value="/WEB-INF/content/inc/industry-left.jsp"></s:include>

<div class="qyright">


  <div class="qyrightcon">
  	<div class="title7">

	<h1>企业信息列表</h1>
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
		<div class=pcheck>&nbsp;</div>
		<div class="pcimg"><a target="_blank" class="titlqq" href="${ctx}/enterprises/ent-index.action?enterpriseId=<s:property value='id'/>"><img src="${ctx}/FileView?id=<s:property value='entInfo.infoImgUrl'/>" width="188" height="167" /></a></div>
	
		<div class="pcontent2">
		<p><a class="titlqq" target="_blank" href="${ctx}/enterprises/ent-index.action?enterpriseId=<s:property value='id'/>"><strong><s:property value="name"/></strong></a><s:if test="auth"><font style="color: #3300CC;font-weight: bold;">【已认证】</font></s:if></p>
		<p><span style="display:none;" lang="info"><s:property value='entInfo.shortIndexContent'/></span><a target="_blank" href="${ctx}/enterprises/ent-index.action?enterpriseId=<s:property value='id'/>"><span class="red">详细信息&gt;&gt;</span></a></p>
		<table width="100%" border="0" cellspacing="0">
		  <tr>
		    <td width="50%"><span class="red"></span></td>
		    <td><span class="red">成立时间：</span><s:date name="ctime" format="yyyy-MM-dd" /></td>
		  </tr>
		  <tr>
		    <td><span class="red">经营品牌：</span><s:property value="brand"/></td>
		    <td><span class="red">主营业务：</span><s:property value="business"/></td>
		  </tr>
		   <tr>
		    <td><span class="red">地址：</span><s:property value="address"/></td>
		    <td>
		    	<a target="_blank" href="${ctx}/enterprises/ent-index.action?enterpriseId=<s:property value='id'/>"><span class="red">查看该公司产品>></span></a> <br/>
		    	<a href="${ctx}/enterprises/ent-contact.action?enterpriseId=<s:property value='id'/>" target="_blank"><img src="${ctx}/images/ckcontact.jpg" /></a>
		    	<s:if test="#session.enterprise_user_id!=null">
				<a id="<s:property value='id'/>" href="javascript:void(0)" rel="favorite"><img src="${ctx}/images/favorite.jpg" /></a>
				</s:if>
		    </td>
		  </tr>
		</table>
		</div>
	</div>
	</s:iterator>

</div>
</div>
  
</div>  

<div class="cls"></div>

<div class="pages" align="center"><e:pagination></e:pagination></div>
  
<%-- main end --%>

<s:include value="/WEB-INF/content/inc/footer.jsp"></s:include>
</body>
</html>