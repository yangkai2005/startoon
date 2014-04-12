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
<script type="text/javascript" src="${ctx}/resources/js/jquery.example.min.js"></script>
<script type="text/javascript"> 
$(document).ready(function(){
	$('li#l11').addClass('hover');
	$('h2#h11').show();

	$('#searchKey').example('请输入关键字');
	
	$('a[rel=search]').click(function() {
		var name = $(this).attr('id');
		$('#searchKey').attr('name', name);
		$('#searchForm').sumit();
	});
	
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
	<div class="newsBoxBottom">
	<div class="newsBox">
		<div class="titleNews"><span>企业招聘</span></div>
		<div class="newsBoxCont">
			<ul class="jobList">
				<s:iterator value="pager.items">
				<li>
					<p class="titleComName"><a href="<s:url namespace="/enterprises" action="ent-hr"/>?enterpriseId=${enterprise.id}"target="_blank"><s:property value="enterprise.name"/></a><s:if test="isRecommend"><img src="../images/icon_tui.jpg"/></s:if></p>
					<p class="jobName"><a href="<s:url namespace="/information/hrservice" action="jobs!show"/>?requestId=${id}"target="_blank"><s:property value="name"/></a></p>
				</li>
				</s:iterator>
			</ul>
			<div class="cls"></div>
			<div class="pages"><e:pagination></e:pagination> </div>
		</div>
	</div>
	</div>
	
	<div class="right">
		<div class="jobSearch">
			<div class="title3"><div class="nt2">职位搜索</div></div>
			<div class="cls"></div>
			<form id="searchForm" action="${ctx}/information/hrservice/jobs-list.action">
			<table class="tableJobSearch">
			  <tbody>
			  <tr>
				<td><a id="q" href="javascript:void(0)">全文</a>&nbsp;&nbsp;
					<a id="name" href="javascript:void(0)">职位名</a>&nbsp;&nbsp;
					<a id="ename" href="javascript:void(0)">公司名</a> 
				</td>
			  </tr>
			  <tr>
				<td><input type="text" class="txtComName" name="q" id="searchKey"/></td>
			  </tr>
			  <tr>
				<td class="tr"><input type="submit" class="btnSearch" value="搜索"/></td>
			  </tr>
			</tbody>
			</table>
			</form>
		</div>

	<e:adquery id="rad1" adId="166"/>
	<div class="rban1">
	<a id="166" rel="ad" target="_blank" href="<e:adlink name="rad1"/>"><img src="<e:adimg name="rad1"/>" width="242" height="140"/></a>
	</div>
	
	<s:action namespace="/information/inc" name="info-hr" executeResult="true"></s:action>
	
	<e:adquery id="rad2" adId="167"/>
	<div class="rban1">
	<a id="167" rel="ad" target="_blank" href="<e:adlink name="rad2"/>"><img src="<e:adimg name="rad2"/>" width="242" height="140"/></a>
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
