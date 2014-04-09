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

<link rel="stylesheet" type="text/css" href="${ctx}/css/index.css" />

<script language="javascript1.1" type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>


</head>

<body>

<%-- header --%>
<s:include value="/inc/header.jsp"></s:include>
<%-- header --%>

<div class="main">
<div class="title4" style="height:1px; margin-bottom:15px;"></div>



<div class="kuleft">
<h1>
<s:action namespace="/inc" name="category-left" executeResult="true" ></s:action>
</h1>

</div>
<div class="kuright">
<s:form namespace="/enterprises" action="enterprise-list">
<h1>
<p><strong>选择分类</strong>：<select name="businessIds" style="width:160px;">
								<option>--请选择--</option>
								<s:iterator value="categories"><option value="<s:property value="id"/>"><s:property value="name"/></option></s:iterator>
							  </select></p>
<p><strong>企业名称</strong>：<input name="name" type="text" class="txtqy1"/></p>
<p><strong>企业地址</strong>：<input name="address" type="text" class="txtqy1"/></p>
</h1>
</s:form>
<div class="cls"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="kutable">
  <tbody>
  <s:iterator value="categories">
	  <tr bgcolor="#fffef1">
	    <td width="17%" class="tdbt"><s:property value="name" /></td>
	    <td width="75%">
	    	<s:iterator value="enterprises">
	    	<a href="${ctx}/enterprises/ent-index.action?enterpriseId=<s:property value='id'/>"><s:property value="name"/></a>
	    	</s:iterator>
	    </td>
	    <td width="8%"><a href="${ctx}/enterprises/enterprise-list.action?businessIds=<s:property value='id'/>&t=1">更多</a></td>
	  </tr>
  </s:iterator>
  </tbody>
</table>


</div>
  
 <div class="cls"></div>

</div>  
  
<%-- footer --%>
<s:include value="/inc/footer.jsp"/>
<%-- footer --%>
	
</body>
</html>