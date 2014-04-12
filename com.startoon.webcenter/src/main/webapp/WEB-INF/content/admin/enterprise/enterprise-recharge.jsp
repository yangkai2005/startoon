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
 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg);},onsuccess:function(){return true;}});

	$("#amount").formValidator({onshow:"请输入充值金额",onfocus:"金额不能为空",oncorrect:"输入正确"}).inputValidator({min:1,empty:{leftempty:false,rightempty:false,emptyerror:"金额两边不能有空格"},onerror:"金额不能为空,请确认"}).regexValidator({regexp:"num",datatype:"enum",onerror:"你输入的金额格式不正确，必须为数字"});

 	
 	$('#modify').click(function() {
		$('#form1').submit();
 	});
});
</script>

</head>

<body>
<div class="windowSize510">
  <div class="windowTitle">
    <span class="window_close"><a href="javascript:void(null)" onclick="parent.tb_remove()" title="关闭" ><img src="${ctx}/resources/images/no.gif" /></a></span>
	<b>后台充值</b>
  </div>
  <div class="windowMain">
  <s:form id="form1" namespace="/admin/enterprise" action="enterprise!recharge">
  <s:hidden name="requestId"></s:hidden>
  <s:hidden name="id"></s:hidden>
  <table class="windowTable">
  <tr>
    <th>待充值的会员：</th>
    <td><s:property value="enterprise.account"/></td>
  </tr>
  <tr>
    <th>充值金额：</th>
    <td><input id="amount" name="_amount" type="text" size="15" />元<span id="amountTip"></span> </td>
  </tr>
  </table>
  </s:form>
</div>
<div class="windowBtn">
  <a href="javascript:void(null)" onclick="parent.tb_remove()"><span class="btn">取&nbsp;消</span></a>
  <a href="javascript:void(null)" id="modify"><span class="btn">确    定</span></a>
</div>

  
</div>




</body>
</html>