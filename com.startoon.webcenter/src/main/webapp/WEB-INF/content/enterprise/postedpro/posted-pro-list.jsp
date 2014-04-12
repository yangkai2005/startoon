<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>星力动漫 - 会员中心</title>

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
	<s:if test="success">alert('发布成功！');</s:if>
 	$.formValidator.initConfig({formid:"addForm",onerror:function(msg){alert(msg)},onsuccess:function(){return true;}});
 	$("#name").formValidator({onshow:"",onfocus:"产品名称不为空",oncorrect:""}).inputValidator({min:1,max:100,onerror:"产品名称不为空"});
 	$("#price").formValidator({onshow:"",onfocus:"",oncorrect:""}).regexValidator({regexp:"num",datatype:"enum",onerror:"价格格式不正确,请输入数字"});
 	$("#upload").formValidator({onshow:"",onfocus:"",oncorrect:""}).inputValidator({min:1,onerror:"请选择产品的图片！"});

	$("#sBtn").click(function () {

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

	 $('#checkAll').click(function() {
		 var ck = $(this).attr('checked');
		 $(':checkbox[name=ids]').attr('checked', ck);
	 });
	 
	$('#deleteAllBtn').click(function() {
		 
		var cks = $(':checkbox[name=ids]:checked');
							if (cks && cks.length > 0) {
								if (confirm("确定要删除选中的采购信息吗?")) {
									$('#delForm').submit();
								}

							} else {
								alert('你还没有选择要删除的采购信息！');
							}
	});
	 	
});


function doDelete(){
	var ids = document.getElementsByName("ids");
	var idstr = "";
	var deleteflag = false;
	for(var i=0;i<ids.length;i++){
		if(ids[i].checked){
			deleteflag = true;
			break;
		}
	}
	if(deleteflag){
		if(confirm("删除后将不可恢复，确定要删除吗?")){
			for(var i=0;i<ids.length;i++){
				if(ids[i].checked){
					idstr = idstr + ids[i].value + ",";
				}
			}
			location.href='<s:url action="posted-pro!delete" namespace="/enterprise/postedpro"/>?ids=' + idstr;
		}
	}else{
		alert("请至少选择一条记录!");
		return false;
	}	
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

<%-- 列表管理 --%>

<div class="memright">
<div class="title4"> <div class="hotline">客服热线：020-39106666</div>
	 <div class="titlemu2">
	
	 
	 <h1>供应管理</h1>
	 </div>
	 </div>
	 
	<div class="memcon2">
		<div class="gy2">
		<div class="bggy">
		<table width="100%" border="0" class="memcontable2" cellspacing="0">
		  <tr>
		  <th width="7%"><input name="checkAll" id="checkAll" type="checkbox" value="" /> 全选</th>
		    <th width="20%">图片</th>
		    <th width="28%">采购名称</th>
		    <th width="18%">到期日期</th>
		    <th width="14%">状态</th>
		    <th width="13%">操作</th>
		  </tr>
		  
		<s:form id="delForm" name="delForm" namespace="/enterprise/postedpro" action="posted-pro!deleteAll">
		  <s:iterator value="pager.items">
			  <tr>
			  	<td style=" border-left:0; text-align:left; padding-left:5px;"><input name="ids" type="checkbox" value='<s:property value="id" />' /></td>
			    <td><img src="${ctx}/<s:property value="imageUrl" />" width="47" height="47" /></td>
			    <td style="font-weight:bold"><s:property value="proName" /></td>
			    <td><s:if test="deadDate!=null"> <s:date name="endTime" format="yyyy-MM-dd"/> </s:if><s:else>长期有效</s:else> </td>
			    <td><s:property value="statusZh"/>&nbsp;</td>
			    <td>
			    	<s:if test="%{pager.paramCondition['isDelete']=='1'}">-</s:if>
			    	<s:else>
		   			<a href="${pageContext.request.contextPath }/enterprise/postedpro/posted-pro!edit.action?requestId=${id}">修改</a>
		   			</s:else>			    
			    </td>
			  </tr>
		  </s:iterator>
		 </s:form>
		</table>
		<div ><input type="button" id="deleteAllBtn" name="submitBtn" value="删除" class="mbtn2"/> <div align="right"> <e:pagination></e:pagination> </div></div>
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