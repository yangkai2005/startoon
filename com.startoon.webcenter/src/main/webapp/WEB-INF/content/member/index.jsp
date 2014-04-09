<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
<%
String url = request.getContextPath() + "/member/base/base-info!edit.action";
response.sendRedirect(url);
%>
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

<script type="text/javascript" src="js/nav.js"></script>
<script type="text/javascript" src="${ctx}/js/dialog.js"></script>
<script language="javascript1.1" type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>

<link href="${ctx}/resources/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>

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
	<div class="mem1">您还未发布信息或采购信息，现在发布。<a href="${ctx}/member/postedpro/posted-pro!input.action?requestId=0"><img src="${ctx}/images/publish2.jpg"/></a></div>
   <div class="mem2">
   <table width="100%" border="0" cellspacing="0" height="86">
  <tbody><tr>
    <td width="8%"><img src="${ctx}/images/membi.jpg" width="45" height="46"/></td>
    <td width="92%"><p class="f14 yellow"><span class="lv b">无聊至此，</span><strong>欢迎您登录星力数码科技有限公司</strong></p>
      <p>您当前可用金币为 <span class="red">30</span> 枚</p></td>
  </tr>
</tbody></table>

   </div>
      <div class="mem3">
	  <table width="100%" border="0" cellspacing="0">
  <tbody><tr>
    <td>信息中心：站内短信 <a href="#"><span class="red">(0)条新</span></a> </td>
    <td>系统信息：<a href="#"><span class="red">(0)条新</span></a></td>
  </tr>
  <tr>
    <td>询盘信息：<a href="#"><span class="red">(0)条新</span></a></td>
    <td>&nbsp;</td>
  </tr>
</tbody></table>

	  </div>
	  
	    <div class="mem4">
	  		<div class="l">
			 <div class="title3">
	 <div class="titlemu">
	 <h1>供求信息</h1>
	 </div>
	 </div>
	 
	 <div class="fabutext" style="color:#727272">您还没购买点击通和关键字竞价服务，为更好地帮助企业进行专业推广，建议您及时购买，以<br>
	   免影响公司业务。<br>
	   <a href="#">什么事点击通？</a><a href="#">什么是关键词竞价？</a><a href="#">如何购买?</a></div>
	 
	 <div class="fabu">
	 <table width="100%" border="0" cellspacing="1" class="fabutable">
  <tbody><tr>
    <th width="32%">信息类型</th>
    <th width="32%">已发布</th>
    <th width="36%">&nbsp;</th>
  </tr>
  <tr>
    <td>供应信息</td>
    <td><span class="lan1">0</span></td>
    <td><a href="#">发布新产品</a></td>
  </tr>
  <tr>
    <td>求购信息</td>
    <td><span class="lan1">0</span></td>
    <td><a href="#">发布新求购</a></td>
  </tr>
</tbody></table>

	 
	 </div>
			
			
			</div>
			
			
			<div class="r">
				
			  <div class="guanggao" style="margin-top:0">
			  <a href="#"><img src="${ctx}/images/pico2.jpg"></a>
			  </div>
			</div>
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