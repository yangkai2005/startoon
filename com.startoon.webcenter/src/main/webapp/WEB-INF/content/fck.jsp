<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>

<script type="text/javascript" src="${ctx}/fckeditor/fckeditor.js"></script>

<FCK:editor instanceName="description" height="350" toolbarSet="B2B" basePath="/fckeditor"></FCK:editor>


<script type="text/javascript">
var oEditor = FCKeditorAPI.GetInstance('content') ;
</script>

<textarea id="content"></textarea>