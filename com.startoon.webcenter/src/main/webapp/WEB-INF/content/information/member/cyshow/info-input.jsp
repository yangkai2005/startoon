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
	
 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg)},onsuccess:function(){return true;}});

 	$("#form1").submit(function(){
 	 	var content = $('#content').val();
 	 	var txt = $('<div>' + content + '</div>').text();
 	 	$(':hidden[name=contentTxt]').val(txt);
 	 });
	 
	var imgHtml = '<tr><th></th><td><table><tr><td><textarea rows="" cols=""></textarea></td></tr></table></td></tr>';
	
	//绑定上传插件
	
	$("#imgFile").MultiFile({
		  max: 30,
		  accept: 'gif|jpg',
		  list:'#list',
		  STRING: {
			   remove: '删除',
				denied:'不能选择扩展名为$ext的文件.\n请重新选择...',
				file:'$file',
				duplicate:'图片$file已经选择了，请选择其他图片'				   
			  },
		  afterFileSelect:function(element, value, master_element){
		  	var fileName = value.replace(/^.+?\\([^\\]+?)(\.[^\.\\]*?)?$/gi,"$1");
		  	var txt = "<span id='"+fileName+"'><textarea rows='3' cols='90' name='description'></textarea></span>";
		  	$("#list").append(txt);

		  	$('textarea[name=description]').example('请输入图片描述内容...');
		  },
		  onFileRemove: function(element, value, master_element){
			  $("#"+value.replace(/^.+?\\([^\\]+?)(\.[^\.\\]*?)?$/gi,"$1"),$("#list")).remove();
		  }
	});


});

</script>

</head>

<body>

<div class="mTitle">
  <b class="bbig">资讯信息维护</b>
</div>
<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/information/member/cyshow" enctype="multipart/form-data">
<s:hidden name="nextMethod" />
<s:hidden name="requestId" />
<s:hidden name="id" />
<s:hidden name="contentTxt" />
<s:hidden name="tid" />
<s:hidden name="isImgInfo" value="true"/>
<s:hidden name="contentTxt" id="contentText"/>


<!--list -->
<div class="mainAdd">
<table class="addTable">
  <tr>
    <th>作品类型:</th> 
	<td> 
	<s:radio name="isImgInfo" list="#{0:'个人', 1:'团体'}"></s:radio> 
	</td>
  </tr>
  <tr>
    <th>所属分类:</th> 
	<td> 
	<s:select list="#{23:'团体', 24:'个人', 25:'动漫', 26:'动画'}" name="infoType.id" id="infoTypeId"></s:select>
	</td>
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
  <tr>
    <th>内容:</th>
	<td>
		<s:textarea name="content" id="content"></s:textarea>
	</td>
  </tr>
  <tr id="trAddImg">
  	<th>图片:</th>
  	<td><input type="file" name="upload" id="imgFile"/><span>第一张图片为主图</span></td>
  </tr>
  
  <tr>
  	<th></th>
  	<td><table><tr><td id="list"></td></tr></table></td>
  </tr>
</table>
</div>
<!--end list -->
<div class="addToolbar">
    <p><button class="btn" type="submit"><b>提交</b></button>
    <button class="btn" type="button" onclick="location.href='<s:url action="info-list" namespace="/admin/information/info"/>?restore_params=true'">返回</button></p>
</div>
 
 </s:form>
</body>
</html>