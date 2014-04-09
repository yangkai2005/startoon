<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.alipay.config.*"%>
<%@ page import="org.j2eeframework.startoon.commons.SysContext"%>
<%@ page import="org.j2eeframework.startoon.entity.Enterprise"%>
<%@ page import="java.text.DecimalFormat"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="org.j2eeframework.startoon.service.EnterpriseService"%>
<%@page import="org.j2eeframework.commons.util.SystemContext"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="keywords" content="星力网，游戏机供应，游戏机采购，动漫游戏资讯，动漫游戏展会，卖游戏机"/>
<meta http-equiv="description" content="星力网是广州星力动漫科技有限公司打造的动漫游戏行业最专业的游戏机供应、游戏机采购平台，提供最新、最全的游艺产品、游戏产品、电玩产品、游戏机配件、电脑板、框体机、模拟机等供应信息、采购信息，星力网资讯频道为行业提供最专业的动漫游戏行业资讯、行业新闻。"/>
<title>星力网_中国动漫游艺门户_动漫游戏产品网络交易平台_动漫游戏行业资讯</title>

<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/member.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />
<script src="${ctx}/resources/js/jquery.js" type="text/javascript"></script>
<link href="${ctx}/resources/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>
<script src="${ctx}/fckeditor/fckeditor.js" type="text/javascript"></script>
<script type="text/javascript"  src="${pageContext.request.contextPath}/resources/js/jquery.selectCombo.1.2.6.js"></script>

<link href="${ctx}/resources/fileuploader/fileuploader.css" rel="stylesheet" type="text/css"/>
<script src="${ctx}/resources/fileuploader/fileuploader.js" type="text/javascript"></script>

<script language=JavaScript>

function CheckForm()
{
	/*if (document.alipayment.aliorder.value.length == 0) {
		alert("请输入商品名称.");
		document.alipayment.aliorder.focus();
		return false;
	}*/
	if (document.alipayment.alimoney.value.length == 0) {
		alert("请输入付款金额.");
		document.alipayment.alimoney.focus();
		return false;
	}
	var reg	= new RegExp(/^\d*\.?\d{0,2}$/);
	if (! reg.test(document.alipayment.alimoney.value))
	{
        alert("请正确输入付款金额");
		document.alipayment.alimoney.focus();
		return false;
	}
	if (Number(document.alipayment.alimoney.value) < 0.01) {
		alert("付款金额金额最小是0.01.");
		document.alipayment.alimoney.focus();
		return false;
	}

}
</script>
<%
String show_url = AlipayConfig.show_url;
String mainname = AlipayConfig.mainname;

Long id = SysContext.getCurrentEnterpriserUser().getId();
EnterpriseService enterpriseService = (EnterpriseService) SystemContext.getApplicationContext().getBean("enterpriseService");
Enterprise enterprise = enterpriseService.getEntityById(id);

Float famount = enterprise.getAmount();
if(famount==null) {
	famount=0F;
}
DecimalFormat df = new DecimalFormat("0.00");//保留两位小数
String amount = df.format(famount);

%>
</head>
<body>
<s:include value="/WEB-INF/content/inc/header.jsp"/>
<s:include value="/WEB-INF/content/inc/member-left.jsp"/>

<div class="memright">
<div class="title4"> <div class="hotline">客服热线：020-39106666</div>
	 <div class="titlemu2">
	 <h1>在线充值</h1>
	 </div>
	 </div>
	<div class="memcon">
	 	
		<div class="sicon" style="padding-top:0">
			<div class="chongzhi1"><img src="${pageContext.request.contextPath}/images/icon_cz.jpg"  align="absmiddle"/> 在线充值</div>
			<div class="chongzhi2">
	<form name="alipayment" onsubmit="return CheckForm();" action="${pageContext.request.contextPath}/enterprise/payment/alipayto.jsp" method=post target="_blank">
<table>
 <tr>
   <td>
     <TABLE cellSpacing=0 cellPadding=0 width=740 border=0>
         <TR>
          <TD width="150">账户余额： </TD>
          <TD width="20"></TD>
          <TD align="left"><%=amount%> 元</TD>
        </TR>
        <TR>
          <TD>充值金额： </TD>
          <TD></TD>
          <TD align="left"><input maxlength=10 size=30 name=alimoney onfocus="if(Number(this.value)==0){this.value='';}" value="00.00"/>
            <span>单位：元      如：112.21元</span></TD>
        </TR>
        <TR>
          <TD>支付方式：</TD>
          <TD></TD>
          <TD align="left">
               <table>
                 <tr>
                   <td><input type="radio" name="pay_bank" value="directPay" checked/><img src="${pageContext.request.contextPath}/images/alipay/alipay_1.gif" border="0"/></td>
                 </tr>
                 <tr>
                   <td><input type="radio" name="pay_bank" value="ICBCB2C"/><img src="${pageContext.request.contextPath}/images/alipay/ICBC_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="CMB"/><img src="${pageContext.request.contextPath}/images/alipay/CMB_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="CCB"/><img src="${pageContext.request.contextPath}/images/alipay/CCB_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="BOCB2C"/><img src="${pageContext.request.contextPath}/images/alipay/BOC_OUT.gif" border="0"/></td>
                 </tr>
                 <tr>
                   <td><input type="radio" name="pay_bank" value="ABC"/><img src="${pageContext.request.contextPath}/images/alipay/ABC_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="COMM"/><img src="${pageContext.request.contextPath}/images/alipay/COMM_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="SPDB"/><img src="${pageContext.request.contextPath}/images/alipay/SPDB_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="GDB"/><img src="${pageContext.request.contextPath}/images/alipay/GDB_OUT.gif" border="0"/></td>
                 </tr>
                 <tr>
                   <td><input type="radio" name="pay_bank" value="CITIC"/><img src="${pageContext.request.contextPath}/images/alipay/CITIC_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="CEBBANK"/><img src="${pageContext.request.contextPath}/images/alipay/CEB_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="CIB"/><img src="${pageContext.request.contextPath}/images/alipay/CIB_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="SDB"/><img src="${pageContext.request.contextPath}/images/alipay/SDB_OUT.gif" border="0"/></td>
                 </tr>
                 <tr>
                   <td><input type="radio" name="pay_bank" value="CMBC"/><img src="${pageContext.request.contextPath}/images/alipay/CMBC_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="HZCBB2C"/><img src="${pageContext.request.contextPath}/images/alipay/HZCB_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="SHBANK"/><img src="${pageContext.request.contextPath}/images/alipay/SHBANK_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="NBBANK"/><img src="${pageContext.request.contextPath}/images/alipay/NBBANK_OUT.gif" border="0"/></td>
                 </tr>
                 <tr>
                   <td><input type="radio" name="pay_bank" value="SPABANK"/><img src="${pageContext.request.contextPath}/images/alipay/SPABANK_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="BJRCB"/><img src="${pageContext.request.contextPath}/images/alipay/BJRCB_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="ICBCBTB"/><img src="${pageContext.request.contextPath}/images/alipay/ENV_ICBC_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="CCBBTB"/><img src="${pageContext.request.contextPath}/images/alipay/ENV_CCB_OUT.gif" border="0"/></td>
                 </tr>
                 <tr>
                   <td><input type="radio" name="pay_bank" value="SPDBB2B"/><img src="${pageContext.request.contextPath}/images/alipay/ENV_SPDB_OUT.gif" border="0"/></td>
                   <td><input type="radio" name="pay_bank" value="ABCBTB"/><img src="${pageContext.request.contextPath}/images/alipay/ENV_ABC_OUT.gif" border="0"/></td>
				   <td><input type="radio" name="pay_bank" value="fdb101" /><img src="${pageContext.request.contextPath}/images/alipay/FDB_OUT.gif" border="0" /></td>
				   <td><input type="radio" name="pay_bank" value="PSBC-DEBIT" /><img src="${pageContext.request.contextPath}/images/alipay/PSBC_OUT.gif" border="0" /></td>
                 </tr>
               </table>
          </TD>
        </TR>
         <TR>
          <TD colspan=3" align="center" height="50"><input type="image" src="${pageContext.request.contextPath}/images/alipay/button_sure.gif" value="确认订单" name="nextstep"/></TD>
        </TR>
</TABLE>
   </td>
 </tr>
</table>

</form>
			</div>
		</div>
		
			<div class="sicon" style="padding-top:0;margin-top:10px;" >
			<div class="chongzhi1"><img src="${pageContext.request.contextPath}/images/icon_cz.jpg"  align="absmiddle"/> 如何消费？</div>
			<div class="chongzhi3">
			<strong>1.点击通消费 </strong><br />
			每天有成千上万的潜在顾客在搜索引擎中查找您的产品，但您并不知道他们在哪里；<br />
			星力网竞价排名，在这些“搜索请求”和“您的网站”之间搭桥，使您的网站直接显示在相关搜索的结果页面； <br />
			<strong>2.产品关键词竞价</strong><br />
			您来决定为每一个潜在顾客付出多少成本 -- 您为每个点击设定的单价越高，您的网站在搜索结果页面出现在前列的机会越大，越引人您来决定为每一个潜在顾客付出多少成本 -- 您为每个点击设定的单价越高，您的网站在搜索结果页面出现在.<br />
			<strong>3.企业关键词竞价</strong><br />
			您来决定为每一个潜在顾客付出多少成本 -- 您为每个点击设定的单价越高，您的网站在搜索结果页面出现在前列的机会越大，越引人您来决定为每一个潜在顾客付出多少成本 -- 您为每个点击设定的单价越高，您的网站在搜索结果页面出现在.			</div>
		</div>
	 
	 
	</div>

</div>

<!--  //member over-->


<div class="cls"></div>

<s:include value="/WEB-INF/content/inc/footer.jsp"/>
</body>
</html>
