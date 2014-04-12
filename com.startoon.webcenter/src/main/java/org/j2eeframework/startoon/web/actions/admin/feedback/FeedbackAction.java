package org.j2eeframework.startoon.web.actions.admin.feedback;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.Feedback;
import org.j2eeframework.startoon.service.FeedbackService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class FeedbackAction extends ServiceBaseManageAction<Feedback,Long>
{
	private static final long serialVersionUID = -3853508691313040396L;
	@Resource
	private FeedbackService feedbackService;
	private Feedback feedback;
	@Override
	public IGenericService<Feedback, Long> getGenericService()
	{
		return feedbackService;
	}

	public Feedback getModel()
	{
		return feedback;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			feedback = new Feedback();
		} else
		{
			feedback = feedbackService.getEntityById(getRequestId());
		}
	}

}
