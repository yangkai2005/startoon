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
<script type="text/javascript" src="${ctx}/resources/js/formValidator.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/formValidatorRegex.js"></script>
<script type="text/javascript" src="${ctx}/resources/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript"> 
$(document).ready(function(){
 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg);},onsuccess:function(){return true;}});
});
</script>

</head>

<body>
<div class="mTitle">
  <b class="bbig">广告维护</b>
</div>
<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/admin/information/advertisement"  enctype="multipart/form-data">
<s:hidden name="nextMethod" />
<s:hidden name="requestId" />
<s:hidden name="id" />
<!--list -->
<div class="mainAdd">
<table class="addTable">
<s:if test="%{advertisement.validAdImg!=null}">
  <tr>
    <th>广告图片:</th> 
	<td> <img src="<s:property value='validAdImg'/>" alt="" /> </td>
  </tr>
</s:if>

  <tr>
    <th>广告编号:</th> 
	<td> <s:textfield name="adNo" id="adNo" size="30"></s:textfield><span id="adNoTip"></span> </td>
  </tr>
  <tr>
    <th>广告位置:</th> 
	<td> <s:textfield name="position" id="position" size="30"></s:textfield><span id="positionTip"></span> </td>
  </tr>
  <tr>
    <th>广告名称:</th> 
	<td> <s:textfield name="name" id="name" size="30"></s:textfield><span id="nameTip"></span> </td>
  </tr>
  <tr>
    <th>链接网址:</th> 
	<td> <s:textfield name="linkUrl" id="linkUrl" size="30"></s:textfield><label>如:http://www.baidu.com</label><span id="linkUrlTip"></span> </td>
  </tr>
  <tr>
    <th>广告价格:</th> 
	<td> <s:textfield name="price" id="price" size="30"></s:textfield><span id="priceTip"></span> </td>
  </tr>
  <tr>
    <th>到期日期:</th> 
	<td> <s:textfield name="deadTime" id="deadTime" size="30" onfocus="WdatePicker()" cssClass="Wdate"></s:textfield><span id="deadTimeTip"></span> </td>
  </tr>
  <tr>
    <th>广告图片:</th> 
	<td> <s:file id="upload" name="upload"></s:file><span id="uploadTip"></span> </td>
  </tr>
</table>
</div>
<!--end list -->
<div class="addToolbar">
    <p><button class="btn" type="submit"><b>确  定</b></button>
    <button class="btn" type="button" onclick="location.href='<s:url action="advertisement-list" namespace="/admin/information/advertisement"/>?restore_params=true'">取  消</button></p>
</div>

 </s:form>
</body>
</html>