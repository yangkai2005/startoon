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

});
</script>
</head>
<body>
<div class="mTitle">
  <!--<span class="hidsearch"><a href="javascript:void(0)" onclick="return chg('searchList');" id="ImgArrow"><img src="${ctx}/resources/images/icon_down.gif" id ="imgButton" />展开搜索</a></span>-->
  <b class="bbig">
  <s:if test="tid==2">资讯中心</s:if>
  <s:if test="tid==3">行情调查</s:if>
  <s:if test="tid==4">高端访谈</s:if>
  <s:if test="tid==6">星力观察家</s:if>
  <s:if test="tid==7">创意资讯</s:if>
  <s:if test="tid==8">展会活动</s:if>
  <s:if test="tid==10">模拟世界</s:if>
  视频管理
  </b>
</div>
<s:form  id="searchForm" action="info-list" namespace="/admin/information/info">
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
	<th>标题</th>
	<th>发布日期</th>
	<th>类别</th>
	<th>来源</th>
	<th>来源网站</th>
    <th>操作</th>
  </tr>
  <s:iterator value="pager.items">
  <tr>  
  	<td> <s:property value="title"/> </td>
  	<td> <s:date name="infoTime" format="yyyy-MM-dd"/> </td>
  	<td> <s:property value="infoType.name"/> </td>
  	<td> <s:property value="source"/> </td>
  	<td> <s:property value="sourceUrl"/> </td>
    <td> 
    	<a href="<s:url action="info!edit" namespace="/admin/information/video"/>?requestId=<s:property value="id"/>">修改</a>  
    	<a href="<s:url action="info!delete" namespace="/admin/information/video"/>?requestId=<s:property value="id"/>"  onclick="return confirmDel();">删除</a>  
    </td>
  </tr>
  </s:iterator>
</table>
</div>
<!--end list -->
<div class="Toolbar">
  <div class="toolBt">
 		<a href="${ctx}/admin/information/video/info!input.action" title="新建"><span class="btn">新建</span></a>
  </div>
  <e:pagination></e:pagination>
</div>
 
</body>
</html>

