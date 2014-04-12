<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@page import="org.j2eeframework.startoon.service.HotKeyService"%>
<%@page import="org.j2eeframework.commons.util.SystemContext"%>
<%@page import="java.util.List"%>
<%@page import="org.j2eeframework.startoon.entity.HotKey"%>

<%
HotKeyService hotKeyService = SystemContext.getApplicationContext().getBean(HotKeyService.class);
List<HotKey> hotKeies = hotKeyService.getHotKey(5);
%>

<script type="text/javascript" src="${ctx}/resources/js/jquery.example.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	$('input#searchKey').example('请输入您要查询的内容...');
	
	$('a[rel=search]').click(function() {
		$('li[rel=search]').removeClass('searin');
		$(this).parent().addClass('searin');
	});

	$('#search').click(function() {
		var key = $.trim($('#searchKey').val());
		if(key=="" || '请输入您要查询的内容...'==key) {
			alert('你还没有输入查询的内容！');
			return false;
		}
		
		$('#searchForm').submit();
		
	});

	$('#searchProduct').click(function() {
		$('#searchForm').attr('action', '${ctx}/supply/supply-list.action');	
	});

	$('#searchEnterprise').click(function() {
		$('#searchForm').attr('action', '${ctx}/enterprises/enterprise-list.action');	
	});

	$('#searchPost').click(function() {
		$('#searchForm').attr('action', '${ctx}/postedpro/posted-pro-list.action');	
	});
});

	function setAction(){
		var type = '${type}';
		if(type=="")
			type = $(':hidden#type').val(); 
		if(type=="1"){
			$('#searchForm').attr('action', '${ctx}/enterprises/enterprise-list.action');
		} else if(type=='2') {
			$('#searchForm').attr('action', '${ctx}/postedpro/posted-pro1-list.action');
		} else {
			$('#searchForm').attr('action', '${ctx}/supply/supply-list.action');
		}
	}
</script>

<div id="wrap">
<div class="head">

<div class="logo">
	<a href="${ctx}/index.action"><img src="${ctx}/images/logo.jpg" title="广州力凯信息科技有限公司"/></a>
</div>

<div class="search">
<h1>
<ul>
	<li class="searin" rel="search" id="searchSupply"><a id="searchProduct" rel="search" href="${ctx}/index.action?type=0">产品</a></li>
	<li rel="search" id="liEnt"><a id="searchEnterprise" rel="search" href="${ctx}/index.action?type=1">企业</a></li>
	<li rel="search" id='postedProSearch'><a id="searchPost" rel="search" href="${ctx}/postedpro/posted-pro-list.action">采购</a></li>
</ul>
</h1>

<div class="cls"></div>

<form id="searchForm" name="searchForm" onsubmit="setAction();" action="${ctx}/supply/supply-list.action" method="get">
<h2>
	<input type="hidden" id="type" name="type" value="${type }"/>
	<input id="searchKey" name="searchKey" type="text" class="txt1"/>
	<input id="search" name="search" type="button" class="btnsearch" />
</h2>
</form>

<div class="cls"></div>

<div class="hotsearch">
	热搜：
	<% for(HotKey key : hotKeies) {
		String k = key.getName();
	%>
		<a target="_blank" href="${ctx}/supply/supply-list.action?searchKey=<%=k %>"><%=k %></a>
	<% } %>
</div>

</div>

<div class="zixunmh">
	<a href="${ctx}/information/index.action" target="_blank"><img src="${ctx}/images/menhu.jpg" /></a>
</div>

</div>

<div class="cls"></div>