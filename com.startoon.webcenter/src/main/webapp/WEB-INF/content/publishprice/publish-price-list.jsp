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
<meta http-equiv="description" content="星力网是广州星力动漫游戏产业园打造的动漫游戏行业最专业的游戏机供应、游戏机采购平台，提供最新、最全的游艺产品、游戏产品、电玩产品、游戏机配件、电脑板、框体机、模拟机等供应信息、采购信息，星力网资讯频道为行业提供最专业的动漫游戏行业资讯、行业新闻。"/>
<title>星力网_中国动漫游艺门户_动漫游戏产品网络交易平台_动漫游戏行业资讯</title>

<link rel="stylesheet" type="text/css" href="${ctx}/css/member.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />

<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>

<script type="text/javascript">
$(function() {
	$("h2#publishprice").addClass("q3");
});
</script>

</head>
<body>
<s:include value="/WEB-INF/content/inc/header.jsp"/>
<s:include value="/WEB-INF/content/inc/member-left.jsp"/>

<%-- 列表管理 --%>
<div class="memright">
	<div class="title4">
		<div class="hotline">客服热线：020-39106666</div>
		<s:include value="/WEB-INF/content/enterprise/message/menu.jsp"></s:include>
	</div>
	 
	<div class="memcon3">
	<div class="cls"></div>
	<table width="100%" border="0" cellspacing="1" class="xinxitable" bgcolor="#ebebeb">
  <tbody><tr>
    <th width="8%">起订量</th>
    <th width="8%">价     格</th>
    <th width="8%">付款方式</th>
    <th>补充信息</th>
    <th width="8%">操作</th>
  </tr>
  <s:iterator value="pager.items">
  <tr>
    <td><s:property value="min"/></td>
    <td><s:property value="price"/></td>
    <td><s:property value="payType"/></td>
    <td><s:property value="content"/></td>
    <td><a href="${ctx}/enterprise/publishprice/publish-price1!delete.action?requestId=<s:property value='id'/>">删除</a></td>
  </tr>
  </s:iterator>
</tbody></table>

	</div>
	 
	 

</div>
<%-- 列表管理 --%>

<div class="cls"></div>
<div style="clear:both;"></div>

<s:include value="/WEB-INF/content/inc/footer.jsp"/>
</body>
</html>