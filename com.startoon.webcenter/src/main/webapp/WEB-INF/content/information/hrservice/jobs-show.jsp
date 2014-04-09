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
<link href="${ctx}/information/css/scroll.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>
<script src="${ctx}/information/js/nav.js" language="javascript"></script>
<script src="${ctx}/information/js/scroll.js" language="javascript"></script>

<script type="text/javascript"> 
$(document).ready(function(){
	$('li#l11').addClass('hover');
	$('h2#h11').show();

	$('#apply').click(function() {
		<s:if test="#session.enterprise_user!=null">
		$.post("${ctx}/information/member/hrservice/apply.action", 
				{jobId:'<s:property value='jobs.id'/>'}, 
				function(data) {
					if(data.result==0) {
						alert('已经成功应聘该职位，请耐心等候该企业的通知！');
					} else if(data==2){
						alert('你还没有填写在线简历，请填写简历后再来应聘该职位！');
					} else {
						alert('应聘该职位失败！\n请确认是否已经登录！');
					}
				}
		);
		</s:if>
		<s:else>alert('请登录后再应聘该职位！');</s:else>
	});
	
	

	$('input#scBtn').click(function() {
		$.post("${ctx}/information/member/jobfavorite/job-favorite!add.action", 
			{"jid": "<s:property value='jobs.id'/>"}, 
			function(data) {
				if(data.result==0) {
					alert('收藏该职位成功！');
				} else if(data.result==1) {
					alert('该职位已经收藏！');
				} else if(data.result==2) { 
					alert('请登录后再收藏！');
				} else {
					alert('收藏失败！');
				}
		});
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
	<div class="left blueBorder">
		<div class="titleCartoon">企业招聘</div>
		<div class="jobDetailTop">
		<div class="jobDetailBottom">
		<div class="jobDetail">
			<p><span class="orange f16 b mr10"><s:property value="name"/></span>招聘人数： <s:property value="num"/>  企业名称：<a href="${ctx}/enterprises/ent-hr.action?enterpriseId=${enterprise.id}" target="_blank"><s:property value="enterprise.name"/></a></p>
			<table width="100%" border="0" class="tableJobDetail">
			  <tbody>
			  <tr>
				<td class="hsbg">发布日期：</td>
				<td><s:date name="createTime" format="yyyy-MM-dd"/> </td>
				<td class="hsbg">工作地点：</td>
				<td><s:property value="workAddress"/></td>
			  </tr>
			  <tr>
				<td class="hsbg">工作年限：</td>
				<td><s:property value="workedAge"/>年</td>
				<td class="hsbg">学 历：</td>
				<td><s:property value="certificate"/></td>
			  </tr>
			  <tr>
				<td class="hsbg" align="right">职能：</td>
				<td colspan="3" align="left"><s:property value="jobFun"/></td>
			  </tr>
			</tbody>
			</table>
			<pre><s:property escape="HTML" value="description"/></pre>
			<p class="tr"><input type="button" class="btnSubmit" value="我要收藏" id="scBtn"/><input type="button" class="btnSubmit" value="我要应聘" id="apply"/></p>
		</div>
		</div>
		</div>
		
		<div class="companyBox">
			<p class="titleCompany">企业介绍  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <a target="_blank" href="${ctx}/enterprises/ent-index.action?enterpriseId=${enterprise.id}"><font style="font-style: normal; font-size: 10" ><s:property value="enterprise.name"/></font></a></p>
			<div class="dumascroll">
			<s:property escape="HTML" value="enterprise.entInfo.indexContent"/>
			</div>
		</div>
		
	</div>
	
	<div class="right">
	
	<div class="rban1" id="otherJob">
	<div class="title3"><div class="nt2">其他职位</div></div>
	<div class="zxnews">
	<ul class="zxnewslist">
	<s:iterator value="otherJobs">
	<li><a href="${ctx}/information/hrservice/jobs!show.action?requestId=<s:property value='id'/>"><s:property value='name'/></a></li>
	</s:iterator>
	</ul>
	</div>	
	
	<e:adquery id="rad1" adId="166"/>
	<div class="rban1">
	<a id="166" rel="ad" target="_blank" href="<e:adlink name="rad1"/>"><img src="<e:adimg name="rad1"/>" width="242" height="140"/></a>
	</div>
	
	<div class="title3"><div class="nt2">相关职位</div></div>
	<div class="zxnews">
	<ul class="zxnewslist">
	<s:iterator value="relateJobs">
	<li><a href="${ctx}/information/hrservice/jobs!show.action?requestId=<s:property value='id'/>"><s:property value='name'/></a></li>
	</s:iterator>
	</ul>
	</div>	
	
	<e:adquery id="rad2" adId="167"/>
	<div class="rban1">
	<a id="167" rel="ad" target="_blank" href="<e:adlink name="rad2"/>"><img src="<e:adimg name="rad2"/>" width="242" height="140"/></a>
	</div>
	
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
