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
	<s:if test="%{msg=='success'}">alert('密码修改成功！');</s:if>
 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg);},onsuccess:function(){return true;}});
 	$("#oldPwd").formValidator({onshow:"请输入原始密码",onfocus:"原始密码为空",oncorrect:""}).inputValidator({min:1,max:100,onerror:"原始密码为空"});
	$("#password1").formValidator({onshow:"请输入新密码",onfocus:"密码不能为空",oncorrect:"密码合法"}).inputValidator({min:6,empty:{leftempty:false,rightempty:false,emptyerror:"密码两边不能有空符号"},onerror:"密码最少为6位,请确认"});
	$("#password2").formValidator({onshow:"请输入确认密码",onfocus:"两次密码必须一致",oncorrect:"密码一致"}).inputValidator({min:6,empty:{leftempty:false,rightempty:false,emptyerror:"重复密码两边不能有空符号"},onerror:"密码最少为6位,请确认"}).compareValidator({desid:"password1",operateor:"=",onerror:"2次密码不一致,请确认"});

			
});
</script>

</head>

<body>
<div class="mTitle">
  <b class="bbig">后台管理员</b>
</div>
<s:form id="form1" action="admin-user!password" namespace="/admin/adminuser">
<s:hidden name="requestId" value="%{#session.admin_user_id}" />
<s:hidden name="id" value="%{#session.admin_user_id}" />
<!--list -->
<div class="mainAdd">
<table class="addTable">
  <tr>
    <th>原始密码:</th> 
	<td> <s:password name="oldPwd" id="oldPwd" size="30"/><span id="oldPwdTip"></span> </td>
  </tr>
  <tr>
    <th>新密码:</th> 
	<td> <s:password name="newPwd" id="password1" size="30"/><span id="password1Tip"></span> </td>
  </tr>
  <tr>
    <th>重复密码:</th> 
	<td> <s:password name="password2" id="password2" size="30"/><span id="password2Tip"></span> </td>
  </tr>
</table>
</div>
<!--end list -->
<div class="addToolbar">
    <p><button class="btn" type="submit"><b>确  定</b></button> <s:reset value="重  置" cssClass="btn"></s:reset> </p>
</div>
 
 </s:form>
</body>
</html>