<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<ul class="linkslist2">
<s:iterator value="pager.items">
<li><a href="<s:property value='url'/>" target="_blank" title="<s:property value="name" />"><s:property value="name" /></a></li>
</s:iterator>
</ul>
