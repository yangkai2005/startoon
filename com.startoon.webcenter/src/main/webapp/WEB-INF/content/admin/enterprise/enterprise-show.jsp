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
});
</script>

</head>

<body>
<div class="mTitle">
  <b class="bbig">注册会员详细</b>
</div>
<!--list -->
<div class="mainAdd">
<table class="addTable">
  <tr>
    <th><b>用户类型</b>:</th> 
	<td> <s:if test="enterprise.userType==0">个人会员</s:if><s:if test="enterprise.userType==1">企业会员</s:if> </td>
  </tr>
  <tr>
    <th><b>帐号</b>:</th> 
	<td> <s:label name="account"></s:label> </td>
  </tr>
  <tr>
    <th><b>昵称</b>:</th> 
	<td> <s:label name="nickname"></s:label> </td>
  </tr>
  <tr>
    <th><b>公司名称</b>:</th> 
	<td> <s:label name="name"></s:label> </td>
  </tr>
  <tr>
    <th><b>公司网站</b>:</th> 
	<td> <s:label name="siteUrl"></s:label> </td>
  </tr>
  <tr>
    <th><b>公司地址</b>:</th> 
	<td> <s:label name="address"></s:label> </td>
  </tr>
  <tr>
    <th><b>联系人 </b>:</th> 
	<td> <s:label name="linkman"></s:label> </td>
  </tr>
  <tr>
    <th><b>手机号码</b>:</th> 
	<td> <s:label name="mobilePhone"></s:label> </td>
  </tr>
  <tr>
    <th><b>固定电话</b>:</th> 
	<td> <s:label name="telephone"></s:label> </td>
  </tr>
  <tr>
    <th><b>传真</b>:</th> 
	<td> <s:label name="fax"></s:label> </td>
  </tr>
  <tr>
    <th><b>邮箱</b>:</th> 
	<td> <s:label name="email"></s:label> </td>
  </tr>
  <tr>
    <th><b>QQ</b>:</th> 
	<td> <s:label name="qq"></s:label> </td>
  </tr>
  <tr>
    <th><b>MSN</b>:</th> 
	<td> <s:label name="msn"></s:label> </td>
  </tr>
</table>
</div>
<!--end list -->
<div class="addToolbar">
<%--
    <p><button class="btn" type="button" onclick="location.href='<s:url action="enterprise-list" namespace="/admin/enterprise"/>?restore_params=true'">返回</button></p>
 --%>
    <p><button class="btn" type="button" onclick="javascript:history.back()">返回</button></p>
</div>
 
</body>
</html>