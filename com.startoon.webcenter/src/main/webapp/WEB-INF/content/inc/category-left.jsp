<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>

<s:iterator var="firstCategory" value="categories">
<div class="kubiaoti"><a href="${ctx}/enterprises/enterprise-list.action?businessIds=<s:property value='id'/>&t=1"><s:property value="name"/></a></div>
<div class="kunav">
<ul>
<s:iterator value="categories" id="firstCategory">
<li><a href="${ctx}/enterprises/enterprise-list.action?businessIds=<s:property value='id'/>&t=1"><s:property value="name"/></a></li>
</s:iterator>
</ul>
</div>
</s:iterator>