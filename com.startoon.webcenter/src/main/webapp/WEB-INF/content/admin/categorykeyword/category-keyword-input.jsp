<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>title here</title>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/admin.css"/>
<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/myfunction.js"></script>
<script type="text/javascript">
$(document).ready(function(){


	$('a[rel=delete]').click(function() {
		var index = $(this).arrt('lang');
		$(this).parent().parent().parent().find('input').each(function(e) {
			$(e).arrt('disabled', true);
		});;
		
	});

	$('a#submitBtn').click(function() {
		
		var b1 = validatePrice();
		var b2 = validateDiscount3();
		var b3 = validateDiscount6();
		var b4 = validateDiscount12();
		
		if(b1&&b2&&b3&&b4) {
			$('form').submit();
		}
		
	});
	$('a#cancelBtn').click(function() {
	});
});

function validatePrice() {
	var success = true;
	//表单校验
	$('input[name=prices]').each(function() {
		var v = $(this).val();
		if($.trim(v)=='') {
			alert('价格必填！');
			$(this).focus();
			success = false;
			return false;
		}
	});

	return success;
}

function validateDiscount3() {
	var success = true;
	//表单校验
	$('input[name=discounts3]').each(function() {
		var v = $(this).val();
		if($.trim(v)=='') {
			alert('3个月折扣必须填写！');
			$(this).focus();
			success = false;
			return false;
		}
	});

	return success;
}

function validateDiscount6() {
	var success = true;
	//表单校验
	$('input[name=discounts6]').each(function() {
		var v = $(this).val();
		if($.trim(v)=='') {
			alert('6个月折扣必须填写！');
			$(this).focus();
			success = false;
			return false;
		}
	});

	return success;
}

function validateDiscount12() {
	var success = true;
	//表单校验
	$('input[name=discounts12]').each(function() {
		var v = $(this).val();
		if($.trim(v)=='') {
			alert('一年的折扣必须填写！');
			$(this).focus();
			success = false;
			return false;
		}
	});

	return success;
}

</script>
</head>
<body>
<div class="mTitle">
  <b class="bbig">类别关键字定价</b>
</div>
 
<!--list -->
<s:form namespace="/admin/categorykeyword" action="%{actionName+'!'+nextMethod}">
<s:hidden name="nextMethod" />
<s:hidden name="requestId" />
<s:hidden name="id" />
<s:hidden name="cid" />
<div class="mainList">

<table class="listTable">
  <tr>
	<th>排名</th>
	<th>类别关键字</th>
	<th>价格</th>
	<th>3个月折扣</th>
	<th>6个月折扣</th>
	<th>1年折扣</th>
  </tr>
  <s:iterator status="st" begin="0" end="14">
  <tr>
  	<td> 第<s:property value="#st.count"/>名 </td>
  	<td> <s:property value="currentCategory.name"/> </td>
  	<td> <input id="price<s:property value="#st.count"/>" name="prices"/> </td>
  	<td> <input id="discount3<s:property value="#st.count"/>" name="discounts3"/> </td>
  	<td> <input id="discount6<s:property value="#st.count"/>" name="discounts6"/> </td>
  	<td> <input id="discount12<s:property value="#st.count"/>" name="discounts12"/> </td>
  </tr>
  </s:iterator>
</table>
</div>
<!--end list -->
<div class="Toolbar">
  <div class="toolBt">
 		<a href="javascript:void(0)" title="确定" id="submitBtn"><span class="btn">确定</span></a>
 		<a href="javascript:history.back();" title="取消" id="cancelBtn"><span class="btn">取消</span></a>
  </div>
  <e:pagination></e:pagination>
</div>
</s:form>
 
</body>
</html>