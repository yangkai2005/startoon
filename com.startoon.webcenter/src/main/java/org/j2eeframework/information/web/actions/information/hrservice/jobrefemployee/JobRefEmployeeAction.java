package org.j2eeframework.information.web.actions.information.hrservice.jobrefemployee;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.JobRefEmployee;
import org.j2eeframework.information.service.JobRefEmployeeService;

public class JobRefEmployeeAction extends ServiceBaseManageAction<JobRefEmployee, Long> {
	private static final long serialVersionUID = 1754016618440551172L;
	@Resource
	private JobRefEmployeeService jobRefEmployeeService;
	private JobRefEmployee jobRefEmployee;

	@Override
	public IGenericService<JobRefEmployee, Long> getGenericService() {
		return jobRefEmployeeService;
	}

	public JobRefEmployee getModel() {
		return jobRefEmployee;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			jobRefEmployee = new JobRefEmployee();
		} else {
			jobRefEmployee = jobRefEmployeeService.getEntityById(getRequestId());
		}
	}

}
