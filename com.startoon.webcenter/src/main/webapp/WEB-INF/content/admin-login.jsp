<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="${ctx}/css/Default.css" />
<link type="text/css" rel="stylesheet" href="${ctx}/css/xtree.css" />
<link type="text/css" rel="stylesheet" href="${ctx}/css/User_Login.css" />
</head>
<body id="userlogin_body">
<form action="${ctx}/admin-login.action" method="post">

<div></div>

<div id="user_login">
<dl>
	<dd id="user_top">
	<ul>
		<li class="user_top_l"></li>
		<li class="user_top_c"></li>
		<li class="user_top_r"></li>
	</ul>
	</dd>
	<dd id="user_main">
	<ul>
		<li class="user_main_l"></li>
		<li class="user_main_c">
		<div class="user_main_box">
		<ul>
			<li class="user_main_text">用户名：</li>
			<li class="user_main_input">
				<input type="text" name="account" class="txtusernamecssclass"/>
			</li>
		</ul>
		<ul>
			<li class="user_main_text">密&nbsp;&nbsp; &nbsp;码：</li>
			<li class="user_main_input">
				<input type="password" name="password" class="txtpasswordcssclass"/>
			</li>
		</ul>
		<ul>
			<li class="user_main_text">验证码：</li>
			<li class="user_main_input">
				<input type="text" name="ccode" class="txtvalidatecodecssclass"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<img src="${ctx}/ic" alt="点击更换验证码"/>
			</li>
		</ul>
		<ul>
			<li style="margin-left: 60px; color:red;"><s:actionerror /> </li>
		</ul>		
		</div>
		</li>
		<li class="user_main_r">
			<input class="IbtnEnterCssClass" type="image" src="${ctx}/images/user_botton.gif" style="border-top-width: 0px; border-left-width: 0px; border-bottom-width: 0px; border-right-width: 0px"/>
		</li>
	</ul>
	</dd>
	<dd id="user_bottom">
	<ul>
		<li class="user_bottom_l"></li>
		<li class="user_bottom_c"></li>
		<li class="user_bottom_r"></li>
	</ul>
	</dd>
</dl>
</div>
<span id="valrusername" style="display: none; color: red"></span>
<span id="valrpassword" style="display: none; color: red"></span>
<span id="valrvalidatecode" style="display: none; color: red"></span>
<div id="validationsummary1" style="display: none; color: red"></div>

<div></div>
</form>
</body>
</html>
