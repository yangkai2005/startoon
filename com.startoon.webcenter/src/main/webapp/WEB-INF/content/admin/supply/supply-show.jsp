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

<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/admin.css"/>

<script src="${ctx}/resources/jqzoom/js/jqzoom.pack.1.0.1.js" type="text/javascript"></script>
<script src="${ctx}/resources/jqzoom/js/jquery.jcarousel.pack.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/jqzoom/js/jquery.jcarousel.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/resources/jqzoom/skins/tango/skin.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/resources/jqzoom/css/jqzoom.css" />

<style type = "text/css">
* {margin:0; padding:0;}
body {font-size:12px;}
ul {list-style:none;}
#pro_view {margin:12px;width:780px;}
#pro_infor {height:260px;}
#image_box {float:left;width:350px;height:251px;}
#image_box img {border:1px solid #ccc;width:335px;height:251px;}
#pro_baseinfo {float:left; width:400px;height:251px;}
#image_list {clear:both;height:50px;}
#image_list img {width:78px;height:62px; padding:2px;cursor:pointer;}
</style>

<script type="text/javascript"> 
$(function() {

    // 放大镜
    var options =
    {
        zoomWidth: 350,
        zoomHeight: 250,
        showEffect:'show',
        hideEffect:'fadeout',
        fadeoutSpeed: 'slow',
        title :false
    };
    $("#bigImg").jqzoom(options);

    $('#image_list img:only-child').click(function() {
        var id = $(this).parent().attr('id');
        
        $('#image_list li').removeClass('hover');
        $(this).parent().addClass('hover');
        $('div[rel=img]').hide();

        if(id=='one1') {
            $('#bigimg1').show();
        } else if(id=='one2') {
            $('#bigimg2').show();
        } else if(id=='one3') {
            $('#bigimg3').show();            
        }
    });
    

});
</script>

</head>
<body>
<div id="wrap">

<!--main star-->
<div class="main">



<script src="${ctx}/js/mz-packed.js" type="text/javascript"></script>
<div class="prode">

<div class="prodeleft1">

<div class="bimg">
<div class="fangda"><img src="${ctx}/images/fangda.jpg" /></div>
<div class="cls"></div>

<%--  --%>
<div id="bigimg1" rel='img'>
<a href="${ctx}/FileView?id=<s:property value="supply.productImgUrl" />" class="MagicZoom MagicThumb" title=""><img id="" width="312" height="297" src="${ctx}/FileView?id=<s:property value="supply.productImgUrl" />"/></a>
</div>
<div id="bigimg2" style="display:none"  rel='img'>
<a href="${ctx}/FileView?id=<s:property value="supply.imgUrl2" />" title="" class="MagicZoom MagicThumb"><img width="312" height="297" src="${ctx}/FileView?id=<s:property value="supply.imgUrl2" />"/></a>
</div>
<div id="bigimg3" style="display:none" rel='img'>
<a href="${ctx}/FileView?id=<s:property value="supply.imgUrl3" />" title="" class="MagicZoom MagicThumb"><img width="312" height="297" src="${ctx}/FileView?id=<s:property value="supply.imgUrl3" />"/></a>
</div>



</div>

<div class="proxiao">
 <ul id="image_list" class="jcarousel-skin-tango">
 <li id="one1" class="hover"><img src="${ctx}/FileView?id=<s:property value="supply.productImgUrl" />"  id="small1" width="78" height="62"/></li>
 <li id="one2"><img src="${ctx}/FileView?id=<s:property value="supply.imgUrl2" />"  id="small2" width="78" height="62"/></li>
 <li id="one3"><img src="${ctx}/FileView?id=<s:property value="supply.imgUrl3" />"  id="small3" width="78" height="62"/></li>
 </ul>
 <div class="cls"></div>
</div>

 
</div>

<div class="prodeleft2">
<h1><p class="detitle"><s:property value="supply.name" /></p>
<p>
产品价格：<span class="red"><s:property value="supply.price" /><s:if test="supply.proPrice>0">元/<s:property value="unitname" /></s:if></span> <br />
制造商/品牌：<s:property value="supply.brand" /><br />
所在地：<s:property value="supply.source" /></p>
</h1>
<h2>
</h2>
</div>



</div>

<div class="cls"></div>
<!-- //poducts about -->

<div class="decleft">
<div class="decleftone">
<div class="dectitle">
<h1>
<ul>
<li class="hover" id="pro1" onmouseover="setTab('pro',1,3)">生产参数</li>
<li id="pro2" onmouseover="setTab('pro',2,3)">产品简介</li>
<li id="pro3" onmouseover="setTab('pro',3,3)">公司简介</li>
</ul>
</h1>
</div>

<div class="deccon">
	<div class="" id="con_pro_1">
		<s:iterator value="supply.supplyParams">
		<span class="f14 b"><s:property value="pkey" />：</span><s:property value="pvalue" /><br />
		</s:iterator>
	</div>
	<div class="play" id="con_pro_2">
		<span class="f14 b">产品名称： </span><s:property value="supply.name" /><br />
		<s:property value="supply.description" escape="html" />
	</div>
	<div class="play" id="con_pro_3">
		<s:property value="entInfo.indexContent" escape="html" />
	</div>
</div>


</div>



</div>
 <!-- // pro over --> 
 <div class="cls"></div>
 
</body>
</html>