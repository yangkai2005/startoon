<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="e" uri="/jeeframework"%>
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
<link href="${ctx}/css/purchaseCenter.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${ctx}/js/nav.js"></script>
<script type="text/javascript" src="${ctx}/js/dialog.js"></script>
<script language="javascript1.1" type="text/javascript" src="${ctx}/js/jquery-1.4.2.js"></script>

<link href="${ctx}/resources/css/validator.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctx}/resources/js/formValidator.js" type="text/javascript"></script>
<script language="JavaScript" src="${ctx}/resources/js/formValidatorRegex.js" type="text/javascript"></script>

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

	$("h2#add").addClass("q3");
	
 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg);},onsuccess:function(){return true;}});
 	

 	$("#form1").submit(function(){
 	 	var fCKeditorContent = FCKeditorAPI.GetInstance("content").GetXHTML();//FCKeditor1是FCkeditor的ID
 	 	var txt = $('<div>' + fCKeditorContent + '</div>').text();
 	 	$(':hidden[name=contentTxt]').val(txt);
 	 });
	 
	//绑定上传插件
	
	$("#imgFile").MultiFile({
		  max: 30,
		  accept: 'gif|jpg',
		  list:'#imglist',
		  STRING: {
			   remove: '删除',
				denied:'不能选择扩展名为$ext的文件.\n请重新选择...',
				file:'$file',
				duplicate:'图片$file已经选择了，请选择其他图片'				   
			  },
		  afterFileSelect:function(element, value, master_element){
		  	var fileName = value.replace(/^.+?\\([^\\]+?)(\.[^\.\\]*?)?$/gi,"$1");
		  	var txt = "<span id='"+fileName+"' style='display:none;'><textarea rows='3' cols='90' name='description'></textarea></span>";
		  	$("#imglist").append(txt);

		  	$('textarea[name=description]').example('请输入图片描述内容...');
		  },
		  onFileRemove: function(element, value, master_element){
			  $("#"+value.replace(/^.+?\\([^\\]+?)(\.[^\.\\]*?)?$/gi,"$1"),$("#imglist")).remove();
		  }
	});


});

</script>
</head>

<body>

<%-- header --%>
<s:include value="/WEB-INF/content/inc/header.jsp"></s:include>
<%-- header --%>
  
<%-- main begin --%>
<div class="main">

<div class="member">

<%-- main left begin --%>
<s:include value="/WEB-INF/content/inc/person-left.jsp"/>
<%-- main left end --%>

<%-- main right begin --%>
<div class="memcon">

	<s:include value="/WEB-INF/content/member/show/menu.jsp"/>
	

	<div class="memcon">
	
	   <div class="maink2">
		<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/member/show" enctype="multipart/form-data">
		<s:hidden name="nextMethod" />
		<s:hidden name="requestId" />
		<s:hidden name="id" />
		<s:hidden name="tid" />
		<s:hidden name="isImgInfo" value="true"/>
		<s:hidden name="contentTxt" id="contentText"/>		
		
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="paddk">
		  <tbody>
		  <tr>
		    <td class="pktdl1">创意show作品类型：<span class="red">&nbsp;</span></td>
		    <td class="pktdr1"><s:radio list="#{24:'个人', 23:'团体',  26:'动画'}" name="infoType.id" id="infoTypeId"></s:radio></td>
		  </tr>
		  <tr>
		    <td class="pktdl1">创意show标题：<span class="red">&nbsp;</span></td>
		    <td class="pktdr1"><s:textfield name="title" id="title" cssClass="input6"></s:textfield><span id="titleTip"></span></td>
		  </tr>
		  
		  <tr>
		    <td class="pktdl1">上传图片：<span class="red">&nbsp;</span></td>
		    <td class="pktdr1">
		    <table width="100%" border="0" cellspacing="0" cellpadding="0">
		      <tbody>
		      <tr>
		        <td style="valign:top;">
		        <div style="float:left; width:100%; margin:5px 0">
				<div class="bp3" style="width:94%"> <img src="${ctx}/images/dan.jpg" style="vertical-align:middle"/>可以添加多张图片，第一张图片为创意show的主题图片</div>
				</div>
				</td>
		        <td></td>
		      </tr>
		      <tr>
		        <td style="valign:top;"><input type="file" name="upload" id="imgFile"/></td>
		        <td></td>
		      </tr>
			  <tr>
			  	<td><table><tr><td id="imglist"></td></tr></table></td>
			  	<td></td>
			  </tr>	      
		    </tbody>
		    </table>
		    </td>
		  </tr>
		  
		  <tr>
		    <td valign="top" class="pktdl1">内容详细：<span class="red">*</span></td>
		    <td class="pktdr1">
		    	<FCK:editor inputName="content" instanceName="content" height="350" toolbarSet="B2BCfg">
						<jsp:attribute name="value">
							${info.content }
						</jsp:attribute>
				</FCK:editor>    
			</td>
		  </tr>
		  <tr>
		    <td class="pktdl2">&nbsp;</td>
		    <td class="pktdr2">
				<input id="sBtn" name="sBtn" type="submit" value="确定" class="btn01"/>
				<input type="button" name="preview" value="取消" class="btn02" onclick="history.back()"/>
		    </td>
		  </tr>
		</tbody>
		</table>
		</s:form>
	   </div>
	  </div>
		
	</div>
<%-- main right end --%>

</div>

<div class="cls"></div>
<div class="cls"></div>

</div>
<%-- main end --%>
  
<%-- footer --%>
<s:include value="/WEB-INF/content/inc/footer.jsp"/>
<%-- footer --%>
	
</body>
</html>