package org.j2eeframework.information.web.actions.admin.information.jobtype;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.JobType;
import org.j2eeframework.information.service.JobTypeService;

public class JobTypeListAction extends ServiceBasePaginationAction<JobType, Long> {

	private static final long serialVersionUID = -3360343791927730737L;

	@Resource
	private JobTypeService jobTypeService;

	@Override
	public IGenericService<JobType, Long> getGenericService() {
		return jobTypeService;
	}

	@Override
	public void preExecute() {

	}

}
