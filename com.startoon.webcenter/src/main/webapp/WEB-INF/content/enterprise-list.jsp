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

<script type="text/javascript" src="js/nav.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/index.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/member.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />

<script language="javascript1.1" type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	$("a#<s:property value="pager.paramCondition['pinyin']"/>").addClass("in");
	$('li[rel=search]').removeClass('searin');
	$('#liEnt').addClass('searin');	
});
</script>
</head>

<body>

<%-- header --%>
<s:include value="/WEB-INF/content/inc/header.jsp"></s:include>
<%-- header --%>

<%-- main begin --%>

<div class="main">
  <div class="title">
  <div class="titlemu"><img src="${ctx}/images/titlefenli.jpg" style="display:block"/></div>
  
  <div class="hotline"><img src="${ctx}/images/hotline.jpg"/></div>
  </div>
  
 <div class="cls"></div>
 
 <div class="indexcon">
 	
	
	<div class="qiyeku">
	<div class="qyl"><strong>按字母分类</strong>： 
	<a id="A" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=A">A</a>
	<a id="B" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=B">B</a>
	<a id="C" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=C">C</a>  
	<a id="D" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=D">D</a>  
	<a id="E" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=E">E</a>  
	<a id="F" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=F">F</a>  
	<a id="G" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=G">G</a>  
	<a id="H" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=H">H</a>  
	<a id="I" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=I">I</a>  
	<a id="J" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=J">J</a>  
	<a id="K" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=K">K</a>  
	<a id="L" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=L">L</a>  
	<a id="M" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=M">M</a>  
	<a id="N" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=N">N</a>  
	<a id="O" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=O">O</a>  
	<a id="P" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=P">P</a>  
	<a id="Q" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=Q">Q</a>  
	<a id="R" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=R">R</a>  
	<a id="S" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=S">S</a>  
	<a id="T" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=T">T</a>  
	<a id="U" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=U">U</a>  
	<a id="V" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=V">V</a>  
	<a id="W" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=W">W</a>  
	<a id="X" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=X">X</a>  
	<a id="Y" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=Y">Y</a> 
    <a id="Z" rel="pinyin" href="${ctx}/enterprise-list.action?pinyin=Z">Z</a>
    </div>
	
	
	</div>
	
	<div class="cls"></div>
	
	<div class="qykucon">
	<ul class="qiyekulist">
		<s:iterator value="pager.items">
		<li><a href="${ctx}/enterprises/ent-index.action?enterpriseId=<s:property value='id'/>"><s:property value='shortName'/></a></li>
		</s:iterator>
	</ul>
	
	</div>

	<div class="cls"></div>
	
	<div class="cls"></div>
	<div class="ban">
	<div style="float:left">
	  <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="781" height="96">
        <param name="movie" value="ban.swf"/>
        <param name="quality" value="high"/>
        <embed src="ban.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="781" height="96"/>
	    </object></div>
		
		<img src="${ctx }/images/ssss.jpg" style="float:right" width="200" height="96"/>
	</div>
 
 </div>

</div>

<%-- main end --%>

<%-- footer --%>
<s:include value="/WEB-INF/content/inc/footer.jsp"/>
<%-- footer --%>
	
</body>
</html>