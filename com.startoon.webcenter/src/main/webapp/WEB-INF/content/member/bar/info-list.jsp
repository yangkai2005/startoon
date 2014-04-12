<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="keywords" content="星力网，游戏机供应，游戏机采购，动漫游戏资讯，动漫游戏展会，卖游戏机"/>
<meta http-equiv="description" content="星力网是广州星力动漫游戏产业园打造的动漫游戏行业最专业的游戏机供应、游戏机采购平台，提供最新、最全的游艺产品、游戏产品、电玩产品、游戏机配件、电脑板、框体机、模拟机等供应信息、采购信息，星力网资讯频道为行业提供最专业的动漫游戏行业资讯、行业新闻。"/>
<title>星力网_中国动漫游艺门户_动漫游戏产品网络交易平台_动漫游戏行业资讯</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/member.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/common.css" />

<script type="text/javascript" src="<%=request.getContextPath()%>/js/nav.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/dialog.js"></script>
<script language="javascript1.1" type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.4.2.js"></script>

<link href="<%=request.getContextPath()%>/resources/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=request.getContextPath()%>/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/resources/js/formValidatorRegex.js" type="text/javascript"></script>

<script type="text/javascript">
$(function() {
	$('h2#list').addClass('q3');
});
</script>
</head>

<body>

<%-- header --%>
<s:include value="/WEB-INF/content/inc/header.jsp"></s:include>
<%-- header --%>
  
<%-- main begin --%>
<div class="main">

<div class="member">

<%-- main left begin --%>
<s:include value="/WEB-INF/content/inc/person-left.jsp"/>
<%-- main left end --%>

<%-- main right begin --%>
<div class="memright">
	
	<s:include value="/WEB-INF/content/member/bar/menu.jsp"/>
	
	<div class="memcon">
	 <table width="100%" border="0" class="bartable" cellspacing="0">
  <tbody><tr bgcolor="#f1f1f1">
    <td width="53%" class="b" style="padding-left:22px; text-align:left">标   题 </td>
    <td width="15%" class="b">作  者</td>
    <td width="13%" class="b">访问</td>
    <td width="19%" class="b">发布时间</td>
  </tr>
  
  <s:iterator value="pager.items" status="st">
  <tr <s:if test="#st.count%2==0">bgcolor="#f1f1f1"</s:if>>
    <td style="text-align: left"><a href="<s:url namespace="/information/info" action="info!show"/>?requestId=<s:property value='id'/>" target="_blank"> <s:property value="title"/>[<s:property value="infoType.name"/>] </a></td>
    <td><s:property value="creatorName"/></td>
    <td class="c7c"><s:property value="hits"/></td>
    <td class="c7c"><s:date name="createTime" format="yyyy-MM-dd"/> </td>
  </tr>
  </s:iterator>
</tbody>
</table>
<div class="cls"></div>
<div class="pages"><e:pagination/></div>
<div class="cls"></div>
	 
	</div>
	 
	 

</div>
<%-- main right end --%>

</div>

<div class="cls"></div>
<div class="cls"></div>

</div>
<%-- main end --%>
  
<%-- footer --%>
<s:include value="/WEB-INF/content/inc/footer.jsp"/>
<%-- footer --%>
	
</body>
</html>