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
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/thickbox.css"/>

<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/myfunction.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/thickbox.js"></script>
<script type="text/javascript">
$(document).ready(function(){

	$("#checkAll").click(function() {
		var ck = $(this).attr('checked');
		$(":checkbox[name=ids]").attr('checked', ck);
	});

	$('#pass').click(function(){
		$('#status').val(2);
		$('#auditForm').submit();
	});

	$('#unpass').click(function(){
		$('#status').val(0);
		$('#auditForm').submit();
	});

	var type = "<s:property value="pager.paramCondition['c']"/>";
	if(type=='0') {
		$('#type').attr('name', 'isShow');
	}
});

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
</script>
</head>
<body>
<div class="mTitle">
  <span class="hidsearch"><a href="javascript:void(0)" onclick="return chg('searchList');" id="ImgArrow"><img src="${ctx}/resources/images/icon_down.gif" id ="imgButton" />展开搜索</a></span>
  <b class="bbig">会员申请审核</b>
</div>
<s:form  id="searchForm" action="enterprise-list" namespace="/admin/information/enterprise">
<input type="hidden" name="userType" value="0" />
<input type="hidden" name="c" id="c" value="<s:property value="pager.paramCondition['c']"/>"/>

<div class="searchBar" id="searchList" style="display:none;">
  <table class="searchTable">
  <tr>
    <th>审核状态：</th>
    <td width="">
    	<select name="isBar" id="type">
    		<option value="0">待审核</option>
    		<option value="1">不通过</option>
    		<option value="2">已通过</option>
    	</select>
    </td>
    <th width="">邮箱：</th>
    <td width=""><s:textfield name="email"></s:textfield> </td>
    <th width="">名称：</th>
    <td width=""><s:textfield name="searchKey"></s:textfield> </td>
	<th width=""><button class="btn" type="submit">确定搜索</button></th>
    <td>
	</td>
  </tr>
  <!--
  <tr>
    <th>&nbsp;</th>
    <td><button class="btn" type="submit">确定搜索</button></td>
  </tr>
  -->
  </table>
</div>
</s:form> 
 
<!--list -->
<div class="mainList">
<form id="auditForm" name="auditForm" action="${ctx}/admin/information/enterprise/enterprise!audit.action" method="post">
<input type="hidden" name="status" id="status"/>
<input type="hidden" name="type" value="<s:property value="pager.paramCondition['c']"/>" />
<table class="listTable">
  <tr>
	<th><input id="checkAll" type="checkbox"/> </th>
	<th>账号</th>
	<th>会员类型</th>
	<th>邮箱</th>
	<th>昵称</th>
  </tr>
  <s:iterator value="pager.items">
  <tr>
  	<td><input type="checkbox" name="ids" value="<s:property value='id'/>" /></td>
  	<td> <s:property value="account"/> </td>
  	<td> <s:if test="userType==0">个人</s:if><s:if test="userType==1">企业</s:if> </td>
  	<td> <s:property value="email"/> </td>
  	<td> <s:property value="nickname"/> </td>
  </tr>
  </s:iterator>
</table>
</form>
</div>
<!--end list -->
<div class="Toolbar">
  <div class="toolBt">
 		<a href="#" title="审核通过" id="pass"><span class="btn">审核通过</span></a>
 		<a href="#" title="审核不通过" id="unpass"><span class="btn">审核不通过</span></a>
  </div>
  <e:pagination></e:pagination>
</div>
 
</body>
</html>

