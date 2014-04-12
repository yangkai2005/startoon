<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>



<ul class="procglist2">
<s:iterator value="categories">
<li><p class="licg1">
<a href="${ctx}/postedpro/posted-pro1-list.action?categoryIdStr=<s:property value='id'/>" style="color:#fe0000; font-weight:bold"><s:property value="name" /></a> 
	<s:iterator value="categories">
	<a href="${ctx}/postedpro/posted-pro1-list.action?categoryIdStr=<s:property value='id'/>"><s:property value="name"/></a>
	</s:iterator>
</s:iterator>			 

</ul>

