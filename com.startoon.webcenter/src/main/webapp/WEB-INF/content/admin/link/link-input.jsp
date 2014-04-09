<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>Title Here</title>

<link href="${ctx}/resources/css/admin.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/resources/js/jquery.js" type="text/javascript"></script>
<link href="${ctx}/resources/v2/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>

<script type="text/javascript"> 
$(document).ready(function(){
 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg)},onsuccess:function(){return true;}});
 	$("#linkType").formValidator({onshow:"",onfocus:"友情链接类别不能为空",oncorrect:""}).inputValidator({min:1,max:100,onerror:"友情链接类别不能为空"});
 	$("#name").formValidator({onshow:"",onfocus:"友情链接名称不能为空",oncorrect:""}).inputValidator({min:1,max:100,onerror:"友情链接名称不能为空"});
 	$("#url").formValidator({onshow:"",onfocus:"链接地址不能为空",oncorrect:""}).inputValidator({min:1,max:100,onerror:"链接地址不能为空"});
 	<s:if test="%{nextMethod=='insert'}">
 	$("#upload").formValidator({onshow:"",onfocus:"LOGO不能为空",oncorrect:""}).inputValidator({min:1,max:100,onerror:"LOGO不能为空"});
 	</s:if> 	
});
</script>

</head>

<body>
<div class="mTitle">
  <b class="bbig">友情链接</b>
</div>
<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/admin/link" enctype="multipart/form-data">
<s:hidden name="nextMethod" />
<s:hidden name="requestId" />
<s:hidden name="id" />
<!--list -->
<div class="mainAdd">
<table class="addTable">
<s:if test="%{nextMethod=='update'}">
  <tr>
    <th></th> 
	<td><img src="<s:property value="smallLogo"/>" alt="<s:property value="name"/>" /></td>
  </tr>
</s:if>
  <tr>
    <th>友情链接类别:</th> 
	<td> <s:select name="linkTypeId" id="linkType" list="%{linkTypes}" listKey="id" listValue="displayName" headerKey="" headerValue="--请选择--"></s:select><span id="linkTypeTip"></span> </td>
  </tr>
  <tr>
    <th>友情链接名称:</th> 
	<td> <s:textfield name="name" id="name" size="30"></s:textfield><span id="nameTip"></span> </td>
  </tr>
  <tr>
    <th>链接地址:</th> 
	<td> <s:textfield name="url" id="url" size="30"></s:textfield><span id="urlTip"></span> </td>
  </tr>
  <tr>
    <th>排序编号:</th> 
	<td> <s:textfield name="orderNo" id="orderNo" size="30"></s:textfield>编号越大，越排前<span id="orderNoTip"></span> </td>
  </tr>
  <tr>
    <th>LOGO:</th> 
	<td> <s:file id="upload" name="upload"></s:file> <span id="logoTip"></span> </td>
  </tr>
</table>
</div>
<!--end list -->
<div class="addToolbar">
    <p><button class="btn" type="submit"><b>确定</b></button>
    <button class="btn" type="button" onclick="location.href='<s:url action="link-list" namespace="/admin/link"/>?restore_params=true'">返回</button></p>
</div>
 
 </s:form>
</body>
</html>