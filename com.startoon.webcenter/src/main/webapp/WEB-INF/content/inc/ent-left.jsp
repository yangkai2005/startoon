<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="left">

<h1><img src="${ctx}/images/lefttitle1.jpg" /></h1>

<h2>
<div class="leftnav">
<ul class="leftlist">
	<li><a href="${ctx}/enterprises/ent-index.action?enterpriseId=<s:property value='enterpriseId'/>">公司首页</a></li>
	<li><a href="${ctx}/enterprises/ent-info.action?enterpriseId=<s:property value='enterpriseId'/>">公司信息</a></li>
	<li><a href="${ctx}/enterprises/ent-produce.action?enterpriseId=<s:property value='enterpriseId'/>">产品中心</a></li>
	<li><a href="${ctx}/enterprises/ent-cert.action?enterpriseId=<s:property value='enterpriseId'/>">认证证书</a></li>
	<li><a href="${ctx}/enterprises/ent-develop.action?enterpriseId=<s:property value='enterpriseId'/>">产研能力</a></li>
	<li><a href="${ctx}/enterprises/crop/info-list.action?enterpriseId=<s:property value='enterpriseId'/>">产业合作</a></li>
	<li><a href="${ctx}/enterprises/ent-hr.action?enterpriseId=<s:property value='enterpriseId'/>">人才招聘</a></li>
	<li><a href="${ctx}/enterprises/dynamic/dynamic-list.action?enterpriseId=<s:property value='enterpriseId'/>">公司动态</a></li>
	<li><a href="${ctx}/enterprises/entmsg/index.action?enterpriseId=<s:property value='enterpriseId'/>">留&nbsp;&nbsp;&nbsp;&nbsp;言</a></li>
	<li>
	<s:if test="#session.enterprise_user!=null">
	<a style="color:red;font-weight:bold;text-decoration:underline;" href="#" onclick="doFavorite();">我要收藏</a>
	</s:if>
	<s:else>
	<a style="color:red;font-weight:bold;text-decoration:underline;" href="#" onclick="alert('请先登录后再收藏!');">我要收藏</a>
	</s:else>
	</li>
</ul>
</div>
</h2>

<h3>
<div class="lefttitle"><img src="${ctx}/images/lefttitle2.jpg" /></div>
<div class="leftcon">
	<strong>公司名称:</strong><s:property value="enterprise.name"/><br />
	<strong>联系人:</strong><s:property value="enterprise.linkman"/><s:if test="enterprise.linkman!=null"><s:if test="enterprise.sex">先生</s:if><s:if test="!enterprise.sex">女士</s:if></s:if><br />
	<strong>移动电话：</strong><s:property value="enterprise.mobilePhone"/><br />
	<strong>联系电话：</strong><s:property value="enterprise.telephone"/><br />
	<strong>传真:</strong><s:property value="enterprise.fax"/><br />
	<strong>邮箱：</strong><s:property value="enterprise.email"/><br />
</div>
</h3>
</div>