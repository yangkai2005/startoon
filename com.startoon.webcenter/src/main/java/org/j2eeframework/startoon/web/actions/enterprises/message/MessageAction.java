package org.j2eeframework.startoon.web.actions.enterprises.message;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.Message;
import org.j2eeframework.startoon.service.MessageService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class MessageAction extends ServiceBaseManageAction<Message,Long>
{
	private static final long serialVersionUID = 977506041550768573L;
	@Resource
	private MessageService messageService;
	private Message message;
	@Override
	public IGenericService<Message, Long> getGenericService()
	{
		return messageService;
	}

	public Message getModel()
	{
		return message;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			message = new Message();
		} else
		{
			message = messageService.getEntityById(getRequestId());
		}
	}

}
