<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>

		
<div class="hidden" id="conMess1" style="display: none; ">
	<form id="commentForm" name="commentForm" action="${ctx}/information/comments/comments!insert.action" method="post">
	<input type="hidden" name="info.id"  value="${info.id }"/>
	<table width="100%" border="0" class="tableMessage">
	  <tbody><tr>
		<td>昵称：<input type="text" name="comments.creatorName" class="txtUser" id="creator"/></td>
	  </tr>
	  <tr>
		<td><textarea class="areaMessage" name="comments.content" id="content"></textarea><p class="red">最多1000字 *</p></td>
	  </tr>
	  <tr>
		<td class="tr"><input type="submit" class="btnSubmitMess" value="" /></td>
	  </tr>
	</tbody>
	</table>
	</form>
</div>
		
