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

<script type="text/javascript" src="${ctx}js/nav.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/index.css" />

<script type="text/javascript" src="${ctx}/js/dialog.js"></script>
<script language="javascript1.1" type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>

<link href="${ctx}/resources/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>


<script type="text/javascript">
$(function() {
 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg);},onsuccess:function(){return true;}});
 	$("#price").formValidator({onshow:"请输入单价",onfocus:"请输入单价，必须是数字",oncorrect:"恭喜你,你输对了"}).inputValidator({min:1,max:100,onerror:"你输入的单价非法,请确认"}).regexValidator({regexp:"num",datatype:"enum",onerror:"你输入的单价非法,请输入数字"});
 	$("#min").formValidator({onshow:"请输入起定量",onfocus:"请输入起定量，必须是数字",oncorrect:"恭喜你,你输对了"}).inputValidator({min:1,max:100,onerror:"你输入的起订量非法,请确认"}).regexValidator({regexp:"intege1",datatype:"enum",onerror:"你输入的起订量非法,请输入数字"});
 	$("#payType").formValidator({onshow:"请输入付款方式",onfocus:"请输入付款方式",oncorrect:"恭喜你,你输对了"}).inputValidator({min:1,max:500,onerror:"你输入的付款方式有误,请确认"});
 	$("#transferType").formValidator({onshow:"请输入运输方式",onfocus:"请输入运输方式",oncorrect:"恭喜你,你输对了"}).inputValidator({min:1,max:100,onerror:"你输入的运输方式非法,请确认"});
 	$("#linkman").formValidator({onshow:"请输入联系人",onfocus:"请输入联系人,如王小姐/张先生",oncorrect:"输入正确"}).inputValidator({min:1,max:100,onerror:"请检查输入的联系人,请确认"});
 	$("#contact").formValidator({onshow:"请输入联系电话",onfocus:"请正确输入联系电话，对方才能联系到你",oncorrect:"输入正确"}).inputValidator({min:1,max:100,onerror:"请检查输入的联系电话,请确认"});
});
</script>
</head>

<body>

<%-- header --%>
<s:include value="/WEB-INF/content/inc/header.jsp"></s:include>
<%-- header --%>
<div class="qycurr" style="border-top:1px solid #f3861b; height:15px;"></div>
<%-- main body --%>
<div class="xunjia">
<h1>
<div class="xujiantitle"><img src="${ctx}/images/piclg.jpg" style="vertical-align:middle" /> 请填写报价内容</div>
<div class="xunjiacon">

<form action="${ctx}/publishprice/publish-price!insert.action" method="post" id="form1" name="form1">
<input type="hidden" name="receiverId" value="<s:property value='receiverId'/>"/>
<input type="hidden" name="pid"  value="<s:property value="postedPro.id"/>"/>

<table width="100%" border="0" cellspacing="0" class="xunjiatable">
  <tr>
    <td width="12%"></td>
    <td width="88%"><span class="xjtdtitle" style="font-size:18px"><s:property value="postedPro.proName"/></span></td>
  </tr>
  <tr>
    <td width="12%">接 收 方：</td>
    <td width="88%"><span class="xjtdtitle"><s:property value="receiver.name"/></span></td>
  </tr>
  <tr>
    <td>单        价：</td>
    <td><input name="publishPrice.price" type="text" id="price" class="txtreg1" />元（单价：￥）<span id="priceTip"></span></td>
  </tr>
  <tr>
    <td>起  定  量：</td>
    <td><input name="publishPrice.min" id="min" type="text" class="txtreg1" /><span id="minTip"></span></td>
  </tr>
  <tr>
    <td>付款方式：</td>
    <td><input name="publishPrice.payType" id="payType" type="text" class="txtreg1" /><span id="payTypeTip"></span></td>
  </tr>
  <tr>
    <td>运输方式：</td>
    <td><input name="publishPrice.transferType" id="transferType" type="text" class="txtreg1" /><span id="transferTypeTip"></span></td>
  </tr>
  <tr>
    <td>联系人：</td>
    <td><input name="publishPrice.linkman" id="linkman" type="text" class="txtreg1" /><span id="linkmanTip"></span></td>
  </tr>
  <tr>
    <td>联系方式：</td>
    <td><input name="publishPrice.contact" id="contact" type="text" class="txtreg1" /><span id="contactTip"></span></td>
  </tr>
  <tr>
    <td>报价信息：</td>
    <td style="padding-top:10px;"><textarea name="publishPrice.content" cols="" rows="" class="txtreg2" id="content"></textarea><span id="contentTip"></span></td>
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