<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
$(function() {
	$('#loginBtn').click(function() {
		var rd = $(':radio[name="userType"]:checked');
		var uid = $('input[name=userId]').val();
		var pwd = $('input[name=password]').val();
		var ut = $(':radio[name="userType"]:checked').val();
		if($.trim(uid)=='') {
			alert('登录名不能为空，请输入登录名！');
			return false;
		}
		if($.trim(pwd)=='') {
			alert('密码不能为空，请输入密码！');
			return false;
		}
		if(rd.length==0) {
			alert('请选择用户类型！');
			return false;
		}
		
		$.post('${ctx}/information/login.action', {'userId': uid, 'password': pwd, 'userType':ut}, function(data) { if(data=='success'){ alert('登录成功！'); location.reload();} else {alert(data);}});
	});
	$('#register').click(function() {
		window.location = '${ctx}/register.jsp';
	});
});
</script>
<%-- 顶部登录 start --%>
<div class="head"> 
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
  	<s:if test="#session.enterprise_user!=null">
    <td width="64%" class="td1">您好， <s:property value="#session.enterprise_user.nickname"/>！ 欢迎来到星力网。进入
			    	<s:if test="#session.enterprise_user.userType==1">
			    	<a href="${ctx}/enterprise/enterprise/enterprise!info.action?entId=${enterprise_user.id}">会员中心</a>
			    	</s:if>
			    	<s:else>
			    	<a href="${ctx}/member/base/base-info!edit.action">会员中心</a>
			    	</s:else>
，或者点击 <a href="${ctx}/ent-logout.action"><b>退出</b></a> 。</td>
  	</s:if>
  	<s:else>
    <td width="64%" class="td1">登录名：<input name="userId" type="text" class="txt1" /> 密 码 ：<input name="password" type="password" class="txt1" /> <s:radio list="#{0:'个人会员',1:'企业会员'}" name="userType"></s:radio><input id="loginBtn" name="loginBtn" type="button" value="登录" style="width:77px; height:22px" /> <input name="register" id="register" type="button" value="注册" style="width:77px; height:22px" /></td>
  	</s:else>
    <td width="13%" class="td2"><a href="${ctx}/information/index.action">资讯首页</a>  <a href="${ctx}/index.action" target="_blank">B2B首页 </a> </td>
    <td width="23%"><a href="${ctx}/information/attachment/index.action"><img src="${ctx}/information/images/hotline.jpg" /></a></td>
  </tr>
</table>
</div>
<%-- 顶部登录 end --%>
