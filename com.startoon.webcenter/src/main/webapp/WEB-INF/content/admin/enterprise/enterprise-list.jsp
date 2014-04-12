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
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/thickbox.css"/>

<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/myfunction.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/thickbox.js"></script>
<script type="text/javascript">
$(document).ready(function(){

	$("#checkAll").click(function() {
		var ck = $(this).attr('checked');
		$(":checkbox[name=ids]").attr('checked', ck);
	});

	$('#pass').click(function(){
		$('#status').val(2);
		$('#auditForm').submit();
	});

	$('#unpass').click(function(){
		$('#status').val(1);
		$('#auditForm').submit();
	});

	$('#lock').click(function(){
		return confirm('冻结帐号后，该帐号将不能登陆！\n确定冻结该帐号？');
	});
	
	$('#delete').click(function(){
		if(confirm("删除记录后，数据将不可恢复！\n确认继续删除？")) {
			$('#status').val(3);
			$('#auditForm').submit();
		}
	});

	//init search
	$('#searchStatus').val(<s:property value="pager.paramCondition['status']"/>);
	$('#searchUserType').val(<s:property value="pager.paramCondition['userType']"/>);
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
  <b class="bbig">注册会员列表</b>
</div>
<s:form  id="searchForm" action="enterprise-list" namespace="/admin/enterprise">
<div class="searchBar" id="searchList" style="display:none;">
  <table class="searchTable">
  <tr>
    <th>审核状态：</th>
    <td width=""> <s:select list="#{0:'待审核', 1:'不通过', 2:'已上线'}" name="status" headerKey="-1" headerValue="所有会员" id="searchStatus"></s:select> </td>
    <th width="">用户类型：</th>
    <td width="">
    	<s:select list="#{0:'个人', 1:'企业'}" name="userType" headerKey="" headerValue="全部" id="searchUserType"></s:select>
    </td>
    <th width="">个人会员类型：</th>
    <td width="">
    	<s:select list="#{'0':'普通个人会员','isBar':'电长吧会员','isShow':'创意Show会员'}" name="ptype" headerKey="" headerValue="全部" id="searchptype"></s:select>
    </td>
    <th width="">邮箱：</th>
    <td width=""> <input name="email" value="<s:property value="pager.paramCondition['email']"/>" /> </td>
    <th width="">名称：</th>
    <td width=""> <input name="searchKey" value="<s:property value="pager.paramCondition['searchKey']"/>" /> </td>
	<th width=""><button class="btn" type="submit">确定搜索</button></th>
    <td>
	</td>
  </tr>
  <!--
  <tr>
    <th>&nbsp;</th>
    <td><button class="btn" type="submit">确定搜索</button></td>
  </tr>
  -->
  </table>
</div>
</s:form> 
 
<!--list -->
<div class="mainList">
<form id="auditForm" name="auditForm" action="${ctx}/admin/enterprise/enterprise!audit.action" method="post">
<input type="hidden" name="status" id="status"/>
<table class="listTable">
  <tr>
	<th><input id="checkAll" type="checkbox"/> </th>
	<th>会员类型</th>
	<th>邮箱</th>
	<th>公司名称</th>
	<th>昵称</th>
	<th>所在地</th>
	<th>公司性质</th>
	<th>注册日期</th>
    <th>操作</th>
  </tr>
  <s:iterator value="pager.items">
  <tr>
  	<td><input type="checkbox" name="ids" value="<s:property value='id'/>" /></td>
  	<td> <s:if test="userType==0">个人</s:if><s:if test="userType==1">企业</s:if> </td>
  	<td> <s:property value="email"/> </td>
  	<td> <s:property value="name"/> </td>
  	<td> <s:property value="nickname"/> </td>
  	<td> <s:property value="address"/> </td>
    <td> <s:if test ="cartoon ==1">动漫</s:if><s:if test ="cartoon==0">非动漫</s:if></td>
  	<td> <s:date name="createTime" format="yyyy-MM-dd"/> </td>
    <td> 
    	<a href="<s:url action="enterprise!show" namespace="/admin/enterprise"/>?requestId=<s:property value="id"/>">详细</a>
    	<a href="<s:url action="enterprise!forwardPwd" namespace="/admin/enterprise"/>?requestId=<s:property value="id"/>&keepThis=true&TB_iframe=true&height=210&width=482&modal=true" class="thickbox">重置密码</a>
    	<a href="<s:url action="enterprise!forwardType" namespace="/admin/enterprise"/>?requestId=<s:property value="id"/>&keepThis=true&TB_iframe=true&height=210&width=482&modal=true" class="thickbox">修改类别</a>
    	<s:if test="userType==1">
    	<a href="<s:url action="ent-index" namespace="/enterprises"/>?enterpriseId=<s:property value="id"/>" target="_blank">查看店铺</a>
    	</s:if>
    	<a href="<s:url action="enterprise!forwardRecharge" namespace="/admin/enterprise"/>?requestId=<s:property value="id"/>&keepThis=true&TB_iframe=true&height=210&width=482&modal=true" class="thickbox">后台充值</a>
    	
    	<s:if test="status!=4">
	    	<a rel="lock" href="<s:url action="enterprise!updateState" namespace="/admin/enterprise"/>?requestId=<s:property value="id"/>&status=4">冻结</a>
    	</s:if>
    	<s:if test="status==4">
	    	<a rel="unlock" href="<s:url action="enterprise!updateState" namespace="/admin/enterprise"/>?requestId=<s:property value="id"/>&status=2">解冻</a>
    	</s:if>
    </td>
  </tr>
  </s:iterator>
</table>
</form>
</div>
<!--end list -->
<div class="Toolbar">
  <div class="toolBt">
 		<a href="#" title="审核通过" id="pass"><span class="btn">审核通过</span></a>
 		<a href="#" title="审核不通过" id="unpass"><span class="btn">审核不通过</span></a>
 		<a href="#" title="删除" id="delete"><span class="btn">删除</span></a>
  </div>
  <e:pagination></e:pagination>
</div>
 
</body>
</html>

