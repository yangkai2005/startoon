<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div style="padding-left:15px;padding-top:30px;width:1000px;height:116px;background:url(${ctx}<s:property value='entInfo.banner'/>) no-repeat top left;">
<span class="comtitle">${enterprise.name }<s:if test="enterprise.auth"><font style="color: #3300CC;font-weight: bold;">【已认证】</font></s:if></span>
</div>