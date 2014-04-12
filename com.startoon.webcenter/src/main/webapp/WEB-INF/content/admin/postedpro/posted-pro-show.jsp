<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

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

<script type="text/javascript"> 
$(document).ready(function(){
	$('#type').val(2);
	$('#searchSupply').removeClass('searin');
	$('#postedProSearch').removeClass('search').addClass('searin');

});
</script>

</head>
<body>
<!--main star-->
<div class="main">

<%-- main begin --%>

<div class="cls"></div>
<!-- //caigou about -->
<div class="cgleft">
	<div class="cagone">
		<table width="100%" border="0" cellspacing="0">
  <tbody><tr>
    <td colspan="2" class="f18 b">采购产品:<s:property value="postedPro.proName" /></td>
    </tr>
  <tr>
    <td width="12%" class="f14 b">开始日期:</td>
    <td width="88%"><s:date name="postedPro.startTime" format="yyyy-MM-dd"/></td>
  </tr>
  <tr>
    <td class="f14 b">结束日期:</td>
    <td><span class="f96"><s:date name="postedPro.endTime" format="yyyy-MM-dd"/></span></td>
  </tr>
  <tr>
    <td class="f14 b">交货地点:</td>
    <td><s:property value="postedPro.tradeAddress" /></td>
  </tr>
  <tr>
    <td class="f14 b">期望价格：</td>
    <td><span class="f96"><s:property value="postedPro.proPrice"/>元</span> </td>
  </tr>
</tbody>
</table>

	
	</div>
	
	<div class="cagtwo">
		<strong class="f14">详细信息：</strong><s:property value="postedPro.description" escape="HTML"/>
	</div>
	
</div>


<%-- main end --%>
</body>
</html>