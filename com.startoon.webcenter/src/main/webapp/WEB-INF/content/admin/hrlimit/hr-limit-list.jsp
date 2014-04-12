<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/myfunction.js"></script>
<script type="text/javascript">
$(document).ready(function(){

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
  <span class="hidsearch"><a href="javascript:void(0)" onclick="return chg('searchList');" id="ImgArrow"><img src="<%=request.getContextPath() %>/resources/images/icon_down.gif" id ="imgButton" />展开搜索</a></span>
  <b class="bbig">企业会员列表</b>
</div>
<s:form  id="searchForm" action="hr-limit-list" namespace="/admin/hrlimit">
<div class="searchBar" id="searchList" style="display:none;">
  <table class="searchTable">
  <tr>
    <th width="10%">会员级别：</th>
    <td width="20%"><s:select id="memberLevle" name="memberLevel" list="#{0:'普通会员', 1:'初级会员', 2:'高级会员' }" headerKey="" headerValue="--请选择--" ></s:select> </td>
    <td><button class="btn" type="submit">确定搜索</button></td>
    <td>
	</td>
  </tr>
  </table>
</div>
</s:form> 
 
<!--list -->
<div class="mainList">
<table class="listTable">
  <tr>
	<th>企业名称</th>
	<th>会员账号</th>
	<th>会员级别</th>
	<th>发布招聘数</th>
	<th>查看简历数</th>
	<th>发布限制</th>
	<th>查看限制</th>
	<th>成为会员时间</th>
	<th>会员到期时间</th>
    <th>操作</th>
  </tr>
  <s:iterator value="pager.items">
  <tr>  
  	<td> <s:property value="enterprise.name" /> </td>
  	<td> <s:property value="enterprise.account" /> </td>
  	<td> <s:if test="enterprise.memberLevel==1">初级会员</s:if><s:elseif test="enterprise.memberLevel==2">高级会员</s:elseif><s:else>普通会员</s:else> </td>
  	<td> <s:property value="jobCount" /> </td>
  	<td> <s:property value="viewCount" /> </td>
  	<td> <s:property value="maxJobCount" /> </td>
  	<td> <s:property value="maxViewCount" /> </td>
  	<td> <s:date name="becomeMemberTime" format="yyyy-MM-dd" /> </td>
  	<td> <s:date name="memberDeadTime" format="yyyy-MM-dd" /> </td>
    <td> 
    	<a href="<s:url action="hr-limit!upgrade" namespace="/admin/hrlimit"/>?requestId=<s:property value="id"/>">会员升级</a>
    	<a href="<s:url action="hr-limit!down" namespace="/admin/hrlimit"/>?requestId=<s:property value="id"/>">会员降级</a>
    </td>
  </tr>
  </s:iterator>
</table>
</div>
<!--end list -->
<div class="Toolbar">
  <div class="toolBt">
  <%-- 
 		<a href="<s:url action="hr-limit!input" namespace="/admin/hrlimit"/>" title="新建"><span class="btn">新建</span></a>
  --%>
  
  </div>
  <e:pagination></e:pagination>
</div>
 
</body>
</html>

