<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>

<e:adquery id="ad1" adId="177"/>
<e:adquery id="ad2" adId="178"/>
<e:adquery id="ad3" adId="179"/>
<div class="ban"><a id="177" rel="ad" target="_blank" href="<e:adlink name="ad1"/>"><img src="<e:adimg name="ad1"/>" width="575" height="89" /></a>&nbsp;&nbsp;<a id="178" rel="ad" target="_blank" href="<e:adlink name="ad2"/>"><img src="<e:adimg name="ad2"/>" width="178" height="89" /></a>&nbsp;&nbsp;<a id="179" rel="ad" target="_blank" href="<e:adlink name="ad3"/>"><img src="<e:adimg name="ad3"/>" width="191" height="89"/></a></div>