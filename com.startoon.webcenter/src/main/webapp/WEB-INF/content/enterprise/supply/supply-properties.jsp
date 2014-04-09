<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:iterator value="categoryAttrs">

<span>

<s:property value="attrName"/>：

<s:if test="attrInput==1">

<select name="paramValue" id="propertyValue">
	<s:iterator value="options">
		<option value='<s:property value="key"/>'><s:property value="key"/></option>;
	</s:iterator>
</select>

</s:if>


<s:if test="attrInput==2">
<input type="text" name="paramValue"/>
</s:if>

<input type="hidden" name="paramKey" value='<s:property value="attrName"/>' />
<input type="hidden" name="categoryAttrId" value='<s:property value="id"/>' />

<br/>
</span>

</s:iterator>