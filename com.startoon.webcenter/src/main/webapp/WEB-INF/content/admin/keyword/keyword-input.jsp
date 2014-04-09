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
	
 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg);},onsuccess:function(){return true;}});
 	$("#name").formValidator({onshow:"请输入关键词",onfocus:"关键词不能为空",oncorrect:"输入正确"}).inputValidator({min:1,max:100,onerror:"关键词不能为空"});
 	$("#minPrice").formValidator({onshow:"请输入最低价",onfocus:"最低价不能为空",oncorrect:"输入正确"}).inputValidator({min:1,max:100,onerror:"最低价不能为空"}).regexValidator({regexp:"decmal1", datatype: "enum",onerror:"你输入的最低价格式不正确"});
 	$("#maxPrice").formValidator({onshow:"请输入最高价",onfocus:"最高价不能为空",oncorrect:"输入正确"}).inputValidator({min:1,max:100,onerror:"最高价不能为空"}).regexValidator({regexp:"decmal1", datatype: "enum",onerror:"你输入的最高价格式不正确"});
 	$("#stepPrice").formValidator({onshow:"请输入递增价",onfocus:"递增价不能为空",oncorrect:"输入正确"}).inputValidator({min:1,max:100,onerror:"递增价不能为空"}).regexValidator({regexp:"decmal1", datatype: "enum",onerror:"你输入的递增价格式不正确"});
 	$("#deadTime").formValidator({onshow:"请输入到期日期",onfocus:"到期日期不能为空",oncorrect:"输入正确"}).inputValidator({min:1,max:100,onerror:"到期日期不能为空"});
 	
});
</script>
</head>

<body>

<div class="mTitle">
  <b class="bbig">关键词维护</b>
</div>
<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/admin/keyword">
<s:hidden name="nextMethod" />
<s:hidden name="requestId" />
<s:hidden name="id" />
<!--list -->
<div class="mainAdd">
<table class="addTable">
  <tr>
    <th>关键词:</th> 
	<td> <s:textfield name="keyword" id="name" size="30"></s:textfield><span id="nameTip"></span> </td>
  </tr>
  <tr>
    <th>最低价:</th> 
	<td> <s:textfield name="minPrice" id="minPrice" size="30"></s:textfield><span id="minPriceTip"></span> </td>
  </tr>
  <tr>
    <th>最高价:</th> 
	<td> <s:textfield name="maxPrice" id="maxPrice" size="30"></s:textfield><span id="maxPriceTip"></span> </td>
  </tr>
  <tr>
    <th>递增价:</th> 
	<td> <s:textfield name="stepPrice" id="stepPrice" size="30"></s:textfield><span id="stepPriceTip"></span> </td>
  </tr>
  <%-- 
  <tr>
    <th>到期日期:</th> 
	<td> <s:textfield name="deadTime" id="deadTime" size="30" cssClass="Wdate" onfocus="WdatePicker({minDate:'%y-%M-#{%d+1}'})" readonly="true" > <s:param name="value"><s:date name="deadTime" format="yyyy-MM-dd"/></s:param>  </s:textfield><span id="deadTimeTip"></span> </td>
  </tr>
  --%>
  <tr>
    <th>描述:</th> 
	<td> <s:textarea name="description" id="description" ></s:textarea><span id="descriptionTip"></span> </td>
  </tr>
</table>
</div>
<!--end list -->
<div class="addToolbar">
    <p><button class="btn" type="submit"><b>提  交</b></button>
    <button class="btn" type="button" onclick="location.href='<s:url action="keyword-list" namespace="/admin/keyword"/>?restore_params=true'">返  回</button></p>
</div>
 
 </s:form>
</body>
</html>
<s:property value="message" escape="html"/>