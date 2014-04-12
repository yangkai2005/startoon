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
	$('li#l8').addClass('hover');
	$('h2#h8').show();


	$("#submit").click(function() {
		var radios = $(":radio:checked");
		var arr = new Array();
		for(i=0; i<radios.length; i++) {
			var id = $(radios[i]).val();
			arr.push(id);
		}
		var ids = arr.toString();
		$.post("${ctx}/information/survey/vote-option-detail!vote.action", {optionIds: ids}, function(data) {if(data=='success') {alert('投票成功，谢谢你的参与！'); location.reload();}});
	});

	$('#detail').click(function() {
		window.location = "${ctx}/information/survey/info!show.action?requestId=<s:property value='surveyInfo.id'/>";
	});
	
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
	<div class="entleft">	

		<div class="content_right">
		<script type="text/javascript">
			var interval_time=2;
			var focus_width=325;
			var focus_height=243;
			var text_height=0;
			var text_mtop = 0;
			var text_lm = 10;
			var textmargin = text_mtop+"|"+text_lm;
			var textcolor = "#ff0000|0xFFffff";
			var text_align= 'left'; 
			var swf_height = focus_height+text_height+text_mtop; 
			var text_size = 14;
			var borderStyle="1|0x000000|0";
			var pics='<s:iterator value="imgReportInfos" status="st"><s:if test="#st.count>1">|</s:if><s:property value="mainImg.normalImg"/></s:iterator>';
			var links='<s:iterator value="imgReportInfos" status="st"><s:if test="#st.count>1">|</s:if>${ctx}/information/info/info!show.action?requestId=${id }</s:iterator>'; 
			var texts='1|2|3|4';
			
			document.write('<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="'+ focus_width +'" height="'+ swf_height +'">');
			document.write('<param name="allowScriptAccess" value="sameDomain"><param name="movie" value="${ctx}/information/js/one.swf"> <param name="quality" value="high"><param name="Wmode" value="transparent">');
			document.write('<param name="menu" value="false"><param name=wmode value="opaque">');
			document.write('<param name="FlashVars" value="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'&textmargin='+textmargin+'&textcolor='+textcolor+'&borderstyle='+borderStyle+'&text_align='+text_align+'&interval_time='+interval_time+'&textsize='+text_size+'">');
			document.write('<embed src="${ctx}/information/js/one.swf" wmode="opaque" FlashVars="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'&textmargin='+textmargin+'&textcolor='+textcolor+'&borderstyle='+borderStyle+'&text_align='+text_align+'&interval_time='+interval_time+'&textsize='+text_size+'" menu="false" bgcolor="#ffffff" quality="high" width="'+ focus_width +'" height="'+ swf_height +'" allowScriptAccess="sameDomain" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />');  
			document.write('</object>');
		</script>		
		
		</div>

		<div class="zhanhui">
		<h1>
		<div class="more11"><a href="${ctx}/information/events/info-list.action?infoTypeId=27" target="_blank">更多&gt;&gt;</a></div><div class="int1">展会报道</div>
		</h1>
		<h2>
		<ul class="entlist">
		<s:iterator value="reportInfos">
		<li><a href="${ctx}/information/info/info!show.action?requestId=${id}" target="_blank"><s:property value="title"/></a></li>
		</s:iterator>
		</ul>
		
		</h2>
		<h3></h3>
		</div>
		<div class="cls"></div>
		<e:adquery id="ad1" adId="98"/>
		<div class="entban"><div class="entban2"><a id="98" rel="ad" target="_blank" href="<e:adlink name="ad1"/>"><img src="<e:adimg name="ad1"/>" width="642" height="85" /></a></div></div>
		
	</div>
	
	<div class="entright">
	
	<div class="zhanhui">
		<h1>
		<div class="more11"><a href="${ctx}/information/survey/info-list.action?infoTypeId=44" target="_blank">更多&gt;&gt;</a></div><div class="int1">展会调查</div>
		</h1>
		<h4>
		<div class="entxinxi">
				<p class="f14 b red"><s:property value="surveyInfo.title"/></p>
				<p><s:property value="surveyInfo.content"/> </p>
				</div>
				<s:iterator value="surveyInfo.votes">
				<div class="entxinxi2">
				<table width="100%" border="0" cellspacing="0">
				  <tbody><tr>
				    <td><strong><s:property value="title" /></strong></td>
				  </tr>
				  <s:iterator value="voteOptions">
				  <tr>
				    <td><input name="voteOptions<s:property value="vote.id"/>" type="radio" value="<s:property value="id"/>"/><s:property value="optionContent"/><br/></td>
				  </tr>
				  </s:iterator>
				</tbody>
				</table>
				</div>
				</s:iterator>
				
				<table width="100%" border="0" cellspacing="0">
				  <tbody>
				  <tr>
				    <td><input id="submit" name="submit" type="button" value="" class="btntijiao"/> <input id="detail" name="detail" type="button" value="" class="btnjieguo"/></td>
				  </tr>
				</tbody>
				</table>
		</h4>
		<h3></h3>
		</div>
	
	</div>
	
	
	<div class="cls"></div>
	
	<div class="entcon">
	<h1><div class="more11"><a href="${ctx}/information/events/info-list.action?infoTypeId=30" target="_blank">更多&gt;&gt;</a></div><div class="int1">展会图集</div></h1>
	<h2>
	<ul class="entlist2">
	<s:iterator value="imgInfos">
	<li>
		<a href="${ctx}/information/events/info!show.action?requestId=${id}" target="_blank"><img src="<s:property value='mainImg.smallImg'/>" width="120" height="90"/></a>
		<a href="${ctx}/information/events/info!show.action?requestId=${id}" target="_blank"><s:property value="getTitleByLength(8)"/></a>
	</li>
	</s:iterator>	
	
	</ul>
	
	</h2>
	
	<h3></h3>
	
	
	</div>
	
	<e:adquery id="ad2" adId="99"/>
	<div class="entban2"><a id="99" rel="ad" target="_blank" href="<e:adlink name="ad2"/>"><img src="<e:adimg name="ad2"/>" width="970" height="80" /></a></div>
	
	<div class="entcon">
	<h1><div class="more11"></div><div class="int1">展会预告</div></h1>
	<h2 style="height:270px;">
	<div class="entconl1">
	<h4><a href="${ctx}/information/info/info!show.action?requestId=<s:property value='previewInfo.id'/>" target="_blank"><img src="<s:property value='previewInfo.mainImg.normalImg'/>" width="230" height="220"/></a></h4>
	<h5><a href="${ctx}/information/info/info!show.action?requestId=<s:property value='previewInfo.id'/>" target="_blank"><s:property value='previewInfo.title'/></a><br/><s:date name="previewInfo.eventTime" format="yyyy-MM-dd"/> <s:property value='previewInfo.eventCity'/></h5>
	</div>
	
	<div class="entconl2">
	<h4><div class="more11"><a href="${ctx}/information/events/info-list.action?infoTypeId=28" target="_blank">更多&gt;&gt;</a></div><div class="ent1">国内展会</div></h4>
	<h5>
	<ul class="entlist3">
	<s:iterator value="innerInfos">
		<li><a href="${ctx}/information/info/info!show.action?requestId=${id}" target="_blank"><img src="<s:property value='mainImg.smallImg'/>" width="105" height="70"/></a>
		<s:property value="getTitleByLength(7)"/><br/><s:date name="eventTime" format="MM月dd"/>  <s:property value="eventCity"/> 
		</li>
	</s:iterator>
	</ul>
	
	</h5>
	
	</div>
	<div class="entconl3">
	<h4><div class="more11"><a href="${ctx}/information/events/info-list.action?infoTypeId=29" target="_blank">更多&gt;&gt;</a></div><div class="ent1">国外展会</div></h4>
	<h5>
	<ul class="entlist4">
	<s:iterator value="outerInfos">
		<li><div class="time3"><s:date name="eventTime" format="yyyy-MM-dd"/> <s:property value="eventCity"/></div><a href="${ctx}/information/info/info!show.action?requestId=${id}" target="_blank">&gt;&gt;<s:property value="getTitleByLength(14)"/></a></li>
	</s:iterator>
	</ul>
	
	</h5>
	
	</div>
	
	</h2>
	
	<h3></h3>
	
	
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
