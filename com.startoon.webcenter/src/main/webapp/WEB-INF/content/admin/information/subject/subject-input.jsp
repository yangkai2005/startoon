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

<script type="text/javascript" src="${ctx}/resources/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"> 
$(document).ready(function(){
 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg)},onsuccess:function(){return true;}});
 	$("#name").formValidator({onshow:"请填写专题名称",onfocus:"请填写专题名称",oncorrect:""}).inputValidator({min:1,max:100,onerror:"专题名称不能为空"});
 	$("#ctime").formValidator({onshow:"请选择发布时间",onfocus:"请选择发布时间",oncorrect:""}).inputValidator({min:1,max:100,onerror:"你还没有选择发布时间"});
 	$("#orderNo").formValidator({onshow:"请填写专题排序",onfocus:"输入的数字越大，就越排前面",oncorrect:""}).inputValidator({min:1,max:100,onerror:"你还没有输入专题排序"});
});
</script>

</head>

<body>
<div class="mTitle">
  <b class="bbig">专题维护</b>
</div>
<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/admin/information/subject">
<s:hidden name="nextMethod" />
<s:hidden name="requestId" />
<s:hidden name="id" />
<!--list -->
<div class="mainAdd">
<table class="addTable">
  <tr>
    <th>专题名称:</th> 
	<td> <s:textfield name="name" id="name" size="30"></s:textfield><span id="nameTip"></span> </td>
  </tr>
  <tr>
    <th>发布日期:</th> 
	<td><s:textfield name="ctime" id="ctime" size="30" cssClass="Wdate" onfocus="WdatePicker()"><s:param name="value"><s:date name="ctime" format="yyyy-MM-dd"/></s:param> </s:textfield><span id="ctimeTip"></span> </td>
  </tr>
  <tr>
    <th>专题排序:</th> 
	<td> <s:textfield name="orderNo" id="orderNo" size="30"></s:textfield><span id="orderNoTip"></span> </td>
  </tr>
</table>
</div>
<!--end list -->
<div class="addToolbar">
    <p><button class="btn" type="submit"><b>提交</b></button>
    <button class="btn" type="button" onclick="location.href='<s:url action="subject-list" namespace="/admin/information/subject"/>?restore_params=true'">取消</button></p>
</div>
 
 </s:form>
</body>
</html>