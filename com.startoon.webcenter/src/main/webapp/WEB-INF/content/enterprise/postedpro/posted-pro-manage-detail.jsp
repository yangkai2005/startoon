<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

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

});
</script>

</head>
<body>
<s:include value="/WEB-INF/content/inc/header.jsp"/>
<!--main star-->
<div class="main">

<div class="qycurr" style="border-top:1px solid #f3861b">
<h1>您当前的位置：<a href="${ctx}/index.action">首 页</a>&gt;<a href="${ctx}/postedpro/posted-pro1-list.action">产品采购</a>&gt;采购详细</h1>
</div>


<script src="${ctx}/js/mz-packed.js" type="text/javascript"></script>
<div class="prode">

<div class="prodeleft1">

<div class="bimg">
<div class="fangda"><img src="${ctx}/images/fangda.jpg" /></div>
<div class="cls"></div>
<div id="bigimg1">
<a href="${ctx}/images/picde01.jpg" title="" class="MagicZoom MagicThumb"><img src="${ctx}/images/picde01.jpg"/></a></div>
<div id="bigimg2" style="display:none">
<a href="${ctx}/images/picde01.jpg" title="" class="MagicZoom MagicThumb"><img src="${ctx}/images/picde01.jpg"/></a></div>
<div id="bigimg3" style="display:none">
<a href="${ctx}/images/picde01.jpg" title="" class="MagicZoom MagicThumb"><img src="${ctx}/images/picde01.jpg"/></a></div>

</div>

<div class="proxiao">
 <ul>
 <li onmouseover="showbig('bigimg',1,3,'one')" id="one1" class="hover"><img src="${ctx}/images/picde02.jpg"  id="small1" width="78" height="62"/></li>
 <li onmouseover="showbig('bigimg',2,3,'one')" id="one2"><img src="${ctx}/images/picde02.jpg"  id="small2" width="78" height="62"/></li>
 <li onmouseover="showbig('bigimg',3,3,'one')" id="one3"><img src="${ctx}/images/picde02.jpg"  id="small3" width="78" height="62"/></li>
 </ul>
 <div class="cls"></div>
</div>

</div>

<div class="prodeleft2">
<h1><p class="detitle"><s:property value="postedPro.proName" /></p>
<p>
产品期望价格：<span class="red"><s:property value="postedPro.proPrice" /></span> <br />
交易地点：<s:property value="postedPro.tradeAddress" /></p>
</h1>
</div>


<div class="prodeleft3">
<div class="pde3one">
<h1>上星力数码科技网，获取更多商机</h1>
<h2>
<div class="fabu"><a href="#">免费发布求购信息</a></div>
<div class="cls"></div>
<div class="zhuce"><a href="${ctx}/member/reg.html"><img src="${ctx}/images/btndezc.jpg" /></a></div>

</h2>

</div>
<div class="pde3two">
<strong>无锡百圣压缩机有限公司</strong>  <br />
联 系 人：曾志<br />
主营行业: 机械工业行业 <br />
所在地：江苏<br />
经营模式：生产型
<br />
<p style="margin-top:10px"><a href="${ctx}/storefronts/index.html"><img src="${ctx}/images/btndeqy.jpg" /></a> &nbsp;<a href="#"><img src="${ctx}/images/btndeqt.jpg" /></a></p>
</div>
</div>



</div>

<div class="cls"></div>
<!-- //poducts about -->

<div class="decleft">
<div class="decleftone">
<div class="dectitle">
<h1>
<ul>
<li id="pro2" onmouseover="setTab('pro',2,3)">产品简介</li>
</ul>
</h1>
</div>

<div class="deccon">
<div class="" id="con_pro_1">

<span class="f14 b">产品名称： <s:property value="postedPro.proName" /></span><br />
<s:property value="postedPro.description" /><div class="play" id="con_pro_2"></div>
<div class="play" id="con_pro_3"></div>

</div>

<div class="cls"></div>


<div class="deccon2">
<ul class="decon2list">
<li><div><a href="#"><img src="${ctx}/images/picde03.jpg" /></a></div>测试</li>
<li><div><a href="#"><img src="${ctx}/images/picde03.jpg" /></a></div>测试</li>
<li><div><a href="#"><img src="${ctx}/images/picde03.jpg" /></a></div>测试</li>
<li><div><a href="#"><img src="${ctx}/images/picde03.jpg" /></a></div>测试</li>
<li><div><a href="#"><img src="${ctx}/images/picde03.jpg" /></a></div>测试</li>

<li><div><a href="#"><img src="${ctx}/images/picde03.jpg" /></a></div>测试</li>
<li><div><a href="#"><img src="${ctx}/images/picde03.jpg" /></a></div>测试</li>
<li><div><a href="#"><img src="${ctx}/images/picde03.jpg" /></a></div>测试</li>
<li><div><a href="#"><img src="${ctx}/images/picde03.jpg" /></a></div>测试</li>
<li><div><a href="#"><img src="${ctx}/images/picde03.jpg" /></a></div>测试</li>

</ul>
</div>

<div class="deccon3">
<img src="${ctx}/images/picde04.jpg" />
</div>


 
 

</div>



<div class="declefttwo">
<div class="f_r"><a href="#"><img src="${ctx}/images/profabu.jpg"/></a></div>
如果没有找到您想要的产品，继续搜索或发布您想要采购的产品！

</div>


</div>


<div class="decright">
<div class="qytitle5">
	<h1>你可能感兴趣的产品</h1>
	</div>
	
	<div class="decright2">
	<ul>
	<li><div><a href="#"><img src="${ctx}/images/liulan.jpg" width="164"  height="135"/></a></div><a href="#">Kaitain节能螺杆空压机</a></li>
	<li><div><a href="#"><img src="${ctx}/images/liulan.jpg" width="164"  height="135" /></a></div><a href="#">Kaitain节能螺杆空压机</a></li>
	<li><div><a href="#"><img src="${ctx}/images/liulan.jpg"  width="164"  height="135"/></a></div><a href="#">Kaitain节能螺杆空压机</a></li>
	<li><div><a href="#"><img src="${ctx}/images/liulan.jpg"  width="164"  height="135"/></a></div><a href="#">Kaitain节能螺杆空压机</a></li>
	
	</ul>
	<div class="cls"></div>
	</div>
	
	</div>
	
	






 


  

  
  
 <!-- // pro over --> 
  
  
  
  
 <div class="cls"></div>
 
<s:include value="/WEB-INF/content/inc/footer.jsp"/>
</body>
</html>