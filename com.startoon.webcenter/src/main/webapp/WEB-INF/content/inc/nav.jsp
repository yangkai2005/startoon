<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">

function addHome()
{
    if (window.sidebar) 
    {
        try {
            netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect"); 
        }
        catch (e)
        {
            alert("此操作被浏览器拒绝！\n请在浏览器地址栏输入“about:config”并回车\n然后将[signed.applets.codebase_principal_support]设置为true"); 
        }
        var prefs =  Components.classes["@mozilla.org/preferences-service;1"].getService( Components.interfaces.nsIPrefBranch );
        prefs.setCharPref("browser.startup.homepage",'http://www.chnam.com/index.action');
    }
    else if(document.all)
    {
        document.body.style.behavior="url(#default#homepage)";
        document.body.setHomePage('http://www.chnam.com/index.action');
    }
    else
    {
        ;
    }
}

$(function() {
	$('a[rel=addhome]').click(function() {
		addHome();
	});
});
	
</script>

<div class="top">
<div id="wrap">

<div class="topleft">
	<a href="${ctx}/index.action">网站首页</a><span class="f8">┆</span> 
	<a href="${ctx}/postedpro/posted-pro-list.action">采购平台</a> <span class="f8">┆</span>
	<a href="${ctx}/information/index.action" target="_blank">资讯频道</a> <span class="f8">┆</span> 
	<a href="<s:url namespace="/news" action="news!show"/>?requestId=2" target="_blank">企业推广</a>
</div>

<div class="topright">
	<s:if test="#session.enterprise_user==null">
	<a href="${ctx}/register.action" class="color1">免费注册</a><span class="f8">┆</span> 
	<a href="${ctx}/login.action">登录</a> <span class="f8">┆</span>
	</s:if>
	
	<s:if test="#session.enterprise_user!=null">
	<s:property value='#session.enterprise_user.account'/>，欢迎来到星力网<span class="f8">┆</span>
	<s:if test="#session.enterprise_user.userType==0">
	<a href="${ctx}/member/index.action?entId=<s:property value='#session.enterprise_user_id'/>" class="color1">会员中心</a> <span class="f8">┆</span>
	</s:if>
	
	<s:if test="#session.enterprise_user.userType==1">
	<a href="${ctx}/enterprise/enterprise/enterprise!info.action?entId=<s:property value='#session.enterprise_user_id'/>" class="color1">会员中心</a> <span class="f8">┆</span>
	</s:if>
	
	</s:if> 
	
	<a href="${pageContext.request.contextPath }/help/help.action">帮助中心</a> <span class="f8">┆</span>
	<a href="#" class="color1" rel='addhome'>设为首页</a>
	
	<s:if test="#session.enterprise_user!=null">
	<span class="f8">┆</span>
	<a href="${ctx}/ent-logout.action" class="color1">退出</a>
	</s:if>

</div>

</div>
</div>