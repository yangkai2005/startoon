<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>

<e:adquery id="banner">
	<jsp:attribute name="infoTypeId">${infoType.id}</jsp:attribute>
	<jsp:attribute name="index">1</jsp:attribute>
</e:adquery>
<div class="ban"><a id="${__ad_banner.id}" rel="ad" href="<e:adlink name="banner"/>" target="_blank"><img src="<e:adimg name="banner"/>" width="972" height="82"/></a></div>