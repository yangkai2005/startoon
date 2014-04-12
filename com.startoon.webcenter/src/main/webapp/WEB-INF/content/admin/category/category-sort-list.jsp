<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>

<script src="${ctx}/resources/jquery-ui-1.8.9/js/jquery-1.4.4.min.js" type="text/javascript"></script>

<link rel="stylesheet" href="${ctx}/resources/jquery-ui-1.8.9/css/ui-lightness/jquery-ui-1.8.9.custom.css"/> 
<link href="${ctx}/resources/css/admin.css" rel="stylesheet" type="text/css" />

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

});
</script> 

<ul id="sortable">
	<s:iterator value="categories">
	<li lang="ids" class="ui-state-default" id="<s:property value="id"/>"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span><s:property value="name"/> </li>
	</s:iterator> 
</ul> 