<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="中国游艺网——星力网,2012动漫游戏行业大型招聘会" />
<meta name="description" content="中国游艺网,星力网,2012动漫游戏行业大型招聘会" />
<title>中国游艺网,星力网,2012动漫游戏行业大型招聘会</title>
<script type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="${ctx}/resources/js"></script>

<link rel="stylesheet" type="text/css" href="${ctx}/resources/fancybox/jquery.fancybox-1.3.4.css"/>
<script type="text/javascript" src="${ctx}/resources/fancybox/jquery.fancybox-1.3.4.pack.js"></script>

<script type="text/javascript">
$(function() {
	// 修改修改分类
	$('a#grbm').fancybox({
		padding: 0,
		margin: 0,
		width: 200,
		height: 180,
		modal: true,
		type: 'iframe',
		showNavArrows: false, 
		scrolling: 'no'
	});
	
	$('a#register').click(function() {
		parent.$.fancybox.close();
	});
});
</script>

</head>
<body>
<div class="main">
<p>
	<span style="line-height:1.5;font-size:14px;"><strong>尊敬的客户：</strong></span> 
</p>
<p>
	<span style="line-height:1.5;"><span style="font-size:14px;">&nbsp;&nbsp;&nbsp;&nbsp;</span><span style="font-size:14px;">注册星力网</span><strong><span style="font-size:14px;">个人账号</span></strong><span style="font-size:14px;">并填写在线简历即可</span></span><span style="line-height:1.5;font-size:14px;">参加本次招聘大会，</span><span style="line-height:1.5;font-size:14px;">感谢您的参与！</span> 
</p>
<p>
	<span style="line-height:1.5;"><span style="font-size:14px;">&nbsp;&nbsp;&nbsp;&nbsp;</span><strong><span style="font-size:14px;">如何</span></strong></span><a id="register" href="http://www.chnam.com/register.jsp" target="_blank"><span style="line-height:1.5;color:#E53333;font-size:14px;"><strong>注册</strong></span></a><span style="line-height:1.5;"><strong><span style="font-size:14px;">个人账号</span></strong><span style="font-size:14px;">？</span></span> 
</p>
<p>
	<br/>
</p>
</div>
</body>
</html>