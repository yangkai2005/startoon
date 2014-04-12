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
 	//$("#attrTypeId").formValidator({onshow:"",onfocus:"还没有选择属性分类",oncorrect:""}).inputValidator({min:1,max:100,onerror:"还没有选择属性分类"});
 	
	var msg = '${msg}';
	if(msg=="success"){
		alert('操作成功!');
	}

});

function doSubmit(){
	if($("#attrname").val()==""){
		alert('属性名称不能为空!');
		$("#attrname")[0].focus();
		return false;
	}

	var attrinput = document.getElementsByName("attrinput");
	if(attrinput(0).checked){
		if($("#attrvalue").val()==""){
			alert('下拉选择：属性值不能为空!');
			$("#attrvalue")[0].focus();
			return false;
		}
	}

	return true;

}
</script>

</head>

<body>
<div class="mTitle">
  <b class="bbig">修改产品类别属性</b>
</div>
<form id="form1" name="frmInput" onsubmit="return doSubmit();" action="${pageContext.request.contextPath }/backmgr/category/category!updateattr.action" method="post">
<!--list -->
<div class="mainAdd">
	<table class="addTable">
  <tr>
    <td valign="top" class="pktdl2">所属分类：&nbsp;</td>
    <td class="pktdr2">
    	${cid} - ${cname}
  	</td>
  </tr>
   <tr>
    <td valign="top" class="pktdl2">输入类型：</td>
    <td class="pktdr2">
    <s:if test="categoryAttr.attrInput==1">
    	<input type="radio" checked value="1" name="attrinput"/>下拉选择
    	<input type="radio" value="2" name="attrinput"/>手工输入
    </s:if>
    <s:else>
    	<input type="radio" value="1" name="attrinput"/>下拉选择
    	<input type="radio" value="2" checked name="attrinput"/>手工输入
    </s:else>
    
   </td>
  </tr>
   <!--<tr>
    <td valign="top" class="pktdl2">属性分类：</td>
    <td class="pktdr2">
    	<s:select id="attrTypeId" name="attrTypeId" list="%{attrTypes}" listKey="id" listValue="name" headerKey="" headerValue="请选择属性分类"></s:select><span id="attrTypeIdTip"></span>
   </td>
  </tr>   
   --><tr>
    <td valign="top" class="pktdl2">属性名称：</td>
    <td class="pktdr2">
    <input name="attrname" id="attrname" maxlength="30" type="text" value="${categoryAttr.attrName}" class="input6"/>
   </td>
  </tr>
    <tr>
    <td valign="top" class="pktdl2">属性值：</td>
    <td class="pktdr2">
    <textarea name="attrvalue" rows="5" cols="50" id="attrvalue" class="input6">${categoryAttr.attrValue}</textarea>
    <br/>(注：多个值之间用逗号隔开，如: 中国,日本,美国)
   </td>
  </tr>
</table>
</div>
<div class="addToolbar">
	<input type="hidden" name="cid" value="${cid}" id="cid"/>
	<input type="hidden" name="aid" value="${categoryAttr.id}" id="aid"/>
    <p><button class="btn" type="submit"><b>确定</b></button>
    <button class="btn" type="button" onclick="location.href='<s:url action="category-attr-list" namespace="/backmgr/categoryattr"/>?cid=${cid}&restore_params=true'">返回</button></p>
</div>
</form>
<!--end list -->
</body>
</html>