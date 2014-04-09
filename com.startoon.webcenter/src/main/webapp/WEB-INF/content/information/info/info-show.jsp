<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="keywords" content="<s:property value="metaKeywords" escape="HTML" />"/>
<meta http-equiv="description" content="<s:property value="metaDescription" escape="HTML" />"/>
<title><s:property value="metaTitle" escape="HTML" /></title>

<link rel="stylesheet" type="text/css" href="${ctx}/information/css/style.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/information/css/common.css" />
<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>
<script src="${ctx}/information/js/nav.js" language="javascript"></script>
<script type="text/javascript" src="${ctx}/resources/js/formValidator.js"></script>

<script type="text/javascript">
function ajaxPagination(pageNo, pageSize) {
	var infoId = $(":hidden[name=infoId]").val();
	var url = "${ctx}/information/comments/comments-list.action";
	url += "?pager.pageNo=" + pageNo + "&infoId=" + infoId;
	$("#conMess0").load(url);
}
$(function() {
	$.formValidator.initConfig({formid:"commentForm",onerror:function(msg){alert(msg)},onsuccess:function(){return true;}});
 	$("#creator").formValidator({onshow:"",onfocus:"name can't empty",oncorrect:""}).inputValidator({min:1,max:100,onerror:"昵称不能为空，请填写你的昵称！"});
 	$("#content").formValidator({onshow:"",onfocus:"name can't empty",oncorrect:""}).inputValidator({min:1,max:1000,onerror:"评论内容不能为空！"});

	$("#conMess0").load("${ctx}/information/comments/comments-list.action", {infoId: <s:property value="info.id"/>});

	<s:if test="%{flag}">alert('您的评论正在审核中，待审核通过之后才显示！');</s:if>

	//资讯中心
	<s:if test="info.topInfoTypeId==2">
	$('li#l2').addClass('hover');
	$('h2#h2').show();
	</s:if>

	//高端访谈
	<s:if test="info.infoType.id==4">
	$('li#l4').addClass('hover');
	$('h2#h4').show();
	</s:if>

	// 星力观察家
	<s:if test="info.infoType.id==6">
	$('li#l6').addClass('hover');	
	</s:if>

	//展会报道
	<s:if test="info.infoType.id==27">
	$('li#l8').addClass('hover');
	$('h2#h8').show();
	</s:if>
	//国内展会预告
	<s:if test="info.infoType.id==28">
	$('li#l8').addClass('hover');
	$('h2#h8').show();
	</s:if>
	//国外展会预告
	<s:if test="info.infoType.id==29">
	$('li#l8').addClass('hover');
	$('h2#h8').show();
	</s:if>
	//模拟世界-技术
	<s:if test="infoType.id==35">
	$('li#l10').addClass('hover');
	$('h2#h10').show();
	</s:if>
	//模拟世界-市场
	<s:if test="infoType.id==36">
	$('li#l10').addClass('hover');
	$('h2#h10').show();
	</s:if>	
	//模拟世界-产品
	<s:if test="infoType.id==37">
	$('li#l10').addClass('hover');
	$('h2#h10').show();
	</s:if>	

	//产业合作-代理
	<s:if test="infoType.id==31">
	$('li#l9').addClass('hover');
	$('h2#h9').show();
	</s:if>
	//产业合作-合作
	<s:if test="infoType.id==32">
	$('li#l9').addClass('hover');
	$('h2#h9').show();
	</s:if>
	//产业合作-加盟
	<s:if test="infoType.id==33">
	$('li#l9').addClass('hover');
	$('h2#h9').show();
	</s:if>
	//产业合作-商机
	<s:if test="infoType.id==34">
	$('li#l9').addClass('hover');
	$('h2#h9').show();
	</s:if>
	//电子吧-机台评鉴
	<s:if test="infoType.id==38">
	$('li#l5').addClass('hover');
	</s:if>
	//电子吧-经验交流
	<s:if test="infoType.id==39">
	$('li#l5').addClass('hover');
	</s:if>
	//电子吧-疑难杂事
	<s:if test="infoType.id==40">
	$('li#l5').addClass('hover');
	</s:if>
	//电子吧-投诉吧
	<s:if test="infoType.id==41">
	$('li#l5').addClass('hover');
	</s:if>

	//行情调查-编辑推荐
	<s:if test="infoType.id==19">
	$('li#l3').addClass('hover');
	$('h2#h3').show();
	</s:if>
	//行情调查-人气排行
	<s:if test="infoType.id==20">
	$('li#l3').addClass('hover');
	$('h2#h3').show();
	</s:if>
	//行情调查-行情综述
	<s:if test="infoType.id==21">
	$('li#l3').addClass('hover');
	$('h2#h3').show();
	</s:if>

	<s:if test="infoType.id==45">
	//人才服务-人才工作站
	$('li#l11').addClass('hover');
	$('h2#h11').show();
	</s:if>
	
	<s:if test="infoType.id==46">
	//人才服务-教育培训
	$('li#l11').addClass('hover');
	$('h2#h11').show();
	</s:if>

	<s:if test="infoType.id==7">
	//创意SHOW-创意资讯
	$('li#l7').addClass('hover');
	$('h2#h7').show();
	</s:if>
	<s:if test="infoType.id==23">
	//创意SHOW-团体
	$('li#l7').addClass('hover');
	$('h2#h7').show();
	</s:if>
	
	<s:if test="infoType.id==24">
	//创意SHOW-个人
	$('li#l7').addClass('hover');
	$('h2#h7').show();
	</s:if>
	
	<s:if test="infoType.id==25">
	//创意SHOW-动画
	$('li#l7').addClass('hover');
	$('h2#h7').show();
	</s:if>

	<s:if test="infoType.id==26">
	//创意SHOW-漫画
	$('li#l7').addClass('hover');
	$('h2#h7').show();
	</s:if>

	$('a[rel=ad]').click(function() {
		var id = $(this).attr('id');
		$.post('${ctx}/information/advertisement/click.action', {'id':id});
	});
});
</script>

</head>

<body>
<script type="text/javascript" src="http://v2.jiathis.com/code/jiathis_r.js?btn=r4.gif" charset="utf-8"></script>
<div id="wrap">
<s:include value="/WEB-INF/content/information/inc/header.jsp"/>

<%-- main begin --%>
<div class="main">
	<div class="left">
		<div class="blueBorder">
			<div class="titleCartoon"><s:property value="info.infoType.name"/></div>
			<div class="newsDetail">
				<p class="titleNewsDetail"><s:property value="info.title"/></p>
				<p class="subNews"><span>来源：<s:property value="info.source"/></span><span>录入：<s:property value="info.creator.account"/></span><span><s:date name="infoTime" format="yyyy-MM-dd"/></span></p>
				<p class="relNews">
					<span class="fr">
					下一篇：<a href="${ctx}/information/info/info!show.action?requestId=${nextInfo.id}" ><s:property value="nextInfo.title"/></a>
					</span>
					上一篇：<a href="${ctx}/information/info/info!show.action?requestId=${preInfo.id}"><s:property value="preInfo.title"/></a>
				</p>
				<div class="cls"></div>
				<div class="dumascroll">
				  <p align="left"><s:property value="info.content" escape="HTML"/></p>
				</div>
			</div>
		</div>
		
		<div class="messageZone">
			<div class="titleMessage">
				<span class="fr">
				已有<span class="red"><s:property value="info.comments" /></span>条评论
				<!-- ，共<span class="red">1139</span>人参与，点击查看<a href="#">全部留言</a> -->
				</span>
				<span class="tabMessage"><a href="javascript:choose('tabMess','conMess',0,2);" id="tabMess0" class="lsve">评论区</a><a href="javascript:choose('tabMess','conMess',1,2);" id="tabMess1" >我要留言</a></span></div>
			<div class="cls"></div>
			<div class="conMessage">
				<div class="hover" id="conMess0"></div>
				<s:include value="/WEB-INF/content/information/comments/comments-input.jsp"></s:include>
			</div>
		</div>
		
	</div>
	
	<div class="right">
	<s:include value="/WEB-INF/content/information/inc/right-ad1.jsp"/>
	<s:action name="info-hot" namespace="/information/inc" executeResult="true"/>
	<s:include value="/WEB-INF/content/information/inc/right-ad2.jsp"/>
	<s:action name="info-recommend" namespace="/information/inc" executeResult="true"/>
	<s:include value="/WEB-INF/content/information/inc/right-ad3.jsp"/>
	</div>
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