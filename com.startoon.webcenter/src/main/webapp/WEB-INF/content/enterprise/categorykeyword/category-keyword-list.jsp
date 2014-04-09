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
<script type="text/javascript" src="${ctx}/resources/js/jquery.example.min.js"></script>

<script type="text/javascript">
$(function(){
	$('h2#keyword1').addClass('q3');
	if('<s:property value="pager.paramCondition['ec']"/>'=='1') {
		alert('你已经购买了该关键字，不能重复购买！');
	}
	$('#keyword').example('请输入关键词');

	$("#keywordSearchBtn").click(function() {
		$("#keySearchForm").submit();
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
	 
	<s:include value="/WEB-INF/content/enterprise/categorykeyword/menu.jsp"></s:include>
	 
	<div class="memcon">
		<div class="jingjiasearch">
		<s:form id="keySearchForm" name="keySearchForm" namespace="/enterprise/categorykeyword" action="category-keyword-list">
		<table width="100%" border="0" cellspacing="0" height="30">
		  <tbody>
		  <tr>
		    <td width="12%" valign="top"><img src="${ctx}/images/searchtitle.jpg"/></td>
		    <td width="88%" valign="top">
		    	<input id="keyword" name="q" type="text" style="width:230px; border:1px solid #9d9d9d; padding:1px; padding-left:5px;" value="<s:property value="%{pager.paramCondition['q']}"/>" />
		    	<input id="keywordSearchBtn" type="button" class="btnsearch2"/>
		    </td>
		  </tr>
		  </tbody>
		</table>
		</s:form>
		</div>
	 	
<div class="sicon2">
<div class="sitab">
<table width="100%" border="0" cellspacing="0" bgcolor="#d7e2ec" class="sitable">
  <tbody><tr>
	    <th width="8%" class="noleft">位置</th>
	    <th width="15%">关键字</th>
	    <th width="8%">购买</th>
	    <th width="10%">到期日期</th>
	    <th width="10%">价格</th>
	    <th width="10%">3个月折扣</th>
	    <th width="10%">6个月折扣</th>
	    <th width="10%">一年折扣</th>
		<th width="15%">操 作</th>
  </tr>
  <s:iterator value="pager.items">
  <tr>
    <td class="noleft tdlist">  第<s:property value="rank"/>位 </td>
    <td> <s:property value="category.name"/> </td>
    <td> <s:if test="status==2"><font color="color">已购买</font></s:if><s:else>未购买</s:else> </td>
    <td> <s:if test="status==2"> <s:date name="etime" format="yyyy-MM-dd"/> </s:if><s:else>-</s:else> </td>
    <td><s:property value="minPrice"/>元</td>
    <td><s:property value="discount3"/>折</td>
    <td><s:property value="discount6"/>折</td>
    <td><s:property value="discount12"/>折</td>
	<td>
		<s:if test="status!=2">
		<a href="${ctx}/enterprise/enterprisecategorykeyword/enterprise-category-keyword!input.action?ckid=${id}">购买</a>
		</s:if>
		<s:else>-</s:else>
	</td>
  </tr>
  </s:iterator>
</tbody>
</table>
</div>
<div class="pagessi"><e:pagination></e:pagination> </div>		
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