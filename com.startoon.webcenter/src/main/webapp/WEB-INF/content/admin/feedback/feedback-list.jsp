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
<%--
  <span class="hidsearch"><a href="javascript:void(0)" onclick="return chg('searchList');" id="ImgArrow"><img src="${ctx}/resources/images/icon_down.gif" id ="imgButton" />展开搜索</a></span>
--%>
  <b class="bbig">我要提问列表</b>
</div>
<s:form  id="searchForm" action="feedback-list" namespace="/admin/feedback">
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
	<th>姓名</th>
	<th>电话</th>
	<th>手机</th>
	<th>公司</th>
	<th>传真</th>
	<th>QQ</th>
	<th>MSN</th>
	<th>电子邮箱</th>
	<th>提问日期</th>
	<th>操作</th>
  </tr>
  <s:iterator value="pager.items">
  <tr>  
  	<td> <s:property value="name"/> </td>
  	<td> <s:property value="phone"/> </td>
  	<td> <s:property value="mobile"/> </td>
  	<td> <s:property value="company"/> </td>
  	<td> <s:property value="fax"/> </td>
  	<td> <s:property value="qq"/> </td>
  	<td> <s:property value="msn"/> </td>
  	<td> <s:property value="email"/> </td>
  	<td> <s:date name="createTime" format="yyyy-MM-dd"/> </td>
    <td> 
    	<a href="<s:url action="feedback!show" namespace="/admin/feedback"/>?requestId=<s:property value="id"/>">查看</a>  
    	<a href="<s:url action="feedback!delete" namespace="/admin/feedback"/>?requestId=<s:property value="id"/>"  onclick="return confirmDel();">删除</a>  
    </td>
  </tr>
  </s:iterator>
</table>
</div>
<!--end list -->
<div class="Toolbar">
  <div class="toolBt">
  		<%-- 
 		<a href="<s:url action="feedback!input" namespace="/admin/feedback"/>" title="新建"><span class="btn">新建</span></a>
  		--%>
  </div>
  <e:pagination></e:pagination>
</div>
 
</body>
</html>

