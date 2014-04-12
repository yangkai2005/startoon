<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.alipay.config.*"%>
<%@ page import="org.j2eeframework.startoon.commons.SysContext"%>
<%@ page import="org.j2eeframework.startoon.entity.Enterprise"%>
<%@ page import="java.text.DecimalFormat"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="org.j2eeframework.startoon.service.EnterpriseService"%>
<%@page import="org.j2eeframework.commons.util.SystemContext"%>
<%@page import="org.j2eeframework.startoon.service.CastService"%><html xmlns="http://www.w3.org/1999/xhtml">
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
<script type="text/javascript">
$(function(){
	$('h2#myamount').addClass('q3');

});
</script>

<%

Long id = SysContext.getCurrentEnterpriserUser().getId();
EnterpriseService enterpriseService = (EnterpriseService) SystemContext.getApplicationContext().getBean("enterpriseService");
Enterprise enterprise = enterpriseService.getEntityById(id);

CastService castService = (CastService) SystemContext.getApplicationContext().getBean("castService");

DecimalFormat df = new DecimalFormat("0.00");//保留两位小数
String amount = df.format(enterprise.getAmount());


double cast = castService.getCurrentUserTodayCast();
String c = df.format(cast);

%>
</head>


<body>
<s:include value="/WEB-INF/content/inc/header.jsp"/>
<div class="member">
	<s:include value="/WEB-INF/content/inc/member-left.jsp"/>
	<%-- 列表管理 --%>
<div class="memright">

	<s:include value="/WEB-INF/content/enterprise/payment/menu.jsp"/>
	 
	<div class="memcon">
	 	
		<div class="sicon2">

		<div class="sititle2"><div class="s2 red">账户余额</div></div>	
		
		<div class="overtime b">
		当前余额：<%=amount%>元
		</div>			
		<div class="overtime b">
		今天消费金额：<%=c%>元
		</div>			
			
		
		
		</div>	 
	 
	 
	</div>
	 
</div>	
	<%-- 列表管理 --%>
</div>

<div class="cls"></div>
<div style="clear:both;"></div>

<s:include value="/WEB-INF/content/inc/footer.jsp"/>
</body>
</html>
