<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>中国电信·世界杯专题后台管理平台</title>

<link href="${ctx}/resources/css/admin.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body{background-color:#FAFAFA;} 
-->
</style>

</head>


<body>

<div class="welcomeTop">
<h1>您好，<s:property value="#session.username"/></h1>
<p>欢迎使用世界杯专题后台管理平台</p>
</div>

<div class="welcomeNewsBorder">
  <div class="newsTitle"><b>系统信息</b></div>
  <div class="welcomeNewsTop"><span class="">&nbsp;</span><b>欢迎使用世界杯专题后台管理平台</b></div>
  <div class="welcomeNewsBottom"><b>系统具有以下功能：</b></div>
  <div class="welcomeNewsBottom">
    <div class="list">板块管理</div>
	<div class="list">专题管理</div>
	<div class="list">用户评论管理</div>
	<div class="list">投票管理</div>
	<div class="list">统计分析</div>
  </div>
</div>

<div class="copyright">Copyright &copy; 2008-2009 &nbsp;All Rights Reserved</div>
</body>
</html>
