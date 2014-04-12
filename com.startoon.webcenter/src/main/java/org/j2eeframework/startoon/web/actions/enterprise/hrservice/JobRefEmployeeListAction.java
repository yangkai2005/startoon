package org.j2eeframework.startoon.web.actions.enterprise.hrservice;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.JobRefEmployee;
import org.j2eeframework.information.service.JobRefEmployeeService;
import org.j2eeframework.startoon.commons.SystemVariables;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.util.Struts2Utils;

public class JobRefEmployeeListAction extends ServiceBasePaginationAction<JobRefEmployee, Long> {

	private static final long serialVersionUID = -3253597777089357842L;

	@Resource
	private JobRefEmployeeService jobRefEmployeeService;

	@Override
	public IGenericService<JobRefEmployee, Long> getGenericService() {
		return jobRefEmployeeService;
	}

	@Override
	public void preExecute() {
		Enterprise enterprise = (Enterprise) Struts2Utils.getSession().getAttribute(SystemVariables.ENTERPRISE_USER);
		getPager().getParamCondition().addParameter("enterpriseId", enterprise.getId() + "");
	}

}
