package org.j2eeframework.information.web.actions.admin.information.hrenterprise;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.HrEnterprise;
import org.j2eeframework.information.service.HrEnterpriseService;

public class HrEnterpriseListAction extends ServiceBasePaginationAction<HrEnterprise, Long> {

	private static final long serialVersionUID = -1972732591660969315L;

	@Resource
	private HrEnterpriseService hrEnterpriseService;

	@Override
	public IGenericService<HrEnterprise, Long> getGenericService() {
		return hrEnterpriseService;
	}

	@Override
	public void preExecute() {
		getPager().getParamCondition().addParameter("type", "-1");
	}

}
