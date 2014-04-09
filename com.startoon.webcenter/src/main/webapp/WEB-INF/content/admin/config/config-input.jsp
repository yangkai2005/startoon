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
 	$("#skey").formValidator({onshow:"",onfocus:"键不能为空",oncorrect:""}).inputValidator({min:1,max:100,onerror:"键不能为空"});
 	$("#svalue").formValidator({onshow:"",onfocus:"值不能为空",oncorrect:""}).inputValidator({min:1,max:100,onerror:"值不能为空"});
});
</script>

</head>

<body>
<div class="mTitle">
  <b class="bbig">配置管理</b>
</div>
<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/admin/config">
<s:hidden name="nextMethod" />
<s:hidden name="requestId" />
<s:hidden name="id" />
<!--list -->
<div class="mainAdd">
<table class="addTable">
  <tr>
    <th>键：</th> 
	<td> <s:textfield name="skey" id="skey" size="30"></s:textfield><span id="skeyTip"></span> </td>
  </tr>
   <th>值：</th> 
	<td> <s:textfield name="svalue" id="svalue" size="30"></s:textfield><span id="svalueTip"></span> </td>
  </tr>
  <tr>
    <th>描述：</th> 
	<td> <s:textarea name="depict" id="desc" ></s:textarea><span id="descTip"></span> </td>
  </tr>
</table>
</div>
<!--end list -->
<div class="addToolbar">
    <p><button class="btn" type="submit"><b>submit</b></button>
    <button class="btn" type="button" onclick="location.href='<s:url action="config-list" namespace="/admin/config"/>?restore_params=true'">cancel</button></p>
</div>
 
 </s:form>
</body>
</html>