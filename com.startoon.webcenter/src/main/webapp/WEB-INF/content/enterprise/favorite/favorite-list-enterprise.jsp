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

<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>

<script type="text/javascript"> 
$(document).ready(function(){

	$('#enterprise').addClass('q3');
	
	$(":hidden[name=shortDesc]").each(function() {
		var desc = $(this).val();
		var desc1 = $(desc).text();
		$(this).parent().prepend(desc1);
	});


	 $('#checkAll').click(function() {
		 var ck = $(this).attr('checked');
		 $(':checkbox[name=ids]').attr('checked', ck);
	 });
	 
	$('#deleteAllBtn').click(function() {
		 
		var cks = $(':checkbox[name=ids]:checked');
							if (cks && cks.length > 0) {
								if (confirm("确定要删除选中的数据吗?")) {
									$('#delForm').submit();
								}

							} else {
								alert('你还没有选择要删除的数据！');
							}
	});

});
</script>

</head>
<body>
<s:include value="/WEB-INF/content/inc/header.jsp"/>
<s:include value="/WEB-INF/content/inc/member-left.jsp"/>

<%-- 列表管理 --%>
<div class="memright">
	<s:include value="/WEB-INF/content/enterprise/favorite/menu.jsp"/>
	 
	<div class="memcon2">
		<div class="gy1">
		</div>
		<div class="gy2">
		<div class="bggy">
		<table width="100%" border="0" class="memcontable2" cellspacing="0">
		  <tr>
		  <th width="7%"><input name="checkAll" id="checkAll" type="checkbox" value="" />全选</th>
		    <th>企业名称</th>
		    <th width="20%">主营业务</th>
		    <th width="10%">收藏时间</th>
		    <th width="13%">操作</th>
		  </tr>
		  
		<s:form id="delForm" name="delForm" namespace="/enterprise/favorite" action="favorite!deleteAll">
		  <s:iterator value="pager.items">
			  <tr>
			  	<td style=" border-left:0; text-align:left; padding-left:5px;"><input name="ids" type="checkbox" value='<s:property value="id" />' /></td>
			    <td><s:property value="ent.name"/>&nbsp;</td>
			    <td><s:property value="ent.business"/>&nbsp;</td>
			    <td><s:date name="createTime" format="yyyy-MM-dd"/>&nbsp;</td>
			    <td>
		   			<a href="${pageContext.request.contextPath }/enterprises/ent-index.action?enterpriseId=${ent.id}" target="_blank">详细</a>
			    </td>
			  </tr>
		  </s:iterator>
		 </s:form>
		</table>
		<div ><input type="button" id="deleteAllBtn" name="submitBtn" value="删除" class="mbtn2"/> <div align="right"> <e:pagination></e:pagination> </div></div>
		</div>
		</div>
	</div>

</div>
<%-- 列表管理 --%>

<div class="cls"></div>
<div style="clear:both;"></div>

<s:include value="/WEB-INF/content/inc/footer.jsp"/>
</body>
</html>