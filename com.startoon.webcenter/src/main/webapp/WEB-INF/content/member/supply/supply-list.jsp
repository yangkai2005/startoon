<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="org.j2eeframework.commons.pager.Pager"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>星力动漫 - 会员中心</title>

<link rel="stylesheet" type="text/css" href="${ctx}/css/member.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/thickbox.css"/>

<script src="${ctx}/resources/js/jquery.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/thickbox.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	if('insert'=='<%=request.getParameter("flag") %>') alert('发布供应信息成功！');
	if('update'=='<%=request.getParameter("flag") %>') alert('修改供应信息成功！');
	if('delete'=='<%=request.getParameter("flag") %>') alert('删除供应信息成功！');

	 $('#checkAll').click(function() {
		 var ck = $(this).attr('checked');
		 $(':checkbox[name=supplyIds]').attr('checked', ck);
	 });
	 
	$('#deleteAllBtn').click(function() {
		 
		var cks = $(':checkbox[name=supplyIds]:checked');
							if (cks && cks.length > 0) {
								if (confirm("确定要删除选中的产品吗?")) {
									$('#delForm').submit();
								}

							} else {
								alert('你还没有选择要删除的产品！');
							}
	});


});

</script>

</head>
<body>
<s:include value="/WEB-INF/content/inc/header.jsp"/>
<s:include value="/WEB-INF/content/inc/person-left.jsp"/>


<%-- 列表管理 --%>

<div class="memright">
<div class="title4"> <div class="hotline">客服热线：020-39106666</div>
	 <div class="titlemu2">
	
	 
	 <h1>供应管理</h1>
	 </div>
	 </div>
	 
	<div class="memcon2">
		<div class="gy1">
		<ul>
		
		<li id="allSupply"><a href="${ctx}/member/supply/supply-list.action?enterpriseId=<s:property value='#session.enterprise_user_id'/>&status=00">已发布</a></li>
		<li id="recSupply"><a href="${ctx}/member/supply/supply-list.action?enterpriseId=<s:property value='#session.enterprise_user_id'/>&recommend=1">已推荐</a></li>
		<li id="delSupply"><a href="${ctx}/member/supply/supply-list.action?enterpriseId=<s:property value='#session.enterprise_user_id'/>&status=1">审核未通过</a></li>
		</ul>
		</div>
		<div class="gy2">
		<div class="bggy">
		<table width="100%" border="0" class="memcontable2" cellspacing="0">
		  <tr>
		  <th width="5%"><input name="checkAll" id="checkAll" type="checkbox" value="" /> 全选</th>
		    <th width="6%">图片</th>
		    <th width="20%">产品名称</th>
		    <th width="6%">到期日期</th>
		    <th width="6%">状态</th>
		    <th width="6%">绑定关键字</th>
		    <th width="" id="auditDescTH" style="display: none;">审核备注</th>
		    <th width="15%">操作</th>
		  </tr>
		  
		<s:form id="delForm" name="delForm" namespace="/member/supply" action="supply!deleteAll">
		  <s:iterator value="pager.items">
			  <tr>
			  	<td style=" border-left:0; text-align:left; padding-left:5px;"><input name="supplyIds" type="checkbox" value='<s:property value="id" />' /></td>
			    <td><img src="${ctx}/FileView?id=${productImgUrl}" width="47" height="47" /></td>
			    <td style="font-weight:bold"><s:property value="name" /> <span class="red"><s:property value="category.name" /></span>系列</td>
			    <td><s:if test="deadDate!=null"> <s:date name="deadDate" format="yyyy-MM-dd"/> </s:if><s:else>长期有效</s:else> </td>
			    <td><s:property value="statusZh"/> </td>
			    <td><s:property value="keyword"/>&nbsp; </td>
			    <td id="auditDescTD" style="display: none;"><s:property value="auditDesc"/>&nbsp; </td>
			    <td>
		   			<a href="${pageContext.request.contextPath }/supply/supply-manage!detail.action?supplyId=${id}" target="_blank">预览</a>
			    	<s:if test="%{pager.paramCondition['isDelete']=='1'}">-</s:if>
			    	<s:else>
		   			<a href="${pageContext.request.contextPath }/member/supply/supply!edit.action?requestId=${id}">修改</a>
		   			</s:else>
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