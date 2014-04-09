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
  <span class="hidsearch"><a href="javascript:void(0)" onclick="return chg('searchList');" id="ImgArrow"><img src="${ctx}/resources/images/icon_down.gif" id ="imgButton" />展开搜索</a></span>
  <b class="bbig">名企招聘列表</b>
</div>
<s:form  id="searchForm" action="hr-enterprise-list" namespace="/admin/information/hrenterprise">
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
	<th>LOGO</th>
	<th>名企名称</th>
	<th>名企网址</th>
	<th>所属位置</th>
	<th>排序编号</th>
    <th>操作</th>
  </tr>
  <s:iterator value="pager.items">
  <tr>  
  	<td> <img src="${ctx}/FileView?id=<s:property value="slogo"/>" alt="<s:property value="name"/>" width="100px" height="100px" />  </td>
  	<td> <s:property value="name"/> </td>
  	<td> <s:property value="site"/> </td>
  	<td> <s:if test="type==0">人才服务-名企招聘</s:if><s:elseif test="type==1">招聘主题-名企招聘</s:elseif><s:elseif test="type==2">招聘主题-名校直通车</s:elseif> </td>
  	<td> <s:property value="orderNo"/> </td>
    <td> 
    	<a href="<s:url action="hr-enterprise!edit" namespace="/admin/information/hrenterprise"/>?requestId=<s:property value="id"/>">修改</a>  
    	<a href="<s:url action="hr-enterprise!delete" namespace="/admin/information/hrenterprise"/>?requestId=<s:property value="id"/>"  onclick="return confirmDel();">删除</a>  
    </td>
  </tr>
  </s:iterator>
</table>
</div>
<!--end list -->
<div class="Toolbar">
  <div class="toolBt">
 		<a href="<s:url action="hr-enterprise!input" namespace="/admin/information/hrenterprise"/>" title="新建"><span class="btn">新建</span></a>
  </div>
  <e:pagination></e:pagination>
</div>
 
</body>
</html>

