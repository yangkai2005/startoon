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

<script src="${ctx}/information/js/nav.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>

<script type="text/javascript"> 
$(document).ready(function(){
	$('li#l9').addClass('hover');
	$('h2#h9').show();

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
<div class="indleft">
	<div class="indtab">
<div class="titleind">
<div class="l"><img src="${ctx }/information/images/icon_ind.jpg"/></div>
<div class="r">
<ul class="indlist">
<li class="" onmouseover="setTab('indone',1,2)" id="indone1"><a href="<s:url namespace="/information/info" action="info-list"/>?infoTypeId=31">代理</a></li>
<li onmouseover="setTab('indone',2,2)" id="indone2" class="hover"><a href="<s:url namespace="/information/info" action="info-list"/>?infoTypeId=32">合作</a></li>
</ul>
</div>
<div class="more4"><!-- <a href="#" target="_blank">更多&gt;&gt;</a> --></div>
</div>
<div class="indcon">

<div class="" id="con_indone_1" style="display: none; ">
<table width="100%" border="0" cellspacing="0" class="indtable">
  <tbody>
  <tr>
    <th width="67%">标   题</th>
    <th width="14%">访问</th>
    <th width="19%">发布时间</th>
  </tr>
  <s:iterator value="proxyInfos">
  <tr>
    <td><a href="<s:url namespace="/information/info" action="info!show"/>?requestId=${id}" target="_blank"><s:property value="title"/></a></td>
    <td class="fw"><s:property value="hits"/></td>
    <td><s:date name="createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:iterator>
</tbody>
</table>
</div>

<div class="play" id="con_indone_2" style="display: block; ">
<table width="100%" border="0" cellspacing="0" class="indtable">
  <tbody><tr>
    <th width="67%">标   题</th>
    <th width="14%">访问</th>
    <th width="19%">发布时间</th>
  </tr>
  <s:iterator value="coopInfos">
  <tr>
    <td><a href="<s:url namespace="/information/info" action="info!show"/>?requestId=${id}" target="_blank"><s:property value="title"/></a></td>
    <td class="fw"><s:property value="hits"/></td>
    <td><s:date name="createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:iterator>
</tbody>
</table>
</div>


</div>



</div>

<div class="indtab" style="margin-bottom:0">
<div class="titleind">
<div class="l"><img src="../images/icon_ind.jpg"/></div>
<div class="r">
<ul class="indlist">
<li class="hover" onmouseover="setTab('ind',1,2)" id="ind1"><a href="<s:url namespace="/information/info" action="info-list"/>?infoTypeId=33">加盟</a></li>
<li onmouseover="setTab('ind',2,2)" id="ind2" class=""><a href="<s:url namespace="/information/info" action="info-list"/>?infoTypeId=34">商机</a></li>
</ul>
</div>
<div class="more4"><!-- <a href="#" target="_blank">更多&gt;&gt;</a> --></div>
</div>
<div class="indcon">
<div class="" id="con_ind_1" style="display: block; ">
<table width="100%" border="0" cellspacing="0" class="indtable">
  <tbody><tr>
    <th width="67%">标   题</th>
    <th width="14%">访问</th>
    <th width="19%">发布时间</th>
  </tr>
  <s:iterator value="enterInfos">
  <tr>
    <td><a href="<s:url namespace="/information/info" action="info!show"/>?requestId=${id}" target="_blank"><s:property value="title"/></a></td>
    <td class="fw"><s:property value="hits"/></td>
    <td><s:date name="createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:iterator>
</tbody>
</table>
</div>

<div class="play" id="con_ind_2" style="display: none; "><table width="100%" border="0" cellspacing="0" class="indtable">
  <tbody><tr>
    <th width="67%">标   题</th>
    <th width="14%">访问</th>
    <th width="19%">发布时间</th>
  </tr>
  <s:iterator value="chanceInfos">
  <tr>
    <td><a href="<s:url namespace="/information/info" action="info!show"/>?requestId=${id}" target="_blank"><s:property value="title"/></a></td>
    <td class="fw"><s:property value="hits"/></td>
    <td><s:date name="createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:iterator>
</tbody></table>
</div>
</div>
</div>



</div>
<div class="indright">
<div class="indrone">
	<div class="title4"><div class="nt4"><img src="../images/icon_down.jpg" align="absmiddle"/> 阅读推荐</div></div>
	<div class="indronecon1">
		<ul class="indlist2">
		<s:iterator value="recommendInfos">
		<li><a href="<s:url namespace="/information/info" action="info!show"/>?requestId=${id}" target="_blank"><s:property value="getTitleByLength(18)"/></a></li>
		</s:iterator>
		</ul>
		<div class="cls"></div>
	</div>
</div>

<e:adquery id="ad1" adId="118"/>
<div class="banind"><a id="118" rel="ad" target="_blank" href="<e:adlink name="ad1"/>"><img src="<e:adimg name="ad1"/>"  width="304" height="121"/></a></div>

<div class="indrone">
	<div class="title4"><div class="nt4"><img src="${ctx}/information/images/icon_down.jpg" align="absmiddle"/> 热点排行</div></div>
	<div class="indronecon1" style="padding-top:5px;">
		<div class="paiming" style="background:none;">
		<h1 style="width:270px;">
		<ul class="paiminglist">
		<s:iterator value="hotInfos">
		<li style="width: 250px;"><a href="<s:url namespace="/information/info" action="info!show"/>?requestId=${id}" target="_blank"><s:property value="getTitleByLength(18)"/></a></li>
		</s:iterator>		
		</ul>
		</h1>
	</div>
	</div>
</div>
</div>

</div>
<%-- main end --%>

<%-- 合作伙伴 begin  --%>
<s:action name="copartnership" namespace="/information/inc" executeResult="true">
	<s:param name="infoTypeId"><s:property value="infoType.id"/> </s:param>
</s:action>
<%-- 合作伙伴 end --%>

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
