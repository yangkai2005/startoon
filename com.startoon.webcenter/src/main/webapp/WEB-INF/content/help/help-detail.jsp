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

<script type="text/javascript" src="${pageContext.request.contextPath }/js/nav.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index.css" />
<script src="${ctx}/resources/js/jquery.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/resources/css/validator.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/css/help.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${pageContext.request.contextPath }/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${pageContext.request.contextPath }/resources/js/formValidatorRegex.js" type="text/javascript"></script>

<script type="text/javascript"> 
$(document).ready(function(){
	//loadSub("");
	var ids = '${ids}';
	if(ids=="")ids=6;//帮助中心-->常见问题
	$('li').removeClass('qq');  
	$("#li"+ids).addClass("qq"); 
});

//获取二级分类列表
function loadSub(ids,cid){
	if(parseInt(ids)==8){
		$("div[class=tiwen]").css("display","");
		$("#showsubhelp").css("display","none");
	}else{
		$("div[class=tiwen]").css("display","none");
		$("#showsubhelp").css("display","");
		$("#showsubhelp").load("${pageContext.request.contextPath}/help/help!list.action?cid="+cid+"&ids="+ids);
		$('li').removeClass('qq');  
		$("#li"+ids).addClass("qq"); 
	}

}

function doSubmit(){

	if(g("name").value==""){
		alert("姓名不能为空!");
		g("name").focus();
		return false;
	}
	if(g("phone").value==""){
		alert("电话不能为空!");
		g("phone").focus();
		return false;
	}

	if(g("email").value.trim()!=""){
		if(g("email").value.trim().isEmail()){
			alert("电子邮箱格式不正确!");
		}
	}
	
	if(g("content").value==""){
		alert("问题不能为空!");
		g("content").focus();
		return false;
	}
	
	return true;
}
</script>

</head>
<body>
<s:include value="/WEB-INF/content/inc/header.jsp"/>
<div class="title4"></div>
<div class="curr">您当前的位置：<a href="${pageContext.request.contextPath}/index.action">首 页</a> > 帮助中心</div>
<s:include value="/WEB-INF/content/inc/help-left_new.jsp"/>

<!-- //right star-->
<div class="right">
  <div class="helptitle2"><div class="hlep1">帮助中心</div></div>
 
 <div class="mconter">
  	<div id="showsubhelp">
  		<table>
  		<tr>
  		<td height="50" class="newstitle">${showhelp.title}</td>
  		</tr>
  		<tr>
  		<td>${showhelp.content }</td>
  		</tr>
  		</table>
  	</div>
<div class="tiwen" style="display:none;">
	<form action="${pageContext.request.contextPath }/help/help!saveFeedBack.action" method="post" name="form1" onsubmit="return doSubmit();">
	<table width="100%" border="0" cellspacing="0" class="tiwentable">
  <tr>
    <th colspan="2"><img src="${pageContext.request.contextPath }/images/icon_jiao.jpg" width="5" height="9" align="absmiddle" /> <strong>我要提问</strong></th>
    </tr>
  <tr>
    <td colspan="2" class="tdred">请填写您的问题以及您的联系方式，我们将安排客服通过邮件或者电话的方式详细回答您的问题。</td>
    </tr>
  <tr>
    <td width="10%">姓    &nbsp;&nbsp;&nbsp;名：</td>
    <td width="90%"><input name="name" type="text" id="name" class="txthelp" /> <span class="red">*</span></td>
  </tr>
  <tr>
    <td>电    &nbsp;&nbsp;&nbsp;话：</td>
    <td><input name="phone" id="phone" type="text" maxlength="40" class="txthelp" />
      <span class="red">*</span></td>
  </tr>
  <tr>
    <td>手    &nbsp;&nbsp;&nbsp;机：</td>
    <td><input name="mobile" id="mobile" maxlength="20" type="text" class="txthelp" />
      <span class="red"></span></td>
  </tr>
  <tr>
    <td>公    &nbsp;&nbsp;&nbsp;司：</td>
    <td><input name="company" maxlength="100" id="company" type="text" class="txthelp" />
      <span class="red"></span></td>
  </tr>
  <tr>
    <td>传    &nbsp;&nbsp;&nbsp;真：</td>
    <td><input name="fax" maxlength="100" id="fax" type="text" class="txthelp" />
      <span class="red"></span></td>
  </tr>
  <tr>
    <td>QQ：</td>
    <td><input name="qq" id="qq" type="text" maxlength="15" class="txthelp" />
      <span class="red"></span></td>
  </tr>
    <tr>
    <td>MSN：</td>
    <td><input name="msn" id="msn" maxlength="40" type="text" class="txthelp" />
      <span class="red"></span></td>
  </tr>
  <tr>
    <td>电子邮箱：</td>
    <td><input name="email" id="email" type="text" class="txthelp" />
      <span class="red"></span></td>
  </tr>
  <tr>
    <td>问    &nbsp;&nbsp;&nbsp;题：</td>
    <td><textarea name="content" cols="60" rows="5" id="content" class="txthelp2"></textarea><span class="red">*</span></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><input name="" type="submit" value="" class="btntijiao" /> <input style="display:none;" name="" type="button" class="btnfanhui" /></td>
  </tr>
</table>
</form>

	
	</div>
 </div>
 
 




</div>
<!-- //right over-->

<s:include value="/WEB-INF/content/inc/footer.jsp"/>
</body>
</html>