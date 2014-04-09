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
<link rel="stylesheet" type="text/css" href="${ctx}/information/css/flash.css" />

<script type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>
<script type=text/javascript src="${ctx}/js/FusionCharts.js"></script>
<script type=text/javascript src="${ctx}/js/fun.js"></script>
<script type=text/javascript src="${ctx}/js/add.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	   var currentIndex = 0;
           var DEMO; //函数对象
           var currentID = 0; //取得鼠标下方的对象ID
           var pictureID = 0; //索引ID
           $("#ifocus_piclist li").eq(0).show(); //默认
           autoScroll();
           $("#ifocus_btn li").hover(function() {
               StopScrolll();
               $("#ifocus_btn li").removeClass("current")//所有的li去掉当前的样式加上正常的样式
               $(this).addClass("current"); //而本身则加上当前的样式去掉正常的样式
               currentID = $(this).attr("id"); //取当前元素的ID
               pictureID = currentID.substring(currentID.length - 1); //取最后一个字符
               $("#ifocus_piclist li").eq(pictureID).fadeIn("slow"); //本身显示
               $("#ifocus_piclist li").not($("#ifocus_piclist li")[pictureID]).hide(); //除了自身别的全部隐藏
             

           }, function() {
               //当鼠标离开对象的时候获得当前的对象的ID以便能在启动自动时与其同步
               currentID = $(this).attr("id"); //取当前元素的ID
               pictureID = currentID.substring(currentID.length - 1); //取最后一个字符
               currentIndex = pictureID;
               autoScroll();
           });
           //自动滚动
           function autoScroll() {
               $("#ifocus_btn li:last").removeClass("current");
               $("#ifocus_tx li:last").hide();
               $("#ifocus_btn li").eq(currentIndex).addClass("current");
               $("#ifocus_btn li").eq(currentIndex - 1).removeClass("current");
               $("#ifocus_tx li").eq(currentIndex).show();
               $("#ifocus_tx li").eq(currentIndex - 1).hide();
               $("#ifocus_piclist li").eq(currentIndex).fadeIn("slow");
               $("#ifocus_piclist li").eq(currentIndex - 1).hide();
               currentIndex++; currentIndex = currentIndex >= 4 ? 0 : currentIndex;
               DEMO = setTimeout(autoScroll, 3000);
           }
           function StopScrolll()//当鼠标移动到对象上面的时候停止自动滚动
           {
               clearTimeout(DEMO);
           }
});
</script>

<script type="text/javascript"> 
$(document).ready(function(){
	$('li#l3').addClass('hover');
	$('h2#h3').show();

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
	
	$('a[rel=ad]').click(function() {
		var id = $(this).attr('id');
		$.post('${ctx}/information/advertisement/click.action', {'id':id});
	});
});
</script>
</head>

<body>
<form action="${ctx}/information/survey/vote-option-detail!vote.action" method="post">
<input type="hidden" id="optionStr" name="optionStr" />
</form>
<div id="wrap">
<s:include value="/WEB-INF/content/information/inc/header.jsp"/>

<%-- main begin --%>
<div class="main">
	
		<div class="surleft">
			<div class="surone">
			<h1>
			<div id="ifocus">
				<div id="ifocus_pic">
					<div id="ifocus_piclist" style="left:0; top:0;">
						<ul>
						<s:iterator value="imgInfo21" status="st">
							<li style="<s:if test="#st.count==1">display: list-item; </s:if><s:else>display: none; </s:else>">
								<a href="${ctx}/information/info/info!show.action?requestId=${id}" target="_blank"><img src="<s:property value="mainImg.normalImg"/>" alt="" width="440" height="222"/></a>
							</li>
						</s:iterator>
						</ul>
					</div>
					<div id="ifocus_opdiv"></div>
				
				</div>
				<div id="ifocus_btn">
					<ul>
						<s:iterator value="imgInfo21" status="st">
						<li class="<s:if test="#st.count==1">current</s:if>" id="p<s:property value='#st.index'/>"><img src="<s:property value="mainImg.smallImg"/>" alt="" width="78" height="44"/></li>
						</s:iterator>
					</ul>
				</div>
			</div>
			
			</h1>
			</div>
			
			<div class="surtwo">
				<div class="titlesur">
					<div class="sur1"><img src="../images/sur_icon1.gif" align="absmiddle"/> <strong>最新调查</strong> <span class="Arial" style=" color:#cbe5f4">LATEST SURVEY</span></div>
				
				</div>
				
				<h1>
				<div class="surbiaoti">
				<p class="f14 b red"><s:property value="info.title"/></p>
				<p><s:property value="info.content"/></p>
				
				</div>
				<div class="surdiaocha">
			  <div class="vote-result">
			  
			  <s:iterator value="info.votes">
			  <p><s:property value="title"/></p><br/>
				<ol class="olist">
				  <s:iterator value="voteOptions">
					  <li class="item">
					  <div class="d d-tit"><span class="gd"><input name="voteOptions<s:property value="vote.id"/>" type="radio" value="<s:property value="id"/>"/><s:property value="optionContent"/></span></div>
					  <div class="d d-prc">
					  <div class="bars">
					  <div style="width: <s:property value='formatPrecent'/>%; display: block; " class="precent" precent="<s:property value='formatPrecent'/>%"><img alt="" src="${ctx}/images/vote_cl_v2.png" width="149" height="13"/> 
					  </div></div><span class="precent-num">(<s:property value='formatPrecent'/>%)</span> </div>
					  <div class="d d-num"><s:property value='voteCount'/>票</div>
					  <div class="d d-from"></div>
					  </li>
					  <li style="DISPLAY: none" id="from_27522_host" class="item-area"></li>
				  </s:iterator>
				  </ol>
			  <br/><br/>
			  </s:iterator>
  
  			</div>
				<div class="cls"></div>
				<div class="surtijiao"><input id="submit" type="button" class="btntijiao"/></div>	
				</div>
				
				
			
				</h1>
				
			
			</div>	
				
		</div>
		
		<div class="surright">
			<div class="xingqing">
				<div class="titlesur2">
				<div class="moresur"><a href="${ctx}/information/survey/info-list.action?infoTypeId=21" target="_blank">更多&gt;&gt;</a></div>
				 <div class="sur2">行情综述</div>
				</div>
				
				<h1>
				<div class="xqjieshao">
				<p class="f14 lan b" align="center"><s:property value="info21First.title"/></p>
				<p><s:property value="info21First.getContentTxtByLength(85)"/><a href="${ctx}/information/info/info!show.action?requestId=<s:property value='info21First.id'/>" target="_blank">[详细]</a></p>
				</div>
				<ul class="surlist">
				<s:iterator value="info21">
				<li><a href="${ctx}/information/info/info!show.action?requestId=<s:property value='id'/>" target="_blank"><span class="lan"></span></a><a href="${ctx}/information/info/info!show.action?requestId=<s:property value='id'/>" target="_blank"><s:property value="title"/></a></li>
				</s:iterator>
				</ul>
				
				</h1>
			
			</div>
			
			<div class="surbianji">
				<div class="titlesur2">
				<!-- 
				 <div class="moresur"><a href="${ctx}/information/survey/info-list.action?infoTypeId=19" target="_blank">更多&gt;&gt;</a></div>
				 -->
				<div class="moresur"><a href="${ctx}/information/info/info-list-img.action?infoTypeId=19" target="_blank">更多&gt;&gt;</a></div>
				 <div class="sur2">编辑推荐</div>
				</div>
				
				<h1>
				<ul class="surlist2">
				
				<s:iterator value="info19">
				<li><div class="l"><a href="<s:url namespace="/information/info" action="info!show"/>?requestId=<s:property value='id'/>" target="_blank"><img src="<s:property value='mainImg.smallImg'/>" width="80" height="58"/></a></div>
				<div class="r"><h3><div class="time3">( <s:date name="infoTime" format="yyyy-MM-dd"/> )</div><span class="lan"><s:property value='title'/></span></h3>
				<h4><s:property value="getContentTxtByLength(35)"/><a href="<s:url namespace="/information/info" action="info!show"/>?requestId=<s:property value='id'/>" target="_blank"><span class="lan">[详细]</span></a></h4>
				</div>
				</li>
				</s:iterator>
				
				</ul>
				
				</h1>
				
			
			</div>
			
			<div class="surzhuti">
				<div class="titlesur2">
				<div class="moresur"><a href="${ctx}/information/survey/info-list.action?infoTypeId=20" target="_blank">更多&gt;&gt;</a></div>
				 <div class="sur2">人气排行</div>
				</div>
				
				<h1>
			<table width="100%" border="0" cellspacing="0" class="surtable">
			  <tbody><tr>
			    <th width="80%" style="text-align:left">标题</th>
			    <th width="20%">点击率</th>
			  </tr>
			  <s:iterator value="info20">
			  <tr>
			    <td><a href="<s:url namespace="/information/info" action="info!show"/>?requestId=<s:property value='id'/>" target="_blank"><s:property value="title"/></a></td>
			    <td align="center" style="font-size:14px; color:#f94304; font-weight:bold;"><s:property value="hits"/></td>
			  </tr>
			  </s:iterator>
			</tbody>
			</table>
				</h1>
			
			</div>
		
		</div>
		
		<div class="cls"></div>
		<div class="surban"><e:adquery id="ad1" adId="30"/><a id="30" rel="ad" target="_blank" href="<e:adlink name="ad1"/>"><img src="<e:adimg name="ad1"/>" width="972" height="85" /></a></div>
		
		<div class="surtab1">
		<div class="titlesur">
						<div class="moresur2"><a href="${ctx}/information/survey/info-list.action?infoTypeId=42" target="_blank">更多&gt;&gt;</a></div>
					<div class="sur1"><img src="../images/sur_icon1.gif" align="absmiddle"/> <strong>市场调查</strong></div>
				</div>
		
		<h1>
		<ul class="surlist3">
		<s:iterator value="info42">
		<li><a href="${ctx}/information/survey/info!show.action?requestId=<s:property value='id'/>" target="_blank">[<s:date name="infoTime" format="yyyy-MM-dd"/>]<s:property value="shortTitle"/> </a></li>
		</s:iterator>
		</ul>
		
		</h1>		
				
		
		</div>
		
		<div class="surtab2">
		<div class="titlesur">
						<div class="moresur2"><a href="${ctx}/information/survey/info-list.action?infoTypeId=43" target="_blank">更多&gt;&gt;</a></div>
					<div class="sur1"><img src="../images/sur_icon1.gif" align="absmiddle"/> <strong>产品调查</strong></div>
				</div>
		
		<h1>
		<ul class="surlist3">
		<s:iterator value="info43">
		<li><a href="${ctx}/information/survey/info!show.action?requestId=<s:property value='id'/>" target="_blank">[<s:date name="createTime" format="yyyy-MM-dd"/>]<s:property value="shortTitle"/> </a></li>
		</s:iterator>
		</ul>
		
		</h1>		
				
		
		</div>
		
		<div class="surtab2">
		<div class="titlesur">
						<div class="moresur2"><a href="${ctx}/information/survey/info-list.action?infoTypeId=44" target="_blank">更多&gt;&gt;</a></div>
					<div class="sur1"><img src="../images/sur_icon1.gif" align="absmiddle"/> <strong>展会调查</strong></div>
				</div>
		
		<h1>
		<ul class="surlist3">
		<s:iterator value="info44">
		<li><a href="${ctx}/information/survey/info!show.action?requestId=<s:property value='id'/>" target="_blank">[<s:date name="createTime" format="yyyy-MM-dd"/>]<s:property value="shortTitle"/> </a></li>
		</s:iterator>
		</ul>
		
		</h1>		
				
		
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
