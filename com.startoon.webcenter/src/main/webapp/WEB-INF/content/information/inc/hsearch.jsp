<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- search start --%>
<!-- search -->
<div class="search">
	<div class="search_one">
		<s:form namespace="/information/search" action="info-list">
		<input name="q" type="text" class="txtsearch" /><input type="submit" value="" class="btn_search" />
		</s:form>	
	</div>
	
    <div class="search_two">
    	<ul class="zxselect">
        	<li onmouseover="setTab('ser',1,1)" id="ser1" onmouseout="setTabout('ser',1)">资讯
            	<div id="con_ser_1" class="hidden">
                	<div class="serbox">
                    	<ul>
                        	<li><a href="#">资讯资讯</a></li>
                            <li><a href="#">资讯</a></li>
                            <li><a href="#">资讯资讯</a></li>
                            <li><a href="#">资讯</a></li>
                        </ul>
                    
                    </div>
                
                </div>
            	
            </li>
        </ul>
    </div>
    
    <div class="search_three"><a href="${ctx}/index.action" target="_blank"><img src="${ctx}/information/images/b2b.jpg" width="339" height="45" /></a></div>

</div>
<%-- search end --%>
