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
<script type="text/javascript">
$(document).ready(function(){
	$('#checkAll').click(function() {
		var ck = $(this).attr('checked');
		$(':checkbox[name=msgId]').attr('checked', ck);
	});
	
	$('#deleteAll').click(function() {
		var cks = $(':checkbox[name=msgId]:checked');
		if(cks && cks.length>0) {
			$("form[name=delForm]").submit();
		} else {
			alert('至少要选择一条记录，请确认！');
			return false;
		}
	});
	
});
</script>
</head>
<body>
<div class="mTitle">
  <b class="bbig">已发送系统消息列表</b>
</div>
<s:form  id="searchForm" action="message-list" namespace="/admin/message">
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
<s:form name="delForm" action="message!deleteAll" namespace="/admin/message">

<table class="listTable">
  <tr>
	<th width="65"><input type="checkbox" id="checkAll" />序号</th>
	<th>标题</th>
	<th>发送时间</th>
	<th>接受者</th>
	<th>消息内容</th>
    <th>操作</th>
  </tr>
  <s:iterator value="pager.items" status="idx">
  <tr> 
  	<td style="text-align:center;"><input type="checkbox" name="msgId" value="${id}"/>${idx.count}</td>
  	<td> <s:property value="title"/> </td>
  	<td> <s:date name="createTime" format="yyyy-MM-dd HH:mm"/> </td>
  	<td> <s:property value="receiverName"/>	</td>
  	<td> <s:property value="content"/> </td>
    <td> 
    	<a href="<s:url action="message!delete" namespace="/admin/message"/>?requestId=<s:property value="id"/>"  onclick="return confirmDel();">删除</a>  
    </td>
  </tr>
  </s:iterator>
</table>

</s:form>
</div>
<!--end list -->
<div class="Toolbar">
  <div class="toolBt">
 		<a href="<s:url action="message!input" namespace="/admin/message"/>" title="新建"><span class="btn">新建</span></a>
 		<a href="javascript:void(0)" id="deleteAll" title="deleteAll"><span class="btn">删除</span></a>
  </div>
  <e:pagination></e:pagination>
</div>
 
</body>
</html>

