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
<script type="text/javascript" src="${ctx}/js/slider.js"></script>

<script type="text/javascript"> 
$(document).ready(function(){
	$('li#l11').addClass('hover');
	$('h2#h11').show();

	$('#searchJob').click(function(){
		$('#searchForm').attr('action', '${ctx}/information/hrservice/jobs-list.action');
		$('#searchForm').submit();
	});
	$('#searchTalent').click(function(){
		$('#searchForm').attr('action', '${ctx}/information/hrservice/talent-list.action');
		$('#searchForm').submit();
	});

	$('#zwSearchTab').click(function() {
	  $('#zwSearch').show();
	  $('#jlSearch').hide();
	  $('#searchForm').attr('action', '${ctx}/information/hrservice/jobs-list.action');
	});


	$('#jlSearchTab').click(function() {
	  $('#jlSearch').show();
	  $('#zwSearch').hide();
	  $('#searchForm').attr('action', '${ctx}/information/hrservice/talent-list.action');
	});

	$('a[rel=search]').click(function() {
		var name = $(this).attr('id');
		$('input#keyInput').attr('name', name);
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
	<div class="serleft">
		<div class="serflash">
		<h1>
		<e:adquery id="ad1" adId="212"/>
		<e:adquery id="ad2" adId="213"/>
		<e:adquery id="ad3" adId="214"/>
		<e:adquery id="ad4" adId="215"/>
		 <script type="text/javascript">
		    <!-- 
		    var interval_time=2;
		    var focus_width=336;
		    var focus_height=218;
		    var text_height=0;
		    var text_mtop = 0;
		    var text_lm = 10;
		    var textmargin = text_mtop+"|"+text_lm;
		    var textcolor = "#ff0000|0xFFffff";
		    var text_align= 'left'; 
		    var swf_height = focus_height+text_height+text_mtop; 
		    var text_size = 14;
		    var borderStyle="1|0x000000|0";
  		    var pics='<e:adimg name="ad1"/>|<e:adimg name="ad2"/>|<e:adimg name="ad3"/>|<e:adimg name="ad4"/>';
		    var links='#|#|#|#'; 
		    var texts='1|2|3|4';
		     document.write('<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="'+ focus_width +'" height="'+ swf_height +'">');
		     document.write('<param name="allowScriptAccess" value="sameDomain"><param name="movie" value="../js/one.swf"> <param name="quality" value="high"><param name="Wmode" value="transparent">');
		     document.write('<param name="menu" value="false"><param name=wmode value="opaque">');
		     document.write('<param name="FlashVars" value="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'&textmargin='+textmargin+'&textcolor='+textcolor+'&borderstyle='+borderStyle+'&text_align='+text_align+'&interval_time='+interval_time+'&textsize='+text_size+'">');
		     document.write('<embed src="${ctx}/information/js/one.swf" wmode="opaque" FlashVars="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'&textmargin='+textmargin+'&textcolor='+textcolor+'&borderstyle='+borderStyle+'&text_align='+text_align+'&interval_time='+interval_time+'&textsize='+text_size+'" menu="false" bgcolor="#ffffff" quality="high" width="'+ focus_width +'" height="'+ swf_height +'" allowScriptAccess="sameDomain" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />');  document.write('</object>');
		     //-->
		    </script>
		
		</h1>
		<e:adquery id="sad1" adId="154"/>
		<h2>
		<a id="154" rel="ad" target="_blank" href="<e:adlink name="sad1"/>"><img src="<e:adimg name="sad1"/>" width="336" height="58"/></a>		
		</h2>
		</div>
		
		<div class="serrencai">
		<div class="sertitle">
			<div class="moreser"><a href="${ctx}/information/hrservice/info-list.action?infoTypeId=45" target="_blank">更多&gt;&gt;</a></div>		
			<div class="ser1">人才工作站</div>
		</div>
		<h1>
		<ul class="serlist">
		<s:iterator value="info45">
		<li><div class="time2">[<s:date name="infoTime" format="yyyy-MM-dd"/>]</div><a href="${ctx}/information/info/info!show.action?requestId=${id}" target="_blank"><s:property value="title" /></a></li>
		</s:iterator>
		</ul>
		
		</h1>
		
		</div>
		<div class="cls"></div>
		<div class="serqiye">
		<div class="sertitle"><div class="ser1">名企招聘</div></div>
		<h1>
		<ul class="serlist2">
			<s:iterator value="hrents">
				<li><a href="<s:property value="site"/>" target="_blank"><img src="<s:property value="smallLogo"/>" width="88" height="28"/></a></li>
			</s:iterator>
		</ul>
		</h1>
		</div>
	
	
	</div>
	
	<div class="serright">
		<div class="sersousuo">
		<div class="sertitle"><div class="ser1"><a href="javascript:void(0)" id="zwSearchTab">职位搜索</a>|<a id="jlSearchTab" href="javascript:void(0)">简历搜索</a></div></div>
		<h1>
		<form id="searchForm" action="${ctx}/information/hrservice/jobs-list.action">
		<table width="100%" border="0" cellspacing="0" class="sousuotable">
		  <tbody>
		  <tr>
<td><span id="zwSearch" ><a rel="search" id="name" href="javascript:void(0)">职位</a>|<a rel="search" id="ename" href="javascript:void(0)">公司</a>|<a id="q" rel="search" href="javascript:void(0)">全文</a></span><span id="jlSearch" style="display:none;"><a id="intent" rel="search" href="javascript:void(0)">职能</a>|<a id="spec" rel="search" href="javascript:void(0)">专业</a>|<a id="exper" rel="search" href="javascript:void(0)">经验</a>|<a id="fullText" rel="search" href="javascript:void(0)">全文</a></span></td>
		  </tr>
		  <tr>
			<td><div class="sousuo1"><input id="keyInput" name="q" type="text" class="txtsousuo"/></div></td>
		  </tr>
		  <tr>
		    <td align="right"> <input type="submit" class="btnSearch" value="搜索"/></td>
		  </tr>
		</tbody>
		</table>
		</form>
		</h1>
		</div>
		
		<div class="serfabu">
		<div class="sertitle"><div class="ser1">发布注册</div></div>
		<!-- 
		<h2><a href="${ctx}/information/hrservice/talent!input.action" target="_blank"><img src="${ctx}/information/images/ser_reg.jpg" width="186" height="49"/></a>
		 -->
		<h2><a href="${ctx}/register.jsp" target="_blank"><img src="${ctx}/information/images/ser_reg.jpg" width="186" height="49"/></a>
		<a href="${ctx}/enterprise/hrservice/jobs!input.action" target="_blank"><img src="${ctx}/information/images/ser_fabu.jpg" width="186" height="48"/></a>
		</h2>
		</div>
		
		<div class="serjiaoyu">
		<div class="sertitle">
		<div class="moreser"><a href="${ctx}/information/info/info-list.action?infoTypeId=46&status=6" target="_blank">更多&gt;&gt;</a></div>
		<div class="ser1">教育培训</div>
		</div>
		
		<h1>
		<ul class="serlist3">
		<s:iterator value="info46">
		<li><a href="${ctx}/information/info/info!show.action?requestId=${id}" target="_blank"><s:property value="title" /></a></li>
		</s:iterator>
		</ul>
		
		</h1>
		
		</div>
		
		
	</div>
	
	<div class="cls"></div>
	<div class="serban"><img src="<e:ad adId="156"/>" width="968" height="90"/></div>
	<div class="serleft">
	<div class="hotzhiwei">
	<div class="sertitle2">
		<div class="moreser"><a href="${ctx}/information/hrservice/jobs-list.action" target="_blank">更多&gt;&gt;</a></div>
		<div class="ser2"><img src="../images/ser_icon3.jpg" align="absmiddle"/> 热门职位 <img src="../images/ser_icon4.gif" align="absmiddle"/></div>
	</div>
	
	<h1>
	<ul class="serlist4">
	<s:iterator value="jobs">
		<li>
		<p><a href="<s:url namespace="/enterprises" action="ent-hr"/>?enterpriseId=${enterprise.id}" target="_blank"><s:property value="enterprise.name"/></a> <s:if test="isRecommend"><span>推</span></s:if></p>
		<p><a href="<s:url namespace="/information/hrservice" action="jobs!show"/>?requestId=${id}" target="_blank"><font class="red"><s:property value="name"/></font></a></p>
		</li>
	</s:iterator>
	</ul>
	
	</h1>
	
	</div>
	
	</div>
	<div class="serright">
	<div class="serjiaoyu" style="margin-top:0">
		<div class="sertitle">
		<div class="moreser"><a href="${ctx}/information/hrservice/talent-list.action" target="_blank">更多&gt;&gt;</a></div>
		<div class="ser1">星力人才库</div>
		</div>
		
		<h3>
		<table width="100%" border="0" cellspacing="0" class="rencaitable">
		  <tbody>
		  <s:iterator value="talents">
		  <tr>
		    <td width="27%">
		    	<a href="${ctx}/information/hrservice/talent!show.action?requestId=${id}" target="_blank"><s:property value="name"/></a>
		    </td>
		    <td width="73%" class="red"><s:property value="jobIntent"/>  <s:property value="workedAge"/>年</td>
		  </tr>
		  </s:iterator>  
		</tbody>
		</table>
		</h3>
		</div>
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
