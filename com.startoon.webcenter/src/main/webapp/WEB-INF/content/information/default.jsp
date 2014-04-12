<%@page import="org.j2eeframework.startoon.entity.HotKey"%>
<%@page import="java.util.List"%>
<%@page import="org.j2eeframework.commons.util.SystemContext"%>
<%@page import="org.j2eeframework.startoon.service.HotKeyService"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>

<%request.setAttribute("ctx", request.getContextPath());%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="keywords" content="中国游艺网—星力网，游戏机供应，游戏机采购，动漫游戏资讯，动漫游戏展会，电子游戏机，电子游戏机价格，电子游戏机厂商，游戏机配件"/>
<meta http-equiv="description" content="中国游艺网—星力网是广州力凯信息科技打造的动漫游戏行业最专业的游戏机供应、游戏机采购平台，提供最新、最全的游艺产品、电子游戏机产品、电玩产品、游戏机配件、电脑板、框体机、模拟机等供应信息、采购信息，中国游艺网资讯频道提供最专业的动漫游戏行业资讯、行业新闻。"/>
<title>中国游艺网_星力网_中国动漫游艺门户_动漫游戏产品网络交易平台_动漫游戏行业资讯_电子游戏机供应_电子游戏机采购_电子游戏机价格_电子游戏机厂商_电子游戏机配件</title>

<link rel="stylesheet" type="text/css" href="${ctx}/information/theme0/style.css"/>
<script type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="${ctx}/information/js/common.js"></script>

<link rel="stylesheet" type="text/css" href="${ctx}/resources/jquery-slider/css/basic-jquery-slider.css"/>
<script src="${ctx}/resources/jquery-slider/js/basic-jquery-slider.js"></script>

<style type="text/css">
span .title {
width:8em;
overflow:hidden;
text-overflow:ellipsis;
white-space:nowrap;
word-break:keep-all;
}
</style>
<script type="text/javascript">
$(function() {
	$('#loginBtn').click(function() {
		var rd = $(':radio[name="userType"]:checked');
		var uid = $('input[name=userId]').val();
		var pwd = $('input[name=password]').val();
		var ut = $(':radio[name="userType"]:checked').val();
		if($.trim(uid)=='') {
			alert('登录名不能为空，请输入登录名！');
			return false;
		}
		if($.trim(pwd)=='') {
			alert('密码不能为空，请输入密码！');
			return false;
		}
		if(rd.length==0) {
			alert('请选择用户类型！');
			return false;
		}
		
		$.post('${ctx}/information/login.action', {'userId': uid, 'password': pwd, 'userType':ut}, function(data) { if(data=='success'){ alert('登录成功！'); location.reload();} else {alert(data);}});
	});
	$('#register').click(function() {
		window.location = '${ctx}/register.jsp';
	});	
	
	// 人才服务
	$('ul.mtop10px').find('a').mouseover(function(){
		$('ul.mtop10px').find('a').each(function(index) {
			$(this).removeClass('active');
		});
		
		$(this).addClass('active');
		var id = $(this).attr('id');
		switch(id) {
			case 'tab1':  $('ul[rel=hr]').hide();$('ul#hrCtx1').show(); 
			break;
			case 'tab2':  $('ul[rel=hr]').hide();$('ul#hrCtx2').show();
			break;
			case 'tab3':  $('ul[rel=hr]').hide();$('ul#hrCtx3').show();
			break;
		}
	});
	
	// 店长吧
	$('ul[rel=bar]').find('a').mouseover(function(){
		$('ul[rel=bar]').find('a').each(function(index) {
			$(this).removeClass('active');
		});
		
		$(this).addClass('active');
		var id = $(this).attr('id');
		switch(id) {
			case 'barTab1':  $('ul[rel=barItems]').hide();$('ul#barItems1').show(); 
			break;
			case 'barTab2':  $('ul[rel=barItems]').hide();$('ul#barItems2').show();
			break;
			case 'barTab3':  $('ul[rel=barItems]').hide();$('ul#barItems3').show();
			break;
		}
	});
	
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

	$("#slide").bjqs({
		'height' : 286,
		'width' : 516,
		'animation' : 'slide',
		'nextText': '',
		'prevText': '',
		'animationDuration' : 200,
		'centerMarkers' : false,
		'centerControls' :false,
		'useCaptions' : true,
		'keyboardNav' : true
	});

	$('a#search').click(function() {
		var k = $(this).attr('rel');
		$('input[name=q]').val(k);
		$('form#searchForm').submit();
	});

	$('a[rel=ad]').click(function() {
		var id = $(this).attr('id');
		$.post('${ctx}/information/advertisement/click.action', {'id':id});
	});
});
</script>
</head>

<body>

<div class="wrapper">
	<div class="header">
    	<div class="top_bar">
        	<div class="top_link"><a href="${ctx}/information/index.action">资讯首页</a>&nbsp;&nbsp;<a href="${ctx}/index.action">B2B首页</a>&nbsp;&nbsp;<a href="${ctx}/information/attachment/index.action">资料下载</a></div>
            <div class="login">
				<s:if test="#session.enterprise_user!=null">
			    <label for="userId">您好， <s:property value="#session.enterprise_user.nickname"/>，欢迎来到星力网！进入
			    	<s:if test="#session.enterprise_user.userType==1">
			    	<a href="${ctx}/enterprise/enterprise/enterprise!info.action?entId=${enterprise_user.id}">会员中心</a>
			    	</s:if>
			    	<s:else>
			    	<a href="${ctx}/member/base/base-info!edit.action">会员中心</a>
			    	</s:else>
			    	，或者点击<a href="${ctx}/ent-logout.action">退出</a>。</label>
			  	</s:if>
			  	<s:else>
            	<label for="userId">帐号</label><input name="userId" type="text" class="input_txt"><label for="password">密码</label><input name="password" type="password" class="input_txt"><input type="radio" name="userType" id="userType0" value="0"><label for="userType0">个人</label><input type="radio" name="userType" id="userType1" value="1"><label for="userType1">企业</label><input id="loginBtn" name="loginBtn" type="button" value="登录"><input name="register" id="register" type="button" value="注册">
			  	</s:else>
            </div>
        </div>
        <div class="top_box">
        	<a href="${ctx}/index.html" title="星力网 首页"><h1 class="logo"><span class="hide">星力网</span></h1></a>
            <div class="search_box">
            	<div class="search_input_box">
           			<s:form id="searchForm" namespace="/information/search" action="info-list" target="_blank">
                    <label for="q" class="label_search">搜索</label>
                    <input name="q" type="text" class="input_search">
                    <input type="submit" value="" class="btn_search">
					</s:form>
                </div>
                <div class="hot_search_box">
                    <span class="hot_search_txt">热门关键字</span>
                    <span class="hot_search_keywords">
					<%
					HotKeyService hotKeyService = SystemContext.getApplicationContext().getBean(HotKeyService.class);
					List<HotKey> hotKeies = hotKeyService.getHotKey(4, 1);
					int i = 0;
					%>                    
					<% for(HotKey key : hotKeies) {
						String k = key.getName();
					%>
						<a target="_blank" id="search" href="javascript:void(0)" rel="<%=k %>"><%=k %></a>
					<% } %>
					</span>
                </div>
            </div>
            <div class="top_menu">
            	<a href="${ctx }/information/info/index.action" class="btn_news" target="_blank"><span class="hide">资讯中心</span></a>
				<a href="${ctx}/information/hightvisit/index.action" class="btn_interview" target="_blank"><span class="hide">访谈观察</span></a>
				<a href="${ctx}/information/bar/index.action" class="btn_storebar" target="_blank"><span class="hide">店长吧</span></a>
				<a href="${ctx}/information/show/index.action" class="btn_creative" target="_blank"><span class="hide">创意SHow</span></a>
				<a href="${ctx}/information/events/index.action" class="btn_exhibition" target="_blank"><span class="hide">展会活动</span></a>
				<a href="${ctx}/information/hrservice/index.action" class="btn_jobs" target="_blank"><span class="hide">人才服务</span></a>
            </div>
        </div>
    </div><!-- end header -->

    <div class="main">
    	<div class="part_one">
   	  <div class="sub_menu">
            	<div class="sm_news">
                	<div class="news_icon"></div>
                	<ul class="sm1">
                    	<li><a target="_blank" href="${ctx}/information/info/info-list.action?infoTypeId=13">行业</a></li>
                        <li><a target="_blank" href="${ctx}/information/info/info-list.action?infoTypeId=14">政策</a></li>
                        <li><a target="_blank" href="${ctx}/information/info/info-list.action?infoTypeId=15">市场</a></li>
                    </ul>
                    <ul class="sm2">
                    	<li><a target="_blank" href="${ctx}/information/info/info-list.action?infoTypeId=16">产品</a></li>
                        <li><a target="_blank" href="${ctx}/information/subject/index.action">专题</a></li>
                        <li><a target="_blank" href="${ctx}/information/info/info-list-img.action?infoTypeId=18">图片</a></li>
                    </ul>
                </div>
                
            	<div class="sm_interview">
                	<div class="interview_icon"></div>
                	<ul class="sm3">
                    	<li><a target="_blank" href="${ctx}/information/hightvisit/index.action">高端访谈</a></li>
                        <li><a target="_blank" href="${ctx}/information/observe/index.action">星力观察家</a></li>
                    </ul>
                </div>
                
            	<div class="sm_storebar">
                	<div class="storebar_icon"></div>
                	<ul class="sm3">
                    	<li><a target="_blank" href="${ctx}/information/bar/info-list.action?infoTypeId=38">机台评鉴</a></li>
                        <li><a target="_blank" href="${ctx}/information/bar/info-list.action?infoTypeId=39">经验交流</a></li>
                    </ul>
                </div>
                
            	<div class="sm_creative">
                	<div class="creative_icon"></div>
                	<ul class="sm1">
                    	<li><a target="_blank" href="${ctx}/information/show/info-list.action?infoTypeId=23">团体</a></li>
                        <li><a target="_blank" href="${ctx}/information/show/info-list.action?infoTypeId=24">个人</a></li>
                    </ul>
                    <ul class="sm2">
                    	<li><a target="_blank" href="${ctx}/information/video/info-list.action?infoTypeId=25">动漫</a></li>
                        <li><a target="_blank" href="${ctx}/information/show/info-list.action?infoTypeId=26">漫画</a></li>
                    </ul>
                </div>

            	<div class="sm_exhibition">
                	<div class="exhibition_icon"></div>
                	<ul class="sm1">
                    	<li><a target="_blank" href="${ctx}/information/events/info-list.action?infoTypeId=27">报道</a></li>
                        <li><a target="_blank" href="${ctx}/information/events/info-list.action?infoTypeId=289">预告</a></li>
                    </ul>
                    <ul class="sm2">
                    	<li><a target="_blank" href="${ctx}/information/events/info-list.action?infoTypeId=30">图集</a></li>
                    </ul>
                </div>

            	<div class="sm_jobs">
                	<div class="jobs_icon"></div>
                	<ul class="sm3">
                    	<li><a target="_blank" href="${ctx}/information/hrservice/jobs-list.action">企业招聘</a></li>
                        <li><a target="_blank" href="${ctx}/information/hrservice/talent-list.action">星力人才库</a></li>
                    </ul>
                </div>
            </div><!-- end sub_menu -->

		  <div class="headline_slide">
			<div id="slide">
			<ul class="bjqs">
              <s:iterator value="imgInfos">
	          <li><a href="${ctx}/information/info/info!show.action?requestId=${id}" target="_blank"><img title="${title}" src="${ctx}/FileView?id=<s:property value="mainImg.imgUrl"/>" width="516" height="286" /></a></li>
              </s:iterator>
			</ul>
			</div>
          </div>

          <div class="headline_list">
              <ul>
              <s:iterator value="focus">
              <li class="imgInfo"><a href="${ctx}/information/info/info!show.action?requestId=${id}" target="_blank"><img src="${ctx}/FileView?id=<s:property value="mainImg.imgUrl"/>" width="64" height="46"/><span><s:if test="title!=null&&title.length()>25"><s:property value="title.substring(0,25)"/>...</s:if><s:else><s:property value='title'/></s:else></span></a></li>
              </s:iterator>
              </ul>
          </div>

        </div><!-- end part_one -->
        <div class="part_two">
        	<e:adquery id="ad1" adId="221"/>
        	<div class="left_box"><a id="221" rel="ad" target="_blank" href="<e:adlink name="ad1"/>"><img src="<e:adimg name="ad1"/>" width="210" height="187" /></a></div>
            <div class="middle_box">
            <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="510" height="187">
				<param name="quality" value="high">
				<embed src="${ctx}/information/images/360.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="510" height="187">
			</object>
            </div>
        	<e:adquery id="ad2" adId="222"/>
            <div class="right_box"><a id="222" rel="ad" target="_blank" href="<e:adlink name="ad2"/>"><img src="<e:adimg name="ad2"/>" width="210" height="187" /></a></div>
        </div><!-- end part_two -->
    	<div class="part_three">
       	  <div class="left_box">
			<e:adquery id="ad3" adId="223"/>
			<e:adquery id="ad4" adId="224"/>
				<h1 class="title_two_dimension_code"><span class="hide">星力视界<a href="#" class="more">more</a></span></h1>
              <div style="height:175px;"><a id="223" rel="ad" target="_blank" href="<e:adlink name="ad3"/>"><img src="<e:adimg name="ad3"/>" width="210" height="175" /></a></div>
              <div style="height:175px;"><a id="224" rel="ad" target="_blank" href="<e:adlink name="ad4"/>"><img src="<e:adimg name="ad4"/>" width="210" height="175" /></a></div>
              <h1 class="title_online_poll"><span class="hide">在线调查</span><a target="_blank" href="${ctx}/information/survey/index.action" class="more" style="bottom:10px;">more</a></h1>
              <div class="bg_online_poll">
                <h3><s:property value="survey.title"/></h3>
                <p><s:property value="survey.contentTxt"/></p>
				<s:iterator value="survey.votes">
                <p class="question"><s:property value="title" escape="html"/></p>
                <ul class="online_poll_form">
                	<s:iterator value="voteOptions">
                    <li><input type="radio" name="voteOptions<s:property value="vote.id"/>" value="<s:property value="id"/>" /><label for="1"><s:property value="optionContent"/></label></li>
                    </s:iterator>
                </ul>				
				</s:iterator>
              </div>
              <div class="online_poll_submit">
                <input id="submitBtn" name="submitBtn" type="button" value="提交调查" class="btn_poll" >
                <input id="detailBtn" name="detailBtn" type="button" value="查看结果" class="btn_poll" >
              </div>
          </div>
          <div class="main_box">
          	<div class="main_box_list">
            	<h1 class="title_interview"><span class="hide">访谈观察</span><a target="_blank" href="${ctx}/information/hightvisit/index.action" class="more">more</a></h1>
                <ul class="list">
                	<e:query id="ft" sql="select a.id, a.title, info_time from t_info a where a.info_type_id=4 and a.status=2 and a.hot=0 order by a.id desc limit 4" />
                	<s:iterator value="#request.ft">
                	<li><a href="${ctx}/information/info/info!show.action?requestId=<s:property value="id"/>" title="<s:property value="title"/>" target="_blank"><s:if test="title.length()>20"><s:property value='title.substring(0,18)'/>...</s:if><s:else><s:property value='title'/></s:else></a><span class="date"><s:date name="info_time" format="yyyy-MM-dd"/></span></li>
                	</s:iterator>
                </ul>
            </div>
            <div class="main_box_list mleft15">
                <h1 class="title_trade"><span class="hide">商讯</span><a target="_blank" href="${ctx}/information/info/info-list.action?infoTypeId=54" class="more">more</a></h1>
                <ul class="list">
                	<e:query id="gc" sql="select a.id, a.title, info_time from t_info a where a.info_type_id=54 and a.status=2 order by a.id desc limit 4" />
                	<s:iterator value="#request.gc">
                	<li><a href="${ctx}/information/info/info!show.action?requestId=${id}" title="${title}" target="_blank"><s:if test="title.length()>20"><s:property value='title.substring(0,18)'/>...</s:if><s:else><s:property value='title'/></s:else></a><span class="date"><s:date name="info_time" format="yyyy-MM-dd"/></span></li>
                	</s:iterator>
                </ul>
            </div>

            <e:adquery id="ad5" adId="225"/>
            <div class="ad_735_50"><a id="225" rel="ad" target="_blank" href="<e:adlink name="ad5"/>"><img src="<e:adimg name="ad5"/>" width="735" height="110" /></a></div>

            <div class="main_box_list">
            	<ul class="tabs" rel="bar">
            		<li><a target="_blank" href="${ctx}/information/bar/index.action" class="active" id="barTab1">最新话题</a></li>
            		<li><a target="_blank" href="${ctx}/information/bar/index.action"  id="barTab2">置顶话题</a></li>
            		<li><a target="_blank" href="${ctx}/information/bar/index.action" id="barTab3">热帖排行</a></li>
            	</ul>
                <div id="tabs1">
                <ul class="list" id="barItems1" rel="barItems">
					<s:iterator value="barLatestInfos">
                	<li><a href="${ctx}/information/info/info!show.action?requestId=${id}" target="_blank" ><s:if test="title.length()>20"><s:property value='title.substring(0,18)'/>...</s:if><s:else><s:property value='title'/></s:else></a><span class="date"><s:date name="createTime" format="yyyy-MM-dd" /></span></li>
					</s:iterator>               
                </ul>
                <ul class="list" id="barItems2" style="display: none" rel="barItems">
					<s:iterator value="barTopInfos">
                	<li><a href="${ctx}/information/info/info!show.action?requestId=<s:property value='id'/>" target="_blank" ><s:if test="title.length()>20"><s:property value='title.substring(0,18)'/>...</s:if><s:else><s:property value='title'/></s:else></a><span class="date"><s:date name="createTime" format="yyyy-MM-dd" /></span></li>
					</s:iterator>               
                </ul>
                <ul class="list" id="barItems3" style="display: none" rel="barItems">
					<e:query id="barHotInfos" sql="select a.id, a.title, a.create_time, a.creator_name from t_info a left join t_info_type b on a.info_type_id=b.id  where b.type_no like '0004%' and a.status=2 and a.hot=1 order by a.id desc limit 4" />                
					<s:iterator value="#request.barHotInfos">
                	<li><a href="${ctx}/information/info/info!show.action?requestId=<s:property value='id'/>" target="_blank" ><s:if test="title.length()>20"><s:property value='title.substring(0,18)'/>...</s:if><s:else><s:property value='title'/></s:else></a><span class="date"><s:date name="create_time" format="yyyy-MM-dd" /></span></li>
					</s:iterator>               
                </ul>
                </div>
            	<ul class="tabs mtop10px">
            		<li><a target="_blank" href="${ctx}/information/hrservice/info-list.action?infoTypeId=45" class="active" id="tab1">人才工作站</a></li>
            		<li><a target="_blank" href="${ctx}/information/hrservice/jobs-list.action" id="tab2">企业招聘</a></li>
            		<li><a target="_blank" href="${ctx}/information/hrservice/talent-list.action" id="tab3">星力人才库</a></li>
            	</ul>
                <div>
                <ul class="list" rel="hr" id="hrCtx1">
					<s:iterator value="info45">
						<li><a href="${ctx}/information/info/info!show.action?requestId=${id}" target="_blank"><s:property value="getTitleByLength(18)" /></a><span class="date"><s:date name="infoTime" format="yyyy-MM-dd" /></span></li>
					</s:iterator>                	
                </ul>
                <ul class="list" style="display: none" rel="hr" id="hrCtx2">
					<s:iterator value="jobs">
						<li><a href="<s:url namespace="/information/hrservice" action="jobs!show"/>?requestId=${id}" target="_blank"><s:property value="name" /></a><span class="date"><s:date name="createTime" format="yyyy-MM-dd" /></span></li>
					</s:iterator>                   	
                </ul>
                <ul class="list" style="display: none" rel="hr" id="hrCtx3">
					<s:iterator value="talents">
						<li><s:property value="name" />  <s:property value="jobIntent"/>  <s:property value="workedAge"/>年</li>
					</s:iterator>                   	
                </ul>
                </div>
            </div><!-- end main_box_list -->
            
            <div class="main_box_list mleft15">
            	<div class="exhibition_box">
            		<h1 class="title_exhibition"><span class="hide">展会活动</span><a target="_blank" href="${ctx}/information/events/index.action" class="more" style="margin-right:5px;">more</a></h1>
                    <ul class="list">
						<e:query id="events" sql="select a.id, a.title, a.info_time from t_info a left join t_info_type b on a.info_type_id=b.id where b.type_no like '0007%' and a.status=2 and a.is_img_info=0 order by a.id desc limit 4"/>
						<s:iterator value="#request.events">
						<li><a href="${ctx}/information/info/info!show.action?requestId=${id}" target="_blank"><s:if test="title.length()>20"><s:property value='title.substring(0,18)'/>...</s:if><s:else><s:property value='title'/></s:else></a><span class="date"><s:date name="info_time" format="yyyy-MM-dd" /></span></li>
						</s:iterator>  						                    
                    </ul>
                    <div class="pic_slide">
                    	<e:query  id="imgEvents" sql="select a.id, a.title,a.content_txt, c.small_img_url from t_info a left join t_info_type b on a.info_type_id=b.id left join t_info_img c on c.info_id=a.id where b.type_no like '0007%' and a.status=2 and a.is_img_info=1 and c.is_main_img=1 order by a.id desc limit 3"/>
                    	<s:iterator value="#request.imgEvents">
                    	<div class="bg_pic"><a href="${ctx}/information/info/info!show.action?requestId=<s:property value='id'/>" target="_blank"><img src="${ctx}/FileView?id=<s:property value='small_img_url'/>" width="100" height="70" /><span><s:if test="title!=null&&title.length()>8"><s:property value="title.substring(0,8)"/></s:if><s:else><s:property value='title'/></s:else></span></a></div>
                    	</s:iterator>
                    </div>
                </div>
            </div><!-- end main_box_list -->
			<e:adquery id="ad6" adId="226"/>
            <div class="ad_735_50"><a id="226" rel="ad" target="_blank" href="<e:adlink name="ad6"/>"><img src="<e:adimg name="ad6"/>" width="735" height="110" /></a></div>
            
            <h1 class="title_creative"><span class="hide">创意Show</span><a target="_blank" href="${ctx}/information/show/index.action" class="more">more</a></h1>
            <div class="creative_box">
                <span class="slide_to_left" id="arrLeft_01"><img src="theme0/btn_slide_to_left.png" width="11" height="61" /></span>
                <div class="pic_slide_big" id="showImgs">
					<s:iterator value="showInfos" >
					<div class="bg_pic" style="height: 100px;">
						<a href="${ctx}/information/show/info!show.action?requestId=${id}" title="<s:property value='title'/>" alt="<s:property value='title'/>" target="_blank"><img src="${ctx}/FileView?id=<s:property value="mainImg.smallImgUrl"/>" width="100" height="70" /></a>
						<span class="title"><a href="${ctx}/information/show/info!show.action?requestId=${id}" title="<s:property value='title'/>" target="_blank"><s:if test="title!=null && title.length()>8"><s:property value='title.substring(0,7)'/>...</s:if><s:else><s:property value='title'/></s:else></a></span>
					</div>
					</s:iterator>
              	</div>
                <span class="slide_to_right" id="arrRright_01"><img src="theme0/btn_slide_to_right.png" width="11" height="61" /></span>
            </div>
          </div>
          <!-- end main_box -->
        </div><!-- end part_three -->
    </div><!-- end main -->
    <div class="footer">
		<div class="links">
        	<h1 class="title_links"><span class="hide">友情链接</span><a href="${ctx}/information/link/link-list.action" target="_blank" class="more">more</a></h1>
            <ul>
            <s:iterator value="links">
            <li><a href="<s:property value='url'/>" target="_blank"><s:property value='name'/></a></li>
            </s:iterator>
            </ul>
        </div>
      <div class="logos">
       	<h1 class="title_logos"><span class="hide">合作单位</span><a href="${ctx}/information/copartnership/copartnership-list.action?infoTypeId=1" target="_blank" class="more">more</a></h1>
          <ul>
          <s:iterator value="copartnerships">
          <li><a href="<s:property value='siteUrl'/>" target="_blank"><img src="<s:property value='smallLogo'/>" width="88" height="33" /><span class="hide"><s:property value="name"/></span></a></li>
          </s:iterator>
          </ul>
        </div>
        <div class="copyright">
        	<ul>
            	<li><a href="<s:url namespace="/news" action="news!show"/>?requestId=2" target="_blank">企业推广</a></li>
                <li>&nbsp;| <a href="<s:url namespace="/news" action="news!show"/>?requestId=4" target="_blank">代理加盟</a></li>
                <li>&nbsp;| <a href="<s:url namespace="/news" action="news!show"/>?requestId=5" target="_blank">关于我们</a></li>
                <li>&nbsp;| <a href="<s:url namespace="/news" action="news!show"/>?requestId=6" target="_blank">站点地图</a></li>
                <li>&nbsp;| <a href="<s:url namespace="/help" action="help"/>" target="_blank">帮助中心</a></li>
            </ul>
<script src="http://s19.cnzz.com/stat.php?id=2876482&web_id=2876482" language="JavaScript"></script>
<script src="http://s19.cnzz.com/stat.php?id=2876482&web_id=2876482&show=pic" language="JavaScript"></script>
            <span class="copyright_txt">广州力凯信息科技有限公司 版权所有 粤ICP备10238157号-1</span>
        </div>
    </div><!-- end footer -->
</div>
<script type="text/javascript">
	  <!--//--><![CDATA[//><!--
	  var focusScroll_01 = new ScrollPic();
	  focusScroll_01.scrollContId	= "showImgs"; //内容容器ID
	  focusScroll_01.arrLeftId	  = "arrLeft_01";//左箭头ID
	  focusScroll_01.arrRightId	 = "arrRright_01"; //右箭头ID
	  focusScroll_01.frameWidth	 = 685;//显示框宽度
	  focusScroll_01.pageWidth	  = 114; //翻页宽度
	  focusScroll_01.upright		= false; //垂直滚动
	  focusScroll_01.speed		  = 20; //移动速度(单位毫秒，越小越快)
	  focusScroll_01.space		  = 20; //每次移动像素(单位px，越大越快)
	  focusScroll_01.autoPlay		= true; //自动播放
	  focusScroll_01.autoPlayTime	= 5; //自动播放间隔时间(秒)
	  focusScroll_01.initialize(); //初始化
	  //--><!]]>
</script>
<script type="text/javascript">
$(function() {
	// $('div.middle_box').load('${ctx}/WEB-INF/content/information/360.jsp');
});
</script>
</body>
</html>
