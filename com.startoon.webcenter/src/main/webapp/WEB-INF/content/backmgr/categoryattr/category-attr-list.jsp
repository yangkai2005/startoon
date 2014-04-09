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
<link href="${ctx}/resources/css/admin.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/resources/js/jquery.js" type="text/javascript"></script>
<script type="text/javascript"> 
$(document).ready(function(){
 	var msg = "${msg}";
 	if(msg=="fail"){
 	 	alert("该属性已经在产品中引用，不能删除!");
 	}
});
function confirmDel(id)
{
	if(confirm("删除记录后，数据将不可恢复！\n确认继续删除？"))
	{
		var url = "${pageContext.request.contextPath}/backmgr/categoryattr/category-attr!deletecheck.action";
		var html = $.ajax({ 
			  url: url, 
			  type:"POST",
			  data:"requestId="+id,
			  async: false 
			}).responseText; 

		if(html==1){
			alert("该自定义属性已经被引用，不可删除!");
		}else{
			return true;
		}
	}
	return false;
}
function chg(id_num){
    var oa = document.getElementById(id_num);
    var ob = document.getElementById("ImgArrow");
	 var imgButton = document.getElementById("imgButton");
    if(oa.style.display == "block"){
            oa.style.display = "none";
            imgButton.src = "${ctx}/resources/images/icon_down.gif";
			 imgButton.alt = "展开搜索";
    }else{
            oa.style.display = "block";
            imgButton.src = "${ctx}/resources/images/icon_up.gif";
			 imgButton.alt = "隐藏搜索";
    }
    return false;
}
</script>
</head>
<body>
<div class="mTitle">
  <b class="bbig">类别属性列表</b>
</div>
 
<!--list -->
<div class="mainList">
<table class="listTable">
  <tr>
  <td>类别名称：${cname }</td>
  <td>父类别：${category.category.name }</td>
  <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
  	<th>属性名</th>
	<th>属性值</th>
	<th>输入类型</th>
    <th>操作</th>
  </tr>
  <s:iterator value="pager.items">
  <tr>  
  	<td> 
  	  <s:property value="attrName"/>
  	</td>
  	<td> 
  	<s:property value="attrValue"/> 
  	</td>
  	<td> 
  	<s:if test="attrInput==1">
  		选择型
  	</s:if> 
  	<s:else>
  		手工输入
  	</s:else>
  	</td>
    <td> 
    	<a href="<s:url action="category!infoattr" namespace="/backmgr/category"/>?aid=<s:property value="id"/>&cid=<s:property value="cid"/>">修改</a>
    	
    	<a onclick="return confirmDel(<s:property value="id"/>);" href="<s:url action="category-attr!delete" namespace="/backmgr/categoryattr"/>?requestId=<s:property value="id"/>">删除</a>
    	
   </td>
  </tr>
  </s:iterator>
</table>
</div>
<!--end list -->
<div class="Toolbar">
 <div class="toolBt">
 		<a href="<s:url action="category!inputattr" namespace="/backmgr/category"/>?cid=${cid}" title="添加属性"><span class="btn">添加属性</span></a>
 		<button class="btn" type="button" onclick="location.href='<s:url action="category-list" namespace="/admin/category"/>?restore_params=true'">返回</button> 
  </div>
  <e:pagination></e:pagination>
</div>
 
</body>
</html>

