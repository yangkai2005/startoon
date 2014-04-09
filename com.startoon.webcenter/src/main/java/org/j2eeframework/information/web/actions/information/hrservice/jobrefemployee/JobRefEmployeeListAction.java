package org.j2eeframework.information.web.actions.information.hrservice.jobrefemployee;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.information.entity.JobRefEmployee;
import org.j2eeframework.information.service.JobRefEmployeeService;


public class JobRefEmployeeListAction extends ServiceBasePaginationAction<JobRefEmployee, Long> {

	private static final long serialVersionUID = -6389905844913446592L;

	@Resource
	private JobRefEmployeeService jobRefEmployeeService;
	
	@Override
	public IGenericService<JobRefEmployee, Long> getGenericService()	{
		return jobRefEmployeeService;
	}

	@Override
	public void preExecute() {
		
	}

}
