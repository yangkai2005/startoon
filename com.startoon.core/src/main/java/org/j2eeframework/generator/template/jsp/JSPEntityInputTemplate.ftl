<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>Title Here</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/admin.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/validator.css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/formValidator.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/formValidatorRegex.js"></script>

<script type="text/javascript"> 
$(document).ready(function(){
 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg)},onsuccess:function(){return true;}});
 	$("#name").formValidator({onshow:"",onfocus:"name can't empty",oncorrect:""}).inputValidator({min:1,max:100,onerror:"name can't empty"});
});
</script>

</head>

<body>
<div class="mTitle">
  <b class="bbig">EntityName</b>
</div>
<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="${namespace}">
<s:hidden name="nextMethod" />
<s:hidden name="requestId" />
<s:hidden name="id" />
<!--list -->
<div class="mainAdd">
<table class="addTable">
  <tr>
    <th>name:</th> 
	<td> <s:textfield name="name" id="name" size="30"></s:textfield><span id="nameTip"></span> </td>
  </tr>
</table>
</div>
<!--end list -->
<div class="addToolbar">
    <p><button class="btn" type="submit"><b>submit</b></button>
    <button class="btn" type="button" onclick="location.href='<s:url action="${listActionName}" namespace="${namespace}"/>?restore_params=true'">cancel</button></p>
</div>
 
 </s:form>
</body>
</html>