<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="org.j2eeframework.commons.pager.Pager"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="keywords" content="星力网，游戏机供应，游戏机采购，动漫游戏资讯，动漫游戏展会，卖游戏机"/>
<meta http-equiv="description" content="星力网是广州星力动漫游戏产业园打造的动漫游戏行业最专业的游戏机供应、游戏机采购平台，提供最新、最全的游艺产品、游戏产品、电玩产品、游戏机配件、电脑板、框体机、模拟机等供应信息、采购信息，星力网资讯频道为行业提供最专业的动漫游戏行业资讯、行业新闻。"/>
<title>星力网_中国动漫游艺门户_动漫游戏产品网络交易平台_动漫游戏行业资讯</title>

<link rel="stylesheet" type="text/css" href="${ctx}/css/member.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />

<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>

<link href="${ctx}/resources/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>

<script type="text/javascript">

$(function(){

 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg);},onsuccess:function(){return true;}});
 	$("#receiveEmail").formValidator({onshow:"",onfocus:"接收邮箱不为空",oncorrect:""}).inputValidator({min:1,max:100,onerror:"接收邮箱不为空"}).regexValidator({regexp:"email",datatype:"enum",onerror:"邮箱格式不正确"});;
 	$(":radio[name=type]").formValidator({onshow:"",onfocus:"",oncorrect:""}).inputValidator({min:1,max:1,onerror:"请选择信息类型"});
	
	 $("#category1").change(function(){
		 $("#category2").html('');
		 $("#category3").html('');
		 $("#category4").html('');
		$.getJSON("${pageContext.request.contextPath}/enterprise/supply/supply!subCategory.action",{fatherId: $(this).val(), ajax: 'true'}, function(data){
			var j = data.array;
			var options = '';
			for (var i = 0; i < j.length; i++) {
				options += '<option value="' + j[i].oV + '">' + j[i].oT + '</option>';
			}
			$("#category2").html(options);
		});
		var c = $('#category1 option:selected').text();
		$('#selectedCategory').html(c);
		
	 });
	 
	 $("#category2").change(function(){
			$("#category3").html('');
			$("#category4").html('');		 
			$.getJSON("${pageContext.request.contextPath}/enterprise/supply/supply!subCategory.action",{fatherId: $(this).val(), ajax: 'true'}, function(data){
				var j = data.array;
				var options = '';
				for (var i = 0; i < j.length; i++) {
					options += '<option value="' + j[i].oV + '">' + j[i].oT + '</option>';
				}
				$("#category3").html(options);
			})

			var c1 = $('#category1 option:selected').text();
			var c2 = $('#category2 option:selected').text();
			$('#selectedCategory').html(c1 + '->' + c2);

	 });
	 
	 $("#category3").change(function(){
			$("#category4").html('');
		 
			$.getJSON("${pageContext.request.contextPath}/enterprise/supply/supply!subCategory.action",{fatherId: $(this).val(), ajax: 'true'}, function(data){
				var j = data.array;
				var options = '';
				for (var i = 0; i < j.length; i++) {
					options += '<option value="' + j[i].oV + '">' + j[i].oT + '</option>';
				}
				$("#category4").html(options);
			})

			var c1 = $('#category1 option:selected').text();
			var c2 = $('#category2 option:selected').text();
			var c3 = $('#category3 option:selected').text();
			
			$('#selectedCategory').html(c1 + '->' + c2 + '->' + c3);
			loadAttr();
			
	 });
});


function loadAttr() {
	
	var c4 = $('#category4').val();
	var c3 = $('#category3').val();
	var c2 = $('#category2').val();
	var c1 = $('#category1').val();

	var categoryId = 0;

	if(c4 && $.trim(c4)!='') {
		categoryId = c4;
	} else if(c3 && c3!='') {
		categoryId = c3;
	} else if(c2 && c2!='') {
		categoryid = c2;
	} else if(c1 && c1!='') {
		categoryId = c1;
	}

	$('#category_attr').load('${pageContext.request.contextPath}/enterprise/supply/supply!properties.action', {categoryId:categoryId});
}

</script>

</head>
<body>
<s:include value="/WEB-INF/content/inc/header.jsp"/>
<s:include value="/WEB-INF/content/inc/person-left.jsp"/>

<%-- 列表管理 --%>
<div class="memright">
<div class="title4"> <div class="hotline">客服热线：020-39106666</div>
	 <div class="titlemu2">
	 
	 <h2 class="q3"><s:a namespace="/enterprise/booking" action="booking-list">免费订阅</s:a></h2> 
	 
	 </div>
	 </div>
	 
	<div class="memcon">
	 	
		<div class="subscribe">
		<s:form id="form1" namespace="/member/booking" action="booking!insert">
		<table width="100%" border="0" cellspacing="0" class="tablesub">
		  <tbody><tr>
		    <td>接收邮箱：<input type="text" id="receiveEmail" name="receiveEmail" class="txtge1" value="<s:property value='#session.enterprise_user.bookingEmail'/>"/>请注意查收您订阅的信息 </td>
		  </tr>
		  <tr>
		    <td><strong>供求商机</strong>：</td>
		  </tr>
		  <tr>
		    <td><p style="margin-bottom:10px;">请选择你要订阅的行业商机</p>
			<p>
				<s:select id="category1" name="category1" list="%{categories}" cssClass="selectk2" listKey="id" listValue="name"  size="8"></s:select>
				<select size="8" name="category2" id="category2" class="selectk2"><option value="">请选择二级分类</option></select>
			    <select size="8" name="category3" id="category3" class="selectk2"><option value="">请选择三级分类</option></select>
			</p>
			</td>
		  </tr>
		  <tr>
		    <td><strong>信息类型</strong>：</td>
		  </tr>
		  <tr>
		    <td style="padding-left:20px;"><s:radio id="type" name="type" list="#{0:'供应', 1:'求购'}"></s:radio></td>
		  </tr>
		  <tr>
		    <td style="padding-left:20px;"><input type="submit" name="Submit" value="添 加" style="width:58px; cursor:pointer"/></td>
		  </tr>
		</tbody>
		</table>
		</s:form>

		<div class="cls"></div>
		<div style="padding-top:15px; float:left; width:100%;">
	<table width="100%" border="0" cellspacing="1" class="xinxitable" bgcolor="#ebebeb">
  <tbody><tr>
    <th width="15%">信息类型</th>
    <th width="30%">供求商机</th>
    <th width="30%">接收邮箱</th>
    <th>操作</th>
  </tr>
  <s:iterator value="pager.items">
  <tr>
    <td><span class="red"><s:if test="type==0">供应</s:if><s:if test="type==1">求购</s:if></span></td>
    <td><span class="red"><s:property value='category.name'/></span></td>
    <td class="tdright"><s:property value="receiveEmail"/></td>
    <td><a href="<s:url namespace="/member/booking" action="booking!delete"/>?requestId=${id}">删除</a></td>
  </tr>
  </s:iterator>
</tbody></table>
</div>
		
		</div>
	 
	 
	</div>
	 
	 

</div>
<%-- 列表管理 --%>

<div class="cls"></div>
<div style="clear:both;"></div>

<s:include value="/WEB-INF/content/inc/footer.jsp"/>
</body>
</html>