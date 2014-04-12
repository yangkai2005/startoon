<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="keywords" content="星力网，游戏机供应，游戏机采购，动漫游戏资讯，动漫游戏展会，卖游戏机"/>
<meta http-equiv="description" content="星力网是广州星力动漫游戏产业园打造的动漫游戏行业最专业的游戏机供应、游戏机采购平台，提供最新、最全的游艺产品、游戏产品、电玩产品、游戏机配件、电脑板、框体机、模拟机等供应信息、采购信息，星力网资讯频道为行业提供最专业的动漫游戏行业资讯、行业新闻。"/>
<title>星力网_中国动漫游艺门户_动漫游戏产品网络交易平台_动漫游戏行业资讯</title>

<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/member.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />
<script src="${ctx}/resources/js/jquery.js" type="text/javascript"></script>
<script src="${ctx}/fckeditor/fckeditor.js" type="text/javascript"></script>

<script type="text/javascript"> 
$(document).ready(function(){
	<s:if test="success">alert('发布成功！');</s:if>

	 $('#checkAll').click(function() {
		 var ck = $(this).attr('checked');
		 $(':checkbox[name=ids]').attr('checked', ck);
	 });
	 
	$('#deleteAllBtn').click(function() {
		 
		var cks = $(':checkbox[name=ids]:checked');
							if (cks && cks.length > 0) {
								if (confirm("确定要删除选中的采购信息吗?")) {
									$('#delForm').submit();
								}

							} else {
								alert('你还没有选择要删除的采购信息！');
							}
	});
	 	
});



</script>
<script type="text/javascript">
			function FCKeditor_OnComplete(editorInstance) {
				window.status = editorInstance.Description;
			}
</script>
</head>
<body>
<s:include value="/WEB-INF/content/inc/header.jsp"/>
<s:include value="/WEB-INF/content/inc/person-left.jsp"/>

<%-- 列表管理 --%>

<div class="memright">
<div class="title4"> <div class="hotline">客服热线：020-39106666</div>
	 <div class="titlemu2">
	 <h1>采购信息列表</h1>
	 </div>
	 </div>
	 
	<div class="memcon2">
		<div class="gy2">
		<div class="bggy">
		<table width="100%" border="0" class="memcontable2" cellspacing="0">
		  <tr>
		  <th width="7%"><input name="checkAll" id="checkAll" type="checkbox" value="" /> 全选</th>
		    <th width="20%">图片</th>
		    <th width="28%">采购名称</th>
		    <th width="18%">到期日期</th>
		    <th width="13%">操作</th>
		  </tr>
		  
		<s:form id="delForm" name="delForm" namespace="/member/postedpro" action="posted-pro!deleteAll">
		  <s:iterator value="pager.items">
			  <tr>
			  	<td style=" border-left:0; text-align:left; padding-left:5px;"><input name="ids" type="checkbox" value='<s:property value="id" />' /></td>
			    <td><img src="${ctx}/<s:property value="imageUrl" />" width="47" height="47" /></td>
			    <td style="font-weight:bold"><s:property value="proName" /></td>
			    <td><s:if test="deadDate!=null"> <s:date name="endTime" format="yyyy-MM-dd"/> </s:if><s:else>长期有效</s:else> </td>
			    <%-- <td><s:property value="statusZh"/> </td> --%>
			    <td>
			    	<s:if test="%{pager.paramCondition['isDelete']=='1'}">-</s:if>
			    	<s:else>
		   			<a href="${pageContext.request.contextPath }/member/postedpro/posted-pro!edit.action?requestId=${id}">修改</a>
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