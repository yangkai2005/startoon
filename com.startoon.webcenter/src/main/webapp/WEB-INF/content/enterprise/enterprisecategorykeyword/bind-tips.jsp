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
});
</script>

</head>

<body>
<div class="windowSize510" style="height: 280px;">
  <div class="windowTitle">
    <span class="window_close"><a href="javascript:void(null)" onclick="parent.tb_remove()" title="关闭" ><img src="../images/no.gif" /></a></span>
	<b>关键字绑定</b>
  </div>
  
  <div class="windowMain" style="height: 190px;">
	<s:if test="%{errorMsg!=null}">
    <div class="delicon"></div>
	<div class="delInfo">
	<s:property value="errorMsg" escape="HTML"/><br />
	</div>	
	</s:if>
	
  	<s:else>
    <div class="editOKicon"></div>
	<div class="editOKInfo">
	关键字已经成功绑定到产品！请点击【确定】按钮关闭窗口！<br />
	</div>
  	</s:else>
  </div>
  
  <div class="windowBtn">
  <a href="javascript:void(null)" onclick="parent.tb_remove()"><span class="btn">确&nbsp;定</span></a>
  </div>

  
</div>

</body>
</html>