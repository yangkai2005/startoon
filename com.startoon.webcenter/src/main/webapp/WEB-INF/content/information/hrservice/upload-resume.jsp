<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="keywords" content="星力网，游戏机供应，游戏机采购，动漫游戏资讯，动漫游戏展会，卖游戏机"/>
<meta http-equiv="description" content="星力网是广州星力动漫游戏产业园打造的动漫游戏行业最专业的游戏机供应、游戏机采购平台，提供最新、最全的游艺产品、游戏产品、电玩产品、游戏机配件、电脑板、框体机、模拟机等供应信息、采购信息，星力网资讯频道为行业提供最专业的动漫游戏行业资讯、行业新闻。"/>
<title>星力网_中国动漫游艺门户_动漫游戏产品网络交易平台_动漫游戏行业资讯</title>
<link rel="stylesheet" type="text/css" href="${ctx}/information/css/style.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/information/css/common.css" />
<script type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>
<script type="text/javascript"> 
$(document).ready(function(){
	$('li#l11').addClass('hover');
	$('h2#h11').show();

	$('#inputResume').click(function() {
		window.location = '${ctx}/information/hrservice/talent!input.action';
	});
	
	$('a[rel=ad]').click(function() {
		var id = $(this).attr('id');
		$.post('${ctx}/information/advertisement/click.action', {'id':id});
	});
	
});
</script>
</head>

<body>
<div id="wrap">

<s:include value="/WEB-INF/content/information/inc/header.jsp"/>

<!--main star-->

<div class="main">

	<div class="uploadResume">

		<p class="titleJob">您应聘的是：<span class="orange">广州星力动漫游戏产业园有限公司</span>的<span class="orange">3D动漫设计</span>职位</p>

		<div class="uploadLeft">

			<p class="f14 b">声明：</p>

			<textarea class="noticeFrame">

尊敬的用户，欢迎您注册成为中观村e世界用户。在注册前请您仔细阅读如下服务条款：

一、服务内容：

1.中观村e世界的具体内容由中观村e世界根据实际情况提供，例如网上购物、促销信息、互动游戏、论坛(BBS)、发表产品评论等。

2.中观村e世界的具体内容由中观村e世界根据实际情况提供，例如网上购物、促销信息、互动游戏、论坛(BBS)、发表产品

评论等。

			</textarea>

			<p class="tc"><span class="mr10"><input type="radio" checked="checked" name="agreement" value="0" />同意</span><input type="radio" name="agreement" value="1" />不同意</p>

		</div>

		

		<div class="uploadRight">

			<p class="f13 b gray">已有一份word简历，直接上传我的简历来申请该职位</p>
			<form action="${ctx}/" enctype="multipart/form-data"></form>
			<table border="0" class="tableUpload">

			  <tr>

				<td>我的Email：</td>

				<td><input type="text" class="txtEmail" name="email" id="email" /></td>

			  </tr>

			  <tr>

				<td>请上传简历：</td>

				<td><input type="file" class="txtEmail" name="upload" id="upload" /><span class="ml10"></span></td>

			  </tr>

			  <tr>

				<td class="tc" colspan="2"><input type="button" class="btnSubmit" value="上传简历" /><input type="button" class="btnSubmit" value="在线填写简历" id="inputResume"/></td>

			  </tr>

			</table>

		</div>

		<div class="cls"></div>

	</div>

</div>



<div class="cls"></div>



<!--links star-->
<s:include value="/WEB-INF/content/information/inc/links.jsp"/>
<!--links over-->

<div class="cls"></div>

<!--foot star-->
<s:include value="/WEB-INF/content/information/inc/footer.jsp"/>

</div>

</body>

</html>

