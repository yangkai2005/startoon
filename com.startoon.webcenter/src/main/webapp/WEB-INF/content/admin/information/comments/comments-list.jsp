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
$(document).ready(function(){

	$('#checkAll').click(function(){
		var ck = $(this).attr("checked");
		$(':checkbox[name=ids]').attr('checked', ck);
	});

	$('#pass').click(function(){
		$(":hidden[name=status]").val(2);
		$('#auditForm').submit();
	});
	$('#unpass').click(function(){
		$(":hidden[name=status]").val(1);
		$('#auditForm').submit();
	});
});


</script>
</head>
<body>
<div class="mTitle">
  <span class="hidsearch"><a href="javascript:void(0)" onclick="return chg('searchList');" id="ImgArrow"><img src="${ctx}/resources/images/icon_down.gif" id ="imgButton" />展开搜索</a></span>
  <b class="bbig">评论审核列表</b>
</div>
<s:form  id="searchForm" action="comments-list" namespace="/admin/information/comments">
<div class="searchBar" id="searchList" style="display:none;">
  <table class="searchTable">
  <tr>
    <th width="10%">审核状态：</th>
    <td width="20%"><s:select name="status" list="#{0:'未审核', 1:'未通过', 2:'通过'}" /></td>
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
<form id="auditForm" action="${ctx}/admin/information/comments/comments!audit.action">
<input type="hidden" name="status" />

<table class="listTable">
  <tr>
	<th><input type="checkbox" name="checkAll" id="checkAll"/> </th>
	<th>新闻标题</th>
	<th>昵称</th>
	<th>创建时间</th>
	<th>评论内容</th>
  </tr>
  <s:iterator value="pager.items">
  <tr>  
  	<td> <input name="ids" type="checkbox" value="<s:property value="id"/>"/> </td>
  	<td> <s:property value="info.title"/> </td>
  	<td> <s:property value="creatorName"/> </td>
  	<td> <s:date name="createTime" format="yyyy-MM-dd HH:mm:ss"/> </td>
  	<td> <s:property value="content"/> </td>
  </tr>
  </s:iterator>
</table>
</form>
</div>
<!--end list -->
<div class="Toolbar">
  <div class="toolBt">
 		<a href="#void(0)" title="通过" id="pass"><span class="btn">通过</span></a>
 		<a href="#void(0)" title="不通过" id="unpass"><span class="btn">不通过</span></a>
  </div>
  <e:pagination></e:pagination>
</div>
 
</body>
</html>

