<#--对于不同的分页条风格可能需要重写模板与重新定义新的PaginationBean-->
<@s.set value="new org.j2eeframework.commons.pager.PaginationBean(pager)" var="paginationBean"/>

<div class="PageLine">
	<@s.if test="pager.countOfPager>1"><#--改成如果有两页以上才显示分页条-->
	<div class="page">
		
		<@s.if test="pager.pageNo == 1">
             	  <span class="disabled"> &lt;</span>
    	</@s.if>
  		<@s.if test="pager.pageNo != 1">
     	 	<a href="#void(0)" onclick="paginationQuery(<@s.property value="pager.pageNo-1"/>,<@s.property value="pager.pageSize"/>)">
     	 		&lt;
     	 	</a>
   		</@s.if>
   		
   		
   		<@s.iterator value="#paginationBean.pageNumberList">
   			<@s.if test="top == pager.pageNo">
      			<span class="current"><@s.property value="top"/></span>
 		    </@s.if>
   			<@s.if test="top != pager.pageNo && top != -1">
     			 <a href="#void(0)" onclick="paginationQuery(<@s.property value="top"/>,<@s.property value="pager.pageSize"/>)" lang="<@s.property value="pager.pageSize"/>" rel="pager">
      				<@s.property value="top"/>
      			</a>
  			</@s.if>
   			<@s.if test="top == -1">
      			...
   			</@s.if>
   		</@s.iterator>
   		
   		<@s.if test="pager.pageNo == pager.countOfPager">
     	    <span class="disabled">  &gt;</span>
   		</@s.if>
  		<@s.if test="pager.pageNo != pager.countOfPager">
        	<a href="#void(0)" onclick="paginationQuery(<@s.property value="pager.pageNo+1"/>,<@s.property value="pager.pageSize"/>)" >
        		&gt;
       		</a>
  		 </@s.if>
   
<script type="text/javascript">
<#--分页查询提交js-->
function paginationQuery(pageNo,pageSize)
{
	//document.getElementById("__pageNoField").value = pageNo;
	//document.getElementById("__QaginationQueryForm").submit();
	ajaxPagination(pageNo,pageSize); 
}
</script>
</div>
</@s.if>
<div style="display: none;">
<form  id="__QaginationQueryForm" action="<@s.property value="#request.__RequestURL"/>" method="post">
	<@s.hidden name="pager.pageNo" id="__pageNoField"/>
	<@s.iterator value="pager.paramCondition"> 
	    <#--避免pager.pageNo参数重复-->
		<@s.iterator value="value"> 
	    <@s.if test="key != 'pager.pageNo'">
			<input type="hidden" name="<@s.property value="key"/>" value="<@s.property/>"/> 
		</@s.if>
		</@s.iterator>
	</@s.iterator>
</form> 
</div>  
</div>
