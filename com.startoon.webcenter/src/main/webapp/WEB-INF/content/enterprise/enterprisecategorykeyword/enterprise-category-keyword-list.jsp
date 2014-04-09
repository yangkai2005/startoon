<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="org.j2eeframework.commons.pager.Pager"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="keywords" content="星力网，游戏机供应，游戏机采购，动漫游戏资讯，动漫游戏展会，卖游戏机"/>
<meta http-equiv="description" content="星力网是广州星力动漫科技有限公司打造的动漫游戏行业最专业的游戏机供应、游戏机采购平台，提供最新、最全的游艺产品、游戏产品、电玩产品、游戏机配件、电脑板、框体机、模拟机等供应信息、采购信息，星力网资讯频道为行业提供最专业的动漫游戏行业资讯、行业新闻。"/>
<title>星力网_中国动漫游艺门户_动漫游戏产品网络交易平台_动漫游戏行业资讯</title>

<link rel="stylesheet" type="text/css" href="${ctx}/css/member.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />

<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery.example.min.js"></script>

<script type="text/javascript">
$(function(){
	$('h2#keyword2').addClass('q3');
	
	$('a[rel=bind]').click(function() {
		var id = $(this).attr('id');
		$.post('${ctx}/enterprise/enterprisekeyword/enterprise-keyword!bindToEnt.action', {kid: id}, function(data) {if(data=='success') {alert('该关键字已经绑定成功！');}});
		});
});
</script>

</head>
<body>
<s:include value="/WEB-INF/content/inc/header.jsp"/>

<div class="member">
	<s:include value="/WEB-INF/content/inc/member-left.jsp"/>
	<%-- 列表管理 --%>
<div class="memright">
	 
	<s:include value="/WEB-INF/content/enterprise/categorykeyword/menu.jsp"></s:include>
	 
	<div class="memcon">
	 	
	<div class="sicon2">
	<div class="sitab">
	<table width="100%" border="0" cellspacing="0" bgcolor="#d7e2ec" class="sitable">
	  <tbody>
	  <tr>
	    <th width="5%" class="noleft">位置</th>
	    <th width="10%">关键字</th>
	    <th width="8%">购买价格</th>
	    <th width="5%">折扣</th>
	    <th width="8%">购买期限</th>
	    <th width="8%">购买总价</th>
	    <th width="10%">购买时间</th>
	    <th width="10%">到期时间</th>
	  </tr>
	  <s:iterator value="pager.items">
	  <tr>
	    <td class="noleft tdlist"> 第<s:property value="categoryKeyword.rank"/>位 </td>
	    <td class="tdlist" style="text-align: center;"><s:property value="categoryKeyword.category.name"/></td>
	    <td> <s:property value="price"/>元/月</td>
	    <td> <s:property value="discount"/>折</td>
	    <td> <s:property value="amount"/>个月</td>
	    <td> <s:property value="totalPrice"/>元</td>
	    <td><s:date name="stime" format="yyyy-MM-dd"/></td>
	    <td> <s:date name="etime" format="yyyy-MM-dd"/> </td>
	  </tr>
	  </s:iterator>
	</tbody>
	</table>
	</div>
	<div class="pagessi"><e:pagination></e:pagination> </div>		
	</div>
	 
	 
	</div>

</div>	
	<%-- 列表管理 --%>
</div>

<div class="cls"></div>
<div style="clear:both;"></div>

<s:include value="/WEB-INF/content/inc/footer.jsp"/>
</body>
</html>