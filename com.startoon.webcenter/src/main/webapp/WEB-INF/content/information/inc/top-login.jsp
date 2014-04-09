<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
$(function() {
	$('#loginBtn').click(function() {
		var uid = $('input[name=userId]').val();
		var pwd = $('input[name=password]').val();
		$.post('${ctx}/information/login.action', {'userId': uid, 'password': pwd}, function() {location.reload();});
	});
});
</script>
<div class="head"> 
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="48%" class="td1" align="right">
    <%--
  	<s:if test="#session.enterprise_user!=null">
  	<s:property value='#session.enterprise_user.account'/>，欢迎来到星力网-资讯平台
  	</s:if>
  	<s:else>
    	登录名：<input name="userId" type="text" class="txt1" />
    	密 码 ：<input name="password" type="password" class="txt1" />
    	<input id="loginBtn" type="button" value="登录" style="width:77px; height:21px" />
  	</s:else>
    --%>
    	<a href="${ctx}/login.jsp">登录</a> 
    	<a href="${ctx}/register.jsp">注册</a> 
    	<a href="${ctx}/find-password.jsp">找回密码</a>
    	&nbsp;&nbsp;
    </td>
    
    <td width="28%" class="td2">
    	<a href="${ctx}/ent-library.action">企业库</a>  
    	<a href="${ctx}/index.action">产品库</a>
    	<a href="${ctx}/index.action">B2B首页</a>  
    	<a href="${ctx}/information/index.action">资讯首页</a></td>
    <td width="23%"><img src="${ctx}/information/images/hotline.jpg" /></td>
  </tr>
</table>
</div>
