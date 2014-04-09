package org.j2eeframework.information.web.actions.admin.information.subject;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.information.entity.Subject;
import org.j2eeframework.information.service.SubjectService;


public class SubjectListAction extends ServiceBasePaginationAction<Subject, Long> {

	private static final long serialVersionUID = 6760048542468666245L;

	@Resource
	private SubjectService subjectService;
	
	@Override
	public IGenericService<Subject, Long> getGenericService()	{
		return subjectService;
	}

	@Override
	public void preExecute() {
		
	}

}
