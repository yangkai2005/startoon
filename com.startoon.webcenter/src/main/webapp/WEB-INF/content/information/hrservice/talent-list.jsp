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
<script type="text/javascript" src="${ctx}/resources/js/jquery.example.min.js"></script>

<script type="text/javascript"> 
$(document).ready(function() {
	$('li#l11').addClass('hover');
	$('h2#h11').show();

	$('#searchKey').example('请输入求职关键词');
	$('input[name=address]').example('请输入工作关键词');	
	
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
	<div class="newsBoxBottom">
	<div class="newsBox">
		<div class="titleNews"><span>星力人才库</span></div>
		<div class="newsBoxCont">
			<table width="100%" border="0" class="tableTalent">
			  <tbody><tr class="b">
				<td>姓名</td>
				<td>性别</td>
				<td>学历</td>
				<td>所学专业</td>
				<td>毕业学校</td>
				<td>工作经验</td>
				<td>求职意向</td>
				<td>更新时间</td>
				<s:if test="#session.enterprise_user!=null">
					<s:if test="#session.enterprise_user.userType==1">
					<td>查看</td>
					</s:if>
				</s:if>
			  </tr>
			  <s:iterator value="pager.items">
			  <tr>
				<td><s:property value="name"/></td>
				<td><s:if test="sex">男</s:if><s:if test="!sex">女</s:if></td>
				<td><s:property value="degree"/></td>
				<td><s:property value="speciality"/></td>
				<td><s:property value="graduateSchool"/></td>
				<td><s:property value="workedAge"/></td>
				<td>
					<a href="javascript:void(0)" title="<s:property value="jobIntent"/>"></a>
					<s:if test="jobIntent!=null && jobIntent.length()>4"><s:property value="jobIntent.substring(0,4)"/></s:if>
					<s:else><s:property value="jobIntent"/></s:else>
				</td>
				<td><s:date name="modifyTime" format="yyyy-MM-dd"/></td>
				<s:if test="#session.enterprise_user!=null">
					<s:if test="#session.enterprise_user.userType==1">
					<td><a href="${ctx}/information/hrservice/talent!show.action?requestId=${id}" target="_blank">详细</a></td>
					</s:if>
				</s:if>				
			  </tr>
			  </s:iterator>
			</tbody>
			</table>

			<div class="cls"></div>
			<div class="pages"> <e:pagination></e:pagination> </div>
		</div>
	</div>
	</div>
	
	<div class="right">
		<div class="jobSearch">
			<div class="title3"><div class="nt2">人才搜索</div></div>
			<div class="cls"></div>
			<form action="${ctx}/information/hrservice/talent-list.action">
			<table class="tableJobSearch" style="width: 240px;">
			  <tbody>
			  <tr>
			  	<td align="right">职能：</td>
				<td><input type="text" name="intent" id="intent" style="width: 145px; height: 20px;"/></td>
			  </tr>
			  <tr>
			  	<td align="right">专业：</td>
				<td><input type="text" name="spec" id="spec" style="width: 145px; height: 20px;"/></td>
			  </tr>
			  <tr>
			  	<td align="right">学历：</td>
				<td><input type="text" name="degree" id="degree" style="width: 145px; height: 20px;"/></td>
			  </tr>
			  <tr>
			  	<td align="right">工作经历：</td>
				<td><input type="text" name="exper" id="exper" style="width: 145px; height: 20px;"/></td>
			  </tr>
			  <tr>
			  	<td align="right">工作年限：</td>
				<td><input type="text" name="wage" id="wage" style="width: 145px; height: 20px;"/></td>
			  </tr>
			  <tr>
			  	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td align="right"><input type="submit" class="btnSearch" value="搜索"/></td>
			  </tr>
			</tbody>
			</table>
			</form>
		</div>		
	
	<s:action namespace="/information/inc" name="info-hr" executeResult="true"></s:action>

	<e:adquery id="rad2" adId="172"/>
	<div class="rban1">
	<a id="172" rel="ad" target="_blank" href="<e:adlink name="rad2"/>"><img src="<e:adimg name="rad2"/>" width="242" height="140"/></a>
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
