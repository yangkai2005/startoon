<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="links">
<h1>
<ul>
	<li class="hover" onmouseover="setTab('two',1,2)" id="two1">友情连接</li>
	<li onmouseover="setTab('two',2,2)" id="two2">合作伙伴</li>
</ul>

</h1>
<h2>
<div class="" id="con_two_1">
<s:action name="link-list" namespace="/link" executeResult="true">
	<s:param name="linkTypeId">1</s:param>
</s:action>
</div>

<div class="play" id="con_two_2">
<s:action name="copartnership" namespace="/copartnership" executeResult="true">
	<s:param name="infoTypeId">-1</s:param>
</s:action>
</div>

</h2>

</div>

