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
	$("#checkAll").click(function() {
		var ck = $(this).attr("checked");
		$('input[name=ids]').attr("checked", ck);
	});

	$("#pass").click(function(){
		var cks = $('input[name=ids]:checked');
		if(cks && cks.length>0) {
			$("#status").val(2);
			$("#auditForm").submit();
		} else {
			alert('请选择要审核的数据！');
		}
	});
	
	$("#unpass").click(function(){
		var cks = $('input[name=ids]:checked');
		if(cks && cks.length>0) {
			$("#status").val(1);
			$("#auditForm").submit();
		} else {
			alert('请选择要审核的数据！');
		}
	});
	
	$("#delBtn").click(function(){
		var cks = $('input[name=ids]:checked');
		$("#auditForm").attr('action', '${ctx}/admin/information/cooperation/info!deleteAll.action');
		
		if(cks && cks.length>0) {
			$("#auditForm").submit();
		} else {
			alert('请选择要删除的数据！');
		}
	});
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
  <b class="bbig">审核列表</b>
</div>
<s:form  id="searchForm" action="info-list" namespace="/admin/information/cooperation">
<div class="searchBar" id="searchList" style="display:none;">
  <table class="searchTable">
  <tr>
    <th width="10%">审核状态：</th>
    <td width="20%"> <s:select list="#{-1:'所有',0:'未审核',1:'不通过',2:'通过'}" name="status"></s:select> </td>
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
<s:form  id="auditForm" action="info!audit" namespace="/admin/information/cooperation">
<s:hidden id="status" name="status"></s:hidden>
<table class="listTable">
  <tr>
	<th><input type="checkbox" id="checkAll"/> </th>
	<th>标题</th>
	<th>类别</th>
	<th>创建者</th>
	<th>创建时间</th>
	<th>审核状态</th>
	<th>内容</th>
  </tr>
  <s:iterator value="pager.items">
  <tr>  
  	<td> <input type="checkbox" name="ids" value="<s:property value="id"/>" /> </td>
	<td> <s:property value="title"/> </td>
	<td> <s:property value="infoType.name"/> </td>
	<td> <s:property value="creatorName"/> </td>
	<td> <s:date name="createTime" format="yyyy-MM-dd"/> </td>
	<td> <s:if test="status==0">未审核</s:if><s:if test="status==1"><font color="#ff0000">不通过</font></s:if><s:if test="status==2">通过</s:if><s:if test="status==3"></s:if> </td>
	<td> <s:property value="contentTxt"/> </td>
	<!--
    <td> 
    	<a href="<s:url action="reply!edit" namespace="/admin/information/reply"/>?requestId=<s:property value="id"/>">修改</a>  
    	<a href="<s:url action="reply!delete" namespace="/admin/information/reply"/>?requestId=<s:property value="id"/>"  onclick="return confirmDel();">删除</a>  
    </td>
  	-->
  </tr>
  </s:iterator>
</table>
</s:form>
</div>
<!--end list -->
<div class="Toolbar">
  <div class="toolBt">
 		<a href="#" title="通过" id="pass"><span class="btn">通过</span></a>
 		<a href="#" title="不通过" id="unpass"><span class="btn">不通过</span></a>
 		<a href="#" id="delBtn"><span class="btn">删除</span></a>
  </div>
  <e:pagination></e:pagination>
</div>
 
</body>
</html>