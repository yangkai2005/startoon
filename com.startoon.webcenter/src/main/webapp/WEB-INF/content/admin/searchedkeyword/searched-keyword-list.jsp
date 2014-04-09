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

<script type="text/javascript" src="${ctx}/resources/My97DatePicker/WdatePicker.js"></script>


<script type="text/javascript">
$(document).ready(function(){

});

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
  <b class="bbig">关键字搜索统计列表</b>
</div>
<s:form  id="searchForm" action="searched-keyword-list" namespace="/admin/searchedkeyword">
<div class="searchBar" id="searchList" style="display:none;">
  <table class="searchTable">
  <tr>
    <th width="10%">关键字：</th>
    <td width="20%"><input name="keyword" type="text" size="25" value="<s:property value="pager.paramCondition['keyword']"/>"/></td>
    <th width="10%">搜索时间：</th>
    <td width="20%"><input name="sdate" type="text" size="12"  class="Wdate" onfocus="WdatePicker()" value="<s:property value="pager.paramCondition['sdate']"/>" />至<input name="edate" type="text" size="12"  class="Wdate" onfocus="WdatePicker()" value="<s:property value="pager.paramCondition['edate']"/>"/></td>
	<th width="10%"></th>
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
	<th>编号</th>
	<th>关键字</th>
	<th>搜索IP</th>
	<th>搜索时间</th>
  </tr>
  <s:iterator value="pager.items" status="st">
  <tr>  
  	<td> <s:property value="%{#st.count + (pager.pageNo-1) * pager.pageSize}"/> </td>
  	<td> <s:property value="keyword"/> </td>
  	<td> <s:property value="searchIp"/> </td>
	<td> <s:date name="lastSearchTime" format="yyyy-MM-dd HH:mm"/> </td>
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

