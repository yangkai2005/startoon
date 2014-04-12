<#--对于不同的分页条风格可能需要重写模板与重新定义新的PaginationBean-->
<@s.set value="new org.j2eeframework.commons.pager.PaginationBean(pager)" var="paginationBean"/>

<div class="page">
	<@s.if test="pager.countOfPager>1"><#--改成如果有两页以上才显示分页条-->
		
		<@s.if test="pager.pageNo == 1">
             	  <span class="disabled">上一页</span>
    	</@s.if>
    	
  		<@s.if test="pager.pageNo != 1">
     	 	<a href="#void(0)" onclick="paginationQuery(<@s.property value="pager.pageNo-1"/>)">
     	 		上一页
     	 	</a>
   		</@s.if>
   		
   		<@s.iterator value="#paginationBean.pageNumberList">
   			<@s.if test="top == pager.pageNo">
      			<span class="current"><@s.property value="top"/></span>
 		    </@s.if>
   			<@s.if test="top != pager.pageNo && top != -1">
     			 <a href="#void(0)" onclick="paginationQuery(<@s.property value="top"/>)">
      				<@s.property value="top"/>
      			</a>
  			</@s.if>
   			<@s.if test="top == -1">
      			...
   			</@s.if>
   		</@s.iterator>
   		
   		<@s.if test="pager.pageNo == pager.countOfPager">
     	    <span class="disabled">下一页</span>
   		</@s.if>
  		<@s.if test="pager.pageNo != pager.countOfPager">
        	<a href="#void(0)" onclick="paginationQuery(<@s.property value="pager.pageNo+1"/>)" >
        		下一页
       		</a>
  		 </@s.if>
  		 跳转到 <@s.select list="pager.pageNoList" cssClass="pageInput" onchange="paginationQuery(this.value)" value="%{pager.pageNo}" ></@s.select>
  		 共<@s.property value="pager.countOfTotalItem"/>条
  		 <#--
  		 第<@s.property value="pager.pageNo"/>页/共<@s.property value="pager.countOfPager"/>页 共<@s.property value="pager.countOfTotalItem"/>条
  		 -->
   </@s.if>
<script type="text/javascript">
<#--分页查询提交js-->
function paginationQuery(pageNo)
{
	document.getElementById("__pageNoField").value = pageNo;
	document.getElementById("__QaginationQueryForm").submit();
}
</script>

<div style="display: none;">
<form  id="__QaginationQueryForm" action="<@s.property value="#request.__RequestURL"/>" method="get">
	<@s.hidden name="pager.pageNo" id="__pageNoField"/>
	<@s.iterator value="pager.paramCondition"> 
	    <#--避免pager.pageNo参数重复-->
	    <@s.if test="key != 'pager.pageNo'">
		<@s.iterator value="value"> 
			<input type="hidden" name="<@s.property value="key"/>" value="<@s.property/>"/> 
		</@s.iterator>
		</@s.if>
	</@s.iterator>
</form> 
</div>  
</div>