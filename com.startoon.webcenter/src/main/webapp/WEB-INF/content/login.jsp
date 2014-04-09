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
<script type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="${ctx}/js/dialog.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery.example.min.js"></script>
<script type="text/javascript" src="${ctx}/js/nav.js"></script>


<style type="text/css">
#floatBoxBg{display:none;width:100%;height:100%;background:#000;position:absolute;top:0;left:0;}
.floatBox{width:739px;position:absolute;top:50px;left:40%;}
.floatBox .title{height:23px;padding:7px 10px 0;background:#77A3CA;color:#fff;}
.floatBox .title h4{float:left;padding:0;margin:0;font-size:14px;line-height:16px;}
.floatBox .title span{float:right;cursor:pointer;}
.floatBox .title span img{padding-top:0px;padding-left:0px;}
.floatBox .content{padding:20px 15px;background:#fff;}

#box{padding:20px;margin:0 50px;background:#999;font-size:14px;}
#box h1{font-size:40px;line-height:50px;height:90px;}
#box #testFloatBox{position:static;margin:20px 0;}
#box table{margin:20px 0;}
#box h3{font-size:16px;padding:20px 0 10px;}
code{font-size:12px;color:#333;margin:10px;display:block;}
#box ol{margin:0;padding:0;list-style-position:inside;list-style-type:decimal;}
#box ol li{margin:0 0 20px 0;line-height:18px;}
#box ol li span{color:#00f;text-decoration:underline;cursor:pointer;}
#box ol li strong{display:block;}
body .iframe .content{padding:0;}
#box .title span{font-size:12px;}
#box p{line-height:18px;}

</style>
<script type="text/javascript">
$(document).ready(function() {

	$('#account').example('请输入您注册的邮箱');
	
	$("#register").click(function () {
		window.location = "${ctx}/register.jsp";
	});

	$(':radio[name=userType]').click(function() {
		var v = $(this).val();
		var e = "企业会员，请登陆";
		var p = "个人会员，请登陆";
		if(v==0) { //个人
			$("span.hy").html(p);			
		} else { //企业
			$("span.hy").html(e);			
		}
	});

});
</script>

</head>

<body>

<%-- header --%>
<s:include value="/WEB-INF/content/inc/header.jsp"></s:include>
<%-- header --%>

<div class="cls"></div>

<!--main star-->
 <s:form name="loginForm" namespace="/" action="ent-login.action">  
<div class="main">
	<div class="login">
	<div class="loginleft"><img src="${ctx}/images/login.jpg" style="display:block" />
	</div>
	<div class="loginight">
	<h1 style="font-size: 14px"><input name="userType" type="radio" value="0"/>个人会员&nbsp;&nbsp;&nbsp;<input name="userType" type="radio" value="1" checked="checked"/>企业会员</h1>
	<h2>
	<table width="100%" border="0" cellspacing="0" class="logintable">
  <tr>
    <td colspan="2"><img src="${ctx}/images/piclg.jpg" style="vertical-align:middle"/> <span class="hy">企业会员，请登陆</span></td>
    </tr>
  <tr>
    <td width="14%">帐 号<br /></td>
    <td width="86%"> <s:textfield id="account" name="account" cssClass="txtlogin1"></s:textfield> </td>
  </tr>
  <tr>
    <td>密 码</td>
    <td> <s:password name="password" cssClass="txtlogin1"></s:password> </td>
  </tr>
  <tr>
    <td colspan="2" align="center"><font color="#FF0000" style="font-size: 12px;"><b><s:property value="message"/></b></font></td>
    </tr>  
  <tr>
    <td>&nbsp;</td>
    <td  style="padding-top:10px"> <s:submit cssClass="btnlog" value=""></s:submit>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" name="register" value="" class="btnreg" id="register"/></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td  style="padding-top:8px"><a href="${ctx}/find-password.jsp">忘记密码？</a><!-- <a href="#">忘记用户名？</a> -->&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
  </tr>
</table>
	</h2>
	</div>
	</div>
</s:form>
<%-- footer --%>
<s:include value="/WEB-INF/content/inc/footer.jsp"/>
<%-- footer --%>
	
</body>
</html>