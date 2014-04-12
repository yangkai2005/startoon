<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="keywords" content="星力网，游戏机供应，游戏机采购，动漫游戏资讯，动漫游戏展会，卖游戏机"/>
<meta http-equiv="description" content="星力网是广州星力动漫游戏产业园打造的动漫游戏行业最专业的游戏机供应、游戏机采购平台，提供最新、最全的游艺产品、游戏产品、电玩产品、游戏机配件、电脑板、框体机、模拟机等供应信息、采购信息，星力网资讯频道为行业提供最专业的动漫游戏行业资讯、行业新闻。"/>
<title>星力网_中国动漫游艺门户_动漫游戏产品网络交易平台_动漫游戏行业资讯</title>

<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/member.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />
<script src="${ctx}/resources/js/jquery.js" type="text/javascript"></script>
<link href="${ctx}/resources/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>
<script src="${ctx}/fckeditor/fckeditor.js" type="text/javascript"></script>
<script type="text/javascript"  src="${pageContext.request.contextPath}/resources/js/jquery.selectCombo.1.2.6.js"></script>
<script type="text/javascript"> 
$(document).ready(function(){

	//初始化父类ID下拉选中
	$("#price_unit").val('${supply.unit}');
	
 	$.formValidator.initConfig({formid:"addForm",onerror:function(msg){alert(msg)},onsuccess:function(){return true;}});
 	$("#name").formValidator({onshow:"",onfocus:"产品名称不为空",oncorrect:""}).inputValidator({min:1,max:100,onerror:"产品名称不为空"});
 	$("#price").formValidator({onshow:"",onfocus:"",oncorrect:""}).regexValidator({regexp:"num",datatype:"enum",onerror:"价格格式不正确,请输入数字"});
 	$("#upload").formValidator({onshow:"",onfocus:"",oncorrect:""}).inputValidator({min:1,onerror:"请选择产品的图片！"});

	$("#sBtn").click(function () {

		var price_unit = document.getElementById("price_unit");
	 	if(price_unit.value=="0"){
			alert("请选择单位!");
			price_unit.focus();
			return false;
	 	}
	 	
		var categoryId = $("select[name='categoryId']").val();
		if(categoryId == 0)
		{
			alert("请选择产品分类");
		}else
		{
			$("#addForm").submit();
		}
		
	});

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
			})
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
	 });
 	
});
</script>
<script type="text/javascript">
			function FCKeditor_OnComplete(editorInstance) {
				window.status = editorInstance.Description;
			}
</script>
</head>
<body>
<s:include value="/WEB-INF/content/inc/header.jsp"/>
<s:include value="/WEB-INF/content/inc/person-left.jsp"/>


<div class="memright">
<div class="title4"> <div class="hotline">客服热线：020-39106666</div>
	 <div class="titlemu2">
	
	 
	 <h1>发布供应</h1>
	 </div>
	 </div>
	 
	<div class="memcon">

   <div class="maink2">
<s:form id="addForm" action="%{actionName+'!'+nextMethod}" namespace="/enterprise/supply"  method="POST" enctype="multipart/form-data">
<s:hidden name="nextMethod" />
<s:hidden name="requestId" />
<s:hidden name="id" />
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="paddk">
  <tr>
    <td class="pktdl1">信息类型：<span class="red">&nbsp;</span></td>
    <td class="pktdr1">
    <s:if test="supply.type==0">
		<input name="supply.type" type="radio" value="0"  checked="checked"/>产品
		<input name="supply.type" type="radio" value="1"  />服务
	</s:if>
	<s:else>
		<input name="supply.type" type="radio" value="0"/>产品
		<input name="supply.type" type="radio" value="1" checked="checked" />服务
	</s:else>
	</td>
  </tr>
  <tr>
    <td valign="top" class="pktdl2">产品名称：<span class="red">*</span></td>
    <td class="pktdr2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="238"><input name="supply.name" id="name" type="text" value="${supply.name}" class="input6"/></td>
        <td><div class="msg1">提示：只填写产品名称，切勿将型号与品牌，或是其它内容填写在文本框内。</div></td>
      </tr>
    </table>
   </td>
  </tr>
  <tr>
    <td valign="top" class="pktdl2">价格：<span class="red">*</span></td>
    <td class="pktdr2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="238" valign="top"><input name="supply.proPrice" value="${supply.proPrice}" id="price" type="text" class="input7" value="0"/>
          &nbsp;元&nbsp;<span class="ml2">
            <s:select id="price_unit" name="unit" listKey="id" listValue="name" headerKey="0" headerValue="请选择单位" cssClass="selectk3" list="%{units}"></s:select>
          </span>
         
          </td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td class="pktdl2">品牌/型号：<span class="red">&nbsp;</span></td>
    <td class="pktdr2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="238"><input name="supply.brand" value="${supply.brand}" id="model_brand" type="text" class="input6"/><div id="model_brandTip"></div></td>
        <td><div class="msg1">提示：请填写当前产品的品牌与型号，系统会自动把您的品牌列入品牌库。</div></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td class="pktdl1">产品原产地：<span class="red">&nbsp;</span></td>
    <td class="pktdr1"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td style="width:238;valign:top;"><input name="supply.source" value="${supply.source}" id="made_from" type="text" class="input6"/></td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td valign="top" class="pktdl1">产品分类：<span class="red">*</span></td>
    <td class="pktdr2">
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="390">
          <s:select name="category1" list="%{categories}" id="category1" cssClass="selectk2" listKey="id" listValue="name" headerKey="0" headerValue="-请选择一级分类-" size="8"></s:select>
		  <select name="category2" id="category2" size="8" class="selectk2"></select>
		  <select name="category3" id="category3" size="8" class="selectk2"></select>
		  <select name="category4" id="category4" size="8" class="selectk2"></select>
           </td>
        </tr>
      </table>
	  </td>
  </tr>
  
  <tr>
    <td class="pktdl2">有效期：<span class="red">&nbsp;</span></td>
    <td class="pktdr12">
    	<s:radio name="supply.period" list="#{0:'半年',1:'1年',3:'3年',9999:'长期'}" listKey="key" listValue="value" value="supply.period"></s:radio>
    </td>
  </tr>
 <tr>
    <td class="pktdl2">详细说明：<span class="red">&nbsp;</span></td>
    <td class="pktdr12">
    	<FCK:editor instanceName="supply.description"  toolbarSet="B2BCfg">
				<jsp:attribute name="value">
					${supply.description }
				</jsp:attribute>
		</FCK:editor>
    </td>
  </tr>
 
<%-- img begin --%>
  <tr>
    <td class="pktdl2">产品图片：<span class="red">&nbsp;</span></td>
    <td class="pktdr12">
    	<input type="file" name="upload" id="upload"/>
    </td>
  </tr>
<%-- img end --%>
 
  <tr>
    <td class="pktdl2">&nbsp;</td>
    <td class="pktdr2">
<input id="sBtn" name="sBtn" type="button"  value="确定"  class="btn01"/>
<input name="Input4" type="reset"  value="重置"  class="btn01"/>

    </td>
  </tr>
</table>
</s:form>
</div>
</div>

	

	 
	 

</div>

   <!--  //memberright over--> 





<!--  //member over-->


<div class="cls"></div>



<s:include value="/WEB-INF/content/inc/footer.jsp"/>
</body>
</html>