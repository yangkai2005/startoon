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
<script language="JavaScript" src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>

<script type="text/javascript">
$(document).ready(function(){
	<s:if test="flag">alert('企业BANNER保存成功！');</s:if>

	$("input[name=banner][value=<s:property value='banner'/>]").attr('checked', true);
	
});
</script>

</head>

<body>

<%-- header --%>
<s:include value="/WEB-INF/content/inc/header.jsp"></s:include>
<%-- header --%>
		

<div class="cls"></div>


<!--main star-->
<div class="main">

<div class="member">
<%-- left --%>
<s:include value="/WEB-INF/content/inc/member-left.jsp"></s:include>
<%-- left --%>


<div class="memright">
<div class="title4"> <div class="hotline">客服热线：020-39106666</div>
	 <div class="titlemu2">
	 <h2><a href="${ctx}/enterprise/enterprise/enterprise!info.action">企业基本信息</a></h2> 
	 <h2><a href="${ctx}/enterprise/enterprise/enterprise!detail.action">企业详细信息</a></h2>
	 <h2 class="q3"><a href="${ctx}/enterprise/enterprise/enterprise!forwardBanner.action">BANNER管理</a></h2>
	 </div>
	 </div>

<form action="${ctx}/enterprise/enterprise/enterprise!banner.action" method="post" id="form1" name="form1">
	  
	<div class="memcon">
	<table width="100%" border="0" cellspacing="0" class="bannertable">
  <tr>
    <td width="4%"><input name="banner" type="radio" value="/images/banner1.jpg" checked="checked"/></td>
    <td width="96%"><img src="${ctx}/images/banner1.jpg" width="730" height="85" /></td>
  </tr>
  <tr>
    <td><input name="banner" type="radio" value="/images/banner2.jpg" /></td>
    <td><img src="${ctx}/images/banner2.jpg" width="730" height="85" /></td>
  </tr>
  <tr>
    <td><input name="banner" type="radio" value="/images/banner3.jpg" /></td>
    <td><img src="${ctx}/images/banner3.jpg" width="730" height="85" /></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><input name="" type="submit" class="mbtn2" value="提交" /></td>
  </tr>
</table>

	</div>
</form>	 
	 

</div>

   <!--  //memberright over--> 



</div>

<!--  //member over-->


<div class="cls"></div>
  
  
 <div class="cls"></div>
 
 
  
  
<%-- footer --%>
<s:include value="/WEB-INF/content/inc/footer.jsp"/>
<%-- footer --%>	
</body>
</html>