<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link type="text/css" rel="stylesheet" href="${ctx}/resources/jqselectable/css/style.css" />
<script type="text/javascript" src="${ctx}/resources/jqselectable/js/jQselectable.js"></script>


<script type="text/javascript">
$(function() {
	$(".selectable").jQselectable({
		set: "fadeIn",
		setDuration: "fast",
		opacity: .9
	});	
});
</script>

<select id="jobType" name="jobType" class="selectable">
<s:iterator value="items">
<optgroup label='<s:property value="name" />'>
	<s:iterator value="children">
	<option value='<s:property value="id"/>'><s:property value="name"/></option>
	</s:iterator>
</optgroup>
</s:iterator>
</select>