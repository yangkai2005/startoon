<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>Title Here</title>

<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/admin.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/validator.css"/>
<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/formValidator.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/formValidatorRegex.js"></script>

<script type="text/javascript"> 
$(document).ready(function(){
 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg)},onsuccess:function(){return true;}});
 	$("#name").formValidator({onshow:"",onfocus:"合作商名称不能为空",oncorrect:""}).inputValidator({min:1,max:100,onerror:"合作商名称不能为空"});
 	$("#position").formValidator({onshow:"",onfocus:"请选择所在位置",oncorrect:""}).inputValidator({min:1,max:100,onerror:"所在位置必须选择"});
 	$("#siteUrl").formValidator({onshow:"",onfocus:"合作商网址不能为空",oncorrect:""}).inputValidator({min:1,max:100,onerror:"合作商网址不能为空"});
 	<s:if test="%{nextMethod=='insert'}">
 	$("#upload").formValidator({onshow:"",onfocus:"合作商的LOGO不能为空",oncorrect:""}).inputValidator({min:1,max:100,onerror:"合作商的LOGO不能为空"});
 	</s:if>
});
</script>

</head>

<body>
<div class="mTitle">
  <b class="bbig">合作单位</b>
</div>
<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/admin/information/copartnership" enctype="multipart/form-data">
<s:hidden name="nextMethod" />
<s:hidden name="requestId" />
<s:hidden name="id" />
<!--list -->
<div class="mainAdd">
<table class="addTable">
<s:if test="%{nextMethod=='update'}">
  <tr>
    <th></th> 
	<td><img src="<s:property value="smallLogo"/>" alt="<s:property value="name"/>" /></td>
  </tr>
</s:if>
  <tr>
    <th>所在位置：</th> 
	<td> 
		<select name="infoTypeId" id="position">
			<option value="">--请选择所在位置--</option>
			<option value="-1" <s:if test="%{infoTypeId==-1}">selected="selected"</s:if>>┣B2B平台</option>
			<option value="">┣资讯平台</option>
			<s:if test="%{infoTypeId==1}">selected="selected"</s:if>
			<option value="1" <s:if test="%{infoTypeId==1}">selected="selected"</s:if>>&nbsp;&nbsp;&nbsp;&nbsp;┣首页</option>
			<option value="2" <s:if test="%{infoTypeId==2}">selected="selected"</s:if>>&nbsp;&nbsp;&nbsp;&nbsp;┣资讯中心</option>
			<option value="4" <s:if test="%{infoTypeId==4}">selected="selected"</s:if>>&nbsp;&nbsp;&nbsp;&nbsp;┣高端访谈</option>
			<option value="5" <s:if test="%{infoTypeId==5}">selected="selected"</s:if>>&nbsp;&nbsp;&nbsp;&nbsp;┣店长吧</option>
			<option value="6" <s:if test="%{infoTypeId==6}">selected="selected"</s:if>>&nbsp;&nbsp;&nbsp;&nbsp;┣星力观察家</option>
			<option value="7" <s:if test="%{infoTypeId==7}">selected="selected"</s:if>>&nbsp;&nbsp;&nbsp;&nbsp;┣创意Show	</option>
			<option value="8" <s:if test="%{infoTypeId==8}">selected="selected"</s:if>>&nbsp;&nbsp;&nbsp;&nbsp;┣展会活动</option>
			<option value="11" <s:if test="%{infoTypeId==11}">selected="selected"</s:if>>&nbsp;&nbsp;&nbsp;&nbsp;┣人才服务</option>
			<option value="100000" <s:if test="%{infoTypeId==100000}">selected="selected"</s:if>>&nbsp;&nbsp;&nbsp;&nbsp;┣资料下载</option>
		</select> 
		<span id="positionTip"></span> 
	</td>
  </tr>
  <tr>
    <th>合作商名称：</th> 
	<td> <s:textfield name="name" id="name" size="30"></s:textfield><span id="nameTip"></span> </td>
  </tr>
  <tr>
    <th>合作商网址：</th> 
	<td> <s:textfield name="siteUrl" id="siteUrl" size="30"></s:textfield><label>如:http://www.qq.com </label><span id="siteUrlTip"></span> </td>
  </tr>
  <tr>
    <th>合作商的LOGO:</th> 
	<td> <s:file id="upload" name="upload"></s:file> <span id="nameTip"></span> </td>
  </tr>
</table>
</div>
<!--end list -->
<div class="addToolbar">
    <p><button class="btn" type="submit"><b>确定</b></button>
    <button class="btn" type="button" onclick="location.href='<s:url action="copartnership-list" namespace="/admin/information/copartnership"/>?restore_params=true'">取消</button></p>
</div>
 
 </s:form>
</body>
</html>