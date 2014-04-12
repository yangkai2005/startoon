<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.j2eeframework.information.entity.InfoType"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>

<%
org.j2eeframework.information.entity.InfoType type = new InfoType();
type.setId(52L);
request.setAttribute("infoType", type);
%>

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
<script type="text/javascript" src="${ctx}/information/js/nav.js"></script>
<script type="text/javascript" src="${ctx}/information/js/products_scroll.js"></script>
<script type="text/javascript" src="${ctx}/information/js/swfobject.js"></script>

<link rel="stylesheet" type="text/css" href="${ctx}/css/slider/common1.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/slider/index1.css" />
<script type="text/javascript" src="${ctx}/js/slider.js"></script>

<script type="text/javascript">
$(function() {
	$('#submitBtn').click(function() {
		var radios = $(":radio:checked");
		var arr = new Array();
		for(i=0; i<radios.length; i++) {
			var id = $(radios[i]).val();
			arr.push(id);
		}
		var ids = arr.toString();
		$.post("${ctx}/information/survey/vote-option-detail!vote.action", {optionIds: ids}, function(data) {if(data=='success') {alert('投票成功，谢谢你的参与！'); location.reload();}});
	});
	$('#detailBtn').click(function() {
		window.location = '${ctx}/information/survey/info!show.action?requestId=<s:property value="survey.id"/>';
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
<!-- head start -->
<s:include value="/WEB-INF/content/information/inc/header.jsp"/>
<!-- head end -->
	    

<!--main star-->
<div class="main">
	<div class="mleft">
	<div class="leftones">
		<div class="leftbox">
			<script type="text/javascript">
			<!-- 
				var interval_time=2;
				var focus_width=305;
				var focus_height=300;
				var text_height=0;
				var text_mtop = 0;
				var text_lm = 10;
				var textmargin = text_mtop+"|"+text_lm;
				var textcolor = "#ff0000|0xFFffff";
				var text_align= 'left'; 
				var swf_height = focus_height+text_height+text_mtop; 
				var text_size = 14;
				var borderStyle="1|0x000000|0";
				var pics='<s:iterator value="imgInfos" status="st"><s:if test="#st.count>1">|</s:if> <s:property value="mainImg.normalImg"/> </s:iterator>';
				var links='<s:iterator value="imgInfos" status="st"><s:if test="#st.count>1">|</s:if> ${ctx}/information/info/info!show.action?requestId=${id } </s:iterator>'; 
				var texts='1|2|3|4';
				
				document.write('<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="'+ focus_width +'" height="'+ swf_height +'">');
				document.write('<param name="allowScriptAccess" value="sameDomain"><param name="movie" value="${ctx}/information/js/one.swf"> <param name="quality" value="high"><param name="Wmode" value="transparent">');
				document.write('<param name="menu" value="false"><param name=wmode value="opaque">');
				document.write('<param name="FlashVars" value="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'&textmargin='+textmargin+'&textcolor='+textcolor+'&borderstyle='+borderStyle+'&text_align='+text_align+'&interval_time='+interval_time+'&textsize='+text_size+'">');
				document.write('<embed src="${ctx}/information/js/one.swf" wmode="opaque" FlashVars="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'&textmargin='+textmargin+'&textcolor='+textcolor+'&borderstyle='+borderStyle+'&text_align='+text_align+'&interval_time='+interval_time+'&textsize='+text_size+'" menu="false" bgcolor="#ffffff" quality="high" width="'+ focus_width +'" height="'+ swf_height +'" allowScriptAccess="sameDomain" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />');  
				document.write('</object>');
			//-->
			</script>		
        </div>
		
		<div class="leftbox">
		<div class="title">
		<div class="more"><a href="${ctx}/information/subject/video/info-list.action?subjectId=<s:property value="currentSubject.id"/>" target="_blank">更多>></a></div>
		<div class="nt1"><img  src="${ctx}/information/images/icon_subject_jian.jpg" width="12" height="12"/>视频报道</div>
		</div>
			<p id="player1" align="center" style="background-color:#ffffff;"><a href="http://www.macromedia.com/go/getflashplayer">Get the Flash Player</a> to see this player.</p>
			<script type="text/javascript">
				var s1 = new SWFObject("${ctx}/flvplayer.swf","single","306","268","7");
				s1.addParam("allowfullscreen","false");
				s1.addVariable("autostart","false");	//打开时自动播放
				s1.addVariable("file","<s:property value="video1.mainImg.video"/>");
				s1.addVariable("image","<s:property value="video1.mainImg.normalImg"/>");	//封面图片的调用
				s1.write("player1");
			</script>
		<h1 align="center" class="wv"><s:property value="video1.title"/></h1>
		<ul class="boxvlist">
		<s:iterator value="video2">
         <li><a href="${ctx}/information/video/info!show.action?requestId=<s:property value="id"/>" target="_blank"><s:property value="title"/></a></li>
		</s:iterator>
        </ul>
		</div>
	</div>
	
	<div class="lefttwos">
	<div class="leftbox2">
	<s:iterator value="focusInfos">
	<div class="t1">
	<h1 class="t1top" style="text-align: left;"><a href="${ctx}/information/info/info!show.action?requestId=<s:property value="id"/>" target="_blank"><s:property value="title"/></a></h1>
	<h2 class="t1b"><s:property value="getContentTxtByLength(45)"/><a href="${ctx}/information/info/info!show.action?requestId=<s:property value="id"/>" target="_blank">[详细]</a></h2>
	</div>
	</s:iterator>
	</div>
		
		<div class="leftboxz">
		<div class="title">
		<div class="more"><a href="${ctx}/information/info/info-list.action?infoTypeId=49&subjectId=${currentSubject.id}" target="_blank">更多>></a></div>
		<div class="nt1"><img  src="${ctx}/information/images/icon_subject_dian.jpg" width="5" height="15"/>最新消息</div>
		</div>
	     <ul class="list2 lfetz">
	     <s:iterator value="latestInfos">
         <li><a href="${ctx}/information/info/info!show.action?requestId=<s:property value="id"/>" target="_blank"><s:property value="title"/></a></li>
	     </s:iterator>
         </ul>
		</div>
    
    <div class="leftboxz">
		<div class="title">
		<div class="more"><a href="${ctx}/information/info/info-list.action?infoTypeId=49&subjectId=${currentSubject.id}&OrderByHits=1" target="_blank">更多>></a></div>
		<div class="nt1"><img  src="${ctx}/information/images/icon_subject_dian.jpg" width="5" height="15"/>人气排行</div>
		</div>
	     <ul class="list2 lfetz">
	     <s:iterator value="hitInfos">
         <li><a href="${ctx}/information/info/info!show.action?requestId=<s:property value="id"/>" target="_blank"><s:property value="title"/></a></li>
	     </s:iterator>
          </ul>
		</div>
	</div>
	
	<div class="cls"></div>
	
	</div>
	
	<div class="mright">
    
	<div class="leftboxr">
		<div class="title">
		<div class="more"><a href="${ctx}/information/info/info-list.action?infoTypeId=50&subjectId=${currentSubject.id}" target="_blank">更多>></a></div>
		<div class="nt1"><img  src="${ctx}/information/images/icon_subject_jian.jpg" width="12" height="12"/>活动</div>

		</div>
        <div class="cls"></div>
		<div class="atvicec">
         <p><img  src="<s:property value="event.mainImg.normalImg"/>" width="241" height="113"/></p>
         <ul class="boxvlist">
          <li>时间：<s:date name="event.eventTime" format="yyyy年MM月dd日"/></li>
          <li>地点：<s:property value="event.eventCity"/></li>
          <li>活动概况：<s:property value="event.getContentTxtByLength(150)"/><span class="xiang"><a href="${ctx}/information/info/info!show.action?requestId=<s:property value="event.id"/>" target="_blank">[详细]</a></span></li>
          </ul>
         </div>
		
		</div>

	<div class="leftboxr">
		<div class="title">
		<div class="more"><!-- <a href="policy.html">更多>></a> --></div>
		<div class="nt1"><img  src="${ctx}/information/images/icon_subject_jian.jpg" width="12" height="12"/>相关链接</div>
        
		</div>
        <div class="cls"></div>
		<div class="atvicecb">
         <ul class="linklist">
         <s:iterator value="infos" status="st">
          <li <s:if test="#st.count%2==0">style="border-bottom:none;"</s:if>>
          <div class="picl"><img  src="<s:property value="mainImg.smallImg"/>" width="106" height="80"/></div>
          <div class="picr">
           <h1 class="picrt"><a href="${ctx}/information/info/info!show.action?requestId=<s:property value="id"/>" target="_blank"><s:property value="title"/></a></h1>
           <h2><s:property value="getContentTxtByLength(30)"/><a href="${ctx}/information/info/info!show.action?requestId=<s:property value="id"/>" target="_blank"><span class="red">[详情]</span></a></h2>
           </div>
           <div class="cls"></div>
          </li>
         </s:iterator>
          </ul>
         </div>
		
		</div>
	
	</div>

</div>

<!-- main over-->

<div class="cls"></div>

<!--links star-->
<s:action name="copartnership" namespace="/information/inc" executeResult="true">
<s:param name="infoTypeId">1</s:param>
</s:action>

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
