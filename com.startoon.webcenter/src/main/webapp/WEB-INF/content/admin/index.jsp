<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>用户登录</TITLE>
<LINK href="${ctx}/css/Default.css" type=text/css rel=stylesheet>
<LINK href="${ctx}/css/xtree.css" type=text/css rel=stylesheet>
<LINK href="${ctx}/css/User_Login.css" type=text/css rel=stylesheet>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<META content="MSHTML 6.00.6000.16674" name=GENERATOR>
</HEAD>
<BODY id=userlogin_body>
<form action="${ctx}/admin/login.action" method="post">

<DIV></DIV>

<DIV id=user_login>
<DL>
	<DD id=user_top>
	<UL>
		<LI class=user_top_l></LI>
		<LI class=user_top_c></LI>
		<LI class=user_top_r></LI>
	</UL>
	<DD id=user_main>
	<UL>
		<LI class=user_main_l></LI>
		<LI class=user_main_c>
		<DIV class=user_main_box>
		<UL>
			<LI class=user_main_text>用户名：</LI>
			<LI class=user_main_input>
				<input type="text" name="account" class="TxtUserNameCssClass"/>
			</LI>
		</UL>
		<UL>
			<LI class=user_main_text>密&nbsp;&nbsp; &nbsp;码：</LI>
			<LI class=user_main_input>
				<input type="password" name="password" class="TxtPasswordCssClass"/>
			</LI>
		</UL>
		<UL>
			<LI class=user_main_text>验证码：</LI>
			<LI class=user_main_input>
				<input type="text" name="ccode" class="TxtValidateCodeCssClass"/>
				<img src="${ctx}/ic" alt="点击更换验证码"/>
			</LI>
		</UL>
		</DIV>
		</LI>
		<LI class="user_main_r">
			<input class="IbtnEnterCssClass" type="image" src="${ctx}/images/user_botton.gif" style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px"/>
		</LI>
	</UL>
	<DD id=user_bottom>
	<UL>
		<LI class=user_bottom_l></LI>
		<LI class=user_bottom_c></LI>
		<LI class=user_bottom_r></LI>
	</UL>
	</DD>
</DL>
</DIV>
<SPAN id=ValrUserName style="DISPLAY: none; COLOR: red"></SPAN>
<SPAN id=ValrPassword style="DISPLAY: none; COLOR: red"></SPAN>
<SPAN id=ValrValidateCode style="DISPLAY: none; COLOR: red"></SPAN>
<DIV id=ValidationSummary1 style="DISPLAY: none; COLOR: red"></DIV>

<DIV></DIV>
</form>
</BODY>
</HTML>
