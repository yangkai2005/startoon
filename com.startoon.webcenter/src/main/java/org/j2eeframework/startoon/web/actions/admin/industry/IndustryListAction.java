package org.j2eeframework.startoon.web.actions.admin.industry;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.Industry;
import org.j2eeframework.startoon.service.IndustryService;

import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.commons.service.IGenericService;

public class IndustryListAction extends ServiceBasePaginationAction<Industry, Long> {

	private static final long serialVersionUID = 5151330982952438102L;

	@Resource
	private IndustryService industryService;
	
	@Override
	public IGenericService<Industry, Long> getGenericService()	{
		return industryService;
	}

	@Override
	public void preExecute() {
		
	}

}
