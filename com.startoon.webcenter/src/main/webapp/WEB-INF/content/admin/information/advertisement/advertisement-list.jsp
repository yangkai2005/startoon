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

<link rel="stylesheet" href="${ctx}/resources/lightbox2.05/css/lightbox.css" type="text/css" media="screen" />
<script type="text/javascript" src="${ctx}/resources/lightbox2.05/js/prototype.js"></script>
<script type="text/javascript" src="${ctx}/resources/lightbox2.05/js/scriptaculous.js?load=effects,builder"></script>
<script type="text/javascript" src="${ctx}/resources/lightbox2.05/js/lightbox.js"></script>

<script type="text/javascript">
function chg(id_num){
	var oa = document.getElementById(id_num);
    var ob = document.getElementById("ImgArrow");
    var imgButton = document.getElementById("imgButton");
    if(oa.style.display == "block") {
    	oa.style.display = "none";
    	imgButton.src = "${ctx}/resources/images/icon_down.gif";
    	imgButton.alt = "展开搜索";
    } else {
    	oa.style.display = "block";
    	imgButton.src = "${ctx}/resources/images/icon_up.gif";
    	imgButton.alt = "隐藏搜索";
    }
    return false;
}
</script>
</head>
<body>
<div class="mTitle">
  <span class="hidsearch"><a href="javascript:void(0)" onclick="return chg('searchList');" id="ImgArrow"><img src="${ctx}/resources/images/icon_down.gif" id ="imgButton" />展开搜索</a></span>
  <b class="bbig">广告位列表</b>
</div>
<s:form  id="searchForm" action="advertisement-list" namespace="/admin/information/advertisement">
<div class="searchBar" id="searchList" style="display:none;">
  <table class="searchTable">
  <tr>
    <th width="10%">ID：</th>
    <td><input name="id" type="text" size="25" value="<s:property value="pager.paramCondition['id']"/>" /></td>
    <th width="10%">编号：</th>
    <td><input name="adNo" type="text" size="25" value="<s:property value="pager.paramCondition['adNo']"/>" /></td>
    <th width="10%">名称：</th>
    <td><input name="name" type="text" size="25" value="<s:property value="pager.paramCondition['name']"/>" /></td>
    <th width="10%">位置：</th>
    <td><input name="position" type="text" size="25" value="<s:property value="pager.paramCondition['position']"/>" /></td>
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
  	<%-- 
  	--%>
  	<th>ID</th>
	<th>图片</th>
	<th>广告编号</th>
	<th>广告位置</th>
	<th>广告名称</th>
	<th>广告价格</th>
	<th>到期日期</th>
	<th>点击量</th>
	<%--
	<th>默认图片</th>
	 --%>
    <th>操作</th>
  </tr>
  <s:iterator value="pager.items">
  <tr>
  	<%-- 
  	--%>  
	<td> <s:property value="id"/> </td>
  	<td> <%-- <img src="<s:property value="validAdImg"/>" alt="" /> --%> <a href="<s:property value="validAdImg"/>" rel="lightbox" title="<s:property value="name"/>">查看广告图片</a> </td>
	<td> <s:property value="adNo"/> </td>
	<td> <s:property value="position"/> </td>
	<td> <s:property value="name"/> </td>
	<td> <s:property value="price"/> </td>
	<td> <s:date name="deadTime" format="yyyy-MM-dd"/> </td>
	<td> <s:property value="hits"/> </td>
	<%--
	<td> <s:property value="defaultAdImgUrl"/> </td>
	 --%>
    <td>
    	<a href="<s:url action="advertisement!edit" namespace="/admin/information/advertisement"/>?requestId=<s:property value="id"/>">修改</a> 
    	<%--
    	<a href="<s:url action="advertisement!delete" namespace="/admin/information/advertisement"/>?requestId=<s:property value="id"/>">删除</a>  
    	--%>
    </td>
  </tr>
  </s:iterator>
</table>
</div>
<!--end list -->
<div class="Toolbar">
  <div class="toolBt">
  	<%--
  	--%>
 		<a href="<s:url action="advertisement!input1" namespace="/admin/information/advertisement"/>" title="新建"><span class="btn">新建</span></a>
  </div>
  <e:pagination></e:pagination>
</div>
 
</body>
</html>

