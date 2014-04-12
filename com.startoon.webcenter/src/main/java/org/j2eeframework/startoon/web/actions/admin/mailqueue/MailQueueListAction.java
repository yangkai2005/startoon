package org.j2eeframework.startoon.web.actions.admin.mailqueue;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.startoon.entity.MailQueue;
import org.j2eeframework.startoon.service.MailQueueService;


public class MailQueueListAction extends ServiceBasePaginationAction<MailQueue, Long> {

	private static final long serialVersionUID = -457306404484931079L;

	@Resource
	private MailQueueService mailQueueService;
	
	@Override
	public IGenericService<MailQueue, Long> getGenericService()	{
		return mailQueueService;
	}

	@Override
	public void preExecute() {
		
	}

}
