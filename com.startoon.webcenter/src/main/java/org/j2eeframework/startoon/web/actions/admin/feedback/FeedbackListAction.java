package org.j2eeframework.startoon.web.actions.admin.feedback;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.startoon.entity.Feedback;
import org.j2eeframework.startoon.service.FeedbackService;


public class FeedbackListAction extends ServiceBasePaginationAction<Feedback, Long> {

	private static final long serialVersionUID = 1315897782990560439L;

	@Resource
	private FeedbackService feedbackService;
	
	@Override
	public IGenericService<Feedback, Long> getGenericService()	{
		return feedbackService;
	}

	@Override
	public void preExecute() {
		
	}

}
