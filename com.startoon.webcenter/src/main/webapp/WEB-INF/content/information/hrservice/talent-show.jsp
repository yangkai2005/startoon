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

<script src="${ctx}/resources/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>

<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/validator.css"/>
<script type="text/javascript" src="${ctx}/resources/js/formValidator.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/formValidatorRegex.js"></script>

<style type="">
th {style="text-align: right; width: 80px;}
</style>

<script type="text/javascript"> 
$(document).ready(function(){
	$('li#l11').addClass('hover');
	$('h2#h11').show();
	
	$('#addFavorite').click(function() {
		var tid = '<s:property value="id"/>'
		$.post('${ctx}/enterprise/hrservice/talent-ref-favorite!add.action', 
				{'tid': tid, 'r': (new Date()).getTime()}, 
				function(data) {
					if(data.result==0) {
						alert('添加到收藏夹成功。'); 
					} else if(data.result==1) {
						alert('添加失败！该简历已经在收藏夹当中！');
					}
				}
		);
	});	
});
</script>
</head>

<body>
<div id="wrap">

<%-- main begin --%>
<div class="main">
	<div class="resume">
		<p class="f14 b">个人信息</p>

		<table width="100%" border="0" class="tableResume">
		  <tbody>
		   <s:if test="avatar!=null">
		  <tr>
			<td>&nbsp;</td>
			<td><img src="${ctx }/FileView?id=<s:property value='avatar'/>" alt="我的头像" /></td>
		  </tr>
		  </s:if>
		  <tr>
			<td class="tr" width="80px">姓名：</td>
			<td><span class="mr10"><s:property value="name"/></span></td>
		  </tr>
		  <tr>
			<td class="tr">性别：</td>
			<td><s:if test="sex">男</s:if><s:else>女</s:else></td>
		  </tr>
		  <tr>
			<td class="tr"> 出生日期：</td>
			<td><s:date name="birthday" format="yyyy-MM-dd"/> </td>
		  </tr>
		  <tr>
			<td class="tr">婚姻状况：</td>
			<td><s:if test="marriage==1">未婚</s:if><s:if test="marriage==2">已婚</s:if><s:else>保密</s:else></td>
		  </tr>
		  <tr>
			<td class="tr">政治面貌：</td>
			<td><s:property value="politicsZh"/></td>
		  </tr>
		  <tr>
			<td class="tr">户口所在地：</td>
			<td><s:property value="birthAddress"/></td>
		  </tr>
		  <tr>
			<td class="tr">现居住城市：</td>
			<td><s:property value="currentAddress"/></td>
		  </tr>
		  <tr>
			<td class="tr">联系方式：</td>
			<td><s:property value="contact"/></td>
		  </tr>
		  <tr>
			<td class="tr">电子邮箱：</td>
			<td><s:property value="email"/></td>
		  </tr>
		</tbody></table>
		
		<p class="f14 b">最高学历和教育背景</p>
		<table width="100%" border="0" class="tableResume">
		  <tbody>
		  <tr>
			<th>毕业学校：</th>
			<td><s:property value="graduateSchool"/></td>
		  </tr>
		  <tr>
			<th>专业名称：</th>
			<td><s:property value="speciality"/></td>
		  </tr>
		  <tr>
			<th>学历/学位：</th>
			<td><s:property value="degree"/></td>
		  </tr>
		  <tr>
			<th>求职意向：</th>
			<td><s:property value="jobIntent"/></td>
		  </tr>
		  <tr>
			<th>应聘职位：</th>
			<td><s:property value="post"/></td>
		  </tr>
		  <tr>
			<th>工作经历：</th>
			<td><s:property value="workExperience"/></td>
		  </tr>
		  <tr>
			<th>自我评价：</th>
			<td><s:property value="selfEvaluate"/></td>
		  </tr>
		  <tr>
			<td colspan="2" align="center">
				<input type="button" class="btnSubmit" value="收   藏" id="addFavorite"/>
				&nbsp;&nbsp;
				<input type="button" class="btnSubmit" value="关  闭" onclick="self.close();"/>
			</td>
		  </tr>
		</tbody>
		</table>
		
	</div>
</div>
<%-- main end --%>

<div class="cls"></div>

</div>
</body>
</html>
