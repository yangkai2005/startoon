<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>Title Here</title>

<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/admin.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/validator.css"/>
<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/formValidator.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/formValidatorRegex.js"></script>
<script type="text/javascript" src="${ctx}/resources/fileuploader/fileuploader.js"></script>

<script type="text/javascript" src="${ctx}/resources/js/jquery.example.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/My97DatePicker/WdatePicker.js"></script>

<!-- multiple-file-upload begin -->
<script src='${ctx}/resources/multiple-file-upload/jquery.blockUI.js' type="text/javascript"></script>
<!--// plugin-specific resources //-->
<script src='${ctx}/resources/multiple-file-upload/jquery.form.js' type="text/javascript" language="javascript"></script>
<script src='${ctx}/resources/multiple-file-upload/jquery.MetaData.js' type="text/javascript" language="javascript"></script>
<script src='${ctx}/resources/multiple-file-upload/jquery.MultiFile.js' type="text/javascript" language="javascript"></script>
<script src='${ctx}/resources/multiple-file-upload/jquery.blockUI.js' type="text/javascript" language="javascript"></script>
<!-- multiple-file-upload end -->

<script type="text/javascript">
$(document).ready(function(){
 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg);},onsuccess:function(){return true;}});
 	$("#title").formValidator({onshow:"",onfocus:"请填写标题",oncorrect:""}).inputValidator({min:1,max:100,onerror:"你还没有填写标题"});
 	$("#infoTime").formValidator({onshow:"",onfocus:"请选择发布时间",oncorrect:""}).inputValidator({min:1,max:100,onerror:"你还没有选择发布时间"});
 	$(":radio.infoTypeId").formValidator({onshow:"",onfocus:"请选择所属的分类",oncorrect:""}).inputValidator({min:1,max:100,onerror:"你还没有选择所属的类别"});
 	$(":radio[name=videoType]").formValidator({onshow:"请选择视频分类",onfocus:"请选择视频分类",oncorrect:"选择正确"}).inputValidator({min:1,max:100,onerror:"你还没有选择视频分类"});

 	
 	$("#form1").submit(function(){
	
	 	if($("#videoUpload:enabled").length>0 && "insert"=="<s:property value='nextMethod'/>") {
	 		$("#imgUpload").formValidator({onshow:"请选择视频快照图片",onfocus:"请选择视频快照图片",oncorrect:"选择正确"}).inputValidator({min:1,max:100,onerror:"你还没有选择视频快照图片"});
	 	}
	 	if($("#videoPath:enabled").length>0) {
	 		$("#videoPath:enabled").formValidator({onshow:"",onfocus:"请输入视频链接地址",oncorrect:"输入正确"}).inputValidator({min:1,max:100,onerror:"请输入视频链接地址"});
	 	}
 	 	var fCKeditorContent = FCKeditorAPI.GetInstance("content").GetXHTML();//FCKeditor1是FCkeditor的ID
 	 	var txt = $('<div>' + fCKeditorContent + '</div>').text();
 	 	$(':hidden[name=contentTxt]').val(txt);
 	 });
	 
	$(':radio[name=videoType]').click(function() {
		var v = $(this).val();
		if(v==1) {
			$("#videoUpload").attr("disabled", false);
			$("#videoPath").attr("disabled", true);
		} else {
			$("#videoUpload").attr("disabled", true);
			$("#videoPath").attr("disabled", false);
		}
	});

});

</script>

</head>

<body>
<div class="mTitle">
  <b class="bbig">视频维护</b>
</div>
<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/admin/information/video" enctype="multipart/form-data">
<s:hidden name="nextMethod" />
<s:hidden name="requestId" />
<s:hidden name="id" />
<s:hidden name="contentTxt" />
<s:hidden name="infoType.id" value="25" />
<!--list -->
<div class="mainAdd">
<table class="addTable">
  <tr>
    <th>视频类型:</th> 
	<td> <s:radio list="#{0:'视频链接', 1:'视频文件'}" name="videoType"></s:radio> <span id="titleTip"></span> </td>
  </tr>
  <tr>
    <th>标题:</th> 
	<td> <s:textfield name="title" id="title" size="30"></s:textfield><span id="titleTip"></span> </td>
  </tr>
  <tr>
    <th>发布日期:</th> 
	<td><s:textfield name="infoTime" id="infoTime" size="30" cssClass="Wdate" onfocus="WdatePicker()"><s:param name="value"><s:date name="infoTime" format="yyyy-MM-dd"/></s:param> </s:textfield><span id="infoTimeTip"></span> </td>
  </tr>
  <tr>
    <th>来源:</th> 
	<td> <s:textfield name="source" id="source" size="30"></s:textfield><span id="sourceTip"></span> </td>
  </tr>
  <tr>
    <th>来源网站:</th> 
	<td> <s:textfield name="sourceUrl" id="sourceUrl" size="30"></s:textfield><span id="sourceUrlTip"></span> </td>
  </tr>

  <tr id="vlink">
  	<th>视频链接:</th>
  	<td> <s:textfield name="videoPath" id="videoPath" size="80"></s:textfield> </td>
  </tr>
  
  <s:if test="%{nextMethod=='update' && mainImg!=null}">
  <tr>
  	<th>&nbsp;</th>
  	<td>
  		<table>
  			<tr id="tr<s:property value='mainImg.id'/>" class="img">
  				<td align="center">
  					<img src="<s:property value='mainImg.smallImg'/>" />
  				</td>
  			</tr>
  		</table>
  	</td>
  </tr>
  </s:if>
  <tr>
  	<th>视频快照:</th>
  	<td> <s:file id="imgUpload" name="imgUpload"/> </td>
  </tr>
  
  <tr id="vfile">
  	<th>视频文件:</th>
  	<td><s:file id="videoUpload" name="videoUpload"/><span>只能上传FLV格式的视频文件</span></td>
  </tr>

  <tr>
    <th>内容:</th>
	<td>
    	<FCK:editor inputName="info.content" instanceName="content" height="350">
				<jsp:attribute name="value">
					${info.content }
				</jsp:attribute>
		</FCK:editor>
	</td>
  </tr>
</table>
</div>
<!--end list -->
<div class="addToolbar">
    <p><button class="btn" type="submit"><b>提交</b></button>
    <button class="btn" type="button" onclick="location.href='<s:url action="info-list" namespace="/admin/information/video"/>?restore_params=true'">返回</button></p>
</div>
 
 </s:form>
</body>
</html>