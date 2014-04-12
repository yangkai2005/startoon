<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
Long id = (Long) request.getAttribute("jobId");
String url = request.getContextPath() + "/information/hrservice/jobs!show.action?requestId=" + id + "&flag=1";
response.sendRedirect(url);
%>