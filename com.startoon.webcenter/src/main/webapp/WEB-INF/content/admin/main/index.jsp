<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>星力动漫·后台管理平台</title>
<link  href="${pageContext.request.contextPath }/resources/css/admin.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath }/resources/js/Geometry.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/resources/js/jquery.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/resources/js/thickbox.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/resources/js/leftMenu.js" type="text/javascript"></script>
<style type="text/css">
<!--
body{overflow-x:hidden; overflow-y:hidden; height:100%; margin:0; background-image: url(${pageContext.request.contextPath }/resources/images/admin_left_bg2.gif); background-repeat:repeat-y;} 
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
                 imgButton.src = "${pageContext.request.contextPath }/resources/images/switch_right.gif";
				 imgButton.alt = "打开左侧导航栏";
				 changeWidth = 9;
         }else{
                 oa.style.display = "block";
                 imgButton.src = "${pageContext.request.contextPath }/resources/images/switch_left.gif";
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
    <div class="logo"></div>
    <div class="topInfo">
	  <div class="loginName">欢迎您：<b><s:property value="#session.admin_user.account"/></b> [<a href="${pageContext.request.contextPath }/admin/logout.action">退出</a>] </div>
	  <div class="topMenu">
	    <a href="${pageContext.request.contextPath }/admin/main/index.jsp"><b class="menuOn">后台管理平台</b></a>
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
	<li class="item"><a href="javascript:void(0)" target="mainFrame" class="title" name="1">后台管理员维护</a>
	  <ul id="opt_1" class="optiton">
	  <s:iterator value="#session.admin_user.permission[1]">
	    <li><a href="<s:property value='path'/>" target="mainFrame"><span class="icon_list">&nbsp;</span><s:property value='name'/></a></li>
	  </s:iterator>
	  </ul>
	</li>
	<li class="item"><a href="javascript:void(0)" target="mainFrame" class="title" name="1">基本资料管理</a>
	  <ul id="opt_1" class="optiton">
	  <s:iterator value="#session.admin_user.permission[2]">
	    <li><a href="<s:property value='path'/>" target="mainFrame"><span class="icon_list">&nbsp;</span><s:property value='name'/></a></li>
	  </s:iterator>	  
	  </ul>
	</li>
	<li class="item"><a href="javascript:void(0)" target="mainFrame" class="title" name="1">B2B平台管理</a>
	  <ul id="opt_1" class="optiton">
	  <s:iterator value="#session.admin_user.permission[3]">
	    <li><a href="<s:property value='path'/>" target="mainFrame"><span class="icon_list">&nbsp;</span><s:property value='name'/></a></li>
	  </s:iterator>
	  </ul>
	</li>
	<li class="item"><a href="javascript:void(0)" target="mainFrame" class="title" name="1">资讯平台管理</a>
	  <ul id="opt_1" class="optiton">
	  <s:iterator value="#session.admin_user.permission[4]">
	    <li><a href="<s:property value='path'/>" target="mainFrame"><span class="icon_list">&nbsp;</span><s:property value='name'/></a></li>
	  </s:iterator>	    
	  </ul>
	</li>
  </ul>
  </div>
  <!--end menu -->
	</td>
	<td class="center">
	<div id="switchpic">
	  <a href="javascript:void(0)" onclick="return chg('leftNav');" id="ImgArrow"><img src="${pageContext.request.contextPath }/resources/images/switch_left.gif" id ="imgButton" alt="隐藏左侧导航栏" /></a>
	</div>	
	</td>
    <td class="right">
	<iframe src="${pageContext.request.contextPath }/admin/main/welcome.action" name="mainFrame" width="100%" height="100%" scrolling-y="yes" scrolling-x="no" id="mainFrame" border="0" frameborder="0" onload="resizeIframe();"></iframe>
	</td>
  </tr>
</table>


</body>
</html>
