package org.j2eeframework.startoon.web.actions.enterprise.enterprise;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EnterpriseService;

import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.commons.service.IGenericService;

public class EnterpriseListAction extends ServiceBasePaginationAction<Enterprise, Long> {

	private static final long serialVersionUID = -5197117148129092111L;

	@Resource
	private EnterpriseService enterpriseService;
	
	@Override
	public IGenericService<Enterprise, Long> getGenericService()	{
		return enterpriseService;
	}

	@Override
	public void preExecute() {
		
	}

}
