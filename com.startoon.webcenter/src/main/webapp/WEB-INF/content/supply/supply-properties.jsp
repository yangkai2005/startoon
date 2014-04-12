<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>星力网</title>

<link rel="stylesheet" type="text/css" href="${ctx}/css/index.css" />
<script type="text/javascript" src="${ctx}/js/cn_main.js"></script>

</head>

<body>
<div id="popmenu" class="menuskin" style="visibility: visible; ">
  <div id="tank1">
    <div class="tanktd1">
      <div class="tt1" id="li_1">参数信息 </div>
    </div>
    <div class="tanktd2">
      <div class="tancontent" id="div1">
	   <s:iterator value="supplyParams">
	   <s:property value="pkey"/>:<s:property value="pvalue"/><br/>
	   </s:iterator>
      </div>
    </div>
    <div class="tanktd3">&nbsp;</div>
  </div>
</div>
</body>
</html>