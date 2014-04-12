<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>

<s:iterator value="pager.items" status="st">
 <s:if test="#st.index>0"> | &nbsp;&nbsp;</s:if><a href="<s:property value='url'/>" title="<s:property value='name'/>" target="_blank"><s:property value="name"/> </a>
</s:iterator>