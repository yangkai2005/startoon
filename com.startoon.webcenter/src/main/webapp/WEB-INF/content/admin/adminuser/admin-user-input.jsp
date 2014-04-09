<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="keywords" content="星力网，游戏机供应，游戏机采购，动漫游戏资讯，动漫游戏展会，卖游戏机"/>
<meta http-equiv="description" content="星力网是广州星力动漫游戏产业园打造的动漫游戏行业最专业的游戏机供应、游戏机采购平台，提供最新、最全的游艺产品、游戏产品、电玩产品、游戏机配件、电脑板、框体机、模拟机等供应信息、采购信息，星力网资讯频道为行业提供最专业的动漫游戏行业资讯、行业新闻。"/>
<title>星力网_中国动漫游艺门户_动漫游戏产品网络交易平台_动漫游戏行业资讯</title>

<link href="${ctx}/resources/css/admin.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/resources/js/jquery.js" type="text/javascript"></script>
<link href="${ctx}/resources/v2/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>

<script type="text/javascript"> 
$(document).ready(function(){
	<s:if test="accountRepeat">alert("帐号已经存在，请重新选择!");</s:if>
 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg);},onsuccess:function(){return true;}});
 	$("#name").formValidator({onshow:"",onfocus:"管理员名称不能为空",oncorrect:""}).inputValidator({min:1,max:100,onerror:"管理员名称不能为空"});
 	$("#account").formValidator({onshow:"",onfocus:"帐号不能为空",oncorrect:""})
 		.inputValidator({min:1,max:100,onerror:"帐号不能为空"});
		/*
 		.ajaxValidator({
 		    type : "post",
 			cache : false,
 			url : "${ctx}/admin/adminuser/admin-user!checkAccount.action",
 			datatype : "json",
 			data : "account=" + $(this).val(),
 			success : function(data){
 	            if(data == "success" ){
 	                return true;
 				}else{
 	                return false;
 				}
 			},
 			error: function(){alert("服务器忙，请重试");},
 			onerror : "帐号已存在",
 			onwait : "正在对帐号进行校验..."
 		});
 		*/ 


	$("#password1").formValidator({onshow:"请输入密码",onfocus:"密码不能为空",oncorrect:"密码合法"}).inputValidator({min:6,empty:{leftempty:false,rightempty:false,emptyerror:"密码两边不能有空符号"},onerror:"密码最少为6位,请确认"});
	$("#password2").formValidator({onshow:"请输入重复密码",onfocus:"两次密码必须一致哦",oncorrect:"密码一致"}).inputValidator({min:6,empty:{leftempty:false,rightempty:false,emptyerror:"重复密码两边不能有空符号"},onerror:"密码最少为6位,请确认"}).compareValidator({desid:"password1",operateor:"=",onerror:"2次密码不一致,请确认"});

			
});
</script>

</head>

<body>
<div class="mTitle">
  <b class="bbig">后台管理员</b>
</div>
<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/admin/adminuser">
<s:hidden name="nextMethod" />
<s:hidden name="requestId" />
<s:hidden name="id" />
<!--list -->
<div class="mainAdd">
<table class="addTable">
  <tr>
    <th>管理员名称:</th> 
	<td> <input type="text" name="name" id="name" size="30"/> <span id="nameTip"></span> </td>
  </tr>
  <tr>
    <th>管理员帐号:</th> 
	<td> <input type="text" name="account" id="account" size="30"/> <span id="accountTip"></span> </td>
  </tr>
  <tr>
    <th>管理员密码:</th> 
	<td> <s:password name="password" id="password1" size="30"></s:password><span id="password1Tip"></span> </td>
  </tr>
  <tr>
    <th>重复密码:</th> 
	<td> <s:password name="password1" id="password2" size="30"></s:password><span id="password2Tip"></span> </td>
  </tr>
</table>
</div>
<!--end list -->
<div class="addToolbar">
    <p><button class="btn" type="submit"><b>submit</b></button>
    <button class="btn" type="button" onclick="location.href='<s:url action="admin-user-list" namespace="/admin/adminuser"/>?restore_params=true'">cancel</button></p>
</div>
 
 </s:form>
</body>
</html>