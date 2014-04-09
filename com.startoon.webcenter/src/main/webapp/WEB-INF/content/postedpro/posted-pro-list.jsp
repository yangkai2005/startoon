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
<script src="${ctx}/resources/js/jquery.js" type="text/javascript"></script>
<link href="${ctx}/resources/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>

<script type="text/javascript"> 
$(document).ready(function(){
	$('a#searchProduct').parent().removeClass('searin');
	$('a#searchPost').parent().addClass('searin');
	$('#type').val(2);

	$("li[rel=category]").each(function() {
		var id = $(this).attr("lang");
		var index = $(this).attr('index');
		var obj = "#" + "con_cg_" + index;
		$(obj).load("${ctx}/postedpro/category.action?categoryId=" + id + "&r=" + (new Date()).getTime());
	});
});
</script>

</head>
<body>
<s:include value="/WEB-INF/content/inc/header.jsp"/>

<%-- main begin --%>

<!--main star-->

<div class="main">

<div class="title4" style="height:1px; margin-bottom:15px;"></div>

<div class="proleft">

<div class="protitle">

  <div class="titlemu"><img src="${ctx }/images/title_cg.jpg" style="display:block" /></div>

  </div>
 <div class="proleftcon2">

 	<div class="procgone">

		<h4><div>最新采购信息</div></h4>

		<div class="procgnav">
			<ul class="procglist">
			<s:iterator value="pager.items">
			<li><div class="cgliuyan"><a href="${ctx}/postedpromessage/posted-pro-message!input.action?enterpriseId=<s:property value='creator.id'/>" target="_blank">给我留言</a></div>
			<div class="procgxinxi"><div class="timecg"><s:date name="createTime" format="yyyy-MM-dd" /> </div><a target="_blank" href="${ctx}/postedpro/posted-pro!detail.action?requestId=<s:property value='id'/>"><s:property value="proName"/></a></div>
			</li>
			</s:iterator>
			</ul>
			<div align="right"><e:pagination></e:pagination> </div>
		</div>

	</div>

	<div class="procgone">

		<h4><div>采购目录</div></h4>

	    <h5>

		<ul>

		<s:iterator value="categories" status="st">
			<s:if test="#st.index==0">
				<li index="<s:property value='#st.count'/>" rel="category" lang="<s:property value='id'/>" class="hover" style="border-left:1px solid #d2c3b0;" onmouseover="setTab('cg',<s:property value='#st.count'/>,<s:property value='%{categoryCount}'/>)" id="cg<s:property value='#st.count'/>"><a href="#"><s:property value="name"/></a></li>
			</s:if>
			<s:else>
				<li index="<s:property value='#st.count'/>" rel="category" lang="<s:property value='id'/>" onmouseover="setTab('cg',<s:property value='#st.count'/>,<s:property value='%{categoryCount}'/>)" id="cg<s:property value='#st.count'/>"><a href="#"><s:property value="name"/></a></li>
			</s:else>
		</s:iterator>

		</ul>
		</h5>

		<div class="procgnav">
			
			 <div id="con_cg_1" class=""></div>
			 <div id="con_cg_2" class="play"></div>
			 <div id="con_cg_3" class="play"></div>
			 <div id="con_cg_4" class="play"></div>
			 <div id="con_cg_5" class="play"></div>
			 <div id="con_cg_6" class="play"></div>
			 <div id="con_cg_7" class="play"></div>

		

		</div>

		

		

		

	

	</div>

	

	

 

 </div> 

  

  



</div>







<div class="proright">

<div class="prorighttab">

<h1><div class="pt1">最新发布产品</div></h1>

<h2>

<ul class="prolist2">
<s:iterator value="supplies">
<li><a target="_blank" href="${ctx}/supply/supply-manage!detail.action?supplyId=<s:property value='id'/>"> <s:property value="name"/> </a></li>
</s:iterator>
</ul>

</h2>

</div>

<div class="proban"><a href="#"><img src="${ctx }/images/ban2.jpg" style="display:block" /></a></div>




</div>

 <!-- // pro over --> 


<%-- main end --%>

<s:include value="/WEB-INF/content/inc/footer.jsp"/>
</body>
</html>