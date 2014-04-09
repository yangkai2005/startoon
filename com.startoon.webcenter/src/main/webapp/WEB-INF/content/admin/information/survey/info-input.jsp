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
 	$("#infoTypeId").formValidator({onshow:"",onfocus:"请选择所属的分类",oncorrect:""}).inputValidator({min:1,max:100,onerror:"你还没有选择所属的类别"});

 	$("#form1").submit(function(){
 	 	var txt = $('#content').val();
 	 	$(':hidden[name=contentTxt]').val(txt);
 	 });

});

</script>

</head>

<body>
<div class="mTitle">
  <b class="bbig">在线调查维护</b>
</div>
<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/admin/information/survey">
<s:hidden name="nextMethod" />
<s:hidden name="requestId" />
<s:hidden name="id" />
<s:hidden name="contentTxt" />
<s:hidden name="tid" />
<!--list -->
<div class="mainAdd">
<table class="addTable">
  <tr>
    <th>标题:</th> 
	<td> <s:textfield name="title" id="title" size="30"></s:textfield><span id="titleTip"></span> </td>
  </tr>
  <%-- 资讯中心 begin --%>
  <tr>
    <th>类别:</th>
	<td> <s:select name="infoType.id" id="infoTypeId" list="%{infoTypes}" listKey="id" listValue="name" headerKey="" headerValue="请选择类别"></s:select> <span id="infoTypeIdTip"></span> </td>
  </tr>
  <tr>
    <th>调查描述:</th>
	<td>
		<s:textarea name="content" id="content"></s:textarea>
	</td>
  </tr>
</table>
</div>
<!--end list -->
<div class="addToolbar">
    <p><button class="btn" type="submit"><b>提交</b></button>
    <button class="btn" type="button" onclick="location.href='<s:url action="info-list" namespace="/admin/information/survey"/>?restore_params=true'">返回</button></p>
</div>
 
</s:form>
</body>
</html>