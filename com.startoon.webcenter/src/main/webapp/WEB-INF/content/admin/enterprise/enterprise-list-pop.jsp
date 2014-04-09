<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<base target="_self" />
<title>信息接收者选择</title>
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
		$('#status').val(1);
		$('#auditForm').submit();
	});
	$('#delete').click(function(){
		if(confirm("删除记录后，数据将不可恢复！\n确认继续删除？")) {
			$('#status').val(3);
			$('#auditForm').submit();
		}
	});
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

function getID(obj,id){
	var resultstr = document.getElementById("resultstr");
	var parentstr = window.dialogArguments.document.getElementById("idandname");
	var str = parentstr.value;

	if(obj.checked){
		if(str != ''){
			parentstr.value = str + "@@@" + id;
		}else{
			parentstr.value = id;
		}
	}else{
		//去掉已选择的
		if(str != ''){
			str = str.replace(id,"");
			parentstr.value = str.replace("@@@@@@","@@@");
		}
	}
	//alert(parentstr.value);
}

function doReturn(){
	var parentstr = window.dialogArguments.document.getElementById("idandname");
	var result = "";
	if(parentstr.value != ''){	
		result = parentstr.value.replace("@@@@@@","@@@");
	}
	window.returnValue = result;
	window.close();
}
</script>
</head>
<body>
<div class="mTitle">
  <span class="hidsearch"><a href="javascript:void(0)" onclick="return chg('searchList');" id="ImgArrow"><img src="${ctx}/resources/images/icon_down.gif" id ="imgButton" />展开搜索</a></span>
  <b class="bbig">注册会员列表</b>
  <input type="button" value="确定选择" name="btnapply" id="btnapply" onclick="doReturn();"/>
</div>
<s:form  id="searchForm" action="enterprise-list-pop" namespace="/admin/enterprise">
<input type="hidden" name="resultstr" id="resultstr"/>
<div class="searchBar" id="searchList" style="display:none;">
  <table class="searchTable">
  <tr>
    <th>审核状态：</th>
    <td width=""><s:select list="#{0:'待审核', 1:'不通过', 2:'已上线'}" name="status" headerKey="-1" headerValue="所有会员"></s:select> </td>
    <th width="">邮箱：</th>
    <td width=""><s:textfield name="email"></s:textfield> </td>
    <th width="">名称：</th>
    <td width=""><s:textfield name="searchKey"></s:textfield> </td>
	<th width=""><button class="btn" type="submit">确定搜索</button></th>
    <td>
	</td>
  </tr>
  </table>
</div>
</s:form> 
 
<!--list -->
<div class="mainList">
<table class="listTable">
  <tr>
	<th width="30"><input type="checkbox" id="checkAll" /> </th>
	<th width="40">类型</th>
	<th>名称</th>
	<th>邮箱</th>
	<th width="75">注册日期</th>
  </tr>
  <s:iterator value="pager.items">
  <tr>
  	<td><input type="checkbox" name="ids" onclick="getID(this,this.value);" value="${id}###<s:if test="userType!=1">个人 - ${email}</s:if><s:else>企业 - ${name}</s:else>" /></td>
  	<td> 
	  	<s:if test="userType==0">个人</s:if><s:else>企业 </s:else>
  	</td>
  	<td> 
  		<s:if test="userType==0"><s:property value="nickname"/></s:if>
  		<s:else><s:property value="name"/></s:else>
  	</td>
  	<td> <s:property value="email"/> </td>
  	<td> <s:date name="createTime" format="yyyy-MM-dd"/> </td>
  </tr>
  </s:iterator>
</table>
</div>
<!--end list -->
<div class="Toolbar"  align="right">
  <div class="toolBt" align="right">
  <e:pagination></e:pagination>
  </div>
</div>
 
</body>
</html>

