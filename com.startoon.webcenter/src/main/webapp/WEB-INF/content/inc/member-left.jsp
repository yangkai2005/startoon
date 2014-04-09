<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>

<div class="memleft">
<h1><img src="${ctx}/images/title_mem.jpg" /></h1>
<h2>
<div class="lefttab1"><a href="#">基本信息管理</a></div>
<div class="lefttab2">
<ul>
	<li><a href="${ctx}/enterprise/base/base-info.jsp">注册信息</a></li>
	<li><a href="${ctx}/enterprise/favorite/favorite-list.action?type=0">我的收藏</a></li>
	<li><a href="${ctx}/enterprises/ent-index.action?enterpriseId=${sessionScope.enterprise_user_id }" target="_blank">企业预览</a></li>
</ul>
</div>

<div class="lefttab1"><a href="#">企业信息管理</a></div>
<div class="lefttab2">
<ul>
	<li><a href="${ctx}/enterprise/enterprise/enterprise!info.action">企业信息</a></li>
	<li><a href="${ctx}/enterprise/entinfo/ent-info!forwardIndex.action">企业管理</a></li>
	<li><a href="${ctx}/enterprise/supply/supply!input.action">发布供应</a></li>
	<li><a href="${ctx}/enterprise/supply/supply-list.action?enterpriseId=${sessionScope.enterprise_user_id }&status=00">供应管理</a></li>
	<li><a href="${ctx}/enterprise/postedpro/posted-pro!input.action">发布采购</a></li>
	<li><a href="${ctx}/enterprise/postedpro/posted-pro-list.action?enterpriseId=${sessionScope.enterprise_user_id }">采购管理</a></li>
	<li><a href="${ctx}/enterprise/hrservice/jobs!input.action">发布招聘</a></li>
	<li><a href="${ctx}/enterprise/hrservice/jobs-list.action">招聘管理</a></li>
	<li><a href="${ctx}/enterprise/booking/booking-list.action">免费订阅</a></li>
	<li><a href="${ctx}/enterprise/publishprice/publish-price-list.action">信息中心</a></li>
</ul>
</div>
<div class="lefttab1"><a href="#">企业推广</a></div>
<div class="lefttab2">
<ul>
	<li><a href="${ctx}/enterprise/payment/my-account.action">我的账户</a></li>
	<li><a href="${ctx}/enterprise/payment/index.action">在线充值</a></li>
	<li><a href="${ctx}/enterprise/keyword/keyword-list.action">产品关键词竞价</a></li>
	<li><a href="${ctx}/enterprise/categorykeyword/category-keyword-list.action">类别关键词广告</a></li>
</ul>
</div>

<div class="lefttab1"><a href="${ctx}/help/help.action">帮助中心</a></div>

<div class="yijian">
<div class="yijiant1"><img src="${ctx}/images/feedback.jpg" /></div>
<div class="yijiant2">
<p class="fp1">客服热线</p>
<p class="fp2"><e:config key="客服热线"/></p>
<p class="b">客服邮箱<br/>
<e:config key="客服邮箱"/></p>
</div>

</div>
</h2>

</div>