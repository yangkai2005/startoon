<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="keywords" content="星力网，游戏机供应，游戏机采购，动漫游戏资讯，动漫游戏展会，卖游戏机"/>
<meta http-equiv="description" content="星力网是广州星力动漫游戏产业园打造的动漫游戏行业最专业的游戏机供应、游戏机采购平台，提供最新、最全的游艺产品、游戏产品、电玩产品、游戏机配件、电脑板、框体机、模拟机等供应信息、采购信息，星力网资讯频道为行业提供最专业的动漫游戏行业资讯、行业新闻。"/>
<title>星力网_中国动漫游艺门户_动漫游戏产品网络交易平台_动漫游戏行业资讯</title>

<link href="${ctx}/resources/css/admin.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/resources/js/jquery.js" type="text/javascript"></script>
<link href="${ctx}/resources/v2/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>
<script type="text/javascript"  src="${pageContext.request.contextPath}/resources/js/jquery.selectCombo.1.2.6.js"></script>

<script type="text/javascript"> 
$(document).ready(function(){
 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg)},onsuccess:function(){return true;}});
 	//$("#name").formValidator({onshow:"",onfocus:"name can't empty",oncorrect:""}).inputValidator({min:1,max:100,onerror:"name can't empty"});
 	
	 $("#firstCategory").change(function(){
		$.getJSON("${pageContext.request.contextPath}/admin/category/category!subCategory.action",{id: $(this).val(), ajax: 'true'}, function(data){
			var j = data.array;
			var options = '';
			for (var i = 0; i < j.length; i++) {
				options += '<option value="' + j[i].oV + '">' + j[i].oT + '</option>';
			}
			//$("#subCategoryId").html(options);
		})
	 });
});
</script>

</head>

<body>
<div class="mTitle">
  <b class="bbig">添加类别</b>
</div>
<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/admin/category">
<s:hidden name="nextMethod" />
<s:hidden name="requestId" />
<s:hidden name="id" />
<s:hidden name="orderNo"  value="9999" />
<!--list -->
<div class="mainAdd">
<table class="addTable">
  <tr>
    <th>父类别名称:</th> 
	<td> <s:select list="%{categoryList}" listKey="id" listValue="name" headerKey="0" headerValue="--父类别--" name="category.id" id="fatherCategory"></s:select> <span id="nameTip"></span> </td>
  </tr>
  <tr>
    <th>类别名称:</th> 
	<td> <s:textfield name="name" id="name" size="30"></s:textfield><span id="nameTip"></span> </td>
  </tr>
</table>
</div>
<!--end list -->
<div class="addToolbar">
    <p><button class="btn" type="submit"><b>submit</b></button>
    <button class="btn" type="button" onclick="location.href='<s:url action="category-list" namespace="/admin/category"/>?restore_params=true'">cancel</button></p>
</div>
 
 </s:form>
</body>
</html>