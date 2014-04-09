package org.j2eeframework.information.web.actions.admin.information.job;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.information.entity.Jobs;
import org.j2eeframework.information.service.JobsService;


public class JobsListAction extends ServiceBasePaginationAction<Jobs, Long> {

	private static final long serialVersionUID = 6933714371516734641L;

	@Resource
	private JobsService jobsService;
	
	@Override
	public IGenericService<Jobs, Long> getGenericService()	{
		return jobsService;
	}

	@Override
	public void preExecute() {
		
	}

}
