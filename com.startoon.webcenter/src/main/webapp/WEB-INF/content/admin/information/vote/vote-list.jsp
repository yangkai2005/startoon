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

function confirmDel()
{
	if(confirm("过期之后，调查将不能在前台展示！\n确认要将调查过期？"))
	{
		return true;
	}
	return false;
}
function confirmPublish()
{
	if(confirm("发布之后将不能再进行修改！\n确认要发布该调查吗？"))
	{
		return true;
	}
	return false;
}
</script>
</head>
<body>
<div class="mTitle">
  <b class="bbig">行情调查列表</b>
</div>
<s:form  id="searchForm" action="vote-list" namespace="/admin/information/vote">
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
	<th>所属的调查主题</th>
	<th>标题</th>
	<th>创建时间</th>
	<th>状态</th>
    <th>操作</th>
  </tr>
  <s:iterator value="pager.items">
  <tr>  
  	<td> <s:property value="info.title"/> </td>
  	<td> <s:property value="title"/> </td>
  	<td> <s:date name="createTime" format="yyyy-MM-dd"/> </td>
  	<td> <s:if test="status==0">创建未发布</s:if><s:if test="status==1">已发布</s:if><s:if test="status==2">已过期</s:if> </td>
    <td>
    	<s:if test="status==0">
	   	<a href="<s:url action="vote!edit" namespace="/admin/information/vote"/>?requestId=<s:property value="id"/>">修改</a>
    	<%-- <a href="<s:url action="vote!publish" namespace="/admin/information/vote"/>?requestId=<s:property value="id"/>"  onclick="return confirmPublish();">发布</a> --%>
    	</s:if>
    	<s:if test="status==1">
    	<a href="<s:url action="vote!overdue" namespace="/admin/information/vote"/>?requestId=<s:property value="id"/>"  onclick="return confirmDel();">过期</a>  
    	</s:if>
    </td>
  </tr>
  </s:iterator>
</table>
</div>
<!--end list -->
<div class="Toolbar">
  <div class="toolBt">
 		<a href="<s:url action="vote!input" namespace="/admin/information/vote"/>?infoId=<s:property value="pager.paramCondition['infoId']"/>" title="新建"><span class="btn">新建</span></a>
 		<a href="<s:url action="info-list" namespace="/admin/information/survey"/>" title="返回"><span class="btn">返回</span></a>
  </div>
  <e:pagination></e:pagination>
</div>

<div>
&nbsp;&nbsp;温馨提示：<br/>
&nbsp;&nbsp;&nbsp;&nbsp;1 行情调查只有在发布前可以进行修改；<br/>
&nbsp;&nbsp;&nbsp;&nbsp;2 行情调查一旦发布之后，不允许再进行修改，只能进行过期操作；<br/>
&nbsp;&nbsp;&nbsp;&nbsp;3 过期的行情调查将不再前台进行展示；
</div>

</body>
</html>

