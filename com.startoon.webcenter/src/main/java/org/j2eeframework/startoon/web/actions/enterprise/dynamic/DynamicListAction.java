package org.j2eeframework.startoon.web.actions.enterprise.dynamic;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Dynamic;
import org.j2eeframework.startoon.service.DynamicService;

public class DynamicListAction extends ServiceBasePaginationAction<Dynamic, Long> {

	private static final long serialVersionUID = 2120390478395087707L;

	@Resource
	private DynamicService dynamicService;
	
	@Override
	public IGenericService<Dynamic, Long> getGenericService()	{
		return dynamicService;
	}

	@Override
	public void preExecute() {
		Long creatorId = SysContext.getCurrentEnterpriserUser().getId();
		getPager().getParamCondition().addParameter("enterpriseId", creatorId + "");
	}

}
