<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="refresh" content="5;url=http://www.chnam.com" />
<meta http-equiv="keywords" content="星力网，游戏机供应，游戏机采购，动漫游戏资讯，动漫游戏展会，卖游戏机"/>
<meta http-equiv="description" content="星力网是广州星力动漫游戏产业园打造的动漫游戏行业最专业的游戏机供应、游戏机采购平台，提供最新、最全的游艺产品、游戏产品、电玩产品、游戏机配件、电脑板、框体机、模拟机等供应信息、采购信息，星力网资讯频道为行业提供最专业的动漫游戏行业资讯、行业新闻。"/>
<title>星力网_中国动漫游艺门户_动漫游戏产品网络交易平台_动漫游戏行业资讯</title>

<link rel="stylesheet" type="text/css" href="${ctx}/css/index.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/member.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />

<script type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="${ctx}/js/nav.js"></script>

<script type="text/javascript">
setTimeout('location.replace("http://www.chnam.com/")', 5000);
</script>

</head>

<body>

<%-- header --%>
<s:include value="/inc/header.jsp"></s:include>
<%-- header --%>

<div class="chucuo">
        <h2>
        	<div class="pic">
        	<span>抱歉，您所访问的内容出现系统错误！</span><br/>
			5秒后自动跳转到星力网首页。
			</div>
        </h2>
    	<h3>
        	<a href="http://www.chnam.com">www.chnam.com</a>
        </h3>
    	
    
    </div> 
  
<%-- footer --%>
<s:include value="/inc/footer.jsp"/>
<%-- footer --%>
	
</body>
</html>