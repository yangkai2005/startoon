<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>星力动漫·后台管理平台</title>

<link href="${ctx}/resources/css/admin.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body{background-color:#FAFAFA;} 
-->
</style>

</head>


<body>

<div class="welcomeTop">
<h1>您好，<s:property value="#session.admin_user.account"/> </h1>
<p>欢迎使用星力网后台管理平台</p>
</div>

<div class="welcomeNewsBorder">
  <div class="newsTitle"><b></b></div>
  <div class="welcomeNewsTop"><span class="">&nbsp;</span><b>欢迎使用后台管理平台</b></div>
  <div class="welcomeNewsBottom"><b>你具有以下操作功能：</b></div>
  <div class="welcomeNewsBottom">
	  <s:iterator value="#session.admin_user.permission[1]">
	    <div class="list"><a href="<s:property value='path'/>"><s:property value='name'/></a></div>
	  </s:iterator>  
	  <s:iterator value="#session.admin_user.permission[2]">
	    <div class="list"><a href="<s:property value='path'/>"><s:property value='name'/></a></div>
	  </s:iterator>
	  <s:iterator value="#session.admin_user.permission[3]">
	    <div class="list"><a href="<s:property value='path'/>"><s:property value='name'/></a></div>
	  </s:iterator>  
	  <s:iterator value="#session.admin_user.permission[4]">
	    <div class="list"><a href="<s:property value='path'/>"><s:property value='name'/></a></div>
	  </s:iterator>  
  </div>
</div>

<div class="copyright">Copyright &copy; 2010-2011 &nbsp;All Rights Reserved</div>
</body>
</html>
