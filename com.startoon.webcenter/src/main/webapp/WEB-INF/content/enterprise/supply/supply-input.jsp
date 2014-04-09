<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="keywords" content="星力网，游戏机供应，游戏机采购，动漫游戏资讯，动漫游戏展会，卖游戏机"/>
<meta http-equiv="description" content="星力网是广州星力动漫科技有限公司打造的动漫游戏行业最专业的游戏机供应、游戏机采购平台，提供最新、最全的游艺产品、游戏产品、电玩产品、游戏机配件、电脑板、框体机、模拟机等供应信息、采购信息，星力网资讯频道为行业提供最专业的动漫游戏行业资讯、行业新闻。"/>
<title>星力网_中国动漫游艺门户_动漫游戏产品网络交易平台_动漫游戏行业资讯</title>

<link rel="stylesheet" type="text/css" href="${ctx}/css/member.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />
<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<script src="${ctx}/resources/js/jquery.js" type="text/javascript"></script>

<link href="${ctx}/resources/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>

<script type="text/javascript"> 
$(document).ready(function(){

	<s:if test="%{errorMessage.length()>0}">alert('<s:property value='errorMessage' escape='html'/>');</s:if>
	
 	$.formValidator.initConfig({formid:"addForm",onerror:function(msg){alert(msg);},onsuccess:function(){return true;}});
 	$("#name").formValidator({onshow:"",onfocus:"产品名称不为空",oncorrect:""}).inputValidator({min:1,max:100,onerror:"产品名称不为空"});
 	$("#price").formValidator({onshow:"",onfocus:"",oncorrect:""}).regexValidator({regexp:"decmal4",datatype:"enum",onerror:"价格格式不正确,请输入数字"});
 	$("#upload1").formValidator({onshow:"",onfocus:"",oncorrect:""}).inputValidator({min:1,onerror:"请选择产品的图片！"});

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
	 $("#category4").change(function(){
			var c1 = $('#category1 option:selected').text();
			var c2 = $('#category2 option:selected').text();
			var c3 = $('#category3 option:selected').text();
			var c4 = $('#category4 option:selected').text();
			$('#selectedCategory').html(c1 + '->' + c2 + '->' + c3 + '->' + c4);
			loadAttr();		 
	 });

	$('#showCategoryAttr').click(function() {
		$('#category_attr').toggle();
		var dis = $("#category_attr").css("display");
		if(dis=='none') {
			$('#showAttr').show();
			$('#hideAttr').hide();
		}
	});

	$("#hideAttr").click(function() {
		$(this).hide();
		$("#showAttr").show();

		$('#category_attr').toggle();
		loadAttr();
	});

	$("#showAttr").click(function() {
		$(this).hide();
		$("#hideAttr").show();

		$('#category_attr').toggle();
		
		loadAttr();
	});


	<s:if test="nextMethod=='update'">
	//修改时初始化
	//1 load页面
	$('#category_attr').load('${pageContext.request.contextPath}/enterprise/supply/supply!properties.action',
			{categoryId:<s:property value="supply.category.id"/>}, 
			function(){
				//2 初始化
				<s:iterator value="supplyParams">
				var pk = '<s:property value="pkey" escape="HTML"/>', pv = '<s:property value="pvalue" escape="HTML"/>';
				//alert(pk);
				$(':hidden[value=<s:property value="pkey"  escape="HTML"/>]').parents('span').find("input[name=paramValue]").val('<s:property value="pvalue"  escape="HTML"/>');
				$(':hidden[value=<s:property value="pkey"  escape="HTML"/>]').parents('span').find("select[name=paramValue]").val('<s:property value="pvalue" escape="HTML"/>');
				</s:iterator>
	});
	</s:if>
	
});
function del(target) {
	$(target).parent().remove();
	return false;
}

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

$(function() {
	$('#btnUpl1').click(function() {
		modifyUpload1();
	});
	$('#btnUpl2').click(function() {
		modifyUpload2();
	});
	$('#btnUpl3').click(function() {
		modifyUpload3();
	});
});

function modifyUpload1() {
	var html = '<td class="pktdl2">产品图片1：<span class="red">&nbsp;</span></td><td class="pktdr12"><input type="file" name="upload1" id="upload1"/><input type="button" value="删除" onclick="delUpl(this)"/>该图片作为产品展示图片，<font color="#ff0000">必须上传</font></td>';
	$('#upl1').html(html);
}

function modifyUpload2() {
	var html='<td class="pktdl2">产品图片2：<span class="red">&nbsp;</span></td><td class="pktdr12"><input type="file" name="upload2" id="upload2"/><input type="button" value="删除" onclick="delUpl(this)"/></td>';
	$('#upl2').html(html);
}

function modifyUpload3() {
	var html='<td class="pktdl2">产品图片3：<span class="red">&nbsp;</span></td><td class="pktdr12"><input type="file" name="upload3" id="upload3"/><input type="button" value="删除" onclick="delUpl(this)"/></td>';
	$('#upl3').html(html);
}

function delUpl(e) {
	$(e).parents("tr").html('');
}
</script>
<script type="text/javascript">
function FCKeditor_OnComplete(editorInstance) {
	window.status = editorInstance.Description;
}
</script>
</head>
<body>
<s:include value="/WEB-INF/content/inc/header.jsp"/>
<s:include value="/WEB-INF/content/inc/member-left.jsp"/>

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
	<s:radio list="#{0:'产品', 1:'服务'}" name="type" id="type" ></s:radio>
	</td>
  </tr>
  <tr>
    <td valign="top" class="pktdl2">产品名称：<span class="red">*</span></td>
    <td class="pktdr2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="238"><s:textfield id="name" name="name" cssClass="input6"></s:textfield></td>
        <td><div class="msg1"></div></td>
      </tr>
    </table>
   </td>
  </tr>
  <tr>
    <td valign="top" class="pktdl2">参考价格：<span class="red">*</span></td>
    <td class="pktdr2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="245" valign="top" colspan="2"><s:textfield id="price" name="proPrice" cssClass="input7"></s:textfield>元<span class="ml2"><s:select id="price_unit" name="unit" listKey="id" listValue="name" headerKey="0" headerValue="请选择单位" cssClass="selectk3" list="%{units}"></s:select><label>0代表价格面议</label> </span>
          </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td class="pktdl2">品牌/型号：<span class="red">&nbsp;</span></td>
    <td class="pktdr2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="238"><s:textfield id="model_brand" name="brand" cssClass="input6"></s:textfield><div id="model_brandTip"></div></td>
        <td><div class="msg1"></div></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td class="pktdl1">产品原产地：<span class="red">&nbsp;</span></td>
    <td class="pktdr1"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td style="width:238;valign:top;"><s:textfield id="made_from" name="source" cssClass="input6"></s:textfield></td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td valign="middle" class="pktdl1">产品分类：<span class="red">*</span></td>
    <td class="pktdr1">
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
	  	<s:if test="nextMethod=='update'">
	  	<tr>
        <td style="padding-top:5px;">
        <input type="hidden" name="categoryId" value="<s:property value='category.id'/>" />
        <div class="msgk1 mgh8">您目前的分类是：<s:property value="categoryStr"/> </div>
        <div id='attr'>
        	<s:iterator value="supplyParams">
        		&nbsp;&nbsp;<label><s:property value="pkey"/></label>：<s:property value="pvalue"/><br/>
        	</s:iterator>
        </div>
        </td>
        </tr>	  
        </s:if>
        <tr>
          <td width="390">
          <s:select name="category1" list="%{categories}" id="category1" cssClass="selectk2" listKey="id" listValue="name"  size="8" cssStyle="width:97px;"></s:select>
		  <select name="category2" id="category2" size="8" class="selectk2" style="width:97px;"></select>
		  <select name="category3" id="category3" size="8" class="selectk2" style="width:97px;"></select>
		  <select name="category4" id="category4" size="8" class="selectk2" style="width:97px;"></select>
           </td>
        </tr>
        <tr>
        <td style="padding-top:5px;">
        <div class="msgk1 mgh8"><s:if test="nextMethod=='update'">您新修改的分类是：</s:if><s:else>您目前的分类是：</s:else><span id="selectedCategory"></span></div>
        </td>
        </tr>
      </table>
	  </td>
  </tr>

  <tr>
    <td class="pktdl2">&nbsp;</td>
    <td class="pktdr2">
	<div class="msgk3">
		<a href="javascript:void(0);" class="show_category_attr" id="showAttr"><img src="${ctx}/images/y_sort1.jpg" id="img_category_attr" alt="显示" border="0" /></a>
		<a href="javascript:void(0);" class="show_category_attr" id="hideAttr" style="display: none;"><img src="${ctx}/images/y_sort2.jpg" id="img_category_attr" alt="显示" border="0" /></a>
		<a href="javascript:void(0);" class="show_category_attr" id="showCategoryAttr">显示更多参数信息&gt;&gt;</a>
	</div>
	<div id='category_attr'></div>
    </td>
  </tr>
  
  <tr>
    <td class="pktdl2">有效期：<span class="red">&nbsp;</span></td>
    <td class="pktdr12">
    	<s:radio list="#{9999:'长期', 0:'半年', 1:'1年', 3:'3年'}" id="period" name="period"></s:radio>
    </td>
  </tr>
<%-- img begin --%>

<s:if test="nextMethod=='update'">
  <tr>

    <td valign="top" class="pktdl1">产品图片：<span class="red">&nbsp;</span></td>

    <td class="pktdr1">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">

      <tr>

        <td class="sck108">

		<div class="img100x100">

		 <div class="imgk100x100"><p><img src="${ctx}/FileView?id=<s:property value='productImgUrl'/>" id="preview_image_1" border="0" class="img100x100"/></p></div>

		  </div>

		  <div class="sctitle" id="image_1Tip">图片一</div>
		 <div class="scbtn" style="position:relative">
		   	<input name="" type="button" id="btnUpl1" value="修改"/>
		 </div>
		 </td>

		
        <td class="sck108">

		<div class="img100x100">

		 <div class="imgk100x100"><p>
		 	<img <s:if test="imgUrl2!=null"> src="${ctx}/FileView?id=<s:property value='imgUrl2'/>" </s:if> <s:else> src="${ctx}/images/none.jpg" </s:else> id="preview_image_2" border="0" class="img100x100"/>
		 </p></div>

		  </div>
		  <div class="sctitle" id="image_2Tip">图片二</div>
		 <div class="scbtn" style="position:relative">
		   	<input name="" type="button" id="btnUpl2" value="修改"/>
		 </div>
		 </td>

        <td class="sck108">

		<div class="img100x100">

		 <div class="imgk100x100"><p>
	<s:if test="imgUrl3!=null">
		 <img src="${ctx}/FileView?id=<s:property value='imgUrl3'/>"  id="preview_image_3" border="0" class="img100x100"/>
	</s:if>
	<s:else>
		 <img src="${ctx}/images/none.jpg"  id="preview_image_3" border="0" class="img100x100"/>
	</s:else>
		 </p></div>

		  </div>

		  <div class="sctitle" id="image_3Tip">图片三</div>
		 <div class="scbtn" style="position:relative">
		   	<input name="" type="button" id="btnUpl3" value="修改"/>
		 </div>
		 </td>

        <td>&nbsp;</td>

      </tr>
      
      
    </table>

      <div class="msg1 mgh8">图片格式jpg或gif,大小不超过500K且建议尺寸不低于500x500像索。</div></td>

  </tr>
      <tr id="upl1"></tr>
      <tr id="upl2"></tr>
      <tr id="upl3"></tr>

</s:if>

<s:else>

  <tr>
    <td class="pktdl2">产品图片1：<span class="red">&nbsp;</span></td>
    <td class="pktdr12">
    	<input type="file" name="upload" id="upload1"/>该图片作为产品展示图片，<font color="#ff0000">必须上传</font>
    </td>
  </tr>
  <tr>
    <td class="pktdl2">产品图片2：<span class="red">&nbsp;</span></td>
    <td class="pktdr12">
    	<input type="file" name="upload" id="upload2"/>
    </td>
  </tr>
  <tr>
    <td class="pktdl2">产品图片3：<span class="red">&nbsp;</span></td>
    <td class="pktdr12">
    	<input type="file" name="upload" id="upload3"/>
    </td>
  </tr>
  <tr>
    <td class="pktdl1"><span class="red">&nbsp;</span></td>
    <td class="pktdr11">
    	&nbsp;<div class="bp3" style="width:94%"> <img src="${ctx}/images/dan.jpg" style="vertical-align:middle" /> 上传的产品图片格式jpg或gif,大小不超过500K且建议尺寸不低于500x500像索</div>
    </td>
  </tr>  
</s:else>
<%-- img end --%>
 <tr>
    <td class="pktdl1">详细说明：<span class="red">&nbsp;</span></td>
    <td class="pktdr11">
    	<FCK:editor instanceName="supply.description" height="350" toolbarSet="B2B">
				<jsp:attribute name="value">
					${supply.description }
				</jsp:attribute>
		</FCK:editor>
    </td>
  </tr>
 
  <tr>
    <td class="pktdl1">&nbsp;</td>
    <td class="pktdr1">
	<input id="sBtn" name="sBtn" type="submit"  value="确定"  class="btn01"/>
	<input name="Input4" type="reset"  value="重置"  class="btn01"/>
    </td>
  </tr>
</table>
</s:form>
</div>
</div>

</div>
<!--  //member over-->
<div class="cls"></div>
<s:include value="/WEB-INF/content/inc/footer.jsp"/>
</body>
</html>