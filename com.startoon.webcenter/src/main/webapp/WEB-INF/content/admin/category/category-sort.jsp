<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="keywords" content="星力网，游戏机供应，游戏机采购，动漫游戏资讯，动漫游戏展会，卖游戏机"/>
<meta http-equiv="description" content="星力网是广州星力动漫游戏产业园打造的动漫游戏行业最专业的游戏机供应、游戏机采购平台，提供最新、最全的游艺产品、游戏产品、电玩产品、游戏机配件、电脑板、框体机、模拟机等供应信息、采购信息，星力网资讯频道为行业提供最专业的动漫游戏行业资讯、行业新闻。"/>
<title>星力网_中国动漫游艺门户_动漫游戏产品网络交易平台_动漫游戏行业资讯</title>

<link href="${ctx}/resources/css/admin.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/resources/jquery-ui-1.8.9/js/jquery-1.4.4.min.js" type="text/javascript"></script>

<link rel="stylesheet" href="${ctx}/resources/jquery-ui-1.8.9/css/ui-lightness/jquery-ui-1.8.9.custom.css"/> 
<link href="${ctx}/resources/css/admin.css" rel="stylesheet" type="text/css" />

<script src="${ctx}/resources/jquery-ui-1.8.9/js/jquery-ui-1.8.9.custom.min.js" type="text/javascript"></script>

<style> 
	#sortable { list-style-type: none; margin: 0; padding: 0; width: 60%; }
	#sortable li { margin: 0 3px 3px 3px; padding: 0.4em; padding-left: 1.5em; font-size: 1.4em; height: 18px; }
	#sortable li span { position: absolute; margin-left: -1.3em; }
</style> 

<script> 
$(function() {
	$( "#sortable" ).sortable();
	$( "#sortable" ).disableSelection();

	$('#submit').click(function() {
		var arr = new Array();
		$('li[lang=ids]').each(function(index) {
			arr.push(index + '-' + $(this).attr('id'));
		});
		var ids = arr.toString();
		$('input[name=sortIds]').val(ids);
		$('form').submit();
	});

	$("#categoriesList").load("${pageContext.request.contextPath}/admin/category/category-sort-list.action", {fatherId: 0});

	 $("#category1").change(function(){
		 $("#category2").html('');
		 $("#category3").html('');
		 $("#category4").html('');
		$.getJSON("${pageContext.request.contextPath}/admin/category/category-sort!subCategory.action",{fatherId: $(this).val(), ajax: 'true'}, function(data){
			var j = data.array;
			var options = '<option value="">--请选择--</option>';
			for (var i = 0; i < j.length; i++) {
				options += '<option value="' + j[i].oV + '">' + j[i].oT + '</option>';
			}
			$("#category2").html(options);
		});

		$("#categoriesList").load("${pageContext.request.contextPath}/admin/category/category-sort-list.action", {fatherId: $(this).val()});
	 });
	 
	 $("#category2").change(function(){
			$("#category3").html('');
			$("#category4").html('');		 
			$.getJSON("${pageContext.request.contextPath}/admin/category/category-sort!subCategory.action",{fatherId: $(this).val(), ajax: 'true'}, function(data){
				var j = data.array;
				var options = '<option value="">--请选择--</option>';
				for (var i = 0; i < j.length; i++) {
					options += '<option value="' + j[i].oV + '">' + j[i].oT + '</option>';
				}
				$("#category3").html(options);
			})

			$("#categoriesList").load("${pageContext.request.contextPath}/admin/category/category-sort-list.action", {fatherId: $(this).val()});

	 });
	 
	 $("#category3").change(function(){
			$("#category4").html('<option value="">--请选择--</option>');
		 
			$.getJSON("${pageContext.request.contextPath}/admin/category/category-sort!subCategory.action",{fatherId: $(this).val(), ajax: 'true'}, function(data){
				var j = data.array;
				var options = '';
				for (var i = 0; i < j.length; i++) {
					options += '<option value="' + j[i].oV + '">' + j[i].oT + '</option>';
				}
				$("#category4").html(options);
			})

			$("#categoriesList").load("${pageContext.request.contextPath}/admin/category/category-sort-list.action", {fatherId: $(this).val()});
	 });
	 
});

function chg(id_num){
    var oa = document.getElementById(id_num);
    var ob = document.getElementById("ImgArrow");
	 var imgButton = document.getElementById("imgButton");
    if(oa.style.display == "block"){
            oa.style.display = "none";
            imgButton.src = "${ctx}/resources/images/icon_down.gif";
			 imgButton.alt = "展开搜索";
    }else{
            oa.style.display = "block";
            imgButton.src = "${ctx}/resources/images/icon_up.gif";
			 imgButton.alt = "隐藏搜索";
    }
    return false;
}
</script> 
</head>
<body> 

<%-- 查询 --%>

<div class="mTitle">
  <span class="hidsearch"><a href="javascript:void(0)" onclick="return chg('searchList');" id="ImgArrow"><img src="${ctx}/resources/images/icon_down.gif" id ="imgButton" />展开搜索</a></span>
  <b class="bbig">排序类别选择</b>
</div>
<s:form  id="searchForm" action="category-list" namespace="/admin/category">
<div class="searchBar" id="searchList">
  <table class="searchTable">
  <tr>
    <td width="20%">
    <select id="category1" name="category1">
    	<option value="">--请选择--</option>
    	<s:iterator value="categories">
    	<option value="<s:property value='id'/>"><s:property value='name'/></option>
    	</s:iterator>
    </select>
    </td>
    <td width="20%">
    <select id="category2" name="category2"><option value="">--请选择--</option></select>
	</td>
    <td width="20%">
    <select id="category3" name="category3"><option value="">--请选择--</option></select>
	</td>
    <td>
    <select id="category4" name="category4"><option value="">--请选择--</option></select>
	</td>
  </tr>
  </table>
</div>
</s:form> 
<%-- 查询 --%>

<div class="mainList">
<div class="mTitle">
  <b class="bbig">类别排序</b>
</div>

 
<!--list -->
<div class="mainList">

<div class="demo" id="categoriesList"> 
</div>

<!-- End demo --> 
 
 
 
<div class="demo-description"> 
<p> 
请用鼠标拖动分类进行排序！
</p> 
</div><!-- End demo-description --> 
 
<form action="${ctx}/admin/category/category-sort!sort.action" method="post">
<input type="hidden" name="sortIds"/>
</form>

</div>
<!--end list -->
<div class="Toolbar">
  <div class="toolBt">
 		<a id="submit" href="#" title="提交"><span class="btn">提交</span></a>
 		<a href="<s:url action="category-list" namespace="/admin/category"/>" title="返回"><span class="btn">返回</span></a>
  </div>
</div>
</div>
</body> 
</html>