<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="org.j2eeframework.commons.pager.Pager"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="keywords" content="星力网，游戏机供应，游戏机采购，动漫游戏资讯，动漫游戏展会，卖游戏机"/>
<meta http-equiv="description" content="星力网是广州星力动漫科技有限公司打造的动漫游戏行业最专业的游戏机供应、游戏机采购平台，提供最新、最全的游艺产品、游戏产品、电玩产品、游戏机配件、电脑板、框体机、模拟机等供应信息、采购信息，星力网资讯频道为行业提供最专业的动漫游戏行业资讯、行业新闻。"/>
<title>星力网_中国动漫游艺门户_动漫游戏产品网络交易平台_动漫游戏行业资讯</title>

<link rel="stylesheet" type="text/css" href="${ctx}/css/member.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />

<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>

<script type="text/javascript">

$(function() {
	<s:if test="msg=='1'">alert('你已经购买了该关键字，不能重复购买！');</s:if>
	var s = '<s:property value="errorCode" escape="HTML"/>';
	if(s!='') {alert(s);}
	
	$('#buykey').click(function() {
		$('#ekForm1').submit();
	});

	$(':radio[name=count]').click(function() {
		var d3 = <s:property value="keyword.discount3"/>;
		var d6 = <s:property value="keyword.discount6"/>;
		var d12 = <s:property value="keyword.discount12"/>;

		var d = $(this).val();
		var price = <s:property value="keyword.minPrice"/>;
		var discount = (d==3)?d3:(d==6?d6:d12);
		var totalPrice = price;
		if(d!=1)
			totalPrice = price * d * discount * 0.1;
		$('b#totalPrice').html(totalPrice);
	});
	
});
</script>

</head>
<body>
<s:include value="/WEB-INF/content/inc/header.jsp"/>
<div class="member">
	<s:include value="/WEB-INF/content/inc/member-left.jsp"/>
	<%-- 列表管理 --%>
<div class="memright">
<div class="title4"> <div class="hotline">客服热线：020-39106666</div>
	 <div class="titlemu2">
	
	 
	 <h2 class="q3">企业关键词竞价</h2> 
	 
	
	 </div>
	 </div>
	 
	<div class="memcon">
	 	
		<div class="sicon2">

		<div class="sititle2"><div class="s2 red">类别关键字购买</div></div>
		
		<div class="overtime b">
		<s:property value="errorCode"/>
		</div>	
			
		<div class="sibuy">
		<s:form id="ekForm1" namespace="/enterprise/enterprisecategorykeyword" action="enterprise-category-keyword!insert">
		<input type="hidden" name="categoryKeyword.id" value="<s:property value='keyword.id'/>"/>
		<input type="hidden" name="price" value="<s:property value='keyword.minPrice'/>"/>
		<table width="100%" border="0" cellspacing="0" class="tablebuy">
		  <tbody>
		  <tr>
		    <td colspan="2">类别关键字：<b><s:property value="keyword.category.name"/></b> </td>
		  </tr>
		  <tr>
		    <td colspan="2" style="padding-top:5px;" class="red">关键字排名：第<s:property value="keyword.rank"/>名</td>
		  </tr>
		  <tr>
		    <td colspan="2" style="padding-top:5px;" class="red">关键词价格：<s:property value="keyword.minPrice"/>元/月</td>
		  </tr>
		  <tr>
		    <td colspan="2" style="padding-top:5px;" class="red">关键词总价：<b id="totalPrice"><s:property value="keyword.minPrice"/></b>元</td>
		  </tr>
		  	<tr>
		   	<td colspan="2" ><font class="red">使用期限：</font><input type="radio" id="" name="count" value="1" checked="checked"/>1个月<input type="radio" id="" name="count" value="3"/>3个月<input type="radio" id="" name="count" value="6"/>6个月<input type="radio" id="" name="count" value="12"/>1年 </td>
		    </tr>
		  <tr>
		    <td colspan="2" style="padding-top:12px;"><a href="javascript:void(0)" id="buykey"><img src="${ctx}/images/buysure.jpg" width="82" height="28" alt=""/></a></td>
		    </tr>
		  </tbody>
		</table>
		</s:form>

		
		</div>	
		
		<div class="jingjiaxz">
		<s:property value="news.content" escape="html"/>	
		</div>
		
		</div>
	 
	 
	</div>
	 
</div>	
	<%-- 列表管理 --%>
</div>

<div class="cls"></div>
<div style="clear:both;"></div>

<s:include value="/WEB-INF/content/inc/footer.jsp"/>
</body>
</html>