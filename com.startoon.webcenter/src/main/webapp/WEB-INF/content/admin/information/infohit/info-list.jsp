<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/myfunction.js"></script>
<script type="text/javascript">
$(document).ready(function(){

});
</script>
</head>
<body>
<div class="mTitle">
<!-- 
  <span class="hidsearch"><a href="javascript:void(0)" onclick="return chg('searchList');" id="ImgArrow"><img src="<%=request.getContextPath() %>/resources/images/icon_down.gif" id ="imgButton" />展开搜索</a></span>
 -->
  <b class="bbig">新闻点击量</b>
</div>
<s:form  id="searchForm" action="info-list" namespace="/admin/information/infohit">
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
	<th>点击量</th>
  </tr>
  <s:iterator value="pager.items">
  <tr>  
  	<td> <s:property value="title"/> </td>
  	<td> <s:date name="infoTime" format="yyyy-MM-dd"/> </td>
  	<td> <s:property value="infoType.name"/> </td>
  	<td> <s:property value="source"/> </td>
  	<td> <s:property value="sourceUrl"/> </td>
  	<td> <s:property value="hits"/> </td>
  </tr>
  </s:iterator>
</table>
</div>
<!--end list -->
<div class="Toolbar">
  <div class="toolBt">
  </div>
  <e:pagination></e:pagination>
</div>
 
</body>
</html>

