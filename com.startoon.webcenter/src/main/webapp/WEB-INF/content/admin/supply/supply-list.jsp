<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>title here</title>

<link href="${ctx}/resources/css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/resources/js/myfunction.js"></script>
<script src="${ctx}/resources/jquery-ui-1.8.9/js/jquery-1.4.4.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="${ctx}/resources/jquery-ui-1.8.9/css/ui-lightness/jquery-ui-1.8.9.custom.css"/> 
<script src="${ctx}/resources/jquery-ui-1.8.9/js/jquery-ui-1.8.9.custom.min.js" type="text/javascript"></script>

<script type="text/javascript">
$(document).ready(function(){
	$("#checkAll").click(function() {
		var ck = $(this).attr("checked");
		$('input[name=ids]').attr("checked", ck);
	});

	$("#pass").click(function(){
		var cks = $('input[name=ids]:checked');
		if(cks && cks.length>0) {
			$("#status").val(2);
			$("#auditForm").submit();
		} else {
			alert('请选择要审核的数据！');
		}
	});
	
	$("#unpass").click(function(){
		var cks = $('input[name=ids]:checked');
		if(cks && cks.length>0) {
			$('#dialog-form').dialog('open');
			$("#status").val(1);
		} else {
			alert('请选择要审核的数据！');
		}
	});
	
	$("#tag").click(function(){
		var cks = $('input[name=ids]:checked');
		if(cks && cks.length>0) {
			$('#dialog1').dialog('open');
		} else {
			alert('请选择要审核的数据！');
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

	$("#dialog1").dialog({
		autoOpen: false,
		height: 170,
		width: 250,
		modal: true,
		buttons: {
			'确定': function() {
				var tagId = $('select[name=tag] option:selected').val();
				$('#tid').val(tagId);
				$('#auditForm').attr('action', '${ctx}/admin/supply/supply!setTag.action');
				$("#auditForm").submit();
				$(this).dialog('close');
			},
			'取消': function() {
				$(this).dialog('close');
			}
		},
		close: function() {
		}
	});
	

});

function chg(id_num){
    var oa = document.getElementById(id_num);
    var ob = document.getElementById("ImgArrow");
	 var imgButton = document.getElementById("imgButton");
    if(oa.style.display == "block"){
            oa.style.display = "none";
            imgButton.src = "${ctx}/resources/images/icon_down.gif";
			 imgButton.alt = "展开搜索";
    }else{
            oa.style.display = "block";
            imgButton.src = "${ctx}/resources/images/icon_up.gif";
			 imgButton.alt = "隐藏搜索";
    }
    return false;
}
</script>
</head>
<body>
<div class="mTitle">
  <span class="hidsearch"><a href="javascript:void(0)" onclick="return chg('searchList');" id="ImgArrow"><img src="${ctx}/resources/images/icon_down.gif" id ="imgButton" />展开搜索</a></span>
  <b class="bbig">待审核产品类别</b>
</div>
<s:form  id="searchForm" action="supply-list" namespace="/admin/supply">
<div class="searchBar" id="searchList" style="display:none;">
  <table class="searchTable">
  <tr>
    <th width="10%">审核状态：</th> 
    <td width="20%"><s:select list="#{0:'未审核', 1:'不通过', 2:'通过'}" name="status" /></td>
    <th width="10%">产品名称：</th> 
    <td width="20%"><input name="searchKey"/> </td>
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
	<th>ID</th>
	<th>产品类别</th>
	<th>产品名称</th>
	<th>发布者类型</th>
	<th>发布企业</th>
	<th>审核</th>
	<th>标签</th>
	<th>展示</th>
    <th>操作</th>
  </tr>
<s:form  id="auditForm" action="supply!auditAll" namespace="/admin/supply">
<s:hidden id="status" name="status" />
<s:hidden id="auditDesc" name="auditDesc" />
<s:hidden id="tid" name="tagId" />
  <s:iterator value="pager.items">
  <tr>
  	<td> <input type="checkbox" name="ids" value="<s:property value="id"/>"/> </td>
  	<td> <s:property value="id"/> </td>
  	<td> <s:property value="category.name"/> </td>
  	<td> <s:property value="name"/> </td>
  	<td> <s:if test="creator.userType==0">个人</s:if><s:else>企业</s:else> </td>
  	<td> <s:if test="creator.userType==0"><s:property value="creator.account"/></s:if><s:else><s:property value="creator.name"/></s:else> </td>
  	<td> <s:property value="statusZh" /> </td>
  	<td> <s:if test="ptags!=null"><s:property value="ptags.name" /></s:if><s:else>-</s:else> </td>
  	<td> <s:if test="ptags!=null"><s:if test="ptags.pass">显示</s:if><s:else>隐藏</s:else></s:if><s:else>-</s:else> </td>
    <td> 
    	<a href="<s:url action="supply!show" namespace="/admin/supply"/>?requestId=<s:property value="id"/>" target="_blank">详细</a>  
    </td>
  </tr>
  </s:iterator>
  
</s:form>
</table>
</div>
<!--end list -->
<div class="Toolbar">
  <div class="toolBt">
 		<a href="#" title="通过" id="pass"><span class="btn">通过</span></a>
 		<a href="#" title="不通过" id="unpass"><span class="btn">不通过</span></a>
 		<a href="#" title="贴标签" id="tag"><span class="btn">贴标签</span></a>
  </div>
  <e:pagination></e:pagination>
</div>

<div id="dialog-form" title="审核不通过">
	<p class="validateTips">请填写审核不通过的原因：</p>
	<form>
	<fieldset>
		<textarea id="desc" name="desc" rows="8" cols="45"></textarea>
	</fieldset>
	</form>
</div>

<div id="dialog1" title="标签选择">
	<p class="validateTips">请选择产品标签：</p>
	<form>
	<fieldset>
		<s:select id="tag" name="tag" list="tags" listKey="id" listValue="name" headerKey="" headerValue="--请选择--"></s:select>
	</fieldset>
	</form>
</div>

</body>
</html>

