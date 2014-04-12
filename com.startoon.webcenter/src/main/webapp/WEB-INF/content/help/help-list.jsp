<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="cjwenti">
	<h2>
	  <ul class="sublist">
			<s:iterator id="obj" value="sublist">
				<li><a href="${pageContext.request.contextPath }/help/help!detail.action?ids=${ids}&id=${obj.id}">${obj.title}</a></li>
			</s:iterator>
		</ul>	
	</h2>
	</div>

