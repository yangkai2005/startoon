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
</script>
</head>
<body>
<div class="mTitle">
  <!--<span class="hidsearch"><a href="javascript:void(0)" onclick="return chg('searchList');" id="ImgArrow"><img src="${ctx}/resources/images/icon_down.gif" id ="imgButton" />展开搜索</a></span>
  -->
  <b class="bbig">版区列表</b>
</div>
<s:form  id="searchForm" action="post-type-list" namespace="/admin/information/posttype">
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
	<th>版区名称</th>
    <th>操作</th>
  </tr>
  <s:iterator value="pager.items">
  <tr>  
  	<td> <s:property value="name"/> </td>
    <td> 
    	<a href="<s:url action="post-type!edit" namespace="/admin/information/posttype"/>?requestId=<s:property value="id"/>">修改</a>  
    	<a href="<s:url action="post-type!delete" namespace="/admin/information/posttype"/>?requestId=<s:property value="id"/>"  onclick="return confirmDel();">删除</a>  
    </td>
  </tr>
  </s:iterator>
</table>
</div>
<!--end list -->
<div class="Toolbar">
  <div class="toolBt">
 		<a href="<s:url action="post-type!input" namespace="/admin/information/posttype"/>" title="新建"><span class="btn">新建</span></a>
  </div>
  <e:pagination></e:pagination>
</div>
 
</body>
</html>

