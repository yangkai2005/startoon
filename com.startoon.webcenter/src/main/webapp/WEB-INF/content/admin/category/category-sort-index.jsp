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

<link rel="stylesheet" href="${ctx}/resources/jquery-ui-1.8.9/css/ui-lightness/jquery-ui-1.8.9.custom.css"/> 
<link href="${ctx}/resources/css/admin.css" rel="stylesheet" type="text/css" />

<script src="${ctx}/resources/js/jquery.js" type="text/javascript"></script>
<script src="${ctx}/resources/jquery-ui-1.8.9/js/jquery-1.4.4.min.js" type="text/javascript"></script>
<script src="${ctx}/resources/jquery-ui-1.8.9/js/jquery-ui-1.8.9.custom.min.js" type="text/javascript"></script>

<style> 
	#sortable { list-style-type: none; margin: 0; padding: 0; width: 60%; }
	#sortable li { margin: 0 3px 3px 3px; padding: 0.4em; padding-left: 1.5em; font-size: 1.4em; height: 18px; }
	#sortable li span { position: absolute; margin-left: -1.3em; }
</style> 

<script> 
$(function() {
	$( "#sortable" ).sortable();
	$( "#sortable" ).disableSelection();

	$('#submit').click(function() {
		var arr = new Array();
		$('li[lang=ids]').each(function(index) {
			arr.push(index + '-' + $(this).attr('id'));
		});
		var ids = arr.toString();
		$('input[name=sortIds]').val(ids);
		$('form').submit();
	});
});


</script> 
</head>
<body> 

<div class="mTitle">
  <b class="bbig">类别排序</b>
</div>

 
<!--list -->
<div class="mainList">

<div class="demo"> 
 
<ul id="sortable">
	<s:iterator value="categories">
	<li lang="ids" class="ui-state-default" id="<s:property value="id"/>"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span><s:property value="name"/> </li>
	</s:iterator> 
</ul> 
 
</div><!-- End demo --> 
 
 
 
<div class="demo-description"> 
<p> 
请用鼠标拖动分类进行排序！
</p> 
</div><!-- End demo-description --> 
 
<form action="${ctx}/admin/category/category-sort!sort.action" method="post">
<input type="hidden" name="sortIds"/>
</form>

</div>
<!--end list -->
<div class="Toolbar">
  <div class="toolBt">
 		<a id="submit" href="#" title="提交"><span class="btn">提交</span></a>
 		<a href="<s:url action="category-list" namespace="/admin/category"/>" title="返回"><span class="btn">返回</span></a>
  </div>
</div>
</body> 
</html>