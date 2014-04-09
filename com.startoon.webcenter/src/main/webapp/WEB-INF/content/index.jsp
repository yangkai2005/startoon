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

<link rel="stylesheet" type="text/css" href="${ctx}/css/index.css" />

<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<script type="text/javascript" src="${ctx}/js/dialog.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>


<style type="text/css">
#floatBoxBg{display:none;width:100%;height:100%;background:#000;position:absolute;top:0;left:0;}
.floatBox{width:739px;position:absolute;top:50px;left:40%;}
.floatBox .title{height:23px;padding:7px 10px 0;background:#77A3CA;color:#fff;}
.floatBox .title h4{float:left;padding:0;margin:0;font-size:14px;line-height:16px;}
.floatBox .title span{float:right;cursor:pointer;}
.floatBox .title span img{padding-top:0px;padding-left:0px;}
.floatBox .content{padding:20px 15px;background:#fff;}

#box{padding:20px;margin:0 50px;background:#999;font-size:14px;}
#box h1{font-size:40px;line-height:50px;height:90px;}
#box #testFloatBox{position:static;margin:20px 0;}
#box table{margin:20px 0;}
#box h3{font-size:16px;padding:20px 0 10px;}
code{font-size:12px;color:#333;margin:10px;display:block;}
#box ol{margin:0;padding:0;list-style-position:inside;list-style-type:decimal;}
#box ol li{margin:0 0 20px 0;line-height:18px;}
#box ol li span{color:#00f;text-decoration:underline;cursor:pointer;}
#box ol li strong{display:block;}
body .iframe .content{padding:0;}
#box .title span{font-size:12px;}
#box p{line-height:18px;}
</style>

<script type="text/javascript">
$(document).ready(function() {
	if('<s:property value='type'/>'=='1') {
			$('li[rel=search]').removeClass('searin');
			$('#liEnt').addClass('searin');
	}

	$("h2[lang=category]").each(function() {
		var id = $(this).attr("rel");
		$(this).load("${ctx}/category.action?categoryId=" + id + "&type=<s:property value='type'/>&r=" + (new Date()).getTime());
	});
	
	$('a[rel=ad]').click(function() {
		var id = $(this).attr('id');
		$.post('${ctx}/information/advertisement/click.action', {'id':id});
	});
	
});
</script>

</head>

<body>

<%-- header --%>
<s:include value="/WEB-INF/content/inc/header.jsp"></s:include>
<%-- header --%>

	    
<div class="cls"></div>

<!--main star-->
<div class="main">

  <div class="title">
	  <div class="hotline"><img src="${ctx}/images/hotline.jpg" /></div>
	  <div class="titlemu"><s:if test="type==1"><img src="${ctx}/images/titlemuqy.jpg" style="display:block" /></s:if><s:else><img src="${ctx}/images/titlemu.jpg" style="display:block" /></s:else></div>
  </div>
  
 <div class="cls"></div>
 
 <div class="indexcon">
 	<div class="xinxi" style="display: none;"><img src="${ctx}/images/rmb.jpg" /> 今日采购商登录：<span class="red b">94616家</span> | 今日供应商登录：<span class="red b">203732家企业</span> |最新询盘发布：<span class="red b">10972条信息</span> |最新产品发布：<span class="red b">73630条信息</span>
	
	</div>
	<div class="qiyeku">
	<div class="l" ><span class="red f14"></span><strong>按字母分类</strong>：
	<s:if test="%{type==1}">
	<a href="${ctx}/enterprise-list.action?pinyin=A" target="_blank">A</a>
	<a href="${ctx}/enterprise-list.action?pinyin=B" target="_blank">B</a>
	<a href="${ctx}/enterprise-list.action?pinyin=C" target="_blank">C</a>  
	<a href="${ctx}/enterprise-list.action?pinyin=D" target="_blank">D</a>  
	<a href="${ctx}/enterprise-list.action?pinyin=E" target="_blank">E</a>  
	<a href="${ctx}/enterprise-list.action?pinyin=F" target="_blank">F</a>  
	<a href="${ctx}/enterprise-list.action?pinyin=G" target="_blank">G</a>  
	<a href="${ctx}/enterprise-list.action?pinyin=H" target="_blank">H</a>  
	<a href="${ctx}/enterprise-list.action?pinyin=I" target="_blank">I</a>  
	<a href="${ctx}/enterprise-list.action?pinyin=J" target="_blank">J</a>  
	<a href="${ctx}/enterprise-list.action?pinyin=K" target="_blank">K</a>  
	<a href="${ctx}/enterprise-list.action?pinyin=L" target="_blank">L</a>  
	<a href="${ctx}/enterprise-list.action?pinyin=M" target="_blank">M</a>  
	<a href="${ctx}/enterprise-list.action?pinyin=N" target="_blank">N</a>  
	<a href="${ctx}/enterprise-list.action?pinyin=O" target="_blank">O</a>  
	<a href="${ctx}/enterprise-list.action?pinyin=P" target="_blank">P</a>  
	<a href="${ctx}/enterprise-list.action?pinyin=Q" target="_blank">Q</a>  
	<a href="${ctx}/enterprise-list.action?pinyin=R" target="_blank">R</a>  
	<a href="${ctx}/enterprise-list.action?pinyin=S" target="_blank">S</a>  
	<a href="${ctx}/enterprise-list.action?pinyin=T" target="_blank">T</a>  
	<a href="${ctx}/enterprise-list.action?pinyin=U" target="_blank">U</a>  
	<a href="${ctx}/enterprise-list.action?pinyin=V" target="_blank">V</a>  
	<a href="${ctx}/enterprise-list.action?pinyin=W" target="_blank">W</a>  
	<a href="${ctx}/enterprise-list.action?pinyin=X" target="_blank">X</a>  
	<a href="${ctx}/enterprise-list.action?pinyin=Y" target="_blank">Y</a> 
    <a href="${ctx}/enterprise-list.action?pinyin=Z" target="_blank">Z</a>	
	</s:if>
	<s:else>
	<a href="${ctx}/supply-list.action?pinyin=A" target="_blank">A</a>
	<a href="${ctx}/supply-list.action?pinyin=B" target="_blank">B</a>
	<a href="${ctx}/supply-list.action?pinyin=C" target="_blank">C</a>  
	<a href="${ctx}/supply-list.action?pinyin=D" target="_blank">D</a>  
	<a href="${ctx}/supply-list.action?pinyin=E" target="_blank">E</a>  
	<a href="${ctx}/supply-list.action?pinyin=F" target="_blank">F</a>  
	<a href="${ctx}/supply-list.action?pinyin=G" target="_blank">G</a>  
	<a href="${ctx}/supply-list.action?pinyin=H" target="_blank">H</a>  
	<a href="${ctx}/supply-list.action?pinyin=I" target="_blank">I</a>  
	<a href="${ctx}/supply-list.action?pinyin=J" target="_blank">J</a>  
	<a href="${ctx}/supply-list.action?pinyin=K" target="_blank">K</a>  
	<a href="${ctx}/supply-list.action?pinyin=L" target="_blank">L</a>  
	<a href="${ctx}/supply-list.action?pinyin=M" target="_blank">M</a>  
	<a href="${ctx}/supply-list.action?pinyin=N" target="_blank">N</a>  
	<a href="${ctx}/supply-list.action?pinyin=O" target="_blank">O</a>  
	<a href="${ctx}/supply-list.action?pinyin=P" target="_blank">P</a>  
	<a href="${ctx}/supply-list.action?pinyin=Q" target="_blank">Q</a>  
	<a href="${ctx}/supply-list.action?pinyin=R" target="_blank">R</a>  
	<a href="${ctx}/supply-list.action?pinyin=S" target="_blank">S</a>  
	<a href="${ctx}/supply-list.action?pinyin=T" target="_blank">T</a>  
	<a href="${ctx}/supply-list.action?pinyin=U" target="_blank">U</a>  
	<a href="${ctx}/supply-list.action?pinyin=V" target="_blank">V</a>  
	<a href="${ctx}/supply-list.action?pinyin=W" target="_blank">W</a>  
	<a href="${ctx}/supply-list.action?pinyin=X" target="_blank">X</a>  
	<a href="${ctx}/supply-list.action?pinyin=Y" target="_blank">Y</a> 
    <a href="${ctx}/supply-list.action?pinyin=Z" target="_blank">Z</a>		
	</s:else>
	</div>
	
	 
	<div class="r"><a href="${ctx}/enterprise/supply/supply!input.action"><img src="${ctx}/images/fabu1.jpg" width='120' height='43' /></a><a href="${ctx}/enterprise/postedpro/posted-pro!input.action"><img src="${ctx}/images/fabu2.jpg"  width='120' height='43'  /></a></div>
	
	</div>
	
	<div class="cls"></div>
	
	
	<s:iterator value="categories">
		<div class="tablist">
		<div class="t1"><span class="sp1"> <s:property value="name"/></span></div>
		<h2 id="category_<s:property value="id"/>" rel="<s:property value="id"/>" lang="category"></h2>
	</div>
<div class="cls"></div>
	</s:iterator>
	
	<div class="cls"></div>
	<div class="indexnews" >
	  <div class="newslist">
	  <h1><img src="${ctx}/images/inew1.jpg" /> <a href="${ctx}/postedpro/posted-pro1-list.action">最新求购信息</a></h1>
	  <h2>
	  <ul class="list1">
	  	<s:iterator value="postedPros">
	  		<li><div class="time"><s:date name="createTime" format="yyyy-MM-dd"/></div><a href="${ctx}/postedpro/posted-pro1-list.action" class="qg">[求购]</a> <a href="${ctx}/postedpro/posted-pro!detail.action?requestId=<s:property value='id'/>"> <s:property value="proName"/> </a></li>
	  	</s:iterator>
	  </ul>
	  
	  </h2>

	  </div>
	  
	  <div class="newslist">
	  <h1><img src="${ctx}/images/inew2.jpg" /> <a href="${ctx}/enterprises/enterprise-list.action">最新入驻企业</a></h1>
	  <h2>
	  <ul class="list2">
	  	<s:iterator value="enterprises" status="st">
		  <li style="background:url(images/num<s:property value='#st.count'/>.jpg) 0 4px no-repeat;"><a href="${ctx}/enterprises/ent-index.action?enterpriseId=<s:property value="id"/>"><s:property value="enterpriseName"/></a></li>
	  	</s:iterator>
	  </ul>
	   
	  </h2>

	  </div>
	  
	  <div class="newslist">
	  <h1><img src="${ctx}/images/inew3.jpg" /><a href="${ctx}/supply/supply-list.action">最新发布供应信息</a></h1>
	  <h2>
	  <ul class="list1">
	  	<s:iterator value="supplies">
	  		<li><a href="${ctx}/supply/supply-list.action" class="qg">[供应]</a><a href="${ctx}/supply/supply-manage!detail.action?supplyId=<s:property value="id"/>"><s:property value="name"/></a></li>
	  	</s:iterator>
	</ul>
	  
	  </h2>

	  </div>
	
	</div>
	<div class="cls"></div>
	<div class="ban">
	<div style="float:left">
	  <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="781" height="96">
        <param name="movie" value="ban.swf" />
        <param name="quality" value="high" />
        <embed src="${ctx}/ban.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="781" height="96"></embed>
	  </object>
	</div>
	<e:adquery id="ad1" adId="217"/>
	<a id="217" rel="ad" target="_blank" href="<e:adlink name="ad1"/>"><img src="<e:adimg name="ad1"/>" style="float:right" width="200" height="96" /></a>
</div>

 </div>

<%-- footer --%>
<s:include value="/WEB-INF/content/inc/footer.jsp"/>
<%-- footer --%>	


</body>
</html>