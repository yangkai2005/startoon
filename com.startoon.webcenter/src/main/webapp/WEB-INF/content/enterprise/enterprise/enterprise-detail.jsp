<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="keywords" content="星力网，游戏机供应，游戏机采购，动漫游戏资讯，动漫游戏展会，卖游戏机"/>
<meta http-equiv="description" content="星力网是广州星力动漫科技有限公司打造的动漫游戏行业最专业的游戏机供应、游戏机采购平台，提供最新、最全的游艺产品、游戏产品、电玩产品、游戏机配件、电脑板、框体机、模拟机等供应信息、采购信息，星力网资讯频道为行业提供最专业的动漫游戏行业资讯、行业新闻。"/>
<title>星力网_中国动漫游艺门户_动漫游戏产品网络交易平台_动漫游戏行业资讯</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/member.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />
<script src="${ctx}/resources/js/jquery.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/js/nav.js"></script>

<script type="text/javascript" src="${ctx}/resources/My97DatePicker/WdatePicker.js"></script>

<link href="${ctx}/resources/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>


<script type="text/javascript">
$(document).ready(function(){

	<s:if test="flag">alert('企业详细信息保存成功！');</s:if>

 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg);},onsuccess:function(){return true;}});
 	$("#registeredCapital").formValidator({empty:true,onshow:"请输入注册资金",onfocus:"请输入注册资金",oncorrect:"输入正确",onempty:""}).inputValidator({min:1,max:11,onerror:"注册资金不正确,请确认"}).regexValidator({regexp:"intege1",datatype:"enum",onerror:"注册资金格式不正确，只能是大于零的数字！"});
 	$("#acreage").formValidator({empty:true,onshow:"请输入厂房面积",onfocus:"请输入厂房面积",oncorrect:"输入正确",onempty:""}).regexValidator({regexp:"num1",datatype:"enum",onerror:"厂房面积格式不正确。只能是大于或等于零的数字！"});
 	$("#turnover").formValidator({empty:true,onshow:"",onfocus:"",oncorrect:"输入正确",onempty:""}).regexValidator({regexp:"num1",datatype:"enum",onerror:"年营业额格式不正确。只能是大于或等于零的数字！"});
 	$("#outs").formValidator({empty:true,onshow:"",onfocus:"",oncorrect:"输入正确",onempty:""}).regexValidator({regexp:"num1",datatype:"enum",onerror:"年出口额格式不正确。只能是大于或等于零的数字！"});
 	$("#ins").formValidator({empty:true,onshow:"",onfocus:"",oncorrect:"输入正确",onempty:""}).regexValidator({regexp:"num1",datatype:"enum",onerror:"年进口额格式不正确。只能是大于或等于零的数字！"});
 	

});


function showbig(name,cursel,n,m){
   for(i=1;i<=n;i++){
   var menu=document.getElementById(m+i);
	var con=document.getElementById(name+i);
	menu.className=i==cursel?"hover":"";
   con.style.display=i==cursel?"block":"none";
   }
  }
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

<%-- right --%>
<div class="memright">
<div class="title4"> <div class="hotline">客服热线：020-39106666</div>
	 <div class="titlemu2">
	 <h2><a href="${ctx}/enterprise/enterprise/enterprise!info.action">企业基本信息</a></h2> 
	 <h2 class="q3"><a href="${ctx}/enterprise/enterprise/enterprise!detail.action">企业详细信息</a></h2>
	 <h2><a href="${ctx}/enterprise/enterprise/enterprise!forwardBanner.action">BANNER管理</a></h2>
	 </div>
	 </div>
	<div class="memcon">
	 <s:form id="form1" name="form1" namespace="/enterprise/enterprise" action="enterprise!updatedetail.action">
	 <s:hidden name="enterprise.id" value="%{enterprise.id}"></s:hidden>
	<table width="100%" border="0" cellspacing="0" class="regtable2">
  <tr>
    <td width="9%">公司规模：</td>
    <td width="38%">
      <input id="scale"  type="text" name="enterprise.scale" style="width:180px;" value="<s:property value='enterprise.scale'/>" />      </td>
    <td width="9%">成立时间：</td>
    <td width="44%"> <s:textfield name="ctime" id="ctime" cssClass="Wdate" onfocus="new WdatePicker()" readonly="true"><s:param name="value"><s:date name="enterprise.ctime" format="yyyy-MM-dd"/></s:param></s:textfield> </td>
  </tr>
  <tr>
    <td>公司类型：</td>
    <td><input id="type"  type="text" name="enterprise.type" style="width:180px;" value="<s:property value='enterprise.type'/>" /></td>
    <td>注册资金：</td>
    <td><input id="registeredCapital"  type="text" name="enterprise.registeredCapital" style="width:180px;" value="<s:property value='enterprise.registeredCapital'/>" />&nbsp;万元</td>
  </tr>
  <tr>
    <td>厂房面积</td>
    <td><input id="acreage"  type="text" name="enterprise.acreage" style="width:180px;" value="<s:property value='enterprise.acreage'/>" />平方米</td>
    <td>年营业额：</td>
    <td> <input id="turnover" name="enterprise.turnover" type="text" style="width:183px;" value="<s:property value='enterprise.turnover'/>"/>万元 </td>
  </tr>
  <tr>
    <td>年出口额：</td>
    <td> <input id="outs" name="enterprise.outs" type="text"  style="width:183px;" value="<s:property value='enterprise.outs'/>" />万元 </td>
    <td>年进口额：</td>
    <td> <input id="ins" name="enterprise.ins" type="text"  style="width:183px;" value="<s:property value='enterprise.ins'/>" />万元 </td>
  </tr>
  <tr>
    <td>经营品牌：</td>
    <td><input id="brand"  type="text" name="enterprise.brand" style="width:180px;" value="<s:property value='enterprise.brand'/>" /></td>
    <td>主客户群：</td>
    <td><input id="clients"  type="text" name="enterprise.clients" style="width:180px;" value="<s:property value='enterprise.clients'/>" /></td>
  </tr>
  <tr>
    <td>开户银行：</td>
    <td><input id="bank"  type="text" name="enterprise.bank" style="width:180px;" value="<s:property value='enterprise.bank'/>" /></td>
    <td>银行帐号：</td>
    <td><input id="bankAccount"  type="text" name="enterprise.bankAccount" style="width:180px;" value="<s:property value='enterprise.bankAccount'/>" /></td>
  </tr>
   <tr>
   <td></td>
    <td colspan="3">
    	<input class="mbtn2" value="确定" type="submit"/>
    	<input class="mbtn2" value="取消" type="reset"/> 
	</td>
    </tr>
</table>
</s:form>
	</div>
	 
	 

</div>
<%-- right --%>

</div>

<!--  //member over-->


<div class="cls"></div>

 <div class="cls"></div>
  
<%-- footer --%>
<s:include value="/WEB-INF/content/inc/footer.jsp"/>
<%-- footer --%>	
</body>
</html>