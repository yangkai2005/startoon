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

});
</script>

</head>

<body>
<div class="mTitle">
  <b class="bbig">角色权限维护</b>
</div>
<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/admin/rolerefpermission">
<s:hidden name="nextMethod" />
<s:hidden name="requestId" />
<s:hidden name="id" />
<input type="hidden" name="roleId" value="<s:property value="currentRole.id"/>" />

<!--list -->
<div class="mainAdd">
<table class="addTable">
  <tr>
  	<th></th>
    <td><b class="bbig"><s:property value="currentRole.name"/></b> </td> 
  </tr>
  <tr>
    <th>后台管理员维护：</th>
    <td> <s:checkboxlist list="permissionMap[1]" listKey="id" listValue="name" name="permissionId"></s:checkboxlist></td> 
  </tr>
  <tr>
    <th>基本资料管理：</th> 
	<td> <s:checkboxlist list="permissionMap[2]" listKey="id" listValue="name" name="permissionId"></s:checkboxlist></td>
  </tr>
  <tr>
    <th>B2B平台管理：</th> 
	<td> <s:checkboxlist list="permissionMap[3]" listKey="id" listValue="name" name="permissionId"></s:checkboxlist></td>
  </tr>
  <tr>
    <th>资讯平台管理：</th> 
	<td> <s:checkboxlist list="permissionMap[4]" listKey="id" listValue="name" name="permissionId"></s:checkboxlist></td>
  </tr>
</table>
</div>
<!--end list -->
<div class="addToolbar">
    <p><button class="btn" type="submit"><b>submit</b></button>
    <button class="btn" type="button" onclick="location.href='<s:url action="role-list" namespace="/admin/role"/>?restore_params=true'">cancel</button></p>
</div>
 
 </s:form>
</body>
</html>