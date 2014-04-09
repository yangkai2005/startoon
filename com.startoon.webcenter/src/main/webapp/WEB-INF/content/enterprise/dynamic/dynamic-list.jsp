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

<link href="${ctx}/resources/jquery-ui/css/custom-theme/jquery-ui.custom.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/resources/jquery-ui/js/jquery-ui.custom.min.js" type="text/javascript"></script>
<script src="${ctx}/resources/jquery-ui/js/ui.datepicker-zh-CN.js" type="text/javascript"></script>

<script type="text/javascript">
$(document).ready(function(){
	$("#dyna").addClass("q2");

	$("#checkAll").click(function() {
		var ck = $(this).attr('checked');
		$(':checkbox[name=ids]').attr('checked', ck);
	});

	$("#addBtn").click(function() {
		window.location.href = "<s:url namespace="/enterprise/dynamic" action="dynamic!input"/>";
	});

	

	$('#deleteAllBtn').click(function() {
		var cks = $(':checkbox[name=ids]:checked');
		if(cks && cks.length>0) {
			if(confirm("删除记录后，数据将不可恢复！\n确认继续删除？")) {
				$("#delForm").submit();
			}
			
		} else {
			alert('还没有选择要删除的数据！');
		}
			
	});	
	
});
function confirmDel()
{
	if(confirm("删除记录后，数据将不可恢复！\n确认继续删除？"))
	{
		 
		return true;
	}
	return false;
}
</script>

</head>

<body>

<%-- header --%>
<s:include value="/WEB-INF/content/inc/header.jsp"></s:include>
<%-- header --%>
		

<div class="cls"></div>


<%-- main begin --%>
<div class="main">

<div class="member">
<%-- left --%>
<s:include value="/WEB-INF/content/inc/member-left.jsp"></s:include>
<%-- left --%>

<%-- right --%>

<div class="memright">
<div class="title4"> <div class="hotline">客服热线：020-39106666</div>
	 <div class="titlemu2">
	
	 
	 <h1>企业管理</h1>
	 </div>
	 </div>
	 
	<div class="memcon">
		<div class="memqy">
		<s:include value="/WEB-INF/content/enterprise/entinfo/menu.jsp" />
		
		<div class="memcon">
		<table width="96%" border="0" class="memcontable2" cellspacing="0">
		  <tr>
		  	<th width="5%"><input name="checkAll" id="checkAll" type="checkbox" /></th>
		    <th>动态标题</th>
		    <th width="10%">操作</th>
		  </tr>
		  
		<s:form id="delForm" name="delForm" namespace="/enterprise/dynamic" action="dynamic!deleteAll">
		  <s:iterator value="pager.items">
			  <tr>
			  	<td><input name="ids" type="checkbox" value='<s:property value="id" />'/></td>
			    <td style="text-align: left;"><s:property value="title"/></td>
			    <td>
		   			<a href="${pageContext.request.contextPath }/enterprise/dynamic/dynamic!edit.action?requestId=${id}">修改</a>
			    </td>
			  </tr>
		  </s:iterator>
		 </s:form>
		</table>
		<div><input type="button" id="deleteAllBtn" name="submitBtn" value="删除" class="mbtn2"/> <input type="button" id="addBtn" name="addBtn" value="新增" class="mbtn2"/> <div align="right"> <e:pagination></e:pagination> </div></div>
			
		</div>		
		
		</div>

	
	</div>
	 
	 

</div>

<%-- right --%>
</div>


</div>
<%-- main end --%>

<div class="cls"></div>
<div class="cls"></div>
  
<%-- footer --%>
<s:include value="/WEB-INF/content/inc/footer.jsp"/>
<%-- footer --%>	
</body>
</html>