package org.j2eeframework.information.web.actions.information.hrservice.resume;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.information.entity.Resume;
import org.j2eeframework.information.service.ResumeService;


public class ResumeListAction extends ServiceBasePaginationAction<Resume, Long> {

	private static final long serialVersionUID = -7399383829190857263L;

	@Resource
	private ResumeService resumeService;
	
	@Override
	public IGenericService<Resume, Long> getGenericService()	{
		return resumeService;
	}

	@Override
	public void preExecute() {
		
	}

}
