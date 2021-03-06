<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="keywords" content="星力网，游戏机供应，游戏机采购，动漫游戏资讯，动漫游戏展会，卖游戏机"/>
<meta http-equiv="description" content="星力网是广州星力动漫游戏产业园打造的动漫游戏行业最专业的游戏机供应、游戏机采购平台，提供最新、最全的游艺产品、游戏产品、电玩产品、游戏机配件、电脑板、框体机、模拟机等供应信息、采购信息，星力网资讯频道为行业提供最专业的动漫游戏行业资讯、行业新闻。"/>
<title>星力网_中国动漫游艺门户_动漫游戏产品网络交易平台_动漫游戏行业资讯</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/member.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />
<script src="${ctx}/resources/js/jquery.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/js/nav.js"></script>

<link href="${ctx}/resources/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>

<script type="text/javascript"> 
$(function(){
	$('h2#zp').addClass('q3');
});
</script>
</head>

<body>

<%-- header --%>
<s:include value="/WEB-INF/content/inc/header.jsp"></s:include>
<%-- header --%>
		

<div class="cls"></div>


<!--main star-->
<div class="main">

<div class="member">
<%-- left --%>
<s:include value="/WEB-INF/content/inc/member-left.jsp"></s:include>
<%-- left --%>

<%-- main begin --%>
<div class="memright">
	
	<s:include value="/WEB-INF/content/enterprise/hrservice/menu.jsp"/>
	 
	<div class="memcon">
	 	
		<div class="sicon2" style="border-bottom:0">

		
		<div class="sitab">
		<table width="100%" border="0" cellspacing="0" bgcolor="#d7e2ec" class="sitable">
  <tbody><tr>
    <th width="20%" class="noleft" style="text-align:left; padding-left:20px;"><span class="red">招聘职位名称</span></th>
    <th width="30%"><span class="red">工作地点</span></th>
    <th width="10%"><span class="red">发布日期</span></th>
    <th width="8%"><span class="red">状态</span></th>
    <th ><span class="red">原因</span></th>
    <th width="10%"><span class="red">操作</span></th>
  </tr>
  <s:iterator value="pager.items">
  <tr>
    <td class="noleft tdlist"><s:property value="name" /></td>
    <td><s:property value="workAddress" /></td>
    <td> <s:date name="createTime" format="yyyy-MM-dd"/> </td>
    <td> <s:if test="status==1"><font color="red">冻结</font></s:if><s:else>发布</s:else> </td>
    <td><s:property value="freezeDesc" /></td>
    <td>
    	<%--
	    <a href="<s:url namespace="/enterprise/hrservice" action="jobs!publish"/>?requestId=<s:property value="id"/>">发布</a>
	    <a href="<s:url namespace="/enterprise/hrservice" action="jobs!show"/>?requestId=<s:property value="id"/>" target="_blank">预览</a>
    	 --%>
	    <a href="<s:url namespace="/enterprise/hrservice" action="jobs!edit"/>?requestId=<s:property value="id"/>">修改</a>
	    <a href="<s:url namespace="/enterprise/hrservice" action="jobs!delete"/>?requestId=<s:property value="id"/>">删除</a>
    </td>
  </tr>
  </s:iterator>
</tbody>
</table>
</div>
<e:pagination></e:pagination>
		</div>
	 
	</div>

</div>
<%-- main begin --%>
</div>

<div class="cls"></div>
  
<%-- footer --%>
<s:include value="/WEB-INF/content/inc/footer.jsp"/>
<%-- footer --%>	
</body>
</html>