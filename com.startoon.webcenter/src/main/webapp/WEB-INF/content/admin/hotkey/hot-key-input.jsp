<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>Title Here</title>

<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/admin.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/validator.css"/>
<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/iColorPicker.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/formValidator.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/formValidatorRegex.js"></script>

<script type="text/javascript"> 
$(document).ready(function(){
 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg)},onsuccess:function(){return true;}});
 	$("#name").formValidator({onshow:"请输入热搜关键词",onfocus:"热搜关键词为必填",oncorrect:"输入正确"}).inputValidator({min:1,max:100,onerror:"热搜关键词不能为空，请确认"});
 	$("#orderNo").formValidator({onshow:"请输入热搜关键词排序编号",onfocus:"热搜关键词排序为0-255之间的数字，数字越大，越靠前",oncorrect:"输入正确"}).inputValidator({min:1,max:100,onerror:"热搜关键词排序不能为空，请确认"}).regexValidator({regexp:"num1",datatype:"enum",onerror:"你输入的排序值非法,请输入数字"});;
});
</script>

</head>

<body>
<div class="mTitle">
  <b class="bbig">热搜关键词维护</b>
</div>
<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/admin/hotkey">
<s:hidden name="nextMethod" />
<s:hidden name="requestId" />
<s:hidden name="id" />
<!--list -->
<div class="mainAdd">
<table class="addTable">
  <tr>
    <th>热搜关键词:</th> 
	<td> <s:textfield name="name" id="name" size="30"></s:textfield><span id="nameTip"></span> </td>
  </tr>
  <tr>
    <th>关键词分类:</th> 
	<td> <s:radio list="#{0:'B2B平台', 1:'资讯平台'}" id="status" name="status"></s:radio><span id="statusTip"></span> </td>
  </tr>
  <tr>
    <th>关键词排序:</th> 
	<td> <s:textfield name="orderNo" id="orderNo" size="30"></s:textfield><span id="orderNoTip"></span> </td>
  </tr>
  <!-- 
  <tr>
    <th>关键词颜色:</th> 
	<td> <s:textfield name="color" id="color" size="30" cssClass="iColorPicker"></s:textfield><span id="colorTip"></span> </td>
  </tr>
   -->
</table>
</div>
<!--end list -->
<div class="addToolbar">
    <p><button class="btn" type="submit"><b>确定</b></button>
    <button class="btn" type="button" onclick="location.href='<s:url action="hot-key-list" namespace="/admin/hotkey"/>?restore_params=true'">取消</button></p>
</div>
 
 </s:form>
</body>
</html>