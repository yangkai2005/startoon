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
 	$.formValidator.initConfig({formid:"passwordForm",onerror:function(msg){alert(msg);},onsuccess:function(){return true;}});

	$("#minPrice").formValidator({onshow:"请输入一个月基本价",onfocus:"基本价不能为空",oncorrect:"输入正确"})
		.inputValidator({min:1,empty:{leftempty:false,rightempty:false,emptyerror:"基本价两边不能有空符号"},onerror:"基本价不能为空,请确认"})
		.regexValidator({regexp:"decmal1",datatype:"enum",onerror:"格式不正确"});

	$("#discount3").formValidator({onshow:"请输入三个月折扣，如：5.5 代表5.5折",onfocus:"折扣不能为空",oncorrect:"输入正确"})
		.inputValidator({min:1,empty:{leftempty:false,rightempty:false,emptyerror:"折扣两边不能有空符号"},onerror:"折扣不能为空,请确认"})
		.regexValidator({regexp:"decmal1",datatype:"enum",onerror:"格式不正确"});

	$("#discount6").formValidator({onshow:"请输入六个月折扣，如：5.5 代表5.5折",onfocus:"折扣不能为空",oncorrect:"输入正确"})
		.inputValidator({min:1,empty:{leftempty:false,rightempty:false,emptyerror:"折扣两边不能有空符号"},onerror:"折扣不能为空,请确认"})
		.regexValidator({regexp:"decmal1",datatype:"enum",onerror:"格式不正确"});

	$("#discount12").formValidator({onshow:"请输入一年折扣，如：5.5 代表5.5折",onfocus:"折扣不能为空",oncorrect:"输入正确"})
		.inputValidator({min:1,empty:{leftempty:false,rightempty:false,emptyerror:"折扣两边不能有空符号"},onerror:"折扣不能为空,请确认"})
		.regexValidator({regexp:"decmal1",datatype:"enum",onerror:"格式不正确"});

	$("#stepPrice").formValidator({onshow:"请输入递增价",onfocus:"递增价不能为空",oncorrect:"输入正确"})
		.inputValidator({min:1,empty:{leftempty:false,rightempty:false,emptyerror:"递增价两边不能有空符号"},onerror:"递增价不能为空,请确认"})
		.regexValidator({regexp:"decmal1",datatype:"enum",onerror:"格式不正确"});
	
	//$("#maxPrice").formValidator({onshow:"请输入最高价",onfocus:"最高价不能为空",oncorrect:"输入正确"}).inputValidator({min:1,empty:{leftempty:false,rightempty:false,emptyerror:"最高价两边不能有空符号"},onerror:"最高价不能为空,请确认"});
	//$("#etime").formValidator({onshow:"请输入有效期",onfocus:"有效期不能为空",oncorrect:"输入正确"}).inputValidator({min:1,empty:{leftempty:false,rightempty:false,emptyerror:"有效期两边不能有空符号"},onerror:"有效期不能为空,请确认"});

 	
 	$('#submitBtn').click(function() {
		$('#form1').submit();
 	});
});
</script>

</head>

<body>
<div class="windowSize510" style="height: 250px">
  <div class="windowTitle">
    <span class="window_close"><a href="javascript:void(null)" onclick="parent.tb_remove()" title="关闭" ><img src="${ctx}/resources/images/no.gif" /></a></span>
	<b>竞价设置</b>
  </div>
  <div class="windowMain">
  <s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/admin/categorykeyword">
	<s:hidden name="nextMethod" />
	<s:hidden name="requestId" />
	<input type="hidden" name="id" value="<s:property value='categoryKeyword.id'/>" />
	<input type="hidden" name="category.id" value="<s:property value='cid'/>" />
  <table class="windowTable">
  <tr>
    <th>基本价：</th>
    <td> <input type="text" id="minPrice" name="minPrice"  value="<s:property value='categoryKeyword.minPrice'/>"/><span id="minPriceTip"></span> </td>
  </tr>
  <tr>
  	<th>递增价：</th>
    <td><input type="text" id="stepPrice" name="stepPrice"  value="<s:property value='categoryKeyword.stepPrice'/>"/><span id="stepPriceTip"></span></td>
  </tr>
  <tr>
  	<th>3个月折扣：</th>
    <td><input type="text" id="discount3" name="discount3"  value="<s:property value='categoryKeyword.discount3'/>"/><span id="discount3Tip"></span></td>
  </tr>
  <tr>
  	<th>6个月折扣：</th>
    <td><input type="text" id="discount6" name="discount6"  value="<s:property value='categoryKeyword.discount6'/>"/><span id="discount6Tip"></span></td>
  </tr>
  <tr>
  	<th>1年折扣：</th>
    <td><input type="text" id="discount12" name="discount12"  value="<s:property value='categoryKeyword.discount12'/>"/><span id="discount12Tip"></span></td>
  </tr>
  </table>
  </s:form>
</div>
<div class="windowBtn">
  <a href="javascript:void(null)" onclick="parent.tb_remove()"><span class="btn">取&nbsp;消</span></a>
  <a href="javascript:void(null)" id="submitBtn"><span class="btn">确&nbsp;定</span></a>
</div>

</div>




</body>
</html>