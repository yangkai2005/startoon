<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>

		
<div class="hover" id="conMess0" >
	<ul class="messageList">
		<s:iterator value="pager.items">
			<li>
				<p class="titleUser"><span class="fr">评论日期：<s:date name="createTime" format="yyyy-MM-dd HH:mm:dd"/></span>访客：<s:property value="creatorName"/></p>
				<div class="txtMessage"><s:property value="content"/></div>
			</li>
		</s:iterator>
	</ul>
	<div class="page"><e:pagination template="ajaxpagination"></e:pagination></div>
</div>