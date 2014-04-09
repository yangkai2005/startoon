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
 	$.formValidator.initConfig({formid:"passwordForm",onerror:function(msg){alert(msg);},onsuccess:function(){return true;}});

	$("#password1").formValidator({onshow:"请输入密码",onfocus:"密码不能为空",oncorrect:"密码合法"}).inputValidator({min:5,empty:{leftempty:false,rightempty:false,emptyerror:"密码两边不能有空符号"},onerror:"密码不能为空,请确认"});
	$("#password2").formValidator({onshow:"请输入重复密码",onfocus:"两次密码必须一致哦",oncorrect:"密码一致"}).inputValidator({min:5,empty:{leftempty:false,rightempty:false,emptyerror:"重复密码两边不能有空符号"},onerror:"重复密码不能为空,请确认"}).compareValidator({desid:"password1",operateor:"=",onerror:"2次密码不一致,请确认"});

 	
 	$('#modify').click(function() {
		$('#passwordForm').submit();
 	});
});
</script>

</head>

<body>
<div class="windowSize510">
  <div class="windowTitle">
    <span class="window_close"><a href="javascript:void(null)" onclick="parent.tb_remove()" title="关闭" ><img src="${ctx}/resources/images/no.gif" /></a></span>
	<b>重置密码</b>
  </div>
  <div class="windowMain">
  <s:form id="passwordForm" namespace="/admin/enterprise" action="enterprise!modifyPwd">
  <s:hidden name="requestId"></s:hidden>
  <s:hidden name="id"></s:hidden>
  <table class="windowTable">
  <tr>
    <th>密码：</th>
    <td><input id="password1" name="password" type="password" size="15" /><span id="password1Tip"></span> </td>
  </tr>
  <tr>
  	<th>重复密码：</th>
    <td><input id="password2" name="repassword" type="password" size="15" /><span id="password2Tip"></span></td>
  </tr>
  </table>
  </s:form>
</div>
<div class="windowBtn">
  <a href="javascript:void(null)" onclick="parent.tb_remove()"><span class="btn">取&nbsp;消</span></a>
  <a href="javascript:void(null)" id="modify"><span class="btn">确定修改</span></a>
</div>

  
</div>




</body>
</html>