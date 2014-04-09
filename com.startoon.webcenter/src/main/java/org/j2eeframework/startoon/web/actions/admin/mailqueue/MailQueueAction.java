package org.j2eeframework.startoon.web.actions.admin.mailqueue;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.MailQueue;
import org.j2eeframework.startoon.service.MailQueueService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class MailQueueAction extends ServiceBaseManageAction<MailQueue,Long>
{
	private static final long serialVersionUID = -5320108955903247653L;
	@Resource
	private MailQueueService mailQueueService;
	private MailQueue mailQueue;
	@Override
	public IGenericService<MailQueue, Long> getGenericService()
	{
		return mailQueueService;
	}

	public MailQueue getModel()
	{
		return mailQueue;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			mailQueue = new MailQueue();
		} else
		{
			mailQueue = mailQueueService.getEntityById(getRequestId());
		}
	}

}
