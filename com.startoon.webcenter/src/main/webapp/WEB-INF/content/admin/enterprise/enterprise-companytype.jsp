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
 	$('#modify').click(function() {
		$('#companytypeForm').submit();
 	});
});
</script>

</head>

<body>
<div class="windowSize510">
  <div class="windowTitle">
    <span class="window_close"><a href="javascript:void(null)" onclick="parent.tb_remove()" title="关闭" ><img src="${ctx}/resources/images/no.gif" /></a></span>
	<b>请选择公司类型</b>
  </div>
  <div class="windowMain">
  <s:form id="companytypeForm" namespace="/admin/enterprise" action="enterprise!modifyComType">
  <s:hidden name="requestId"></s:hidden>
  <s:hidden name="id"></s:hidden>
  <table class="windowTable">
   <tr>
      <td align="center">&nbsp;
        </td>               
  </tr>
   <tr>
      <td align="center">
      <s:radio list="#{true:'动漫',false:'非动漫'}" name="cartoon" ></s:radio>      	
      </td>               
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