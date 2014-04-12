package org.j2eeframework.startoon.web.actions.enterprise.hrservice;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Jobs;
import org.j2eeframework.information.service.JobsService;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Enterprise;

public class JobsListAction extends ServiceBasePaginationAction<Jobs, Long> {

	private static final long serialVersionUID = 1685769491821810773L;

	@Resource
	private JobsService jobsService;

	@Override
	public IGenericService<Jobs, Long> getGenericService() {
		return jobsService;
	}

	@Override
	public void preExecute() {
		Enterprise user = SysContext.getCurrentEnterpriserUser();
		getPager().getParamCondition().addParameter("enterpriseId", user.getId() + "");
		
	}

}
