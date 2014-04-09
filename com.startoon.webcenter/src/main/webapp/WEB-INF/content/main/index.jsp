<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>中国电信·知识管理平台</title>
<link href="${ctx}/resources/css/admin.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/resources/js/Geometry.js" type="text/javascript"></script>
<script src="${ctx}/resources/js/jquery.js" type="text/javascript"></script>
<script src="${ctx}/resources/js/thickbox.js" type="text/javascript"></script>
<script src="${ctx}/resources/js/leftMenu.js" type="text/javascript"></script>
<style type="text/css">
<!--
body{overflow-x:hidden; overflow-y:hidden; height:100%; margin:0; background-image: url(${ctx}/resources/images/admin_left_bg2.gif); background-repeat:repeat-y;} 
-->
</style> 
<script type="text/javascript">
var changeWidth = 224;

function chg(id_num){
         var oa = document.getElementById(id_num);
         var ob = document.getElementById("ImgArrow");
		 var imgButton = document.getElementById("imgButton");
         if(oa.style.display == "block"){
                 oa.style.display = "none";
                 imgButton.src = "${ctx}/resources/images/switch_right.gif";
				 imgButton.alt = "打开左侧导航栏";
				 changeWidth = 9;
         }else{
                 oa.style.display = "block";
                 imgButton.src = "${ctx}/resources/images/switch_left.gif";
				 imgButton.alt = "隐藏左侧导航栏";
				 changeWidth = 224;
         }
		 resizeIframe();
         return false;
}

function resizeAll(){
	resizeIframe();

}

function resizeIframe(){
	document.getElementById("mainFrame").height=Geometry.getViewportHeight()-67;
	document.getElementById("mainFrame").width = Geometry.getViewportWidth()-changeWidth;
	document.getElementById("menuLine").style.height=Geometry.getViewportHeight()-133+"px";
}

</script>

</head>
<body scroll="no" onresize="resizeAll();">
<div class="topBg">
  <div class="topRight">
    <div class="logo"><img src="${ctx}/resources/images/logo.gif" /></div>
    <div class="topInfo">
	  <div class="loginName">欢迎您：<b>admin</b>［<a href="admin.htm">系统首页</a>，<a href="index.htm">退出</a>］</div>
	  <div class="topMenu">
	    <a href="admin.htm"><b class="menuOn">知识管理平台</b></a>
	  </div>
	</div>
  </div>
</div>
<table class="mainTable" border="0" cellPadding="0" cellSpacing="0">
  <tr>
    <td class="left" id="leftNav" style="display:block;">
  <div class="leftTop">
  </div>
  <!--menu -->
  <div class="menuLine" id="menuLine">
  <ul id="menu">
	
	<li class="item"><a href="javascript:void(0)" target="mainFrame" class="title" name="1">后台管理</a>
	  <ul id="opt_1" class="optiton">
	    <li><a href="${pageContext.request.contextPath }/admin/category/category-list.action" target="mainFrame"><span class="icon_edit">&nbsp;</span>类别列表</a></li>
	  </ul>
	</li>
  </ul>
  </div>
  <!--end menu -->
	</td>
	<td class="center">
<div id="switchpic">
  <a href="javascript:void(0)" onClick="return chg('leftNav');" id="ImgArrow"><img src="${ctx}/resources/images/switch_left.gif" id ="imgButton" alt="隐藏左侧导航栏" /></a>
</div>	
	</td>
    <td class="right">
	<iframe src="welcome.jsp" name="mainFrame" width="100%" height="100%" scrolling-y="yes" scrolling-x="no" id="mainFrame" border="0" frameborder="0" onload="resizeIframe();"></iframe>
	</td>
  </tr>
</table>





</body>
</html>
