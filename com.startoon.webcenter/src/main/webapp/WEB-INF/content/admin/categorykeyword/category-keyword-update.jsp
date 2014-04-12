<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>Title Here</title>

<link href="${ctx}/resources/css/admin.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/resources/js/jquery.js" type="text/javascript"></script>
<link href="${ctx}/resources/v2/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>

<script type="text/javascript"> 
$(document).ready(function(){

});
</script>

</head>

<body>
<div class="mTitle">
  <b class="bbig">类别关键词-关键词修改</b>
</div>
<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/admin/categorykeyword">
<s:hidden name="nextMethod" />
<s:hidden name="requestId" />
<s:hidden name="id" />
<s:hidden name="orderNo"  value="9999" />
<!--list -->
<div class="mainAdd">
<table class="addTable">
  <tr>
    <th>类别关键词名称：</th> 
	<td> <s:property value="category.name"/> </td>
  </tr>
  <tr>
    <th>关键词排名：</th> 
	<td> 第<s:property value="rank"/>位 </td>
  </tr>
  <tr>
    <th>基本价格：</th> 
	<td> <s:textfield name="minPrice" id="minPrice" size="30"></s:textfield><span id="minPriceTip"></span> </td>
  </tr>
  <tr>
    <th>3个月折扣价：</th> 
	<td> <s:textfield name="discount3" id="discount3" size="30"></s:textfield><span id="discount3Tip"></span> </td>
  </tr>
  <tr>
    <th>6个月折扣价：</th> 
	<td> <s:textfield name="discount6" id="discount6" size="30"></s:textfield><span id="discount6Tip"></span> </td>
  </tr>
  <tr>
    <th>12个月折扣价：</th> 
	<td> <s:textfield name="discount12" id="discount12" size="30"></s:textfield><span id="discount12Tip"></span> </td>
  </tr>
</table>
</div>
<!--end list -->
<div class="addToolbar">
    <p><button class="btn" type="submit"><b>submit</b></button>
    <button class="btn" type="button" onclick="location.href='<s:url action="category-keyword-list" namespace="/admin/categorykeyword"/>?restore_params=true'">cancel</button></p>
</div>
 
 </s:form>
</body>
</html>