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
	$(':radio[name=keywordType]').click(function() {
		var t = $(this).val();
		if(t==1) {
			var url = '${pageContext.request.contextPath }/enterprise/enterprisecategorykeyword/unbind.action?supplyId=<%=request.getParameter("supplyId") %>';
			window.location = url;
		} else {
			var url = '${pageContext.request.contextPath }/enterprise/supply/unbind.action?supplyId=<%=request.getParameter("supplyId") %>';
			window.location = url;
		}
	});
});
</script>

</head>

<body>
<div class="windowSize510" style="height: 280px;">
  <div class="windowTitle">
    <span class="window_close"><a href="javascript:void(null)" onclick="parent.tb_remove()" title="关闭" ><img src="../images/no.gif" /></a></span>
	<b>选择关键字类型 </b>
  </div>

  <div class="windowMain">
	  <table class="windowTable">
	  <tr>
	    <th>&nbsp;</th>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <th>&nbsp;</th>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <th>请选择关键字类型：</th>
	    <td><input type="radio" id="skeyword" name="keywordType" value="0" />产品关键字<input type="radio" id="ckeyword" name="keywordType" value="1" />类别关键字 <br/></td>
	  </tr>
	  <tr>
	    <th>&nbsp;</th>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <th>&nbsp;</th>
	    <td>&nbsp;</td>
	  </tr>
	  </table>
  </div>
  
  <div class="windowBtn">
  <a href="javascript:void(null)" onclick="parent.tb_remove()"><span class="btn">取&nbsp;消</span></a>
  </div>

  
</div>

</body>
</html>