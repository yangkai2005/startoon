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

<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/validator.css"/>
<script type="text/javascript" src="${ctx}/resources/js/formValidator.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/formValidatorRegex.js"></script>

<script type="text/javascript"> 
$(document).ready(function(){
	$('li#l11').addClass('hover');
	$('h2#h11').show();

	$('#inputResume').click(function() {
		window.location = '${ctx}/information/hrservice/talent!input.action?jobId=<s:property value="%{currentJob.id}"/>';
	});

	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg);},onsuccess:function(){return true;}});
 	$("#email").formValidator({onshow:"请填写你的邮箱",onfocus:"请正确填写你的邮箱，方便企业与你联系",oncorrect:"填写正确"}).inputValidator({min:5,max:50,onerror:"请正确填写你的邮箱"}).regexValidator({regexp:"email",datatype:"enum",onerror:"你输入的邮箱格式不正确"});
 	$("#upload").formValidator({onshow:"请选择你要上传的word格式简历",onfocus:"请选择你要上传的word格式简历",oncorrect:""}).inputValidator({min:1,max:100,onerror:"请选择你要上传的word格式简历"});

 	$('#form1').submit(function() {
 	 	var ck = $(':radio:checked').val();
 	 	if(ck!='0') {
 	 	 	alert('只有同意声明才能进行操作！');
 	 	 	return false;
 	 	}
 	});
});
</script>
</head>

<body>
<div id="wrap">
<s:include value="/WEB-INF/content/information/inc/header.jsp"/>

<!--main star-->
<div class="main">
	<div class="uploadResume">
		<p class="titleJob">您应聘的是：<span class="orange"><s:property value="%{currentJob.enterprise.name}"/></span>的<span class="orange"><s:property value="%{currentJob.name}"/></span>职位</p>
		<div class="uploadLeft">
			<p class="f14 b">声明：</p>
			<textarea class="noticeFrame">
一、隐私条款 
    星力网www.chnam.com《人才服务》栏目为服务性栏目，免费为个人会员提供简历展示、求职信息；免费为企业会员提供人才信息。除了“婚姻状况”、“政治面貌”、“户口所在地”三项为选择性填写之外，其它项目信息为必填信息。
    我们将向企业注册会员免费公开您的个人资料，包括：姓名、性别、出生日期、婚姻状况、现居住城市、联系方式、电子邮箱、毕业学校、专业名称、学历/学位、求职意向、工作经历、自我评价等信息。www.chnam.com承诺不出售注册者信息或做其它用途。
    由于www.chnam.com《人才服务》栏目是是一个免费的服务型平台，您可以把你的简历放入我们的数据库，招聘企业或人员可以通过我们的简历数据库找到你的简历。用人单位及其它企业对您个人信息的使用，www.chnam.com不负任何法律责任。
    当你向www.chnam.com递交您的简历时，默认选择允许公开您的简历选项，www.chnam.com认为在您把你的简历放入我们的数据库时，您已经意识到了这种风险的存在，并同意承担这样的风险。对于因此而引起的任何法律纠纷，www.chnam.com不承担任何法律责任。

二、免责条款
    www.chnam.com《人才服务》的企业招聘信息由注册企业免费发布、其人才简历由个人会员免费自行注册发布，www.chnam.com对信息的真实性一概不负任何责任。
     使用者承认并同意，应聘信息发布方对存入简历中心的个人简历及材料的格式、内容的准确性和合法性负有全部责任，招聘信息发布方对于其在职位数据库公布的材料的准确性和合法性负有全部责任。
     对于www.chnam.com为使用者提供便利而设置的外部链接网址，www.chnam.com并不保证其准确性、安全性和完整性，亦并不代表本网站对其链接内容的认可，请使用者谨慎确认后使用，www.chnam.com对由此导致的任何损失或伤害不承担任何责任。
     个人会员递交简历或将简历放入www.chnam.com数据库、企业会员发布招聘信息即代表认同本条款。

			</textarea>
			<p class="tc"><span class="mr10"><input type="radio" checked="checked" name="agreement" value="0" />同意</span><input type="radio" name="agreement" value="1" />不同意</p>
		</div>
		<div class="uploadRight">
			<p class="f13 b gray">已有一份word简历，直接上传我的简历来申请该职位</p>
			<form id="form1" action="${ctx}/information/hrservice/resume/resume!insert.action" enctype="multipart/form-data" method="post">
			<input type="hidden" name="jobs.id" value="<s:property value='currentJob.id'/>"/>
			<input type="hidden" name="enterprise.id" value="<s:property value='currentJob.enterprise.id'/>"/>
			<table border="0" class="tableUpload">
			  <tr>
				<td>我的Email：</td>
				<td><input type="text" class="txtEmail" name="email" id="email" /><span id="email"></span></td>
			  </tr>
			  <tr>
				<td>请上传简历：</td>
				<td><input type="file" class="txtEmail" name="upload" id="upload" /><span class="ml10"></span></td>
			  </tr>
			  <tr>
				<td class="tc" colspan="2"><input type="submit" class="btnSubmit" value="上传简历" /><input type="button" class="btnSubmit" value="在线填写简历" id="inputResume"/></td>
			  </tr>
			</table>
			</form>
		</div>
		<div class="cls"></div>
	</div>
</div>
<!-- main end -->

<div class="cls"></div>
<s:include value="/WEB-INF/content/information/inc/links.jsp"/>
<div class="cls"></div>
<s:include value="/WEB-INF/content/information/inc/footer.jsp"/>
</div>
</body>
</html>

