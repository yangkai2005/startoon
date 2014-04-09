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
<link rel="stylesheet" type="text/css" href="${ctx}/css/member.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />
<script src="${ctx}/resources/js/jquery.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/js/nav.js"></script>

<link href="${ctx}/resources/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>
<script src="${ctx}/resources/My97DatePicker/WdatePicker.js" type="text/javascript"></script>

<link rel="stylesheet" href="${ctx}/resources/zTree/css/demo.css" type="text/css"/>
<link rel="stylesheet" href="${ctx}/resources/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css"/>
<script type="text/javascript" src="${ctx}/resources/zTree/js/jquery.ztree.core-3.2.js"></script>
<script type="text/javascript" src="${ctx}/resources/zTree/js/jquery.ztree.excheck-3.2.js"></script>


<script type="text/javascript">
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
		var offset = cityOffset.left;
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

	$(function() {
		$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg);},onsuccess:function(){return true;}});
	 	$("#num").formValidator({onshow:"",onfocus:"",oncorrect:""}).inputValidator({min:1,max:100,onerror:"请填写招聘人数"}).regexValidator({regexp:"num",datatype:"enum",onerror:"招聘人数为数字"});
	});
</script>
</head>

<body>

<%-- header --%>
<s:include value="/WEB-INF/content/inc/header.jsp"></s:include>
<%-- header --%>
		

<div class="cls"></div>


<!--main star-->
<div class="main">

<div class="member">
<%-- left --%>
<s:include value="/WEB-INF/content/inc/member-left.jsp"></s:include>
<%-- left --%>

<%-- main begin --%>
<div class="memright">
<div class="title4"> <div class="hotline">客服热线：020-39106666</div>
	 <div class="titlemu2">
	
	 
	 <h2 class="q3">企业招聘</h2> 
	 </div>
	 </div>
	 
	<div class="memcon">
		 	
		<div class="sicon3">
		<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/enterprise/hrservice">
		<s:hidden name="nextMethod" />
		<s:hidden name="requestId" />
		<s:hidden name="id" />
		
		<table width="100%" border="0" cellspacing="1" bgcolor="#d7e2ec" class="qytable">
		  <tbody>
		  <tr>
		    <td width="11%" class="tdtitle">职位名称：</td>
		    <td width="39%"><s:textfield id="name" name="name" cssClass="txtqy1"/> </td>
		    <td width="11%" class="tdtitle">招聘人数：</td>
		    <td width="39%"><s:textfield id="num" name="num" cssClass="txtqy1" cssStyle="width:120px;" /><span id="numTip"></span></td>
		  </tr>
		  <tr>
		    <td class="tdtitle">工作性质：</td>
		    <td> <s:radio list="#{0:'全职 ', 1:'兼职'}" name="type"></s:radio> </td>
		    <td class="tdtitle">专&nbsp;&nbsp;&nbsp;&nbsp;业：</td>
		    <td><s:textfield id="speciality" name="speciality" cssClass="txtqy1"/></td>
		  </tr>
		  <tr>
		    <td class="tdtitle">工作地点：</td>
		    <td> <s:textfield id="workAddress" name="workAddress" cssClass="txtqy1"/></td>
		    <td class="tdtitle">截止日期：</td>
		    <td><s:textfield id="endTime" name="endTime" cssClass="txtqy1" cssClass="Wdate"  onfocus="WdatePicker()"> <s:param name="value"><s:date name="endTime" format="yyyy-MM-dd"/></s:param></s:textfield></td>
		  </tr>
		  <tr>
		    <td class="tdtitle">要求性别： </td>
		    <td><s:radio list="#{0:'不限',1:'男',2:'女'}" name="sexLimit"></s:radio></td>
		    <td class="tdtitle">要求年龄：</td>
		    <td><s:textfield id="ageLimit" name="ageLimit" cssClass="txtqy1"/></td>
		  </tr>
		  <tr>
		    <td class="tdtitle">要求学历：</td>
		    <td>
		    	<s:select list="#{'不限':'不限', '小学':'小学', '初中':'初中', '高中':'高中', '大专':'大专', '本科':'本科', '硕士':'硕士', '博士':'博士' }" name="certificate" cssStyle="width:200px;"></s:select>
		    </td>
		    <td class="tdtitle">工作年限：</td>
		    <td><s:textfield id="workedAge" name="workedAge" cssClass="txtqy1"/></td>
		  </tr>
		  <tr>
		    <td class="tdtitle">职能：</td>
		    <td colspan="3">
		    <s:textfield id="citySel" name="jobFun" readonly="true" cssStyle="width:350px;" onfocus="ShowMenu();"></s:textfield>&nbsp;<a id="menuBtn" href="#" onclick="showMenu(); return false;">选择</a>
		    </td>
		  </tr>
		  <tr>
		    <td class="tdtitle">详细描述：</td>
		    <td colspan="3">
		    	<s:textarea name="description" cssClass="txtqy3"  cssStyle="height: 300px;"></s:textarea>
		     </td>
		    </tr><!--
		  <tr>
		    <td class="tdtitle">立即发布：</td>
		    <td colspan="3"><input type="checkbox" name="status" value="2"/>是</td>
		    </tr>
		  -->
		  <tr>
		    <td>&nbsp;</td>
		      <td colspan="3">
		          <input type="submit" name="Submit" value="确 定" class="btnanlou"/> 
		          <input type="button" name="Submit" value="返 回" class="btnanlou" onclick="history.back();"/>
		          &nbsp;&nbsp;</td>
		  </tr>
		</tbody>
		</table>
		</s:form>		
		</div>
		<br/>
		<div class="cls"></div>
		<div style="margin-top: 20px;">
		
		<s:if test="limit.memberLevel==1">
		<h3><b style="font-family: 黑体;">温馨提示</b>：您现在是<b style="color: #ff0000">初级会员</b>，可免费发布职位数：<font style="color: #ff0000;"><s:property value="limit.maxJobCount"/></font>条   已使用数量：<font style="color: #ff0000;"><s:property value="limit.jobCount"/></font>条  如需增加发布数量，请联系客服或致电<font style="color: #ff0000;">39106666</font> </h3>
		</s:if>
		
		<s:elseif test="limit.memberLevel==2">
		<h3>温馨提示：您现在是<b style="color: #ff0000">高级会员</b>，可免费发布职位数：<font style="color: #ff0000;"><s:property value="limit.maxJobCount"/></font>条   已使用数量：<font style="color: #ff0000;"><s:property value="limit.jobCount"/></font>条  如需增加发布数量，请联系客服或致电<font style="color: #ff0000;">39106666</font> </h3>
		</s:elseif>
		
		<s:else>
		<h3>温馨提示：您现在是<b style="color: #ff0000">普通会员</b>，可免费发布职位数：<font style="color: #ff0000;">5</font>条   已使用数量：<font style="color: #ff0000;"><s:if test="limit==null">0</s:if><s:else><s:property value="limit.jobCount"/></s:else> </font>条  如需增加发布数量，请联系客服或致电<font style="color: #ff0000;">39106666</font> </h3>
		</s:else>
		
		</div>
	</div>

</div>
<%-- main begin --%>

</div>

<div class="cls"></div>
  
<%-- footer --%>
<s:include value="/WEB-INF/content/inc/footer.jsp"/>
<%-- footer --%>	

<div id="menuContent" class="menuContent" style="display:none; position: absolute;">
	<ul id="treeDemo" class="ztree" style="margin-top:0; width:342px; height: 300px;"></ul>
</div>
</body>
</html>