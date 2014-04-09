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
<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/swfobject.js"></script>
<script type="text/javascript" src="${ctx}/information/js/video_scroll1.js"></script>
<script language="javascript" type="text/javascript" src="${ctx}/information/js/left-scroll.js"></script>

<script type="text/javascript">
$(function() {
	
	$('li#l7').addClass('hover');
	$('h2#h7').show();	
	
	//点击右侧更换图片
	$('ul#videoList').find('a').click(function(){
		var src = $(this).find('img').attr('rel');
		$('img#bimg').attr('src', src);
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
<div class="main bgBlack">
	<div class="titleCartVideo"><s:property value="info.title"/></div>
	<div class="cartZone">
		<div class="cartAbout">
			<div class="titleWorks">视频简介:</div>
			<div class="txtCartAbout">
				<p class="b"><s:property value="info.title"/></p>
				<p>发表日期：<s:date name="info.infoTime" format="yyyy年MM月dd日"/> </p>
				<p>来源：<s:property value="info.source"/></p>
				<p class="t2m"><s:property value="info.getContentTxtByLength(200)"/></p>
			</div>
		</div>
		
		<div class="cartVideo">
		<s:if test="info.mainImg.videoType==1">
		<div class="myvideo" style="background-color:#ffffff;" id="bigImage">
		<p id="player1" align="center" style="background-color:#ffffff;"><a href="http://www.macromedia.com/go/getflashplayer">Get the Flash Player</a> to see this player.</p>
			<script type="text/javascript">
				var s1 = new SWFObject("${ctx}/flvplayer.swf","single","575","481","7");
				s1.addParam("allowfullscreen","false");
				s1.addVariable("autostart","false");	//打开时自动播放
				s1.addVariable("file","<s:property value="info.mainImg.video"/>");
				s1.addVariable("image","<s:property value="info.mainImg.normalImg"/>");	//封面图片的调用
				s1.addVariable("width","575");
				s1.addVariable("height","451");
				s1.write("player1");
			</script>		
		</div>
		</s:if>
		<s:else>
		<div align="center">
		<embed src="<s:property value="info.mainImg.video"/>" quality="high" width="570" height="480" align="middle" allowScriptAccess="sameDomain" allowFullscreen="true" type="application/x-shockwave-flash"></embed>		
		</div>
		</s:else>		
		</div>
		
		<div class="cartSml">
			<div class="titleWorks">&nbsp;</div>
			<div class="cartSmlScroll">
				<div id="videoImgs">
					<ul class="cartSmlList" id="videoList">
						<s:iterator value="info1">
						<li onclick="Hoverimg('bimg','simg1')"><a href="${ctx}/information/video/info!show.action?requestId=<s:property value='id'/>"><img src="<s:property value='mainImg.smallImg'/>"  width="88" height="58"/></a></li>
						</s:iterator>
					</ul>
				</div>
				<script type="text/javascript" src="${ctx}/information/js/video_scroll1.js"></script>
				<script>
				function Hoverimg(n,m){
					ss=document.getElementById(n);
					nn=document.getElementById(m);
					ss.src=nn.rel;
				}
				</script>
			</div>
			
		</div>
	</div>
	
	<div class="relVideo">
		<div class="titleRel">更多高清</div>
		<div class="relVideoScroll">
			 <div class="btnLeftRel" onmousedown="ISL_GoUp()" onmouseup="ISL_StopUp()" onmouseout="ISL_StopUp()"></div>
			 <div class="Cont" id="ISL_Cont">
			  <div class="ScrCont">
			   <div id="List1">
				<!-- 图片列表 begin -->
				<ul class="relVideoList">
					<s:iterator value="info2">
					<li><a href="${ctx}/information/video/info!show.action?requestId=<s:property value='id'/>"><img src="<s:property value="mainImg.smallImg"/>" alt="<s:property value="mainImg.smallImg"/>"/></a></li>
					</s:iterator>
				<!-- 图片列表 end -->
				</ul>
			   </div>
			  </div>
			 </div>
			 <div class="btnRightRel" onmousedown="ISL_GoDown()" onmouseup="ISL_StopDown()" onmouseout="ISL_StopDown()"></div>
			</div>
	</div>
	<div class="cls"></div>
</div>
<%-- main end --%>

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
