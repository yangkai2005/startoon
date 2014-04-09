<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.j2eeframework.information.entity.Resume"%>

<%
Resume resume = (Resume)request.getAttribute("resume");
Long id = resume.getJobs().getId();
System.err.println(">>返回的ID：" + id);
String url = request.getContextPath() + "/information/hrservice/jobs!show.action?requestId=" + id + "&flag=1";
response.sendRedirect(url);
%>