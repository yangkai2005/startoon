<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="title3"><div class="nt2">人才工作站</div></div>

<div class="zxnews">
	<ul class="zxnewslist">
		<s:iterator value="pager.items">
			<li><a href="${ctx}/information/info/info!show.action?requestId=${id}"><s:property value="shortTitle" /></a></li>
		</s:iterator>
	</ul>
</div>
