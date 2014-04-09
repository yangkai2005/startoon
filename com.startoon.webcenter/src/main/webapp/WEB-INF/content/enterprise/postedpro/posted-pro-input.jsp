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

<link rel="stylesheet" type="text/css" href="${ctx}/css/member.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/purchaseCenter.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/validator.css" />

<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/formValidator.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/formValidatorRegex.js"></script>
<script type="text/javascript" src="${ctx}/resources/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript"> 
$(function() {
 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg);},onsuccess:function(){return true;}});
 	$("#proName").formValidator({onshow:"",onfocus:"采购名称不为空",oncorrect:""}).inputValidator({min:1,max:100,onerror:"采购名称不为空"});
 	$("#amount").formValidator({onshow:"",onfocus:"数量格式不正确,请输入数字",oncorrect:""}).regexValidator({regexp:"num1",datatype:"enum",onerror:"数量格式不正确,请输入数字"});
 	$("#proPrice").formValidator({onshow:"",onfocus:"价格格式不正确,请输入数字",oncorrect:""}).regexValidator({regexp:"decmal4",datatype:"enum",onerror:"价格格式不正确,请输入数字"});
 	$("#startTime").formValidator({onshow:"",onfocus:"开始时间不为空",oncorrect:""}).inputValidator({min:1,max:100,onerror:"开始时间不为空"});
 	$("#endTime").formValidator({onshow:"",onfocus:"结束时间不为空",oncorrect:""}).inputValidator({min:1,max:100,onerror:"结束时间不为空"});
 	$("#tradeAddress").formValidator({onshow:"",onfocus:"交货地点不为空",oncorrect:""}).inputValidator({min:1,max:100,onerror:"交货地点不为空"});

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
			});

			var c1 = $('#category1 option:selected').text();
			var c2 = $('#category2 option:selected').text();
			$('#selectedCategory').html(c1 + '->' + c2);
	 });
	 
	 $("#category3").change(function(){
			var c1 = $('#category1 option:selected').text();
			var c2 = $('#category2 option:selected').text();
			var c3 = $('#category3 option:selected').text();
			$('#selectedCategory').html(c1 + '->' + c2 + '->' + c3);
	 }); 	
 	
	$('form').submit(function() {
		var cn1 = $("#category1 option:selected").text();
		var cn2 = $("#category2 option:selected").text();
		var cn3 = $("#category3 option:selected").text();
		var cid1 = $("#category1").val();
		var cid2 = $("#category2").val();
		var cid3 = $("#category3").val();
		if($.trim(cid3)=='') {
			alert('你还没有选择采购类别，请选择采购类别！');
			return false;
		}

		$("input[name=categoryName1]").val(cn1);
		$("input[name=categoryName2]").val(cn2);
		$("input[name=categoryName3]").val(cn3);
		$("input[name=categoryId1]").val(cid1);
		$("input[name=categoryId2]").val(cid2);
		$("input[name=categoryId3]").val(cid3);
	});
		
});
</script>

</head>
<body>
<s:include value="/WEB-INF/content/inc/header.jsp"/>
<s:include value="/WEB-INF/content/inc/member-left.jsp"/>

<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/enterprise/postedpro">
<s:hidden name="nextMethod" />
<s:hidden name="requestId" />
<s:hidden name="id" />

<div class="memright">
	<div class="title4">
		<div class="hotline">客服热线：020-39106666</div>
		<div class="titlemu2"><h1>发布采购</h1></div>
	</div>
	 
	<div class="memcon">
	<div class="fabucg">
    <div class="en2">

	<div class="pitem">
		<div class="nameTxt">采购标题:<span class="red">*</span></div>
		<div class="inpArea2"><s:textfield name="proName" id="proName" cssClass="inptex3" cssStyle="width: 328px;"></s:textfield></div>
	</div>
	<div class="pitem" >
		<div class="nameTxt">产品分类:<span class="red">*</span></div>
		<div class="inpArea2">
			<s:select size="10" list="%{categories}" name="category1" id="category1" listKey="id" listValue="name" cssStyle="width:110px;"></s:select>
			<select size="10" id="category2" name="category2"  style="width:110px;"></select>
			<select size="10" id="category3" name="category3" style="width:110px;"></select>
			<input type="hidden" name="categoryId1"/>
			<input type="hidden" name="categoryId2"/>
			<input type="hidden" name="categoryId3"/>
			<input type="hidden" name="categoryName1"/>
			<input type="hidden" name="categoryName2"/>
			<input type="hidden" name="categoryName3"/>
		</div>
	</div>
	<div class="pitem">
		<div class="nameTxt">&nbsp;</div>
		<div class="inprea2" id="selectedCategory"></div>
	</div> 
	<div class="pitem">
		<div class="nameTxt">采购数量:<span class="red">*</span></div>
		<div class="inprea2"> <s:textfield id="amount" name="amount" cssClass="inptex3"></s:textfield></div>
	</div> 

	<div class="pitem">
		<div class="nameTxt">期望价格:<span class="red">*</span></div>
		<div class="inprea2"><s:textfield id="proPrice" name="proPrice" cssClass="inptex3"></s:textfield>元</div>
	</div>
	 
	<div class="pitem">
		<div class="nameTxt">开始时间:<span class="red">*</span></div>
		<div class="inprea2">
			<s:textfield id="startTime" name="startTime" cssClass="inptex33 Wdate" onfocus="WdatePicker()" >
				<s:param name="value"><s:date name="startTime" format="yyyy-MM-dd"/></s:param>
			</s:textfield>
		</div>
	</div>
	
	<div class="pitem">
		<div class="nameTxt">结束时间:<span class="red">*</span></div>
		<div class="inprea2">
			<s:textfield id="endTime" name="endTime" cssClass="inptex33 Wdate" onfocus="WdatePicker()">
				<s:param name="value"><s:date name="endTime" format="yyyy-MM-dd"/></s:param>
			</s:textfield>
		</div>
	</div>
	
	<div class="pitem">
		<div class="nameTxt">交货地点:<span class="red">*</span></div>
		<div class="inpArea2"><s:textfield id="tradeAddress" name="tradeAddress" cssClass="inptex3" cssStyle="width:500px"></s:textfield></div>
	</div>

	<div class="pitem1">
		<div class="nameTxt">详细信息:<span class="red">&nbsp;</span></div>
		<div class="inpArea" style="width:510px;">
	    	<FCK:editor instanceName="description" height="350" toolbarSet="B2BCfg">
				<jsp:attribute name="value">${postedPro.description}</jsp:attribute>
			</FCK:editor>	  
		 </div>
		<div id="descTip" style="clear:both; width:424px; margin-left:183px;"></div>
	</div>
	
	</div>

	<div class="pitem">
		<div class="nameTxt">&nbsp;</div>
		<div class="inpArea"><input id="submitBtn" type="submit" class="pbtn1" value="确认提交" /><input type="reset" class="pbtn1" value="重 置"/></div>
	</div>

</div>
</div>
<!--  //member over-->
</div>
</s:form>

<div class="cls"></div>
<s:include value="/WEB-INF/content/inc/footer.jsp"/>
</body>
</html>