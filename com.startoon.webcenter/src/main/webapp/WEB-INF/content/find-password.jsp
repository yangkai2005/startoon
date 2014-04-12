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

<link rel="stylesheet" type="text/css" href="${ctx}/css/member.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />

<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>

<link href="${ctx}/resources/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>

<script type="text/javascript"> 

$(document).ready(function(){
	<s:if test="error==1">alert('输入的邮箱不存在！');</s:if>
 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg);},onsuccess:function(){return true;}});

	$("#email").formValidator({onshow:"请输入注册时的邮箱",onfocus:"最多80个字符",oncorrect:"输入正确"})
		.inputValidator({min:1,max:80,empty:{leftempty:false,rightempty:false,emptyerror:"邮箱两边不能有空格"},onerror:"邮箱不能为空"})
		.regexValidator({regexp:"email",datatype:"enum",onerror:"邮箱格式不正确"});
});

</script>

</head>

<body>
<%-- header --%>
<s:include value="/inc/header.jsp"></s:include>
<%-- header --%>
<div id="wrap">


	    
<div class="cls"></div>


<!--main star-->
<div class="main">
	<div class="wangji">
		<div class="changjian"><img src="${ctx}/images/wen.jpg" align="absmiddle" /> <a href="${ctx}/help/help.action" style=" color:#000; text-decoration:underline">常见问题</a></div>
		<div class="cls"></div>
		<div class="wangjicon">
		<form id="form1" name="form1" action="${ctx}/find-password.action" method="post">
		<table width="100%" border="0" cellspacing="0" class="regtable">
		
		  <tr>
		    <td width="19%"><span class="f14"><strong>邮箱地址:</strong></span></td>
		    <td width="81%"><input id="email" name="email" type="text" class="txtreg1" style="width: 200px"/><span id="emailTip"></span></td>
		  </tr>
		  <!--
		  <tr>
		    <td>&nbsp;</td>
		    <td><input type="checkbox" name="checkbox" value="checkbox" />
		      将密码同时发送到我的注册手机</td>
		  </tr>
		  <tr>
		    <td><span class="f14"><strong>验&nbsp;证&nbsp;码:</strong></span></td>
		    <td><input name="Input4" type="text" class="txtreg2" /> 
		      <img src="images/yanzheng.jpg" width="69" height="24" style="vertical-align:middle"/> <a href="#">换个验证码</a></td>
		  </tr>
		  -->
		    <tr>
		    <td>&nbsp;</td>
		    <td style="padding:15px 0"><input type="submit" name="Submit" value="" class="btnzhaohui" /></td>
		  </tr>
		  <tr>
		    <td>&nbsp;</td>
		    <td style="color:#696969">如果您注册时填写的邮箱无法使用了，请联系我们<a href="#" style=" color:#000; text-decoration:underline"></a></td>
		  </tr>
		</table>
		</form>
		
		</div>
	
	
	</div>	

	<!-- //links -->

</div>




<div class="cls"></div>



</div>
	
<%-- footer --%>
<s:include value="/inc/footer.jsp"/>
<%-- footer --%>	
</body>
</html>