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

<style type="text/css">
table th {font-size:14px; font-weight:bold; color:#0451ba; }
</style>

<script type="text/javascript"> 
$(document).ready(function(){
 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg)},onsuccess:function(){return true;}});
 	$("#name").formValidator({onshow:"",onfocus:"name can't empty",oncorrect:""}).inputValidator({min:1,max:100,onerror:"name can't empty"});
});
</script>

</head>

<body>
<div class="mTitle">
  <b class="bbig">我要提问详细</b>
</div>
<!--list -->
<div class="mainAdd">
<table class="addTable">
  <tr>
    <th>姓名:</th> 
	<td> <s:label name="name"></s:label> </td>
  </tr>
  <tr>
    <th>电话:</th> 
	<td> <s:label name="phone"></s:label> </td>
  </tr>
  <tr>
    <th>手机:</th> 
	<td> <s:label name="mobile"></s:label> </td>
  </tr>
  <tr>
    <th>公司:</th> 
	<td> <s:label name="company"></s:label> </td>
  </tr>
  <tr>
    <th>传真:</th> 
	<td> <s:label name="fax"></s:label> </td>
  </tr>
  <tr>
    <th>QQ:</th> 
	<td> <s:label name="qq"></s:label> </td>
  </tr>
  <tr>
    <th>MSN:</th> 
	<td> <s:label name="msn"></s:label> </td>
  </tr>
  <tr>
    <th>电子邮箱:</th> 
	<td> <s:label name="email"></s:label> </td>
  </tr>
  <tr>
    <th>问题:</th> 
	<td> <s:text name="content"></s:text> </td>
  </tr>
</table>
</div>
<!--end list -->
<div class="addToolbar">
    <p>
    <button class="btn" type="button" onclick="location.href='<s:url action="feedback-list" namespace="/admin/feedback"/>?restore_params=true'">返回</button>
    </p>
</div>
 
</body>
</html>