<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="headnavindex">
<div class="indexlogo"><a href="${ctx}/index.action"><img src="${ctx}/images/logo.jpg" width="200" height="80" title="广州力凯信息科技有限公司" alt="广州力凯信息科技有限公司" /></a></div>
<div class="indexnav">
<ul class="indexnavlist">
<li><h1><a href="${ctx}/information/info/info-index.action">资讯中心</a></h1>
<h2>
<p>
<a href="${ctx}/information/info/info-list.action?infoTypeId=13" >行业</a>
<a href="${ctx}/information/info/info-list.action?infoTypeId=14">政策</a>
<a href="${ctx}/information/info/info-list.action?infoTypeId=15">市场</a>
</p>
<p>
<a href="${ctx}/information/info/info-list.action?infoTypeId=16">产品</a>
<%--
<a href="${ctx}/information/info/info-list.action?infoTypeId=17"><span class="red">专题</span></a>
 --%>
<a href="${ctx}/information/subject/index.action"><span class="red">专题</span></a>
<a href="${ctx}/information/info/info-list.action?infoTypeId=18">图片</a>
</p>
</h2>
</li>

<li><h1><a href="${ctx}/information/survey/index.action">行情调查</a></h1>
<h2>
<p>
<a href="${ctx}/information/survey/info-list.action?infoTypeId=22"><span class="red">在线调查</span></a>
<a href="${ctx}/information/survey/info-list.action?infoTypeId=21">行情综述</a>
</p>
<p>
<a href="${ctx}/information/survey/info-list.action?infoTypeId=19">编辑推荐</a>
<a href="${ctx}/information/survey/info-list.action?infoTypeId=20">人气排行</a>
</p>
</h2>
</li>

<li>
	<h1><a href="${ctx}/information/hightvisit/index.action"><span class="red">高端▪访谈</span></a></h1>
	<h1><a href="${ctx}/information/bar/index.action"><span class="red">店长吧</span></a></h1>
	<h1><a href="${ctx}/information/observe/index.action"><span class="red">星力观察家</span></a></h1>
</li>

<li><h1><a href="${ctx}/information/show/index.action">创意SHOW</a></h1>
<h2>
<p>
<a href="${ctx}/information/show/info-list.action?infoTypeId=23">团体</a>
<a href="${ctx}/information/show/info-list.action?infoTypeId=24">个人</a>
</p>
<p>
<a href="${ctx}/information/video/info-list.action?infoTypeId=25">动画</a>
<a href="${ctx}/information/show/info-list.action?infoTypeId=26">漫画</a>
</p>
</h2>
</li>

<li><h1><a href="${ctx}/information/events/index.action">展会活动</a></h1>
<h2>
<p>
<a href="${ctx}/information/events/info-list.action?infoTypeId=27">报道</a>
<a href="${ctx}/information/events/info-list.action?infoTypeId=289">预告</a>
</p>
<p><a href="${ctx}/information/events/info-list.action?infoTypeId=30">图集</a></p>
</h2>
</li>
<li><h1><a href="${ctx}/information/cooperation/index.action">产业合作</a></h1>
<h2>
<p>
<a href="${ctx}/information/info/info-list.action?infoTypeId=31">代理</a>
<a href="${ctx}/information/info/info-list.action?infoTypeId=32"><span class="red">合作</span></a>
</p>
<p>
<a href="${ctx}/information/info/info-list.action?infoTypeId=33">加盟</a>
<a href="${ctx}/information/info/info-list.action?infoTypeId=34">商机</a>
</p>
</h2>
</li>

<li><h1><a href="${ctx}/information/analogworld/index.action">模拟世界</a></h1>
<h2>
<p>
<a href="${ctx}/information/analogworld/info-list.action?infoTypeId=35">技术</a>
<a href="${ctx}/information/analogworld/info-list.action?infoTypeId=36">市场</a>
</p>
<p>
<a href="${ctx}/information/analogworld/info-list.action?infoTypeId=37">产品</a>
</p>
</h2>
</li>

<li style="background:none; padding-right:0"><h1><a href="${ctx}/information/hrservice/index.action">人才服务</a></h1>
<h2>
<p><a href="${ctx}/information/hrservice/jobs-list.action">企业招聘</a></p>
<p><a href="${ctx}/information/hrservice/talent-list.action">星力人才库</a></p>
</h2>
</li>

</ul>


</div>


</div>