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

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/member.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/common.css" />

<script type="text/javascript" src="<%=request.getContextPath()%>/js/nav.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/dialog.js"></script>
<script language="javascript1.1" type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.4.2.js"></script>

<link href="<%=request.getContextPath()%>/resources/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=request.getContextPath()%>/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/resources/js/formValidatorRegex.js" type="text/javascript"></script>


<script type="text/javascript">
$(function() {
	$('h2#add').addClass('q3');

	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg)},onsuccess:function(){return true;}});
 	$("#infoTypeId").formValidator({onshow:"请选择所属的版区",onfocus:"请选择所属的版区",oncorrect:""}).inputValidator({min:1,max:100,onerror:"请选中所属的版区！"});
 	$("#title").formValidator({onshow:"请输入标题",onfocus:"标题不能为空",oncorrect:"输入正确"}).inputValidator({min:1,max:100,onerror:"标题不能为空，请确认"});
	
 	$("form").submit(function(){
 	 	var fCKeditorContent = FCKeditorAPI.GetInstance("content").GetXHTML();//FCKeditor1是FCkeditor的ID
 	 	var txt = $('<div>' + fCKeditorContent + '</div>').text();
 	 	if($.trim(txt)=="") {
 	 	 	alert('内容不能为空！');
 	 	 	return false;
 	 	 }
 	 	$(':hidden[name=contentTxt]').val(txt);
 	 });

	 
	 	
});
</script>
</head>

<body>

<%-- header --%>
<s:include value="/WEB-INF/content/inc/header.jsp"></s:include>
<%-- header --%>
  
<%-- main begin --%>
<div class="main">

<div class="member">

<%-- main left begin --%>
<s:include value="/WEB-INF/content/inc/person-left.jsp"/>
<%-- main left end --%>
<div class="memcon">

	<s:include value="/WEB-INF/content/member/bar/menu.jsp"/>
	

	<div class="memcon">
	
	   <div class="maink2">
		<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/member/bar">
		<s:hidden name="nextMethod" />
		<s:hidden name="requestId" />
		<s:hidden name="id" />
		<s:hidden name="contentTxt" id="contentTxt"/>
		
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="paddk">
		  <tbody>
		  <tr>
		    <td class="pktdl1">所属的版区：<span class="red">&nbsp;</span></td>
		    <td class="pktdr1"> <s:select list="infoTypes" listKey="id" listValue="name" headerKey="" headerValue="-请选择-" name="infoType.id"  id="infoTypeId"></s:select> <span id="infoTypeIdTip"></span> </td>
		  </tr>
		  <tr>
		    <td class="pktdl1">标题：<span class="red">&nbsp;</span></td>
		    <td class="pktdr1"><s:textfield name="title" id="title" cssClass="input6"></s:textfield><span id="titleTip"></span></td>
		  </tr>
		  
		  <tr>
		    <td valign="top" class="pktdl1">内容详细：<span class="red">*</span></td>
		    <td class="pktdr1">
		    	<FCK:editor inputName="content" instanceName="content" height="350">
						<jsp:attribute name="value">
							${info.content }
						</jsp:attribute>
				</FCK:editor>    
			</td>
		  </tr>
		  <tr>
		    <td class="pktdl2">&nbsp;</td>
		    <td class="pktdr2">
				<input id="sBtn" name="sBtn" type="submit" value="确定" class="btn01"/>
				<input type="button" name="preview" value="取消" class="btn02" onclick="history.back()"/>
		    </td>
		  </tr>
		</tbody>
		</table>
		</s:form>
	   </div>
	  </div>
		
	</div>
<%-- main right begin --%>

<%-- main right end --%>

</div>

<div class="cls"></div>
<div class="cls"></div>

</div>
<%-- main end --%>
  
<%-- footer --%>
<s:include value="/WEB-INF/content/inc/footer.jsp"/>
<%-- footer --%>
	
</body>
</html>