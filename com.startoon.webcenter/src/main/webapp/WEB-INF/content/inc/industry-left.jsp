<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

 <%@page import="java.util.List"%>
<%@page import="org.j2eeframework.startoon.entity.Category"%>
<%@page import="org.j2eeframework.startoon.service.CategoryService"%>
<%@page import="org.j2eeframework.commons.util.SystemContext"%>

<div class="qyleft">


<%
CategoryService categoryService = SystemContext.getApplicationContext().getBean(CategoryService.class);
List<Category> categories = categoryService.getCategoriesByFatherId(0L);

for (Category c : categories) {
	Long id = c.getId();
	List<Category> sub = categoryService.getCategoryByFatherId(id, 10);
	c.setCategories(sub);
}

request.setAttribute("categories", categories);

%>

<div class="qylefttab" style="margin-bottom:10px;">
	<div class="qytitle5" style=" border-bottom:0">
	<h1>分类查看信息</h1>
	</div>
	
	<div class="qyleftcon">
	 <ul class="qylist4">
	 <s:iterator value="#request.categories">
	 <li>
	 <a href="${ctx}/enterprises/enterprise-list.action?categoryIds=<s:property value='id'/>"><strong><s:property value="name"/></strong></a><br />
	 <s:iterator value="categories">
	 <a href="${ctx}/enterprises/enterprise-list.action?categoryIds=<s:property value='id'/>"><s:property value="name"/></a>
	 </s:iterator>
	 </li>
	 </s:iterator>
	 </ul>
	</div>
</div>

<s:if test="industries.size()>0">
<div class="duoxuan"><img src="${ctx}/images/morexuan.jpg" border="0" usemap="#Map" />
<map name="Map" id="Map"><area shape="rect" coords="72,5,153,22" href="#" /></map></div>
</s:if>



</div>