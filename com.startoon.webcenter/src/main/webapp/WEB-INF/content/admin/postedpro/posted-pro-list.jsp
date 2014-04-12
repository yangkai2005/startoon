<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>title here</title>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/admin.css"/>
<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/myfunction.js"></script>
<script type="text/javascript">
$(document).ready(function(){

	$('#checkAll').click(function() {
		var ck = $(this).attr('checked');
		$('input[name=ids]').attr('checked', ck);
	});
	
	$('#pass').click(function() {
		var cbs = $('input[name=ids]:checked');
		if(cbs &&cbs.length>0) {
			$('#status').val(2);
			$('form#auditForm').submit();
		} else {
			alert('请选择要审核的记录');
		}
	});

	$('#unpass').click(function() {
		var cbs = $('input[name=ids]:checked');
		if(cbs &&cbs.length>0) {
			$('#status').val(1);
			$('form#auditForm').submit();
		} else {
			alert('请选择要审核的记录');
		}
	});
	
	
});
</script>
</head>
<body>
<div class="mTitle">
  <!--
  <span class="hidsearch"><a href="javascript:void(0)" onclick="return chg('searchList');" id="ImgArrow"><img src="${ctx}/resources/images/icon_down.gif" id ="imgButton" />展开搜索</a></span>
  -->
  <b class="bbig">采购信息管理</b>
</div>
<s:form  id="searchForm" action="posted-pro-list" namespace="/admin/postedpro">
<div class="searchBar" id="searchList" style="display:none;">
  <table class="searchTable">
  <tr>
    <th width="10%">xxx：</th>
    <td width="20%"><input name="" type="text" size="25" /></td>
	<th width="10%">xxx：</th>
    <td>
	</td>
  </tr>

  <tr>
    <th>&nbsp;</th>
    <td><button class="btn" type="submit">确定搜索</button></td>
  </tr>
  </table>
</div>
</s:form> 
 
<!--list -->
<div class="mainList">
<table class="listTable">
  <tr>
	<th>ID<input id="checkAll" type="checkbox" /></th>
	<th>类别</th>
	<th>采购名称</th>
	<th>采购数量</th>
	<th>期望价格</th>
	<th>创建时间</th>
	<th>状态</th>
    <th>操作</th>
  </tr>
  <s:form id="auditForm" namespace="/admin/postedpro" action="posted-pro!audit">
    <s:hidden id="status" name="status" />

  <s:iterator value="pager.items">
  <tr>  
  	<td> <input name="ids" type="checkbox" value="<s:property value='id'/>" /><s:property value="id"/> </td>
  	<td> <s:property value="category.name"/> </td>
  	<td> <s:property value="proName"/> </td>
  	<td> <s:property value="amount"/> </td>
  	<td> <s:property value="proPrice"/> </td>
  	<td> <s:date name="createTime" format="yyyy-MM-dd HH:mm"/> </td>
  	<td> <s:if test="status==0">未审核</s:if><s:elseif test="status==1">不通过</s:elseif><s:elseif test="status==2">通过</s:elseif><s:else>-</s:else> </td>
    <td> 
    	<a href="<s:url action="posted-pro!show" namespace="/admin/postedpro"/>?requestId=<s:property value="id"/>" target="_blank">详细</a>
    	<!-- 
    	<a href="<s:url action="posted-pro!delete" namespace="/admin/postedpro"/>?requestId=<s:property value="id"/>"  onclick="return confirmDel();">删除</a>  
    	 -->
    </td>
  </tr>
  </s:iterator>
  </s:form>
</table>
</div>
<!--end list -->
<div class="Toolbar">
  <div class="toolBt">
 	<!--
 		<a href="<s:url action="posted-pro!input" namespace="/admin/postedpro"/>" title="新建"><span class="btn">新建</span></a>
  -->
 		<a href="#" id="pass" title="通过"><span class="btn">通过</span></a>
 		<a href="#" id="unpass" title="不通过"><span class="btn">不通过</span></a>
  </div>
  <e:pagination></e:pagination>
</div>
 
</body>
</html>

