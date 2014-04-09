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
  <b class="bbig">在线调查列表</b>
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
	<th>类别</th>
	<th>调查描述</th>
    <th>操作</th>
  </tr>
  <s:iterator value="pager.items">
  <tr>  
  	<td> <s:property value="title"/> </td>
  	<td> <s:property value="infoType.name"/> </td>
  	<td> <s:property value="content"/> </td>
    <td> 
    	<a href="<s:url action="info!edit" namespace="/admin/information/survey"/>?requestId=<s:property value="id"/>">修改</a>  
    	<a href="<s:url action="info!delete" namespace="/admin/information/survey"/>?requestId=<s:property value="id"/>"  onclick="return confirmDel();">删除</a>  
    	<s:if test="status!=2">
    	<a href="<s:url action="vote-list" namespace="/admin/information/vote"/>?infoId=<s:property value="id"/>">添加调查问题</a>
    	<a href="<s:url action="info!publish" namespace="/admin/information/survey"/>?requestId=<s:property value="id"/>">发布调查</a>
    	</s:if>
    </td>
  </tr>
  </s:iterator>
</table>
</div>
<!--end list -->
<div class="Toolbar">
  <div class="toolBt">
 		<a href="${ctx}/admin/information/survey/info!input.action" title="新建"><span class="btn">新建</span></a>
  </div>
  <e:pagination></e:pagination>
</div>

<div>
&nbsp;&nbsp;温馨提示：<br/>
&nbsp;&nbsp;&nbsp;&nbsp;1 调查只有在发布前可以添加调查问题；<br/>
&nbsp;&nbsp;&nbsp;&nbsp;2 行情调查一旦发布之后，不允许再进行添加调查问题；<br/>
</div>
</body>
</html>

