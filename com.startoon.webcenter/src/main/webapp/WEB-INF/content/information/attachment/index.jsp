<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="星力动漫游戏产业园" />
<meta name="description" content="星力动漫游戏产业园" />
<meta name="author" content="xiaohe" />
<title>星力动漫游戏产业园</title>

<link rel="stylesheet" type="text/css" href="${ctx}/information/css/style.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/information/css/common.css" />

<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script> 

<script type="text/javascript">
$(document).ready(function(){
	$('a[rel=ad]').click(function() {
		var id = $(this).attr('id');
		$.post('${ctx}/information/advertisement/click.action', {'id':id});
	});
});
</script>
</head>

<body>
<div id="wrap">

<s:include value="/WEB-INF/content/information/inc/htop.jsp"/>
<s:include value="/WEB-INF/content/information/inc/hnav.jsp"/>
<s:include value="/WEB-INF/content/information/inc/hbanner-index.jsp"/>
<s:include value="/WEB-INF/content/information/inc/hsearch.jsp"/>


<!--main star-->
<div class="main">

<div class="left">
<div class="lbox">
<ul class="pboxlink">
	<s:iterator value="pager.items">
		<li>
		<div class="pimg"><a href="${ctx}/information/attachment/attachment!show.action?requestId=<s:property value='id'/>"><img src="${ctx}/FileView?id=<s:property value='imgUrl'/>" width="130" height="84" alt="<s:property value='name'/>" /></a></div>
		<div class="ptxt"><a href="${ctx}/information/attachment/attachment!show.action?requestId=<s:property value='id'/>"><s:property value='name' /></a></div>
		</li>
	</s:iterator>
	<div class="cls"></div>
</ul>
<div class="cls"></div>
<div class="lpage"><e:pagination></e:pagination></div>
<div class="cls"></div>
</div>
<div class="cls"></div>
</div>

<div class="right">
<div class="title3">
<div class="nt2">资料下载</div>
</div>
<div class="cls"></div>
<div class="zxnews22">
<div class="zlink">

<ul>
	<s:iterator value="attachmentTypes">
		<li><a href="${ctx}/information/attachment/index.action?typeId=<s:property value='id'/>"><img src="../images/pic_zl.gif" width="30" height="22" style="vertical-align: middle; padding-right: 10px;" /><s:property value='name'/></a></li>
	</s:iterator>
</ul>

</div>
</div>

</div>


</div>

<div class="cls"></div>


<%-- copartnership start --%>
<s:action name="copartnership" namespace="/information/inc" executeResult="true">
<s:param name="infoTypeId">1</s:param>
</s:action>
<%-- copartnership end --%>


<%-- links begin --%>
<s:include value="/WEB-INF/content/information/inc/links.jsp"/>
<%-- links end --%>

<div class="cls"></div>

<%-- footer begin --%>
<s:include value="/WEB-INF/content/information/inc/footer.jsp"/>
<%-- footer end --%>

</div>
</body>
</html>
