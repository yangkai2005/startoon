<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="星力动漫游戏产业园" />
<meta name="description" content="星力动漫游戏产业园" />
<meta name="author" content="xiaohe" />
<title>星力动漫游戏产业园</title>
<link rel="stylesheet" type="text/css" href="${ctx}/information/css/style.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/information/css/common.css"/>
<script type="text/javascript" src="${ctx}/information/js/nav.js"></script>
<script type="text/javascript" src="${ctx}/information/js/common.js"></script>
<script src="${ctx}/information/js/xixi.js" type=text/javascript></script>
<script type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="${ctx}/js/swfobject.js"></script>

<e:query id="infoImgs" sql="select a.id, a.title, b.small_img_url, b.img_url from t_info a left join t_info_img b on a.id=b.info_id where a.info_type_id=18 and a.status=2 and a.is_img_info=1 and b.is_main_img=1 order by a.id desc limit 10" isMultiple="true"/>

<script type="text/javascript">
			var areaDailyList = [
			         			<s:iterator value="#request.infoImgs" status="st">
			         			<s:if test="#st.count>1">,</s:if>
			         			{"image":"${ctx}/FileView?id=<s:property value="img_url"/>"}
			         			</s:iterator>
			         			];
			jQuery(function(){
			if (!$('#slidePic')[0]) 
			return;
			var i = 0, p = $('#slidePic ul'), pList = $('#slidePic ul li'), len = pList.length;
			var elePrev = $('#prev'), eleNext = $('#next');
			//var firstClick = false;
			var w = 60, num = 4;
			p.css('height',w*len);
			if (len <= num) 
			eleNext.addClass('gray');
			function prev(){
			if (elePrev.hasClass('gray')) {
			//alert('已经是第一张了');
			return;
			}
			p.animate({
			marginTop:-(--i) * w
			},500);
			if (i < len - num) {
			eleNext.removeClass('gray');
			}
			if (i == 0) {
			elePrev.addClass('gray');
			}
			}
			function next(){
			if (eleNext.hasClass('gray')) {
			//alert('已经是最后一张了');
			return;
			}
			//p.css('margin-left',-(++i) * w);
			p.animate({
			marginTop:-(++i) * w
			},500);
			if (i != 0) {
			elePrev.removeClass('gray');
			}
			if (i == len - num) {
			eleNext.addClass('gray');
			}
			}
			elePrev.bind('click',prev);
			eleNext.bind('click',next);
			pList.each(function(n,v){
			$(this).click(function(){
			if(n-i == 3){
			next();
			}
			if(n-i == 0){
			prev()
			}
			$('#slidePic ul li.cur').removeClass('cur');
			$(this).addClass('cur');
			show(n);
			}).mouseover(function(){
			$(this).addClass('hover');
			}).mouseout(function(){
			$(this).removeClass('hover');
			})
			});
			function show(i){
			var ad = areaDailyList[i];
		
		
			$('#dailyImage').attr('src',ad.image);
			
			
			}
			});
			
</script>

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
		$.post("${ctx}/information/survey/vote-option-detail!vote.action", {optionIds: ids}, function(data) {if(data=='success') {alert('投票成功，谢谢你的参与！');}});
	});
	$('#detailBtn').click(function() {
		window.location = '${ctx}/information/survey/info!show.action?requestId=<s:property value="survey.id"/>';
	});

	$('img#dailyImage').click(function() {
		var id = $(this).attr('class');
		var url = '${ctx}/information/info/info!show.action?requestId='+id;
		$(this).parent().attr('href', url);
		$(this).parent().trigger('click');
	});

	$('img.smallFocusImg').click(function() {
		var id = $(this).attr('id');
		$('img#dailyImage').attr('class', id);
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

<s:include value="/WEB-INF/content/information/inc/htop.jsp"/>
<s:include value="/WEB-INF/content/information/inc/hnav.jsp"/>
<s:include value="/WEB-INF/content/information/inc/hbanner-index.jsp"/>
<s:include value="/WEB-INF/content/information/inc/hsearch.jsp"/>

<!--main star-->
<div class="indexmain">

<e:query id="ads" sql="select id, ad_no, position, name, link_url from t_advertisement where id>221 limit 29"/>
<s:set var="textAd" value="#request.ads"/>

<!-- one -->
	<div class="one">
    	<div class="title_new">
    		<div class="more_new"><a href="${ctx}/information/info/info-index.action">更多>></a></div><h1><b>资讯中心</b></h1>
			<div class="zanzhu">
				<s:iterator value="textAd" begin="0" end="4"> <a href="<s:property value="link_url"/>" title="<s:property value="name"/>" target="_blank"><s:property value="name"/></a></s:iterator>
			</div>    		
    	</div>
        <div class="onecontab">
        			<!-- flash -->
        		<div class="flash">
                <div class="zuopinleft"><a href="#" rel="focusImg" target="_blank"><img src="${ctx}/FileView?id=<s:property value="%{#request.infoImgs.get(0).img_url}"/>" width="323" height="226" id="dailyImage" class="<s:property value="%{#request.infoImgs.get(0).id}"/>" /></a></div>
                <div class="zuopinright">
            	<div class="slide-pic" id="slidePic">
				<a class="gray" id="prev" hideFocus href="javascript:;"></a> 
				<div class=pic-container>
					<ul>
					<s:iterator value="#request.infoImgs" status="st">
					  <li><img src="${ctx}/FileView?id=<s:property value="small_img_url"/>" width="66" height="50" class="smallFocusImg" id="<s:property value="id"/>"/></li>
					</s:iterator>
					</ul>
				</div>
				 <a id="next" hideFocus href="javascript:;"></a>
			</div>
            
            </div></div>
                <!-- flash over -->
                
				<e:query sql="select a.id, a.title, b.name, a.hot, a.content_txt from t_info a left join t_info_type b on a.info_type_id=b.id where a.is_img_info=0 and a.status=2 and b.type_no like '0001%' and b.id<>18 order by a.id desc limit 15" id="zxinfo" isMultiple="true"/>
                <div class="oneconright">
                	<div class="onerighttext1">
                    	<h2><b><a href="${ctx}/information/info/info!show.action?requestId=<s:property value="#request.zxinfo.get(0).id"/>" target="_blank"><s:property value="#request.zxinfo.get(0).title"/></a></b></h2>
                        <p class="em"><s:if test="%{#request.zxinfo.get(0).content_txt.length()>120}"><s:property value="#request.zxinfo.get(0).content_txt.substring(0, 120)"/>...</s:if><s:else><s:property value="#request.zxinfo.get(0).content_txt"/></s:else></p>
                    </div>
                    
                    <div class="onerighttext2">
                    	<ul class="onelist">
							<s:iterator value="#request.zxinfo" status="st" begin="1">
								<li <s:if test="#st.count%2==0">class="noright"</s:if>><a href="${ctx}/information/info/info!show.action?requestId=<s:property value="id"/>" title="<s:property value="title"/>" target="_blank">[<s:property value="name"/>]<s:if test="title.length()>10"><s:property value="title.substring(0,10)"/>...</s:if><s:else><s:property value="title"/></s:else></a><s:if test="%{hot==1}"><img src="${ctx}/information/images/hot.jpg" width="21" height="13" /></s:if></li>
							</s:iterator>
                        </ul>
                    </div>
                
                </div>
        
        </div> 
        
        <div class="cls"></div>
        
        <div class="onetwoleft">
        	<div class="l">
			<e:query id="video" sql="select a.id, a.title, b.video_path, b.img_url, b.video_type from t_info a left join t_info_img b on a.id=b.info_id where a.title='星力园区360°全景展示'" isMultiple="false"/>
			<a target="_blank" href="<s:property value='#request.video.video_path'/>"><img src="${ctx}/FileView?id=<s:property value="#request.video.img_url"/>" alt="<s:property value="#request.video.title"/>" width="232" height="165" /></a>
            <p><b>星力园区360°全景展示</b></p>
            </div>
            
            <div class="r">
            	 <ul class="oneimglist">
                 	<li><a href="http://www.chnam.com/xldm/index2.html" target="_blank"><img src="images/logo-kcdz.jpg" width="95" height="33" /></a></li>
                    <li><a href="http://www.chnam.com/xldm/g27.html" target="_blank"><img src="images/logo-yzly.jpg" width="95" height="33" /></a></li>
                    <li><a href="${ctx}/information/index.action"><img src="${ctx}/images/logo.jpg" width="95" height="33" /></a></li>
                    <li><a href="${ctx}/information/index.action"><img src="${ctx}/images/logo.jpg" width="95" height="33" /></a></li>
                    <li><a href="${ctx}/information/index.action"><img src="${ctx}/images/logo.jpg" width="95" height="33" /></a></li>
                    <li><a href="${ctx}/information/index.action"><img src="${ctx}/images/logo.jpg" width="95" height="33" /></a></li>
                    <li><a href="${ctx}/information/index.action"><img src="${ctx}/images/logo.jpg" width="95" height="33" /></a></li>
                    <li><a href="${ctx}/information/index.action"><img src="${ctx}/images/logo.jpg" width="95" height="33" /></a></li>
                 </ul>
            
            </div>
        </div>
        
        <div class="onetworight">
        <div class="title_new2">
        	<div class="more_new2"><a href="${ctx}/information/subject/index.action">更多>></a></div><h1><b>专题</b></h1>
			<div class="zanzhu2">
				<s:iterator value="textAd" begin="25" end="28"> <a href="<s:property value="link_url"/>" title="<s:property value="name"/>" target="_blank"><s:property value="name"/></a></s:iterator>
			</div>         	
        </div>
        
        <e:query sql="select a.id, a.title, a.content_txt, c.small_img_url from t_info a left join t_info_type b on a.info_type_id=b.id left join t_info_img c on c.info_id=a.id where b.type_no like '0012%' and a.status=2 and a.is_img_info=1 order by a.id desc limit 1" id="subject" isMultiple="false"/>
        <div class="onetworighttext1">
        	<div class="l"><a href="${ctx}/information/info/info!show.action?requestId=<s:property value="#request.subject.id"/>" title="<s:property value="#request.subject.title"/>" target="_blank"><img src="${ctx}/FileView?id=<s:property value="#request.subject.small_img_url"/>" width="104" height="74" alt="<s:property value="#request.subject.title"/>" /></a></div>
            <div class="r">
            	<h2><b><a href="${ctx}/information/info/info!show.action?requestId=<s:property value="#request.subject.id"/>" title="<s:property value="#request.subject.title"/>" target="_blank"><s:property value="#request.subject.title"/></a></b></h2>
                <p><s:if test="#request.subject.content_txt.length()>50"><s:property value="#request.subject.content_txt.substring(0,50)"/>...</s:if><s:else><s:property value="#request.subject.content_txt"/></s:else></p>
            
            </div>   
        </div>
        <e:query sql="select a.id, a.title from t_info a left join t_info_type b on a.info_type_id=b.id where b.type_no like '0012%' and a.status=2 and a.is_img_info=0 order by a.id desc limit 6" id="subjects" isMultiple="true"/>
        <div class="onetworighttext2">
			<ul class="onelist2">
				<s:iterator value="#request.subjects" status="st">
               	<li <s:if test="#st.count%2==0">class="noright"</s:if>><a href="${ctx}/information/info/info!show.action?requestId=<s:property value="id"/>" title="<s:property value="title"/>" target="_blank"><s:if test="title.length()>12"><s:property value="title.substring(0, 10)"/>...</s:if><s:else><s:property value="title"/></s:else></a></li>
				</s:iterator>
           </ul>
		</div>
        </div>
    </div><!-- one over -->
    
		
	<div class="cls"></div>
	
	<e:adquery id="ban" adId="180"/>
	<a id="180" rel="ad" target="_blank" href="<e:adlink name="ban"/>"><img src="<e:adimg name="ban"/>" width="972" height="130" /></a>	
	
    <!-- two -->
	<div class="two">
    
    <!-- two left -->
    	<div class="twoleft">
        	<div class="title_new3">
        	<div class="more_new"></div><h1><b>访谈▪观察</b></h1>
			<div class="zanzhu">
				<s:iterator value="textAd" begin="5" end="9"> <a href="<s:property value="link_url"/>" title="<s:property value="name"/>" target="_blank"><s:property value="name"/></a></s:iterator>
			</div>         	
        	</div>
<e:query id="focusFtgc" sql="select a.id, a.title, a.content_txt, b.small_img_url from t_info a left join t_info_img b on a.id=b.info_id where a.info_type_id in (4, 6) and a.status=2 and a.hot=1 and a.is_img_info=1 and b.is_main_img=1 order by a.id desc limit 1" isMultiple="false" />            
            <div class="twolefttab">
            <div class="fangcha">
            	<a href="${ctx}/information/info/info!show.action?requestId=<s:property value="#request.focusFtgc.id"/>" title="<s:property value="#request.focusFtgc.title"/>" target="_blank"><img src="${ctx}/FileView?id=<s:property value="#request.focusFtgc.small_img_url"/>" width="196" height="139" alt="<s:property value="#request.focusFtgc.title"/>"/></a>
               <b><a href="${ctx}/information/info/info!show.action?requestId=<s:property value="#request.focusFtgc.id"/>" title="<s:property value="#request.focusFtgc.title"/>" target="_blank"><s:property value="#request.focusFtgc.title"/></a></b>
            </div>
            <div class="fangchatext">
            		<div class="fangchaone">
                    	<h2><b><a href="${ctx}/information/info/info!show.action?requestId=<s:property value="#request.focusFtgc.id"/>" title="<s:property value="#request.focusFtgc.title"/>" target="_blank"><s:property value="#request.focusFtgc.title"/></a></b></h2>
                          <p><s:if test="#request.focusFtgc.content_txt.length()>75"><s:property value="#request.focusFtgc.content_txt.substring(0, 75)"/>...</s:if><s:else><s:property value="#request.focusFtgc.content_txt"/></s:else></p>
                    </div>
<e:query id="ftgc" sql="select a.id, a.title from t_info a where a.info_type_id in (4, 6) and a.status=2 and a.hot=0 order by a.id desc limit 10" />
                    <div class="fangchatwo">
                    	<ul class="onelist3">
				<s:iterator value="#request.ftgc" status="st">
               	<li <s:if test="#st.count%2==0">class="noright"</s:if>><a href="${ctx}/information/info/info!show.action?requestId=<s:property value="id"/>" title="<s:property value="title"/>" target="_blank"><s:if test="title.length()>12"><s:property value="title.substring(0, 12)"/>...</s:if><s:else><s:property value="title"/></s:else></a></li>
				</s:iterator>
                        </ul>
                    </div>
            </div>
            
            </div>
            
            <div class="title_new3">
            	<div class="more_new"><a href="${ctx}/information/show/index.action" title="创意show">更多>></a></div><h1><b>创意show</b></h1>
				<div class="zanzhu">
					<s:iterator value="textAd" begin="10" end="14"> <a href="<s:property value="link_url"/>" title="<s:property value="name"/>" target="_blank"><s:property value="name"/></a></s:iterator>
				</div>             	
            </div>
            <!-- twoleftflash -->
            <div class="twoleftflash">
			 <div class=scroll>
                        <div id=arrLeft_01 class=arrLeft></div>
                       
<e:query id="shows" sql="select a.id, a.title, c.small_img_url, a.info_type_id from t_info a left join t_info_type b on a.info_type_id=b.id left join t_info_img c on c.info_id=a.id where b.type_no like '0006%' and a.status=2 and a.is_img_info=1 and c.is_main_img=1 and a.info_type_id!=7 order by a.id desc limit 16" />			
	
           <div id=arrCont_01 class=arrCont>
				<ul>
					<s:iterator value="#request.shows" status="st">
					<s:if test="#st.count%2==1 && #st.count>1"></li></s:if>
					<s:if test="#st.count%2==1 "><li></s:if>
					<div class="liimg">
						<s:if test="%{info_type_id==7}">
							<a href="${ctx}/information/info/info!show.action?requestId=<s:property value='id'/>" title="<s:property value='title'/>" target="_blank"><img src="${ctx}/FileView?id=<s:property value="small_img_url"/>" width="132" height="73" /></a>
							<a href="${ctx}/information/info/info!show.action?requestId=<s:property value='id'/>" title="<s:property value='title'/>" target="_blank"><s:property value='title'/></a>
						</s:if>
						<s:else>
							<a href="${ctx}/information/show/info!show.action?requestId=<s:property value='id'/>" title="<s:property value='title'/>" target="_blank"><img src="${ctx}/FileView?id=<s:property value="small_img_url"/>" width="132" height="73" /></a>
							<a href="${ctx}/information/show/info!show.action?requestId=<s:property value='id'/>" title="<s:property value='title'/>" target="_blank"><s:property value='title'/></a>
						</s:else>
					</div>
					</s:iterator>				
                </ul>
                </div>
               <div id=arrRright_01 class=arrRright></div>
               
               <div class="cls"></div>
               
               </div>
               
                <script language=javascript type=text/javascript>
                                          <!--//--><![CDATA[//><!--
                                          var focusScroll_01 = new ScrollPic();
                                          focusScroll_01.scrollContId	= "arrCont_01"; //内容容器ID
                                          focusScroll_01.arrLeftId	  = "arrLeft_01";//左箭头ID
                                          focusScroll_01.arrRightId	 = "arrRright_01"; //右箭头ID
                                          focusScroll_01.frameWidth	 = 592;//显示框宽度
                                          focusScroll_01.pageWidth	  = 148; //翻页宽度
                                          focusScroll_01.upright		= false; //垂直滚动
                                          focusScroll_01.speed		  = 20; //移动速度(单位毫秒，越小越快)
                                          focusScroll_01.space		  = 20; //每次移动像素(单位px，越大越快)
                                          focusScroll_01.autoPlay		= true; //自动播放
                                          focusScroll_01.autoPlayTime	= 5; //自动播放间隔时间(秒)
                                          focusScroll_01.initialize(); //初始化
                        
                                          //--><!]]>
                                    </script>
               
		
            </div><!-- twoleftflash over -->
            
        	
        
        </div> <!-- twoleft over -->
        
        <div class="tworight">
        <!-- twortab -->
        	<div class="twortab">
            	 <div class="twotitle">
                 	<div class="more_two"><a href="${ctx}/information/bar/index.action">更多>></a></div>
                 	<h2>店长吧</h2>
                 </div>
                 
                 <div class="twotitlenav">
                 	<ul class="twonavlist">
                        <li class="hover" onmouseover="setTab('twoone',1,3)" id="twoone1"><a href="javascript:void(0)">最新话题</a></li>    
                        <li onmouseover="setTab('twoone',2,3)" id="twoone2"><a href="javascript:void(0)">置顶话题</a></li>    
                        <li onmouseover="setTab('twoone',3,3)" id="twoone3"><a href="javascript:void(0)">热贴排行</a></li> 
                    </ul>   
                 </div>
                 
                 <div class="twotcon">
                 	<div id="con_twoone_1">
                    	<ul class="twolist1">
				<s:iterator value="barLatestInfos">
				<li><div class="ttime1"> <s:property value="creatorName"/>  <s:date name="createTime" format="yyyy-MM-dd" /></div><a href="${ctx}/information/info/info!show.action?requestId=<s:property value='id'/>" target="_blank"  title="<s:property value="title"/>"><s:property value="getTitleByLength(8)"/></a></li>
				</s:iterator>
                        </ul>
                    
                    </div>
                    
                    <div id="con_twoone_2" class="hidden">
										<ul class="twolist1">
				<s:iterator value="barTopInfos">
				<li><div class="ttime1"> <s:property value="creatorName"/>  <s:date name="createTime" format="yyyy-MM-dd" /></div><a href="${ctx}/information/info/info!show.action?requestId=<s:property value='id'/>" title="<s:property value="title"/>" target="_blank"><s:property value="getTitleByLength(8)"/></a></li>
				</s:iterator>	
				</ul>
										</div>
                    <div id="con_twoone_3" class="hidden">
										<ul class="twolist1">
<e:query id="barHotInfos" sql="select a.id, a.title, a.create_time, a.creator_name from t_info a left join t_info_type b on a.info_type_id=b.id  where b.type_no like '0004%' and a.status=2 and a.hot=1 order by a.id desc limit 6" />	
				<s:iterator value="#request.barHotInfos">
				<li><div class="ttime1"> <s:property value="creator_name"/>  <s:date name="create_time" format="yyyy-MM-dd" /></div><a href="${ctx}/information/info/info!show.action?requestId=<s:property value='id'/>"  title="<s:property value="title"/>" target="_blank"><s:if test="title.length()>10"><s:property value="title.substring(0,8)"/>...</s:if><s:else><s:property value="title"/></s:else></a></li>
				</s:iterator>	
				</ul>										
				</div>
                 
                 
                 </div>
            </div><!-- twortab over -->
            
              <!-- twortab -->
        	<div class="twortab">
            	 <div class="twotitle">
                 	<div class="more_two"><a href="${ctx}/information/info/info-list.action?infoTypeId=54">更多>></a></div>
                 	<h2>商讯</h2>
                 </div>
                 
                 <div class="twotcon">
<e:query id="shangxun" sql="select a.id, a.title from t_info a where a.info_type_id=54 and a.status=2 order by a.id desc limit 12" />                 
                    	<ul class="twolist2">
                    	<s:iterator value="#request.shangxun">
                        	<li><a href="${ctx}/information/info/info!show.action?requestId=<s:property value='id'/>" title="<s:property value="title"/>" target="_blank"><s:property value="title"/></a></li>
                    	</s:iterator>
                        </ul>
                 
                 </div>
            </div><!-- twortab over -->
            
        </div>
    
    </div><!-- two over -->
    
    <div class="ban3">
	<e:adquery id="banner4" adId="220"/>
	<a id="220" rel="ad" target="_blank" href="<e:adlink name="banner4"/>"><img src="<e:adimg name="banner4"/>" width="972" height="130" /></a>	
    </div>
    
    
    <!-- three -->
    	<div class="three">
        			 <!-- thrleft left -->
    	<div class="thrleft">
        	<div class="title_new3">
        		<div class="more_new"><a href="${ctx}/information/events/index.action">更多>></a></div><h1><b>展会活动</b></h1>
				<div class="zanzhu">
					<s:iterator value="textAd" begin="15" end="19"> <a href="<s:property value="link_url"/>" title="<s:property value="name"/>" target="_blank"><s:property value="name"/></a></s:iterator>
				</div>         		
        	</div>
<e:query  id="imgEvents" sql="select a.id, a.title,a.content_txt, c.small_img_url from t_info a left join t_info_type b on a.info_type_id=b.id left join t_info_img c on c.info_id=a.id where b.type_no like '0007%' and a.status=2 and a.is_img_info=1 and c.is_main_img=1 order by a.id desc limit 10"/>        
            <div class="thrlefttab">
            <div class="thrl">
            	<a href="${ctx}/information/info/info!show.action?requestId=<s:property value='#request.imgEvents.get(0).id'/>" title="<s:property value='#request.imgEvents.get(0).title'/>" target="_blank"><img width="220" height="125" src="${ctx}/FileView?id=<s:property value="#request.imgEvents.get(0).small_img_url"/>" alt="<s:property value='#request.imgEvents.get(0).title'/>"  /></a>
               <b><a href="${ctx}/information/info/info!show.action?requestId=<s:property value='#request.imgEvents.get(0).id'/>" title="<s:property value="#request.imgEvents.get(0).title"/>" target="_blank"><s:if test="#request.imgEvents.get(0).title.length()>13"><s:property value="#request.imgEvents.get(0).title.substring(0,13)"/>...</s:if>
<s:else><s:property value="#request.imgEvents.get(0).title"/></s:else></a></b>
            </div>
            <div class="threer">
            		<div class="threerone">
                    	<h2><b><a href="${ctx}/information/info/info!show.action?requestId=<s:property value='#request.imgEvents.get(0).id'/>" title="<s:property value="#request.imgEvents.get(0).title"/>" target="_blank"><s:property value="#request.imgEvents.get(0).title"/></a></b></h2>
                          <p><s:if test="#request.imgEvents.get(0).content_txt.length()>50"><s:property value="#request.imgEvents.get(0).content_txt.substring(0,50)"/>...</s:if><s:else><s:property value="#request.imgEvents.get(0).content_txt"/></s:else></p>
                    </div>
 <e:query id="events" sql="select a.id, a.title from t_info a left join t_info_type b on a.info_type_id=b.id where b.type_no like '0007%' and a.status=2 and a.is_img_info=0 order by a.id desc limit 6"/>
                    <div class="threertwo">
                    	<ul class="onelist4">
							<s:iterator value="#request.events" status="st">
								<li <s:if test="#st.count%2==0">class="noright"</s:if>><a href="${ctx}/information/info/info!show.action?requestId=<s:property value='id'/>" title="<s:property value="title"/>" target="_blank"><s:property value="%{title.substring(0,11)}"/>...<s:if test="%{title.lenght()>12}"><s:property value="%{title.substring(0,12)}"/></s:if></a></li>
							</s:iterator>                            
                        </ul>
                    
                    </div>
            </div>
            
            <div class="cls"></div>
            <div class="threeflashone">
            		 <div class=scroll2>
                        <div id=arrLeft_02 class=arrLeft></div>
                       
           <div id=arrCont_02 class=arrCont>
				<ul>
<s:iterator value="#request.imgEvents" status="st">
<li><div class="liimg"><a href="${ctx}/information/info/info!show.action?requestId=<s:property value='id'/>" title="<s:property value="title"/>" target="_blank"><img src="${ctx}/FileView?id=<s:property value="small_img_url"/>" alt="<s:property value="title"/>" width="132" height="73"/></a><a href="${ctx}/information/info/info!show.action?requestId=<s:property value='id'/>" title="<s:property value="title"/>" target="_blank"><s:property value="title"/></a></div></li>
</s:iterator>
                </ul>
                </div>
               <div id=arrRright_02 class=arrRright></div></div>
               <div class="cls"></div>
                <script type=text/javascript>
                                          <!--//--><![CDATA[//><!--
                                          var focusScroll_02 = new ScrollPic();
                                          focusScroll_02.scrollContId	= "arrCont_02"; //内容容器ID
                                          focusScroll_02.arrLeftId	  = "arrLeft_02";//左箭头ID
                                          focusScroll_02.arrRightId	 = "arrRright_02"; //右箭头ID
                                          focusScroll_02.frameWidth	 = 592;//显示框宽度
                                          focusScroll_02.pageWidth	  = 148; //翻页宽度
                                          focusScroll_02.upright		= false; //垂直滚动
                                          focusScroll_02.speed		  = 20; //移动速度(单位毫秒，越小越快)
                                          focusScroll_02.space		  = 20; //每次移动像素(单位px，越大越快)
                                          focusScroll_02.autoPlay		= true; //自动播放
                                          focusScroll_02.autoPlayTime	= 5; //自动播放间隔时间(秒)
                                          focusScroll_02.initialize(); //初始化
                        
                                          //--><!]]>
                                    </script>
               
		
            </div>  
            </div>
            
            <div class="title_new3">
            	<div class="more_new"><a href="${ctx}/information/info/info-list.action?infoTypeId=53">更多>></a></div><h1><b>星力视界</b></h1>
				<div class="zanzhu">
					<s:iterator value="textAd" begin="20" end="24"> <a href="<s:property value="link_url"/>" title="<s:property value="name"/>" target="_blank"><s:property value="name"/></a></s:iterator>
				</div>              
            </div>
            <!-- twoleftflash  -->
            <div class="twoleftflash">
			 <div class=scroll>
                        <div id=arrLeft_03 class=arrLeft></div>
                       
			
<e:query id="xlsj" sql="select a.id, a.title, c.small_img_url from t_info a left join t_info_type b on a.info_type_id=b.id left join t_info_img c on c.info_id=a.id where b.type_no='0013' and a.status=2 and a.is_img_info=1 and c.is_main_img=1 order by a.id desc limit 16" />			
	
           <div id=arrCont_03 class=arrCont>
				<ul>
<s:iterator value="#request.xlsj" status="st">
<s:if test="#st.count%2==1 && #st.count>1"></li></s:if>
<s:if test="#st.count%2==1 "><li></s:if>
<div class="liimg">
<a href="${ctx}/information/show/info!show.action?requestId=<s:property value='id'/>" title="<s:property value="title"/>" target="_blank"><img src="${ctx}/FileView?id=<s:property value="small_img_url"/>" width="132" height="73" alt="<s:property value='title'/>" /></a>
<a href="${ctx}/information/show/info!show.action?requestId=<s:property value='id'/>" title="<s:property value="title"/>" target="_blank"><s:property value='title'/></a>
</div>
</s:iterator>				
                </ul>
                </div>
          
               <div id=arrRright_03 class=arrRright></div></div>
               <div class="cls"></div>
                <script language=javascript type=text/javascript>
                                          <!--//--><![CDATA[//><!--
                                          var focusScroll_03 = new ScrollPic();
                                          focusScroll_03.scrollContId	= "arrCont_03"; //内容容器ID
                                          focusScroll_03.arrLeftId	  = "arrLeft_03";//左箭头ID
                                          focusScroll_03.arrRightId	 = "arrRright_03"; //右箭头ID
                                          focusScroll_03.frameWidth	 = 592;//显示框宽度
                                          focusScroll_03.pageWidth	  = 148; //翻页宽度
                                          focusScroll_03.upright		= false; //垂直滚动
                                          focusScroll_03.speed		  = 20; //移动速度(单位毫秒，越小越快)
                                          focusScroll_03.space		  = 20; //每次移动像素(单位px，越大越快)
                                          focusScroll_03.autoPlay		= true; //自动播放
                                          focusScroll_03.autoPlayTime	= 5; //自动播放间隔时间(秒)
                                          focusScroll_03.initialize(); //初始化
                        
                                          //--><!]]>
                                    </script>
		
            </div><!-- twoleftflash over -->
            
        </div> 
        
        <div class="tworight">
        <!-- twortab -->
        	<div class="twortab">
            	 <div class="twotitle">
                 	<div class="more_two"><a href="${ctx}/information/hrservice/index.action">更多>></a></div>
                 	<h2>人才服务</h2>
                 </div>
                 
                 <div class="twotitlenav">
                 	<ul class="twonavlist">
                    	
                        <li class="hover" onmouseover="setTab('twot',1,3)" id="twot1"><a href="${ctx}/information/hrservice/info-list.action?infoTypeId=45">人才工作站</a></li>    
                        <li onmouseover="setTab('twot',2,3)" id="twot2"><a href="${ctx}/information/hrservice/jobs-list.action">企业招聘</a></li>    
                        <li onmouseover="setTab('twot',3,3)" id="twot3"><a href="${ctx}/information/hrservice/talent-list.action">星力人才库</a></li> 
                    
                    </ul>   
                 </div>
          
                 <div class="twotcon">
                 	<div id="con_twot_1">
                    	<ul class="twolist2">
					<s:iterator value="info45">
						<li><a href="${ctx}/information/info/info!show.action?requestId=${id}" target="_blank"><s:property value="getTitleByLength(14)" /></a></li>
					</s:iterator>									                       
                        </ul>
                    
                    </div>
                    
                    <div id="con_twot_2" class="hidden">
										<ul class="twolist2">
					<s:iterator value="jobs">
						<li><a href="<s:url namespace="/information/hrservice" action="jobs!show"/>?requestId=${id}" target="_blank"><s:property value="name"/></a></li>
					</s:iterator>					
					</ul>
										</div>
                    <div id="con_twot_3" class="hidden">
										<ul class="twolist2">
					<s:iterator value="talents">
						<li><s:property value="name" />  <s:property value="jobIntent"/>  <s:property value="workedAge"/>年</li>
					</s:iterator>		
					</ul>
										</div>
                 
                 
                 </div>
            </div><!-- twortab over -->
            
              <!-- twortab -->
        	<div class="twortab" style="margin-top:10px;">
            	 <div class="twotitle">
                 	<div class="more_two"><a href="${ctx}/information/survey/index.action" target="_blank">更多>></a></div>
                 	<h2 style="background:none">在线调查</h2>
                 </div>
              <div class="twoleft3con">
				<h1>
				<p class="f14 b red"><s:property value="survey.title"/></p>
				<p><s:property value="survey.contentTxt"/></p>
				</h1>
				<h2>
				<s:if test="survey.votes.size()>1">
				<s:iterator value="survey.votes" begin="0" end="0">
				<h2>
				<table width="100%" border="0" cellspacing="0">
				  <tr>
				    <td><strong><s:property value="title"/></strong></td>
				  </tr>
				  <s:iterator value="voteOptions">
				  <tr>
				    <td><input name="voteOptions<s:property value="vote.id"/>" type="radio" value="<s:property value="id"/>"/><s:property value="optionContent"/><br /></td>
				  </tr>
				  </s:iterator>
				</table>
				</h2>
				</s:iterator>
				</s:if>
				<s:else>
				<s:iterator value="survey.votes">
				<h2>
				<table width="100%" border="0" cellspacing="0">
				  <tr>
				    <td><strong><s:property value="title"/></strong></td>
				  </tr>
				  <s:iterator value="voteOptions">
				  <tr>
				    <td><input name="voteOptions<s:property value="vote.id"/>" type="radio" value="<s:property value="id"/>"/><s:property value="optionContent"/><br /></td>
				  </tr>
				  </s:iterator>
				</table>
				</h2>
				</s:iterator>
				</s:else>

				</h2>
				
				<div class="cls"></div>
				<div class="tijiao"><input id="submitBtn" name="submitBtn" type="button" value="" class="btntijiao" /> <input id="detailBtn" name="detailBtn" type="button"  value="" class="btnjieguo"/></div>	
			  </div>
            </div><!-- twortab over -->
            <div class="cls"></div>
            
            <div class="thrad">
	<e:adquery id="rad1" adId="221"/>
	<a id="221" rel="ad" target="_blank" href="<e:adlink name="rad1"/>"><img src="<e:adimg name="rad1"/>" width="264" height="178" /></a>	            
            </div>
            
        </div>
        
        
        </div>
				<!-- three over -->	
	
	<div class="cls"></div>

</div>

<div class="cls"></div>

<%-- copartnership start --%>
<s:action name="copartnership" namespace="/information/inc" executeResult="true">
<s:param name="infoTypeId">1</s:param>
</s:action>
<%-- copartnership end --%>

<%-- links begin --%>
<s:include value="/WEB-INF/content/information/inc/links.jsp"/>
<%-- links end --%>

<div class="cls"></div>

<%-- footer begin --%>
<s:include value="/WEB-INF/content/information/inc/footer.jsp"/>
<%-- footer end --%>
	
</body>
</html>
