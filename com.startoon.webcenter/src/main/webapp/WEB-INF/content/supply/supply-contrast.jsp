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

<link rel="stylesheet" type="text/css" href="${ctx}/css/index.css" />


<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<script type="text/javascript" src="${ctx}/js/cn_main.js"></script>
<script type="text/javascript" src="${ctx}/js/sh_scripts1.js"></script>
<script src="${ctx}/resources/js/jquery.js" type="text/javascript"></script>

<style type="text/css">
.mbtn2 {
BACKGROUND-IMAGE: url(../images/m_btn02.jpg);
BORDER-BOTTOM: 0px;
BORDER-LEFT: 0px;
WIDTH: 66px;
BACKGROUND-REPEAT: no-repeat;
HEIGHT: 26px;
BORDER-TOP: 0px;
CURSOR: pointer;
BORDER-RIGHT: 0px;
border-bottom: 0px;
border-left: 0px;
background-repeat: no-repeat;
border-top: 0px;
border-right: 0px;
}
</style>

</head>
<body>
<s:include value="/WEB-INF/content/inc/header.jsp"/>

<div class="main">
  <div class="title">
  <div class="titlemu">
  	<div class="indextitle">产品对比</div>
  </div>
  
  <div class="hotline"><img src="${ctx}/images/hotline.jpg"/></div>
  </div>
 <div align="left"><input type="button" class="mbtn2" value="打 印" onclick="window.print();"/>&nbsp;<input type="button" class="mbtn2" value=" 关  闭 " onclick="window.close();"/> </div>
  
 <div class="cls"></div>
 <div class="indexcon" style="width:998px; padding-left:0; padding-right:0;">
 	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="comtable">
  <tbody><tr>
    <td width="15%" class="cp1"><div class="cptitle1">产品基本信息：</div> </td>
    <td width="40%" class="cp2"><a target="_blank" href="${ctx}/supply/supply-manage!detail.action?supplyId=<s:property value='supply1.id'/>"><s:property value="supply1.name"/></a></td>
    <td width="45%" class="cp2"><a target="_blank" href="${ctx}/supply/supply-manage!detail.action?supplyId=<s:property value='supply2.id'/>"><s:property value="supply2.name"/></a></td>
  </tr>
  <tr>
    <td class="cpk1">产品图片</td>
    <td class="cpk2"><div class="imgk100x100"><a target="_blank" href="${ctx}/supply/supply-manage!detail.action?supplyId=<s:property value='supply1.id'/>"><img src="${ctx}/FileView?id=<s:property value='supply1.productImgUrl'/>" width="100" height="100"/></a></div></td>
    <td class="cpk2"><div class="imgk100x100"><a target="_blank" href="${ctx}/supply/supply-manage!detail.action?supplyId=<s:property value='supply2.id'/>"><img src="${ctx}/FileView?id=<s:property value='supply2.productImgUrl'/>" width="100" height="100"/></a></div></td>
  </tr>
  <tr>
    <td class="cpk1">产品报价</td>
    <td class="cpk2"><s:property value="supply1.proPrice"/>&nbsp;</td>
    <td class="cpk2"><s:property value="supply2.proPrice"/>&nbsp;</td>
  </tr>
  <tr>
    <td class="cpk1">发布企业</td>
    <td class="cpk2"><s:property value="supply1.creator.name"/>&nbsp;</td>
    <td class="cpk2"><s:property value="supply2.creator.name"/>&nbsp;</td>
  </tr>
  <tr>
    <td class="cpk1">品牌型号</td>
    <td class="cpk2"><s:property value="supply1.brand"/>&nbsp;</td>
    <td class="cpk2"><s:property value="supply2.brand"/>&nbsp;</td>
  </tr>
  
  <tr>
    <td class="cpk1">原产地</td>
    <td class="cpk2"><s:property value="supply1.source"/>&nbsp;</td>
    <td class="cpk2"><s:property value="supply2.source"/>&nbsp;</td>
  </tr>
  
  <tr>
    <td width="15%" class="cp1"><div class="cptitle1">参数信息：</div> </td>
    <td width="40%" class="cp2">&nbsp;</td>
    <td width="45%" class="cp2">&nbsp;</td>
  </tr>
  
  <tr>
    <td class="cpk1"></td>
    <td class="cpk2">
    	<table>
    		<s:iterator value="supply1.supplyParams">
    		<tr>
    			<td class=""><b><s:property value="pkey"/>：</b></td>
    			<td class=""><s:property value="pvalue"/> </td>
    		</tr>
    		</s:iterator>
    	</table>
    </td>
    <td class="cpk2">
    	<table>
    		<s:iterator value="supply2.supplyParams">
    		<tr>
    			<td class=""><b><s:property value="pkey"/>：</b></td>
    			<td class=""><s:property value="pvalue"/> </td>
    		</tr>
    		</s:iterator>
    	</table>
    </td>
  </tr>
  
  <tr>
    <td width="15%" class="cp1"><div class="cptitle1">详细信息：</div> </td>
    <td width="40%" class="cp2">&nbsp;</td>
    <td width="45%" class="cp2">&nbsp;</td>
  </tr>
  <tr>
    <td class="cpk1">产品详细信息:</td>
    <td class="cpk2">
	<div class="cpkdx"><s:property value="supply1.description" escape="html"/> </div>	
	</td>
    <td class="cpk2">
	<div class="cpkdx"><s:property value="supply2.description" escape="html"/> </div>	
	</td>
  </tr>
  
</tbody></table>
 
 </div>
</div>

<s:include value="/WEB-INF/content/inc/footer.jsp"/>
</body>
</html>