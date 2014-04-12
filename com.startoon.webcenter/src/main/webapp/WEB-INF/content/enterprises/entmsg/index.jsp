<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="keywords" content="${entInfo.enterprise.name},星力网，游戏机供应，游戏机采购，动漫游戏资讯，动漫游戏展会，卖游戏机"/>
<meta http-equiv="description" content="${entInfo.enterprise.name},星力网是广州星力动漫游戏产业园打造的动漫游戏行业最专业的游戏机供应、游戏机采购平台，提供最新、最全的游艺产品、游戏产品、电玩产品、游戏机配件、电脑板、框体机、模拟机等供应信息、采购信息，星力网资讯频道为行业提供最专业的动漫游戏行业资讯、行业新闻。"/>
<title>${entInfo.enterprise.name}_星力网_中国动漫游艺门户_动漫游戏产品网络交易平台_动漫游戏行业资讯</title>

<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/tool.js"></script>
<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/storefronts.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />
<script type="text/javascript">
<!--
function doFavorite(){
	var url = "${pageContext.request.contextPath}/enterprise/favorite/favorite!add.action";
	 var html = $.ajax({
		  url: url,
		  data:"fid=${enterpriseId}&type=2&t="+new Date().getTime(),
		  async: false
		 }).responseText;
	 if (html=="success"){
		 alert('恭喜,收藏成功!');
	 } 
}

$(function(){
	
	$('#submitBtn').click(function() {
		var flag = doSubmit();
		
		if(flag){
			var name= $.trim($("#creatorName").val());
			var contact = $.trim($("#contact").val());
			var email= $.trim($("#email").val());
			var content = $.trim($("#content").val());
			var eid = $.trim($("#enterpriseId").val());
			//$('form[name=form1]').submit();
			$.ajax({
				   type: "POST",
				   url: "${pageContext.request.contextPath}/enterprises/entmsg/ent-msg!doInsert.action",
				   data: "creatorName="+name+"&contact="+contact+"&email="+email+"&content="+content+"&enterpriseId="+eid,
				   success: function(msg){
				     if(parseInt(msg)==0){
				    	 alert('留言成功，请等待管理员审核！');
				    	 clearSearch();
				     }else{
				    	 alert('留言失败，请稍后再试！');
				     }
				   }
				}); 
		}
	});
	
	$('#cancelBtn').click(function() {
		$('form[name=form1]').reset();
	});
});

function doSubmit(){
	var form = document.form1;

	if(isNull($$("creatorName"),"姓名"))return false;
	if(isNull($$("contact"),"联系方式"))return false;
	if(isNull($$("email"),"E-mail"))return false;
	if(checkEmail($$("email"),"E-mail"))return false;
	if(isNull($$("content"),"留言"))return false;
	return true;
}


//-->
</script>
</head>

<body>

<s:include value="/WEB-INF/content/inc/nav.jsp"></s:include>

<div id="wrap">
	<div class="ban">   		  
		<s:include value="/WEB-INF/content/enterprises/banner.jsp"></s:include>
	</div>

<div class="cls"></div>

<div class="curr">您${flag}-当前的位置：<a href="${ctx}/index.action">首 页</a> &gt; <a href="${ctx}/enterprises/ent-index.action?enterpriseId=<s:property value="enterprise.id"/>"><s:property value="enterprise.name"/></a> &gt; 公司首页</div>

<!--main star-->
<div class="main">

<!-- //left star-->
<s:include value="/WEB-INF/content/inc/ent-left.jsp"></s:include>
<!-- //left over-->


<!-- //right star-->
<div class="right">
 <div class="title3">
 <div class="titlemu">
	<h1>
	在线留言
	</h1>

 </div>
 </div>
 <div class="cls"></div>
 <div class="liutxt">
        <div class="liulink">
              <ul>
              <s:iterator value="pager.items">
                <li>
                   <div class="ltitle"><span class="zs">作者：</span><s:property value="creatorName"/>&nbsp;<span class="zs">回复日期：</span><s:date name="ctime" format="yyyy-MM-dd HH:mm" /></div>
                   <div class="ltxt"><s:property value="content"/></div>
                </li>
              </s:iterator>
              </ul>
        </div>
        <div class="cls"></div>
        <div class="lpage"><e:pagination/></div>
       <div class="cls"></div>
       <div class="liu_tb">
       <div class="liutitle">我要留言</div>
       
<form id="form1" name="form1" action="${pageContext.request.contextPath}/enterprises/entmsg/ent-msg!insert.action" method="post">
       
       <s:hidden name="enterpriseId" id="enterpriseId"></s:hidden>
       <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tb_liuyan">
              <tr>
                <td width="30%" class="td_l" style="vertical-align:top">姓名：</td>
                <td width="70%">
                  <input type="text" name="creatorName" id="creatorName" class="iptxt" /><font color="red">*</font>
                </td>
              </tr>
              <tr>
                <td class="td_l" style="vertical-align:top">所在地区：</td>
                <td>  <input type="text" name="area" id="area" class="iptxt" /></td>
              </tr>
              <tr>
                <td class="td_l" style="vertical-align:top">联系方式：</td>
                <td><input type="text" name="contact" id="contact" class="iptxt" /><font color="red">*</font></td>
              </tr>
              <tr>
                <td class="td_l" style="vertical-align:top">E-mail：</td>
                <td><input type="text" name="email" id="email" class="iptxt" /><font color="red">*</font></td>
              </tr>
              <tr>
                <td class="td_l" style="vertical-align:top">留言：</td>
                <td><input type="text" name="content" id="content" class="iptxt1" /><font color="red">*</font></td>
              </tr>
              <tr>
                <td colspan="2" style="padding-left:400px;">
                	<a href="javascript:void(0)" id="submitBtn"><img src="${ctx}/images/bt_liuyan.jpg" width="87" height="28" /></a>
                	<a href="javascript:void(0)" id="cancelBtn"><img src="${ctx}/images/bt_cz.jpg" width="87" height="28" /></a>
                </td>
              </tr>
            </table>
</form>
</div>
 
 </div>
 
</div>
<!-- //right over-->

</div>
<div class="cls"></div>
<%-- footer begin --%>
<s:include value="/WEB-INF/content/inc/copyright.jsp"></s:include>
<%-- footer begin --%>
</body>
</html>