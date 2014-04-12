<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
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

<script type="text/javascript">
$(document).ready(function(){
	<s:if test="flag">alert('添加企业动态成功！');</s:if>

	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg);},onsuccess:function(){return true;}});
 	$("#title").formValidator({onshow:"",onfocus:"标题不为空",oncorrect:""}).inputValidator({min:1,max:100,onerror:"标题不为空"});
 	$(":radio.infoTypeId").formValidator({onshow:"",onfocus:"请选择类别",oncorrect:""}).inputValidator({min:1,max:100,onerror:"请选择类别"});
	
	$("#crop").addClass("q2");
	$('#btnSubmit').click(function() {
		$('#form1').submit();
	});

 	$("#form1").submit(function(){
 	 	var fCKeditorContent = FCKeditorAPI.GetInstance("content").GetXHTML();//FCKeditor1是FCkeditor的ID
 	 	var txt = $('<div>' + fCKeditorContent + '</div>').text();
 	 	$(':hidden[name=contentTxt]').val(txt);
 	 });
	
});
</script>
</head>

<body>
<%-- header --%>
<s:include value="/WEB-INF/content/inc/header.jsp"></s:include>
<%-- header --%>
<div class="cls"></div>
<%-- main begin --%>
<div class="main">

<div class="member">
<%-- left --%>
<s:include value="/WEB-INF/content/inc/member-left.jsp"></s:include>
<%-- left --%>

<%-- right --%>

<div class="memright">
<div class="title4"> <div class="hotline">客服热线：020-39106666</div>
	 <div class="titlemu2">
	 
	 <h1>企业管理</h1>
	 </div>
	 </div>
	 
	<div class="memcon">
		<div class="memqy">
		<s:include value="/WEB-INF/content/enterprise/entinfo/menu.jsp" />
		
		<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/enterprise/cooperation">
		<s:hidden name="nextMethod" />
		<s:hidden name="requestId" />
		<s:hidden name="id" />
		<s:hidden name="contentTxt" id="contentTxt" />
		<h2>
		<p align="left">产业合作标题：<s:textfield name="title" id="title" cssStyle="width: 350px;"></s:textfield><span id="titleTip"></span></p>
		<s:if test="nextMethod=='insert'">
		<br />
		<p align="left">合作方式：<s:radio list="#{31:'代理', 32:'合作', 33:'加盟', 34:'商机'}" name="infoType.id" cssClass="infoTypeId"></s:radio> <span id="infoTypeIdTip"></span> </p>
		</s:if>
		<br/>
		<p align="center">
			<FCK:editor instanceName="content" height="350" toolbarSet="B2B">
				<jsp:attribute name="value">
					${content }
				</jsp:attribute>
			</FCK:editor>			
		</p>
		<div class="bp3" style="width:100%; margin:10px 0; float:left;">
			<img src="${ctx}/images/dan.jpg" style="vertical-align:middle" /> 详细说明为20-12000个字符
		</div>
		<p align="center">
			<input id='btnSubmit' type="button" name="preview"  value="确定"  class="btn01" />
			<input name="Input4" type="button"  value="取消"  class="btn02" onclick="javascript:history.back()"/>
		</p>
		</h2>
		</s:form>
		
		</div>

	
	</div>
	 
	 

</div>

<%-- right --%>
</div>


</div>
<%-- main end --%>

<div class="cls"></div>
<div class="cls"></div>
  
<%-- footer --%>
<s:include value="/WEB-INF/content/inc/footer.jsp"/>
<%-- footer --%>	
</body>
</html>