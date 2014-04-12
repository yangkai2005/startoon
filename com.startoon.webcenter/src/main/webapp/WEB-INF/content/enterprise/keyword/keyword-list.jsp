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
	/**
	if('<s:property value="pager.paramCondition['ec']"/>'=='1') {
		alert('你已经购买了该关键字，不能重复购买！');
	} */
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
	 
	<s:include value="/WEB-INF/content/enterprise/keyword/menu.jsp"></s:include>
	 
	<div class="memcon">
		<div class="jingjiasearch">
		<s:form id="keySearchForm" name="keySearchForm" namespace="/enterprise/keyword" action="keyword-list">
		<table width="100%" border="0" cellspacing="0" height="30">
		  <tbody>
		  <tr>
		    <td width="12%" valign="top"><img src="${ctx}/images/searchtitle.jpg"/></td>
		    <td width="88%" valign="top">
		    	<input id="keyword" name="keyword" type="text" style="width:230px; border:1px solid #9d9d9d; padding:1px; padding-left:5px;" value="<s:property value="%{pager.paramCondition['keyword']}"/>" />
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
    <th width="16%" class="noleft">产品关键词</th>
    <th width="36%">买家搜索次数</th>
    <th width="17%">当前最高价</th>
	<th width="15%">操 作</th>
  </tr>
  <s:iterator value="pager.items">
  <tr>
    <td class="noleft tdlist"> <s:property value="keyword"/> </td>
    <td class="tdlist">买家搜索<s:property value="searchTimes"/>次</td>
    <td><s:property value="currentPrice"/>元</td>
	<td>
		<a href="${ctx}/enterprise/enterprisekeyword/enterprise-keyword!input.action?kid=${id}">我要竞价</a>
		<%--
		<s:if test="valid">
		<a href="${ctx}/enterprise/enterprisekeyword/enterprise-keyword!input.action?kid=${id}">我要竞价</a>
		</s:if>
		<s:else><font color="#FF0000">已经过期</font></s:else>
		 --%>
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