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

	var msg = '${msg}';
	if(msg=="success"){
		alert('操作成功!');
	}
	
 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg)},onsuccess:function(){return true;}});
 	$("#name").formValidator({onshow:"",onfocus:"name can't empty",oncorrect:""}).inputValidator({min:1,max:100,onerror:"name can't empty"});
});
</script>

</head>

<body>
<div class="mTitle">
  <b class="bbig">帮助中心 - 添加文章</b>
</div>
<form id="form1" action="${pageContext.request.contextPath}/admin/help/help!insert.action" method="post">
<!--list -->
<div class="mainAdd">
<table class="addTable">
	<tr>
    <th>选择分类:</th> 
	<td> 
		<select name="classid" id="classid">
			<option value="">--请选择分类--</option>
           ${treeString}
		</select>
	 </td>
  </tr>
  <tr>
    <th>标题:</th> 
	<td> <s:textfield name="title" id="title" size="30"></s:textfield><span id="nameTip"></span> </td>
  </tr>
   <tr>
    <th>详细信息:</th> 
	<td>
    	<FCK:editor instanceName="content" height="350">
				<jsp:attribute name="value">
					${content }
				</jsp:attribute>
		</FCK:editor>	
	    <span id="contentTip"></span> </td>
  </tr>
</table>
</div>
<!--end list -->
<div class="addToolbar">
    <p><button class="btn" type="submit"><b>确定</b></button>
    <button class="btn" type="button" onclick="location.href='<s:url action="help-list" namespace="/admin/help"/>?restore_params=true'">返回</button></p>
</div>
 
 </form>
</body>
</html>