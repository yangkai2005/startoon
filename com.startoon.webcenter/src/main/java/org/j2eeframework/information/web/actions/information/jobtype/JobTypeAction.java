package org.j2eeframework.information.web.actions.information.jobtype;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.information.entity.JobType;
import org.j2eeframework.information.service.JobTypeService;

public class JobTypeAction extends ServiceBaseManageAction<JobType, Long> {
	private static final long serialVersionUID = 2840938481357196918L;
	@Resource
	private JobTypeService jobTypeService;
	private JobType jobType;

	@Override
	public IGenericService<JobType, Long> getGenericService() {
		return jobTypeService;
	}

	public JobType getModel() {
		return jobType;
	}

	public void prepare() throws Exception {
		if (getRequestId() == null || getRequestId() == 0) {
			jobType = new JobType();
		} else {
			jobType = jobTypeService.getEntityById(getRequestId());
		}
	}

}
