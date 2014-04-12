<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="keywords" content="${seoStr},星力网，游戏机供应，游戏机采购，动漫游戏资讯，动漫游戏展会，卖游戏机"/>
<meta http-equiv="description" content="${postedPro.proName}、星力网是广州星力动漫游戏产业园打造的动漫游戏行业最专业的游戏机供应、游戏机采购平台，提供最新、最全的游艺产品、游戏产品、电玩产品、游戏机配件、电脑板、框体机、模拟机等供应信息、采购信息，星力网资讯频道为行业提供最专业的动漫游戏行业资讯、行业新闻。"/>
<title>${postedPro.proName}_星力网_中国动漫游艺门户_动漫游戏产品网络交易平台_动漫游戏行业资讯</title>

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

function doFavorite(){
	var url = "${pageContext.request.contextPath}/enterprise/favorite/favorite!add.action";
	 var html = $.ajax({
		  url: url,
		  data:"fid=${postedPro.id}&type=1&t="+new Date().getTime(),
		  async: false
		 }).responseText;
	 if (html=="success"){
		 alert('恭喜,收藏成功!');
	 } 
}
</script>

</head>
<body>
<s:include value="/WEB-INF/content/inc/header.jsp"/>
<!--main star-->
<div class="main">

<div class="qycurr" style="border-top:1px solid #f3861b">
<h1>您当前的位置：<a href="${ctx}/index.action">首 页</a>&gt;<a href="${ctx}/postedpro/posted-pro1-list.action">采购</a>&gt;采购详细</h1>
</div>

<%-- main begin --%>

<div class="cls"></div>
<!-- //caigou about -->
<div class="cgleft">
	<div class="cagone">
		<table width="100%" border="0" cellspacing="0">
  <tbody><tr>
    <td colspan="2" class="f14 b">求&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;购:<font class="f18 b">&nbsp;&nbsp;<s:property value="postedPro.proName" /></font></td>
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
    <td><span class="f96"><s:property value="postedPro.proPrice"/>元</span> <a href="${ctx}/publishprice/publish-price!input.action?pid=<s:property value="postedPro.id"/>&receiverId=<s:property value='postedPro.creator.id'/>" target="_blank" style="margin-left:90px;"><img src="${ctx }/images/Btn_wybj.jpg" width="134" height="31" style="vertical-align:middle;"/></a>
    &nbsp;&nbsp;
    <s:if test="#session.enterprise_user!=null">
	<a style="color:red;font-weight:bold;text-decoration:underline;" href="#" onclick="doFavorite();">我要收藏</a>
	</s:if>
	<s:else>
	<a style="color:red;font-weight:bold;text-decoration:underline;" href="#" onclick="alert('请先登录后再收藏!');">我要收藏</a>
	</s:else>
    </td>
  </tr>
</tbody>
</table>

	
	</div>
	
	<div class="cagtwo">
		<strong class="f14">详细信息：</strong><s:property value="postedPro.description" escape="HTML"/>
		<br/>
		<p><span class="contactmsg">联系我时,请说明是在星力网看到的,谢谢！</span></p>
	</div>
	
	<div class="cgoutitle"><div class="vt1">相关采购信息</div></div>
	<div class="cgounews">
		<ul class="cgnewslist">
		<s:iterator value="relationPostedPros">
		<li><div class="f_r"><s:date name="createTime" format="yyyy-MM-dd" /></div><a href="${ctx}/postedpro/posted-pro!detail.action?requestId=<s:property value="id"/>"><s:property value="proName"/></a></li>
		</s:iterator>
		</ul>
	</div>
</div>

<div class="cgright">
	<div class="cgtitle"><div class="vt2">最新采购信息</div></div>
	<div class="cgrcon">
		<ul class="cgnewslist">
		<s:iterator value="latestPostedPros">
		<li><div class="f_r"><s:date name="createTime" format="yyyy-MM-dd" /></div><a href="${ctx}/postedpro/posted-pro!detail.action?requestId=<s:property value="id"/>"><s:property value="proName"/></a></li>
		</s:iterator>		
		</ul>
	</div>
	
	<div class="cgtitle"><div class="vt2">最新供应信息</div></div>
	<div class="cgrcon">
		<ul class="cgnewslist">
		<s:iterator value="latestSupplies">
		<li><div class="f_r"><s:date name="createTime" format="yyyy-MM-dd" /></div><a href="${ctx}/supply/supply-manage!detail.action?supplyId=<s:property value="id"/>"><s:property value="name"/></a></li>
		</s:iterator>		
		</ul>
	</div>

</div>


<%-- main end --%>

<div class="cls"></div>

<s:include value="/WEB-INF/content/inc/footer.jsp"/>
</body>
</html>