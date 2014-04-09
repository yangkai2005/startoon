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
<link rel="stylesheet" type="text/css" href="${ctx}/information/css/flash.css" />

<script type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>
<script type=text/javascript src="${ctx}/js/FusionCharts.js"></script>
<script type=text/javascript src="${ctx}/js/fun.js"></script>
<script type=text/javascript src="${ctx}/js/add.js"></script>

<script type="text/javascript"> 
$(document).ready(function(){
	$('li#l3').addClass('hover');
	$('h2#h3').show();

	$("#submit").click(function() {
		var radios = $(":radio:checked");
		var arr = new Array();
		for(i=0; i<radios.length; i++) {
			var id = $(radios[i]).val();
			arr.push(id);
		}
		var ids = arr.toString();
		$.post("${ctx}/information/survey/vote-option-detail!vote.action", {optionIds: ids}, function(data) {if(data=='success') {alert('投票成功，谢谢你的参与！'); location.reload();}});
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
	
		<div class="surde">
			
			
			<div class="surdeone">
				<div class="titlesur">
					<div class="sur1"><img src="../images/sur_icon1.gif" align="absmiddle"> <strong>行情调查</strong> <span class="Arial" style=" color:#cbe5f4">LATEST SURVEY</span></div>
				</div>
				
				<h1>
				<div class="surdebiaoti">
				<p class="f14 b red" align="center"><s:property value="surveyInfo.title"/> </p>
				<p><s:property value="surveyInfo.contentTxt"/></p>
				</div>
				<div class="surdiaochade">
			  <div class="vote-result">
			  

		<s:iterator value="surveyInfo.votes">
			<div class="surdede">
			<p><s:property value="title"/></p><br/>
			<ol class="olist">
			  <s:iterator value="voteOptions">
				  <li class="item"><div class="d d-tit"><span class="gd"><input type="radio" name="option_<s:property value="vote.id"/>" value="<s:property value="id"/>"/> <s:property value="optionContent"/> </span></div>
				  <div class="d d-prc">
				  <div class="bars">
				  <div style="width: <s:property value='formatPrecent'/>%; display: block; " class="precent" precent="<s:property value='formatPrecent'/>%"><img alt="" src="${ctx}/images/vote_cl_v2.png" width="149" height="13"/> 
				  </div></div><span class="precent-num">(<s:property value='formatPrecent'/>%)</span> </div>
				  <div class="d d-num"><s:property value='voteCount'/>票</div>
				  <div class="d d-from"></div>
				  </li>
				  <li style="DISPLAY: none" id="from_27522_host" class="item-area"></li>
			  </s:iterator>
			</ol>
			</div>
		</s:iterator>
  </div>
				<div class="cls"></div>
				<div class="surtijiaode"><input id="submit" type="button" class="btntijiao"/></div>	
				</div>
			
				</h1>
			
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
