<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="title3"><div class="nt2">最新资讯</div></div>

<div class="zxnews">
	<ul class="zxnewslist">
		<s:iterator value="latestInfos">
			<li><a href="${ctx}/information/info/info!show.action?requestId=${id}" target="_blank"><s:property value="getTitleByLength(15)" /></a></li>
		</s:iterator>
	</ul>
</div>