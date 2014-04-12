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

<link rel="stylesheet" href="${ctx}/resources/zTree/css/demo.css" type="text/css"/>
<link rel="stylesheet" href="${ctx}/resources/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css"/>
<script type="text/javascript" src="${ctx}/resources/zTree/js/jquery.ztree.core-3.2.js"></script>
<script type="text/javascript" src="${ctx}/resources/zTree/js/jquery.ztree.excheck-3.2.js"></script>

<script type="text/javascript"> 
$(document).ready(function(){
	$('li#l11').addClass('hover');
	$('h2#h11').show();

	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg);},onsuccess:function(){return true;}});
 	$("#name").formValidator({onshow:"请输入你的姓名",onfocus:"请填写姓名",oncorrect:"填写正确"}).inputValidator({min:2,max:50,onerror:"你还没有填写姓名"});
 	$("#birthday").formValidator({onshow:"请输入的出生日期",onfocus:"请输入的出生日期，不能全部是0哦",oncorrect:"你输入的日期合法"}).inputValidator({min:"1900-01-01",max:"2000-01-01",type:"date",onerror:"日期必须在\"1900-01-01\"和\"2000-01-01\"之间"});
 	$("#currentAddress").formValidator({onshow:"请填写你目前居住的地址",onfocus:"请填写你目前居住的地址",oncorrect:"填写正确"}).inputValidator({min:2,max:100,onerror:"你还没有填写目前居住的地址，请确认！"});
 	$("#currentAddress").formValidator({onshow:"请填写你目前居住的地址",onfocus:"请填写你目前居住的地址",oncorrect:"填写正确"}).inputValidator({min:2,max:100,onerror:"你还没有填写目前居住的地址，请确认！"});
 	$("#contact").formValidator({onshow:"请填写你的联系方式",onfocus:"请正确填写你的联系方式，方便企业与你联系",oncorrect:"填写正确"}).inputValidator({min:11,max:11,onerror:"手机号码必须是11位的,请确认！"}).regexValidator({regexp:"mobile",datatype:"enum",onerror:"你输入的手机号码格式不正确"});
 	$("#email").formValidator({onshow:"请填写你的邮箱",onfocus:"请正确填写你的邮箱，方便企业与你联系",oncorrect:"填写正确"}).inputValidator({min:5,max:50,onerror:"请正确填写你的邮箱"}).regexValidator({regexp:"email",datatype:"enum",onerror:"你输入的邮箱格式不正确"});
 	$("#graduateSchool").formValidator({onshow:"请输入你的毕业学校",onfocus:"请填写毕业学校",oncorrect:"填写正确"}).inputValidator({min:2,max:50,onerror:"请正确填写你的毕业学校"});
 	$("#speciality").formValidator({onshow:"请输入你的专业名称",onfocus:"请填写专业名称",oncorrect:"填写正确"}).inputValidator({min:2,max:50,onerror:"请正确填写你的专业名称"});
 	$("#degree").formValidator({onshow:"请输入你的学历/学位",onfocus:"请填写学历/学位",oncorrect:"填写正确"}).inputValidator({min:2,max:50,onerror:"请正确填写你的学历/学位"});
 	$("#jobIntent").formValidator({onshow:"请输入你的求职意向",onfocus:"请填写求职意向",oncorrect:"填写正确"}).inputValidator({min:2,max:50,onerror:"请正确填写你的求职意向"});
 	$("#workedAge").formValidator({onshow:"请输入你的工作年限",onfocus:"请填写工作年限",oncorrect:"填写正确"}).inputValidator({min:1,max:50,onerror:"请正确填写你的工作年限"});
 	$("#workExperience").formValidator({onshow:"请填写你的工作经历",onfocus:"请填写你的工作经历",oncorrect:"填写正确"}).inputValidator({min:50,max:2000,onerror:"请正确填写你的工作经历，最少50个字"});
 	$("#selfEvaluate").formValidator({onshow:"请填写你的自我评价",onfocus:"请填写你的自我评价",oncorrect:"填写正确"}).inputValidator({min:50,max:2000,onerror:"请正确填写你的自我评价，最少50个字"});
 	
	<s:if test="flag==0">alert('保存简历成功！');</s:if>
	
	$('a[rel=ad]').click(function() {
		var id = $(this).attr('id');
		$.post('${ctx}/information/advertisement/click.action', {'id':id});
	});

});
</script>

<script type="text/javascript">
	<!--
	var setting = {
		async: {
			enable: true,
			url:"${ctx}/information/jobtype/job-type-tree.action",
			autoParam:["id"]
		},
		check: {
			enable: true,
			chkboxType: {"Y":"", "N":""}
		},
		view: {
			dblClickExpand: false
		},
		data: {
			simpleData: {
				enable: true,
				idKey: 'id',
				pIdKey: 'pid'
			}
		},
		callback: {
			beforeClick: beforeClick,
			onCheck: onCheck
		}
	};

	function beforeClick(treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.checkNode(treeNode, !treeNode.checked, null, true);
		return false;
	}
	
	function onCheck(e, treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
		nodes = zTree.getCheckedNodes(true),
		v = "";
		for (var i=0, l=nodes.length; i<l; i++) {
			v += nodes[i].name + ",";
		}
		if (v.length > 0 ) v = v.substring(0, v.length-1);
		var cityObj = $("#citySel");
		cityObj.attr("value", v);
	}

	function showMenu() {
		var cityObj = $("#citySel");
		var cityOffset = $("#citySel").offset();
		var offset = cityOffset.left-188;
		$("#menuContent").css({left:offset + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

		$("body").bind("mousedown", onBodyDown);
	}
	function hideMenu() {
		$("#menuContent").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown);
	}
	function onBodyDown(event) {
		if (!(event.target.id == "menuBtn" || event.target.id == "citySel" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
			hideMenu();
		}
	}

	$(document).ready(function(){
		$.fn.zTree.init($("#treeDemo"), setting);
	});
	//-->
</script>

</head>

<body>
<div id="wrap">
<s:include value="/WEB-INF/content/information/inc/header.jsp"/>

<%-- main begin --%>
<div class="main">
	<div class="resume">
		<p class="f14 b">个人信息（<span class="orange">*</span>为必填项）</p>
		
		<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/information/hrservice" enctype="multipart/form-data">
		<s:hidden name="nextMethod" />
		<s:hidden name="requestId" />
		<s:hidden name="talent.id" />

		<table width="100%" border="0" class="tableResume">
		  <tbody>
		  <s:if test="avatar!=null">
		  <tr>
			<td class="tr"><span class="orange mr10"></span>&nbsp;</td>
			<td> <img src="${ctx }/FileView?id=<s:property value='avatar'/>" alt="我的头像" /> </td>
		  </tr>
		  
		  </s:if>
		  <tr>
			<td class="tr"><span class="orange mr10"></span>头像： </td>
			<td> <s:file name="upload" id="upload"></s:file> </td>
		  </tr>
		  <tr>
			<td class="tr"><span class="orange mr10">*</span>姓名： </td>
			<td> <s:textfield name="talent.name" id="name" cssClass="txtName"/><span id="nameTip"></span> </td>
		  </tr>
		  <tr>
			<td class="tr"><span class="orange mr10">*</span>性别：</td>
			<td><span class="mr10"> <s:radio list="#{true:'男', false:'女' }" name="talent.sex"></s:radio></span><span id="sexTip"></span> </td>
		  </tr>
		  <tr>
			<td class="tr"><span class="orange mr10">*</span> 出生日期：</td>
			<td><span class="mr10">
			<s:textfield readonly="true" name="talent.birthday" id="birthday" cssClass="Wdate" onfocus="WdatePicker({dataFmt:'yyyy-MM-dd'})">
				<s:param name="value">
					<s:date name="talent.birthday" format="yyyy-MM-dd"/>
				</s:param>
			</s:textfield></span><span id="birthdayTip"></span></td>
		  </tr>
		  <tr>
			<td class="tr">婚姻状况：</td>
			<td><span class="mr10"> <s:radio list="#{0:'保密', 1:'未婚', 2:'已婚'}" name="talent.marriage"></s:radio></span></td>
		  </tr>
		  <tr>
			<td class="tr">政治面貌：</td>
			<td><span class="mr10"><s:radio list="#{0:'保密', 1:'中共党员（含预备党员）', 2:'团员', 3:'群众', 4:'民主党派', 5:'无党派人士' }" name="talent.politics"></s:radio></span></td>
		  </tr>
		  <tr>
			<td class="tr">户口所在地：</td>
			<td><span class="mr10"><s:textfield name="talent.birthAddress" id="birthAddress" cssClass="txtName"/></span></td>
		  </tr>
		  <tr>
			<td class="tr"><span class="orange mr10">*</span>现居住城市：</td>
			<td><s:textfield name="talent.currentAddress" id="currentAddress" cssClass="txtName"/><span id="currentAddressTip"></span></td>
		  </tr>
		  <tr>
			<td class="tr"><span class="orange mr10">*</span>联系方式：</td>
			<td><s:textfield name="talent.contact" id="contact" cssClass="txtName"/><span id="contactTip"></span></td>
		  </tr>
		  <tr>
			<td class="tr"><span class="orange mr10">*</span>电子邮箱：</td>
			<td><s:textfield name="talent.email" id="email" cssClass="txtName"/><span id="emailTip"></span></td>
		  </tr>
		</tbody></table>
		
		<p class="f14 b">最高学历和教育背景（<span class="orange">*</span>为必填项）</p>
		<table width="100%" border="0" class="tableResume">
		  <tbody><tr>
			<td><span class="orange mr10">*</span>毕业学校：</td>
			<td><s:textfield name="talent.graduateSchool" id="graduateSchool" cssClass="txtName"/><span id="graduateSchoolTip"></span></td>
		  </tr>
		  <tr>
			<td><span class="orange mr10">*</span>专业名称：</td>
			<td><s:textfield name="talent.speciality" id="speciality" cssClass="txtName"/><span id="specialityTip"></span></td>
		  </tr>
		  <tr>
			<td><span class="orange mr10">*</span>学历/学位：</td>
			<td><s:textfield name="talent.degree" id="degree" cssClass="txtName"/><span id="degreeTip"></span></td>
		  </tr>
		  <tr>
			<td><span class="orange mr10">*</span>工作年限：</td>
			<td><s:textfield name="talent.workedAge" id="workedAge" cssClass="txtName"/><span id="workedAgeTip"></span></td>
		  </tr>
		  <tr>
			<td><span class="orange mr10">*</span>求职意向：</td>
			<td>
				<input id="citySel" name="talent.jobIntent" type="text" readonly value="<s:property value='talent.jobIntent'/>" style="width:350px;" onfocus="showMenu();" />&nbsp;<a id="menuBtn" href="#" onclick="showMenu(); return false;">选择</a>
			</td>
		  </tr>
		  <tr>
			<td><span class="orange mr10"></span>应聘职位：</td>
			<td>
				<s:textfield name="talent.post" id="post" cssClass="txtName"/><span id="postTip"></span>
			</td>
		  </tr>
		  <tr>
			<td><span class="orange mr10">*</span>工作经历：</td>
			<td> <s:textarea name="talent.workExperience" id="workExperience" cssClass="areaExper"></s:textarea></td>
		  </tr>
		  <tr>
			<td><span class="orange mr10">*</span>自我评价：</td>
			<td><s:textarea name="talent.selfEvaluate" id="selfEvaluate" cssClass="areaExper"></s:textarea></td>
		  </tr>
		  <tr>
			<td>&nbsp;</td>
			<td><input type="submit" class="btnSubmit" value="提交"/><input type="button" class="btnSubmit" value="取消"/></td>
		  </tr>
		</tbody>
		</table>
		</s:form>
		
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
<div id="menuContent" class="menuContent" style="display:none; position: absolute;">
	<ul id="treeDemo" class="ztree" style="margin-top:0; width:342px; height: 300px;"></ul>
</div>
</div>
</body>
</html>
