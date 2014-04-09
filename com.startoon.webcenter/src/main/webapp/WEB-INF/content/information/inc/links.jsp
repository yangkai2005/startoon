<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="links2">
<div class="l">友情链接</div>
<div class="r">
<h1>
<s:action name="link" namespace="/information/inc" executeResult="true">
	<s:param name="linkTypeId">2</s:param>
</s:action>
<div class="cls"></div>
<div class="more3"><a href="${ctx}/information/link/link-list.action" target="_blank">更多&gt;&gt;</a></div>
</h1>
</div>
</div>