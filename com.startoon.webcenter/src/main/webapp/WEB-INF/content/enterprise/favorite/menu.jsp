<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="title4">
	<div class="hotline">客服热线：020-39106666</div>
	<div class="titlemu2">
		<h2 id="supply"><a href="<s:url namespace="/enterprise/favorite" action="favorite-list"/>?type=0">产品收藏</a></h2>
		<h2 id="postedPro"><a href="<s:url namespace="/enterprise/favorite" action="favorite-list"/>?type=1">采购收藏</a></h2>
		<h2 id="enterprise"><a href="<s:url namespace="/enterprise/favorite" action="favorite-list"/>?type=2">企业收藏</a></h2>
	</div>
</div>
