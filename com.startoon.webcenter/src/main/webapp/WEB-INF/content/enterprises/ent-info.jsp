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

<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/storefronts.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />

</head>

<body>

<s:include value="/WEB-INF/content/inc/nav.jsp"></s:include>

<div id="wrap">
	<div class="ban">   		  
		<s:include value="banner.jsp"></s:include>
	</div>

<div class="cls"></div>

<div class="curr">您当前的位置：<a href="${ctx}/index.action">首 页</a> &gt; <a href="${ctx}/enterprises/ent-index.action?enterpriseId=<s:property value="enterprise.id"/>"><s:property value="enterprise.name"/></a> &gt; 公司首页</div>

<!--main star-->
<div class="main">

<!-- //left star-->
<s:include value="/WEB-INF/content/inc/ent-left.jsp"></s:include>
<!-- //left over-->

<%-- main begin --%>
<div class="right">

<div class="title3">
<div class="titlemu">
	<h1>公司信息</h1>
</div>
</div>

<div class="mconter3">
	<div class="detail" style="padding-top:0">
	<div class="chakan" id="kan1" style="height: auto;">
	    <img width="181" height="131" src="<s:property value='entInfo.logo'/>" style="float:left; margin-right:25px; border:1px solid #dbdbdb; padding:1px;" />${entInfo.indexContent }
	</div>

	<div class="gongxishow">
	<table width="100%" border="0" cellspacing="1" class="gstable">
	  <tr>
	    <td width="17%" class="tdgs">公司名称：</td>
	    <td width="33%"><s:property value='enterprise.name'/>&nbsp;</td>
	    <td width="17%" class="tdgs">公司规模：</td>
	    <td width="33%"><s:property value='enterprise.scale'/>&nbsp;</td>
	  </tr>
	  <tr>
	    <td class="tdgs">成立时间：</td>
	    <td> <s:date name="enterprise.ctime" format="yyyy年MM月dd日"/>&nbsp;</td>
	    <td class="tdgs">经营模式：</td>
	    <td><s:property value='enterprise.manageType'/>&nbsp;</td>
	  </tr>
	  <tr>
	    <td height="26" class="tdgs">厂房面积：</td>
	    <td><s:property value='enterprise.acreage'/>&nbsp;</td>
	    <td class="tdgs">年营业额</td>
	    <td><s:property value='enterprise.turnover'/>&nbsp;</td>
	  </tr>
	  <tr>
	    <td class="tdgs">年进口额：</td>
	    <td><s:property value='enterprise.ins'/>&nbsp;</td>
	    <td class="tdgs">年出口额：</td>
	    <td><s:property value='enterprise.outs'/>&nbsp;</td>
	  </tr>
	  <tr>
	    <td class="tdgs">主营业务：</td>
	    <td><s:property value='enterprise.business'/>&nbsp;</td>
	    <td class="tdgs">经营品牌：</td>
	    <td><s:property value='enterprise.brand'/>&nbsp;</td>
	  </tr>
	  <tr>
	    <td class="tdgs">主客户群：</td>
	    <td><s:property value='enterprise.clients'/>&nbsp;</td>
	    <td class="tdgs">主要市场：</td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td class="tdgs">公司电话：</td>
	    <td><s:property value='enterprise.telephone'/>&nbsp;</td>
	    <td class="tdgs">公司网站：</td>
	    <td><a href="<s:property value='enterprise.stdSiteUrl'/>" target="_blank"><s:property value='enterprise.siteUrl'/></a>&nbsp;</td>
	  </tr>
	  <tr>
	    <td class="tdgs">开户银行：</td>
	    <td><s:property value='enterprise.bank'/>&nbsp;</td>
	    <td class="tdgs">帐号：</td>
	    <td><s:property value='enterprise.bankAccount'/>&nbsp;</td>
	  </tr>
	</table>
	</div>

	

	

	</div> 



 



 </div>

 

 









</div>

<%-- main begin --%>

</div>
<div class="cls"></div>

<%-- footer begin --%>
<s:include value="/WEB-INF/content/inc/copyright.jsp"></s:include>
<%-- footer begin --%>
</body>
</html>