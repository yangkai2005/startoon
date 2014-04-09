<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>信息接收者选择</title>

<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/admin.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/validator.css"/>
<script type="text/javascript" src="${ctx}/resources/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/common.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/formValidator.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/formValidatorRegex.js"></script>

<script type="text/javascript"> 
$(document).ready(function(){
 	$.formValidator.initConfig({formid:"form1",onerror:function(msg){alert(msg);},onsuccess:function(){return true;}});
 	
 	$("#title").formValidator({onshow:"请输入系统消息的标题",onfocus:"系统消息标题不能为空",oncorrect:"输入正确"}).inputValidator({min:1,max:255,onerror:"系统消息标题不能为空"});
 	$("#content").formValidator({onshow:"请输入要发送信息的内容",onfocus:"消息内容不能为空",oncorrect:"输入正确"}).inputValidator({min:1,max:2048,onerror:"消息内容不能为空"});

 	$("#btnsubmit").click(function () {
		var ename = document.getElementById("ename");
		var title = document.getElementById("title");
		var content = document.getElementById("content");
	 	if(ename.options.length==0){
			alert("请至少选择一个企业会员!");
			return false;
	 	}
	 	
	 	if(title.value==""){
	 		alert("系统消息标题不能为空!");
	 		title.focus();
			return false;
	 	}
	 	if(content.value==""){
	 		alert("消息内容不能为空!");
	 		content.focus();
			return false;
	 	}
	 	
	 	$("#btnsubmit").submit();
	});

	$("#all").click(function() {
		getUser(0);
	});
	$("#ent").click(function() {
		getUser(1);
	});
	$("#per").click(function() {
		getUser(2);
	});

});

function getUser(flag) {
	var url = "${pageContext.request.contextPath}/admin/enterprise/enterprise!getUser.action?r=" + Math.random();
	$.getJSON(url, {flag:flag}, function(users){
		var ids = new Array();
		var names = new Array();
		var options = "";
		$.each(users, function(i, user) {
			ids.push(user.uid);
			names.push(user.name);
			options += "<option value='" + user.uid + "'>" + user.name + "</option>";
		});
		$("#ename").html(options);
		$("#ids").val(ids.toString());
		$("#idandname").val(names.toString());
	}); 
}

function popupwin(){
	var url = "${pageContext.request.contextPath}/admin/enterprise/enterprise-list-pop.action?t="+new Date().getTime();
	var param = "dialogWidth=700px;dialogHeight=580px;status=no;help:no"; //initBusiForgt
	var idandname = document.getElementById("idandname");				
	var returnvalue = window.showModalDialog(url,idandname,param);
	if(returnvalue!="" && typeof(returnvalue) !="undefined"){
		var receiveId = document.getElementById("ids");
		var receiveName = document.getElementById("ename");
		var idandname = returnvalue.split("@@@");
		idandname = idandname.unique();
		receiveName.options.length=0; 
		for(var i=0;i<idandname.length;i++){
			if(idandname[i]!=""){
				var arr = idandname[i].split("###");
				var opt = new Option(arr[1],arr[0]);
				if(arr[1]!=''){
					receiveName.options.add(opt);
				}
				if(receiveId.value != ""){
					receiveId.value = receiveId.value + "," + arr[0];
				}else{
					receiveId.value = arr[0];
				}
			}
		}
	}else{
		receiveName.options.length=0; 
	}
}

function cls(){
	var idandname = document.getElementById("idandname");
	var receiveName = document.getElementById("ename");
	receiveName.options.length = 0;
	idandname.value = "";
	

}
</script>

</head>

<body>
<div class="mTitle">
  <b class="bbig">发送系统消息</b>
</div>
<s:form id="form1" action="%{actionName+'!'+nextMethod}" namespace="/admin/message">
<s:hidden name="nextMethod" />
<s:hidden name="requestId" />
<s:hidden name="id" />
<!--list -->
<div class="mainAdd">
<table class="addTable">
 <tr id="selecttr">
    <th>请选择:</th>
	<td valign="top">
		<table>
			<tr>
				<td><select name="ename" id="ename" multiple="multiple" style="height:150px;width:400px;"></select></td>
				<td>
					<input type="button" name="btnsel" id="btnsel" value="选择会员" onclick="popupwin()"/><br/>
					<input type="button" name="btnsel" id="all" value="所有会员"/><br/>
					<input type="button" name="btnsel" id="ent" value="企业会员"/><br/>
					<input type="button" name="btnsel" id="per" value="个人会员"/><br/>
					<input type="button" name="btnsel" id="clear" value="清空会员" onclick="cls();"/>
				</td>
			</tr>
		</table>
		
		<input type="hidden" name="ids" id="ids"/>
		<input type="hidden" name="idandname" id="idandname"/>
	 </td>
  </tr>
  <tr>
    <th>标题:</th>
	<td> <s:textfield name="title" id="title" size="75"></s:textfield><span id="titleTip"></span> </td>
  </tr>
  <tr>
    <th>信息内容:</th> 
	<td> <s:textarea name="content" id="content"></s:textarea> <span id="contentTip"></span> </td>
  </tr>
</table>
</div>
<!--end list -->
<div class="addToolbar">
    <p><button class="btn" id="btnsubmit" type="submit"><b>确定</b></button>
    <button class="btn" type="button" onclick="location.href='<s:url action="message-list" namespace="/admin/message"/>?restore_params=true'">返回</button></p>
</div>
 
 </s:form>
</body>
</html>