package org.j2eeframework.startoon.web.actions.admin.enterprise;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.service.EnterpriseService;

public class EnterpriseListPopAction extends ServiceBasePaginationAction<Enterprise, Long> {

	private static final long serialVersionUID = -4734836206552732907L;

	@Resource
	private EnterpriseService enterpriseService;

	@Override
	public IGenericService<Enterprise, Long> getGenericService() {
		return enterpriseService;
	}

	@Override
	public void preExecute() {
		getPager().getParamCondition().addParameter("userType", "-1");
		getPager().setPageSize(15);
	}

}
