<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="search">
	<div class="l">
		<s:form namespace="/information/search" action="info-list">
		<img src="${ctx}/information/images/pic_search.jpg" align="absmiddle" /> 
		<input name="q" type="text" style="width: 304px;" /> 
		<input type="submit" value="搜索" style="width: 33px;" />
		</s:form>
	</div>
	<div class="r">
		热搜:
		<a href="${ctx}/information/search/info-list.action?q=企业招聘">企业招聘</a> | 
		<a href="${ctx}/information/search/info-list.action?q=技术产品">技术产品</a> | 
		<a href="${ctx}/information/search/info-list.action?q=创意世界">创意世界</a> | 
		<a href="${ctx}/information/search/info-list.action?q=资源互补">资源互补</a> | 
		<a href="${ctx}/information/search/info-list.action?q=行情指数">行情指数</a> | 
		<a href="${ctx}/information/search/info-list.action?q=市场调查">市场调查</a> 
	</div>
</div>