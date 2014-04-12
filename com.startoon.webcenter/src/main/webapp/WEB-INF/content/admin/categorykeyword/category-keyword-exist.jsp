<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%

//String categoryId = request.getParameter("categoryId");
Long categoryId = (Long)request.getAttribute("categoryId");
String contextPath = request.getContextPath();
String location = contextPath + "/admin/categorykeyword/category-keyword-list.action?m=1&categoryId=" + categoryId;
response.sendRedirect(location);

%>