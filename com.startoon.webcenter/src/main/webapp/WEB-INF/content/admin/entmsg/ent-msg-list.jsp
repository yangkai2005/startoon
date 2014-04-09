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

function chg(id_num){
    var oa = document.getElementById(id_num);
    var ob = document.getElementById("ImgArrow");
	 var imgButton = document.getElementById("imgButton");
    if(oa.style.display == "block"){
            oa.style.display = "none";
            imgButton.src = "${ctx}/resources/images/icon_down.gif";
			 imgButton.alt = "展开搜索";
    }else{
            oa.style.display = "block";
            imgButton.src = "${ctx}/resources/images/icon_up.gif";
			 imgButton.alt = "隐藏搜索";
    }
    return false;
}

$(document).ready(function(){

	$('#checkAll').click(function() {
		var ck = $(this).attr('checked');
		$(':checkbox[name=ids]').attr('checked', ck);
	});

	$('#pass').click(function() {
		var doflag = isChecked();
		if(doflag){
			$('input[name=status]').val(2);
			$('#auditForm').submit();
		}else{
			alert('请至少选一条记录!');
		}
	});	

	$('#unpass').click(function() {
		var doflag = isChecked();
		if(doflag){
			$('input[name=status]').val(1);
			$('#auditForm').submit();
		}else{
			alert('请至少选一条记录!');
		}
	});	
	$('#delete').click(function() {
		var doflag = isChecked();
		if(doflag){
			if(confirm('留言删除后将不可恢复,确认要删除吗?')){
				$('#auditForm').attr("action","${pageContext.request.contextPath}/admin/entmsg/ent-msg!delete.action");
				$('#auditForm').submit();
			}
		}else{
			alert('请至少选一条记录!');
		}
	});	
	
});

function isChecked(){
	var doflag = false;
	$(':checkbox[name=ids]').each(function(idx,element){
		if($(element).attr("checked")){
			doflag = true;
		}
	});	

	return doflag;
}
</script>
</head>
<body>
<div class="mTitle">

  <span class="hidsearch"><a href="javascript:void(0)" onclick="return chg('searchList');" id="ImgArrow"><img src="${ctx}/resources/images/icon_down.gif" id ="imgButton" />展开搜索</a></span>

  <b class="bbig">企业留言审核</b>
</div>
<s:form  id="searchForm" action="ent-msg-list" namespace="/admin/entmsg">
<div class="searchBar" id="searchList" style="display:none;">
  <table class="searchTable">
  <tr>
    <th>留言内容：</th>
    <td><input name="content" id="content" type="text" size="25" /></td>
    <td><button class="btn" type="submit">确定搜索</button></td>
  </tr>
  </table>
</div>
</s:form> 
 
<form id="auditForm" name="auditForm" action="${ctx}/admin/entmsg/ent-msg!check.action">
<s:hidden name="status"></s:hidden>
<!--list -->
<div class="mainList">
<table class="listTable">
  <tr>
	<th width="50"><input type="checkbox" id="checkAll" />全选 </th>
	<th>审核状态</th>
	<th>企业</th>
	<th>姓名</th>
	<th>所在地区</th>
	<th>联系方式</th>
	<th>Email</th>
	<th>留言</th>
	<th>留言时间</th>
	<%--
    <th>操作</th>
	 --%>
  </tr>
  <s:iterator value="pager.items">
  <tr>  
  	<td> <input type="checkbox" name="ids" value="<s:property value='id'/>"/> </td>
  	<td> <s:property escape="html" value="statusZh"/> </td>
  	<td> <a href="${pageContext.request.contextPath}/enterprises/ent-index.action?enterpriseId=${enterprise.id}" target="_blank"><s:property value="enterprise.name"/></a> </td>
  	<td> <s:property value="creatorName"/> </td>
  	<td> <s:property value="area"/> </td>
  	<td> <s:property value="contact"/> </td>
  	<td> <s:property value="email"/> </td>
  	<td> <s:property value="content"/> </td>
  	<td> <s:date name="ctime" format="yyyy-MM-dd HH:mm:ss"/> </td>
  	<%--
    <td> 
    	<a href="<s:url action="ent-msg!edit" namespace="/admin/entmsg"/>?requestId=<s:property value="id"/>">修改</a>  
    	<a href="<s:url action="ent-msg!delete" namespace="/admin/entmsg"/>?requestId=<s:property value="id"/>"  onclick="return confirmDel();">删除</a>  
    </td>
  	 --%>
  </tr>
  </s:iterator>
</table>
</div>
</form>
<!--end list -->
<div class="Toolbar">
  <div class="toolBt">
 		<a href="#" id="pass" title="通过"><span class="btn">通过</span></a>
 		<a href="#" id="unpass" title="不通过"><span class="btn">不通过</span></a>
 		<a href="#" id="delete" title="删除所选"><span class="btn">删除所选</span></a>
  </div>
  <e:pagination></e:pagination>
</div>


 
</body>
</html>

