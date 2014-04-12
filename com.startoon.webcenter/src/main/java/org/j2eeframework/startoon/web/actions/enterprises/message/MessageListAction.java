package org.j2eeframework.startoon.web.actions.enterprises.message;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.Message;
import org.j2eeframework.startoon.service.MessageService;

import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.commons.service.IGenericService;

public class MessageListAction extends ServiceBasePaginationAction<Message, Long> {

	private static final long serialVersionUID = -3745957166913122390L;

	@Resource
	private MessageService messageService;
	
	@Override
	public IGenericService<Message, Long> getGenericService()	{
		return messageService;
	}

	@Override
	public void preExecute() {
		
	}

}
