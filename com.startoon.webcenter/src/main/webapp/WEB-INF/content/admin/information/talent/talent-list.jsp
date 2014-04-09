<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>title here</title>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/admin.css"/>
<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/myfunction.js"></script>

<link rel="stylesheet" href="${ctx}/resources/jquery-ui-1.8.9/css/ui-lightness/jquery-ui-1.8.9.custom.css"/> 
<script src="${ctx}/resources/jquery-ui-1.8.9/js/jquery-ui-1.8.9.custom.min.js" type="text/javascript"></script>


<script type="text/javascript">
$(document).ready(function(){
	$("#checkAll").click(function() {
		var ck = $(this).attr("checked");
		$('input[name=ids]').attr("checked", ck);
	});

	$("#freeze").click(function(){
		var cks = $('input[name=ids]:checked');
		if(cks && cks.length>0) {
			$('#dialog-form').dialog('open');
			$("#status").val(1);
		} else {
			alert('请选择要冻结的数据！');
		}
	});
	$("#unfreeze").click(function(){
		var cks = $('input[name=ids]:checked');
		if(cks && cks.length>0) {
			$("#status").val(0);
			$("#auditForm").submit();
		} else {
			alert('请选择要取消冻结的数据！');
		}
	});


	// a workaround for a flaw in the demo system (http://dev.jqueryui.com/ticket/4375), ignore!
	$("#dialog").dialog("destroy");
	

	$("#dialog-form").dialog({
		autoOpen: false,
		height: 300,
		width: 350,
		modal: true,
		buttons: {
			'确定': function() {
				var desc = $('#desc').val();
				$('#auditDesc').val(desc);
				$("#auditForm").submit();
				$(this).dialog('close');
			},
			'取消': function() {
				$(this).dialog('close');
			}
		},
		close: function() {
			allFields.val('').removeClass('ui-state-error');
		}
	});
});
</script>
</head>
<body>
<div class="mTitle">
  <span class="hidsearch"><a href="javascript:void(0)" onclick="return chg('searchList');" id="ImgArrow"><img src="${ctx}/resources/images/icon_down.gif" id ="imgButton" />展开搜索</a></span>
  <b class="bbig">在线简历列表</b>
</div>
<s:form  id="searchForm" action="talent-list" namespace="/admin/information/talent">
<div class="searchBar" id="searchList" style="display:none;">
  <table class="searchTable">
  <tr>
    <th width="10%">xxx：</th>
    <td width="20%"><input name="" type="text" size="25" /></td>
	<th width="10%">xxx：</th>
    <td>
	</td>
  </tr>

  <tr>
    <th>&nbsp;</th>
    <td><button class="btn" type="submit">确定搜索</button></td>
  </tr>
  </table>
</div>
</s:form> 
 
<!--list -->
<div class="mainList">
<table class="listTable">
  <tr>
  	<th><input type="checkbox" id="checkAll" name="checkAll" /></th>
	<th>注册账号</th>
	<th>注册邮箱</th>
	<th>姓名</th>
	<th>创建时间</th>
	<th>状态</th>
	<th>冻结原因</th>
    <th>操作</th>
  </tr>
  
<s:form  id="auditForm" action="talent!freeze" namespace="/admin/information/talent">
<s:hidden id="status" name="state"></s:hidden>
<s:hidden id="auditDesc" name="desc"></s:hidden>
  
  <s:iterator value="pager.items">
  <tr>  
  	<td> <input type="checkbox" name="ids" value="<s:property value="id"/>"/> </td>
  	<td> <a href="${ctx}/admin/enterprise/enterprise!show.action?requestId=<s:property value='creator.id'/>" ><s:property value="creator.account"/></a> </td>
  	<td> <s:property value="creator.email"/> </td>
  	<td> <s:property value="name"/> </td>
	<td> <s:date name="createTime" format="yyyy-MM-dd" /> </td>
	<td> <s:if test="state==1"><font color="red">冻结</font></s:if><s:else>发布</s:else> </td>
  	<td> <s:property value="freezeDesc"/> </td>
    <td> 
    	<a href="${ctx}/information/hrservice/talent!show.action?requestId=<s:property value="id"/>" target="_blank">详细</a>  
    </td>
  </tr>
  </s:iterator>

</s:form>

</table>
</div>
<!--end list -->
<div class="Toolbar">
  <div class="toolBt">
  		<a href="#" title="冻结" id="freeze"><span class="btn">冻结</span></a>
 		<a href="#" title="解冻" id="unfreeze"><span class="btn">解冻</span></a>
  </div>
  <e:pagination></e:pagination>
</div>

<div id="dialog-form" title="冻结">
	<p class="validateTips">请填写冻结原因：</p>
	<form>
	<fieldset>
		<textarea id="desc" name="desc" rows="8" cols="45"></textarea>
	</fieldset>
	</form>
</div>
 
</body>
</html>

