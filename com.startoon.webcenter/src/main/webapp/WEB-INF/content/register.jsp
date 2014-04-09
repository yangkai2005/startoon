<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>

<%@page import="org.j2eeframework.commons.util.SystemContext"%>
<%@page import="org.j2eeframework.startoon.service.NewsService"%>
<%@page import="org.j2eeframework.startoon.entity.News"%>

<%
NewsService newsService = (NewsService)SystemContext.getApplicationContext().getBean("newsService");
News news = newsService.getEntityById(8L);
String agreement = news.getContent();
request.setAttribute("agreement", agreement);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="keywords" content="星力网，游戏机供应，游戏机采购，动漫游戏资讯，动漫游戏展会，卖游戏机"/>
<meta http-equiv="description" content="星力网是广州星力动漫游戏产业园打造的动漫游戏行业最专业的游戏机供应、游戏机采购平台，提供最新、最全的游艺产品、游戏产品、电玩产品、游戏机配件、电脑板、框体机、模拟机等供应信息、采购信息，星力网资讯频道为行业提供最专业的动漫游戏行业资讯、行业新闻。"/>
<title>星力网_中国动漫游艺门户_动漫游戏产品网络交易平台_动漫游戏行业资讯</title>

<script type="text/javascript" src="js/nav.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/index.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/member.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />

<script type="text/javascript" src="${ctx}/js/dialog.js"></script>
<script language="javascript1.1" type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>

<link href="${ctx}/resources/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>


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
$(document).ready(function(){

 	$.formValidator.initConfig({formid:"registerForm",onerror:function(msg){alert(msg);},onsuccess:function(){return true;}});
	$("#password1").formValidator({onshow:"请输入密码",onfocus:"密码不能为空",oncorrect:"密码合法"}).inputValidator({min:5,empty:{leftempty:false,rightempty:false,emptyerror:"密码两边不能有空符号"},onerror:"密码不能为空,请确认"});
	$("#password2").formValidator({onshow:"请输入重复密码",onfocus:"两次密码必须一致哦",oncorrect:"密码一致"}).inputValidator({min:5,empty:{leftempty:false,rightempty:false,emptyerror:"重复密码两边不能有空符号"},onerror:"重复密码不能为空,请确认"}).compareValidator({desid:"password1",operateor:"=",onerror:"2次密码不一致,请确认"});

	$("input:radio[name=sex]").formValidator({tipid:"sexTip",onshow:"请选择你的性别",onfocus:"没有第三种性别了，你选一个吧",oncorrect:"输入正确",defaultvalue:[1]}).inputValidator({min:1,max:1,onerror:"性别忘记选了,请确认"});
	$("input:radio[name=userType]").formValidator({tipid:"userTypeTip",onshow:"请选择用户类型",onfocus:"请选择用户类型",oncorrect:"输入正确",defaultvalue:[1]}).inputValidator({min:1,max:1,onerror:"用户类型忘记选了,请确认"});
	$("#vcode").formValidator({onshow:"",onfocus:"请填写验证码",oncorrect:""}).inputValidator({min:1,max:100,onerror:"验证码不能为空"});
	$("input:checkbox[name=agree]").formValidator({tipid:"agreeTip",onshow:"",onfocus:"",oncorrect:""}).inputValidator({min:1,onerror:"你还没有同意星力数码科技服务条款"});

	$("#name").formValidator({tipid:"",onshow:"请填写公司名称",onfocus:"请填写公司名称",oncorrect:"输入正确"});
	$("#linkman").formValidator({tipid:"",onshow:"请填写联系人",onfocus:"请填写联系人",oncorrect:"输入正确"});
	$("#mobilePhone").formValidator({tipid:"",onshow:"请填写联系方式",onfocus:"请填写联系方式",oncorrect:"输入正确"});
	$("#address").formValidator({tipid:"",onshow:"请填写地址",onfocus:"请填写地址",oncorrect:"输入正确"});
	$("#nickname").formValidator({tipid:"",onshow:"请填写昵称",onfocus:"请填写昵称",oncorrect:"输入正确"});

	$("#email").formValidator({onshow:"请输入邮箱",onfocus:"最多50个字符",oncorrect:"输入正确"})
		.inputValidator({min:1,max:50,empty:{leftempty:false,rightempty:false,emptyerror:"邮箱两边不能有空格"},onerror:"邮箱不能为空"})
		.regexValidator({regexp:"email",datatype:"enum",onerror:"邮箱格式不正确"})
		.ajaxValidator({
			url   : "${ctx}/register!checkEmail.action",
			data  : {email:$(this).val()},
			success : function(data){
	            if(data == "success" ){
	                return true;
				}else{
	                return false;
				}
			},
			error: function(){alert("服务器忙，请重试");},
			onerror : "您注册的邮箱已存在",
			onwait : "正在对邮箱进行校验..."
		});

	$(":radio[name=userType]").click(function() {
		var v = $(this).val();
		if(v==0) {
			$("span#addr1").show();
			$("span#addr2").hide();
			hideEnt();
			$("#userTypeTip").html('<font color="red">你选择的是：个人会员</font>');
		}
		if(v==1) {
			$("span#addr2").show();
			$("span#addr1").hide();
			showEnt();
			$("#userTypeTip").html('<font color="red">你选择的是：企业会员</font>');
		}
		
	});

	$('form').submit(function() {
		var ut = $(":radio[name=userType]:checked").val();
		var addr = $("#address").val();
		var name = $("#name").val();
		var linkman = $("#linkman").val();
		var phone = $("#mobilePhone").val();

		//alert("userType" + ut + "|address:" + addr + "|name:" + name + "|linkman:" + linkman + "|phone:" + phone );

		if(ut==1) {
			if(name=="") {
				alert("公司名称为必填");
				return false;
			}
			if(addr=="") {
				alert("公司地址为必填");
				return false;
			}
			
			if(linkman=="") {
				alert("联系人为必填");
				return false;
			}
			
			if(phone=="") {
				alert("联系方式为必填");
				return false;
			}
		}
		
		
	});
});

function showEnt() {
	$('#trname').show();
	$('#trlinkman').show();
	$('#trmobilephone').show();
}
function hideEnt() {
	$('#trname').hide();
	$('#trlinkman').hide();
	$('#trmobilephone').hide();
}

</script>
</head>

<body>

<%-- header --%>
<s:include value="/WEB-INF/content/inc/header.jsp"></s:include>
<%-- header --%>

	    
<div class="cls"></div>

<!--main star-->
<s:form namespace="/" action="register" id="registerForm">
<div class="main">
	<div class="reg">
	<h1><div class="wenti">如遇注册问题请拨打：<span class="ye">020-39106666</span></div><img src="${ctx}/images/piclg.jpg" style="vertical-align:middle" /> <span class="hy">注册星力网，享受更多服务，把握更多商机！</span></h1>
	<h2>
<table width="100%" border="0" cellspacing="0" class="regtable" style="width:750px;">
  <tr>
  	<td>&nbsp;</td>
  	<th>
    	<s:radio list="#{0:'个人会员',1:' 企业会员'}" name="userType"></s:radio><span id="userTypeTip"></span>
  	</th>
  </tr>
  <tr>
    <td width="80"><span class="f14">电子邮箱</span></td>
    <td><input id="email" name="email" type="text" class="txtreg1" /><font color="red">(即登录帐号)</font><span id="emailTip"></span> </td>
  </tr>
  <tr>
    <td><span class="f14">性&nbsp;&nbsp;&nbsp;&nbsp;别</span></td>
    <td>
    	<s:radio list="#{0:'男', 1:'女'}" name="sex" id="sex"></s:radio><span id="sexTip"></span>
	  </td>
  </tr>
  <tr>
    <td><span class="f14">昵&nbsp;&nbsp;&nbsp;&nbsp;称</span></td>
    <td><input id="nickname" name="nickname" type="text" class="txtreg1"/> <span id="nicknameTip"></span> </td>
  </tr>
  <tr id="trname" style="display: none;">
    <td><span class="f14">公司名称</span></td>
    <td><input id="name" name="name" type="text" class="txtreg1"/> <span id="nameTip"></span> </td>
  </tr>
  <tr>
    <td><span class="f14" id="addr1">所&nbsp;在&nbsp;地</span><span class="f14" style="display:none;" id="addr2">公司地址</span></td>
    <td> <s:textfield name="address" id="address" cssClass="txtreg1"></s:textfield> <span id="addressTip"></span> </td>
  </tr>
  <tr id="trlinkman" style="display: none;">
    <td><span class="f14">联&nbsp;系&nbsp;人</span></td>
    <td><input  id="linkman"  name="linkman" type="text" class="txtreg1" /> <span id="linkmanTip"></span></td>
  </tr>
  <tr id="trmobilephone" style="display: none;">
    <td><span class="f14">联系方式</span></td>
    <td><input  id="mobilePhone"  name="mobilePhone" type="text" class="txtreg1" /> <span id="mobilePhoneTip"></span></td>
  </tr>
  <tr>
    <td><span class="f14">密&nbsp;&nbsp;&nbsp;&nbsp;码</span></td>
    <td><input id="password1" name="password" type="password" class="txtreg1" /> <span id="password1Tip"></span> </td>
  </tr>
  <tr>
    <td><span class="f14">确认密码</span></td>
    <td><input  id="password2"  name="repwd" type="password" class="txtreg1" /> <span id="password2Tip"></span> </td>
  </tr>
  <tr>
    <td><span class="f14">验&nbsp;证&nbsp;码</span></td>
    <td><input id="vcode" name="vcode" type="text" class="txtreg1" style="width:80px;"/> 
      <img src="${ctx}/ic" width="60" height="20" style="vertical-align:middle" />  <span id="vcodeTip"></span> </td>
  </tr>
	<tr>
    <td>&nbsp;</td>
    <td>
    	<FCK:editor instanceName="content" height="200" width="400" toolbarSet="None">
				<jsp:attribute name="value">
					${agreement }
				</jsp:attribute>
		</FCK:editor>    
      </td>
 	</tr>  
  <tr>
    <td>&nbsp;</td>
    <td><input name="agree" type="checkbox" value="0" id="agree" checked="checked"/>我同意星力数码科技服务条款<span id="agreeTip"></span> </td>
  </tr>
</table>
<div class="cls"></div>
	
	</h2>
	<h3>
	<p align="center"><input name="submit" type="submit" class="btnreg1" value=""/></p>
	</h3>
	
	</div>
</s:form>
<%-- main end --%>
  
  
<%-- footer --%>
<s:include value="/WEB-INF/content/inc/footer.jsp"/>
<%-- footer --%>
	
</body>
</html>