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
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
$(document).ready(function(){

});
function chg(id_num){
	var oa = document.getElementById(id_num);
    var ob = document.getElementById("ImgArrow");
    var imgButton = document.getElementById("imgButton");
    if(oa.style.display == "block") {
    	oa.style.display = "none";
    	imgButton.src = "<%=request.getContextPath() %>/resources/images/icon_down.gif";
    	imgButton.alt = "展开搜索";
    } else {
    	oa.style.display = "block";
    	imgButton.src = "<%=request.getContextPath() %>/resources/images/icon_up.gif";
    	imgButton.alt = "隐藏搜索";
    }
    return false;
}
</script>
</head>
<body>
<div class="mTitle">
  <span class="hidsearch"><a href="javascript:void(0)" onclick="return chg('searchList');" id="ImgArrow"><img src="<%=request.getContextPath() %>/resources/images/icon_down.gif" id ="imgButton" />展开搜索</a></span>
  <b class="bbig">信息列表</b>
</div>
<s:form  id="searchForm" action="msg-record-list" namespace="/admin/msg">
<div class="searchBar" id="searchList" style="display:none;">
  <table class="searchTable">
  <tr>
    <th width="10%">标题：</th>
    <td width="20%"><input name="title" type="text" size="25" /></td>
    <th width="10%">创建时间：</th>
    <td width="20%"><input name="stime" type="text" size="12" onclick="WdatePicker()" class="Wdate" />-<input name="etime" type="text" size="12" onclick="WdatePicker()" class="Wdate" /></td>
    <th width="10%">内容：</th>
    <td width="20%"><input name="content" type="text" size="25" /></td>
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
	<th width="5%">ID</th>
	<th width="20%">标题</th>
	<th width="10%">发送时间</th>
	<th>内容</th>
  </tr>
  <s:iterator value="pager.items">
  <tr>  
  	<td> <s:property value="id" /> </td>
  	<td> <s:property value="title" /> </td>
  	<td> <s:date name="ctime" format="yyyy-MM-dd"/> </td>
  	<td> <s:property value="content" /> </td>
  </tr>
  </s:iterator>
</table>
</div>
<!--end list -->

<div class="Toolbar">
  <div class="toolBt"></div>
  <e:pagination></e:pagination>
</div>

</body>
</html>

