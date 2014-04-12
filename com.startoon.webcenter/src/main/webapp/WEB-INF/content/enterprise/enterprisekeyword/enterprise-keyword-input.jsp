<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="org.j2eeframework.commons.pager.Pager"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="keywords" content="星力网，游戏机供应，游戏机采购，动漫游戏资讯，动漫游戏展会，卖游戏机"/>
<meta http-equiv="description" content="星力网是广州星力动漫科技有限公司打造的动漫游戏行业最专业的游戏机供应、游戏机采购平台，提供最新、最全的游艺产品、游戏产品、电玩产品、游戏机配件、电脑板、框体机、模拟机等供应信息、采购信息，星力网资讯频道为行业提供最专业的动漫游戏行业资讯、行业新闻。"/>
<title>星力网_中国动漫游艺门户_动漫游戏产品网络交易平台_动漫游戏行业资讯</title>

<link rel="stylesheet" type="text/css" href="${ctx}/css/member.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />

<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>

<script type="text/javascript">
function floatAdd(arg1,arg2)
{
    var r1,r2,m;
    try
    {
        r1=arg1.toString().split(".")[1].length;
    }
    catch(e)
    {
        r1=0;
    }
    
    try
    {
        r2=arg2.toString().split(".")[1].length;
    }
    catch(e)
    {
        r2=0;
    }
    m=Math.pow(10,Math.max(r1,r2));
    return (arg1*m+arg2*m)/m;
}

var currentPrice = 0;
$(function() {
	<s:if test="msg=='1'">alert('你已经购买了该关键字，不能重复购买！');</s:if>
	$("#addPrice").click(function() {
		var mp = <s:property value="selectedKeyword.currentPrice"/>;
		var sp = <s:property value="selectedKeyword.stepPrice"/>;
		if(currentPrice==0) {
			currentPrice = mp; 
		}
		//currentPrice += sp;
		currentPrice = floatAdd(currentPrice, sp);
		//currentPrice = Math.round(currentPrice);
		$('#price').val(currentPrice);
		
	});

	$('#buykey').click(function() {
		$('#ekForm1').submit();
	});
	
});
</script>

</head>

<body>
<s:include value="/WEB-INF/content/inc/header.jsp"/>
<div class="member">
	<s:include value="/WEB-INF/content/inc/member-left.jsp"/>
	<%-- 列表管理 --%>
<div class="memright">
<div class="title4"> <div class="hotline">客服热线：020-39106666</div>
	 <div class="titlemu2">
	
	 
	 <h2 class="q3">企业关键词竞价</h2> 
	 
	
	 </div>
	 </div>
	 
	<div class="memcon">
	 	
		<div class="sicon2">

		<div class="sititle2"><div class="s2 red">填写竞价表单</div></div>	
		<%--
		<div class="overtime b">
		距离竞拍结束还有 <s:property value="selectedKeyword.remainTime" escape="HTML"/>
		</div>
		 --%>
			
		<div class="sibuy">
		<s:form id="ekForm1" namespace="/enterprise/enterprisekeyword" action="enterprise-keyword!insert">
		<input type="hidden" name="keyword.id" value="<s:property value='selectedKeyword.id'/>"/>
		<table width="100%" border="0" cellspacing="0" class="tablebuy">
		  <tbody>
		  <tr>
		    <td colspan="2">竞价关键词：<b><s:property value="selectedKeyword.keyword"/></b> </td>
		    </tr>
		  <tr>
		    <td colspan="2" style="padding-top:5px;" class="red">当前关键词最高价格：<s:property value="selectedKeyword.currentPrice"/>元</td>
		    </tr>
			
			  <tr>
		    <td colspan="2" class="red">我要加价：<input type="text" id="price" name="price" class="txtbuy" readonly="readonly" value="<s:property value="selectedKeyword.currentPrice"/>" /> <a href="javascript:void(0)" id="addPrice">加价</a> （最低加价<s:property value="selectedKeyword.stepPrice"/>元）</td>
		    </tr>
		    <!--
		  <tr>
		    <td colspan="2">验 证 码：<input type="text" name="ccode" class="txtbuy"/>
		      <img src="${ctx}/ic" width="45" height="19" style="vertical-align:middle"/></td>
		    </tr>
		  -->
		  <tr>
		    <td colspan="2" style="padding-top:12px;"><a href="javascript:void(0)" id="buykey"><img src="${ctx}/images/buysure.jpg" width="82" height="28" alt=""/></a></td>
		    </tr>
		  </tbody>
		</table>
		</s:form>

		
		</div>	
		
		<div class="jingjiaxz">
		<s:property value="news.content" escape="html"/>	
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