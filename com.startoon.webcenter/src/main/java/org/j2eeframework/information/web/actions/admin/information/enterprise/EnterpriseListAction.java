package org.j2eeframework.information.web.actions.admin.information.enterprise;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EnterpriseService;


public class EnterpriseListAction extends ServiceBasePaginationAction<Enterprise, Long> {

	private static final long serialVersionUID = -4734836206552732907L;

	@Resource
	private EnterpriseService enterpriseService;
	
	@Override
	public IGenericService<Enterprise, Long> getGenericService()	{
		return enterpriseService;
	}

	@Override
	public void preExecute() {
		getPager().setPageSize(10);
	}

}
