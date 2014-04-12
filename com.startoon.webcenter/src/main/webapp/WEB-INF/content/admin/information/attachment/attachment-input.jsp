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

<script type="text/javascript"> 
$(document).ready(function(){
 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg)},onsuccess:function(){return true;}});
 	//$("#typeId").formValidator({onshow:"",onfocus:"请选择资料分类",oncorrect:""}).inputValidator({min:1,max:100,onerror:"请选择资料分类"});
 	$("#name").formValidator({onshow:"",onfocus:"请输入资料名称",oncorrect:""}).inputValidator({min:1,max:100,onerror:"资料名称不能为空"});
 	$("#upload").formValidator({onshow:"",onfocus:"请选择上传的资料文件",oncorrect:""}).inputValidator({min:1,max:100,onerror:"资料文件不能为空"});
});
</script>

</head>

<body>
<div class="mTitle">
  <b class="bbig">资料维护</b>
</div>
<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/admin/information/attachment" enctype="multipart/form-data">
<s:hidden name="nextMethod" />
<s:hidden name="requestId" />
<s:hidden name="id" />
<!--list -->
<div class="mainAdd">
<table class="addTable">

  <tr>
    <th>资料分类:</th> 
	<td> <s:select list="attachmentTypes" id="typeId" name="typeId" listKey="id" listValue="name"></s:select><span id="typeIdTip"></span> </td>
  </tr>
  <tr>
    <th>资料名称:</th> 
	<td> <s:textfield name="name" id="name" size="30"></s:textfield><span id="nameTip"></span> </td>
  </tr>
  <tr>
    <th>资料URL地址:</th> 
	<td> <s:textfield name="url" id="url" size="50"></s:textfield> <span id="typeIdTip"></span> </td>
  </tr>
  <tr>
    <th>资料截图:</th> 
	<td> <s:file name="img" id="img"></s:file> <span id="imgTip"></span> </td>
  </tr>
  <tr>
    <th>资料文件:</th> 
	<td> <s:file name="upload" id="upload"></s:file> <span id="uploadTip"></span> </td>
  </tr>
  <tr>
    <th>描述:</th> 
	<td> <s:textarea name="description" id="description" ></s:textarea><span id="descriptionTip"></span> </td>
  </tr>
</table>
</div>
<!--end list -->
<div class="addToolbar">
    <p><button class="btn" type="submit"><b>提   交</b></button>
    <button class="btn" type="button" onclick="location.href='<s:url action="attachment-list" namespace="/admin/information/attachment"/>?restore_params=true'">取  消</button></p>
</div>
 
 </s:form>
</body>
</html>