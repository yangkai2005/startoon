<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/WEB-INF/j2eeframework_common.tld"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>Title Here</title>

<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/admin.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/validator.css"/>
<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/formValidator.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/formValidatorRegex.js"></script>

<script type="text/javascript"> 
$(document).ready(function(){
});
</script>

</head>

<body>
<div class="mTitle">
  <b class="bbig">类别关键词列表</b>
</div>
<s:form  id="searchForm" action="link-list" namespace="/admin/link">
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
	<th> 关键词 </th>
	<th> 排名 </th>
	<th> 价格 </th>
	<th> 3个月折扣 </th>
	<th> 6个月折扣 </th>
	<th> 12个月折扣 </th>
    <th> 操作 </th>
  </tr>
  <s:iterator value="pager.items">
  <tr>  
  	<td> <s:property value="category.name"/> </td>
  	<td> 第<s:property value="rank"/>位 </td>
  	<td> <s:property value="minPrice"/> </td>
  	<td> <s:property value="discount3"/> </td>
  	<td> <s:property value="discount6"/> </td>
  	<td> <s:property value="discount12"/> </td>
    <td> 
    	<a href="<s:url action="category-keyword!edit" namespace="/admin/categorykeyword"/>?requestId=<s:property value="id"/>">修改</a>
    </td>
  </tr>
  </s:iterator>
</table>
</div>
<!--end list -->
<div class="Toolbar">
  <div class="toolBt">
  		<!-- 
 		<a href="#" title="新建"><span class="btn">新建</span></a>
  		 -->
  </div>
  <e:pagination></e:pagination>
</div>
 
</body>
</html>