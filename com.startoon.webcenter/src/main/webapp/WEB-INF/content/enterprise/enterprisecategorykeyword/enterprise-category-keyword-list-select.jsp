<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>Title Here</title>

<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/admin.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/thickbox.css"/>

<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/thickbox.js"></script>

<script type="text/javascript"> 
$(document).ready(function(){

	$(':checkbox[name=keywordId]').click(function() {
			$(':checkbox[name=keywordId]').attr('checked', false);
			$(this).attr('checked', true);
	});

	$('#modify').click(function() {
		var ck = $(':checkbox:checked');
		if(ck && ck.length>0) {
			$('#bindForm').submit();
		} else {
			alert('请选择要绑定关键字！');
		}

		return false;

	});
});
</script>

</head>

<body>
<div class="windowSize510" style="height: 280px;">
  <div class="windowTitle">
    <span class="window_close"><a href="javascript:void(null)" onclick="parent.tb_remove()" title="关闭" ><img src="${ctx}/resources/images/no.gif" /></a></span>
	<b>绑定关键字</b>
  </div>
  <div class="windowMain" style="padding-bottom:5px;">
  <s:form id="bindForm" name="bindForm" namespace="/enterprise/enterprisecategorykeyword" action="bind">
  <input type="hidden" name="supplyId" value="<s:property value="pager.paramCondition['supplyId']"/>" />
  
  <table class="listTable">
  <tr>
    <th>选择</th>
    <th>位置</th>
    <th>关键字</th>
    <th>购买价格</th>
    <th>购买时间</th>
    <th>到期日期</th>
  </tr>
  <s:iterator value="pager.items">
  <tr>
    <td><input name="keywordId" type="checkbox" value="<s:property value='id'/>" /></td>
    <td> 第<s:property value="categoryKeyword.rank"/>位 </td>
    <td> <s:property value="categoryKeyword.category.name"/> </td>
    <td> <s:property value="price"/>元 </td>
    <td> <s:date name="stime" format="yyyy-MM-dd"/> </td>
    <td> <s:date name="etime" format="yyyy-MM-dd"/> </td>
  </tr>
  </s:iterator>
  </table>
  </s:form>
<e:pagination></e:pagination>
</div>
<div class="windowBtn" style="padding-top:5px;">
  <a href="javascript:void(null)" onclick="parent.tb_remove()"><span class="btn">取&nbsp;消</span></a>
  <a href="javascript:void(null)" id="modify"><span class="btn">绑&nbsp;定</span></a>
</div>
  
</div>

</body>
</html>