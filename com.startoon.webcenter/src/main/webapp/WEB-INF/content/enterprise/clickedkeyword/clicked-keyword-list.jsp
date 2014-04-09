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
<script type="text/javascript" src="${ctx}/resources/My97DatePicker/WdatePicker.js"></script>

<style type="">
.search-input {
width:100px; border:1px solid #9d9d9d; padding:1px; padding-left:1px;
}

</style>

<script type="text/javascript">
$(function(){
	$('h2#keyword3').addClass('q3');

	$('a[rel=bind]').click(function() {
		var id = $(this).attr('id');
		$.post('${ctx}/enterprise/enterprisekeyword/enterprise-keyword!bindToEnt.action', {kid: id}, function(data) {if(data=='success') {alert('该关键字已经绑定成功！');}});
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
		<s:form id="keySearchForm" name="keySearchForm" namespace="/enterprise/clickedkeyword" action="clicked-keyword-list">
		<table width="100%" border="0" cellspacing="0">
		  <tbody>
		  <tr>
		    <td width="12%" valign="top"><img src="${ctx}/images/searchtitle.jpg"/></td>
		    <td width="88%" valign="top">
		    	关 键 词：<input id="keyword" name="keyword" type="text" class="search-input" value="<s:property value="%{pager.paramCondition['keyword']}"/>" />
				&nbsp;&nbsp;
		    	点击类型：<select name="flag"><option value="">请选择</option><option value="0">产品</option><option value="1">企业</option> </select>
		    </td>
		  </tr>
		  <tr>
		    <td width="12%" valign="top">&nbsp;</td>
		    <td width="88%" valign="top">
		    	点击时间：<input name="stime" class="Wdate" onfocus="WdatePicker()" size="15" value="<s:property value="%{pager.paramCondition['stime']}"/>" />&nbsp;至&nbsp;<input name="etime" class="Wdate" onfocus="WdatePicker()" size="15" value="<s:property value="%{pager.paramCondition['etime']}"/>"/>
		    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    	<input id="keywordSearchBtn" type="button" class="btnsearch2" onclick="$('#keySearchForm').submit();"/>
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
	    <th width="15%" class="noleft">编号</th>
	    <th width="20%">关键词</th>
	    <th>绑定产品</th>
	    <th width="20%">点击时间</th>
	    <th width="10%">点击费用</th>
	    <th>点击类型</th>
	  </tr>
	  <s:iterator value="pager.items" status="st">
	  <tr>
	    <td class="noleft tdlist"> <s:property value="%{#st.count + (pager.pageNo-1)*pager.pageSize}"/> </td>
	    <td class="tdlist" align="center"><s:property value="keyword"/></td>
	    <td><a target="_blank" href="${ctx}/supply/supply-manage!detail.action?supplyId=${supply.id}"><s:property value="supply.name"/></a></td>
	    <td><s:date name="clickedTime" format="yyyy-MM-dd HH:mm"/></td>
	    <td> <s:property value="enterpriseKeyword.price"/>元/次 </td>
	    <td> <s:if test="flag==1"><b>企业</b>点击排名</s:if><s:else><b>产品</b>点击排名</s:else> </td>
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