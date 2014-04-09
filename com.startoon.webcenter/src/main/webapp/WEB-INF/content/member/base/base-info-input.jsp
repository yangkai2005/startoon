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

<script type="text/javascript" src="js/nav.js"></script>
<script type="text/javascript" src="${ctx}/js/dialog.js"></script>
<script language="javascript1.1" type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>

<link href="${ctx}/resources/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>


<script type="text/javascript">
$(function(){
	<s:if test="success">alert('操作成功！');</s:if>
	
	$('a[rel=ad]').click(function() {
		var id = $(this).attr('id');
		$.post('${ctx}/information/advertisement/click.action', {'id':id});
	});
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

	 <h2 class="q3">基本信息</h2> 
	
	 </div>
	 </div>
	 
	<div class="grmemcon">
	<s:form name="/member/base" action="base-info!update">
	<s:hidden name="requestId"></s:hidden>
	<s:hidden name="id"></s:hidden>
	<table width="100%" border="0" cellspacing="0" class="regtable2">
	  <tbody>
	  <tr>
	    <td width="13%">用户名：</td>
	    <td width="87%" colspan="2"> <s:textfield name="name" cssClass="txtge1"></s:textfield> </td>
	    </tr>
	  <tr>
	    <td>呢称：</td>
	    <td colspan="2"><s:textfield name="nickname" cssClass="txtge1"></s:textfield> </td>
	    </tr>
		 <tr>
	    <td>性别：</td>
	    <td colspan="2"> <s:radio list="#{true:'男', false:'女'}" name="sex"></s:radio> </td>
	    </tr>
		 <tr>
	    <td>手机：</td>
	    <td colspan="2"><s:textfield name="mobilePhone" cssClass="txtge1"></s:textfield></td>
	    </tr>
		 <tr>
	    <td>固定电话：</td>
	    <td colspan="2"><s:textfield name="telephone" cssClass="txtge1"></s:textfield> <span>如：020-88888888</span> </td>
	    </tr>
	    <tr>
	    <td>传真：</td>
	    <td colspan="2"><s:textfield name="fax" cssClass="txtge1"></s:textfield> <span>如：020-88888888</span></td>
	    </tr>	    
	    <%--
		 <tr>
	    <td>邮箱：</td>
	    <td colspan="2"><s:textfield name="email" cssClass="txtge1"></s:textfield></td>
	    </tr>
	    --%>
		 <tr>
	    <td>QQ：</td>
	    <td colspan="2"><s:textfield name="qq" cssClass="txtge1"></s:textfield></td>
	    </tr>
		<tr>
	    <td>详细地址：</td>
	    <td colspan="2"><s:textfield name="address" cssClass="txtge4"></s:textfield></td>
	    </tr>
	  	<tr>
	    <td></td>
	    <td colspan="2"><input name="" type="submit" value="确 定" class="mbtn2"/> <input name="" type="button" value="取 消" class="mbtn2"/> </td>
	    </tr>
	</tbody>
	</table>
	</s:form>
	</div>
	<div class="cls"></div>
	
	 </div>
	 
	 <div class="geright">
		<e:adquery id="ad1" adId="218"/>
		<e:adquery id="ad2" adId="219"/>
	    <a id="218" rel="ad" target="_blank" href="<e:adlink name="ad1"/>"><img src="<e:adimg name="ad1"/>" width="191" height="235"/></a>
	    <a id="219" rel="ad" target="_blank" href="<e:adlink name="ad2"/>"><img src="<e:adimg name="ad2"/>" width="191" height="235"/></a>
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