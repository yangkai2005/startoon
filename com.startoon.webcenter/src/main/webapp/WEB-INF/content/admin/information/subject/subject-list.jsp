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
	$('a[rel=online]').click(function() {
		var sid = $(this).attr('id');
		$.get('${ctx}/admin/information/subject/subject!online.action', 
				{requestId:sid, r:(new Date()).getTime()}, 
				function(data) {
					if(data=='success') {
						alert('上线成功'); 
						window.location.reload();
					} else {
						alert('上线失败');
					}
				});
	});
	$('a[rel=offline]').click(function() {
		var sid = $(this).attr('id');
		$.get('${ctx}/admin/information/subject/subject!offline.action', 
				{requestId:sid, r:(new Date()).getTime()}, 
				function(data) {
					if(data=='success') {
						alert('下线成功'); 
						window.location.reload();
					} else {
						alert('下线失败');
					}
				});
	});
});
</script>
</head>
<body>
<div class="mTitle">
<%--
  <span class="hidsearch"><a href="javascript:void(0)" onclick="return chg('searchList');" id="ImgArrow"><img src="${ctx}/resources/images/icon_down.gif" id ="imgButton" />展开搜索</a></span>
 --%>
  <b class="bbig">专题列表</b>
</div>
<s:form  id="searchForm" action="subject-list" namespace="/admin/information/subject">
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
	<th>专题名称</th>
	<th>专题状态</th>
	<th>专题排序</th>
    <th>操作</th>
  </tr>
  <s:iterator value="pager.items">
  <tr>  
  	<td> <s:property value="name"/> </td>
  	<td> <s:if test="status==0">新建</s:if><s:if test="status==1">上线</s:if><s:if test="status==2">下线</s:if> </td>
  	<td> <s:property value="orderNo"/> </td>
    <td>
    	<s:if test="status==1">
    	<a href="javascript:void(0)" id="<s:property value="id"/>" rel="offline">下线</a>  
    	</s:if>
		<s:else>
    	<a href="javascript:void(0)" id="<s:property value="id"/>" rel="online">上线</a>  
		</s:else>
    	
    	<a href="<s:url action="subject!edit" namespace="/admin/information/subject"/>?requestId=<s:property value="id"/>">修改</a>  
    	<a href="<s:url action="subject!delete" namespace="/admin/information/subject"/>?requestId=<s:property value="id"/>"  onclick="return confirmDel();">删除</a>  
    </td>
  </tr>
  </s:iterator>
</table>
</div>
<!--end list -->
<div class="Toolbar">
  <div class="toolBt">
 		<a href="<s:url action="subject!input" namespace="/admin/information/subject"/>" title="新建"><span class="btn">新建</span></a>
  </div>
  <e:pagination></e:pagination>
</div>
 
</body>
</html>

