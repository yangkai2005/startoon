<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="links">
	<div class="linkstop"><div class="more2"><a href="<s:url namespace="/information/copartnership" action="copartnership-list"/>?infoTypeId=<s:property value="infoType.id"/>" target="_blank">更多&gt;&gt;</a></div><div class="nt3">合作单位</div></div>
	<div class="linkscon">
	<ul class="linkslist">
	  <s:iterator value="copartnerships">
		 <li><a href="<s:property value='siteUrl'/>" target="_blank"><img src="<s:property value='smallLogo'/>" width="95" height="34" /></a></li>
	  </s:iterator>
	 </ul>
	</div>
	<div class="linksfoot"></div>

</div>