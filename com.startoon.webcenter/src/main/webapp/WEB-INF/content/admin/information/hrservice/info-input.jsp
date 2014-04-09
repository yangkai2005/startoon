<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>


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
<script type="text/javascript" src="${ctx}/resources/fileuploader/fileuploader.js"></script>

<script type="text/javascript" src="${ctx}/resources/js/jquery.example.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/My97DatePicker/WdatePicker.js"></script>

<!-- multiple-file-upload begin -->
<script src='${ctx}/resources/multiple-file-upload/jquery.blockUI.js' type="text/javascript"></script>
<!--// plugin-specific resources //-->
<script src='${ctx}/resources/multiple-file-upload/jquery.form.js' type="text/javascript" language="javascript"></script>
<script src='${ctx}/resources/multiple-file-upload/jquery.MetaData.js' type="text/javascript" language="javascript"></script>
<script src='${ctx}/resources/multiple-file-upload/jquery.MultiFile.js' type="text/javascript" language="javascript"></script>
<script src='${ctx}/resources/multiple-file-upload/jquery.blockUI.js' type="text/javascript" language="javascript"></script>
<!-- multiple-file-upload end -->

<script type="text/javascript">
$(document).ready(function(){
	
 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg);},onsuccess:function(){return true;}});
 	$("#title").formValidator({onshow:"",onfocus:"请填写标题",oncorrect:""}).inputValidator({min:1,max:100,onerror:"你还没有填写标题"});
 	$("#infoTime").formValidator({onshow:"",onfocus:"请选择发布时间",oncorrect:""}).inputValidator({min:1,max:100,onerror:"你还没有选择发布时间"});
 	$(":radio#infoTypeId").formValidator({onshow:"",onfocus:"请选择所属的分类",oncorrect:""}).inputValidator({min:1,max:100,onerror:"你还没有选择所属的类别"});

 	$("#form1").submit(function(){
 	 	var fCKeditorContent = FCKeditorAPI.GetInstance("content").GetXHTML();//FCKeditor1是FCkeditor的ID
 	 	var txt = $('<div>' + fCKeditorContent + '</div>').text();
 	 	$(':hidden[name=contentTxt]').val(txt);
 	 });
	 
	

});

</script>

</head>

<body>
<div class="mTitle">
  <b class="bbig">资讯信息维护</b>
</div>
<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/admin/information/hrservice" >
<s:hidden name="nextMethod" />
<s:hidden name="requestId" />
<s:hidden name="id" />
<s:hidden name="contentTxt" />
<!--list -->
<div class="mainAdd">
<table class="addTable">
  <tr>
    <th>人才服务新闻分类:</th> 
	<td> <s:radio id="infoTypeId" name="infoType.id" list="#{45:'人才工作站', 46:'教育培训'}"></s:radio> <span id="infoTypeIdTip"></span></td>
  </tr>
  <tr>
    <th>标题:</th> 
	<td> <s:textfield name="title" id="title" size="30"></s:textfield><span id="titleTip"></span> </td>
  </tr>
  <tr>
    <th>发布日期:</th> 
	<td><s:textfield name="infoTime" id="infoTime" size="30" cssClass="Wdate" onfocus="WdatePicker()"><s:param name="value"><s:date name="infoTime" format="yyyy-MM-dd"/></s:param> </s:textfield><span id="infoTimeTip"></span> </td>
  </tr>
  <tr>
    <th>来源:</th> 
	<td> <s:textfield name="source" id="source" size="30"></s:textfield><span id="sourceTip"></span> </td>
  </tr>
  <tr>
    <th>来源网站:</th> 
	<td> <s:textfield name="sourceUrl" id="sourceUrl" size="30"></s:textfield><span id="sourceUrlTip"></span> </td>
  </tr>
  <tr>
    <th>内容:</th>
	<td>  
    	<FCK:editor inputName="content" instanceName="content" height="350">
				<jsp:attribute name="value">
					${info.content }
				</jsp:attribute>
		</FCK:editor>
	</td>
  </tr>
</table>
</div>
<!--end list -->
<div class="addToolbar">
    <p><button class="btn" type="submit"><b>提交</b></button>
    <button class="btn" type="button" onclick="location.href='<s:url action="info-list" namespace="/admin/information/hrservice"/>?restore_params=true'">返回</button></p>
</div>
 
 </s:form>
</body>
</html>