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
<script src="${ctx}/resources/js/jquery.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/js/nav.js"></script>

<link href="${ctx}/resources/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>

<script type="text/javascript"> 
$(document).ready(function(){
	<s:if test="flag==0">alert('密码修改成功！');</s:if>
	<s:if test="flag==1">alert('修改失败！请确认原密码是否正确！');</s:if>
	
 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg)},onsuccess:function(){return true;}});
	$("#oldpwd").formValidator({onshow:"请输入原密码",onfocus:"原密码不能为空",oncorrect:"密码合法"}).inputValidator({min:6,empty:{leftempty:false,rightempty:false,emptyerror:"密码两边不能有空符号"},onerror:"密码至少为6个字符,请确认"});
	$("#password1").formValidator({onshow:"请输入密码",onfocus:"密码不能为空",oncorrect:"密码合法"}).inputValidator({min:6,empty:{leftempty:false,rightempty:false,emptyerror:"密码两边不能有空符号"},onerror:"密码至少为6个字符,请确认"});
	$("#password2").formValidator({onshow:"请输入重复密码",onfocus:"两次密码必须一致哦",oncorrect:"密码一致"}).inputValidator({min:6,empty:{leftempty:false,rightempty:false,emptyerror:"重复密码两边不能有空符号"},onerror:"重复密码不能为空,请确认"}).compareValidator({desid:"password1",operateor:"=",onerror:"2次密码不一致,请确认"});
<%--
	$("#account").formValidator({onshow:"请输入修改后的登录帐号",onfocus:"最多80个字符",oncorrect:"输入正确"}).inputValidator({min:1,max:80,empty:{leftempty:false,rightempty:false,emptyerror:"帐号两边不能有空格"},onerror:"帐号不能为空"}).regexValidator({regexp:"email",datatype:"enum",onerror:"帐号格式不正确，必须为有效的邮箱！"}).ajaxValidator({
	    type : "post",
		cache : false,
		addidvalue : true,
		url : "${ctx}/enterprise/base/base-info!check.action",
		datatype : "html",
		data : "account=" + $(this).val(),
		success : function(data){
            if(data == "success" ){
                return true;
			}else{
                return false;
			}
		},
		error: function(){alert("服务器忙，请重试");},
		onerror : "您注册的帐号已存在",
		onwait : "正在对帐号进行校验..."
	}).defaultPassed();
--%>
	

	$("#btnSubmit").click(function() {
		$("form").submit();
	});

	$("#btnReset").click(function() {
		$("#password1").val("");
		$("#password2").val("");
	});
	
});

</script>

</head>

<body>

<%-- header --%>
<s:include value="/inc/header.jsp"></s:include>
<%-- header --%>
		

<div class="cls"></div>


<!--main star-->
<div class="main">

<div class="member">
<%-- left --%>
<s:include value="/inc/member-left.jsp"></s:include>
<%-- left --%>

<s:form namespace="/enterprise/base" action="base-info!modify" name="form1" id="form1">
<div class="memright">
<div class="title4"> <div class="hotline">客服热线：020-39106666</div>
	 <div class="titlemu2">
	
	 
	 <h2 class="q3"><a href="${ctx}/enterprise/enterprise/enterprise!info.action">注册信息</a></h2> 
	 </div>
	 </div>
	 
	<div class="memcon">
	<table width="100%" border="0" cellspacing="0" class="regtable2">
	
	<%--
	  <tr>
	    <td width="9%">登录帐号：</td>
	    <td colspan="2"> <s:textfield name="account" id="account" cssClass="txtreg1" value="%{#session.enterprise_user.account}"></s:textfield><span id="accountTip"></span> </td>
	    </tr>
	 --%>
	  <tr>
	    <td>原密码：</td>
	    <td colspan="2"><s:password name="oldpwd" id="oldpwd" cssClass="txtreg1"></s:password><span id="oldpwdTip"></span></td>
	    </tr>
	  <tr>
	    <td>新密码：</td>
	    <td colspan="2"><s:password name="password" id="password1" cssClass="txtreg1"></s:password><span id="password1Tip"></span></td>
	    </tr>
	  <tr>
	    <td>确认密码：</td>
	    <td colspan="2"> <s:password name="repwd" id="password2" cssClass="txtreg1"></s:password><span id="password2Tip"></span></td>
	    </tr>
	  <tr>
	    <td></td>
	    <td colspan="2">
	    	<input id="btnSubmit" type="button" name="preview"  value="确定"  class="btn02" />
			<input id="btnReset" name="Input4" type="button"  value="取消"  class="btn01"/>
	    </td>
	    </tr>
	
	</table>
	</div>
	 
	 
</s:form>
</div>
   <!--  //memberright over--> 
</div>
<!--  //member over-->
<div class="cls"></div>
<%-- footer --%>
<s:include value="/inc/footer.jsp"/>
<%-- footer --%>	
</body>
</html>