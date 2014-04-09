<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>

<e:adquery id="rad2">
	<jsp:attribute name="infoTypeId">${infoType.id}</jsp:attribute>
	<jsp:attribute name="index">3</jsp:attribute>
</e:adquery>

<div class="rban1">
<a id="${__ad_rad2.id}" rel="ad" href="<e:adlink name="rad2"/>" target="_blank"><img src="<e:adimg name="rad2"/>" width="242" height="140" /></a>
</div>

