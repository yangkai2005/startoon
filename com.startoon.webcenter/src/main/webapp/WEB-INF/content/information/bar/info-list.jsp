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
	$('li#l5').addClass('hover');
	
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
	<div class="barleft">

		<div class="barcon">
			<div class="bartab">
			<h1><div class="more10 f14"></div>【 <s:property value="infoType.name"/> 】</h1>
			<h2>
			<table width="100%" border="0" class="bartable" cellspacing="0">
			  <tbody><tr>
			    <th width="61%">标   题</th>
			    <th width="15%">作  &nbsp;者</th>
			    <th width="12%">访问</th>
			    <th width="12%">发布时间</th>
			  </tr>
			  <s:iterator value="pager.items">
			  <tr>
			    <td><a href="${ctx}/information/info/info!show.action?requestId=${id}" target="_blank"><s:property value="title"/></a></td>
			    <td><s:property value="creatorName"/>&nbsp;</td>
			    <td style="color:#7c5d32"><s:property value="hits"/></td>
			    <td style="color:#7c7c7c"> <s:date name="createTime" format="yyyy-MM-dd"/> </td>
			  </tr>
			  </s:iterator>  			  
			</tbody>
			</table>
			
			</h2>
			<e:pagination></e:pagination>
			</div>
		
		</div>
	
	</div>
	
	<div class="barright">
		<e:adquery id="rad1">
			<jsp:attribute name="infoTypeId">${infoType.id}</jsp:attribute>
			<jsp:attribute name="index">2</jsp:attribute>
		</e:adquery>
		<div class="barban1"><a id="225" rel="ad" href="<e:adlink name="rad1"/>"><img src="<e:adimg name="rad1"/>" width="238" height="104"/></a></div>
		<div class="barrightcon">
			<div class="bartitle2">
				<div class="bar1"><img src="../images/bar_t.jpg" align="absmiddle"/> 热帖排行</div>
			</div>
			<h1>
			<ul class="barlist">
			<s:iterator value="hotInfos">
			<li><a href="${ctx}/information/info/info!show.action?requestId=${id}"  target="_blank"><s:property value="shortTitle15"/></a></li>
			</s:iterator>				
			</ul>
			</h1>
			<e:adquery id="rad2">
				<jsp:attribute name="infoTypeId">${infoType.id}</jsp:attribute>
				<jsp:attribute name="index">3</jsp:attribute>
			</e:adquery>
			<h2><a id="${__ad_rad2.id }" rel="ad" href="<e:adlink name="rad2"/>"><img src="<e:adimg name="rad2"/>" width="238" height="104"/></a></h2>		
		
		</div>
		
		<div class="barrightcon" style="margin-top:6px;">
			<div class="bartitle2">
				<div class="bar1"><img src="../images/bar_t.jpg" align="absmiddle"/> 最新话题</div>
			</div>
			<h1>
			<ul class="barlist">
			<s:iterator value="latestInfos">
			<li><a href="${ctx}/information/info/info!show.action?requestId=${id}" target="_blank"><s:property value="shortTitle15"/></a></li>
			</s:iterator>			
			</ul>
			</h1>
			<h2>
			<e:adquery id="rad3">
				<jsp:attribute name="infoTypeId">${infoType.id}</jsp:attribute>
				<jsp:attribute name="index">4</jsp:attribute>
			</e:adquery>
			<e:adquery id="rad4">
				<jsp:attribute name="infoTypeId">${infoType.id}</jsp:attribute>
				<jsp:attribute name="index">5</jsp:attribute>
			</e:adquery>
			<e:adquery id="rad5">
				<jsp:attribute name="infoTypeId">${infoType.id}</jsp:attribute>
				<jsp:attribute name="index">6</jsp:attribute>
			</e:adquery>
			<a id="${__ad_rad3.id }" rel="ad" href="<e:adlink name="rad3"/>"><img src="<e:adimg name="rad3"/>" width="238" height="104"/></a>					
			<a id="${__ad_rad4.id }" rel="ad" href="<e:adlink name="rad4"/>"><img src="<e:adimg name="rad4"/>" width="238" height="104"/></a>					
			<a id="${__ad_rad5.id }" rel="ad" href="<e:adlink name="rad5"/>"><img src="<e:adimg name="rad5"/>" width="238" height="104"/></a>					
			</h2>
		
		</div>
		
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
