<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<div class="qyleft">
<%--
<s:iterator value="attrTypes">
<div class="qylefttab">
	<div class="qytitle5"><div class="more2"><a href="#">更多>></a></div>
	<h1>按<s:property value="name"/>筛选</h1>
	</div>
	
	<div class="qyleftcon">
	 <ul class="qylist3">
	 <s:iterator value="categoryAttrs">
		 <li><a href="${ctx}/supplyparam/supply-param-list.action?categoryAttrId=<s:property value='id'/>"><s:property value="attrName"/></a></li>
	 </s:iterator>
	 </ul>
	</div>
</div>
</s:iterator>
 --%>
<s:iterator value="categoryAttrs">
<div class="qylefttab">
	<div class="qytitle5"><div class="more2"><!-- <a href="#">更多>></a>--></div>
	<h1>按<s:property value="attrName"/>筛选</h1>
	</div>
	
	<div class="qyleftcon">
	 <ul class="qylist3">
	 <s:iterator value="supplyParams">
		 <li><a href="${ctx}/supply/supply-list.action?categoryId=<s:property value='categoryId'/>&aKey=<s:property value='pvalue'/>"><s:property value="pvalue"/></a></li>
	 </s:iterator>
	 </ul>
	</div>
</div>
</s:iterator>
<s:if test="categoryAttrs.size()>0">
<div class="duoxuan"><img src="../images/morexuan.jpg" border="0" usemap="#Map" />
<map name="Map" id="Map"><area shape="rect" coords="72,5,153,22" href="#" /></map>	
</div>
</s:if>



<div class="qylefttab" style="margin-bottom:10px;">
	<div class="qytitle5" style=" border-bottom:0">
	<h1>分类查看信息</h1>
	</div>
	
	<div class="qyleftcon">
	 <ul class="qylist4">
	 <s:iterator value="topCategories">
	 <li>
	 <a href="${ctx}/postedpro/posted-pro1-list.action?categoryIdStr=<s:property value='id'/>"><strong><s:property value="name"/></strong></a><br />
	 <s:iterator value="categories">
	 <a href="${ctx}/postedpro/posted-pro1-list.action?categoryIdStr=<s:property value='id'/>"><s:property value="name"/></a>
	 </s:iterator>
	 </li>
	 </s:iterator>
	 </ul>
	</div>
</div>

<!--
<div class="qylefttab">
	<div class="qytitle5">
	<h1>最近浏览过产品</h1>
	</div>
	
	<div class="qyleftcon">
	 <ul class="qylist2">
	 <li><input name="" type="checkbox" value="" /><a href="#">移动螺杆空气<span class="red">模具</span>系列</a></li>
	 <li><input name="" type="checkbox" value="" /><a href="#">移动螺杆空气<span class="red">模具</span>系列</a></li>
	 <li><input name="" type="checkbox" value="" /><a href="#">移动螺杆空气<span class="red">模具</span>系列</a></li>
	 <li><input name="" type="checkbox" value="" /><a href="#">移动螺杆空气<span class="red">模具</span>系列</a></li>
	 <li><input name="" type="checkbox" value="" /><a href="#">移动螺杆空气<span class="red">模具</span>系列</a></li>
	 <li><input name="" type="checkbox" value="" /><a href="#">移动螺杆空气<span class="red">模具</span>系列</a></li>
	 <li><input name="" type="checkbox" value="" /><a href="#">移动螺杆空气<span class="red">模具</span>系列</a></li>
	 <li><input name="" type="checkbox" value="" /><a href="#">移动螺杆空气<span class="red">模具</span>系列</a></li>
	
	 </ul>
	
	</div>

</div>
-->

</div>