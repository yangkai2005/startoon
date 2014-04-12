<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- //left star-->
<div class="left">
<s:iterator id="obj" value="list" status="idx">
<s:if test="#idx.count<5">
<div class="helptitle"><div class="hlep1">${obj.helpclass.classname}</div></div>
<div class="helpcon">
<s:if test="#obj.sublist!=null">
<ul class="helplist">
<s:iterator id="subobj" value="#obj.sublist">
<li><a href="#" onclick="loadSub(${subobj.id},${obj.helpclass.id });">${subobj.classname}</a></li>
</s:iterator>
</ul>
</s:if>
</div>
</s:if>
</s:iterator>

</div>
<!-- //left over-->