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
<link href="../css/purchaseCenter.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="../css/member.css" />
<link rel="stylesheet" type="text/css" href="../css/common.css" />



<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<script type="text/javascript" src="${ctx}/js/dialog.js"></script>
<script language="javascript1.1" type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>

<link href="${ctx}/resources/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){
	$("h2#list").addClass("q3");
});
</script>
</head>

<body>

<%-- header --%>
<s:include value="/WEB-INF/content/inc/header.jsp"></s:include>
<%-- header --%>
  
<%-- main begin --%>
<div class="main">

<div class="member">

<%-- main left begin --%>
<s:include value="/WEB-INF/content/inc/person-left.jsp"/>
<%-- main left end --%>

<%-- main right begin --%>
<div class="memright">

	<s:include value="/WEB-INF/content/member/show/menu.jsp"/>
	 
	<div class="memcon">
		<div class="cytab" style="display: none;">
		<div class="cysearch">
		<input name="" type="text" class="cy1" value="请输入关键字查找相关图片..."/> <input name="" type="button" class="cy2" value="搜索"/>
		</div>
			<ul class="cytablist">
			<li onclick="setTab('cy',1,3)" id="cy1"><strong>相册</strong></li>
			<li class="hover" onclick="setTab('cy',2,3)" id="cy2"><strong>+上传照片</strong></li>
			<li onclick="setTab('cy',3,3)" id="cy3"><span class="lv b">管理</span>/<span class="lv b">发布</span>主题相册</li>
			</ul>
		</div>
		
		<div class="cycon">
		<div class="play" id="con_cy_1"></div>
		<div class="" id="con_cy_2">
			<div class="picsc">
			&nbsp;
			<h2>
			<ul class="picsclist">
			<s:iterator value="pager.items">
			<li><a href="<s:url namespace="/information/show" action="info!show"/>?requestId=<s:property value='id'/>" target="_blank"><img src="<s:property value='mainImg.smallImg'/>" width="118" height="118"/><s:property value="getTitleByLength(8)"/></a></li>
			</s:iterator>
			</ul>
			
			</h2>
			<h3><e:pagination/></h3>
			
			</div>
			
		
		</div>
		<div class="play" id="con_cy_3"></div>
		</div>
	
	</div> 

</div>
<%-- main right end --%>

</div>

<div class="cls"></div>
<div class="cls"></div>

</div>
<%-- main end --%>
  
<%-- footer --%>
<s:include value="/WEB-INF/content/inc/footer.jsp"/>
<%-- footer --%>
	
</body>
</html>