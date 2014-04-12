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

<link rel="stylesheet" type="text/css" href="${ctx}/css/member.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />


<script type="text/javascript" src="${ctx}/js/dialog.js"></script>
<script language="javascript1.1" type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>

<link href="${ctx}/resources/css/validator.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>

<script type="text/javascript"> 
$(document).ready(function(){
	<s:if test="success">alert('修改密码成功！');</s:if>
 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg)},onsuccess:function(){return true;}});
	$("#password").formValidator({onshow:"请输入原始密码",onfocus:"原始密码不能为空",oncorrect:"密码合法"}).inputValidator({min:6,empty:{leftempty:false,rightempty:false,emptyerror:"密码两边不能有空符号"},onerror:"密码至少为6个字符,请确认"});
	$("#password1").formValidator({onshow:"请输入新密码",onfocus:"新密码不能为空",oncorrect:"密码合法"}).inputValidator({min:6,empty:{leftempty:false,rightempty:false,emptyerror:"新密码两边不能有空符号"},onerror:"密码至少为6个字符,请确认"});
	$("#password2").formValidator({onshow:"请输入重复密码",onfocus:"两次密码必须一致哦",oncorrect:"密码一致"}).inputValidator({min:6,empty:{leftempty:false,rightempty:false,emptyerror:"重复密码两边不能有空符号"},onerror:"重复密码不能为空,请确认"}).compareValidator({desid:"password1",operateor:"=",onerror:"2次密码不一致,请确认"});
});

</script>

</head>

<body>

<%-- header --%>
<s:include value="/WEB-INF/content/inc/header.jsp"></s:include>
<%-- header --%>
  
<%-- main begin --%>
<div class="main">

<div class="member">

<%-- main left begin --%>
<s:include value="/WEB-INF/content/inc/person-left.jsp"/>
<%-- main left end --%>

<%-- main right begin --%>
<div class="memright">
<div class="geleft">
<div class="title5">
	 <div class="titlemu2">

	 <h2 class="q3">修改密码</h2> 
	
	 </div>
	 </div>
	 
	<div class="grmemcon">
	<s:form name="/member/base" action="base-info!modifyPassword">
	<table width="100%" border="0" cellspacing="0" class="regtable2">
  <tbody>
  <tr><td><s:actionerror/></td></tr>
  <tr>
    <td width="16%">原有密码：</td>
    <td width="84%" colspan="2"><s:password name="oldPwd" cssClass="txtge3" id="password"></s:password> <span id="passwordTip"></span> </td>
    </tr>
  <tr>
    <td>请设置新密码：</td>
    <td colspan="2"><s:password name="newPwd" cssClass="txtge3" id="password1"></s:password><span id="password1Tip"></span></td>
    </tr>
	 <tr>
    <td>重复输入密码：</td>
    <td colspan="2"><s:password name="newPwd1" cssClass="txtge3" id="password2"></s:password><span id="password2Tip"></span></td>
    </tr>
	
  <tr>
    <td></td>
    <td colspan="2"><input name="" type="submit" value="确 定" class="mbtn2"/> <input name="" type="reset" value="重 置" class="mbtn2"/> </td>
    </tr>
 
</tbody></table>
</s:form>
	</div>
	<div class="cls"></div>
	 </div>
	 
	 <div class="geright">
	  <a href="#"><img src="${ctx}/images/pico2.jpg" width="191" height="235"/></a>
	   <a href="#"><img src="${ctx}/images/pico2.jpg" width="191"/></a>
	 </div>

</div>
<%-- main right end --%>

</div>

<div class="cls"></div>
<div class="cls"></div>

</div>
<%-- main end --%>
  
<%-- footer --%>
<s:include value="/WEB-INF/content/inc/footer.jsp"/>
<%-- footer --%>
	
</body>
</html>