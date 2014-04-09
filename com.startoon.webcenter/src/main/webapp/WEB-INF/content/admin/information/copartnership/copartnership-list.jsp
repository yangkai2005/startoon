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
  <b class="bbig">创意SHOW合作伙伴列表</b>
</div>
<s:form  id="searchForm" action="copartnership-list" namespace="/admin/information/copartnership">
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
	<th width="150px">LOGO</th>
	<th>名称</th>
	<th>网址</th>
	<th>所在位置</th>
    <th>操作</th>
  </tr>
  <s:iterator value="pager.items">
  <tr>  
  	<td> <img src="<s:property value="smallLogo"/>" alt="<s:property value="name"/>" width="100px" height="100px" /> </td>
	<td> <s:property value="name"/> </td>
	<td> <s:property value="siteUrl"/> </td>
	<td>
		<s:if test="%{infoTypeId==-1}">B2B平台</s:if>
		<s:if test="%{infoTypeId==1}">资讯平台：首页</s:if>
		<s:if test="%{infoTypeId==2}">资讯平台：资讯中心</s:if>
		<s:if test="%{infoTypeId==4}">资讯平台：高端访谈</s:if>
		<s:if test="%{infoTypeId==5}">资讯平台：店长吧</s:if>
		<s:if test="%{infoTypeId==6}">资讯平台：星力观察家</s:if>
		<s:if test="%{infoTypeId==7}">资讯平台：创意Show</s:if>
		<s:if test="%{infoTypeId==8}">资讯平台：展会活动</s:if>
		<s:if test="%{infoTypeId==11}">资讯平台：人才服务</s:if>
		<s:if test="%{infoTypeId==100000}">资讯平台：资料下载</s:if>
	</td>
    <td> 
    	<a href="<s:url action="copartnership!edit" namespace="/admin/information/copartnership"/>?requestId=<s:property value="id"/>">修改</a>  
    	<a href="<s:url action="copartnership!delete" namespace="/admin/information/copartnership"/>?requestId=<s:property value="id"/>"  onclick="return confirmDel();">删除</a>  
    </td>
  </tr>
  </s:iterator>
</table>
</div>
<!--end list -->
<div class="Toolbar">
  <div class="toolBt">
 		<a href="<s:url action="copartnership!input" namespace="/admin/information/copartnership"/>" title="新建"><span class="btn">新建</span></a>
  </div>
  <e:pagination></e:pagination>
</div>
 
</body>
</html>

