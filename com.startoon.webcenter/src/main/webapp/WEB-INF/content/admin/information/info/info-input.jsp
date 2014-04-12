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

 	$("#form1").submit(function(){
 	 	var fCKeditorContent = FCKeditorAPI.GetInstance("content").GetXHTML();//FCKeditor1是FCkeditor的ID
 	 	var txt = $('<div>' + fCKeditorContent + '</div>').text();
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
		  	var txt = "<span style='display:none;' id='"+fileName+"'><textarea rows='3' cols='90' name='description'></textarea></span>";
		  	$("#list").append(txt);

		  	$('textarea[name=description]').example('请输入图片描述内容...');
		  },
		  onFileRemove: function(element, value, master_element){
			  $("#"+value.replace(/^.+?\\([^\\]+?)(\.[^\.\\]*?)?$/gi,"$1"),$("#list")).remove();
		  }
	});

	$(':radio[name=isImgInfo]').click(function(){
		var img = $(':radio[name=isImgInfo]:checked').val();
		
		if(img=='true') {
			//$('#trAddImg').show();
		} 
		if(img=='false') {
			//$('#trAddImg').hide();
		}
	});

	$('a[rel=delImg]').click(function(){
		var id = $(this).attr('id');
		$.post('<s:url action="info-img!ajaxDelete" namespace="/admin/information/infoimg"/>', 
				{requestId: id}, 
				function(date) {$("#tr" + id).remove(); alert('删除成功！');});
	});

});

</script>

</head>

<body>
<div class="mTitle">
  <b class="bbig">资讯信息维护</b>
</div>
<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/admin/information/info" enctype="multipart/form-data">
<s:hidden name="nextMethod" />
<s:hidden name="requestId" />
<s:hidden name="id" />
<s:hidden name="contentTxt" />
<s:hidden name="tid" />
<!--list -->
<div class="mainAdd">
<table class="addTable">
  <tr>
    <th>资讯分类:</th> 
	<td> 
	<s:radio name="isImgInfo" id="isImgInfo" list="#{false:'文本类', true:'图片类'}"></s:radio> 
	<span id="isImgInfoTip"></span> 
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
  <%-- 资讯中心 begin --%>
  <s:if test="tid==2">
  <tr>
    <th>类别:</th>
	<td> <s:select name="infoType.id" id="infoTypeId" list="%{infoTypes}" listKey="id" listValue="name"></s:select> <span id="infoTypeIdTip"></span> </td>
  </tr>
  </s:if>
  <%-- 资讯中心 end --%>
  <%-- 行情调查 begin --%>
  <s:if test="tid==3">
  <tr>
    <th>类别:</th>
	<td> <s:select name="infoType.id" id="infoTypeId" list="#{19:'编辑推荐', 20:'人气排行', 21:'行情综述'}"></s:select> <span id="infoTypeIdTip"></span> </td>
  </tr>
  </s:if>
  <%-- 行情调查 end --%>
  <%-- 高端访谈 begin --%>
  <s:if test="tid==4">
  <input type="hidden" name="infoType.id" value="4"/>
  </s:if>
  <%-- 高端访谈 end --%>
  <%-- 星力观察家 begin --%>
  <s:if test="tid==6">
  <input type="hidden" name="infoType.id" value="6"/>
  </s:if>
  <%-- 星力观察家 end --%>
  <%-- 创意资讯 begin --%>
  <s:if test="tid==7">
  <input type="hidden" name="infoType.id" value="7"/>
  </s:if>
  <%-- 创意资讯 end --%>
  <%-- 星力视界 begin --%>
  <s:if test="tid==53">
  <input type="hidden" name="infoType.id" value="53"/>
  </s:if>
  <%-- 星力视界 end --%>
  <%-- 商讯 begin --%>
  <s:if test="tid==54">
  <input type="hidden" name="infoType.id" value="54"/>
  </s:if>
  <%-- 商讯 end --%>
  <%-- 创意资讯 begin --%>
  <s:if test="tid==8">
  <tr>
    <th>展会城市:</th> 
	<td> <s:textfield name="eventCity" id="eventCity" size="30"></s:textfield><span id="eventCityTip"></span> </td>
  </tr>
  <tr>
    <th>展会日期:</th> 
	<td><s:textfield name="eventTime" id="eventTime" size="30" cssClass="Wdate" onfocus="WdatePicker()"><s:param name="value"><s:date name="eventTime" format="yyyy-MM-dd"/></s:param> </s:textfield><span id="eventTimeTip"></span> </td>
  </tr>
  <s:if test="nextMethod=='insert'">
  <tr>
    <th>展会活动类别:</th>
	<td> <s:radio list="#{27:'报道',30:'图集',28:'国内预告',29:'国外预告'}" name="infoType.id" cssClass="infoTypeId"></s:radio> <span id="infoTypeIdTip"></span> </td>
  </tr>
  </s:if>
  </s:if>
  <%-- 创意资讯 end --%>
  <%-- begin --%>
  <s:if test="tid==10">
  <tr>
    <th>模拟世界类别:</th>
	<td> <s:radio list="#{35:'技术',36:'市场',37:'产品'}" name="infoType.id" cssClass="infoTypeId"></s:radio> <span id="infoTypeIdTip"></span> </td>
  </tr>
  </s:if>  
  <%-- end --%>
  <tr>
    <th>是否热点:</th>
	<td> <s:radio  name="hot" list="#{false:'否', true:'是'}"></s:radio> <span id="hotTip"></span> </td>
  </tr>
  <tr>
    <th>是否推荐:</th>
	<td> <s:radio  name="recommend" list="#{false:'否', true:'是'}"></s:radio> <span id="recommendTip"></span> </td>
  </tr>
  <tr id="trAddImg">
  	<th>图片:</th>
  	<td><input type="file" name="upload" id="imgFile"/><span>第一张图片为主图</span></td>
  </tr>
  <tr>
  	<th></th>
  	<td><table><tr><td id="list"></td></tr></table></td>
  </tr>
  <%-- 更新时修改图片 begin --%>
  <s:if test="nextMethod=='update'">
  <tr>
  	<th></th>
  	<td>
  		<table>
  			<s:iterator value="infoImgs">
  			<tr id="tr<s:property value='id'/>" class="img"><td align="center"><img src="<s:property value='smallImg'/>" /><br/><a id="<s:property value='id'/>" rel="delImg" href="#">删除</a></td></tr>
  			</s:iterator>
  		</table>
  	</td>
  </tr>  
  </s:if> 
  <%-- 更新时修改图片 end --%>
  
  <tr>
  	<th>meta-keywords</th>
  	<td><s:textarea name="metaKeywords" cssStyle="width:400px; height: 50px;"></s:textarea></td>
  </tr>
  <tr>
  	<th>meta-description</th>
  	<td><s:textarea name="metaDescription" cssStyle="width:400px; height: 50px;"></s:textarea></td>
  </tr>
  <tr>
  	<th>meta-title</th>
  	<td><s:textarea name="metaTitle" cssStyle="width:400px; height: 50px;"></s:textarea></td>
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
    <button class="btn" type="button" onclick="location.href='<s:url action="info-list" namespace="/admin/information/info"/>?restore_params=true'">返回</button></p>
</div>
 
 </s:form>
</body>
</html>