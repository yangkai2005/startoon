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
 	$.formValidator.initConfig({formid:"registerForm",onerror:function(msg){alert(msg)},onsuccess:function(){return true;}});
 	$("#userType").formValidator({onshow:"",onfocus:"请选择用户类型！",oncorrect:""}).inputValidator({min:6,max:100,onerror:"请选择用户类型！"});
 	//$("#email").formValidator({onshow:"",onfocus:"",oncorrect:""}).regexValidator({regexp:"email",datatype:"enum",onerror:"请输入正确的邮箱地址！"});
 	//$("#nickname").formValidator({onshow:"",onfocus:"",oncorrect:""}).inputValidator({min:2,max:100,onerror:"请填写昵称！"});
	$("#password1").formValidator({onshow:"请输入密码",onfocus:"密码不能为空",oncorrect:"密码合法"}).inputValidator({min:5,empty:{leftempty:false,rightempty:false,emptyerror:"密码两边不能有空符号"},onerror:"密码不能为空,请确认"});
	$("#password2").formValidator({onshow:"请输入重复密码",onfocus:"两次密码必须一致哦",oncorrect:"密码一致"}).inputValidator({min:5,empty:{leftempty:false,rightempty:false,emptyerror:"重复密码两边不能有空符号"},onerror:"重复密码不能为空,请确认"}).compareValidator({desid:"password1",operateor:"=",onerror:"2次密码不一致,请确认"});

	$("input:radio[name='sex']").formValidator({tipid:"sexTip",onshow:"请选择你的性别",onfocus:"没有第三种性别了，你选一个吧",oncorrect:"输入正确",defaultvalue:[1]}).inputValidator({min:1,max:1,onerror:"性别忘记选了,请确认"});
	$("input:radio[name='userType']").formValidator({tipid:"sexTip",onshow:"请选择用户类型",onfocus:"请选择用户类型",oncorrect:"输入正确",defaultvalue:[1]}).inputValidator({min:1,max:1,onerror:"用户类型忘记选了,请确认"});
	$("#vcode").formValidator({onshow:"",onfocus:"请填写验证码",oncorrect:""}).inputValidator({min:1,max:100,onerror:"验证码不能为空"});
	$("input:checkbox[name=agree]").formValidator({tipid:"agreeTip",onshow:"",onfocus:"",oncorrect:""}).inputValidator({min:1,onerror:"你还没有同意星力数码科技服务条款"});

	$("#email").formValidator({onshow:"请输入邮箱",onfocus:"最多80个字符",oncorrect:"输入正确"}).inputValidator({min:1,max:80,empty:{leftempty:false,rightempty:false,emptyerror:"邮箱两边不能有空格"},onerror:"邮箱不能为空"}).regexValidator({regexp:"email",datatype:"enum",onerror:"邮箱格式不正确"}).ajaxValidator({
	    type : "post",
		cache : false,
		addidvalue : true,
		url : "${ctx}/register!checkEmail.action",
		datatype : "html",
		data : "email=" + $(this).val(),
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
});

</script>
</head>

<body>

<%-- header --%>
<s:include value="/WEB-INF/content/inc/header.jsp"></s:include>
<%-- header --%>

	    
<div class="cls"></div>

<!--main star-->
<form action="${ctx}/register.action" id="registerForm">
<div class="main">
<div class="succ">
	<h1><div class="wenti">如遇注册问题请拨打：<span class="ye">020-39106666</span></div><img src="${pageContext.request.contextPath }/images/piclg.jpg" style="vertical-align:middle" /> <span class="hy">注册星力网，享受更多服务，把握更多商机！</span></h1>
	
	<h2>
	<p class="huiyuan">尊敬的  ${nickname } ,恭喜您成功注册成星力网会员。</p>
	<p class="huiyuan2"><span class="f14">请您记住您的登录账号：</span> ${email }</p>
	<p>
	<s:if test="userType==0">
	<a href="${ctx}/member/index.action?entId=<s:property value='enterpriseId'/>"><img src="${pageContext.request.contextPath }/images/huiyuanzhongxin.jpg" /></a>
	</s:if>
	
	<s:if test="userType==1">
	<a href="${pageContext.request.contextPath }/enterprise/enterprise/enterprise!info.action?entId=${enterpriseId}"><img src="${pageContext.request.contextPath }/images/huiyuanzhongxin.jpg" /></a>
	</s:if>
	
	</p>
	
	</h2>
	
	</div>
	
	
	
	</div>
</form>
<%-- main end --%>
  
  
<%-- footer --%>
<s:include value="/WEB-INF/content/inc/footer.jsp"/>
<%-- footer --%>
	
</body>
</html>