<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<h1>
<ul>
	<li id="index"><a href="${ctx}/enterprise/entinfo/ent-info!forwardIndex.action">公司简介</a></li>
	<li id="prod"><a href="${ctx}/enterprise/entinfo/ent-info!forwardProduce.action">生产能力</a></li>
	<li id="devp"><a href="${ctx}/enterprise/entinfo/ent-info!forwardDev.action">研发能力</a></li>
	<li id="cert"><a href="${ctx}/enterprise/cert/cert-list.action">认证证书</a></li>
	<li id="crop"><a href="${ctx}/enterprise/cooperation/info-list.action">产业合作</a></li>
	<li id="dyna"><a href="${ctx}/enterprise/dynamic/dynamic-list.action">公司动态</a></li> 
	<li id="cate"><a href="${ctx}/enterprise/entcategory/ent-category-list.action">主营产品</a></li>
</ul>
</h1>
