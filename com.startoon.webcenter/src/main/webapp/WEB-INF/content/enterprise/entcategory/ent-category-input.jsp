<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="keywords" content="星力网，游戏机供应，游戏机采购，动漫游戏资讯，动漫游戏展会，卖游戏机"/>
<meta http-equiv="description" content="星力网是广州星力动漫游戏产业园打造的动漫游戏行业最专业的游戏机供应、游戏机采购平台，提供最新、最全的游艺产品、游戏产品、电玩产品、游戏机配件、电脑板、框体机、模拟机等供应信息、采购信息，星力网资讯频道为行业提供最专业的动漫游戏行业资讯、行业新闻。"/>
<title>星力网_中国动漫游艺门户_动漫游戏产品网络交易平台_动漫游戏行业资讯</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/member.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />
<script src="${ctx}/resources/js/jquery.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/js/nav.js"></script>

<link href="${ctx}/resources/jquery-ui/css/custom-theme/jquery-ui.custom.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/resources/jquery-ui/js/jquery-ui.custom.min.js" type="text/javascript"></script>
<script src="${ctx}/resources/jquery-ui/js/ui.datepicker-zh-CN.js" type="text/javascript"></script>

<script type="text/javascript">
$(document).ready(function(){
	<s:if test="flag">alert('添加主营产品成功！');</s:if>
	
	$("#cate").addClass("q2");
	$('#btnSubmit').click(function() {
		$('#form1').submit();
	});
	$('#btnAdd').click(function() {
		var c1 = $("#category1 option:selected").attr("text");
		var c2 = $("#category2 option:selected").attr("text");
		var c3 = $("#category3 option:selected").attr("text");
		var v1 = $("#category1 option:selected").val();
		var v2 = $("#category2 option:selected").val();
		var v3 = $("#category3 option:selected").val();
		var name = c1;
		if(c2) name = name + '->' + c2;
		if(c3) name = name + '->' + c3; 

		var cid;
		if(v3) cid = v3;
		else if(v2) cid = v2;
		else if(v1) cid = v1;
		
		var del = "&nbsp;<a href='#' onclick='return del(this)'><font color='red'>删除</font></a><input type='hidden' name='categoryIds' value='" + cid + "'/>";
		var html = '<div class="bp3" style="width:100%; margin:10px 0; float:left;">' + name + del + '</div>';

		$("#pos").before(html);

		var div = $(".bp3");
		if(div && div.length>0) $("#sumitOpr").show();
	});


	 $("#category1").change(function(){
		 $("#category2").html('');
		 $("#category3").html('');
			$.getJSON("${pageContext.request.contextPath}/enterprise/supply/supply!subCategory.action",{fatherId: $(this).val(), ajax: 'true'}, function(data){
				var j = data.array;
				var options = '';
				for (var i = 0; i < j.length; i++) {
					options += '<option value="' + j[i].oV + '">' + j[i].oT + '</option>';
				}
				$("#category2").html(options);
			})
	 });
	 
	 $("#category2").change(function(){
			$("#category3").html('');
			$.getJSON("${pageContext.request.contextPath}/enterprise/supply/supply!subCategory.action",{fatherId: $(this).val(), ajax: 'true'}, function(data){
				var j = data.array;
				var options = '';
				for (var i = 0; i < j.length; i++) {
					options += '<option value="' + j[i].oV + '">' + j[i].oT + '</option>';
				}
				$("#category3").html(options);
			})
	 });
});
function del(e) {
	$(e).parent().remove();
	return false;
}

</script>
<script type="text/javascript">
	function FCKeditor_OnComplete(editorInstance) {
		window.status = editorInstance.Description;
	}
</script>
</head>

<body>

<%-- header --%>
<s:include value="/WEB-INF/content/inc/header.jsp"></s:include>
<%-- header --%>
		

<div class="cls"></div>


<%-- main begin --%>
<div class="main">

<div class="member">
<%-- left --%>
<s:include value="/WEB-INF/content/inc/member-left.jsp"></s:include>
<%-- left --%>

<%-- right --%>

<div class="memright">
	<div class="title4">
		<div class="hotline">客服热线：020-39106666</div>
		<div class="titlemu2">
			<h1>企业管理</h1>
		</div>
	</div>
	 
	<div class="memcon">
		<div class="memqy">
		<s:include value="/WEB-INF/content/enterprise/entinfo/menu.jsp" />
		
		<h2>
		<br/>
		<p>
          <s:select name="category1" list="%{categories}" id="category1" cssClass="selectk2" listKey="id" listValue="name" headerKey="0" headerValue="-请选择一级分类-" size="8"></s:select>
		  <select name="category2" id="category2" size="8" class="selectk2"></select>
		  <select name="category3" id="category3" size="8" class="selectk2"></select>
		 </p>
		<p align="center">
			<input id='btnAdd' type="button" name="preview"  value="添加"  class="btn02" />
		</p>
		<form id="form1" name="form1" action="${ctx}/enterprise/entcategory/ent-category!insert.action" method="post">
		<div id="pos"></div>
		</form>
		<p align="center" style="display: none;" id="sumitOpr">
			<input id='btnSubmit' type="button" name="preview"  value="确定"  class="btn01" />
			<input name="Input4" type="button"  value="取消"  class="btn02" onclick="javascript:history.back()"/>
		</p>
		</h2>
		
		</div>
	</div>
</div>

<%-- right --%>
</div>


</div>
<%-- main end --%>

<div class="cls"></div>
<div class="cls"></div>
  
<%-- footer --%>
<s:include value="/WEB-INF/content/inc/footer.jsp"/>
<%-- footer --%>	
</body>
</html>