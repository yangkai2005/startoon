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
 	$("#name").formValidator({onshow:"",onfocus:"name can't empty",oncorrect:""}).inputValidator({min:1,max:100,onerror:"name can't empty"});
});
</script>

</head>

<body>
<div class="mTitle">
  <b class="bbig">名企维护</b>
</div>
<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/admin/information/hrenterprise" enctype="multipart/form-data">
<s:hidden name="nextMethod" />
<s:hidden name="requestId" />
<s:hidden name="id" />
<!--list -->
<div class="mainAdd">
<table class="addTable">
<s:if test="nextMethod=='update'">
  <tr>
    <th>LOGO：</th> 
	<td> <img src="${ctx}/FileView?id=<s:property value="slogo"/>" alt="<s:property value="name"/>" width="100px" height="100px" /> </td>
  </tr>
</s:if>
  <tr>
    <th>名企名称：</th> 
	<td> <s:textfield name="name" id="name" size="30"></s:textfield><span id="nameTip"></span> </td>
  </tr>
  <tr>
    <th>名企网址：</th> 
	<td> <s:textfield name="site" id="site" size="30"></s:textfield><label>如:http://www.qq.com </label><span id="siteTip"></span> </td>
  </tr>
  <tr>
    <th>排序：</th> 
	<td> <s:textfield name="orderNo" id="orderNo" size="30"></s:textfield><s:label>请输入0-255之间的数，编号越大越靠前</s:label><span id="orderNoTip"></span> </td>
  </tr>
  <tr>
    <th>所属的位置：</th> 
	<td> <s:radio list="#{0:'人才服务首页', 1:'招聘专题-名企招聘', 2:'招聘专题-名校直通车'}" name="type" id="type"></s:radio> <span id="typeTip"></span> </td>
  </tr>
  <tr>
    <th>名企LOGO:</th> 
	<td> <s:file id="upload" name="upload"></s:file> <span id="uploadTip"></span> </td>
  </tr>
</table>
</div>
<!--end list -->
<div class="addToolbar">
    <p><button class="btn" type="submit"><b>提  交</b></button>
    <button class="btn" type="button" onclick="location.href='<s:url action="hr-enterprise-list" namespace="/admin/information/hrenterprise"/>?restore_params=true'">取  消</button></p>
</div>
 
 </s:form>
</body>
</html>