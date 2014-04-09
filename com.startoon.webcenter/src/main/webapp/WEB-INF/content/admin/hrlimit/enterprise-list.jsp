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
	$("#checkAll").click(function() {
		var ck = $(this).attr('checked');
		$(":checkbox[name=ids]").attr('checked', ck);
	});
	$("#apply").click(function() {
		var cb = $(':checkbox[name=ids]:checked');
		if(cb && cb.length>0) {
			$('form#applyForm').submit();
		} else {
			alert('请选择要报名的会员！');
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
  <b class="bbig">企业会员列表</b>
</div>
<s:form  id="searchForm" action="enterprise-list" namespace="/admin/hrlimit">
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
<table class="listTable">
  <tr>
	<th><input type="checkbox" id="checkAll"/></th>
	<th>企业名称</th>
	<th>邮箱</th>
	<th>会员类型</th>
	<th>是否报名</th>
	<th>报名时间</th>
  </tr>
  <s:form name="applyForm" id="applyForm" namespace="/admin/hrlimit" action="enterprise!apply" >
  <s:iterator value="pager.items">
  <tr>  
  	<td> <input type="checkbox" name="ids" value="<s:property value='id'/>" /> </td>
  	<td> <s:property value="name" /> </td>
  	<td> <s:property value="account" /> </td>
  	<td> <s:if test="userType==0">个人</s:if><s:if test="userType==1">企业</s:if> </td>
  	<td> <s:if test="limit!=null && limit.isApply"><font style="color: #ff0000; font-weight: bold;">已报名</font></s:if><s:else>否</s:else> </td>
  	<td> <s:if test="limit!=null && limit.isApply"><s:date name="limit.applyTime" format="yyyy-MM-dd" /></s:if><s:else>-</s:else> </td>
  </tr>
  </s:iterator>
  </s:form>
</table>
</div>
<!--end list -->
<div class="Toolbar">
  <div class="toolBt">
 	<a href="javascript:void(0)" id="apply" title="报名"><span class="btn">报名</span></a>
  </div>
  <e:pagination></e:pagination>
</div>
 
</body>
</html>