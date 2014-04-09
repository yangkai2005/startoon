<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>

<script type="text/javascript">
$(function() {
	$('#applyShow').click(function() {
		if(confirm('确定要申请成为创意show会员吗？')) {
			$.get('<s:url namespace="/member/show" action="info!apply"/>',
					function(data) { 
						if(data='success') {
							alert('创意show会员申请已经提交，请等待管理员审核！');
							location.reload();
						}
				  });
		}
	});
	$('#applyBar0').click(function() {
		if(confirm('确定要申请成为店长吧会员吗？')) {
			$.get('<s:url namespace="/member/bar" action="info!apply"/>',
					function(data) { 
						if(data=='success') {
							alert('店长吧会员申请已经提交，请等待管理员审核！');
							location.reload();
						}
					 }
			 );
		}
	});
});
</script>
<div class="memleft">
<h1><img src="${ctx}/images/title_mem.jpg"></h1>
<h2>
<div class="lefttab1">个人资料管理中心</div>
<div class="lefttab2">
<ul>
<li><a href="<s:url namespace="/member/base" action="base-info!edit"/>">个人资料管理</a></li>
<li><s:a namespace="/member/base" action="base-info!forwardPassword">修改密码</s:a></li>
</ul>
</div>

<div class="lefttab1">个人信息管理</div>
<div class="lefttab2">
<ul>
<li><a href="<s:url namespace="/member/supply" action="supply!input"/>">发布供应信息</a></li>
<li><a href="<s:url namespace="/member/supply" action="supply-list"/>">管理供应信息</a></li>
<li><a href="<s:url namespace="/member/postedpro" action="posted-pro!input"/>?requestId=0">发布求购信息</a></li>
<li><a href="<s:url namespace="/member/postedpro" action="posted-pro-list"/>?requestId=0">管理求购信息</a></li>
<li><a href="<s:url namespace="/member/booking" action="booking-list"/>">免费订阅</a></li>
<li><a href="<s:url namespace="/member/publishprice" action="publish-price-list"/>">信息中心</a></li>
<li><a href="<s:url namespace="/member/favorite" action="favorite-list"/>?type=0">我的收藏夹</a></li>
</ul>
</div>

<div class="lefttab1">我的职位</div>
<div class="lefttab2">
<ul>
<li><a href="${ctx}/information/hrservice/talent!edit.action" target="_blank">我的简历</a></li>
<li><a href="${ctx}/information/member/jobfavorite/job-favorite-list.action"/>职位收藏</a></li>
<li><a href="${ctx}/information/member/resumerecord/resume-record-list.action"/>应聘记录</a></li>
</ul>
</div>

<div class="lefttab1">个人申请信息</div>
<div class="lefttab2">
<ul>
<s:if test="#session.enterprise_user.isShow==0">
<li><a href="javascript:void(0)" id="applyShow">申请创意秀会员</a></li>
</s:if>
<s:if test="#session.enterprise_user.isShow==1">
<li><a href="javascript:void(0)" onclick="javascript:alert('你提交的创意秀会员申请还在审核当中！');" >申请创意秀会员</a></li>
</s:if>
<s:if test="#session.enterprise_user.isShow==2">
<li><s:a namespace="/member/show" action="info-list">创意秀会员</s:a></li>
</s:if>

<s:if test="#session.enterprise_user.isBar==0">
<li><a href="javascript:void(0)" id="applyBar0">申请店长吧会员</a></li>
</s:if>
<s:if test="#session.enterprise_user.isBar==1">
<li><a href="javascript:void(0)" onclick="javascript:alert('你提交的店长吧会员申请还在审核当中！');">申请店长吧会员</a></li>
</s:if>
<s:if test="#session.enterprise_user.isBar==2">
<li><s:a namespace="/member/bar" action="info-list">店长吧会员</s:a></li>
</s:if>
</ul>
</div>

<div class="lefttab1"><a href="${ctx}/help/help.action" target="_blank">帮助中心</a></div>

<div class="yijian">
<div class="yijiant1"><img src="${ctx}/images/feedback.jpg"></div>
<div class="yijiant2">
<p class="fp1">客服热线</p>
<p class="fp2"><e:config key="客服热线"/></p>
<p class="b">客服邮箱<br/>
<e:config key="客服邮箱"/></p>
</div>

</div>



</h2>

</div>