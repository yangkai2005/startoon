<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="keywords" content="${seoStr}"/>
<meta http-equiv="description" content="${seoStr},星力网,动漫游戏产品网络交易平台,游戏机供应"/>
<title>${seoStr},星力网,动漫游戏产品网络交易平台,游戏机供应</title>

<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/index.css" />
<script src="${ctx}/resources/js/jquery.js" type="text/javascript"></script>
<link href="${ctx}/resources/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>

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

function doFavorite(){
	var url = "${pageContext.request.contextPath}/enterprise/favorite/favorite!add.action";
	 var html = $.ajax({
		  url: url,
		  data:"fid=${supply.id}&type=0&t="+new Date().getTime(),
		  async: false
		 }).responseText;
	 if (html=="success"){
		 alert('恭喜,收藏成功!');
	 } 
}

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
<s:include value="/WEB-INF/content/inc/header.jsp"/>
<!--main star-->
<div class="main">

<div class="qycurr" style="border-top:1px solid #f3861b">
<h1>您当前的位置：<a href="${ctx}/index.action">首 页</a>  &gt; <a href="${ctx}/supply/supply-list.action">产品分类</a> &gt; <a href="${ctx}/supply/supply-list.action?categoryId=<s:property value="supply.category.id" />"><s:property value="supply.category.name" /></a></h1>
</div>


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
<s:if test="supply.imgUrl2!=null">
<div id="bigimg2" style="display:none"  rel='img'>
<a href="${ctx}/FileView?id=<s:property value="supply.imgUrl2" />" title="" class="MagicZoom MagicThumb"><img width="312" height="297" src="${ctx}/FileView?id=<s:property value="supply.imgUrl2" />"/></a>
</div>
</s:if>
<s:if test="supply.imgUrl3!=null">
<div id="bigimg3" style="display:none" rel='img'>
<a href="${ctx}/FileView?id=<s:property value="supply.imgUrl3" />" title="" class="MagicZoom MagicThumb"><img width="312" height="297" src="${ctx}/FileView?id=<s:property value="supply.imgUrl3" />"/></a>
</div>
</s:if>



</div>

<div class="proxiao">
 <ul id="image_list" class="jcarousel-skin-tango">
 <li id="one1" class="hover"><img src="${ctx}/FileView?id=<s:property value="supply.productImgUrl" />"  id="small1" width="78" height="62"/></li>
 <s:if test="supply.imgUrl2!=null">
 <li id="one2"><img src="${ctx}/FileView?id=<s:property value="supply.imgUrl2" />"  id="small2" width="78" height="62"/></li>
 </s:if>
 <s:if test="supply.imgUrl3!=null">
 <li id="one3"><img src="${ctx}/FileView?id=<s:property value="supply.imgUrl3" />"  id="small3" width="78" height="62"/></li>
 </s:if>
 </ul>
 <div class="cls"></div>
</div>

 
</div>

<div class="prodeleft2">
<h1><p class="detitle"><s:property value="supply.name" /></p>
<p>
参考价格：<span class="red"><s:property value="supply.price" /><s:if test="supply.proPrice>0">元/<s:property value="unitname" /></s:if></span> <br />
制造商/品牌：<s:property value="supply.brand" /><br />
所在地：<s:property value="supply.source" /></p>
</h1>
<p><span class="contactmsg">联系我时,请说明是在星力网看到的,谢谢！</span> &nbsp;&nbsp;
<s:if test="#session.enterprise_user!=null">
<a style="color:red;font-weight:bold;text-decoration:underline;" href="#" onclick="doFavorite();">我要收藏</a>
</s:if>
<s:else>
<a style="color:red;font-weight:bold;text-decoration:underline;" href="#" onclick="alert('请先登录后再收藏!');">我要收藏</a>
</s:else>
</p>
<h2>
<a href="${ctx}/askprice/ask-price!input.action?enterpriseId=<s:property value='supply.creator.id' />" target="_blank"><img src="${ctx}/images/btndedj.jpg" /></a>&nbsp;&nbsp;
<a href="${ctx}/enterprises/ent-contact.action?enterpriseId=<s:property value='supply.creator.id'/>" target="_blank"><img src="${ctx}/images/btndeck.jpg" /></a>
</h2>
</div>


<div class="prodeleft3">
<div class="pde3one">
<h1>上星力网，获取更多商机</h1>
<h2>
<div class="fabu"><a href="${ctx}/enterprise/postedpro/posted-pro!input.action">免费发布求购信息</a></div>
<div class="cls"></div>
<div class="zhuce"><a href="${ctx}/register.jsp"><img src="${ctx}/images/btndezc.jpg" /></a></div>

</h2>

</div>
<div class="pde3two">
<strong><s:property value="supply.creator.name" /></strong>  <br />
联 系 人：<s:property value="supply.creator.linkman" /><br />
主营行业: <s:property value="supply.creator.business" /> <br />
所在地：<s:property value="supply.creator.address" /><br />
经营模式：<s:property value="supply.creator.manageTypeZh" />
<br />
<s:if test="supply.creator.userType==1">
<p style="margin-top:10px"><a href="${ctx}/enterprises/ent-index.action?enterpriseId=<s:property value="supply.creator.id" />"><img src="${ctx}/images/btndeqy.jpg" /></a> &nbsp;<a href="${ctx}/enterprises/ent-produce.action?enterpriseId=<s:property value="supply.creator.id" />"><img src="${ctx}/images/btndeqt.jpg" /></a></p>
</s:if>
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
<li class="hover" id="pro1" onmouseover="setTab('pro',1,3)">产品简介</li>
<li id="pro2" onmouseover="setTab('pro',2,3)">生产参数</li>
<li id="pro3" onmouseover="setTab('pro',3,3)" <s:if test="supply.creator.userType==0">style="display:none;"</s:if>>公司简介</li>
</ul>
</h1>
</div>

<div class="deccon">
	<div class="" id="con_pro_1">
		<span class="f14 b">产品名称： </span><s:property value="supply.name" /><br />
		<s:property value="supply.description" escape="html" />
	</div>
	<div class="play" id="con_pro_2">
		<s:iterator value="supply.supplyParams">
		<span class="f14 b"><s:property value="pkey"/>：</span><s:property value="pvalue"/><br/>
		</s:iterator>
	</div>
	<div class="play" id="con_pro_3">
		<s:property value="entInfo.indexContent" escape="HTML" />
	</div>
</div>


</div>



<div class="declefttwo">
<div class="f_r"><a href="${ctx}/enterprise/postedpro/posted-pro!input.action"><img src="${ctx}/images/profabu.jpg"/></a></div>
如果没有找到您想要的产品，继续搜索或发布您想要采购的产品！

</div>

</div>

<div class="decright">
	<div class="qytitle5">
		<h1>推荐产品</h1>
	</div>
	
	<div class="decright2">
		<ul>
		<s:iterator value="recommends">
		<li><div><a href="${ctx}/supply/supply-manage!detail.action?supplyId=${id}" target="_blank"><img src="${ctx}/FileView?id=<s:property value="supply.productImgUrl" />" width="164" height="135"></a></div><a href="${ctx}/supply/supply-manage!detail.action?supplyId=${id}" target="_blank"><s:property value="name"/></a></li>
		</s:iterator>
		</ul>
		<div class="cls"></div>
	</div>
</div>
 <!-- // pro over --> 
 <div class="cls"></div>
 
<s:include value="/WEB-INF/content/inc/footer.jsp"/>
</body>
</html>