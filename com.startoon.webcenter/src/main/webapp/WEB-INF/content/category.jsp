<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<ul>
	<s:iterator value="categories">
	<li>
	<p>
		<s:if test="%{type=='1'}">
			<a href="${ctx}/enterprises/enterprise-list.action?categoryIds=<s:property value='id'/>" class="bb" target="_blank"><s:property value="name" /></a> 
			<s:iterator value="categories"><a class="aa" href="${ctx}/enterprises/enterprise-list.action?categoryIds=<s:property value='id'/>" target="_blank"><s:property value="name"/></a></s:iterator> 
			<s:if test="categories.size()>9"><a href="${ctx}/category/category-list.action?categoryId=<s:property value='category.id'/>" class="more" target="_blank">更多</a> </s:if>
		</s:if>
		
		<s:else>
			<a href="${ctx}/supply/supply-list.action?categoryId=<s:property value='id'/>" class="bb" target="_blank"><s:property value="name" /></a> 
			<s:iterator value="categories"><a class="aa" href="${ctx}/supply/supply-list.action?categoryId=<s:property value='id'/>" target="_blank"><s:property value="name"/></a></s:iterator> 
			<s:if test="categories.size()>9"><a href="${ctx}/category/category-list.action?categoryId=<s:property value='category.id'/>" class="more" target="_blank">更多</a> </s:if>
		</s:else>
	</p>
	</li>
	</s:iterator>
</ul>