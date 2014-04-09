<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<ul>
	<s:iterator value="categories">
	<li>
	<p>
		<a href="${ctx}/enterprises/enterprise-list.action?categoryIds=<s:property value='id'/>&t=1" class="bb"><s:property value="name" /></a> 
		<s:iterator value="categories"><a class="aa" href="${ctx}/enterprises/enterprise-list.action?categoryIds=<s:property value='id'/>"><s:property value="name"/></a></s:iterator> 
		<s:if test="categories.size()>9"><a href="${ctx}/category/category-list.action?categoryId=<s:property value='category.id'/>&t=1" class="more">更多</a> </s:if>
	</p>
	</li>
	</s:iterator>
</ul>
