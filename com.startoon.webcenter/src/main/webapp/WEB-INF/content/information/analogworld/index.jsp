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
<link rel="stylesheet" type="text/css" href="${ctx}/information/css/style.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/information/css/common.css" />

<script type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>

<link rel="stylesheet" type="text/css" href="${ctx}/css/slider/common.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/slider/index.css" />
<script type="text/javascript" src="${ctx}/js/slider.js"></script>

<script type="text/javascript"> 
$(document).ready(function(){
	$('li#l10').addClass('hover');
	$('h2#h10').show();
	
	$('a[rel=ad]').click(function() {
		var id = $(this).attr('id');
		$.post('${ctx}/information/advertisement/click.action', {'id':id});
	});
});
</script>

</head>

<body>
<div id="wrap">
<s:include value="/WEB-INF/content/information/inc/header.jsp"/>

<%-- main begin --%>
<div class="main">

	
		<div class="content_right">
		<script type="text/javascript">
		<!-- 
			var interval_time=2;
			var focus_width=300;
			var focus_height=234;
			var text_height=0;
			var text_mtop = 0;
			var text_lm = 10;
			var textmargin = text_mtop+"|"+text_lm;
			var textcolor = "#ff0000|0xFFffff";
			var text_align= 'left'; 
			var swf_height = focus_height+text_height+text_mtop; 
			var text_size = 14;
			var borderStyle="1|0x000000|0";
			var pics='<s:iterator value="imgInfos" status="st"><s:if test="#st.count>1">|</s:if><s:property value="mainImg.normalImg"/></s:iterator>';
			var links='<s:iterator value="imgInfos" status="st"><s:if test="#st.count>1">|</s:if>${ctx}/information/info/info!show.action?requestId=${id }</s:iterator>'; 
			var texts='1|2|3|4';
			
			document.write('<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="'+ focus_width +'" height="'+ swf_height +'">');
			document.write('<param name="allowScriptAccess" value="sameDomain"><param name="movie" value="${ctx}/information/js/one.swf"> <param name="quality" value="high"><param name="Wmode" value="transparent">');
			document.write('<param name="menu" value="false"><param name=wmode value="opaque">');
			document.write('<param name="FlashVars" value="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'&textmargin='+textmargin+'&textcolor='+textcolor+'&borderstyle='+borderStyle+'&text_align='+text_align+'&interval_time='+interval_time+'&textsize='+text_size+'">');
			document.write('<embed src="${ctx}/information/js/one.swf" wmode="opaque" FlashVars="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'&textmargin='+textmargin+'&textcolor='+textcolor+'&borderstyle='+borderStyle+'&text_align='+text_align+'&interval_time='+interval_time+'&textsize='+text_size+'" menu="false" bgcolor="#ffffff" quality="high" width="'+ focus_width +'" height="'+ swf_height +'" allowScriptAccess="sameDomain" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />');  
			document.write('</object>');
		//-->
		</script>			
		  <!--
		  <div class="ad">
		    <ul class="slider" style="bottom: -771px; ">
		      <s:iterator value="imgInfos">
		      <li><a href="${ctx}/information/info/info!show.action?requestId=${id }" target="_blank"><img src="<s:property value="mainImg.normalImg"/>" width="300px" height="234px"/></a></li>
		      </s:iterator>
		    </ul>
		    <ul class="num">
		      <s:iterator value="imgInfos" status="st">
		      <li><s:property value="#st.count"/></li>
		      </s:iterator>
		    </ul>
		  </div>
		-->
		</div>
		
		<div class="anaone">
		<div class="title2">
		<div class="more"><a href="${ctx}/information/info/info-list.action?infoTypeId=35" target="_blank">更多&gt;&gt;</a></div>
		<div class="nt1">技术</div>
		</div>
		
		<h1>
		<ul class="list2">
		<s:iterator value="technologyInfos">
		<li><a href="${ctx}/information/info/info!show.action?requestId=${id}" target="_blank"><s:property value="shortTitle"/></a></li>
		</s:iterator>
		</ul>
		</h1>
		
		
		</div>
		<div class="anaone">
		<div class="title2">
		<div class="more"><a href="${ctx}/information/info/info-list.action?infoTypeId=36" target="_blank">更多&gt;&gt;</a></div>
		<div class="nt1">市场</div>
		</div>
		
		<h1>
		<ul class="list2">
		<s:iterator value="marketInfos">
		<li><a href="${ctx}/information/info/info!show.action?requestId=${id}" target="_blank"><s:property value="shortTitle"/></a></li>
		</s:iterator>
		</ul>
		</h1>
		
		
		</div>
	

	<div class="cls"></div>
	
	<e:adquery id="ad1" adId="138"/>
	<div class="banob"><a id="138" rel="ad" target="_blank" href="<e:adlink name="ad1"/>"><img src="<e:adimg name="ad1"/>" width="970" height="84"/></a></div>
	
	
	<div class="anacon">
	<h1>
		<div class="more" style="padding-top:6px;"><a href="${ctx}/information/analogworld/info-list.action?infoTypeId=37" target="_blank">更多&gt;&gt;</a></div>
		<div class="nt1" style="padding-top:6px;">产品</div>
	</h1>
		
	<h2>
	<ul class="analist3">
	<s:iterator value="productInfos">
	<li><div class="liimg"><a href="${ctx}/information/info/info!show.action?requestId=${id}" target="_blank"><img src="<s:property value="mainImg.smallImg"/>" width="160" height="120"/></a></div>
	<p><strong><s:property value="shortTitle10"/></strong></p>
	<p><s:property value="getContentTxtByLength(25)"/></p>
	</li>
	</s:iterator>
	</ul>
	</h2>
	
	</div>

</div>
<%-- main end --%>

<%-- 合作伙伴 begin  --%>
<s:action name="copartnership" namespace="/information/inc" executeResult="true">
	<s:param name="infoTypeId"><s:property value="infoType.id"/> </s:param>
</s:action>
<%-- 合作伙伴 end --%>

<div class="cls"></div>

<%-- links begin --%>
<s:include value="/WEB-INF/content/information/inc/links.jsp"/>
<%-- links end --%>

<div class="cls"></div>

<!--foot begin-->
<s:include value="/WEB-INF/content/information/inc/footer.jsp"/>
<!--foot end-->

</div>
</body>
</html>
