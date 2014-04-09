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
<link rel="stylesheet" type="text/css" href="${ctx}/css/member.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/common.css" />
<script src="${ctx}/resources/js/jquery.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<link href="${ctx}/resources/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>
<script type="text/javascript"  src="${ctx}/resources/js/jquery.selectCombo.1.2.6.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	<s:if test="flag">alert('企业基本信息保存成功！');</s:if>

	$("#category1").change(function(){
		$("#category2").html('');
		var id = $('#category1 option:selected').attr('id');
		$.getJSON("${pageContext.request.contextPath}/enterprise/supply/supply!subCategory.action",{fatherId: id, ajax: 'true'}, 
			function(data){
				var j = data.array;
				var options = '';
				for (var i = 0; i < j.length; i++) {
					options += '<option value="' + j[i].oV + '">' + j[i].oT + '</option>';
			}
			$("#category2").html(options);
		});
	});

	$('#addBusiness').click(function() {
		var s1 = $('#category1 option:selected').text();
		var s2 = $('#category2 option:selected').text();
		var cid = $('#category2').val();
		var s = s1 + '->' + s2;
		var html = '<tr><td><input type="hidden" name="cid" value="' + cid + '"/></td><td colspan="2">' + s + ' <a id="' + cid + '" href="javascript:void(0);" onclick="del(this)"><font color="red">删除</font></a></td></tr>';

		$('#local').before(html);
		
	});
	
});

function del(e) {
	var cid = $(e).attr('id');
	$.post('${pageContext.request.contextPath}/enterprise/enterprise/enterprise!removeBusiness.action', 
			{categoryId: cid}, 
			function(data) {
				$(e).parent().parent().remove();
			});
}


function showbig(name,cursel,n,m){
   for(i=1;i<=n;i++){
   var menu=document.getElementById(m+i);
	var con=document.getElementById(name+i);
	menu.className=i==cursel?"hover":"";
   con.style.display=i==cursel?"block":"none";
   }
  }
</script>



</head>

<body>

<%-- header --%>
<s:include value="/WEB-INF/content/inc/header.jsp"></s:include>
<%-- header --%>
		

<div class="cls"></div>


<!--main star-->
<div class="main">

<div class="member">
<%-- left --%>
<s:include value="/WEB-INF/content/inc/member-left.jsp"></s:include>
<%-- left --%>

<s:form namespace="/enterprise/enterprise" action="enterprise!updatebase.action">
<s:hidden name="id" value="%{enterprise.id}"></s:hidden>

<div class="memright">
<div class="title4"> <div class="hotline">客服热线：020-39106666</div>
	 <div class="titlemu2">
	 <h2 class="q3"><a href="${ctx}/enterprise/enterprise/enterprise!info.action">企业基本信息</a></h2> 
	 <h2><a href="${ctx}/enterprise/enterprise/enterprise!detail.action">企业详细信息</a></h2>
	 <h2><a href="${ctx}/enterprise/enterprise/enterprise!forwardBanner.action">BANNER管理</a></h2>
	 </div>
	 </div>
	 
	<div class="memcon">
	<table width="100%" border="0" cellspacing="0" class="regtable2">
  <tr>
    <td width="9%">公司名称：</td>
    <td colspan="2"> <s:textfield name="enterprise.name" cssClass="txtreg1"></s:textfield> </td>
    </tr>
  <tr>
    <td>企业网址：</td>
    <td colspan="2"><s:textfield name="enterprise.siteUrl" cssClass="txtreg1"></s:textfield></td>
    </tr>
  <tr>
    <td>公司地址：</td>
    <td colspan="2"> <s:textfield name="enterprise.address" cssClass="txtreg1"></s:textfield> </td>
    </tr>
  <tr>
    <td>经营模式：</td>
    <td colspan="2"> <s:radio list="#{0:'生产型', 1:'贸易型', 2:'代理型', 3:'经销商'}" name="enterprise.manageType"></s:radio> </td>
    </tr>
  <tr>
    <td>主营方向：</td>
    <td colspan="2"> <s:radio list="#{0:'销售', 1:'采购', 2:'两者都是'}" name="enterprise.manageDirection"></s:radio> </td>
    </tr>
  <tr>
    <td>企业性质：</td>
    <td colspan="2"> <s:radio list="#{false:'非动漫类', true:'动漫类'}" name="enterprise.cartoon"></s:radio> </td>
    </tr>
  <tr>
    <td>主营业务：</td>
    <td colspan="2">
    	<select id="category1" name="enterprise.business" class="txtreg1" style="width:135px;">
    	<s:iterator value="categories"> <option id="<s:property value="id"/>" value="<s:property value="name"/>"><s:property value="name"/></option> </s:iterator>
    	</select>
    	<select name="category2" id="category2" class="txtreg1" style="width:135px;"></select>
    	<input type="button" id="addBusiness" value="添加" />
    </td>
    </tr>
  <s:iterator value="businesses">
  <tr>
  	<td><input type="hidden" name="cid" value="<s:property value="category.id"/>"/></td>
  	<td><s:property value="category.category.name"/>-&gt;<s:property value="category.name"/> <a id="<s:property value="category.id"/>" href="javascript:void(0)" onclick="del(this)"><font color="red">删除</font></a></td>
  </tr>
  </s:iterator>
  <tr id="local" style="display:none;">
    <td>所属行业：</td>
    <td colspan="2"> <s:select list="%{industries}" listKey="name" listValue="name" headerKey="" headerValue="--请选择--" name="enterprise.industry" cssClass="txtreg1"></s:select></td>
    </tr>
  <tr>
    <td>联系人：</td>
    <td colspan="2"> <s:textfield name="enterprise.linkman" cssClass="txtreg4"></s:textfield> <s:radio list="#{true:'先生', false:'女士'}" name="enterprise.sex"></s:radio> </td>
    </tr>
  <tr>
    <td>移动电话：</td>
    <td width="23%"> <s:textfield name="enterprise.mobilePhone" cssClass="txtreg4"></s:textfield> </td>
    <td width="68%">固定电话：<s:textfield name="enterprise.telephone" cssClass="txtreg4"></s:textfield> </td>
  </tr>
  <tr>
    <td>传真：</td>
    <td> <s:textfield name="enterprise.fax" cssClass="txtreg4"></s:textfield> </td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;邮箱：<s:textfield name="enterprise.email" cssClass="txtreg4"></s:textfield> </td>
  </tr>
  <tr>
    <td>QQ：</td>
    <td> <s:textfield name="enterprise.qq" cssClass="txtreg4"></s:textfield> </td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MSN：<s:textfield name="enterprise.msn" cssClass="txtreg4"></s:textfield></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td colspan="2"><input name="" type="checkbox" value="" checked="checked"/>我愿意接受相关行业信息</td>
    </tr>
  <tr>
    <td></td>
    <td colspan="2"> <s:submit cssClass="btnqr" name="btnapply" value=" " cssStyle="background:#fff url(../../images/queren.jpg) no-repeat top left;border:none;width:233px;height:26px;"></s:submit>  <input name="btnexit" type="button" value=" " style="border:none;background:#fff url(../../images/exit.jpg) no-repeat top left;width:65px;height:26px;" class="btnexit" /></td>
    </tr>

</table>
	</div>
	 
	 
</s:form>
</div>

   <!--  //memberright over--> 

</div>

<!--  //member over-->

<div class="cls"></div>  
  
<%-- footer --%>
<s:include value="/WEB-INF/content/inc/footer.jsp"/>
<%-- footer --%>	
</body>
</html>