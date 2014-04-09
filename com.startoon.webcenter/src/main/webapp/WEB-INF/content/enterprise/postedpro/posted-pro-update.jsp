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

<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/member.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />
<script src="${ctx}/resources/js/jquery.js" type="text/javascript"></script>
<link href="${ctx}/resources/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>
<link href="${ctx}/resources/jquery-ui/css/custom-theme/jquery-ui.custom.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/resources/jquery-ui/js/jquery-ui.custom.min.js" type="text/javascript"></script>
<script src="${ctx}/resources/jquery-ui/js/ui.datepicker-zh-CN.js" type="text/javascript"></script>

<script type="text/javascript"> 
$(document).ready(function(){
 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg)},onsuccess:function(){return true;}});
 	$("#name").formValidator({onshow:"",onfocus:"产品名称不为空",oncorrect:""}).inputValidator({min:1,max:100,onerror:"产品名称不为空"});
 	$("#amount").formValidator({onshow:"",onfocus:"",oncorrect:""}).regexValidator({regexp:"num1",datatype:"enum",onerror:"数量格式不正确,请输入数字"});
 	$("#price").formValidator({onshow:"",onfocus:"",oncorrect:""}).regexValidator({regexp:"decmal4",datatype:"enum",onerror:"价格格式不正确,请输入数字"});


 	$("#sBtn").click(function (){

		var categoryId = $("select[name='categoryId']").val();
		if(categoryId != 0) return true;
		else
		{
			alert("请选择分类");
			return false;
		} 

 	 });



 	$('#startTime').datepicker({
		duration:0,
		buttonImage: "${ctx}/resources/images/day.gif",
		buttonImageOnly: true,
		dateFormat:"yy-mm-dd",
		showOn:"both"
		},$.datepicker.regional['zh-CN']
	);


	$('#endTime').datepicker({
		duration:0,
		buttonImage: "${ctx}/resources/images/day.gif",
		buttonImageOnly: true,
		dateFormat:"yy-mm-dd",
		showOn:"both"
		},$.datepicker.regional['zh-CN']
	);
});

</script>

</head>
<body>
<s:include value="/WEB-INF/content/inc/header.jsp"/>
<s:include value="/WEB-INF/content/inc/member-left.jsp"/>
<s:form id="form1" action="posted-pro!update.action" namespace="/enterprise/postedpro">
<s:hidden name="nextMethod" />
<s:hidden name="requestId" />
<s:hidden name="id" />
<div class="memright">
<div class="title4"> <div class="hotline">客服热线：020-39106666</div>
	 <div class="titlemu2"> 
	 <h1>发布采购</h1>
	 </div>
</div>
	 
	<div class="memcon">
	<div class="fabucg">
    <div class="en2">


   <div class="pitem">
	 <div class="nameTxt">采购产品:<span class="red">*</span></div>
	 <div class="inpArea2"> <input name="postedPro.proName" value="${postedPro.proName }" id="name"  class="inputk1" maxLength=50  type="text" /></div>
	
	</div>

	  <div class="pitem" style="display:none;">
	
	 <div class="nameTxt">产品分类:<span class="red">*</span></div>
	 <div class="inpArea2"><select name="categoryId"><option value="0">机械工业</option></select></div>
		

	
	</div>
	 
	 
	 <div class="pitem">
		<div class="nameTxt">采购数量:<span class="red">&nbsp;</span></div>
			<div class="inprea2"><input onkeydown="isNumber(this);" name="postedPro.amount"  id="amount"  class="inptex3"  maxLength=10 value="${postedPro.amount }"></input> </div></div> 
	  <div class="pitem">
	<div class="nameTxt">期望价格:<span class="red">&nbsp;</span></div>
		<div class="inprea2"><input  name="postedPro.proPrice" onkeydown="isNumber(this);" id="price"  class="inptex3"  maxLength=10 value="${postedPro.proPrice }"></input> 元</div></div>
	 
	 <div class="pitem">
	<div class="nameTxt">开始时间:<span class="red">&nbsp;</span></div>
		 <div class="inprea2"><input  name="postedPro.startTime"  id="startTime"  value="<s:date name="postedPro.startTime" format="yyyy-MM-dd" />" class="inptex33"  ></input>
		
	 </div>
	</div>
	
	 <div class="pitem">
	<div class="nameTxt">结束时间:<span class="red">&nbsp;</span></div>
		 <div class="inprea2">
		 <input  name="postedPro.endTime"  id="endTime" value="<s:date name="postedPro.endTime" format="yyyy-MM-dd" />"  class="inptex33"  ></input>
	 </div>
	</div>
	
	
	<div class="pitem">
 <div class="nameTxt">交货地点:<span class="red">&nbsp;</span></div>

   <div class="inpArea2">
		<input  name="postedPro.tradeAddress" value="${postedPro.tradeAddress }" id="price"  class="inptex3" ></input>
   </div>

</div>
   <div class="pitem1">
	 <div class="nameTxt">详细信息:<span class="red">&nbsp;</span></div>
	 <div class="inpArea" style="width:410px;">
	   <textarea name="postedPro.description"  id="desc" rows="6" style="width:410px;" class="textarea">${postedPro.description }</textarea></div>
	 <div class="xunxian">限1000字</div>
	 <div id="descTip" style="clear:both; width:424px; margin-left:183px;"></div>
	</div>
	
	

	</div>
   <div class="pitem">
	 <div class="nameTxt">&nbsp;</div>
	 <div class="inpArea">
	 <input type="hidden" value="${postedPro.id }" name="id" id="id"/>
	 <input id="submitBtn" type="submit"  onclick="baseSubmit()" class="pbtn1" value="确认提交" />
	   <input type="reset" class="pbtn1" value="重 置"/>
	   <input type="button" onclick="location.href='${pageContext.request.contextPath}/enterprise/postedpro/posted-pro-list.action?enterpriseId=${sessionScope.enterprise_user_id }'" class="pbtn1" value="返 回"/>
	 </div>

	</div>
	</div>
</div>


<!--  //member over-->

</div>
<div class="cls"></div>

</s:form>
<s:include value="/WEB-INF/content/inc/footer.jsp"/>
</body>
</html>