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
 	$("#title").formValidator({onshow:"",onfocus:"标题不能为空",oncorrect:""}).inputValidator({min:1,max:100,onerror:"标题不能为空"});
 	$("#description").formValidator({onshow:"",onfocus:"描述不能为空",oncorrect:""}).inputValidator({min:1,max:100,onerror:"描述不能为空"});
 	$("#options").formValidator({onshow:"",onfocus:"选项不能为空",oncorrect:""}).inputValidator({min:1,max:100,onerror:"选项不能为空"});
});
</script>

</head>

<body>
<div class="mTitle">
  <b class="bbig">行情调查维护</b>
</div>
<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/admin/information/vote">
<s:hidden name="nextMethod" />
<s:hidden name="requestId" />
<s:hidden name="id" />
<input type="hidden" name="info.id" value="<s:property value="infoId"/>" />
<!--list -->
<div class="mainAdd">
<table class="addTable">
  <tr>
    <th>标题:</th> 
	<td> <s:textarea name="title" id="title"></s:textarea><span id="titleTip"></span> </td>
  </tr>
  <tr>
    <th>选项:</th> 
	<td> <s:textarea name="options" id="options"></s:textarea><span id="optionsTip"></span> </td>
  </tr>
  <tr>
    <th></th> 
	<td>一行代表一个调查选项</td>
  </tr>
</table>
</div>
<!--end list -->
<div class="addToolbar">
    <p><button class="btn" type="submit"><b>确  定</b></button>
    <button class="btn" type="button" onclick="location.href='<s:url action="vote-list" namespace="/admin/information/vote"/>?restore_params=true'">返  回</button></p>
</div>
 
 </s:form>
</body>
</html>