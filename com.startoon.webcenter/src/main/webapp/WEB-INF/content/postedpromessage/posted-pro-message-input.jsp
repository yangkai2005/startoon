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

<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/index.css" />

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
<div class="qycurr" style="border-top:1px solid #f3861b; height:15px;"></div>
<%-- main body --%>
<div class="xunjia">
<h1>
<div class="xujiantitle"><img src="${ctx}/images/piclg.jpg" style="vertical-align:middle" /> 请填写询价内容</div>
<div class="xunjiacon">

<form action="${ctx}/postedpromessage/posted-pro-message!insert.action" method="post" id="form1" name="form1">

<input type="hidden" name="enterpriseId" value="<s:property value='enterprise.id'/>"/>

<table width="100%" border="0" cellspacing="0" class="xunjiatable">
  <tr>
    <td width="12%">接收方：</td>
    <td width="88%"><span class="xjtdtitle"><s:property value="enterprise.name"/></span></td>
  </tr>
  <tr>
    <td>留言内容：</td>
    <td style="padding-top:10px;"><textarea name="postedProMessage.content" cols="" rows="" class="txtreg2"></textarea></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><input name="" type="submit" class="btnxunjia" value="提&nbsp;&nbsp;&nbsp;交" /></td>
  </tr>

</table>
</form>

</div>

</h1>

</div>
<%-- main body --%>
  
<%-- footer --%>
<s:include value="/WEB-INF/content/inc/footer.jsp"/>
<%-- footer --%>
	
</body>
</html>