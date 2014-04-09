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
<script type="text/javascript" src="${ctx}/information/js/nflash.js"></script>

<script type="text/javascript"> 
$(document).ready(function(){
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
	<div class="left">
    <div class="lmain2">
        <div class="title6">
		     <div class="moren"><a href="${ctx}/information/info/info-list-img.action?infoTypeId=18" target="_blank">更多&gt;&gt;</a></div>
		     <div class="nt1">图片</div>
		</div>
        <div class="cls"></div>
        <div class="zxflash">
        <div id="focus_change">
		 <script type="text/javascript">
		    <!-- 
		    var interval_time=2;
		    var focus_width=680;
		    var focus_height=305;
		    var text_height=0;
		    var text_mtop = 0;
		    var text_lm = 10;
		    var textmargin = text_mtop+"|"+text_lm;
		    var textcolor = "#ff0000|0xFFffff";
		    var text_align= 'left'; 
		    var swf_height = focus_height+text_height+text_mtop; 
		    var text_size = 14;
		    var borderStyle="1|0x000000|0";
  		    var pics='<s:iterator value="imgInfos" status="st"><s:if test="#st.count>1">|</s:if><s:property value='mainImg.normalImg'/></s:iterator>';
		    var links='<s:iterator value="imgInfos" status="st"><s:if test="#st.count>1">|</s:if>${ctx}/information/info/info!show.action?requestId=<s:property value='id'/></s:iterator>'; 
		    var texts='<s:iterator value="imgInfos" status="st"><s:if test="#st.count>1">|</s:if><s:property value="title"/></s:iterator>';
		     document.write('<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="'+ focus_width +'" height="'+ swf_height +'">');
		     document.write('<param name="allowScriptAccess" value="sameDomain"><param name="movie" value="../js/one.swf"> <param name="quality" value="high"><param name="Wmode" value="transparent">');
		     document.write('<param name="menu" value="false"><param name=wmode value="opaque">');
		     document.write('<param name="FlashVars" value="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'&textmargin='+textmargin+'&textcolor='+textcolor+'&borderstyle='+borderStyle+'&text_align='+text_align+'&interval_time='+interval_time+'&textsize='+text_size+'">');
		     document.write('<embed src="${ctx}/information/js/one.swf" wmode="opaque" FlashVars="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'&textmargin='+textmargin+'&textcolor='+textcolor+'&borderstyle='+borderStyle+'&text_align='+text_align+'&interval_time='+interval_time+'&textsize='+text_size+'" menu="false" bgcolor="#ffffff" quality="high" width="'+ focus_width +'" height="'+ swf_height +'" allowScriptAccess="sameDomain" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />');  document.write('</object>');
		     //-->
		    </script>		
		
		</div>
        
        </div>
    
    </div>
    <div class="cls"></div>
    <div class="lmain">
	<div class="leftone">
	  <div class="loneside">
	    <div class="title5">
		<div class="moren"><a href="${ctx}/information/info/info-list.action?infoTypeId=14" target="_blank">更多&gt;&gt;</a></div>
		<div class="nt1">政策</div>
		</div>
		
		<div class="lonezc">
		<ul class="list1">
		<s:iterator value="zcInfos" status="st1">
			<li><div class="time"><s:date name="infoTime" format="yyyy-MM-dd"/></div><a href="${ctx}/information/info/info!show.action?requestId=${id}" target="_blank"><s:property value="shortTitle"/></a></li>
			<s:if test="#st1.count==3"><li class="bottomline">&nbsp;</li></s:if>
		</s:iterator>
		</ul>
		</div>
		
		</div>
	</div>
	
	<div class="lefttwo">
	
		<div class="loneside">
		<div class="title5">
		<div class="moren"><a href="${ctx}/information/info/info-list.action?infoTypeId=13" target="_blank">更多&gt;&gt;</a></div>
		<div class="nt1">行业</div>
		</div>
		
		<div class="lonezc">
		<ul class="list1">
		<s:iterator value="tradeInfos" status="st2">
			<li><div class="time"><s:date name="infoTime" format="yyyy-MM-dd"/></div><a href="${ctx}/information/info/info!show.action?requestId=${id}" target="_blank"><s:property value="shortTitle"/> </a></li>
			<s:if test="#st2.count==3"><li class="bottomline">&nbsp;</li></s:if>
		</s:iterator>
		</ul>
		</div>
		
		
		</div>
	
	</div>
	</div>
	<div class="cls"></div>
	
	<e:adquery id="ban" adId="2"/>	
	<div class="ban2"><a id="2" rel="ad" target="_blank" href="<e:adlink name="ban"/>"><img src="<e:adimg name="ban"/>" width="700" height="97" /></a></div>
	
	<div class="leftone">
		<div class="loneside" style="margin-bottom:0">
		<div class="title5">
		<div class="moren"><a href="${ctx}/information/info/info-list.action?infoTypeId=16" target="_blank">更多&gt;&gt;</a></div>
		<div class="nt1">产品</div>
		</div>
		
		<div class="lonezc">
		<ul class="list1">
		<s:iterator value="productInfos" status="st3">
			<li><div class="time"><s:date name="infoTime" format="yyyy-MM-dd"/></div><a href="${ctx}/information/info/info!show.action?requestId=${id}" target="_blank"><s:property value="shortTitle"/> </a></li>
			<s:if test="#st3.count==3"><li class="bottomline">&nbsp;</li></s:if>
		</s:iterator>
		</ul>
		</div>
		
		
		</div>
	</div>
	
	<div class="lefttwo">
		<div class="loneside" style="margin-bottom:0">
		<div class="title5">
		<div class="moren"><a href="${ctx}/information/info/info-list.action?infoTypeId=15" target="_blank">更多&gt;&gt;</a></div>
		<div class="nt1">市场</div>
		</div>
		
		<div class="lonezc">
		<ul class="list1">
		<s:iterator value="marketInfos" status="st4">
			<li><div class="time"><s:date name="infoTime" format="yyyy-MM-dd"/></div><a href="${ctx}/information/info/info!show.action?requestId=${id}" target="_blank"><s:property value="shortTitle"/> </a></li>
			<s:if test="#st4.count==3"><li class="bottomline">&nbsp;</li></s:if>
		</s:iterator>
		</ul>
		</div>
		
		</div>
	</div>
	
	
	</div>
	
	<div class="right">
	<div class="title3"><div class="nt2">阅读排行</div></div>
	<div class="paiming">
		<h1>
		<ul class="paiminglist">
		<s:iterator value="hitInfos">
			<li><a href="${ctx}/information/info/info!show.action?requestId=<s:property value='id'/>" target="_blank"><s:property value="getTitleByLength(13)"/></a></li>
		</s:iterator>
		</ul>
		</h1>
	</div>
	
	<s:include value="/WEB-INF/content/information/inc/right-ad2.jsp"/>
	<s:action name="info-latest" namespace="/information/inc" executeResult="true"/>
	<s:include value="/WEB-INF/content/information/inc/right-ad3.jsp"/>	
	
	</div>


</div>

<div class="cls"></div>

<%-- main end --%>

<%-- 合作伙伴 begin  --%>
<s:action name="copartnership" namespace="/information/inc" executeResult="true">
	<s:param name="infoTypeId"><s:property value="infoType.id"/></s:param>
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
