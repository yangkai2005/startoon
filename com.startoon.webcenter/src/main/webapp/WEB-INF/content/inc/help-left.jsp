<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- //left star-->
<div class="left">
<h1><img src="${pageContext.request.contextPath }/images/title_help.jpg" /></h1>
<h2>
<div class="leftnav">
<ul class="leftlist">
<s:iterator id="obj" value="list" status="idx">
	<li id="li${obj.id}"><a href="#" onclick="loadSub(${obj.id});">${obj.classname}</a></li>
</s:iterator>
</ul>

</div>

</h2>

<h3 style="display:none;">
<div class="lefttitle"><img src="../storefronts/images/lefttitle2.jpg" /></div>
<div class="leftcon">
<strong>公司名称:</strong>深圳市奋立达塑胶制品<br />
有限公司铁氟龙套管厂<br />
<strong>联系人:</strong>唐先生<br />
<strong>联系电话：</strong>020-28319024<br />
<strong>邮箱：</strong>loosent@toprand.com<br />
<strong>传真:</strong>28139085<br />
<strong>QQ在线:</strong> <a href="#"><img src="../storefronts/images/qq.jpg" /></a>
</div>


</h3>

</div>
<!-- //left over-->